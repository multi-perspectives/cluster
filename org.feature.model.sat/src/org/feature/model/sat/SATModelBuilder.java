package org.feature.model.sat;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.emftext.term.propositional.expression.And;
import org.emftext.term.propositional.expression.BinaryOperator;
import org.emftext.term.propositional.expression.FeatureRef;
import org.emftext.term.propositional.expression.Nested;
import org.emftext.term.propositional.expression.Not;
import org.emftext.term.propositional.expression.Or;
import org.emftext.term.propositional.expression.Term;
import org.emftext.term.propositional.expression.UnaryOperator;
import org.feature.model.sat.exception.BuilderException;
import org.feature.model.sat.exception.UnknownStatementException;
import org.feature.model.sat.model.slicing.BoundedType;
import org.featuremapper.models.feature.Feature;
import org.featuremapper.models.feature.FeatureModel;
import org.featuremapper.models.feature.Group;
import org.sat4j.core.VecInt;
import org.sat4j.specs.ContradictionException;
import org.sat4j.specs.ISolver;
import org.sat4j.tools.GateTranslator;

public class SATModelBuilder {

	private int varCounter;

	private static Logger logger = Logger.getLogger(SATModelBuilder.class);

	/**
	 * association of feature identifier to Integer
	 */
	private Map<Feature, Integer> featureToId = new HashMap<Feature, Integer>();

	/**
	 * association of integer to feature identifier
	 */
	private Map<Integer, Feature> idToFeature = new HashMap<Integer, Feature>();

	/**
	 * used sat solver
	 */
	private GateTranslator solver;

	public SATModelBuilder(ISolver solver) {
		varCounter = 1;
		featureToId = new HashMap<Feature, Integer>();
		idToFeature = new HashMap<Integer, Feature>();

		this.solver = new GateTranslator(solver);
	}

	public void setGateTranslator(GateTranslator gt) {
		solver = gt;
	}

	public GateTranslator getModel() {
		return solver;
	}

	/**
	 * Transform a cardinality-based feature model into a constraint model.
	 * 
	 * @param featuremodel
	 */
	public GateTranslator buildSATModel(FeatureModel featuremodel) {
		Feature rootFeature = featuremodel.getRoot();

		addMapping(rootFeature);
		buildRootFeature(rootFeature);
		try {
			transformFeature(rootFeature);
		} catch (BuilderException | ContradictionException e1) {
			logger.error("Cannot build constraint model for SAT4J");
			e1.printStackTrace();
		}

		try {
			transformRemainingCTConstraints(featuremodel);
		} catch (ContradictionException e) {
			logger.error("Cannot build constraint model for SAT4J");
			e.printStackTrace();
		}

		return solver;
	}

	private void transformFeature(Feature feature) throws BuilderException,
			ContradictionException {

		// Handle rest of the features
		EList<Group> groups = feature.getGroups();
		for (Group group : groups) {
			transformGroup(group);
		}

	}

	private void transformGroup(Group group) throws BuilderException,
			ContradictionException {
		try {
			createGroupConstraint(group);
			EList<Feature> childFeatures = group.getChildFeatures();
			for (Feature feature : childFeatures) {
				transformFeature(feature);
			}
		} catch (UnknownStatementException e) {
			logger.error("Group constraint could not be added - group constraint discarded");
		}
		
	}

	// TODO: Does not work correctly! Fix it!
	private void transformRemainingCTConstraints(FeatureModel model)
			throws ContradictionException {

		VecInt v = new VecInt();
		List<Term> terms = TextExpressionParser.parseExpressions(model);
		for (Term term : terms) {
			// Add resulting (new) variable to the solver model and bind it to
			// true

			try {
				v.push(checkTerm(term));
			} catch (UnknownStatementException e) {
				logger.error("Not all features in the constraint could be resolved - Cross Tree Constraint dicarded");
			}
		}
		try {
			v.push(getMapping(model.getRoot()));
		} catch (UnknownStatementException e) {
			logger.error("Cross Tree Constraints could not be added to the feature model");
		}
		solver.addClause(v);
	}

	private int checkTerm(Term term) throws ContradictionException, UnknownStatementException {

		int result = 0;

		if (term instanceof BinaryOperator) {
			BinaryOperator binTerm = (BinaryOperator) term;
			Term leftTerm = binTerm.getOperand1();
			int leftConstraint = checkTerm(leftTerm);
			Term rightTerm = binTerm.getOperand2();
			int rightConstraint = checkTerm(rightTerm);

			if (term instanceof Or) {
				int[] values = { leftConstraint, rightConstraint };
				// create a new variable that expresses the or relation
				solver.or(varCounter++, new VecInt(values));
				result = varCounter;
			} else if (term instanceof And) {
				int[] values = { leftConstraint, rightConstraint };
				// create a new variable that expresses the and relation
				solver.and(varCounter++, new VecInt(values));
				result = varCounter;
			}
		} else if (term instanceof UnaryOperator) {
			UnaryOperator unaryTerm = (UnaryOperator) term;
			Term singleTerm = unaryTerm.getOperand();
			int singleConstraint = checkTerm(singleTerm);
			// give back the internal feature variable, either negated or not
			if (term instanceof Not) {
				result = -(singleConstraint);
			} else if (term instanceof Nested) {
				result = singleConstraint;
			}
		} else if (term instanceof FeatureRef) {
			FeatureRef featureRefTerm = (FeatureRef) term;
			Feature feature = featureRefTerm.getFeature();
			if (feature.eIsProxy()) {
				URI proxyURI = ((org.eclipse.emf.ecore.InternalEObject) feature)
						.eProxyURI();
				String uriFragment = proxyURI.fragment();
				logger.warn("Proxy found! UriFragment of proxy is: "
						+ uriFragment);
			}
			result = getMapping(feature);
		}

		return result;
	}

	private void createGroupConstraint(Group group) throws BuilderException,
			ContradictionException, UnknownStatementException {

		addGroupMapping(group);

		// Optional: o..n
		if (group.getMaxCardinality() >= group.getChildFeatures().size()
				&& group.getMinCardinality() == 0) {
			buildOptionalChildren(group.getParentFeature(),
					group.getChildFeatures());

		}
		// Mandatory: n..n
		else if (group.getMaxCardinality() == group.getChildFeatures().size()
				&& group.getMinCardinality() == group.getChildFeatures().size()) {
			buildMandatoryChildren(group.getParentFeature(),
					group.getChildFeatures());

		}
		// Alternative: x..x; x>0; x<n
		else if (group.getMaxCardinality() == group.getMinCardinality()
				&& group.getMaxCardinality() >= 1
				&& group.getMaxCardinality() <= group.getChildFeatures().size()
				&& group.getChildFeatures().size() >= 1) {
			buildAlternativeChildren(group.getParentFeature(),
					group.getChildFeatures());

		}
		// Or: 1..n
		else if (group.getMinCardinality() > 0
				&& group.getMaxCardinality() != group.getMinCardinality()
				&& group.getMaxCardinality() <= group.getChildFeatures().size()) {
			buildOrChildren(group.getParentFeature(), group.getChildFeatures());

		} else
			throw new BuilderException(
					"Unkown combination of feature cardinalities");

		// for (Feature f : group.getChildFeatures()) {
		// buildParent(f, group.getParentFeature());
		// }
	}

	// private void buildParent(Feature childFeature, Feature parentIdentifier)
	// throws BuilderException {
	// int[] clause = { -getMapping(childFeature),
	// getMapping(parentIdentifier) };
	// logger.debug("add parent clause  '{" + childFeature + "}' -> '{"
	// + parentIdentifier + "}'");
	// buildClause(clause);
	// }

	private void buildAlternativeChildren(Feature featureIdentifier,
			List<Feature> alternativeIdentifiers) throws BuilderException,
			ContradictionException, UnknownStatementException {
		int[] clause = new int[alternativeIdentifiers.size()];

		for (int i = 0; i < alternativeIdentifiers.size(); i++) {
			clause[i] = getMapping(alternativeIdentifiers.get(i));
		}
		// clause[alternativeIdentifiers.size()] =
		// -getMapping(featureIdentifier);
		logger.debug("add alternative clause '{" + featureIdentifier
				+ "}' -> '{" + alternativeIdentifiers + "}'");

		buildXOrClause(clause);

		// Add Imply constraint to parent feature
		solver.halfOr(getMapping(featureIdentifier), new VecInt(clause));
	}

	private void buildOptionalChildren(Feature featureIdentifier,
			List<Feature> optionalIdentifiers) throws BuilderException,
			ContradictionException, UnknownStatementException {
		logger.debug("build optional, nothing to do");

		int[] clause = new int[optionalIdentifiers.size()];

		for (int i = 0; i < optionalIdentifiers.size(); i++) {
			clause[i] = getMapping(optionalIdentifiers.get(i));
		}

		// Add Imply constraint to parent feature
		solver.halfOr(getMapping(featureIdentifier), new VecInt(clause));
	}

	private void buildMandatoryChildren(Feature featureIdentifier,
			List<Feature> mandatoryIdentifiers) throws BuilderException,
			ContradictionException, UnknownStatementException {

		VecInt mandatory = new VecInt();

		for (Feature f : mandatoryIdentifiers) {
			// int[] clause = { feature, getMapping(mandatory) };
			mandatory.push(getMapping(f));
			logger.debug("add mandatory clause '{" + featureIdentifier
					+ "}' <-> '{" + f + "}'");
			// buildClause(clause);
		}

		// add mandatory features for parent feature
		solver.and(getMapping(featureIdentifier), mandatory);

		// Add Imply constraint to parent feature
		// --> not necessary since constraint logical equality is specified
	}

	private void buildOrChildren(Feature featureIdentifier,
			List<Feature> orIdentifiers) throws BuilderException,
			ContradictionException, UnknownStatementException {
		int[] clause = new int[orIdentifiers.size()];

		for (int i = 0; i < orIdentifiers.size(); i++) {
			clause[i] = getMapping(orIdentifiers.get(i));
		}
		// clause[orIdentifiers.size()] = -getMapping(featureIdentifier);
		logger.debug("add or clause '{" + featureIdentifier + "}' -> '{"
				+ orIdentifiers + "}'");
		buildOrClause(clause);

		// Add Imply constraint to parent feature
		solver.halfOr(getMapping(featureIdentifier), new VecInt(clause));
	}

	// TODO: Integrate accordingly when three valued logic is integrated
//	private void buildVariabilityType(Feature featureIdentifier,
//			BoundedType type) throws BuilderException {
//		switch (type) {
//		case ALIVE:
//			int[] clause1 = { getMapping(featureIdentifier) };
//			logger.debug("add static clause '{" + featureIdentifier + "}'");
//			buildClause(clause1);
//			break;
//		case DEAD:
//			int[] clause2 = { -getMapping(featureIdentifier) };
//			logger.debug("add dead clause 'not {" + featureIdentifier + "}'");
//			buildClause(clause2);
//			break;
//		default:
//			logger.debug("feature type ignored");
//			break;
//		}
//	}

	private void buildRootFeature(Feature rootIdentifier)
			throws BuilderException {
		try {
			int[] clause = { getMapping(rootIdentifier) };
			logger.debug("add root clause '{" + rootIdentifier + "}'");
			buildClause(clause);
		} catch (UnknownStatementException e) {
			logger.error("Root feature can not be found");
		}

	}

	/**
	 * build clause
	 * 
	 * @param clause
	 *            as array of integers
	 * @throws BuilderException
	 *             converted ContradictionException
	 */
	private void buildClause(int[] clause) throws BuilderException {
		try {
			// Add or-clause column; add several columns for and-clause
			solver.addClause(new VecInt(clause));
		} catch (ContradictionException e) {
			String message = e.getMessage();
			logger.warn(message, e);
			throw new BuilderException(message, e);
		}
	}

	/**
	 * translate or to sat
	 * 
	 * @param ors
	 *            ors
	 * @throws BuilderException
	 */
	private void buildOrClause(int[] ors) throws BuilderException {
		try {
			solver.addAtLeast(new VecInt(ors), 1);
		} catch (ContradictionException e) {
			String message = e.getMessage();
			logger.warn(message, e);
			throw new BuilderException(message, e);
		}
	}

	/**
	 * translate alternatives to sat
	 * 
	 * @param alternatives
	 *            alternatives
	 * @throws BuilderException
	 */
	private void buildXOrClause(int[] alternatives) throws BuilderException {
		try {
			solver.addAtLeast(new VecInt(alternatives), 1);
			solver.addAtMost(new VecInt(alternatives), 1);
		} catch (ContradictionException e) {
			String message = e.getMessage();
			logger.warn(message, e);
			throw new BuilderException(message, e);
		}
	}

	private void addGroupMapping(Group group) {
		for (Feature f : group.getChildFeatures()) {
			addMapping(f);
		}
	}

	public void addMapping(Feature newFeature) {
		if (featureToId.containsKey(newFeature))
			return;
		else {
			featureToId.put(newFeature, varCounter++);
			idToFeature.put(varCounter, newFeature);
		}
	}

	public Integer getMapping(Feature featureIdentifier)
			throws UnknownStatementException {
		if (featureToId.get(featureIdentifier) == null)
			throw new UnknownStatementException(
					"Feature can not be found in the feature model");
		return featureToId.get(featureIdentifier);
	}

	public Feature getMapping(int feature) {
		return idToFeature.get(feature);
	}

	public void removeMapping(Feature featureId)
			throws UnknownStatementException {
		idToFeature.remove(getMapping(featureId));
		featureToId.remove(featureId);
	}

	@Deprecated
	private void registerFeatures(Map<Feature, String> featureIdentifiers)
			throws BuilderException {
		featureToId = new HashMap<Feature, Integer>(featureIdentifiers.size());
		int i = 1;
		for (Feature identifier : featureIdentifiers.keySet()) {
			featureToId.put(identifier, new Integer(i));
			idToFeature.put(new Integer(i), identifier);
			logger.debug("add new feature '{"
					+ featureIdentifiers.get(identifier)
					+ "}' with integer value '{" + i + "}'");
			i++;
		}
		// solver.newVar(featureIdentifiers.size());
		varCounter = featureIdentifiers.size();
	}

	@Deprecated
	private void buildExcludeDependencies(Feature featureIdentifier,
			List<Feature> excludeIdentifiers) throws BuilderException,
			UnknownStatementException {
		for (Feature exclude : excludeIdentifiers) {
			int[] clause = { -getMapping(featureIdentifier),
					-getMapping(exclude) };
			logger.debug("add exclude clause '{" + featureIdentifier
					+ "}' <-> '{" + exclude + "}'");
			buildClause(clause);
		}
	}

	@Deprecated
	private void buildRequireDependencies(Feature featureIdentifier,
			List<Feature> requireIdentifiers) throws BuilderException,
			UnknownStatementException {
		for (Feature require : requireIdentifiers) {
			int[] clause = { -getMapping(featureIdentifier),
					getMapping(require) };
			logger.debug("add require clause '{" + featureIdentifier
					+ "}' -> '{" + require + "}'");
			buildClause(clause);
		}
	}

}

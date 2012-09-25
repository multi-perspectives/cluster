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
import org.featuremapper.models.feature.Feature;
import org.featuremapper.models.feature.FeatureModel;
import org.featuremapper.models.feature.Group;
import org.sat4j.core.VecInt;
import org.sat4j.specs.ContradictionException;
import org.sat4j.specs.ISolver;
import org.sat4j.specs.IVecInt;
import org.sat4j.tools.GateTranslator;

public class SATModelBuilder implements ISolverModelBuilder{

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
	
	private Feature rootFeature;

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

	@Override
	public void setSolverModel(GateTranslator gt) {
		solver = gt;
	}

	@Override
	public GateTranslator getModel() {
		return solver;
	}

	@Override
	public GateTranslator buildSolverModel(FeatureModel featuremodel) {
		rootFeature = featuremodel.getRoot();

		addMapping(rootFeature);
		
		try {
			buildRootFeature(rootFeature);
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
	
	@Override
	public void addMapping(Feature newFeature) {
		if (featureToId.containsKey(newFeature))
			return;
		else {
			varCounter++;
			featureToId.put(newFeature, varCounter);
			idToFeature.put(varCounter, newFeature);
		}
	}

	@Override
	public Integer getMapping(Feature featureIdentifier)
			throws UnknownStatementException {
		if (featureToId.get(featureIdentifier) == null)
			throw new UnknownStatementException(
					"Feature can not be found in the feature model");
		return featureToId.get(featureIdentifier);
	}

	@Override
	public Feature getMapping(int feature) {
		return idToFeature.get(feature);
	}

	@Override
	public void removeMapping(Feature featureId)
			throws UnknownStatementException {
		idToFeature.remove(getMapping(featureId));
		featureToId.remove(featureId);
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
				logger.error("Not all features in the constraint could be resolved - cross tree constraint dicarded");
			}
		}
		
		try {
			solver.and(getMapping(model.getRoot()), v);
		} catch (UnknownStatementException e) {
			logger.error("Root feature could not be found in feature model - all cross tree constraints dicarded");
		}
		
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
				varCounter++;
				int[] values = { -varCounter, leftConstraint, rightConstraint };
				// create a new variable that expresses the or relation
				logger.debug("Adding cross tree constraint or for features: '" + leftConstraint  + " || " + rightConstraint + "'");
				solver.or(varCounter, new VecInt(values));
				result = varCounter;
			} else if (term instanceof And) {
				varCounter++;
				int[] values = {varCounter,  leftConstraint, rightConstraint };
				// create a new variable that expresses the and relation
				logger.debug("Adding cross tree constraint and for features: '" + leftConstraint  + " && " + rightConstraint + "'");
				solver.and(varCounter, new VecInt(values));
				result = varCounter;
			}
		} else if (term instanceof UnaryOperator) {
			UnaryOperator unaryTerm = (UnaryOperator) term;
			Term singleTerm = unaryTerm.getOperand();
			int singleConstraint = checkTerm(singleTerm);
			// return the internal feature variable, either negated or not
			if (term instanceof Not) {
				logger.debug("Adding cross tree constraint not for feature: '" + singleConstraint + "'");
				result = -(singleConstraint);
			} else if (term instanceof Nested) {
				logger.debug("Adding cross tree constraint bound for feature: '" + singleConstraint + "'");
				result = singleConstraint;
			}
		} else if (term instanceof FeatureRef) {
			FeatureRef featureRefTerm = (FeatureRef) term;
			Feature feature = featureRefTerm.getFeature();
			logger.debug("Adding feature to cross tree constaint: '" + feature.getName() + "'");
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

	}

	private void buildAlternativeChildren(Feature featureIdentifier,
			List<Feature> alternativeIdentifiers) throws BuilderException,
			ContradictionException, UnknownStatementException {
		VecInt clause = new VecInt();
		
		int parentId = getMapping(featureIdentifier);
		int rootId = getMapping(rootFeature);
		
		for (int i = 0; i < alternativeIdentifiers.size(); i++) {
			int featureId = getMapping(alternativeIdentifiers.get(i));
			clause.push(featureId);
			
			//TODO: Find better solution!
			int[] redundantClause = {rootId, -featureId};
			solver.addClause(new VecInt(redundantClause));
		}

		logger.debug("add alternative clause '{" + featureIdentifier
				+ "}' -> '{" + alternativeIdentifiers + "}'");

		// Add Imply constraint to parent feature
		solver.halfOr(parentId, clause);
		
		clause.push(-parentId);
		buildXOrClause(clause);
	}

	private void buildOptionalChildren(Feature featureIdentifier,
			List<Feature> optionalIdentifiers) throws BuilderException,
			ContradictionException, UnknownStatementException {
		logger.debug("build optional, nothing to do");

		VecInt clause = new VecInt();
		
		int parentId = getMapping(featureIdentifier);
		int rootId = getMapping(rootFeature);

		for (int i = 0; i < optionalIdentifiers.size(); i++) {
			int featureId = getMapping(optionalIdentifiers.get(i));
			clause.push(featureId);
			
			//TODO: Find better solution!
			int[] redundantClause = {rootId, -featureId};
			solver.addClause(new VecInt(redundantClause));
		}

		// Add Imply -> constraint to parent feature
		solver.halfOr(parentId, clause);
	}

	private void buildMandatoryChildren(Feature featureIdentifier,
			List<Feature> mandatoryIdentifiers) throws BuilderException,
			ContradictionException, UnknownStatementException {

		VecInt mandatory = new VecInt();
		
		int parentId = getMapping(featureIdentifier);

		for (Feature f : mandatoryIdentifiers) {
			mandatory.push(getMapping(f));
			logger.debug("add mandatory clause '{" + featureIdentifier
					+ "}' <-> '{" + f + "}'");
		}

		// add mandatory features for parent feature
		solver.and(parentId, mandatory);

		// Add Imply constraint to parent feature
		// --> not necessary since constraint logical equality is specified
	}

	private void buildOrChildren(Feature featureIdentifier,
			List<Feature> orIdentifiers) throws BuilderException,
			ContradictionException, UnknownStatementException {
		VecInt clause = new VecInt();

		int parentId = getMapping(featureIdentifier);
		int rootId = getMapping(rootFeature);
		
		for (int i = 0; i < orIdentifiers.size(); i++) {
			int featureId = getMapping(orIdentifiers.get(i));
			clause.push(featureId);
			
			//TODO: Find better solution!
			int[] redundantClause = {rootId, -featureId};
			solver.addClause(new VecInt(redundantClause));
		}
		// clause[orIdentifiers.size()] = -getMapping(featureIdentifier);
		logger.debug("add or clause '{" + featureIdentifier + "}' -> '{"
				+ orIdentifiers + "}'");
		
		// Add Imply constraint to parent feature
		solver.halfOr(parentId, clause);
		
		clause.push(parentId);
		buildOrClause(clause);
	}

	private void buildRootFeature(Feature rootIdentifier)
			throws BuilderException, ContradictionException {
		try {
			int[] clause = { getMapping(rootIdentifier) };
			logger.debug("add root clause '{" + rootIdentifier + "}'");
			solver.addClause(new VecInt(clause));
		} catch (UnknownStatementException e) {
			logger.error("Root feature can not be found");
		}

	}

	/**
	 * translate or to sat
	 * 
	 * @param ors
	 *            ors
	 * @throws BuilderException
	 */
	private void buildOrClause(IVecInt ors) throws BuilderException {
		try {
			solver.addAtLeast(ors, 1);
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
	private void buildXOrClause(IVecInt alternatives) throws BuilderException {
		try {			
			solver.addAtLeast(alternatives, 1);
			solver.addAtMost(alternatives, 1);
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
}

package org.feature.model.sat.builder;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
import org.feature.model.sat.TextExpressionParser;
import org.feature.model.sat.exception.BuilderException;
import org.feature.model.sat.exception.UnknownStatementException;
import org.featuremapper.models.feature.Constraint;
import org.featuremapper.models.feature.Feature;
import org.featuremapper.models.feature.FeatureModel;
import org.featuremapper.models.feature.Group;
import org.sat4j.core.VecInt;
import org.sat4j.specs.ContradictionException;
import org.sat4j.specs.ISolver;
import org.sat4j.specs.IVecInt;
import org.sat4j.tools.GateTranslator;

/**
 * Class is responsible for transforming a EMF feature model into a SAT4J Model
 * representation.
 * 
 * @author saller
 * 
 */
public class SATModelBuilder implements ISolverModelBuilder {

	/**
	 * counter of features within the feature model. is also used to derive
	 * uniqe id for the transformation
	 */
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
	 * Root feature of the according feature model
	 */
	private Feature rootFeature;

	/**
	 * used sat solver
	 */
	private GateTranslator solver;

	/**
	 * 
	 * Initialize necessary attributes
	 * 
	 * @param solver
	 *            SAT solver
	 */
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

		// add initial mapping for root feature
		addMapping(rootFeature);

		try {
			buildRootFeature(rootFeature);
			// start transformation feature model into SAT model
			transformFeature(rootFeature);
		} catch (BuilderException | ContradictionException e1) {
			logger.error("Cannot build constraint model for SAT4J");
			e1.printStackTrace();
		}

		try {
			// parse and transform cross tree constraints within the feature
			// model
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
			logger.debug(varCounter + " <-> " + newFeature.getName());
		}
	}

	@Override
	public Integer getMapping(Feature featureIdentifier) throws UnknownStatementException {
		if (featureToId.get(featureIdentifier) == null)
			throw new UnknownStatementException("Feature can not be found in the feature model");
		return featureToId.get(featureIdentifier);
	}

	@Override
	public Feature getMapping(int feature) {
		return idToFeature.get(feature);
	}

	@Override
	public void removeMapping(Feature featureId) throws UnknownStatementException {
		idToFeature.remove(getMapping(featureId));
		featureToId.remove(featureId);
	}

	private void transformFeature(Feature feature) throws BuilderException, ContradictionException {

		// Handle rest of the features
		EList<Group> groups = feature.getGroups();
		for (Group group : groups) {
			transformGroup(group);
		}

	}

	private void transformGroup(Group group) throws BuilderException, ContradictionException {
		try {
			createGroupConstraint(group);
			EList<Feature> childFeatures = group.getChildFeatures();
			for (Feature feature : childFeatures) {
				// start another transformation process for a child feature
				transformFeature(feature);
			}
		} catch (UnknownStatementException e) {
			logger.error("Group constraint could not be added - group constraint discarded");
		}

	}

	private void transformRemainingCTConstraints(FeatureModel model) throws ContradictionException {

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

		// If no CSP terms are given, look for SAT terms; otherwise add CSP
		// cross tree constraints
		if (terms.size() > 0)
			try {
				solver.and(getMapping(model.getRoot()), v);
			} catch (UnknownStatementException e) {
				logger.error("Root feature could not be found in feature model - all cross tree constraints dicarded");
			}
		else
			checkSATConstrints(model);
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
				int[] values = { leftConstraint, rightConstraint };
				// create a new variable that expresses the or relation
				logger.debug("Adding cross tree constraint or for features: '" + leftConstraint + " || "
						+ rightConstraint + "'");
				solver.or(varCounter, new VecInt(values));
				result = varCounter;
			} else if (term instanceof And) {
				varCounter++;
				int[] values = { leftConstraint, rightConstraint };
				// create a new variable that expresses the and relation
				logger.debug("Adding cross tree constraint and for features: '" + leftConstraint + " && "
						+ rightConstraint + "'");
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
				URI proxyURI = ((org.eclipse.emf.ecore.InternalEObject) feature).eProxyURI();
				String uriFragment = proxyURI.fragment();
				logger.warn("Proxy found! UriFragment of proxy is: " + uriFragment);
			}
			result = getMapping(feature);
		}

		return result;
	}

	private void checkSATConstrints(FeatureModel model) {
		// parse SAT constraint require(source, target) or exclude(source,
		// target)
		for (Constraint c : model.getConstraints()) {
			if (c.getLanguage().toLowerCase().equals("sat")) {
				String expr = c.getExpression();
				if (expr.startsWith("require(")) {
					String satExpr = expr.replaceFirst("require", "");
					satExpr = satExpr.replace("(", "");
					satExpr = satExpr.replace(")", "");
					satExpr = satExpr.replace(" ", "");
					String[] literals = satExpr.split(",");
					String reqSource = literals[0];
					Set<String> reqTargets = new HashSet<String>();
					for (int i = 1; i < literals.length; i++)
						reqTargets.add(literals[i]);

					try {
						buildRequireDependencies(reqSource, reqTargets);
					} catch (BuilderException e) {
						logger.error("Can not read SAT constraint '" + expr + "'from feature model");
						continue;
					} catch (ContradictionException e) {
						logger.error("Can not read SAT constraint '" + expr + "'from feature model");
						continue;
					}
				} else if (expr.startsWith("exclude(")) {
					String satExpr = expr.replaceFirst("exclude", "");
					satExpr = satExpr.replace("(", "");
					satExpr = satExpr.replace(")", "");
					satExpr = satExpr.replace(" ", "");
					String[] literals = satExpr.split(",");
					String exclSource = literals[0];
					Set<String> exclTargets = new HashSet<String>();
					for (int i = 1; i < literals.length; i++)
						exclTargets.add(literals[i]);

					try {
						buildExcludeDependencies(exclSource, exclTargets);
					} catch (BuilderException e) {
						logger.error("Can not read SAT constraint '" + expr + "'from feature model");
						continue;
					} catch (ContradictionException e) {
						logger.error("Can not read SAT constraint '" + expr + "'from feature model");
						continue;
					}
				}
			}
		}
	}

	private void createGroupConstraint(Group group) throws BuilderException, ContradictionException,
			UnknownStatementException {

		addGroupMapping(group);

		// Optional: o..n
		if (group.getMaxCardinality() >= group.getChildFeatures().size() && group.getMinCardinality() == 0) {
			buildOptionalChildren(group.getParentFeature(), group.getChildFeatures());

		}
		// Mandatory: n..n
		else if (group.getMaxCardinality() == group.getChildFeatures().size()
				&& group.getMinCardinality() == group.getChildFeatures().size()) {
			buildMandatoryChildren(group.getParentFeature(), group.getChildFeatures());

		}
		// Alternative: x..x; x>0; x<n
		else if (group.getMaxCardinality() == group.getMinCardinality() && group.getMaxCardinality() >= 1
				&& group.getMaxCardinality() <= group.getChildFeatures().size() && group.getChildFeatures().size() >= 1) {
			buildAlternativeChildren(group.getParentFeature(), group.getChildFeatures());

		}
		// Or: 1..n
		else if (group.getMinCardinality() > 0 && group.getMaxCardinality() != group.getMinCardinality()
				&& group.getMaxCardinality() <= group.getChildFeatures().size()) {
			buildOrChildren(group.getParentFeature(), group.getChildFeatures());

		} else
			throw new BuilderException("Unkown combination of feature cardinalities");

	}

	private void buildExcludeDependencies(String excludeSource, Set<String> excludedIdentifiers)
			throws BuilderException, ContradictionException {
		for (String exclude : excludedIdentifiers) {
			int[] literals = { -getFeatureByName(excludeSource), -getFeatureByName(exclude) };
			VecInt clause = new VecInt(literals);
			logger.debug("add exclude clause '" + excludeSource + "' <-> '" + exclude + "'");
			solver.addClause(clause);
		}
	}

	private void buildRequireDependencies(String reqSource, Set<String> requiredIdentifiers) throws BuilderException,
			ContradictionException {
		for (String require : requiredIdentifiers) {
			int[] literals = { -getFeatureByName(reqSource), getFeatureByName(require) };
			VecInt clause = new VecInt(literals);
			logger.debug("add require clause '" + reqSource + "' -> '" + require + "'");
			solver.addClause(clause);
		}
	}

	private void buildAlternativeChildren(Feature featureIdentifier, List<Feature> alternativeIdentifiers)
			throws BuilderException, ContradictionException, UnknownStatementException {
		VecInt clause = new VecInt();

		int parentId = getMapping(featureIdentifier);
		int rootId = getMapping(rootFeature);

		for (int i = 0; i < alternativeIdentifiers.size(); i++) {
			int featureId = getMapping(alternativeIdentifiers.get(i));
			clause.push(featureId);

			// TODO: Find better solution!
			int[] redundantClause = { rootId, -featureId };
			solver.addClause(new VecInt(redundantClause));
		}

		logger.debug("add alternative clause '" + featureIdentifier.getName() + "' -> '"
				+ convertFeatureListToString(alternativeIdentifiers) + "'");

		// Add Imply constraint to parent feature
		solver.halfOr(parentId, clause);

		clause.push(-parentId);
		buildXOrClause(clause);
	}

	private void buildOptionalChildren(Feature featureIdentifier, List<Feature> optionalIdentifiers)
			throws BuilderException, ContradictionException, UnknownStatementException {

		VecInt clause = new VecInt();

		int parentId = getMapping(featureIdentifier);
		int rootId = getMapping(rootFeature);

		for (int i = 0; i < optionalIdentifiers.size(); i++) {
			int featureId = getMapping(optionalIdentifiers.get(i));
			clause.push(featureId);

			// TODO: Find better solution!
			int[] redundantClause = { rootId, -featureId };
			solver.addClause(new VecInt(redundantClause));
		}

		// Add Imply -> constraint to parent feature
		solver.halfOr(parentId, clause);
	}

	private void buildMandatoryChildren(Feature featureIdentifier, List<Feature> mandatoryIdentifiers)
			throws BuilderException, ContradictionException, UnknownStatementException {

//		VecInt mandatory = new VecInt();

		int parentId = getMapping(featureIdentifier);

		for (Feature f : mandatoryIdentifiers) {
			VecInt mandatory = new VecInt();
			mandatory.push(getMapping(f));
			solver.and(parentId, mandatory);
			logger.debug("add mandatory clause '" + featureIdentifier.getName() + "' <-> '" + f.getName() + "'");
		}

		// add mandatory features for parent feature
//		solver.and(parentId, mandatory);

		// Add Imply constraint to parent feature
		// --> not necessary since constraint logical equality is specified
	}

	private void buildOrChildren(Feature featureIdentifier, List<Feature> orIdentifiers) throws BuilderException,
			ContradictionException, UnknownStatementException {
		VecInt clause = new VecInt();

		int parentId = getMapping(featureIdentifier);
		int rootId = getMapping(rootFeature);

		for (int i = 0; i < orIdentifiers.size(); i++) {
			int featureId = getMapping(orIdentifiers.get(i));
			clause.push(featureId);

			// TODO: Find better solution!
			int[] redundantClause = { rootId, -featureId };
			solver.addClause(new VecInt(redundantClause));
		}
		// clause[orIdentifiers.size()] = -getMapping(featureIdentifier);
		logger.debug("add or clause '" + featureIdentifier.getName() + "' -> '"
				+ convertFeatureListToString(orIdentifiers) + "'");

		// Add Imply constraint to parent feature
		solver.halfOr(parentId, clause);

		clause.push(-parentId);
		buildOrClause(clause);
	}

	private void buildRootFeature(Feature rootIdentifier) throws BuilderException, ContradictionException {
		try {
			logger.debug("add root clause '" + rootIdentifier.getName() + "'");
			solver.gateTrue(getMapping(rootIdentifier));
		} catch (UnknownStatementException e) {
			logger.error("Root feature can not be found");
		}

	}

	private void buildOrClause(IVecInt ors) throws BuilderException {
		try {
			solver.addAtLeast(ors, 1);
		} catch (ContradictionException e) {
			String message = e.getMessage();
			logger.warn(message, e);
			throw new BuilderException(message, e);
		}
	}

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

	private int getFeatureByName(String featureName) {
		for (Feature f : featureToId.keySet())
			if (f.getName().equals(featureName))
				return featureToId.get(f);
		logger.error("Feature '" + featureName + "' could not be found.");
		return 0;
	}

	private String convertFeatureListToString(List<Feature> features) {
		StringBuffer buffer = new StringBuffer();
		int counter = 1;
		for (Feature feature : features) {
			buffer.append(feature.getName());
			if (counter < features.size()) {
				buffer.append(", ");
				counter++;
			}
		}
		return buffer.toString();
	}
}

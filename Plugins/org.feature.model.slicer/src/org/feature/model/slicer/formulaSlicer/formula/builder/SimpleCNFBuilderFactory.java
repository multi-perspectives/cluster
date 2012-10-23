package org.feature.model.slicer.formulaSlicer.formula.builder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;
import org.emftext.term.propositional.expression.Term;
import org.feature.model.sat.exception.BuilderException;
import org.feature.model.sat.exception.UnknownStatementException;
import org.feature.model.sat.solver.IFeatureSolver;
import org.featuremapper.models.feature.Feature;
import org.featuremapper.models.feature.FeatureModel;
import org.featuremapper.models.feature.Group;

/**
 * This Builder create a SAT string for output
 * 
 * @author Ingo Reimund
 * @create 12.03.2012
 */
@Deprecated
public class SimpleCNFBuilderFactory implements IFormulaFactory {

	/**
	 * Logger
	 */
	private static Logger logger = Logger
			.getLogger(SimpleCNFBuilderFactory.class);

	/**
	 * result of the build process
	 */
	private StringBuffer result = new StringBuffer();

	private Map<Feature, String> featureToRepresentation;
	private Map<String, Feature> representationToFeature;
	private int featureCounter;

	@Override
	public String createFormulaId(FeatureModel model) {
		featureCounter = 1;
		featureToRepresentation = new HashMap<Feature, String>();
		representationToFeature = new HashMap<String, Feature>();
		for (Feature f : model.getAllFeatures()) {
			addMapping(f, featureCounter + "");
		}

		Feature rootFeature = model.getRoot();

		buildRootFeature(rootFeature);
		transformFeature(rootFeature);

		prepareOr();
		prepareAlternative();

		return result.toString();

	}

	@Override
	public String createFormulaName(FeatureModel model) {
		featureCounter = 1;
		featureToRepresentation = new HashMap<Feature, String>();
		representationToFeature = new HashMap<String, Feature>();
		for (Feature f : model.getAllFeatures()) {
			addMapping(f, f.getName());
		}

		Feature rootFeature = model.getRoot();

		buildRootFeature(rootFeature);
		transformFeature(rootFeature);

		prepareOr();
		prepareAlternative();

		return result.toString();
	}

	@Override
	public String createFormulaName(FeatureModel model,
			Set<Feature> boundedAlive, Set<Feature> boundedDead) {
		StringBuffer buffer = new StringBuffer();
		buffer.append(createFormulaName(model));

		for (Feature alive : boundedAlive) {
			buffer.append("(");
			buffer.append(alive.getName());
			buffer.append(")\n");
		}
		for (Feature dead : boundedDead) {
			buffer.append("(-");
			buffer.append(dead.getName());
			buffer.append(")\n");
		}
		return buffer.toString();
	}

	@Override
	public String createFormulaId(FeatureModel model,
			Set<Feature> boundedAlive, Set<Feature> boundedDead) {
		StringBuffer buffer = new StringBuffer();
		buffer.append(createFormulaId(model));

		for (Feature alive : boundedAlive) {
			buffer.append("(");
			try {
				buffer.append(getMapping(alive));
			} catch (UnknownStatementException e) {
				logger.error("Feature '"
						+ alive.getName()
						+ "' could not be found. skipping the CNF transformation");
			}
			buffer.append(")\n");
		}
		for (Feature dead : boundedDead) {
			buffer.append("(-");
			try {
				buffer.append(getMapping(dead));
			} catch (UnknownStatementException e) {
				logger.error("Feature '"
						+ dead.getName()
						+ "' could not be found. skipping the CNF transformation");
			}
			buffer.append(")\n");
		}
		return buffer.toString();
	}

	private void transformFeature(Feature feature) {

		// Handle rest of the features
		EList<Group> groups = feature.getGroups();
		for (Group group : groups) {
			transformGroup(group);
		}

	}

	private void transformGroup(Group group) {

		createGroupConstraint(group);
		EList<Feature> childFeatures = group.getChildFeatures();
		for (Feature feature : childFeatures) {
			transformFeature(feature);
		}

	}

	// TODO: implement
	private void transformRemainingCTConstraints(FeatureModel model) {

		// VecInt v = new VecInt();
		// List<Term> terms = TextExpressionParser.parseExpressions(model);
		// for (Term term : terms) {
		// // Add resulting (new) variable to the solver model and bind it to
		// // true
		//
		// v.push(checkTerm(term));
		//
		// }
		//
		// solver.and(getMapping(model.getRoot()), v);

	}

	// TODO: implement
	private int checkTerm(Term term) {

		int result = 0;
		//
		// if (term instanceof BinaryOperator) {
		// BinaryOperator binTerm = (BinaryOperator) term;
		// Term leftTerm = binTerm.getOperand1();
		// int leftConstraint = checkTerm(leftTerm);
		// Term rightTerm = binTerm.getOperand2();
		// int rightConstraint = checkTerm(rightTerm);
		//
		// if (term instanceof Or) {
		// varCounter++;
		// int[] values = { -varCounter, leftConstraint, rightConstraint };
		// // create a new variable that expresses the or relation
		// logger.debug("Adding cross tree constraint or for features: '"
		// + leftConstraint + " || " + rightConstraint + "'");
		// solver.or(varCounter, new VecInt(values));
		// result = varCounter;
		// } else if (term instanceof And) {
		// varCounter++;
		// int[] values = { varCounter, leftConstraint, rightConstraint };
		// // create a new variable that expresses the and relation
		// logger.debug("Adding cross tree constraint and for features: '"
		// + leftConstraint + " && " + rightConstraint + "'");
		// solver.and(varCounter, new VecInt(values));
		// result = varCounter;
		// }
		// } else if (term instanceof UnaryOperator) {
		// UnaryOperator unaryTerm = (UnaryOperator) term;
		// Term singleTerm = unaryTerm.getOperand();
		// int singleConstraint = checkTerm(singleTerm);
		// // return the internal feature variable, either negated or not
		// if (term instanceof Not) {
		// logger.debug("Adding cross tree constraint not for feature: '"
		// + singleConstraint + "'");
		// result = -(singleConstraint);
		// } else if (term instanceof Nested) {
		// logger.debug("Adding cross tree constraint bound for feature: '"
		// + singleConstraint + "'");
		// result = singleConstraint;
		// }
		// } else if (term instanceof FeatureRef) {
		// FeatureRef featureRefTerm = (FeatureRef) term;
		// Feature feature = featureRefTerm.getFeature();
		// logger.debug("Adding feature to cross tree constaint: '"
		// + feature.getName() + "'");
		// if (feature.eIsProxy()) {
		// URI proxyURI = ((org.eclipse.emf.ecore.InternalEObject) feature)
		// .eProxyURI();
		// String uriFragment = proxyURI.fragment();
		// logger.warn("Proxy found! UriFragment of proxy is: "
		// + uriFragment);
		// }
		// result = getMapping(feature);
		// }
		//
		return result;
	}

	private void createGroupConstraint(Group group) {

		// Optional: o..n
		if (group.getMaxCardinality() >= group.getChildFeatures().size()
				&& group.getMinCardinality() == 0) {
			addChildrenOptional(group.getParentFeature(),
					group.getChildFeatures());
		}
		// Mandatory: n..n
		else if (group.getMaxCardinality() == group.getChildFeatures().size()
				&& group.getMinCardinality() == group.getChildFeatures().size()) {
			addChildrenMandatory(group.getParentFeature(),
					group.getChildFeatures());

		}
		// Alternative: x..x; x>0; x<n
		else if (group.getMaxCardinality() == group.getMinCardinality()
				&& group.getMaxCardinality() >= 1
				&& group.getMaxCardinality() <= group.getChildFeatures().size()
				&& group.getChildFeatures().size() >= 1) {
			addChildrenAlternative(group.getParentFeature(),
					group.getChildFeatures());

		}
		// Or: 1..n
		else if (group.getMinCardinality() > 0
				&& group.getMaxCardinality() != group.getMinCardinality()
				&& group.getMaxCardinality() <= group.getChildFeatures().size()) {
			addChildrenOr(group.getParentFeature(), group.getChildFeatures());

		} else
			throw new BuilderException(
					"Unkown combination of feature cardinalities");

	}

	/**
	 * create a connection between child and parent. If child is selected, the
	 * parent have to be selected too;
	 * 
	 * @param featureIdentifier
	 *            child
	 * @param parentIdentifier
	 *            parent
	 */
	private void createParent(Feature child, Feature parent) {
		logger.debug("build parent (-'{" + child.getName() + "}' v '{"
				+ parent.getName() + "}')");
		String expression = "";
		try {
			expression += "(";
			expression += ("-");
			expression += (getMapping(child));
			expression += (" v ");
			expression += (getMapping(parent));
			expression += (")\n");
		} catch (UnknownStatementException e) {
			logger.error("Could not add expression to CNF; skip expression");
		}
		result.append(expression);

	}

	private void addChildrenMandatory(Feature featureParent,
			List<Feature> childIdentifiers) {

		String expression = "";

		for (Feature childIdentifier : childIdentifiers) {
			createParent(childIdentifier, featureParent);
			logger.debug("build mandatory (-'{" + featureParent.getName()
					+ "}' v '{" + childIdentifier.getName() + "}')");

			try {
				expression += ("(");
				expression += ("-");
				expression += (getMapping(featureParent));
				expression += (" v ");
				expression += getMapping(childIdentifier);
				expression += (")\n");

			} catch (UnknownStatementException e) {
				logger.error("Could not add expression to CNF; skip expression");
			}
		}
		result.append(expression);
	}

	/**
	 * mapping between feature identifier and the child identifier which are in
	 * a or group
	 */
	private Map<Feature, List<Feature>> orMapping = new HashMap<>();

	private void addChildrenOr(Feature featureIdentifier,
			List<Feature> childIdentifiers) {
		for (Feature childIdentifier : childIdentifiers) {
			createParent(childIdentifier, featureIdentifier);
			if (!orMapping.containsKey(featureIdentifier)) {
				orMapping.put(featureIdentifier, new ArrayList<Feature>());
			}
			orMapping.get(featureIdentifier).add(childIdentifier);
		}
	}

	/**
	 * mapping between feature identifier and the child identifier which are in
	 * a or group
	 */
	private Map<Feature, List<Feature>> altMapping = new HashMap<>();

	private void addChildrenAlternative(Feature featureIdentifier,
			List<Feature> childIdentifiers) {
		for (Feature childIdentifier : childIdentifiers) {
			createParent(childIdentifier, featureIdentifier);
			if (!altMapping.containsKey(featureIdentifier)) {
				altMapping.put(featureIdentifier, new ArrayList<Feature>());
			}
			altMapping.get(featureIdentifier).add(childIdentifier);
		}
	}

	private void addChildrenOptional(Feature featureIdentifier,
			List<Feature> childIdentifiers) {
		for (Feature childIdentifier : childIdentifiers) {
			createParent(childIdentifier, featureIdentifier);
		}
	}

	private void addDepencencyRequire(Feature featureIdentifier,
			Feature dependencyIdentifier) {
		logger.debug("build require (-'{" + featureIdentifier.getName()
				+ "}' v '{" + dependencyIdentifier.getName() + "}')");

		String expression = "";
		try {

			expression += ("(");
			expression += ("-");
			expression += (getMapping(featureIdentifier));
			expression += (" v ");
			expression += (getMapping(dependencyIdentifier));
			expression += (")\n");
		} catch (UnknownStatementException e) {
			logger.error("Could not add expression to CNF; skip expression");
		}
		result.append(expression);
	}

	private void addDepencencyExclude(Feature featureIdentifier,
			Feature dependencyIdentifier) {
		logger.debug("build exclude (-'{" + featureIdentifier.getName()
				+ "}' v -'{" + dependencyIdentifier.getName() + "}')");

		String expression = "";
		try {
			expression += ("(");
			expression += ("-");
			expression += (getMapping(featureIdentifier));
			expression += (" v ");
			expression += ("-");
			expression += (getMapping(dependencyIdentifier));
			expression += (")\n");

		} catch (UnknownStatementException e) {
			logger.error("Could not add expression to CNF; skip expression");
		}
		result.append(expression);
	}

	// private void addProperty(String featureIdentifier, String name,
	// String value, String type, Boolean fixed, Boolean readonly) {
	// logger.debug("ignore type '{}' of feature '{}'", type,
	// getName(featureIdentifier));
	// }

	private void buildRootFeature(Feature rootIdentifier) {
		logger.debug("build root feature");

		String expression = "";
		try {
			expression += ("(");
			expression += (getMapping(rootIdentifier));
			expression += (")\n");

		} catch (UnknownStatementException e) {
			logger.error("Could not add expression to CNF; skip expression");
		}
		result.append(expression);
	}

	/**
	 * use the mapping of or features to create an expression which added to the
	 * end of the result
	 */
	private void prepareOr() {
		for (Feature identifier : orMapping.keySet()) {

			String expression = "";
			try {
				logger.debug("build or (-'{" + identifier.getName() + "}' v ?)");
				expression += ("(");
				expression += ("-");
				expression += (getMapping(identifier));
				expression += (" v ");
				expression += ("(");

				List<Feature> list = orMapping.get(identifier);
				expression += (getMapping(list.get(0)));

				for (int i = 1; i < list.size(); i++) {
					expression += (" v ");
					expression += (getMapping(list.get(i)));
				}
				expression += (")");
				expression += (")\n");
			} catch (UnknownStatementException e) {
				logger.error("Could not add expression to CNF; skip expression");
			}
			result.append(expression);
		}
	}

	/**
	 * use the mapping of alternative features to create an expression which
	 * added to the end of the result
	 */
	private void prepareAlternative() {
		for (Feature identifier : altMapping.keySet()) {

			String expression = "";
			try {
				logger.debug("build or (-'{" + identifier.getName() + "}' v ?)");
				expression += ("(");
				expression += ("-");
				expression += (getMapping(identifier));
				expression += (" v ");
				expression += ("(");

				List<Feature> list = altMapping.get(identifier);
				for (int i = 0; i < list.size(); i++) {
					expression += ("(");
					expression += (getMapping(list.get(i)));

					for (Feature alt : list) {
						if (!list.get(i).equals(alt)) {
							expression += (" ^ ");
							expression += ("-");
							expression += (getMapping(alt));
						}
					}
					expression += (")");

					if (i < list.size() - 1) {
						expression += (" v ");
					}
				}
				expression += ("))\n");
			} catch (UnknownStatementException e) {
				logger.error("Could not add expression to CNF; skip expression");
			}
			expression += (expression);
		}
	}

	private void addMapping(Feature newFeature, String representation) {
		if (featureToRepresentation.containsKey(newFeature))
			return;
		else {
			featureCounter++;
			featureToRepresentation.put(newFeature, representation);
			representationToFeature.put(representation, newFeature);
		}
	}

	private String getMapping(Feature featureIdentifier)
			throws UnknownStatementException {
		if (featureToRepresentation.get(featureIdentifier) == null)
			throw new UnknownStatementException(
					"Feature can not be found in the feature model");
		return featureToRepresentation.get(featureIdentifier);
	}

	@Override
	public String createFormulaIdMinimized(FeatureModel model,
			Set<Feature> boundedAlive, Set<Feature> boundedDead) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String createFormulaNameMinimized(IFeatureSolver solverModel,
			Set<Feature> boundedAlive, Set<Feature> boundedDead) {
		// TODO Auto-generated method stub
		return null;
	}

//	private Feature getMapping(String feature) {
//		return representationToFeature.get(feature);
//	}
//
//	private void removeMapping(Feature featureId)
//			throws UnknownStatementException {
//		representationToFeature.remove(getMapping(featureId));
//		featureToRepresentation.remove(featureId);
//	}
}
package org.feature.model.sat;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.term.propositional.expression.BinaryOperator;
import org.emftext.term.propositional.expression.FeatureRef;
import org.emftext.term.propositional.expression.Term;
import org.emftext.term.propositional.expression.UnaryOperator;
import org.emftext.term.propositional.expression.resource.expression.util.ExpressionResourceUtil;
import org.feature.model.utilities.FeatureModelUtil;
import org.featuremapper.models.feature.Constraint;
import org.featuremapper.models.feature.Feature;
import org.featuremapper.models.feature.FeatureModel;
import org.featuremapper.models.feature.FeaturePackage;

public class TextExpressionParser {

	private static Logger log = Logger.getLogger(TextExpressionParser.class);

	/**
	 * parse all
	 * 
	 * @param featuremodel
	 */
	public static List<Term> parseExpressions(FeatureModel featuremodel) {
		List<Term> terms = new ArrayList<Term>(featuremodel.getConstraints()
				.size());
		
		URI uri = EcoreUtil.getURI(featuremodel);
		Resource resource = featuremodel.eResource();
		ResourceSet resourceSet = new ResourceSetImpl();
		if (resource != null) {
			resourceSet = resource.getResourceSet();
		}
		List<Constraint> cspConstraints = FeatureModelUtil.getConstraints(
				featuremodel, FeatureModelUtil.csp_constraintLanguage);
		for (Constraint constraint : cspConstraints) {
			String expression = constraint.getExpression();
			Term term = parseExpression(expression, uri, resourceSet);
			if (term != null) {
				log.debug("Term for expression '" + expression + "' extracted.");
				terms.add(term);
			} else {
				log.warn("no term extracted");
			}
		}
		return terms;
	}

	public static Set<Feature> getConstrainedFeatures(FeatureModel featuremodel) {
		Set<Feature> constrainedFeatures = new LinkedHashSet<Feature>();
		List<Term> expressions = parseExpressions(featuremodel);
		for (Term term : expressions) {
			constrainedFeatures.addAll(getFeaturesFromTerm(term));
		}
		return constrainedFeatures;
	}

	public static Set<Feature> getFeaturesFromTerm(Term term) {
		Set<Feature> constrainedFeatures = new LinkedHashSet<Feature>();
		if (term instanceof BinaryOperator) {
			BinaryOperator binTerm = (BinaryOperator) term;
			Term leftTerm = binTerm.getOperand1();
			constrainedFeatures.addAll(getFeaturesFromTerm(leftTerm));
			Term rightTerm = binTerm.getOperand2();
			constrainedFeatures.addAll(getFeaturesFromTerm(rightTerm));

		} else if (term instanceof UnaryOperator) {
			UnaryOperator unaryTerm = (UnaryOperator) term;
			Term singleTerm = unaryTerm.getOperand();
			constrainedFeatures.addAll(getFeaturesFromTerm(singleTerm));
		} else if (term instanceof FeatureRef) {
			FeatureRef featureRefTerm = (FeatureRef) term;
			Feature feature = featureRefTerm.getFeature();
			constrainedFeatures.add(feature);
		}
		return constrainedFeatures;
	}

	/**
	 * parse a constraint expression and return the term model
	 * 
	 * @param expression
	 *            as String
	 * @param featuremodelURI
	 *            an uri to create a temporary file from
	 * @return
	 */
	public static Term parseExpression(String expression, URI featuremodelURI,
			ResourceSet resourceSet) {
		Term term = null;
		InputStream inputStream = new ByteArrayInputStream(
				expression.getBytes());

		EPackage.Registry.INSTANCE.put(FeaturePackage.eNS_URI,
				FeaturePackage.eINSTANCE);

		if (inputStream != null) {
			URI uri = featuremodelURI.trimFileExtension().trimFragment();

			String uriString = uri.toString();
			log.debug("FeaturemodelURI: " + uriString);
			uri = URI.createURI(uriString);
			uri = uri.appendFileExtension("_" + inputStream.hashCode());
			uri = uri.appendFileExtension("expression");

			log.debug("Expression resource created for URI " + uri);
			Resource resource = resourceSet.createResource(uri);
			try {
				resource.load(inputStream, Collections.EMPTY_MAP);
				EList<EObject> contents = resource.getContents();
				// an expression must contain only one Term
				if (contents.size() == 1
						&& contents.get(0) instanceof org.emftext.term.propositional.expression.Constraint) {
					org.emftext.term.propositional.expression.Constraint constraint = (org.emftext.term.propositional.expression.Constraint) contents
							.get(0);
					term = constraint.getTerm();
				}
				boolean resolved = ExpressionResourceUtil.resolveAll(resource);
				if (resolved) {
					log.debug("All proxies of the expression have been resolved.");
				} else {
					// log.warn("Not all proxies of the expression could be resolved.");
				}

			} catch (IOException e) {
				log.warn("Could not load temporary expression resource '" + uri
						+ "'.");
			}
		}
		return term;
	}
}

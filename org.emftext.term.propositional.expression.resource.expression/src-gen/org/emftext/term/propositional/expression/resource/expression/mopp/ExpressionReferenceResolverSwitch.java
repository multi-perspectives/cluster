/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.term.propositional.expression.resource.expression.mopp;

public class ExpressionReferenceResolverSwitch implements org.emftext.term.propositional.expression.resource.expression.IExpressionReferenceResolverSwitch {
	
	protected org.emftext.term.propositional.expression.resource.expression.analysis.FeatureRefFeatureReferenceResolver featureRefFeatureReferenceResolver = new org.emftext.term.propositional.expression.resource.expression.analysis.FeatureRefFeatureReferenceResolver();
	
	public org.emftext.term.propositional.expression.resource.expression.analysis.FeatureRefFeatureReferenceResolver getFeatureRefFeatureReferenceResolver() {
		return featureRefFeatureReferenceResolver;
	}
	
	public void setOptions(java.util.Map<?, ?> options) {
		featureRefFeatureReferenceResolver.setOptions(options);
	}
	
	public void resolveFuzzy(String identifier, org.eclipse.emf.ecore.EObject container, org.eclipse.emf.ecore.EReference reference, int position, org.emftext.term.propositional.expression.resource.expression.IExpressionReferenceResolveResult<org.eclipse.emf.ecore.EObject> result) {
		if (container == null) {
			return;
		}
		if (org.emftext.term.propositional.expression.TermPackage.eINSTANCE.getFeatureRef().isInstance(container)) {
			ExpressionFuzzyResolveResult<org.featuremapper.models.feature.Feature> frr = new ExpressionFuzzyResolveResult<org.featuremapper.models.feature.Feature>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("feature")) {
				featureRefFeatureReferenceResolver.resolve(identifier, (org.emftext.term.propositional.expression.FeatureRef) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
	}
	
	public org.emftext.term.propositional.expression.resource.expression.IExpressionReferenceResolver<? extends org.eclipse.emf.ecore.EObject, ? extends org.eclipse.emf.ecore.EObject> getResolver(org.eclipse.emf.ecore.EStructuralFeature reference) {
		if (reference == org.emftext.term.propositional.expression.TermPackage.eINSTANCE.getFeatureRef_Feature()) {
			return featureRefFeatureReferenceResolver;
		}
		return null;
	}
	
}

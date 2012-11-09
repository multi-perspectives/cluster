/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.model.constraint.resource.csl.mopp;

public class CslReferenceResolverSwitch implements org.feature.model.constraint.resource.csl.ICslReferenceResolverSwitch {
	
	/**
	 * This map stores a copy of the options the were set for loading the resource.
	 */
	private java.util.Map<Object, Object> options;
	
	protected org.feature.model.constraint.resource.csl.analysis.FeatureExpressionLeftFeatureReferenceResolver featureExpressionLeftFeatureReferenceResolver = new org.feature.model.constraint.resource.csl.analysis.FeatureExpressionLeftFeatureReferenceResolver();
	protected org.feature.model.constraint.resource.csl.analysis.FeatureExpressionRightFeatureReferenceResolver featureExpressionRightFeatureReferenceResolver = new org.feature.model.constraint.resource.csl.analysis.FeatureExpressionRightFeatureReferenceResolver();
	
	public org.feature.model.constraint.resource.csl.ICslReferenceResolver<org.feature.model.constraint.FeatureExpression, org.featuremapper.models.feature.Feature> getFeatureExpressionLeftFeatureReferenceResolver() {
		return getResolverChain(org.feature.model.constraint.ConstraintPackage.eINSTANCE.getFeatureExpression_LeftFeature(), featureExpressionLeftFeatureReferenceResolver);
	}
	
	public org.feature.model.constraint.resource.csl.ICslReferenceResolver<org.feature.model.constraint.FeatureExpression, org.featuremapper.models.feature.Feature> getFeatureExpressionRightFeatureReferenceResolver() {
		return getResolverChain(org.feature.model.constraint.ConstraintPackage.eINSTANCE.getFeatureExpression_RightFeature(), featureExpressionRightFeatureReferenceResolver);
	}
	
	public void setOptions(java.util.Map<?, ?> options) {
		if (options != null) {
			this.options = new java.util.LinkedHashMap<Object, Object>();
			this.options.putAll(options);
		}
		featureExpressionLeftFeatureReferenceResolver.setOptions(options);
		featureExpressionRightFeatureReferenceResolver.setOptions(options);
	}
	
	public void resolveFuzzy(String identifier, org.eclipse.emf.ecore.EObject container, org.eclipse.emf.ecore.EReference reference, int position, org.feature.model.constraint.resource.csl.ICslReferenceResolveResult<org.eclipse.emf.ecore.EObject> result) {
		if (container == null) {
			return;
		}
		if (org.feature.model.constraint.ConstraintPackage.eINSTANCE.getFeatureExpression().isInstance(container)) {
			CslFuzzyResolveResult<org.featuremapper.models.feature.Feature> frr = new CslFuzzyResolveResult<org.featuremapper.models.feature.Feature>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("leftFeature")) {
				featureExpressionLeftFeatureReferenceResolver.resolve(identifier, (org.feature.model.constraint.FeatureExpression) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (org.feature.model.constraint.ConstraintPackage.eINSTANCE.getFeatureExpression().isInstance(container)) {
			CslFuzzyResolveResult<org.featuremapper.models.feature.Feature> frr = new CslFuzzyResolveResult<org.featuremapper.models.feature.Feature>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("rightFeature")) {
				featureExpressionRightFeatureReferenceResolver.resolve(identifier, (org.feature.model.constraint.FeatureExpression) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
	}
	
	public org.feature.model.constraint.resource.csl.ICslReferenceResolver<? extends org.eclipse.emf.ecore.EObject, ? extends org.eclipse.emf.ecore.EObject> getResolver(org.eclipse.emf.ecore.EStructuralFeature reference) {
		if (reference == org.feature.model.constraint.ConstraintPackage.eINSTANCE.getFeatureExpression_LeftFeature()) {
			return getResolverChain(reference, featureExpressionLeftFeatureReferenceResolver);
		}
		if (reference == org.feature.model.constraint.ConstraintPackage.eINSTANCE.getFeatureExpression_RightFeature()) {
			return getResolverChain(reference, featureExpressionRightFeatureReferenceResolver);
		}
		return null;
	}
	
	@SuppressWarnings({"rawtypes", "unchecked"})	
	public <ContainerType extends org.eclipse.emf.ecore.EObject, ReferenceType extends org.eclipse.emf.ecore.EObject> org.feature.model.constraint.resource.csl.ICslReferenceResolver<ContainerType, ReferenceType> getResolverChain(org.eclipse.emf.ecore.EStructuralFeature reference, org.feature.model.constraint.resource.csl.ICslReferenceResolver<ContainerType, ReferenceType> originalResolver) {
		if (options == null) {
			return originalResolver;
		}
		Object value = options.get(org.feature.model.constraint.resource.csl.ICslOptions.ADDITIONAL_REFERENCE_RESOLVERS);
		if (value == null) {
			return originalResolver;
		}
		if (!(value instanceof java.util.Map)) {
			// send this to the error log
			new org.feature.model.constraint.resource.csl.util.CslRuntimeUtil().logWarning("Found value with invalid type for option " + org.feature.model.constraint.resource.csl.ICslOptions.ADDITIONAL_REFERENCE_RESOLVERS + " (expected " + java.util.Map.class.getName() + ", but was " + value.getClass().getName() + ")", null);
			return originalResolver;
		}
		java.util.Map<?,?> resolverMap = (java.util.Map<?,?>) value;
		Object resolverValue = resolverMap.get(reference);
		if (resolverValue == null) {
			return originalResolver;
		}
		if (resolverValue instanceof org.feature.model.constraint.resource.csl.ICslReferenceResolver) {
			org.feature.model.constraint.resource.csl.ICslReferenceResolver replacingResolver = (org.feature.model.constraint.resource.csl.ICslReferenceResolver) resolverValue;
			if (replacingResolver instanceof org.feature.model.constraint.resource.csl.ICslDelegatingReferenceResolver) {
				// pass original resolver to the replacing one
				((org.feature.model.constraint.resource.csl.ICslDelegatingReferenceResolver) replacingResolver).setDelegate(originalResolver);
			}
			return replacingResolver;
		} else if (resolverValue instanceof java.util.Collection) {
			java.util.Collection replacingResolvers = (java.util.Collection) resolverValue;
			org.feature.model.constraint.resource.csl.ICslReferenceResolver replacingResolver = originalResolver;
			for (Object next : replacingResolvers) {
				if (next instanceof org.feature.model.constraint.resource.csl.ICslReferenceCache) {
					org.feature.model.constraint.resource.csl.ICslReferenceResolver nextResolver = (org.feature.model.constraint.resource.csl.ICslReferenceResolver) next;
					if (nextResolver instanceof org.feature.model.constraint.resource.csl.ICslDelegatingReferenceResolver) {
						// pass original resolver to the replacing one
						((org.feature.model.constraint.resource.csl.ICslDelegatingReferenceResolver) nextResolver).setDelegate(replacingResolver);
					}
					replacingResolver = nextResolver;
				} else {
					// The collection contains a non-resolver. Send a warning to the error log.
					new org.feature.model.constraint.resource.csl.util.CslRuntimeUtil().logWarning("Found value with invalid type in value map for option " + org.feature.model.constraint.resource.csl.ICslOptions.ADDITIONAL_REFERENCE_RESOLVERS + " (expected " + org.feature.model.constraint.resource.csl.ICslDelegatingReferenceResolver.class.getName() + ", but was " + next.getClass().getName() + ")", null);
				}
			}
			return replacingResolver;
		} else {
			// The value for the option ADDITIONAL_REFERENCE_RESOLVERS has an unknown type.
			new org.feature.model.constraint.resource.csl.util.CslRuntimeUtil().logWarning("Found value with invalid type in value map for option " + org.feature.model.constraint.resource.csl.ICslOptions.ADDITIONAL_REFERENCE_RESOLVERS + " (expected " + org.feature.model.constraint.resource.csl.ICslDelegatingReferenceResolver.class.getName() + ", but was " + resolverValue.getClass().getName() + ")", null);
			return originalResolver;
		}
	}
	
}

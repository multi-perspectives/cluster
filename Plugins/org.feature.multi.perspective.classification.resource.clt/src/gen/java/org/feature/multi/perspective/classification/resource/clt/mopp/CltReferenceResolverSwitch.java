/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.multi.perspective.classification.resource.clt.mopp;

public class CltReferenceResolverSwitch implements org.feature.multi.perspective.classification.resource.clt.ICltReferenceResolverSwitch {
	
	/**
	 * This map stores a copy of the options the were set for loading the resource.
	 */
	private java.util.Map<Object, Object> options;
	
	protected org.feature.multi.perspective.classification.resource.clt.analysis.ClassificationModelViewMappingReferenceResolver classificationModelViewMappingReferenceResolver = new org.feature.multi.perspective.classification.resource.clt.analysis.ClassificationModelViewMappingReferenceResolver();
	protected org.feature.multi.perspective.classification.resource.clt.analysis.ClassificationModelFeatureModelReferenceResolver classificationModelFeatureModelReferenceResolver = new org.feature.multi.perspective.classification.resource.clt.analysis.ClassificationModelFeatureModelReferenceResolver();
	protected org.feature.multi.perspective.classification.resource.clt.analysis.ClassificationViewgroupsReferenceResolver classificationViewgroupsReferenceResolver = new org.feature.multi.perspective.classification.resource.clt.analysis.ClassificationViewgroupsReferenceResolver();
	protected org.feature.multi.perspective.classification.resource.clt.analysis.ClassificationComposeReferenceResolver classificationComposeReferenceResolver = new org.feature.multi.perspective.classification.resource.clt.analysis.ClassificationComposeReferenceResolver();
	protected org.feature.multi.perspective.classification.resource.clt.analysis.ClassifiedFeatureFeatureReferenceResolver classifiedFeatureFeatureReferenceResolver = new org.feature.multi.perspective.classification.resource.clt.analysis.ClassifiedFeatureFeatureReferenceResolver();
	
	public org.feature.multi.perspective.classification.resource.clt.ICltReferenceResolver<org.feature.multi.perspective.classification.ClassificationModel, org.feature.multi.perspective.mapping.viewmapping.MappingModel> getClassificationModelViewMappingReferenceResolver() {
		return getResolverChain(org.feature.multi.perspective.classification.ClassificationPackage.eINSTANCE.getClassificationModel_ViewMapping(), classificationModelViewMappingReferenceResolver);
	}
	
	public org.feature.multi.perspective.classification.resource.clt.ICltReferenceResolver<org.feature.multi.perspective.classification.ClassificationModel, org.featuremapper.models.feature.FeatureModel> getClassificationModelFeatureModelReferenceResolver() {
		return getResolverChain(org.feature.multi.perspective.classification.ClassificationPackage.eINSTANCE.getClassificationModel_FeatureModel(), classificationModelFeatureModelReferenceResolver);
	}
	
	public org.feature.multi.perspective.classification.resource.clt.ICltReferenceResolver<org.feature.multi.perspective.classification.Classification, org.feature.multi.perspective.model.viewmodel.AbstractGroup> getClassificationViewgroupsReferenceResolver() {
		return getResolverChain(org.feature.multi.perspective.classification.ClassificationPackage.eINSTANCE.getClassification_Viewgroups(), classificationViewgroupsReferenceResolver);
	}
	
	public org.feature.multi.perspective.classification.resource.clt.ICltReferenceResolver<org.feature.multi.perspective.classification.Classification, org.feature.multi.perspective.classification.Classification> getClassificationComposeReferenceResolver() {
		return getResolverChain(org.feature.multi.perspective.classification.ClassificationPackage.eINSTANCE.getClassification_Compose(), classificationComposeReferenceResolver);
	}
	
	public org.feature.multi.perspective.classification.resource.clt.ICltReferenceResolver<org.feature.multi.perspective.classification.ClassifiedFeature, org.featuremapper.models.feature.Feature> getClassifiedFeatureFeatureReferenceResolver() {
		return getResolverChain(org.feature.multi.perspective.classification.ClassificationPackage.eINSTANCE.getClassifiedFeature_Feature(), classifiedFeatureFeatureReferenceResolver);
	}
	
	public void setOptions(java.util.Map<?, ?> options) {
		if (options != null) {
			this.options = new java.util.LinkedHashMap<Object, Object>();
			this.options.putAll(options);
		}
		classificationModelViewMappingReferenceResolver.setOptions(options);
		classificationModelFeatureModelReferenceResolver.setOptions(options);
		classificationViewgroupsReferenceResolver.setOptions(options);
		classificationComposeReferenceResolver.setOptions(options);
		classifiedFeatureFeatureReferenceResolver.setOptions(options);
	}
	
	public void resolveFuzzy(String identifier, org.eclipse.emf.ecore.EObject container, org.eclipse.emf.ecore.EReference reference, int position, org.feature.multi.perspective.classification.resource.clt.ICltReferenceResolveResult<org.eclipse.emf.ecore.EObject> result) {
		if (container == null) {
			return;
		}
		if (org.feature.multi.perspective.classification.ClassificationPackage.eINSTANCE.getClassificationModel().isInstance(container)) {
			CltFuzzyResolveResult<org.feature.multi.perspective.mapping.viewmapping.MappingModel> frr = new CltFuzzyResolveResult<org.feature.multi.perspective.mapping.viewmapping.MappingModel>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("viewMapping")) {
				classificationModelViewMappingReferenceResolver.resolve(identifier, (org.feature.multi.perspective.classification.ClassificationModel) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (org.feature.multi.perspective.classification.ClassificationPackage.eINSTANCE.getClassificationModel().isInstance(container)) {
			CltFuzzyResolveResult<org.featuremapper.models.feature.FeatureModel> frr = new CltFuzzyResolveResult<org.featuremapper.models.feature.FeatureModel>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("featureModel")) {
				classificationModelFeatureModelReferenceResolver.resolve(identifier, (org.feature.multi.perspective.classification.ClassificationModel) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (org.feature.multi.perspective.classification.ClassificationPackage.eINSTANCE.getClassification().isInstance(container)) {
			CltFuzzyResolveResult<org.feature.multi.perspective.model.viewmodel.AbstractGroup> frr = new CltFuzzyResolveResult<org.feature.multi.perspective.model.viewmodel.AbstractGroup>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("viewgroups")) {
				classificationViewgroupsReferenceResolver.resolve(identifier, (org.feature.multi.perspective.classification.Classification) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (org.feature.multi.perspective.classification.ClassificationPackage.eINSTANCE.getClassification().isInstance(container)) {
			CltFuzzyResolveResult<org.feature.multi.perspective.classification.Classification> frr = new CltFuzzyResolveResult<org.feature.multi.perspective.classification.Classification>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("compose")) {
				classificationComposeReferenceResolver.resolve(identifier, (org.feature.multi.perspective.classification.Classification) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (org.feature.multi.perspective.classification.ClassificationPackage.eINSTANCE.getClassifiedFeature().isInstance(container)) {
			CltFuzzyResolveResult<org.featuremapper.models.feature.Feature> frr = new CltFuzzyResolveResult<org.featuremapper.models.feature.Feature>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("feature")) {
				classifiedFeatureFeatureReferenceResolver.resolve(identifier, (org.feature.multi.perspective.classification.ClassifiedFeature) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
	}
	
	public org.feature.multi.perspective.classification.resource.clt.ICltReferenceResolver<? extends org.eclipse.emf.ecore.EObject, ? extends org.eclipse.emf.ecore.EObject> getResolver(org.eclipse.emf.ecore.EStructuralFeature reference) {
		if (reference == org.feature.multi.perspective.classification.ClassificationPackage.eINSTANCE.getClassificationModel_ViewMapping()) {
			return getResolverChain(reference, classificationModelViewMappingReferenceResolver);
		}
		if (reference == org.feature.multi.perspective.classification.ClassificationPackage.eINSTANCE.getClassificationModel_FeatureModel()) {
			return getResolverChain(reference, classificationModelFeatureModelReferenceResolver);
		}
		if (reference == org.feature.multi.perspective.classification.ClassificationPackage.eINSTANCE.getClassification_Viewgroups()) {
			return getResolverChain(reference, classificationViewgroupsReferenceResolver);
		}
		if (reference == org.feature.multi.perspective.classification.ClassificationPackage.eINSTANCE.getClassification_Compose()) {
			return getResolverChain(reference, classificationComposeReferenceResolver);
		}
		if (reference == org.feature.multi.perspective.classification.ClassificationPackage.eINSTANCE.getClassifiedFeature_Feature()) {
			return getResolverChain(reference, classifiedFeatureFeatureReferenceResolver);
		}
		return null;
	}
	
	@SuppressWarnings({"rawtypes", "unchecked"})	
	public <ContainerType extends org.eclipse.emf.ecore.EObject, ReferenceType extends org.eclipse.emf.ecore.EObject> org.feature.multi.perspective.classification.resource.clt.ICltReferenceResolver<ContainerType, ReferenceType> getResolverChain(org.eclipse.emf.ecore.EStructuralFeature reference, org.feature.multi.perspective.classification.resource.clt.ICltReferenceResolver<ContainerType, ReferenceType> originalResolver) {
		if (options == null) {
			return originalResolver;
		}
		Object value = options.get(org.feature.multi.perspective.classification.resource.clt.ICltOptions.ADDITIONAL_REFERENCE_RESOLVERS);
		if (value == null) {
			return originalResolver;
		}
		if (!(value instanceof java.util.Map)) {
			// send this to the error log
			new org.feature.multi.perspective.classification.resource.clt.util.CltRuntimeUtil().logWarning("Found value with invalid type for option " + org.feature.multi.perspective.classification.resource.clt.ICltOptions.ADDITIONAL_REFERENCE_RESOLVERS + " (expected " + java.util.Map.class.getName() + ", but was " + value.getClass().getName() + ")", null);
			return originalResolver;
		}
		java.util.Map<?,?> resolverMap = (java.util.Map<?,?>) value;
		Object resolverValue = resolverMap.get(reference);
		if (resolverValue == null) {
			return originalResolver;
		}
		if (resolverValue instanceof org.feature.multi.perspective.classification.resource.clt.ICltReferenceResolver) {
			org.feature.multi.perspective.classification.resource.clt.ICltReferenceResolver replacingResolver = (org.feature.multi.perspective.classification.resource.clt.ICltReferenceResolver) resolverValue;
			if (replacingResolver instanceof org.feature.multi.perspective.classification.resource.clt.ICltDelegatingReferenceResolver) {
				// pass original resolver to the replacing one
				((org.feature.multi.perspective.classification.resource.clt.ICltDelegatingReferenceResolver) replacingResolver).setDelegate(originalResolver);
			}
			return replacingResolver;
		} else if (resolverValue instanceof java.util.Collection) {
			java.util.Collection replacingResolvers = (java.util.Collection) resolverValue;
			org.feature.multi.perspective.classification.resource.clt.ICltReferenceResolver replacingResolver = originalResolver;
			for (Object next : replacingResolvers) {
				if (next instanceof org.feature.multi.perspective.classification.resource.clt.ICltReferenceCache) {
					org.feature.multi.perspective.classification.resource.clt.ICltReferenceResolver nextResolver = (org.feature.multi.perspective.classification.resource.clt.ICltReferenceResolver) next;
					if (nextResolver instanceof org.feature.multi.perspective.classification.resource.clt.ICltDelegatingReferenceResolver) {
						// pass original resolver to the replacing one
						((org.feature.multi.perspective.classification.resource.clt.ICltDelegatingReferenceResolver) nextResolver).setDelegate(replacingResolver);
					}
					replacingResolver = nextResolver;
				} else {
					// The collection contains a non-resolver. Send a warning to the error log.
					new org.feature.multi.perspective.classification.resource.clt.util.CltRuntimeUtil().logWarning("Found value with invalid type in value map for option " + org.feature.multi.perspective.classification.resource.clt.ICltOptions.ADDITIONAL_REFERENCE_RESOLVERS + " (expected " + org.feature.multi.perspective.classification.resource.clt.ICltDelegatingReferenceResolver.class.getName() + ", but was " + next.getClass().getName() + ")", null);
				}
			}
			return replacingResolver;
		} else {
			// The value for the option ADDITIONAL_REFERENCE_RESOLVERS has an unknown type.
			new org.feature.multi.perspective.classification.resource.clt.util.CltRuntimeUtil().logWarning("Found value with invalid type in value map for option " + org.feature.multi.perspective.classification.resource.clt.ICltOptions.ADDITIONAL_REFERENCE_RESOLVERS + " (expected " + org.feature.multi.perspective.classification.resource.clt.ICltDelegatingReferenceResolver.class.getName() + ", but was " + resolverValue.getClass().getName() + ")", null);
			return originalResolver;
		}
	}
	
}

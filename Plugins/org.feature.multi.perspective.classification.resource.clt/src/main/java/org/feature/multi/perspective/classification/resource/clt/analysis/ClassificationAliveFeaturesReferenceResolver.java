/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.multi.perspective.classification.resource.clt.analysis;

public class ClassificationAliveFeaturesReferenceResolver implements org.feature.multi.perspective.classification.resource.clt.ICltReferenceResolver<org.feature.multi.perspective.classification.Classification, org.featuremapper.models.feature.Feature> {
	
	private org.feature.multi.perspective.classification.resource.clt.analysis.CltDefaultResolverDelegate<org.feature.multi.perspective.classification.Classification, org.featuremapper.models.feature.Feature> delegate = new org.feature.multi.perspective.classification.resource.clt.analysis.CltDefaultResolverDelegate<org.feature.multi.perspective.classification.Classification, org.featuremapper.models.feature.Feature>();
	
	public void resolve(String identifier, org.feature.multi.perspective.classification.Classification container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.feature.multi.perspective.classification.resource.clt.ICltReferenceResolveResult<org.featuremapper.models.feature.Feature> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public String deResolve(org.featuremapper.models.feature.Feature element, org.feature.multi.perspective.classification.Classification container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}

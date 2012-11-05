/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.multi.perspective.classification.resource.clt.analysis;

import org.feature.model.utilities.ResourceUtil;

public class ClassificationModelFeatureModelReferenceResolver implements org.feature.multi.perspective.classification.resource.clt.ICltReferenceResolver<org.feature.multi.perspective.classification.ClassificationModel, org.featuremapper.models.feature.FeatureModel> {
	
	private org.feature.multi.perspective.classification.resource.clt.analysis.CltDefaultResolverDelegate<org.feature.multi.perspective.classification.ClassificationModel, org.featuremapper.models.feature.FeatureModel> delegate = new org.feature.multi.perspective.classification.resource.clt.analysis.CltDefaultResolverDelegate<org.feature.multi.perspective.classification.ClassificationModel, org.featuremapper.models.feature.FeatureModel>();
	
	public void resolve(String identifier, org.feature.multi.perspective.classification.ClassificationModel container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.feature.multi.perspective.classification.resource.clt.ICltReferenceResolveResult<org.featuremapper.models.feature.FeatureModel> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public String deResolve(org.featuremapper.models.feature.FeatureModel element, org.feature.multi.perspective.classification.ClassificationModel container, org.eclipse.emf.ecore.EReference reference) {
	   return ResourceUtil.getRelativeURI(element, container);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}

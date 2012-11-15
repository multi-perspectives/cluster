/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.multi.perspective.classification.resource.clt.analysis;

import org.eclipse.emf.common.util.EList;
import org.feature.multi.perspective.classification.Classification;
import org.feature.multi.perspective.classification.ClassificationModel;

public class ClassificationComposeReferenceResolver implements org.feature.multi.perspective.classification.resource.clt.ICltReferenceResolver<org.feature.multi.perspective.classification.Classification, org.feature.multi.perspective.classification.Classification> {
	
	private org.feature.multi.perspective.classification.resource.clt.analysis.CltDefaultResolverDelegate<org.feature.multi.perspective.classification.Classification, org.feature.multi.perspective.classification.Classification> delegate = new org.feature.multi.perspective.classification.resource.clt.analysis.CltDefaultResolverDelegate<org.feature.multi.perspective.classification.Classification, org.feature.multi.perspective.classification.Classification>();
	
	public void resolve(String identifier, org.feature.multi.perspective.classification.Classification container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.feature.multi.perspective.classification.resource.clt.ICltReferenceResolveResult<org.feature.multi.perspective.classification.Classification> result) {
		ClassificationModel model = (ClassificationModel) container.eContainer();
		EList<Classification> classifications = model.getClassifications();
		for (Classification classification : classifications) {
         if (identifier.equals(classification.getId())){
            result.addMapping(identifier, classification);
            return;
         }
      }
	   delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public String deResolve(org.feature.multi.perspective.classification.Classification element, org.feature.multi.perspective.classification.Classification container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}

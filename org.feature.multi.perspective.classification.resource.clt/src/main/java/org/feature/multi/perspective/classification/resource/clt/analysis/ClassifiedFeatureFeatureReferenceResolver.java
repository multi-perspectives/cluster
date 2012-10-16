/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.multi.perspective.classification.resource.clt.analysis;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.feature.multi.perspective.classification.Classification;
import org.feature.multi.perspective.classification.ClassificationModel;
import org.feature.multi.perspective.classification.ClassifiedFeature;
import org.feature.multi.perspective.mapping.viewmapping.MappingModel;
import org.featuremapper.models.feature.Feature;
import org.featuremapper.models.feature.FeatureModel;

public class ClassifiedFeatureFeatureReferenceResolver implements org.feature.multi.perspective.classification.resource.clt.ICltReferenceResolver<org.feature.multi.perspective.classification.ClassifiedFeature, org.featuremapper.models.feature.Feature> {
	
	private org.feature.multi.perspective.classification.resource.clt.analysis.CltDefaultResolverDelegate<org.feature.multi.perspective.classification.ClassifiedFeature, org.featuremapper.models.feature.Feature> delegate = new org.feature.multi.perspective.classification.resource.clt.analysis.CltDefaultResolverDelegate<org.feature.multi.perspective.classification.ClassifiedFeature, org.featuremapper.models.feature.Feature>();
	
	public void resolve(String identifier, org.feature.multi.perspective.classification.ClassifiedFeature container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.feature.multi.perspective.classification.resource.clt.ICltReferenceResolveResult<org.featuremapper.models.feature.Feature> result) {
	   Feature feature = findElement(identifier, container);
	      if (feature != null) {
	         result.addMapping(identifier, feature);
	      }
	      delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	   }

	   private Feature findElement(String identifier, ClassifiedFeature container) {
	      EObject containingElement = container.eContainer();
	      if (containingElement instanceof Classification) {
	         Classification classification = (Classification) containingElement;
	         EObject model = classification.eContainer();
	         if (model instanceof ClassificationModel) {
	            ClassificationModel classificationModel = (ClassificationModel) model;
	            FeatureModel featureModel = classificationModel.getFeatureModel();
	            if (featureModel == null) {
	               MappingModel viewmapping = classificationModel.getViewMapping();
	               if (viewmapping != null) {
	                  featureModel = viewmapping.getFeatureModel();
	               }
	            }
	            TreeIterator<EObject> eAllContents = featureModel.eAllContents();
	            while (eAllContents.hasNext()) {
	               EObject object = eAllContents.next();
	               if (object instanceof Feature) {
	                  Feature feature = (Feature) object;
	                  String featureId = EcoreUtil.getID(object);
	                  if (identifier.equals(featureId)) {
	                     return feature;
	                  }
	               }
	            }
	         }
	      }
	      return null;
	   }
	
	public String deResolve(org.featuremapper.models.feature.Feature element, org.feature.multi.perspective.classification.ClassifiedFeature container, org.eclipse.emf.ecore.EReference reference) {
		return EcoreUtil.getID(element);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}

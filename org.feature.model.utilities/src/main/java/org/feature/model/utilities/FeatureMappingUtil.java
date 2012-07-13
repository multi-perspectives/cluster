/**
 * 
 */
package org.feature.model.utilities;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.feature.multi.perspective.model.viewmodel.GroupModel;
import org.featuremapper.models.feature.FeatureModel;
import org.featuremapper.models.featuremapping.FeatureMappingModel;
import org.featuremapper.models.featuremapping.FeatureModelRef;
import org.featuremapper.models.featuremapping.SolutionModelRef;

/**
 * Utility class for accessing the featuremapping models.
 * 
 * @author <a href=mailto:info@juliaschroeter.de>Julia Schroeter</a>
 * 
 */
public final class FeatureMappingUtil {
   
   private static Logger log = Logger.getLogger(FeatureModelUtil.class);

   public static FeatureMappingModel getFeatureMapping(IFile featureMapping, ResourceSet resourceSet) {
      FeatureMappingModel mapping = null;
      EObject model = ResourceUtil.getModel(featureMapping, resourceSet);
      if (model instanceof FeatureMappingModel) {
         mapping = (FeatureMappingModel) model;
      }
      return mapping;
   }

   public static FeatureMappingModel getFeatureMapping(Resource resource) {
      FeatureMappingModel featureMappingModel = null;
      if (resource != null) {
         EList<EObject> contents = resource.getContents();
         for (EObject eObject : contents) {
            if (eObject instanceof FeatureMappingModel) {
               featureMappingModel = (FeatureMappingModel) eObject;
               break;
            }
         }
      }
      return featureMappingModel;
   }

   public static FeatureModel getFeatureModel(FeatureMappingModel mapping) {
      FeatureModel result = null;
      if (mapping != null) {
         FeatureModelRef featureModelref = mapping.getFeatureModel();
         if (featureModelref != null) {
            result = featureModelref.getValue();
         }
      }
      return result;
   }

   public static GroupModel getSolutionGroupModel(FeatureMappingModel featureMapping) {
      GroupModel gModel = null;

      if (featureMapping != null) {
         EList<SolutionModelRef> solutionModels = featureMapping.getSolutionModels();
         if (solutionModels.size() > 1){
            log.info("Featuremapping has more than 1 solutionmodel assigned: " + featureMapping);
         }
         for (SolutionModelRef solutionModelRef : solutionModels) {
            EObject solution = solutionModelRef.getValue();
            if (solution instanceof GroupModel) {
               gModel = (GroupModel) solution;
               break;
            }
         }
      }
      return gModel;
   }
}

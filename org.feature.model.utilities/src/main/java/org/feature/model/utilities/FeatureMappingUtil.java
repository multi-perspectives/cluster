/**
 * 
 */
package org.feature.model.utilities;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.feature.multi.perspective.mapping.viewmapping.MappingModel;
import org.feature.multi.perspective.model.viewmodel.GroupModel;
import org.featuremapper.models.feature.FeatureModel;

/**
 * Utility class for accessing the featuremapping models.
 * 
 * @author <a href=mailto:info@juliaschroeter.de>Julia Schroeter</a>
 * 
 */
public final class FeatureMappingUtil {
   

   public static MappingModel getFeatureMapping(IFile featureMapping, ResourceSet resourceSet) {
      MappingModel mapping = null;
      EObject model = ResourceUtil.getModel(featureMapping, resourceSet);
      if (model instanceof MappingModel) {
         mapping = (MappingModel) model;
      }
      return mapping;
   }

   public static MappingModel getFeatureMapping(Resource resource) {
      MappingModel featureMappingModel = null;
      if (resource != null) {
         EList<EObject> contents = resource.getContents();
         for (EObject eObject : contents) {
            if (eObject instanceof MappingModel) {
               featureMappingModel = (MappingModel) eObject;
               break;
            }
         }
      }
      return featureMappingModel;
   }

   public static FeatureModel getFeatureModel(MappingModel mapping) {
      FeatureModel result = null;
      if (mapping != null) {
         result = mapping.getFeatureModel();
      }
      return result;
   }

   public static GroupModel getSolutionGroupModel(MappingModel featureMapping) {
      GroupModel gModel = null;
      if (featureMapping != null) {
         gModel = featureMapping.getViewModel();
      }
      return gModel;
   }
}

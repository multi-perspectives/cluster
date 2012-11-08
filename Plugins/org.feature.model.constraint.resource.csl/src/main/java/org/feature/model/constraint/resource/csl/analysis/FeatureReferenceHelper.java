/**
 * 
 */
package org.feature.model.constraint.resource.csl.analysis;

import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.feature.model.constraint.FeatureExpression;
import org.feature.model.utilities.FeatureModelUtil;
import org.featuremapper.models.feature.Feature;
import org.featuremapper.models.feature.FeatureModel;

/**
 * @author <a href=mailto:julia.schroeter@tu-dresden.de>Julia Schroeter</a>
 * 
 */
public final class FeatureReferenceHelper {

   public static Feature getFeature(String identifier, FeatureExpression container) {
      Feature result = null;
      URI featureModelResource = container.eResource().getURI().trimFileExtension().trimFileExtension();
      featureModelResource = featureModelResource.appendFileExtension("feature");
      Resource resource = container.eResource().getResourceSet().getResource(featureModelResource, true);
      if (resource != null && resource.getContents().size() == 1 && resource.getContents().get(0) instanceof FeatureModel) {
         FeatureModel fm = (FeatureModel) resource.getContents().get(0);
         List<Feature> allFeatures = FeatureModelUtil.getAllFeatures(fm);
         for (Feature feature : allFeatures) {
            String id = EcoreUtil.getID(feature);
            if (id.equals(identifier)) {
               result = feature;
               break;
            }
         }
      }
      return result;
   }

}

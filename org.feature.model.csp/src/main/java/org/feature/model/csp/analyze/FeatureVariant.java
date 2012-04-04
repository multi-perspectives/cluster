/**
 * 
 */
package org.feature.model.csp.analyze;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.feature.model.utilities.FeatureModelUtil;
import org.featuremapper.models.feature.Attribute;
import org.featuremapper.models.feature.Feature;

/**
 * A variant feature configuration.
 * 
 * @author <a href="mailto:info@juliaschroeter.de">Julia Schroeter</a>
 * 
 */
public class FeatureVariant {

   List<Feature> features = new ArrayList<Feature>();

   public void addFeature(Feature feature) {
      features.add(feature);
   }

   public boolean containsFeature(Feature feature){
      return features.contains(feature);
   }
   
   
   public List<Feature> getFeatures(){
      return features;
   }
   
   public int getFeatureCount() {
      return features.size();
   }

   public String toString() {
      StringBuffer buffer = new StringBuffer();
      for (Feature feature : features) {
         if (buffer.length() > 0) {
            buffer.append(", ");
         }
         String name = feature.getName();
         if (!StringUtils.isEmpty(name)){
            buffer.append(name);
         }
         buffer.append("(");
         String featureId = EcoreUtil.getID(feature);
         buffer.append(featureId);
         buffer.append(")");
         String featureCardinality = getFeatureCardinality(feature);
         buffer.append("[" + featureCardinality + "]");
      }
      return buffer.toString();
   }

   private String getFeatureCardinality(Feature feature) {
      String cardinality = "";
      Attribute attribute = FeatureModelUtil.getAttribute(feature, FeatureModelUtil.attribute_cardinality);
      if (attribute != null) {
         cardinality = attribute.getValue();
      }
      return cardinality;
   }

}

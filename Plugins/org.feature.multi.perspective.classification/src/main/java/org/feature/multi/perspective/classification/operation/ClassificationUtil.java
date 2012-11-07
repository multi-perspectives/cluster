/**
 * 
 */
package org.feature.multi.perspective.classification.operation;

import org.feature.multi.perspective.classification.ClassificationFactory;
import org.feature.multi.perspective.classification.ClassifiedFeature;
import org.feature.multi.perspective.classification.Classifier;
import org.featuremapper.models.feature.Feature;

/**
 * Utility class to access classifications.
 * 
 * @author <a href=mailto:julia.schroeter@tu-dresden.de>Julia Schroeter</a>
 * 
 */
public final class ClassificationUtil {

   /**
    * create a classified Feature.
    * 
    * @param feature
    * @return
    */
   public static ClassifiedFeature createClassifiedFeature(Feature feature, Classifier classifier) {
      ClassifiedFeature classifiedFeature = ClassificationFactory.eINSTANCE.createClassifiedFeature();
      classifiedFeature.setClassified(classifier);
      return classifiedFeature;
   }

   /**
    * create an alive feature.
    * 
    * @param feature
    * @return
    */
   public static ClassifiedFeature createAliveFeature(Feature feature) {
      return createClassifiedFeature(feature, Classifier.ALIVE);
   }

   /**
    * create a dead feature.
    * 
    * @param feature
    * @return
    */
   public static ClassifiedFeature createDeadFeature(Feature feature) {
      return createClassifiedFeature(feature, Classifier.DEAD);
   }

   /**
    * create an unbound feature.
    * 
    * @param feature
    * @return
    */
   public static ClassifiedFeature createUnboundFeature(Feature feature) {
      return createClassifiedFeature(feature, Classifier.UNBOUND);
   }

}

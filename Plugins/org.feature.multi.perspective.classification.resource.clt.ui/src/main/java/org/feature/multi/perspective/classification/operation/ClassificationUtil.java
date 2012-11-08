/**
 * 
 */
package org.feature.multi.perspective.classification.operation;

import org.eclipse.emf.common.util.EList;
import org.feature.multi.perspective.classification.Classification;
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
    * create an initially unclassified Feature.
    * 
    * @param feature
    * @return
    */
   public static ClassifiedFeature createClassifiedFeature(Feature feature) {
      return createClassifiedFeature(feature, Classifier.UNCLASSIFIED);
   }

   /**
    * create a classified Feature.
    * 
    * @param feature
    * @return
    */
   public static ClassifiedFeature createClassifiedFeature(Feature feature, Classifier classifier) {
      ClassifiedFeature classifiedFeature = ClassificationFactory.eINSTANCE.createClassifiedFeature();
      classifiedFeature.setFeature(feature);
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

   /**
    * refines the classifier of the given classified feature only, if is is allowed. If it is the same classifier then
    * do nothing.
    * 
    * @param classifiedFeature
    * @param newClassifier
    * @return
    */
   public static boolean changeClassifier(ClassifiedFeature classifiedFeature, Classifier newClassifier) {
      Classifier oldClassifier = classifiedFeature.getClassified();
      boolean isAllowed = isChangeAllowed(oldClassifier, newClassifier);
      if (isAllowed) {
         classifiedFeature.setClassified(newClassifier);
      }
      return isAllowed;
   }

   public static boolean isChangeAllowed(Classifier oldClassifier, Classifier newClassifier) {
      boolean isAllowed = false;

      if (oldClassifier.equals(newClassifier)) {
         isAllowed = true;
      } else if (Classifier.UNCLASSIFIED.equals(oldClassifier)) {
         // unclassified can be changed to unbound, alive and dead
         isAllowed = true;
      } else if (Classifier.UNBOUND.equals(oldClassifier) && !Classifier.UNCLASSIFIED.equals(newClassifier)) {
         // unbound can be changed to alive and dead
         isAllowed = true;
      }
      // alive and dead can not be refined further
      return isAllowed;
   }

   public static void cleanUpFeatureReference(Feature feature, Classification classification) {
      EList<Feature> deadFeatures = classification.getDeadFeatures();
      deadFeatures.remove(feature);
      EList<Feature> unboundFeatures = classification.getUnboundFeatures();
      unboundFeatures.remove(feature);
      EList<Feature> aliveFeatures = classification.getAliveFeatures();
      aliveFeatures.remove(feature);
   }

}

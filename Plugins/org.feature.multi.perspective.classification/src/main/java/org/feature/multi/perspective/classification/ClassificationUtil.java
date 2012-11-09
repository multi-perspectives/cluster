/**
 * 
 */
package org.feature.multi.perspective.classification;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.feature.model.constraint.FeatureExpression;
import org.feature.multi.perspective.view.View;
import org.featuremapper.models.feature.Feature;
import org.featuremapper.models.feature.Group;

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

   public static ClassifiedFeature createdClassifiedFeature(Classification classification, Feature feature) {
      ClassifiedFeature classifiedFeature = createClassifiedFeature(feature);
      addClassifiedFeature(classification, classifiedFeature);
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

      if (!oldClassifier.equals(newClassifier)) {
         if (Classifier.UNCLASSIFIED.equals(oldClassifier)) {
            // unclassified can be changed to unbound, alive and dead
            isAllowed = true;
         } else if (Classifier.UNBOUND.equals(oldClassifier) && !Classifier.UNCLASSIFIED.equals(newClassifier)) {
            // unbound can be changed to alive and dead
            isAllowed = true;
         }
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

   /**
    * get the classifiedfeature.
    * 
    * @param classification
    * @param feature
    * @return
    */
   public static ClassifiedFeature getClassifiedFeature(Classification classification, Feature feature) {
      boolean isContained = ClassificationCache.getInstance().isFeatureContainedInView(classification, feature);
      return getClassifiedFeature(classification, feature, isContained);
   }

   /**
    * get the classified feature.
    * 
    * @param classification
    * @param feature
    * @param containedInView
    * @return
    */
   public static ClassifiedFeature getClassifiedFeature(Classification classification, Feature feature, boolean containedInView) {
      ClassifiedFeature result = null;
      EList<ClassifiedFeature> classifiedFeatures;
      if (containedInView) {
         classifiedFeatures = classification.getClassifiedFeatures();
      } else {
         classifiedFeatures = classification.getAutoCompleteFeatures();
      }

      for (ClassifiedFeature classifiedFeature : classifiedFeatures) {
         Feature classifiedReference = classifiedFeature.getFeature();
         if (EcoreUtil.equals(feature, classifiedReference)) {
            result = classifiedFeature;
            break;
         }
      }
      return result;
   }

   /**
    * add the given classified feature to the classification. beware the method does not check for uniqueness of the
    * classified feature!
    * 
    * @param classification
    * @param classifiedFeature
    */
   public static void addClassifiedFeature(Classification classification, ClassifiedFeature classifiedFeature) {
      Feature feature = classifiedFeature.getFeature();
      boolean containedInView = ClassificationCache.getInstance().isFeatureContainedInView(classification, feature);
      if (containedInView) {
         classification.getClassifiedFeatures().add(classifiedFeature);
      } else {
         classification.getAutoCompleteFeatures().add(classifiedFeature);
      }
   }

   /**
    * get all the feature classifications contained in the given feature group.
    * 
    * @param group
    * @param classification
    * @return
    */
   public static List<ClassifiedFeature> getClassifiedFeaturesOfGroup(Group group, Classification classification) {
      // consider only classified features of the according view
      EList<Feature> childFeatures = group.getChildFeatures();
      List<ClassifiedFeature> result = new ArrayList<>(childFeatures.size());
      for (Feature feature : childFeatures) {
         ClassifiedFeature classifiedFeature = getClassifiedFeature(classification, feature);
         if (classifiedFeature != null) {
            result.add(classifiedFeature);
         }
      }
      return result;
   }

   /**
    * get all the features assigned to the view as classified features.
    * 
    * @param classification
    * @return
    */
   public static List<ClassifiedFeature> getAllClassifiedFeaturesOfView(Classification classification) {
      View view = ClassificationCache.getInstance().getView(classification);
      EList<Feature> features = view.getFeatures();
      for (Feature feature : features) {
         getOrCreateClassifiedFeature(classification, feature);
      }
      return classification.getClassifiedFeatures();
   }

   public static ClassifiedFeature getOrCreateClassifiedFeature(Classification classification, Feature feature) {
      ClassifiedFeature classifiedFeature = ClassificationUtil.getClassifiedFeature(classification, feature);
      if (classifiedFeature == null) {
         classifiedFeature = ClassificationUtil.createdClassifiedFeature(classification, feature);
      }
      return classifiedFeature;
   }

   public static List<FeatureExpression> getConstraintsContainingFeature(ClassifiedFeature classifiedFeature) {
      List<FeatureExpression> constraints = ClassificationCache.getInstance().getConstraints(classifiedFeature);
      Feature feature = classifiedFeature.getFeature();
      for (FeatureExpression featureExpression : constraints) {
         if (containsFeature(featureExpression, feature)) {
            constraints.add(featureExpression);
         }
      }
      return constraints;
   }

   private static boolean containsFeature(FeatureExpression expression, Feature feature) {
      Feature leftFeature = expression.getLeftFeature();
      Feature rightFeature = expression.getRightFeature();
      boolean isContained = (EcoreUtil.equals(leftFeature, feature) || EcoreUtil.equals(rightFeature, feature));
      return isContained;

   }
}

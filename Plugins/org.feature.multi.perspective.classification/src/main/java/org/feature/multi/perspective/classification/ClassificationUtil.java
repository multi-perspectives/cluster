/**
 * 
 */
package org.feature.multi.perspective.classification;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.feature.model.constraint.FeatureExpression;
import org.feature.multi.perspective.classification.impl.ClassificationFactoryImpl;
import org.feature.multi.perspective.model.viewmodel.AbstractGroup;
import org.feature.multi.perspective.model.viewmodel.impl.ViewmodelFactoryImpl;
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
   
   /**
    * refines the classifier of the given classified feature only, if is is allowed. If it is the same classifier then
    * do nothing.
    * 
    * @param classifiedFeature
    * @param newClassifier
    * @param classification classification that has to be adapted to the new classifier
    * @return
    */
   public static boolean changeClassifier(ClassifiedFeature classifiedFeature, Classifier newClassifier, Classification classification) {
	   if(changeClassifier(classifiedFeature, newClassifier))
	   {
		   if(newClassifier == Classifier.ALIVE)
		   {
			   classification.getAliveFeatures().add(classifiedFeature.getFeature());
			   classification.getDeadFeatures().remove(classifiedFeature.getFeature());
			   classification.getUnboundFeatures().remove(classifiedFeature.getFeature());		   
		   }
		   else if(newClassifier == Classifier.DEAD)
		   {
			   classification.getAliveFeatures().remove(classifiedFeature.getFeature());
			   classification.getDeadFeatures().add(classifiedFeature.getFeature());
			   classification.getUnboundFeatures().add(classifiedFeature.getFeature());
		   }
		   else if(newClassifier == Classifier.UNBOUND)
		   {
			   classification.getAliveFeatures().remove(classifiedFeature.getFeature());
			   classification.getDeadFeatures().remove(classifiedFeature.getFeature());
			   classification.getUnboundFeatures().add(classifiedFeature.getFeature());
		   }
		   return true;
	   }
	   else
		   return false;
      
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

   /**
    * get the classifiedfeature.
    * 
    * @param classification
    * @param feature
    * @return
    */
   public static ClassifiedFeature getClassifiedFeature(Classification classification, Feature feature) {
      boolean isContained = ClassificationCache.getInstance().isFeatureContainedInAnyViews(classification, feature);
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
      boolean containedInView = ClassificationCache.getInstance().isFeatureContainedInAnyViews(classification, feature);
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
   public static List<ClassifiedFeature> getFeaturesOfGroup(Group group, Classification classification, boolean onlyContainedInView) {
      // consider only classified features of the according view
      EList<Feature> childFeatures = group.getChildFeatures();
      List<ClassifiedFeature> result = new ArrayList<>(childFeatures.size());
      for (Feature feature : childFeatures) {
         ClassifiedFeature classifiedFeature = getClassifiedFeature(classification, feature);
         if (onlyContainedInView) {
            if (classifiedFeature != null) {
               result.add(classifiedFeature);
            }
         } else {
            if (classifiedFeature == null) {
               classifiedFeature = getOrCreateClassifiedFeature(classification, feature);
               if (classifiedFeature != null){
                  result.add(classifiedFeature);
               }
            }
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
      List<FeatureExpression> contained = new ArrayList<FeatureExpression>();
      Set<FeatureExpression> constraints = ClassificationCache.getInstance().getConstraints(classifiedFeature);
      Feature feature = classifiedFeature.getFeature();
      for (FeatureExpression featureExpression : constraints) {
         if (containsFeature(featureExpression, feature)) {
            contained.add(featureExpression);
         }
      }
      return contained;
   }

   private static boolean containsFeature(FeatureExpression expression, Feature feature) {
      Feature leftFeature = expression.getLeftFeature();
      Feature rightFeature = expression.getRightFeature();
      boolean isContained = (EcoreUtil.equals(leftFeature, feature) || EcoreUtil.equals(rightFeature, feature));
      return isContained;

   }
   
   public static Classification composition(Classification stage1, Classification stage2){
	   //Union both classifications and compose intersecting feature-classifications
	   Classification composedClassification = ClassificationFactoryImpl.eINSTANCE.createClassification();
	   
	   //TODO:Wie View-Gruppen aus den Classifications zuordnen?
	   
	   composedClassification.getViewgroups().addAll(stage1.getViewgroups());
	   composedClassification.getViewgroups().addAll(stage2.getViewgroups());
	   
	   HashMap<Feature, Set<ClassifiedFeature>> featureToClassifications = new HashMap<Feature, Set<ClassifiedFeature>>();
	   

	   for(ClassifiedFeature c: stage1.getClassifiedFeatures()) {
		   if(!featureToClassifications.containsKey(c.getFeature())) {
			   HashSet<ClassifiedFeature> listOfFeatures = new HashSet<ClassifiedFeature>();
			   listOfFeatures.add(c);
		   }
		   else
			   featureToClassifications.get(c.getFeature()).add(c);			   
	   }
	   
	   for(ClassifiedFeature c: stage2.getClassifiedFeatures()) {
		   if(!featureToClassifications.containsKey(c.getFeature())) {
			   HashSet<ClassifiedFeature> listOfFeatures = new HashSet<ClassifiedFeature>();
			   listOfFeatures.add(c);
		   }
		   else
			   featureToClassifications.get(c.getFeature()).add(c);			   
	   }

	   for(Feature f : featureToClassifications.keySet()) {
		   Set<ClassifiedFeature> classifications = featureToClassifications.get(f);
		   addClassifiedFeature(composedClassification, composeSetOfClassifiedFeatures(classifications));
	   }
	   
	   return composedClassification;
   }
   
   private static ClassifiedFeature composeSetOfClassifiedFeatures (Set<ClassifiedFeature> classifications) {
	   ClassifiedFeature feature = null;
	   
	   for(ClassifiedFeature f : classifications) {
		   Classifier classifier = composeClassifiedFeatures(feature, f);
		   if(feature == null) {
			   feature = createClassifiedFeature(f.getFeature(), classifier);
		   }		  
		   changeClassifier(feature, classifier);
	   }
	   
	   return feature;
   }
   
   private static Classifier composeClassifiedFeatures(ClassifiedFeature feature1, ClassifiedFeature feature2){
	   
	   if(feature1 == null && feature2 != null )
		   return feature2.getClassified();
	   else if(feature1 != null && feature2 == null )
		   return feature1.getClassified();
	   else if(feature1 == null && feature2 == null )
		   return null;
	   
	   //Same Classification
	   if(feature1.getClassified() == feature2.getClassified())
		   return feature1.getClassified();
	   //Contradiction Classifications
	   else if(feature1.getClassified().equals(Classifier.ALIVE) && feature1.getClassified().equals(Classifier.DEAD))
		   return null;
	   else if(feature1.getClassified().equals(Classifier.DEAD) && feature1.getClassified().equals(Classifier.ALIVE))
		   return null;
	   
	   //Unbound gets overitten by ALIVE and DEAD
	   else if(feature1.getClassified().equals(Classifier.UNBOUND) && feature1.getClassified().equals(Classifier.ALIVE))
		   return Classifier.ALIVE;
	   else if(feature1.getClassified().equals(Classifier.ALIVE) && feature1.getClassified().equals(Classifier.UNBOUND))
		   return Classifier.ALIVE;
	   else if(feature1.getClassified().equals(Classifier.UNBOUND) && feature1.getClassified().equals(Classifier.DEAD))
		   return Classifier.DEAD;
	   else if(feature1.getClassified().equals(Classifier.DEAD) && feature1.getClassified().equals(Classifier.UNBOUND))
		   return Classifier.DEAD;
	   
	 //Unbound gets overitten by ALIVE and DEAD and UNBOUND
	   else if(feature1.getClassified().equals(Classifier.UNCLASSIFIED) && feature1.getClassified().equals(Classifier.ALIVE))
		   return Classifier.ALIVE;
	   else if(feature1.getClassified().equals(Classifier.ALIVE) && feature1.getClassified().equals(Classifier.UNCLASSIFIED))
		   return Classifier.ALIVE;
	   else if(feature1.getClassified().equals(Classifier.UNCLASSIFIED) && feature1.getClassified().equals(Classifier.DEAD))
		   return Classifier.DEAD;
	   else if(feature1.getClassified().equals(Classifier.DEAD) && feature1.getClassified().equals(Classifier.UNCLASSIFIED))
		   return Classifier.DEAD;
	   else if(feature1.getClassified().equals(Classifier.UNCLASSIFIED) && feature1.getClassified().equals(Classifier.UNBOUND))
		   return Classifier.UNBOUND;
	   else if(feature1.getClassified().equals(Classifier.UNBOUND) && feature1.getClassified().equals(Classifier.UNCLASSIFIED))
		   return Classifier.UNBOUND;
	   
	   else 
		   return null;
	   
   }
}

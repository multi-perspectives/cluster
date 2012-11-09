package org.feature.multi.perspective.classification;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.feature.model.constraint.Exclude;
import org.feature.model.constraint.FeatureExpression;
import org.feature.model.constraint.Require;
import org.feature.model.utilities.FeatureModelUtil;
import org.featuremapper.models.feature.Feature;
import org.featuremapper.models.feature.Group;

/**
 * Handles the classification of stages.
 * 
 * @author <a href="mailto:julia.schroeter@tu-dresden.de">Julia Schroeter</a>
 * 
 */
public class AutoClassification {

   ClassificationModel classificationModel;

   // cache checked feature model groups per classification
   // cache checked features per classification

   public AutoClassification(ClassificationModel classificationModel) {
      this.classificationModel = classificationModel;
   }

   public void autoComplete() {
      EList<Classification> classifications = classificationModel.getClassifications();
      for (Classification classification : classifications) {
         autoComplete(classification);
      }
   }

   private void wipeOutOldAutoCompletions(Classification classification) {
      classification.getAutoCompleteFeatures().clear();
   }

   private void autoComplete(Classification classification) {
      wipeOutOldAutoCompletions(classification);

      List<ClassifiedFeature> classifiedFeatures = initClassificationFeatures(classification);
      int size = classifiedFeatures.size();
      List<ClassifiedFeature> featureCopy = new ArrayList<ClassifiedFeature>(size);
      featureCopy.addAll(classifiedFeatures);

      for (ClassifiedFeature classifiedFeature : featureCopy) {
         autoCompleteClassifiedFeature(classifiedFeature);
      }
   }

   private List<ClassifiedFeature> initClassificationFeatures(Classification classification){
      return ClassificationUtil.getAllClassifiedFeaturesOfView(classification);
   }
   
   private void autoCompleteClassifiedFeature(ClassifiedFeature classifiedFeature) {
      Classifier classified = classifiedFeature.getClassified();
      if (Classifier.ALIVE.equals(classified)) {
         handleAliveFeature(classifiedFeature);
      } else if (Classifier.DEAD.equals(classified)) {
         handleDeadFeature(classifiedFeature);
      } else if (Classifier.UNBOUND.equals(classified)) {
         handleUnboundFeature(classifiedFeature);
      } else if (Classifier.UNCLASSIFIED.equals(classified)) {
         handleUnclassifiedFeature(classifiedFeature);
      }
   }

   private void handleUnclassifiedFeature(ClassifiedFeature classifiedFeature) {
      // set feature undbound and handle it as unboundfeature
      classifiedFeature.setClassified(Classifier.UNBOUND);
      handleUnboundFeature(classifiedFeature);
   }

   private void handleUnboundFeature(ClassifiedFeature classifiedFeature) {
      setParentFeaturesUnbound(classifiedFeature);
   }

   private void handleDeadFeature(ClassifiedFeature classifiedFeature) {
      // TODO Auto-generated method stub
   }

   private void handleAliveFeature(ClassifiedFeature classifiedFeature) {
      // TODO select parent features
      setParentFeaturesAlive(classifiedFeature);
      // TODO select constraint requires edge features
      // TODO select group cardinality sibling features
      checkSiblings(classifiedFeature);
      // if eContainer is null, then this is the root feature
      // otherwise select parent features
      checkConstraintsForAliveFeature(classifiedFeature);
   }

   private void checkConstraintsForAliveFeature(ClassifiedFeature classifiedFeature) {
      Feature feature = classifiedFeature.getFeature();
      Classification classification = (Classification)classifiedFeature.eContainer();
      List<FeatureExpression> constraintsContainingFeature = ClassificationUtil.getConstraintsContainingFeature(classifiedFeature);
      for (FeatureExpression featureExpression : constraintsContainingFeature) {
         if (featureExpression instanceof Require) {
            Require require = (Require) featureExpression;
            Feature leftFeature = require.getLeftFeature();
            if (EcoreUtil.equals(leftFeature, feature)){
               // all required features must be set alive
               Feature rightFeature = require.getRightFeature();
               handleAutoCompleteFeature(rightFeature, Classifier.ALIVE, classification);
            }
         } else if (featureExpression instanceof Exclude) {
            //    all excluded features must be set to dead 
            Exclude exclude = (Exclude) featureExpression;
            Feature excludedfeature = getExcludedFeature(exclude, feature);
            handleAutoCompleteFeature(excludedfeature, Classifier.DEAD, classification);
         }
      }
   }

   private Feature getExcludedFeature(Exclude exclude, Feature feature){
     Feature result;
      Feature leftFeature = exclude.getLeftFeature();
      Feature rightFeature = exclude.getRightFeature();
      if (EcoreUtil.equals(leftFeature, feature)){
         result = rightFeature;
      } else {
         result = leftFeature;
      }
      return result;
   }
   
   private void handleAutoCompleteFeature(Feature feature, Classifier newClassifier, Classification classification){
      ClassifiedFeature classifiedFeature = ClassificationUtil.getOrCreateClassifiedFeature(classification, feature);
      ClassificationUtil.changeClassifier(classifiedFeature,newClassifier);
      handleChangedFeature(classifiedFeature);
   }
   
   private void handleChangedFeature(ClassifiedFeature classifiedFeature){
      // autoCompleteClassifiedFeature(classifiedFeature);
   }
   
   private void checkSiblings(ClassifiedFeature classifiedFeature) {
      Feature feature = classifiedFeature.getFeature();
      Classification classification = (Classification) classifiedFeature.eContainer();
      Group parentGroup = feature.getParentGroup();
      // if parent group is null, than this is the root feature and nothing need to be done.
      if (parentGroup != null) {
         int minCardinality = parentGroup.getMinCardinality();
         int maxCardinality = parentGroup.getMaxCardinality();

         List<ClassifiedFeature> allSiblingFeatures = ClassificationUtil.getClassifiedFeaturesOfGroup(parentGroup, classification);
         List<ClassifiedFeature> siblingsCopy = new ArrayList<ClassifiedFeature>();
         siblingsCopy.addAll(allSiblingFeatures);

         List<ClassifiedFeature> aliveSiblings = filterClassifiedFeatures(siblingsCopy, Classifier.ALIVE);
         siblingsCopy.removeAll(aliveSiblings);
         List<ClassifiedFeature> deadSiblings = filterClassifiedFeatures(siblingsCopy, Classifier.DEAD);
         siblingsCopy.removeAll(deadSiblings);

         int sizeAlive = aliveSiblings.size();
         int sizeUnboundOrAlive = sizeAlive + siblingsCopy.size();
         
         if (sizeAlive == maxCardinality) {
            // maximum reached, set unbound features dead
            for (ClassifiedFeature sibling : siblingsCopy) {
               ClassificationUtil.changeClassifier(sibling, Classifier.DEAD);
               handleChangedFeature(sibling);
            }
         }

         if (sizeUnboundOrAlive < minCardinality) {
            // TODO the minimum number of selected features cannot be reached
            // consider more features, that are not yet contained in the classification
         }
         if (sizeAlive > maxCardinality) {
            // TODO the maximum number of selected features is exceeded
         }

      }
   }

   private List<ClassifiedFeature> filterClassifiedFeatures(List<ClassifiedFeature> features, Classifier filter) {
      List<ClassifiedFeature> filteredList = new ArrayList<ClassifiedFeature>();
      for (ClassifiedFeature classifiedFeature : features) {
         Classifier classified = classifiedFeature.getClassified();
         if (filter.equals(classified)) {
            filteredList.add(classifiedFeature);
         }
      }
      return filteredList;
   }

   private void setParentFeatures(ClassifiedFeature classifiedFeature, Classifier newClassifier) {
      // if eContainer is null, then this is the root feature
      // otherwise select parent features recursively
      Feature childFeature = classifiedFeature.getFeature();
      List<Feature> anchestors = FeatureModelUtil.getAllAchestorFeatures(childFeature);

      Classification classification = (Classification) classifiedFeature.eContainer();
      // set each anchestor alive
      for (Feature feature : anchestors) {
         // check if the parent features are contained in the view and therefore can be configured manually
         ClassifiedFeature parentClassifiedFeature = ClassificationUtil.getOrCreateClassifiedFeature(classification, feature);

         boolean changed = ClassificationUtil.changeClassifier(parentClassifiedFeature, newClassifier);
         if (!changed) {
            System.out.println("Classifier not changed to " + newClassifier.getName() + " of Feature '"
                               + parentClassifiedFeature.getFeature().getName() + "'. Is: "
                               + parentClassifiedFeature.getClassified().getName());
            // TODO set error marker on classifiedFeature
            // "Autocompletion Error: Could not change classification of parent feature feature.getName()"
         }
      }
   }

  

   private void setParentFeaturesAlive(ClassifiedFeature classifiedFeature) {
      setParentFeatures(classifiedFeature, Classifier.ALIVE);
   }

   private void setParentFeaturesUnbound(ClassifiedFeature classifiedFeature) {
      // parent features need to be alive or unbound
      setParentFeatures(classifiedFeature, Classifier.UNBOUND);
   }

}

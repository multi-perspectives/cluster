package org.feature.multi.perspective.classification;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
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

   List<ChangeFeature> featuresToComplete = new ArrayList<ChangeFeature>();

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
      // autocomplete cached features
      handleChangeFeatures();
   }

   private List<ClassifiedFeature> initClassificationFeatures(Classification classification) {
      return ClassificationUtil.getAllClassifiedFeaturesOfView(classification);
   }

   private void autoCompleteClassifiedFeature(ClassifiedFeature classifiedFeature) {
      Classifier classified = classifiedFeature.getClassified();
      if (Classifier.ALIVE.equals(classified)) {
         handleAliveFeature(classifiedFeature);
      } else if (Classifier.DEAD.equals(classified)) {
         handleDeadFeature(classifiedFeature);
      } else if (Classifier.UNCLASSIFIED.equals(classified)) {
         handleUnclassifiedFeature(classifiedFeature);
      } else if (Classifier.UNBOUND.equals(classified)) {
         handleUnboundFeature(classifiedFeature);
      }
   }

   private void handleUnclassifiedFeature(ClassifiedFeature classifiedFeature) {
      // set feature undbound and handle it as unboundfeature
      classifiedFeature.setClassified(Classifier.UNBOUND);
      handleUnboundFeature(classifiedFeature);
   }

   private void handleUnboundFeature(ClassifiedFeature classifiedFeature) {
      // set parents unbound
      setParentFeatures(classifiedFeature, Classifier.UNBOUND);
   }

   private void handleAliveFeature(ClassifiedFeature classifiedFeature) {
      // select parent features
      setParentFeatures(classifiedFeature, Classifier.ALIVE);
      // check children
      checkChildren(classifiedFeature);
      // select group cardinality sibling features
      checkSiblings(classifiedFeature);
      // check Constraints
      checkConstraintsForAliveFeature(classifiedFeature);
   }

   private void handleDeadFeature(ClassifiedFeature classifiedFeature) {
      // set children dead
      setChildFeaturesDead(classifiedFeature, Classifier.DEAD);
      // set features that require this feature dead
      checkConstraintsForDeadFeature(classifiedFeature);
   }

   private void checkConstraintsForDeadFeature(ClassifiedFeature classifiedFeature) {
      Feature feature = classifiedFeature.getFeature();
      Classification classification = (Classification) classifiedFeature.eContainer();
      List<FeatureExpression> constraintsContainingFeature = ClassificationUtil.getConstraintsContainingFeature(classifiedFeature);
      for (FeatureExpression featureExpression : constraintsContainingFeature) {
         if (featureExpression instanceof Require) {
            Require require = (Require) featureExpression;
            Feature rightFeature = require.getRightFeature();
            if (EcoreUtil.equals(rightFeature, feature)) {
               // all features that require this feature must be set dead
               Feature leftFeature = require.getRightFeature();
               handleAutoCompleteFeature(leftFeature, Classifier.DEAD, classification);
            }
         }
      }

   }

   private void checkChildren(ClassifiedFeature classifiedFeature) {
      EList<Group> groups = classifiedFeature.getFeature().getGroups();
      Classification classification = (Classification) classifiedFeature.eContainer();
      for (Group group : groups) {
         checkChildren(group, classification);
      }
   }

   private void checkConstraintsForAliveFeature(ClassifiedFeature classifiedFeature) {
      Feature feature = classifiedFeature.getFeature();
      Classification classification = (Classification) classifiedFeature.eContainer();
      List<FeatureExpression> constraintsContainingFeature = ClassificationUtil.getConstraintsContainingFeature(classifiedFeature);
      for (FeatureExpression featureExpression : constraintsContainingFeature) {
         if (featureExpression instanceof Require) {
            Require require = (Require) featureExpression;
            Feature leftFeature = require.getLeftFeature();
            if (EcoreUtil.equals(leftFeature, feature)) {
               // all required features must be set alive
               Feature rightFeature = require.getRightFeature();
               handleAutoCompleteFeature(rightFeature, Classifier.ALIVE, classification);
            }
         } else if (featureExpression instanceof Exclude) {
            // all excluded features must be set to dead
            Exclude exclude = (Exclude) featureExpression;
            Feature excludedfeature = getExcludedFeature(exclude, feature);
            handleAutoCompleteFeature(excludedfeature, Classifier.DEAD, classification);
         }
      }
   }

   private Feature getExcludedFeature(Exclude exclude, Feature feature) {
      Feature result;
      Feature leftFeature = exclude.getLeftFeature();
      Feature rightFeature = exclude.getRightFeature();
      if (EcoreUtil.equals(leftFeature, feature)) {
         result = rightFeature;
      } else {
         result = leftFeature;
      }
      return result;
   }

   private void handleAutoCompleteFeature(Feature feature, Classifier newClassifier, Classification classification) {
      ClassifiedFeature classifiedFeature = ClassificationUtil.getOrCreateClassifiedFeature(classification, feature);
      handleAutoCompleteFeature(classifiedFeature, newClassifier);
   }

   private void handleAutoCompleteFeature(ClassifiedFeature classifiedFeature, Classifier newClassifier) {
      ChangeFeature change = new ChangeFeature(classifiedFeature, newClassifier);
      featuresToComplete.add(change);
   }

   private void handleChangeFeatures() {
      do {
         List<ChangeFeature> copy = new ArrayList<ChangeFeature>();
         copy.addAll(featuresToComplete);
         for (ChangeFeature changeFeature : copy) {
            handleChangeFeature(changeFeature);
         }
         featuresToComplete.removeAll(copy);
      }
      while (featuresToComplete.size() > 0);
   }

   private void handleChangeFeature(ChangeFeature changeFeature) {
      ClassifiedFeature feature = changeFeature.getFeature();
      Classifier newClassifier = changeFeature.getNewClassifier();
      boolean isChanged = ClassificationUtil.changeClassifier(feature, newClassifier);
      if (isChanged) {
         autoCompleteClassifiedFeature(feature);
      }
   }

   private void checkSiblings(ClassifiedFeature classifiedFeature) {
      Feature feature = classifiedFeature.getFeature();
      Classification classification = (Classification) classifiedFeature.eContainer();
      Group parentGroup = feature.getParentGroup();
      // if parent group is null, than this is the root feature and nothing need to be done.
      checkChildren(parentGroup, classification);
   }

   private void checkChildren(Group parentGroup, Classification classification) {
      if (parentGroup != null) {
         int minCardinality = parentGroup.getMinCardinality();
         int maxCardinality = parentGroup.getMaxCardinality();

         List<ClassifiedFeature> siblingClassificationFeatures = ClassificationUtil.getFeaturesOfGroup(parentGroup, classification, true);
         List<ClassifiedFeature> siblingsCopy = new ArrayList<ClassifiedFeature>();
         siblingsCopy.addAll(siblingClassificationFeatures);

         List<ClassifiedFeature> aliveSiblings = filterClassifiedFeatures(siblingsCopy, Classifier.ALIVE);
         siblingsCopy.removeAll(aliveSiblings);
         List<ClassifiedFeature> deadSiblings = filterClassifiedFeatures(siblingsCopy, Classifier.DEAD);
         siblingsCopy.removeAll(deadSiblings);

         int sizeAlive = aliveSiblings.size();
         int sizeUnboundOrAlive = sizeAlive + siblingsCopy.size();

         if (sizeAlive == maxCardinality) {
            // maximum reached, set unbound features dead
            for (ClassifiedFeature sibling : siblingsCopy) {
               handleAutoCompleteFeature(sibling, Classifier.DEAD);
            }
         }
         if (sizeUnboundOrAlive < minCardinality) {
            // TODO the minimum number of selected features cannot be reached
            // consider more features, that are not yet contained in the classification
            List<ClassifiedFeature> newSiblingClassificationFeatures =
               ClassificationUtil.getFeaturesOfGroup(parentGroup, classification, false);
            for (ClassifiedFeature newSibling : newSiblingClassificationFeatures) {
               handleAutoCompleteFeature(newSibling, Classifier.UNBOUND);
            }
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
         handleAutoCompleteFeature(feature, newClassifier, classification);
      }
   }

   private void setChildFeaturesDead(ClassifiedFeature classifiedFeature, Classifier newClassifier) {
      // otherwise select child features recursively
      Feature parentFeature = classifiedFeature.getFeature();
      Classification classification = (Classification) classifiedFeature.eContainer();

      TreeIterator<EObject> eAllContents = parentFeature.eAllContents();
      while (eAllContents.hasNext()) {
         EObject element = eAllContents.next();
         if (element instanceof Group) {
            Group group = (Group) element;
            List<ClassifiedFeature> childFeatures = ClassificationUtil.getFeaturesOfGroup(group, classification, true);
            for (ClassifiedFeature childFeature : childFeatures) {
               handleAutoCompleteFeature(childFeature, Classifier.DEAD);
            }
         }
      }
   }

   private class ChangeFeature {

      private ClassifiedFeature feature;
      private Classifier newClassifier;

      public ChangeFeature(ClassifiedFeature feature, Classifier newClassifier) {
         this.feature = feature;
         this.newClassifier = newClassifier;
      }

      public ClassifiedFeature getFeature() {
         return feature;
      }

      public Classifier getNewClassifier() {
         return newClassifier;
      }

   }

}

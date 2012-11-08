package org.feature.multi.perspective.classification.operation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.feature.model.utilities.FeatureModelUtil;
import org.feature.multi.perspective.classification.Classification;
import org.feature.multi.perspective.classification.ClassificationFactory;
import org.feature.multi.perspective.classification.ClassificationModel;
import org.feature.multi.perspective.classification.ClassifiedFeature;
import org.feature.multi.perspective.classification.Classifier;
import org.feature.multi.perspective.mapping.viewmapping.MappingModel;
import org.feature.multi.perspective.model.viewmodel.AbstractGroup;
import org.feature.multi.perspective.view.View;
import org.feature.multi.perspective.view.provider.ViewBuilder;
import org.featuremapper.models.feature.Feature;

/**
 * Handles the classification of stages.
 * 
 * @author <a href="mailto:julia.schroeter@tu-dresden.de">Julia Schroeter</a>
 * 
 */
public class AutoClassification {

   ViewBuilder builder;

   ClassificationModel classificationModel;

   public AutoClassification(ClassificationModel classificationModel) {
      init(classificationModel);
   }

   private void init(ClassificationModel classificationModel) {
      this.classificationModel = classificationModel;
      MappingModel viewMapping = classificationModel.getViewMapping();
      builder = new ViewBuilder(viewMapping, false);
   }


   public void autoComplete() {
      EList<Classification> classifications = classificationModel.getClassifications();
      for (Classification classification : classifications) {
        autoComplete(classification) ;
      }
      saveResource();
   }

   
   private void saveResource() {
      try {
         classificationModel.eResource().save(null);
      } catch (IOException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      
   }

   private void autoComplete(Classification classification) {
      EList<ClassifiedFeature> classifiedFeatures = classification.getClassifiedFeatures();
      int size = classifiedFeatures.size();
      List<ClassifiedFeature> featureCopy = new ArrayList<ClassifiedFeature>(size); 
      featureCopy.addAll(classifiedFeatures);
      
      for (ClassifiedFeature classifiedFeature : featureCopy) {
         autoCompleteClassifiedFeature(classifiedFeature);
      }
   }

   private View getView(Classification classification){
      AbstractGroup viewgroup = classification.getViewgroup();
      return builder.getView(viewgroup);
   }
   
  
   
   private void autoCompleteClassifiedFeature(ClassifiedFeature classifiedFeature) {
      Classifier classified = classifiedFeature.getClassified();
         if (Classifier.ALIVE.equals(classified)) {
            handleAliveFeature(classifiedFeature);
         } else if (Classifier.DEAD.equals(classified)) {
            handleDeadFeature(classifiedFeature);
         } else if (Classifier.UNBOUND.equals(classified)) {
            handleUnboundFeature(classifiedFeature);
         }
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
      setSiblingsAlive(classifiedFeature);
      // if eContainer is null, then this is the root feature
      // otherwise select parent features

   }

   private void setSiblingsAlive(ClassifiedFeature classifiedFeature) {
      // TODO Auto-generated method stub
      
   }


   private void setParentFeatures(ClassifiedFeature classifiedFeature, Classifier newClassifier){
      // if eContainer is null, then this is the root feature
      // otherwise select parent features recursively
      Feature childFeature = classifiedFeature.getFeature();
      List<Feature> anchestors = FeatureModelUtil.getAllAchestorFeatures(childFeature);

      Classification classification = (Classification) classifiedFeature.eContainer();
      View view = getView(classification);
      EList<Feature> viewFeatures = view.getFeatures();

      // set each anchestor alive
      for (Feature feature : anchestors) {
         // check if the parent features are contained in the view and therefore can be configured manually
         boolean containedInView = viewFeatures.contains(feature);
         ClassifiedFeature parentClassifiedFeature = findClassifiedFeature(classification, feature, containedInView);
         
         boolean changed = ClassificationUtil.changeClassifier(parentClassifiedFeature, newClassifier);
         if (!changed){
            System.out.println("Classifier '"+ newClassifier.getName()+ "' not changed on Feature '" + parentClassifiedFeature.getFeature().getName() 
                               + "'. Is: " + parentClassifiedFeature.getClassified().getName() );
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

   private ClassifiedFeature findClassifiedFeature(Classification classification, Feature feature, boolean containedInView) {
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
      if (result == null) {
         result = ClassificationUtil.createClassifiedFeature(feature);
         classifiedFeatures.add(result);
      }

      return result;
   }

  
}

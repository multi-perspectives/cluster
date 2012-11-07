package org.feature.multi.perspective.classification.operation;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.FeatureMapUtil;
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
   private MappingModel mappingModel;

   public AutoClassification(MappingModel mappingModel) {
      this.mappingModel = mappingModel;
      init(mappingModel);
   }

   private void init(MappingModel mappingModel) {
      builder = new ViewBuilder(mappingModel, true);
      initClassificationModel();
   }

   private void initClassificationModel() {
      classificationModel = ClassificationFactory.eINSTANCE.createClassificationModel();
      classificationModel.setViewMapping(builder.getViewMapping());
      initClassifications();
   }

   private void initClassifications() {
      List<View> allViews = builder.getAllViews();
      for (View view : allViews) {
         initClassificationPerView(view);
      }
   }

   /**
    * initialize a classification for a given view, whereas each feature contained in the view is declared as unbound.
    * 
    * @param view
    */
   public void initClassificationPerView(View view) {
      Classification classification = ClassificationFactory.eINSTANCE.createClassification();
      classificationModel.getClassifications().add(classification);

      AbstractGroup viewgroup = view.getViewgroup();
      classification.setViewgroup(viewgroup);
      EList<Feature> features = view.getFeatures();
      classification.getUnboundFeatures().addAll(features);
   }

   public void autoCompleteClassification(ClassifiedFeature classifiedFeature) {
      Classifier classified = classifiedFeature.getClassified();
      EObject container = classifiedFeature.eContainer();
      Feature feature = classifiedFeature.getFeature();

      if (container instanceof Classification) {
         Classification classification = (Classification) container;

         if (Classifier.ALIVE.equals(classified)) {
            handleAliveFeature(feature, classification);
         } else if (Classifier.DEAD.equals(classified)) {
            handleDeadFeature(feature, classification);
         } else if (Classifier.UNBOUND.equals(classified)) {
            handleUnboundFeature(feature, classification);
         }
      }
   }

   private void handleUnboundFeature(Feature feature, Classification classification) {
      // TODO Auto-generated method stub
   }

   private void handleDeadFeature(Feature feature, Classification classification) {
      // TODO Auto-generated method stub
   }

   private void handleAliveFeature(Feature feature, Classification classification) {
      // TODO select parent features
      selectParentFeatures(feature, classification);
      // TODO select constraint requires edge features
      // TODO select group cardinality sibling features
      
      // if eContainer is null, then this is the root feature
      // otherwise select parent features
     
      }
      
   
   private View getView(Classification classification){
      AbstractGroup viewgroup = classification.getViewgroup();
      View view = builder.getView(viewgroup);
      return view;
   }

   
   private void selectParentFeatures(Feature childFeature, Classification classification) {
      // if eContainer is null, then this is the root feature
      // otherwise select parent features recursively
      List<Feature> anchestors = FeatureModelUtil.getAllAchestorFeatures(childFeature);
      View view = getView(classification);
      EList<Feature> viewFeatures = view.getFeatures();
      
      List<Feature> anchestorsContainedInView = new ArrayList<>();
      List<Feature> anchestorsNotContainedInView = new ArrayList<>();
      // check if the parent features are contained in the view and therefore can be configured manually
      for (Feature feature : anchestors) {
         if (viewFeatures.contains(feature)){
            anchestorsContainedInView.add(feature);
         } else {
            anchestorsNotContainedInView.add(feature);
         }
      }
      // for each parent contained in the view, check classification status
   }

   
   
   
   
   private void cleanUpFeatureReference(Feature feature, Classification classification){
      EList<Feature> deadFeatures = classification.getDeadFeatures();
      deadFeatures.remove(feature);
      EList<Feature> unboundFeatures = classification.getUnboundFeatures();
      unboundFeatures.remove(feature);
      EList<Feature> aliveFeatures = classification.getAliveFeatures();
      aliveFeatures.remove(feature);
   }
   
}

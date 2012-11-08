/**
 * 
 */
package org.feature.multi.perspective.classification.resource.clt.postprocessor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.feature.model.utilities.FeatureMappingUtil;
import org.feature.model.utilities.GroupModelUtil;
import org.feature.multi.perspective.classification.Classification;
import org.feature.multi.perspective.classification.ClassificationFactory;
import org.feature.multi.perspective.classification.ClassificationModel;
import org.feature.multi.perspective.classification.ClassifiedFeature;
import org.feature.multi.perspective.classification.Classifier;
import org.feature.multi.perspective.classification.resource.clt.ICltOptionProvider;
import org.feature.multi.perspective.classification.resource.clt.ICltOptions;
import org.feature.multi.perspective.classification.resource.clt.ICltResourcePostProcessor;
import org.feature.multi.perspective.classification.resource.clt.ICltResourcePostProcessorProvider;
import org.feature.multi.perspective.classification.resource.clt.mopp.CltResource;
import org.feature.multi.perspective.mapping.viewmapping.MappingModel;
import org.feature.multi.perspective.model.viewmodel.AbstractGroup;
import org.feature.multi.perspective.model.viewmodel.GroupModel;
import org.featuremapper.models.feature.Feature;

/**
 * Initializes an classification of all stages by assigning unclassified feature per stage according to the definitions
 * given in the view model as well as in the mapping to the feature model.
 * 
 * @author <a href="mailto:julia.schroeter@tu-dresden.de">Julia Schroeter</a>
 * 
 */
public class StageInitializer implements ICltOptionProvider, ICltResourcePostProcessor, ICltResourcePostProcessorProvider {

   @Override
   public void process(CltResource resource) {

      EList<EObject> contents = resource.getContents();
      for (EObject eObject : contents) {
         if (eObject instanceof ClassificationModel) {
            ClassificationModel model = (ClassificationModel) eObject;
            MappingModel viewMapping = model.getViewMapping();
            EList<Classification> classifications = model.getClassifications();
            resolveViewMapping(viewMapping, classifications);
         }
      }
   }

   private void resolveViewMapping(MappingModel viewMapping, EList<Classification> classifications) {
      List<Classification> newClassifications = new ArrayList<Classification>();
      GroupModel viewModel = viewMapping.getViewModel();
      if (viewModel != null) {
         List<AbstractGroup> allGroups = GroupModelUtil.getAllGroups(viewModel, true);
         for (AbstractGroup group : allGroups) {
            boolean create = true;
            for (Classification classification : classifications) {
               AbstractGroup viewgroup = classification.getViewgroup();
               if (viewgroup != null && EcoreUtil.equals(group, viewgroup)) {
                  create = false;
                  break;
               }
            }
            if (create) {
               Classification newClassification = createClassification(group, viewMapping);
               newClassifications.add(newClassification);
            }
         }
      }
      classifications.addAll(newClassifications);
   }

   private Classification createClassification(AbstractGroup group, MappingModel mappingModel) {
      Classification classification = ClassificationFactory.eINSTANCE.createClassification();
      String name = group.getName();
      classification.setId(name);
      classification.setViewgroup(group);
      List<ClassifiedFeature> newClassifiedFeatures = createClassifiedFeatures(group, mappingModel);
      classification.getClassifiedFeatures().addAll(newClassifiedFeatures);
      return classification;
   }

   private List<ClassifiedFeature> createClassifiedFeatures(AbstractGroup group, MappingModel mappingModel) {
      List<ClassifiedFeature> newClassifiedFeatures = new ArrayList<ClassifiedFeature>();
      List<Feature> features = FeatureMappingUtil.collectViewFeatures(group, mappingModel);
      for (Feature feature : features) {
       // ClassifiedFeature classifiedFeature = ClassificationUtil.createClassifiedFeature(feature);
       // newClassifiedFeatures.add(classifiedFeature);
      }
      return newClassifiedFeatures;
   }


   @Override
   public void terminate() {}

   @Override
   public ICltResourcePostProcessor getResourcePostProcessor() {
      return this;
   }

   @Override
   public Map< ? , ? > getOptions() {
      return Collections.singletonMap(ICltOptions.RESOURCE_POSTPROCESSOR_PROVIDER, this);
   }

}

package org.feature.multi.perspective.classification.resource.clt.postprocessor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
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
import org.feature.multi.perspective.mapping.viewmapping.Mapping;
import org.feature.multi.perspective.mapping.viewmapping.MappingModel;
import org.feature.multi.perspective.model.viewmodel.AbstractGroup;
import org.featuremapper.models.feature.Feature;

public class ViewgroupInitializer implements ICltOptionProvider, ICltResourcePostProcessor,
      ICltResourcePostProcessorProvider {

   @Override
   public void process(CltResource resource) {
      EList<EObject> contents = resource.getContents();
      for (EObject eObject : contents) {
         if (eObject instanceof ClassificationModel) {
            ClassificationModel model = (ClassificationModel) eObject;
            MappingModel viewMapping = model.getViewMapping();
            EList<Classification> classifications = model.getClassifications();
            if (viewMapping != null) {
               EList<Mapping> mappings = viewMapping.getMappings();
               oberserveMappings(mappings, classifications);
            }
         }
      }
   }

   private void oberserveMappings(EList<Mapping> mappings, EList<Classification> classifications) {
      List<Classification> newClassifications = new ArrayList<Classification>();
      for (Mapping mapping : mappings) {
         AbstractGroup mappedGroup = mapping.getViewgroup();
         if (mappedGroup != null) {
            boolean create = true;
            for (Classification classification : classifications) {
                classification.getViewgroups();
//               if (viewgroup != null && EcoreUtil.equals(mappedGroup, viewgroup)) {
//                  create = false;
//                  break;
//               }
            }
            if (create) {
               Classification newClassification = createClassification(mapping);
               newClassifications.add(newClassification);
            }
         }
      }
      classifications.addAll(newClassifications);
   }

   private Classification createClassification(Mapping mapping) {
      Classification classification = ClassificationFactory.eINSTANCE.createClassification();
      AbstractGroup group = mapping.getViewgroup();
      classification.getViewgroups().add(group);
      List<ClassifiedFeature> newClassifiedFeatures = createClassifiedFeatures(mapping);
      classification.getClassifiedFeatures().addAll(newClassifiedFeatures);
      return classification;
   }

   private List<ClassifiedFeature> createClassifiedFeatures(Mapping mapping) {
      List<ClassifiedFeature> newClassifiedFeatures = new ArrayList<ClassifiedFeature>();
      EList<Feature> features = mapping.getFeatures();
      for (Feature feature : features) {
         ClassifiedFeature classifiedFeature = createClassifiedFeature(feature);
         newClassifiedFeatures.add(classifiedFeature);
      }
      return newClassifiedFeatures;
   }

   private ClassifiedFeature createClassifiedFeature(Feature feature) {
      ClassifiedFeature newClassifiedFeature = ClassificationFactory.eINSTANCE.createClassifiedFeature();
      newClassifiedFeature.setFeature(feature);
      newClassifiedFeature.setClassified(Classifier.UNCLASSIFIED);
      return newClassifiedFeature;
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

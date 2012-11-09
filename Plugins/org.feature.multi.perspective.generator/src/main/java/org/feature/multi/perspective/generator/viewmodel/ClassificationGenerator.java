/**
 * 
 */
package org.feature.multi.perspective.generator.viewmodel;

import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.feature.model.csp.analyze.FeatureModelAnalyzer;
import org.feature.model.csp.analyze.FeatureVariant;
import org.feature.multi.perspective.classification.Classification;
import org.feature.multi.perspective.classification.ClassificationFactory;
import org.feature.multi.perspective.classification.ClassificationModel;
import org.feature.multi.perspective.classification.ClassificationPackage;
import org.feature.multi.perspective.classification.ClassificationUtil;
import org.feature.multi.perspective.classification.ClassifiedFeature;
import org.feature.multi.perspective.classification.Classifier;
import org.feature.multi.perspective.classification.impl.ClassificationFactoryImpl;
import org.feature.multi.perspective.mapping.viewmapping.Mapping;
import org.feature.multi.perspective.mapping.viewmapping.MappingModel;
import org.feature.multi.perspective.model.viewmodel.AbstractGroup;
import org.feature.multi.perspective.model.viewmodel.CoreGroup;
import org.feature.multi.perspective.model.viewmodel.GroupModel;
import org.featuremapper.models.feature.Feature;
import org.featuremapper.models.feature.FeatureModel;

/**
 * @author <a href=mailto:julia.schroeter@tu-dresden.de>Julia Schroeter</a>
 * 
 */
public class ClassificationGenerator extends AbstractGenerator {

   private static Logger log = Logger.getLogger(ClassificationGenerator.class);

   // Jedes Szenario entsp. einer validen zusammenhängenden Konfiguration
   private int numberOfParalellViewInterpretationScenarios = 3;
   // Prozentsatz von Unbound in jeder Klassifizierung einer View
   private int percentOfUnboundOverrideEachInterpretation = 5;
   private int percentOfUnclassifiedOverrideEachInterpretation = 10;
   // --> es sollte zu keinen invaliden Konifgurationen innerhalb eines
   // Szenarios kommen

   // ALLE möglichen Produktkonfigurationen berechnen

   // X % auf Unbound und Unclassified setzen

   private ClassificationModel classifyModel;
   private FullVariantClassification productVariants[];

   public ClassificationGenerator() {
      super();
      classifyModel = ClassificationFactoryImpl.eINSTANCE.createClassificationModel();

      productVariants = new FullVariantClassification[numberOfParalellViewInterpretationScenarios];
   }

   public void generateClassification() {
      ResourceSet set = new ResourceSetImpl();
      List<MappingModel> allMappingModels = getAllMappingModels(set);
      for (MappingModel featureMapping : allMappingModels) {
         generateClassification(featureMapping);
         persistModel(classifyModel, "classification_" + featureMapping.eResource().getTimeStamp() , "clt", classificationFolder);
      }
   }

   public void generateClassification(MappingModel featuremapping) {
      FeatureModel fm = featuremapping.getFeatureModel();
      fillViewInterpretations(fm);

      // classifyModel.setFeatureModel(fm);
      classifyModel.setViewMapping(featuremapping);

      // Every view is being interpreted
      // 'numberOfParalellViewInterpretationScenarios' times
      for (Mapping m : featuremapping.getMappings()) {
         AbstractGroup g = m.getViewgroup();

         if (g instanceof CoreGroup) continue;

         // EList<Feature> viewFeatures = m.getFeatures();

         for (int i = 0; i < numberOfParalellViewInterpretationScenarios; i++) {

            Classification classification = ClassificationFactory.eINSTANCE.createClassification();
            classification.getViewgroups().add(g);
            classification.setId(g.getName() + "_" + i);
            classifyModel.getClassifications().add(classification);
            
            List<ClassifiedFeature> classifiedFeatures = ClassificationUtil.getAllClassifiedFeaturesOfView(classification);

            for (ClassifiedFeature feature : classifiedFeatures) {
            	
               Classifier classifier = Classifier.UNCLASSIFIED;
               
               int randomUnbound = (int) Math.floor((Math.random() * 99) + 1);
               int randomUnclassified = (int) Math.floor((Math.random() * 99) + 1);

               if (randomUnbound <= percentOfUnboundOverrideEachInterpretation
                   && !(randomUnclassified <= percentOfUnclassifiedOverrideEachInterpretation)) {
                  // c.getUnboundFeatures().add(f);
                  classifier = Classifier.UNBOUND;
               } else if (!(randomUnbound <= percentOfUnboundOverrideEachInterpretation)
                          && (randomUnclassified <= percentOfUnclassifiedOverrideEachInterpretation))
               // No classification
               {}
               // if both would match, unclassified wins
               else if ((randomUnbound <= percentOfUnboundOverrideEachInterpretation)
                        && (randomUnclassified <= percentOfUnclassifiedOverrideEachInterpretation)) {
                  // classifier = Classifier.UNBOUND;
               } 
               
               else {
                  if (productVariants[i].getAliveFeatures().contains(feature.getFeature())) {
                     classifier = Classifier.ALIVE;
                  } else if (productVariants[i].getDeadFeatures().contains(feature.getFeature())) {
                     classifier = Classifier.DEAD;
                  } else
                     log.error("Feature classification is UNKNOWN! - Classification cannot be determined, set to unclassified");
               }
               ClassificationUtil.changeClassifier(feature, classifier, classification);
            }
         }
      }
   }

   private void fillViewInterpretations(FeatureModel fm) {

      FeatureModelAnalyzer analyzer = new FeatureModelAnalyzer(fm);
      List<FeatureVariant> allVariants = analyzer.getAllVariants();

      if (allVariants.size() < numberOfParalellViewInterpretationScenarios) {
         log.error("Not enough product variants available to generate sufficient classifications");
         // TODO: Throw exception
         return;
      }

      for (int i = 0; i < numberOfParalellViewInterpretationScenarios; i++) {
         FeatureVariant variant = allVariants.get(allVariants.size() - i - 1);
         FullVariantClassification variantClassification = new FullVariantClassification(variant);

         for (Feature f : fm.getAllFeatures()) {
            if (variant.getFeatures().contains(f))
               variantClassification.getAliveFeatures().add(f);
            else
               variantClassification.getDeadFeatures().add(f);
         }

         productVariants[i] = variantClassification;

         log.debug("Adding Variant-Interpretion " + i + " with " + variantClassification.getAliveFeatures().size() + " alive features and "
                   + variantClassification.getDeadFeatures().size() + " dead features");
      }

   }

   public ClassificationModel getClassificationModel() {
      return this.classifyModel;
   }

   public void setNumContextPerView(int numContexts) {
      this.numberOfParalellViewInterpretationScenarios = numContexts;
   }

   public int getNumContextPerView() {
      return numberOfParalellViewInterpretationScenarios;
   }

   public void setPercentUnbound(int percent) {
      this.percentOfUnboundOverrideEachInterpretation = percent;
   }

   public int getPercentUnbound() {
      return this.percentOfUnboundOverrideEachInterpretation;
   }

   public void setPercentUnclassified(int percent) {
      this.percentOfUnclassifiedOverrideEachInterpretation = percent;
   }

   public int getPercentUnclassified() {
      return this.percentOfUnclassifiedOverrideEachInterpretation;
   }

}

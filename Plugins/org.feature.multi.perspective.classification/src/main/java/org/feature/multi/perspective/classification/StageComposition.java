/**
 * 
 */
package org.feature.multi.perspective.classification;

import org.eclipse.emf.common.util.EList;

/**
 * @author <a href="mailto:julia.schroeter@tu-dresden.de">Julia Schroeter</a>
 * 
 */
public class StageComposition {

   private ClassificationModel model;

   /**
    * default constructor.
    */
   public StageComposition(ClassificationModel model) {
      this.model = model;}

   public void compose(Classification classification) {
      EList<Classification> compose = classification.getCompose();
      Classification composition = null;
      // compose stages pair wise
      for (Classification composeableClassification : compose) {
         if (composition == null) {
            composition = composeableClassification;
            continue;
         } else {
            composition = ClassificationUtil.composition(composition, composeableClassification, model);
         }
      }
      copyCompositionResult(classification, composition);
      
   }

   private void copyCompositionResult(Classification destination, Classification composition) {
      destination.getAutoCompleteFeatures().clear();
      destination.getClassifiedFeatures().clear();
      
      destination.getClassifiedFeatures().addAll(composition.getClassifiedFeatures());
      destination.getAutoCompleteFeatures().addAll(composition.getAutoCompleteFeatures());
   }

   public void autoCompose() {
      EList<Classification> classifications = model.getClassifications();
      for (Classification classification : classifications) {
         EList<Classification> compose = classification.getCompose();
         if (compose.size() > 0){
            compose(classification);
         }
      }
      
   }

}

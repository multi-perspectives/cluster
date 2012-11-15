/**
 * 
 */
package org.feature.multi.perspective.classification.operation;

import org.feature.multi.perspective.classification.ClassificationModel;
import org.feature.multi.perspective.classification.StageComposition;

/**
 * Handler for the composition of stages.
 * 
 * @author <a href="mailto:julia.schroeter@tu-dresden.de">Julia Schroeter</a>
 * 
 */
public class CompositionHandler extends AbstractCompletionHandler {

   @Override
   protected void executeCommand(ClassificationModel model) {
      StageComposition composition = new StageComposition(model);
      composition.autoCompose();
   }

}

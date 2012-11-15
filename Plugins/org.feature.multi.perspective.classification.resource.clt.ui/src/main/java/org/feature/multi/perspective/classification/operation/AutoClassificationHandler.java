/**
 * 
 */
package org.feature.multi.perspective.classification.operation;

import org.feature.multi.perspective.classification.AutoClassification;
import org.feature.multi.perspective.classification.ClassificationModel;

/**
 * Handler for the auto classification command.
 * 
 * @author <a href="mailto:julia.schroeter@tu-dresden.de">Julia Schroeter</a>
 * 
 */
public class AutoClassificationHandler extends AbstractCompletionHandler {

   @Override
   protected void executeCommand(ClassificationModel model) {
      AutoClassification autoClassification = new AutoClassification(model);
      autoClassification.autoComplete();
   }

}

package org.feature.model.csp.solver.handler;

import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.feature.model.csp.solver.CSPAnalyzer;
import org.feature.model.utilities.ResourceUtil;

/**
 * Default command handler that invokes an analysis on a selected featuremodel in the workbench.
 * @author <a href="mailto:info@juliaschroeter.de">Julia Schroeter</a>
 *
 */
public class AnalyzeFeatureModelCommandHandler extends AbstractHandler {

   String handledCommandId = "org.js.featuremodel.analyze";

   /*
    * (non-Javadoc)
    * 
    * @see org.eclipse.core.commands.IHandler#execute(org.eclipse.core.commands.ExecutionEvent)
    */
   @Override
   public Object execute(ExecutionEvent event) throws ExecutionException {
      List<IFile> files = ResourceUtil.getSelectedWorkbenchFiles();
      CSPAnalyzer.analyze(files);
      return null;
   }

}

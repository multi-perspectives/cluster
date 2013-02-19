package org.feature.transform.splot2fm.handler;

import java.util.List;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.feature.transform.splot2fm.SXFM2FMTransformator;

public class TransformCommandHandler extends AbstractGenCommandHandler {

   String handledCommandId = "org.js.transform.splot2fm";

   /*
    * (non-Javadoc)
    * 
    * @see org.eclipse.core.commands.IHandler#execute(org.eclipse.core.commands.ExecutionEvent)
    */
   @Override
   public Object execute(ExecutionEvent event) throws ExecutionException {
      List<IFile> files = getFilesFromWorkspace();
      SXFM2FMTransformator.parseFiles(files);
      return null;
   }

}

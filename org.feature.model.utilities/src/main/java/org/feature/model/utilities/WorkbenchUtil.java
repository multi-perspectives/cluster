/**
 * 
 */
package org.feature.model.utilities;

import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

/**
 * workspace utility class to access the eclipse workspace.
 * 
 * @author <a href="mailto:info@juliaschroeter.de">Julia Schroeter</a>
 * 
 */
public class WorkbenchUtil {

   /**
    * find the currently active editor. May return null, if no editor is active.
    * 
    * @return
    */
   public static IEditorPart getActiveEditor() {
      IEditorPart activeEditor = null;
      IWorkbench workbench = PlatformUI.getWorkbench();
      if (workbench != null) {
         IWorkbenchWindow activeWindow = workbench.getActiveWorkbenchWindow();
         if (activeWindow != null) {
            IWorkbenchPage page = activeWindow.getActivePage();
            if (page != null) {
               activeEditor = page.getActiveEditor();
            }
         }
      }
      return activeEditor;
   }
}

/**
 * 
 */
package org.feature.multi.perspective.classification.operation;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;
import org.emftext.access.EMFTextAccessProxy;
import org.emftext.access.resource.IEditor;
import org.emftext.access.resource.IResource;
import org.feature.multi.perspective.classification.ClassificationModel;
import org.feature.multi.perspective.classification.resource.clt.ui.CltEditor;

/**
 * @author <a href="mailto:julia.schroeter@tu-dresden.de">Julia Schroeter</a>
 * 
 */
public class AutoClassificationHandler extends AbstractHandler {

   private boolean enabled = false;

   @Override
   public Object execute(ExecutionEvent event) throws ExecutionException {

      ClassificationModel model = getModel(event);
      if (model != null) {
         AutoClassification autoClassification = new AutoClassification(model);
         autoClassification.autoComplete();
      }
      return null;
   }

   private ClassificationModel getModel(ExecutionEvent event) {
      ClassificationModel model = null;
      IEditorPart activeEditor = HandlerUtil.getActiveEditor(event);
      IEditor iEditor = EMFTextAccessProxy.get(activeEditor, IEditor.class);
      IResource resource = iEditor.getResource();
      EObject eObject = resource.getContents().get(0);

      EObject rootContainer = EcoreUtil.getRootContainer(eObject);
      if (rootContainer instanceof ClassificationModel) {
         model = (ClassificationModel) rootContainer;
      }
      return model;
   }

   @Override
   public boolean isEnabled() {
      return enabled;
   }

   @Override
   public void setEnabled(Object evaluationContext) {
      super.setEnabled(evaluationContext);
      IWorkbench workbench = PlatformUI.getWorkbench();
      if (workbench != null) {
         IWorkbenchWindow activeWindow = workbench.getActiveWorkbenchWindow();
         ISelectionService selectionService = activeWindow.getSelectionService();
         ISelection selection = selectionService.getSelection();

         if (activeWindow != null) {
            IWorkbenchPage page = activeWindow.getActivePage();
            if (page != null) {
               IEditorPart editor = page.getActiveEditor();
               if (editor instanceof CltEditor) {
                  ISelection editorSelection = editor.getEditorSite().getSelectionProvider().getSelection();
                  enabled = selection.equals(editorSelection);
               }
            }
         }
      }

   }

}

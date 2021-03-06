/**
 * 
 */
package org.feature.multi.perspective.classification.operation;

import java.io.IOException;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.ChangeCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
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
public abstract class AbstractCompletionHandler extends AbstractHandler {

   private boolean enabled = false;

   protected EditingDomain domain;

   @Override
   public Object execute(ExecutionEvent event) throws ExecutionException {
      final ClassificationModel model = getModel(event);

      ChangeCommand changeCommand = new ChangeCommand(model) {

         @Override
         protected void doExecute() {
            executeCommand(model);
         }
      };
      domain.getCommandStack().execute(changeCommand);

      try {
         model.eResource().save(null);
      } catch (IOException e) {
         e.printStackTrace();
      }
      return null;
   }

   protected abstract void executeCommand(ClassificationModel model);

   /**
    * get the model from the execution context.
    * 
    * @param event
    * @return
    */
   protected ClassificationModel getModel(ExecutionEvent event) {
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
      enabled = false;
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
                  domain = ((CltEditor) editor).getEditingDomain();
                  ISelection editorSelection = editor.getEditorSite().getSelectionProvider().getSelection();
                  enabled = selection.equals(editorSelection);
               }
            }
         }
      }

   }

}

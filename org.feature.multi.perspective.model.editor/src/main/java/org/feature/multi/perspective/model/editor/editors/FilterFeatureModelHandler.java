/**
 * 
 */
package org.feature.multi.perspective.model.editor.editors;

import java.util.Collection;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.expressions.EvaluationContext;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.feature.multi.perspective.model.viewmodel.ViewPoint;

/**
 * 
 * @author Tim Winkelmann
 * 
 */
public class FilterFeatureModelHandler extends AbstractHandler {

   private boolean enabled = false;
   private ViewPoint viewPoint;

   /*
    * (non-Javadoc)
    * 
    * @see org.eclipse.core.commands.IHandler#execute(org.eclipse.core.commands.ExecutionEvent)
    */
   @Override
   public Object execute(ExecutionEvent event) throws ExecutionException {
         ViewmodelMultiPageEditor multiPageEditor = getActiveEditor();
                  if (multiPageEditor != null){
                  multiPageEditor.createFilteredFeatureModel(viewPoint);
                  } return null;
   }

   private ViewmodelMultiPageEditor getActiveEditor(){
      ViewmodelMultiPageEditor multiPageEditor = null;
      IWorkbench workbench = PlatformUI.getWorkbench();
      if (workbench != null) {
         IWorkbenchWindow activeWindow = workbench.getActiveWorkbenchWindow();
         if (activeWindow != null) {
            IWorkbenchPage page = activeWindow.getActivePage();
            if (page != null) {
               IEditorPart activeEditor = page.getActiveEditor();
               if (activeEditor instanceof ViewmodelMultiPageEditor) {
                   multiPageEditor = (ViewmodelMultiPageEditor) activeEditor;
               }}}}
      return multiPageEditor;
   }
   
   
   /*
    * (non-Javadoc)
    * 
    * @see org.eclipse.core.combattmands.AbstractHandler#isEnabled()
    */
   @Override
   public boolean isEnabled() {
      return enabled;
   }

   /*
    * (non-Javadoc)
    * 
    * @see org.eclipse.core.commands.AbstractHandler#setEnabled(java.lang.Object)
    */
   @Override
   public void setEnabled(Object evaluationContext) {
      super.setEnabled(evaluationContext);
      ViewmodelMultiPageEditor multiPageEditor = getActiveEditor();
      if (multiPageEditor != null){
      if (evaluationContext instanceof EvaluationContext) {
         EvaluationContext eval = (EvaluationContext) evaluationContext;
         Object defaultVariable = eval.getDefaultVariable();
         if (defaultVariable instanceof Collection) {
            Collection list = (Collection) defaultVariable;
            for (Object object : list) {
               if (object instanceof ViewPoint && multiPageEditor.getMappingResource() != null) {
                  this.viewPoint = (ViewPoint) object;
                  enabled = true;
                  return;
               }
            }
         }}
      }
      enabled = false;
   }
}

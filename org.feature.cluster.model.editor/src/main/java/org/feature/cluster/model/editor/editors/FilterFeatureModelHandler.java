/**
 * 
 */
package org.feature.cluster.model.editor.editors;

import java.util.Collection;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.expressions.EvaluationContext;
import org.feature.cluster.model.cluster.ViewPoint;

/**
 * @author winkelti
 *
 */
public class FilterFeatureModelHandler extends AbstractHandler {
	private boolean enabled = false;
	public static MultiPageEditor multiPageEditor;
	private ViewPoint viewPoint;
	
	/* (non-Javadoc)
	 * @see org.eclipse.core.commands.IHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 */
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		multiPageEditor.createFilteredFeatureModel(viewPoint);
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.core.commands.AbstractHandler#isEnabled()
	 */
	@Override
	public boolean isEnabled() {
		return enabled;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.core.commands.AbstractHandler#setEnabled(java.lang.Object)
	 */
	@Override
	public void setEnabled(Object evaluationContext) {
		super.setEnabled(evaluationContext);
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
			}
		}
		enabled = false;
	}
}

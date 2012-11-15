/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.model.constraint.resource.csl.ui;

public class CslOutlinePageCollapseAllAction extends org.feature.model.constraint.resource.csl.ui.AbstractCslOutlinePageAction {
	
	public CslOutlinePageCollapseAllAction(org.feature.model.constraint.resource.csl.ui.CslOutlinePageTreeViewer treeViewer) {
		super(treeViewer, "Collapse all", org.eclipse.jface.action.IAction.AS_PUSH_BUTTON);
		initialize("icons/collapse_all_icon.gif");
	}
	
	public void runInternal(boolean on) {
		if (on) {
			getTreeViewer().collapseAll();
		}
	}
	
	public boolean keepState() {
		return false;
	}
	
}

/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.model.constraint.resource.csl.ui;

public class CslOutlinePageExpandAllAction extends org.feature.model.constraint.resource.csl.ui.AbstractCslOutlinePageAction {
	
	public CslOutlinePageExpandAllAction(org.feature.model.constraint.resource.csl.ui.CslOutlinePageTreeViewer treeViewer) {
		super(treeViewer, "Expand all", org.eclipse.jface.action.IAction.AS_PUSH_BUTTON);
		initialize("icons/expand_all_icon.gif");
	}
	
	public void runInternal(boolean on) {
		if (on) {
			getTreeViewer().expandAll();
		}
	}
	
	public boolean keepState() {
		return false;
	}
	
}

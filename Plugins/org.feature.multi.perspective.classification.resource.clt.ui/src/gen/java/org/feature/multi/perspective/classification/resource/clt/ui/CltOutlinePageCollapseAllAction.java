/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.multi.perspective.classification.resource.clt.ui;

public class CltOutlinePageCollapseAllAction extends org.feature.multi.perspective.classification.resource.clt.ui.AbstractCltOutlinePageAction {
	
	public CltOutlinePageCollapseAllAction(org.feature.multi.perspective.classification.resource.clt.ui.CltOutlinePageTreeViewer treeViewer) {
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

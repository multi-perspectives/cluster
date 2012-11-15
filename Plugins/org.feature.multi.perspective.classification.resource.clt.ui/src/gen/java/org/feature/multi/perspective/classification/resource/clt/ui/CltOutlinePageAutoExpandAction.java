/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.multi.perspective.classification.resource.clt.ui;

public class CltOutlinePageAutoExpandAction extends org.feature.multi.perspective.classification.resource.clt.ui.AbstractCltOutlinePageAction {
	
	public CltOutlinePageAutoExpandAction(org.feature.multi.perspective.classification.resource.clt.ui.CltOutlinePageTreeViewer treeViewer) {
		super(treeViewer, "Auto expand", org.eclipse.jface.action.IAction.AS_CHECK_BOX);
		initialize("icons/auto_expand_icon.gif");
	}
	
	public void runInternal(boolean on) {
		getTreeViewer().setAutoExpand(on);
		getTreeViewer().refresh();
	}
	
}

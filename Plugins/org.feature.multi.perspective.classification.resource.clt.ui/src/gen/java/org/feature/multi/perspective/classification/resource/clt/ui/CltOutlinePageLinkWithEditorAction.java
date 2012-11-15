/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.multi.perspective.classification.resource.clt.ui;

public class CltOutlinePageLinkWithEditorAction extends org.feature.multi.perspective.classification.resource.clt.ui.AbstractCltOutlinePageAction {
	
	public CltOutlinePageLinkWithEditorAction(org.feature.multi.perspective.classification.resource.clt.ui.CltOutlinePageTreeViewer treeViewer) {
		super(treeViewer, "Link with Editor", org.eclipse.jface.action.IAction.AS_CHECK_BOX);
		initialize("icons/link_with_editor_icon.gif");
	}
	
	public void runInternal(boolean on) {
		getTreeViewer().setLinkWithEditor(on);
	}
	
}

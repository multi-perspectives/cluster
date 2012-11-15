/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.model.constraint.resource.csl.ui;

public class CslOutlinePageLinkWithEditorAction extends org.feature.model.constraint.resource.csl.ui.AbstractCslOutlinePageAction {
	
	public CslOutlinePageLinkWithEditorAction(org.feature.model.constraint.resource.csl.ui.CslOutlinePageTreeViewer treeViewer) {
		super(treeViewer, "Link with Editor", org.eclipse.jface.action.IAction.AS_CHECK_BOX);
		initialize("icons/link_with_editor_icon.gif");
	}
	
	public void runInternal(boolean on) {
		getTreeViewer().setLinkWithEditor(on);
	}
	
}

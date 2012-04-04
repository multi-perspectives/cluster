/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.term.propositional.expression.resource.expression.ui;

public class ExpressionOutlinePageLinkWithEditorAction extends org.emftext.term.propositional.expression.resource.expression.ui.AbstractExpressionOutlinePageAction {
	
	public ExpressionOutlinePageLinkWithEditorAction(org.emftext.term.propositional.expression.resource.expression.ui.ExpressionOutlinePageTreeViewer treeViewer) {
		super(treeViewer, "Link with Editor", org.eclipse.jface.action.IAction.AS_CHECK_BOX);
		initialize("icons/link_with_editor_icon.gif");
	}
	
	public void runInternal(boolean on) {
		getTreeViewer().setLinkWithEditor(on);
	}
	
}

/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.term.propositional.expression.resource.expression.ui;

public class ExpressionOutlinePageActionProvider {
	
	public java.util.List<org.eclipse.jface.action.IAction> getActions(org.emftext.term.propositional.expression.resource.expression.ui.ExpressionOutlinePageTreeViewer treeViewer) {
		// To add custom actions to the outline view, set the
		// 'overrideOutlinePageActionProvider' option to <code>false</code> and modify
		// this method.
		java.util.List<org.eclipse.jface.action.IAction> defaultActions = new java.util.ArrayList<org.eclipse.jface.action.IAction>();
		defaultActions.add(new org.emftext.term.propositional.expression.resource.expression.ui.ExpressionOutlinePageLinkWithEditorAction(treeViewer));
		defaultActions.add(new org.emftext.term.propositional.expression.resource.expression.ui.ExpressionOutlinePageCollapseAllAction(treeViewer));
		defaultActions.add(new org.emftext.term.propositional.expression.resource.expression.ui.ExpressionOutlinePageExpandAllAction(treeViewer));
		defaultActions.add(new org.emftext.term.propositional.expression.resource.expression.ui.ExpressionOutlinePageAutoExpandAction(treeViewer));
		defaultActions.add(new org.emftext.term.propositional.expression.resource.expression.ui.ExpressionOutlinePageLexicalSortingAction(treeViewer));
		defaultActions.add(new org.emftext.term.propositional.expression.resource.expression.ui.ExpressionOutlinePageTypeSortingAction(treeViewer));
		return defaultActions;
	}
	
}

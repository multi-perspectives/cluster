/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.term.propositional.expression.resource.expression.ui;

public class ExpressionOutlinePageLexicalSortingAction extends org.emftext.term.propositional.expression.resource.expression.ui.AbstractExpressionOutlinePageAction {
	
	public ExpressionOutlinePageLexicalSortingAction(org.emftext.term.propositional.expression.resource.expression.ui.ExpressionOutlinePageTreeViewer treeViewer) {
		super(treeViewer, "Sort alphabetically", org.eclipse.jface.action.IAction.AS_CHECK_BOX);
		initialize("icons/sort_lexically_icon.gif");
	}
	
	public void runInternal(boolean on) {
		getTreeViewerComparator().setSortLexically(on);
		getTreeViewer().refresh();
	}
	
}

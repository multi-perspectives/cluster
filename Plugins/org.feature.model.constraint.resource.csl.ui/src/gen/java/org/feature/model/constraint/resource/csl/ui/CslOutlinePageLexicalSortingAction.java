/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.model.constraint.resource.csl.ui;

public class CslOutlinePageLexicalSortingAction extends org.feature.model.constraint.resource.csl.ui.AbstractCslOutlinePageAction {
	
	public CslOutlinePageLexicalSortingAction(org.feature.model.constraint.resource.csl.ui.CslOutlinePageTreeViewer treeViewer) {
		super(treeViewer, "Sort alphabetically", org.eclipse.jface.action.IAction.AS_CHECK_BOX);
		initialize("icons/sort_lexically_icon.gif");
	}
	
	public void runInternal(boolean on) {
		getTreeViewerComparator().setSortLexically(on);
		getTreeViewer().refresh();
	}
	
}

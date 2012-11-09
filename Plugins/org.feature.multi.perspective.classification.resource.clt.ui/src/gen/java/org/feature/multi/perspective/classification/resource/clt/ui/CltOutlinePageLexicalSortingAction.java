/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.multi.perspective.classification.resource.clt.ui;

public class CltOutlinePageLexicalSortingAction extends org.feature.multi.perspective.classification.resource.clt.ui.AbstractCltOutlinePageAction {
	
	public CltOutlinePageLexicalSortingAction(org.feature.multi.perspective.classification.resource.clt.ui.CltOutlinePageTreeViewer treeViewer) {
		super(treeViewer, "Sort alphabetically", org.eclipse.jface.action.IAction.AS_CHECK_BOX);
		initialize("icons/sort_lexically_icon.gif");
	}
	
	public void runInternal(boolean on) {
		getTreeViewerComparator().setSortLexically(on);
		getTreeViewer().refresh();
	}
	
}

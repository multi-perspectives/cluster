/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.multi.perspective.classification.resource.clt.ui;

public class CltOutlinePageActionProvider {
	
	public java.util.List<org.eclipse.jface.action.IAction> getActions(org.feature.multi.perspective.classification.resource.clt.ui.CltOutlinePageTreeViewer treeViewer) {
		// To add custom actions to the outline view, set the
		// 'overrideOutlinePageActionProvider' option to <code>false</code> and modify
		// this method.
		java.util.List<org.eclipse.jface.action.IAction> defaultActions = new java.util.ArrayList<org.eclipse.jface.action.IAction>();
		defaultActions.add(new org.feature.multi.perspective.classification.resource.clt.ui.CltOutlinePageLinkWithEditorAction(treeViewer));
		defaultActions.add(new org.feature.multi.perspective.classification.resource.clt.ui.CltOutlinePageCollapseAllAction(treeViewer));
		defaultActions.add(new org.feature.multi.perspective.classification.resource.clt.ui.CltOutlinePageExpandAllAction(treeViewer));
		defaultActions.add(new org.feature.multi.perspective.classification.resource.clt.ui.CltOutlinePageAutoExpandAction(treeViewer));
		defaultActions.add(new org.feature.multi.perspective.classification.resource.clt.ui.CltOutlinePageLexicalSortingAction(treeViewer));
		defaultActions.add(new org.feature.multi.perspective.classification.resource.clt.ui.CltOutlinePageTypeSortingAction(treeViewer));
		return defaultActions;
	}
	
}

/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.model.constraint.resource.csl.ui;

public class CslOutlinePageActionProvider {
	
	public java.util.List<org.eclipse.jface.action.IAction> getActions(org.feature.model.constraint.resource.csl.ui.CslOutlinePageTreeViewer treeViewer) {
		// To add custom actions to the outline view, set the
		// 'overrideOutlinePageActionProvider' option to <code>false</code> and modify
		// this method.
		java.util.List<org.eclipse.jface.action.IAction> defaultActions = new java.util.ArrayList<org.eclipse.jface.action.IAction>();
		defaultActions.add(new org.feature.model.constraint.resource.csl.ui.CslOutlinePageLinkWithEditorAction(treeViewer));
		defaultActions.add(new org.feature.model.constraint.resource.csl.ui.CslOutlinePageCollapseAllAction(treeViewer));
		defaultActions.add(new org.feature.model.constraint.resource.csl.ui.CslOutlinePageExpandAllAction(treeViewer));
		defaultActions.add(new org.feature.model.constraint.resource.csl.ui.CslOutlinePageAutoExpandAction(treeViewer));
		defaultActions.add(new org.feature.model.constraint.resource.csl.ui.CslOutlinePageLexicalSortingAction(treeViewer));
		defaultActions.add(new org.feature.model.constraint.resource.csl.ui.CslOutlinePageTypeSortingAction(treeViewer));
		return defaultActions;
	}
	
}

/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.term.propositional.expression.resource.expression.ui;

public abstract class AbstractExpressionOutlinePageAction extends org.eclipse.jface.action.Action {
	
	private String preferenceKey = this.getClass().getSimpleName() + ".isChecked";
	
	private org.emftext.term.propositional.expression.resource.expression.ui.ExpressionOutlinePageTreeViewer treeViewer;
	
	public AbstractExpressionOutlinePageAction(org.emftext.term.propositional.expression.resource.expression.ui.ExpressionOutlinePageTreeViewer treeViewer, String text, int style) {
		super(text, style);
		this.treeViewer = treeViewer;
	}
	
	public void initialize(String imagePath) {
		org.eclipse.jface.resource.ImageDescriptor descriptor = org.emftext.term.propositional.expression.resource.expression.ui.ExpressionImageProvider.INSTANCE.getImageDescriptor(imagePath);
		setDisabledImageDescriptor(descriptor);
		setImageDescriptor(descriptor);
		setHoverImageDescriptor(descriptor);
		boolean checked = org.emftext.term.propositional.expression.resource.expression.ui.ExpressionUIPlugin.getDefault().getPreferenceStore().getBoolean(preferenceKey);
		valueChanged(checked, false);
	}
	
	@Override	
	public void run() {
		if (keepState()) {
			valueChanged(isChecked(), true);
		} else {
			runBusy(true);
		}
	}
	
	public void runBusy(final boolean on) {
		org.eclipse.swt.custom.BusyIndicator.showWhile(org.eclipse.swt.widgets.Display.getCurrent(), new Runnable() {
			public void run() {
				runInternal(on);
			}
		});
	}
	
	public abstract void runInternal(boolean on);
	
	private void valueChanged(boolean on, boolean store) {
		setChecked(on);
		runBusy(on);
		if (store) {
			org.emftext.term.propositional.expression.resource.expression.ui.ExpressionUIPlugin.getDefault().getPreferenceStore().setValue(preferenceKey, on);
		}
	}
	
	public boolean keepState() {
		return true;
	}
	
	public org.emftext.term.propositional.expression.resource.expression.ui.ExpressionOutlinePageTreeViewer getTreeViewer() {
		return treeViewer;
	}
	
	public org.emftext.term.propositional.expression.resource.expression.ui.ExpressionOutlinePageTreeViewerComparator getTreeViewerComparator() {
		return (org.emftext.term.propositional.expression.resource.expression.ui.ExpressionOutlinePageTreeViewerComparator) treeViewer.getComparator();
	}
	
}

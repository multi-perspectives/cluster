/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.model.constraint.resource.csl.ui;

public abstract class AbstractCslOutlinePageAction extends org.eclipse.jface.action.Action {
	
	private String preferenceKey = this.getClass().getSimpleName() + ".isChecked";
	
	private org.feature.model.constraint.resource.csl.ui.CslOutlinePageTreeViewer treeViewer;
	
	public AbstractCslOutlinePageAction(org.feature.model.constraint.resource.csl.ui.CslOutlinePageTreeViewer treeViewer, String text, int style) {
		super(text, style);
		this.treeViewer = treeViewer;
	}
	
	public void initialize(String imagePath) {
		org.eclipse.jface.resource.ImageDescriptor descriptor = org.feature.model.constraint.resource.csl.ui.CslImageProvider.INSTANCE.getImageDescriptor(imagePath);
		setDisabledImageDescriptor(descriptor);
		setImageDescriptor(descriptor);
		setHoverImageDescriptor(descriptor);
		boolean checked = org.feature.model.constraint.resource.csl.ui.CslUIPlugin.getDefault().getPreferenceStore().getBoolean(preferenceKey);
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
			org.feature.model.constraint.resource.csl.ui.CslUIPlugin.getDefault().getPreferenceStore().setValue(preferenceKey, on);
		}
	}
	
	public boolean keepState() {
		return true;
	}
	
	public org.feature.model.constraint.resource.csl.ui.CslOutlinePageTreeViewer getTreeViewer() {
		return treeViewer;
	}
	
	public org.feature.model.constraint.resource.csl.ui.CslOutlinePageTreeViewerComparator getTreeViewerComparator() {
		return (org.feature.model.constraint.resource.csl.ui.CslOutlinePageTreeViewerComparator) treeViewer.getComparator();
	}
	
}

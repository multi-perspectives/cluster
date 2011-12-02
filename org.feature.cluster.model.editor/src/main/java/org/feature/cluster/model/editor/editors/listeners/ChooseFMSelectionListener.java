/**
 * 
 */
package org.feature.cluster.model.editor.editors.listeners;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;
import org.feature.cluster.model.editor.editors.MultiPageEditor;

/**
 * Listener for the selection of the FeatureMapping.
 * @author Tim Winkelmann
 *
 */
public class ChooseFMSelectionListener implements SelectionListener {
	private Composite parentComposite;
	private MultiPageEditor mpe;
	
	public ChooseFMSelectionListener(Composite composite, MultiPageEditor multiPageEditor) {
		this.parentComposite = composite;
		this.mpe = multiPageEditor;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.swt.events.SelectionListener#widgetSelected(org.eclipse.swt.events.SelectionEvent)
	 */
	@Override
	public void widgetSelected(SelectionEvent e) {
		//open FileDialog for workspace.
		FileDialog dialog = new FileDialog (parentComposite.getShell(), SWT.OPEN);
		String [] filterNames = new String [] {"FeatureMapping", "All Files (*)"};
		String [] filterExtensions = new String [] {"*.featuremapping", "*"};
		String filterPath = ResourcesPlugin.getWorkspace().getRoot().getLocation().toOSString();
		dialog.setFilterNames (filterNames);
		dialog.setFilterExtensions (filterExtensions);
		dialog.setFilterPath (filterPath);
		dialog.setFileName ("featureClusterMapping");
		// call mpe with the FeatureMapping
		mpe.setFeatureMapping(dialog.open());
	}

	/* (non-Javadoc)
	 * @see org.eclipse.swt.events.SelectionListener#widgetDefaultSelected(org.eclipse.swt.events.SelectionEvent)
	 */
	@Override
	public void widgetDefaultSelected(SelectionEvent e) {
		// TODO Auto-generated method stub

	}

}

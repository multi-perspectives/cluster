/**
 * 
 */
package org.feature.cluster.model.editor.editors.listeners;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.ui.dialogs.WorkspaceResourceDialog;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;
import org.feature.cluster.model.editor.editors.MultiPageEditor;
import org.featuremapper.common.utils.FeatureMappingUtil;
import org.featuremapper.ui.views.filter.FileExtensionViewerFilter;

/**
 * Listener for the selection of the FeatureMapping.
 * 
 * @author Tim Winkelmann
 * 
 */
public class ChooseFMSelectionListener implements SelectionListener {
	Logger log = Logger.getLogger(ChooseFMSelectionListener.class);
	private Composite parentComposite;
	private MultiPageEditor mpe;

	public ChooseFMSelectionListener(Composite composite,
			MultiPageEditor multiPageEditor) {
		this.parentComposite = composite;
		this.mpe = multiPageEditor;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.swt.events.SelectionListener#widgetSelected(org.eclipse.swt
	 * .events.SelectionEvent)
	 */
	@Override
	public void widgetSelected(SelectionEvent e) {
		// open FileDialog for workspace.
//		browseMapping();
		
		 FileDialog dialog = new FileDialog (parentComposite.getShell(),
		 SWT.OPEN);
		 String [] filterNames = new String [] {"FeatureMapping",
		 "All Files (*)"};
		 String [] filterExtensions = new String [] {"*.featuremapping", "*"};
		 String filterPath =
		 ResourcesPlugin.getWorkspace().getRoot().getLocation().toOSString();
		 dialog.setFilterNames (filterNames);
		 dialog.setFilterExtensions (filterExtensions);
		 dialog.setFilterPath (filterPath);
		 dialog.setFileName ("featureClusterMapping");
		 // call mpe with the FeatureMapping
		 String path = dialog.open();
		 log.debug(path);
		 mpe.setFeatureMapping(path);
	}
	
	/**
	 * opens a Dialog to choose a mapping.
	 */
	private void browseMapping() {
		List<ViewerFilter> filters = new ArrayList<ViewerFilter>();
		FileExtensionViewerFilter featureModelViewerFilter = new FileExtensionViewerFilter(
				FeatureMappingUtil.getMappingModelExtensions());
		filters.add(featureModelViewerFilter);
		IFile[] selectedFiles = WorkspaceResourceDialog.openFileSelection(
				parentComposite.getShell(), "Choose mapping",
				"Please choose a mapping:", false, null, filters);

		if (selectedFiles.length > 0) {
			String path = selectedFiles[0].getFullPath().toFile().getPath();
			log.debug(path);
			mpe.setFeatureMapping(path);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.swt.events.SelectionListener#widgetDefaultSelected(org.eclipse
	 * .swt.events.SelectionEvent)
	 */
	@Override
	public void widgetDefaultSelected(SelectionEvent e) {
	}
}

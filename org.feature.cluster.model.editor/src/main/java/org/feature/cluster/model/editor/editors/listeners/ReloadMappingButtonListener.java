/**
 * 
 */
package org.feature.cluster.model.editor.editors.listeners;

import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.feature.cluster.model.editor.editors.MultiPageEditor;

/**
 * @author winkelti
 *
 */
public class ReloadMappingButtonListener implements SelectionListener {
	MultiPageEditor multiPageEditor;
	public ReloadMappingButtonListener(MultiPageEditor multiPageEditor) {
		this.multiPageEditor = multiPageEditor;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.swt.events.SelectionListener#widgetSelected(org.eclipse.swt.events.SelectionEvent)
	 */
	@Override
	public void widgetSelected(SelectionEvent e) {
		multiPageEditor.setFeatureMapping(multiPageEditor.getMappingResourcePath());
	}

	/* (non-Javadoc)
	 * @see org.eclipse.swt.events.SelectionListener#widgetDefaultSelected(org.eclipse.swt.events.SelectionEvent)
	 */
	@Override
	public void widgetDefaultSelected(SelectionEvent e) {
		// TODO Auto-generated method stub

	}

}

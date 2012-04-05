/**
 * 
 */
package org.feature.multi.perspective.model.editor.editors.listeners;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.ui.dialogs.WorkspaceResourceDialog;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Composite;
import org.feature.multi.perspective.model.cluster.GroupModel;
import org.feature.multi.perspective.model.editor.editors.ClusterMappingFilter;
import org.feature.multi.perspective.model.editor.editors.ClusterMultiPageEditor;
import org.featuremapper.common.utils.FeatureMappingUtil;

/**
 * Listener for the selection of the FeatureMapping.
 * 
 * @author Tim Winkelmann
 * 
 */
public class ChooseFMSelectionListener implements SelectionListener {

   Logger log = Logger.getLogger(ChooseFMSelectionListener.class);
   private Composite parentComposite;
   private ClusterMultiPageEditor mpe;

   public ChooseFMSelectionListener(Composite composite, ClusterMultiPageEditor multiPageEditor) {
      this.parentComposite = composite;
      this.mpe = multiPageEditor;
   }

   /*
    * (non-Javadoc)
    * 
    * @see org.eclipse.swt.events.SelectionListener#widgetSelected(org.eclipse.swt .events.SelectionEvent)
    */
   @Override
   public void widgetSelected(SelectionEvent e) {
      // open FileDialog for workspace.
      browseMapping();
   }

   /**
    * opens a Dialog to choose a mapping.
    */
   private void browseMapping() {
      List<ViewerFilter> filters = new ArrayList<ViewerFilter>();
      ArrayList<String> extensions = FeatureMappingUtil.getMappingModelExtensions();
      GroupModel groupModel = mpe.getGroupModel();

      ClusterMappingFilter filter = new ClusterMappingFilter(extensions, groupModel);
      filters.add(filter);

      IFile[] selectedFiles =
         WorkspaceResourceDialog.openFileSelection(parentComposite.getShell(), "Choose mapping", "Please choose a mapping:", false, null,
                                                   filters);

      if (selectedFiles.length > 0) {
         String path = selectedFiles[0].getFullPath().toString();
         log.debug(path);
         URI uri = URI.createPlatformResourceURI(path, true);
         mpe.setFeatureMapping(uri);
      }
   }

   /*
    * (non-Javadoc)
    * 
    * @see org.eclipse.swt.events.SelectionListener#widgetDefaultSelected(org.eclipse .swt.events.SelectionEvent)
    */
   @Override
   public void widgetDefaultSelected(SelectionEvent e) {}
}

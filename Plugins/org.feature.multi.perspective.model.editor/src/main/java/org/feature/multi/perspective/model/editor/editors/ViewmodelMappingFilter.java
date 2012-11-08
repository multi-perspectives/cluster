/**
 * 
 */
package org.feature.multi.perspective.model.editor.editors;

import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jface.viewers.Viewer;
import org.feature.model.utilities.FeatureMappingUtil;
import org.feature.model.utilities.ResourceUtil;
import org.feature.multi.perspective.mapping.viewmapping.MappingModel;
import org.feature.multi.perspective.model.viewmodel.GroupModel;
import org.featuremapper.ui.views.filter.FileExtensionViewerFilter;

/**
 * This filter displays only featuremappings that have a given viewmodel model set as a solutionspace model.
 * 
 * @author <a href=mailto:info@juliaschroeter.de>Julia Schroeter</a>
 * 
 */
public class ViewmodelMappingFilter extends FileExtensionViewerFilter {

   private final ResourceSet resourceSet;
   private final IFile groupmodelFile;

   public ViewmodelMappingFilter(List<String> extensions, GroupModel groupmodel) {
      super(extensions);
      this.resourceSet = groupmodel.eResource().getResourceSet();
      this.groupmodelFile = ResourceUtil.getFile(groupmodel.eResource());
   }

   @Override
   public boolean select(Viewer viewer, Object parentElement, Object element) {
      boolean select = super.select(viewer, parentElement, element);
      if (select) {
         if (element instanceof IFile) {
            IFile file = (IFile) element;
            MappingModel mapping = FeatureMappingUtil.getFeatureMapping(file, resourceSet);
               GroupModel groupModel = mapping.getViewModel();
               if (groupModel != null){
                     IFile modelFile = ResourceUtil.getFile(groupModel.eResource());
                     select = groupmodelFile.equals(modelFile);
                  }
         }}
      return select;
   }

}

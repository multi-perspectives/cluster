/**
 * 
 */
package org.feature.multi.perspective.model.editor.editors;

import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jface.viewers.Viewer;
import org.feature.model.utilities.ResourceUtil;
import org.feature.multi.perspective.model.cluster.GroupModel;
import org.featuremapper.models.featuremapping.FeatureMappingModel;
import org.featuremapper.models.featuremapping.SolutionModelRef;
import org.featuremapper.ui.views.filter.FileExtensionViewerFilter;

/**
 * This filter displays only featuremappings that have a given cluster model set as a solutionspace model.
 * 
 * @author <a href=mailto:info@juliaschroeter.de>Julia Schroeter</a>
 * 
 */
public class ClusterMappingFilter extends FileExtensionViewerFilter {

   private final ResourceSet resourceSet;
   private final IFile groupmodelFile;

   public ClusterMappingFilter(List<String> extensions, GroupModel groupmodel) {
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
            EObject model = ResourceUtil.getModel(file, resourceSet);
            if (model instanceof FeatureMappingModel) {
               FeatureMappingModel mapping = (FeatureMappingModel) model;
               EList<SolutionModelRef> solutionModels = mapping.getSolutionModels();
               for (SolutionModelRef solutionModelRef : solutionModels) {
                  EObject solution = solutionModelRef.getValue();
                  if (solution instanceof GroupModel) {
                     GroupModel gModel = (GroupModel) solution;
                     IFile modelFile = ResourceUtil.getFile(gModel.eResource());
                     select = groupmodelFile.equals(modelFile);
                  }
               }
            } else {
               select = false;
            }
         }
      }
      return select;
   }

}

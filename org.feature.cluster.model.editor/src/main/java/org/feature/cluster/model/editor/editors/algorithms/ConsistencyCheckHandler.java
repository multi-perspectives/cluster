/**
 * 
 */
package org.feature.cluster.model.editor.editors.algorithms;

import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.feature.cluster.model.cluster.GroupModel;
import org.feature.cluster.model.editor.editors.View;
import org.feature.cluster.model.editor.editors.ViewCreater;
import org.featuremapper.models.feature.FeatureModel;
import org.featuremapper.models.featuremapping.FeatureMappingModel;
import org.featuremapper.models.featuremapping.FeatureMappingPackage;
import org.featuremapper.models.featuremapping.FeatureModelRef;
import org.js.model.utilities.FeatureMappingUtil;

/**
 * Handler that triggers both consistency check algorithm to compare their preformance.
 * 
 * @author <a href=mailto:info@juliaschroeter.de>Julia Schroeter</a>
 * 
 */
public class ConsistencyCheckHandler extends AbstractHandler {

   private static String generatedProject = "generatedProject";
   protected static String mappingFolder = FeatureMappingPackage.eNS_PREFIX;

   private static Logger log = Logger.getLogger(ConsistencyCheckHandler.class);

   @Override
   public Object execute(ExecutionEvent event) throws ExecutionException {
      IWorkspace workspace = ResourcesPlugin.getWorkspace();
      IProject project = workspace.getRoot().getProject(generatedProject);
      if (project.exists()) {
         IFolder projectFolder = project.getFolder(mappingFolder);
         if (projectFolder.exists()) {
            ResourceSet resourceSet = new ResourceSetImpl();
            IResource[] members;
            try {
               members = projectFolder.members();
               for (IResource iResource : members) {
                  if (iResource instanceof IFile) {
                     IFile file = (IFile) iResource;
                     FeatureMappingModel mapping = FeatureMappingUtil.getFeatureMapping(file, resourceSet);
                     if (mapping != null) {
                        checkConsistency(mapping, resourceSet);
                     }
                  }
               }
            } catch (CoreException e) {
               log.error("Could not determine children of folder " + projectFolder);
            }

         }
      }
      return null;
   }

   private void checkConsistency(FeatureMappingModel featureMapping, ResourceSet resourceSet) {
      GroupModel groupModel = FeatureMappingUtil.getSolutionClusterModel(featureMapping, resourceSet);
      FeatureModelRef fmRef = featureMapping.getFeatureModel();
      if (fmRef != null) {
         FeatureModel featureModel = fmRef.getValue();
         ViewCreater viewCreator = new ViewCreater(groupModel, featureMapping, featureModel);
         List<View> views = viewCreator.getViews();
         runIncremental(views, groupModel, featureModel);
         runHeuristic(views, groupModel, featureModel);
      }
   }

   private void runHeuristic(List<View> views, GroupModel groupModel, FeatureModel featureModel) {
      BruteForceAlgorithm algorithm = new BruteForceAlgorithm(groupModel, views, featureModel);
      algorithm.checkViewPoints();

   }

   private void runIncremental(List<View> views, GroupModel groupModel, FeatureModel featureModel) {
      IncrementalAlgorithm algorithm = new IncrementalAlgorithm(views, groupModel, featureModel);
      algorithm.run();
   }

}

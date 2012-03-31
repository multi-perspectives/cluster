/**
 * 
 */
package org.feature.cluster.model.editor.editors.algorithms;

import java.util.Collection;
import java.util.LinkedList;
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
	   log.debug("execute consistency check!");
      IWorkspace workspace = ResourcesPlugin.getWorkspace();
      IProject project = workspace.getRoot().getProject(generatedProject);
      if (project.exists()) {
         IFolder projectFolder = project.getFolder(mappingFolder);
         if (projectFolder.exists()) {
            ResourceSet resourceSet = new ResourceSetImpl();
            IResource[] members;
            try {
               members = projectFolder.members();
               List<Long> bfs = new LinkedList<Long>();
               List<Long> heu = new LinkedList<Long>();
               List<Integer> fms = new LinkedList<Integer>();
               List<Integer> numberViews = new LinkedList<Integer>();
               for (IResource iResource : members) {
                  if (iResource instanceof IFile) {
                     IFile file = (IFile) iResource;
                     FeatureMappingModel mapping = FeatureMappingUtil.getFeatureMapping(file, resourceSet);
                     if (mapping != null) {
                        checkConsistency(mapping, resourceSet,bfs,heu,fms,numberViews);
                     }
                  }
               }
              printCollection(fms);
              printCollection(numberViews);
              printCollection(bfs);
              printCollection(heu);
              
            } catch (CoreException e) {
               log.error("Could not determine children of folder " + projectFolder);
            }

         }
      }
      return null;
   }

   private void printCollection(Collection<Integer> list){
	   String s = "{";
	   for (Integer l : list) {
		s =s + l + ", ";
	   }
	   s= s + "};";
	   log.debug(s);
   }
   
   private long printCollection(List<Long> list){
	   String s = "{";
	   long x = 0;
	   for (Long l : list) {
		s =s + l + ", ";
 		x += l;
	   }
	   s= s + "};";
	   log.debug(s);
	   return x / list.size();
   }
   
   private void checkConsistency(FeatureMappingModel featureMapping, ResourceSet resourceSet, List<Long> bfs, List<Long> heu, List<Integer> fms, List<Integer> numberViews) {
      GroupModel groupModel = FeatureMappingUtil.getSolutionClusterModel(featureMapping, resourceSet);
      FeatureModelRef fmRef = featureMapping.getFeatureModel();
      if (fmRef != null) {
         FeatureModel featureModel = fmRef.getValue();
         ViewCreater viewCreator = new ViewCreater(groupModel, featureMapping, featureModel);
         List<View> views = viewCreator.getViews();
         fms.add(featureModel.getAllFeatures().size());
         numberViews.add(views.size());
         
         long time = System.currentTimeMillis();
         runIncremental(views, groupModel, featureModel);
         bfs.add(System.currentTimeMillis()-time);
         time = System.currentTimeMillis();
         runHeuristic(views, groupModel, featureModel);
         heu.add(System.currentTimeMillis() - time);
      }
   }

   private void runHeuristic(List<View> views, GroupModel groupModel, FeatureModel featureModel) {
	   IncrementalAlgorithm algorithm = new IncrementalAlgorithm(views, groupModel, featureModel);
	   algorithm.run();
   }

   private void runIncremental(List<View> views, GroupModel groupModel, FeatureModel featureModel) {
	   BruteForceAlgorithm algorithm = new BruteForceAlgorithm(groupModel, views, featureModel);
	   algorithm.checkViewPoints();
   }

}

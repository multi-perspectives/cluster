/**
 * 
 */
package org.feature.cluster.model.editor.editors.algorithms;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.feature.cluster.model.cluster.CoreGroup;
import org.feature.cluster.model.cluster.Group;
import org.feature.cluster.model.cluster.GroupModel;
import org.feature.cluster.model.cluster.ViewPoint;
import org.feature.cluster.model.editor.editors.View;
import org.featuremapper.models.feature.Feature;
import org.featuremapper.models.feature.FeatureModel;

/**
 * This class represent the BruteForceAlgorithm which validates the {@link ViewPoint}
 * 
 * @author Tim Winkelmann
 * 
 */
public class BruteForceAlgorithm {

   private Logger log = Logger.getLogger(BruteForceAlgorithm.class);
   private Set<View> viewPoints;
   private GroupModel groupModel;
   private List<View> views;
   private FeatureModel featureModel;

   public BruteForceAlgorithm(GroupModel groupModel, List<View> views, FeatureModel featureModel) {
      this.groupModel = groupModel;
      this.views = views;
      this.featureModel = featureModel;
   }

   /**
    * iterate over each view point and there groups. checks then there combined view consistency
    * 
    * @param groupModel contains the view points
    * @param views2 contains all views
    */
   public Set<View> checkViewPoints() {
//	   long time = System.currentTimeMillis();
      EList<ViewPoint> viewPointsToCheck = groupModel.getViewPointContainer().getViewPoints();
      HashMap<EObject, View> viewMemory = new HashMap<EObject, View>();
      viewPoints = new HashSet<View>();
      for (ViewPoint viewPoint : viewPointsToCheck) {
         // log.debug("ViewPoint: " + viewPoint.getName());
         viewPoints.add(checkViewpoint(viewPoint, views, groupModel.getCoreGroup(), viewMemory));
      }
//      log.debug("BF: " + (System.currentTimeMillis()-time));
      return viewPoints;
   }

   /**
    * check the viewpoint
    * 
    * @param viewPoint the view point
    * @param views the views
    * @param coreGroup the coreGroup
    */
   private View checkViewpoint(ViewPoint viewPoint, List<View> views, CoreGroup coreGroup, HashMap<EObject, View> viewMemory) {
      EList<Group> containedInGroup = viewPoint.getContainedInGroup();
      Set<Set<View>> setOfPaths = new HashSet<Set<View>>();
      for (Group group : containedInGroup) {
         List<EObject> groups = getGroupPath(group, coreGroup);
         // log.debug("check path for: " + group.getName());
         viewMemory.clear(); // performance test without memory
         Set<View> path = new HashSet<View>();
         if (!viewMemory.containsKey(group)) {
            path = checkPath(groups, views, viewMemory);
         } else {
            path = new HashSet<View>();
            path.add(viewMemory.get(group));
         }
         setOfPaths.add(path);
      }
      if (setOfPaths.isEmpty()) {
         // log.debug("check path for: coreGroup");
         // log.debug(views.get(0).group);
         views.get(0).isConsistent();
         // log.debug(views.get(0).isConsistent());
         return views.get(0);
      } else {
         Set<Feature> features = new HashSet<Feature>();

         for (Set<View> path : setOfPaths) {
            for (View view : path) {
               // log.debug(view.isConsistent());
               features.addAll(view.getFeatures());
            }
         }
         View view = new View(viewPoint, features, this.featureModel);
          view.isConsistent();
         // log.debug(view.isConsistent() + "\n");
         return view;
      }
   }

   /**
    * create views for every group. the views extends the previous one.
    * 
    * @param path has to be sorted from root to target!
    * @param views
    * @param viewMemory
    * @return
    */
   private Set<View> checkPath(List<EObject> path, List<View> views, HashMap<EObject, View> viewMemory) {
      Set<View> pathViews = new HashSet<View>();
      for (EObject group : path) {
         View view = viewMemory.get(group);
         if (view != null) {// check if view was already calculated
            pathViews.add(view);
            // log.debug("skipped: " + group);
            continue;
         }
         // find a view
         for (View v : views) {
            if (v.getGroup().equals(group)) {
               view = v;
               break;
            }
         }
         if (view == null) {
            log.error("could not find a view");
            return pathViews;
         }
         Set<Feature> features = new HashSet<Feature>();// combine view
         features.addAll(view.getFeatures());
         for (View v : pathViews) {
            features.addAll(v.getFeatures());
         }
         if (!features.isEmpty()) {// check if there is something to combine
            view = new View(group, features, this.featureModel);
         }
         // log.debug("add: " + group);
         pathViews.add(view);
         viewMemory.put(group, view);
      }
      return pathViews;
   }

   /**
    * get all ancestors from that group
    * 
    * @param group a group from the tree
    * @param coreGroup the core group
    * @return the path from the coreGroup to the group
    */
   private List<EObject> getGroupPath(Group group, CoreGroup coreGroup) {
      List<EObject> groups = new LinkedList<EObject>();
      groups.add(coreGroup);
      for (Group childGroup : coreGroup.getGroups()) {
         List<Group> calcGroupPath = calcGroupPath(group, childGroup);
         if (!calcGroupPath.isEmpty()) {
            groups.addAll(calcGroupPath);
            break;
         }
      }
      return groups;
   }

   /**
    * calculates path to group
    * 
    * @param target the target group
    * @param source the current group
    * @return the path or an empty list
    */
   private List<Group> calcGroupPath(Group target, Group source) {
      if (target.equals(source)) {
         List<Group> groups = new LinkedList<Group>();
         groups.add(target);
         return groups;
      } else {// check children
         for (Group group : source.getGroups()) {
            List<Group> calcGroupPath = calcGroupPath(target, group);
            if (!calcGroupPath.isEmpty()) {
               calcGroupPath.add(0, source);// the index used to be sorted!
               return calcGroupPath;
            }
         }
      }
      return new LinkedList<Group>();
   }

   /**
    * @return the viewPoints
    */
   public Set<View> getViewPoints() {
      return viewPoints;
   }

}

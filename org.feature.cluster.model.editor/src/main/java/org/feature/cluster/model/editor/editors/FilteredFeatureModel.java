package org.feature.cluster.model.editor.editors;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.feature.cluster.model.cluster.CoreGroup;
import org.feature.cluster.model.cluster.Group;
import org.feature.cluster.model.cluster.GroupModel;
import org.feature.cluster.model.cluster.ViewPoint;
import org.featuremapper.models.feature.Feature;
import org.featuremapper.models.featuremapping.FeatureMappingModel;
import org.featuremapper.models.featuremapping.FeatureModelRef;
import org.featuremapper.models.featuremapping.Mapping;
import org.featuremapper.models.featuremapping.SolutionModelRef;

/**
 * create the filtered feature model and validates it.
 * also validates all view points.
 * @author Tim Winkelmann
 *
 */
public class FilteredFeatureModel {
	private static Logger log = Logger.getLogger(FilteredFeatureModel.class);
	
	/**
	 * 
	 * @param mappingResource
	 * @param viewPoint
	 */
	public FilteredFeatureModel(Resource mappingResource, ViewPoint viewPoint) {
		EList<EObject> contents = mappingResource.getContents();
		FeatureMappingModel featureMappingModel = null;
		for (EObject eObject : contents) {
			if (eObject instanceof FeatureMappingModel) {
				featureMappingModel = (FeatureMappingModel) eObject;
				break;
			}
		}
		EList<Feature> allFeatures = featureMappingModel.getFeatureModel().getValue().getAllFeatures();

		log.debug("#allFeatures: " + allFeatures.size());
		//create views
		EList<SolutionModelRef> solutionModels = featureMappingModel.getSolutionModels();
		GroupModel groupModel = null;
		for (SolutionModelRef solutionModelRef : solutionModels) {
			EObject value = solutionModelRef.getValue();
			if (value instanceof GroupModel) {
				groupModel = (GroupModel) value;
				break;
			}
		}
		EList<Mapping> mappings = featureMappingModel.getMappings();
		ViewCreater viewCreater = new ViewCreater(allFeatures,mappings,  groupModel.getCoreGroup());
		List<View> views2 = viewCreater.getViews();
		long timeMillis = System.currentTimeMillis();
		new IncrementalAlgorithm(views2,groupModel);
		log.debug("time: " + (System.currentTimeMillis() - timeMillis));
		timeMillis = System.currentTimeMillis();
		//view consistency check
//		checkViews(views2);
		Set<View> checkViewPoints = checkViewPoints(groupModel,views2);
		log.debug("time: " + (System.currentTimeMillis() - timeMillis));
		View viewP = null;
		for (View view : checkViewPoints) {
			if (view.group instanceof ViewPoint) {
				ViewPoint vp = (ViewPoint) view.group;
				if (vp.getName().equals(viewPoint.getName())) {
					viewP = view;
					break;
				}
			}
		}
		if (viewP != null) {
			createFeatureModel(featureMappingModel,viewPoint,viewP);
		}else{
			log.error("Could not create ViewPoint");
		}
	}
	
	/**
	 * creates the feature model and persist it in a file.
	 * @param featureMappingModel the mapping
	 * @param viewPoint the viewpoint
	 * @param view the features to the viewpoint
	 */
	private void createFeatureModel(FeatureMappingModel featureMappingModel, ViewPoint viewPoint, View view){
		log.debug("#Features for a ViewPoint:  " + view.features.size());
		Map<String, Feature> featureMap = new HashMap<String, Feature>();
		Set<Feature> features = view.features;
		for (Feature feature : features) {
			featureMap.put(feature.getName(), feature);
		}
		FeatureModelRef org = featureMappingModel.getFeatureModel();
		Filter filter = new Filter(org,featureMap);
		
		log.debug(filter.fm);
		ResourceSet rst = new ResourceSetImpl();//TODO Save Dialog
		Resource resource = rst.createResource(URI.createPlatformResourceURI("/Test/" + featureMappingModel.getFeatureModel().getValue().getName() + "_" + viewPoint.getName() + ".feature",true));
		resource.getContents().add(filter.fm);
		try {
			resource.save(Collections.EMPTY_MAP);
		} catch (IOException e) {
			log.error(e.getMessage());
		}
	}
	/**
	 * iterate over each view point and there groups.
	 * checks then there combined view consistency
	 * @param groupModel contains the view points
	 * @param views2 contains all views
	 */
	private Set<View> checkViewPoints(GroupModel groupModel, List<View> views) {
		EList<ViewPoint> viewPoints = groupModel.getViewPoints().getViewPoints();
		HashMap<EObject,View> viewMemory = new HashMap<EObject, View>();
		Set<View> viewPoints2 = new HashSet<View>();
		for (ViewPoint viewPoint : viewPoints) {
//			log.debug("ViewPoint: " + viewPoint.getName());
			viewPoints2.add(checkViewpoint(viewPoint,views,groupModel.getCoreGroup(),viewMemory));
		}
		return viewPoints2;
	}
	/**
	 * check the viewpoint
	 * @param viewPoint the view point
	 * @param views the views
	 * @param coreGroup the coreGroup
	 */
	private View checkViewpoint(ViewPoint viewPoint, List<View> views, CoreGroup coreGroup,HashMap<EObject,View> viewMemory) {
		EList<Group> containedInGroup = viewPoint.getContainedInGroup();
		Set<Set<View>> setOfPaths = new HashSet<Set<View>>();
		for (Group group : containedInGroup) {
			List<EObject> groups = getGroupPath(group,coreGroup);
//			log.debug("check path for: " + group.getName());
			viewMemory.clear(); // performance test without memory
			Set<View> path = new HashSet<View>();
			if (!viewMemory.containsKey(group)) {
				path = checkPath(groups,views,viewMemory);
			}else{
				path = new HashSet<View>();
				path.add(viewMemory.get(group));
			}
			setOfPaths.add(path);
		}
		if (setOfPaths.isEmpty()) {
//			log.debug("check path for: coreGroup");
//			log.debug(views.get(0).group);
			views.get(0).isConsistent();
//			log.debug(views.get(0).isConsistent());
			return views.get(0);
		}else{
			Set<Feature> features = new HashSet<Feature>();
			for (Set<View> path : setOfPaths) {
				for (View view : path) {
//					log.debug(view.isConsistent());
					features.addAll(view.features);
				}
			}
			View view = new View(viewPoint, features);
//			view.isConsistent();
//			log.debug(view.isConsistent() + "\n");
			return view;
		}
	}
	
	/**
	 * create views for every group. the views extends the previous one.
	 * @param path has to be sorted from root to target!
	 * @param views
	 * @param viewMemory
	 * @return
	 */
	private Set<View> checkPath(List<EObject> path, List<View> views,HashMap<EObject,View> viewMemory) {
		Set<View> pathViews = new HashSet<View>();
		for (EObject group : path) {
			View view = viewMemory.get(group);
			if (view != null) {//check if view was already calculated
				pathViews.add(view);
//				log.debug("skipped: " + group);
				continue;
			}
			// find a view
			for (View v : views) {
				if (v.group.equals(group)) {
					view = v;
					break;
				}
			}
			if (view == null) {
				log.error("could not find a view");
				return pathViews;
			}
			Set<Feature> features = new HashSet<Feature>();//combine view
			features.addAll(view.features);
			for (View v : pathViews) {
				features.addAll(v.features);
			}
			if (!features.isEmpty()) {//check if there is something to combine
				view = new View(group, features);
			}
//			log.debug("add: " + group);
			pathViews.add(view);
			viewMemory.put(group, view);
		}
		return pathViews;
	}

	/**
	 * get all ancestors from that group
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
	 * @param target the target group
	 * @param source the current group
	 * @return the path or an empty list
	 */
	private List<Group> calcGroupPath(Group target, Group source){
		if (target.equals(source)) {
			List<Group> groups = new LinkedList<Group>();
			groups.add(target);
			return groups;
		}else{//check children
			for (Group group : source.getGroups()) {
				List<Group> calcGroupPath = calcGroupPath(target, group);
				if (!calcGroupPath.isEmpty()) {
					calcGroupPath.add(0, source);//the index used to be sorted!
					return calcGroupPath;
				}
			}
		}
		return new LinkedList<Group>();
	}
}

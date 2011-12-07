package org.feature.cluster.model.editor.editors;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
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
import org.feature.cluster.model.cluster.GroupModel;
import org.feature.cluster.model.cluster.ViewPoint;
import org.feature.cluster.model.editor.editors.algorithms.BruteForceAlgorithm;
import org.feature.cluster.model.editor.editors.algorithms.IncrementalAlgorithm;
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

		log.info("#allFeatures: " + allFeatures.size());
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
		List<View> views = viewCreater.getViews();
		long timeMillis = System.currentTimeMillis();
		
		new IncrementalAlgorithm(views,groupModel);

		log.debug("time: " + (System.currentTimeMillis() - timeMillis));
		timeMillis = System.currentTimeMillis();

		BruteForceAlgorithm bfa = new BruteForceAlgorithm(groupModel,views);
		Set<View> checkViewPoints = bfa.getViewPoints();

		log.debug("time: " + (System.currentTimeMillis() - timeMillis));

		//Find specific ViewPoint
		View viewP = null;
		for (View view : checkViewPoints) {
			if (view.getGroup() instanceof ViewPoint) {
				ViewPoint vp = (ViewPoint) view.getGroup();
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
		log.debug("#Features for a ViewPoint:  " + view.getFeatures().size());
		Map<String, Feature> featureMap = new HashMap<String, Feature>();
		Set<Feature> features = view.getFeatures();
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


}

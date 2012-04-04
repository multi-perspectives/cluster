/**
 * 
 */
package org.feature.multi.perspective.model.editor.editors;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.featuremapper.models.feature.Constraint;
import org.featuremapper.models.feature.Feature;
import org.featuremapper.models.feature.FeatureModel;
import org.featuremapper.models.feature.Group;
import org.featuremapper.models.featuremapping.FeatureModelRef;

/**
 * @author winkelti
 *
 */
public class Filter {
	FeatureModel fm;
	private Map<String, Feature> featureMap;
	private FeatureModel orgFeatureModel;
	
	public Filter(FeatureModelRef org, Map<String, Feature> featureMap) {
		this.featureMap = featureMap;
		orgFeatureModel = org.getValue();
		Feature orgRoot = orgFeatureModel.getRoot();
		if (featureMap.containsKey(orgRoot.getName())) {
			fm = EcoreUtil.copy(orgFeatureModel);
			fm.setRoot(copyFeature(orgRoot,null));
			assert(fm.getAllFeatures().size() == featureMap.size());
			EList<EAttribute> eAllAttributes = org.getValue().eClass().getEAllAttributes();
			for (EAttribute eAttribute : eAllAttributes) {
				fm.eSet(eAttribute, org.getValue().eGet(eAttribute));
			}
			fm.getConstraints().clear();
			checkConstraints(orgFeatureModel.getConstraints(),fm.getAllFeatures());
		}
		//root feature not selected
	}
	
	/**
	 * removes every constraints which contains features that are not in the new {@link FeatureModel}.
	 * @param constraints
	 * @param featureModelFeatures 
	 */
	private void checkConstraints(EList<Constraint> constraints, EList<Feature> featureModelFeatures){
		Map<String, Feature> fmfMap = new HashMap<String, Feature>();
		for (Feature feature : featureModelFeatures) {
			fmfMap.put(feature.getName(), feature);
		}
		List<Constraint> tempConstraints = new LinkedList<Constraint>();
		tempConstraints.addAll(constraints);
		for (Constraint constraint : tempConstraints) {
			EList<Feature> constrainedFeatures = constraint.getConstrainedFeatures();
			boolean remove = false;
			for (Feature feature : constrainedFeatures) {
				if (!this.featureMap.containsKey(feature.getName())) {
					remove = true;
					break;
				}
			}
			String expr = constraint.getExpression();
			expr = expr.replaceAll("\"", "");
			int index = expr.toLowerCase().indexOf("not ", 0);
			if (index == 0) {
				expr = expr.substring(4);
			}
			if (!this.featureMap.containsKey(expr)) {
				remove = true;
			}
			if (!remove) { //replace old references with new
				Constraint copy = EcoreUtil.copy(constraint);
				List<Feature> features = new LinkedList<Feature>();
				for (Feature feature : constrainedFeatures) {
					features.add(fmfMap.get(feature.getName()));
				}
				copy.setExpression(constraint.getExpression());
				copy.setLanguage(constraint.getLanguage());
				copy.getConstrainedFeatures().addAll(features);
				this.fm.getConstraints().add(copy);
			}
		}
	}
	
	/**
	 * 
	 * @param orgFeature
	 * @param parentGroup
	 * @return
	 */
	private Feature copyFeature(Feature orgFeature, Group parentGroup) {
		Feature feature = EcoreUtil.copy(orgFeature);
		copyGroups(feature.getGroups(), feature);
		feature.setParentGroup(parentGroup);
		return feature;
	}
	
	/**
	 * 
	 * @param groups
	 * @return
	 */
	private void copyGroups(EList<Group> groups,Feature parentFeature) {
		List<Feature> features = null;
		boolean removeGroups = false;
		List<Group> removeGroupsList = new LinkedList<Group>();
		for (Group group : groups) {
			features = new LinkedList<Feature>();
			int numberOfOriginalFeatures = group.getChildFeatures().size();
			List<Feature> childFeatures = new LinkedList<Feature>();
			childFeatures.addAll(group.getChildFeatures());
			for (Feature feature : childFeatures) {
				if (featureMap.containsKey(feature.getName())) {
					Feature copyFeature = copyFeature(feature, group);
					features.add(copyFeature);
				}
			}
			group.getChildFeatures().clear();
			group.getChildFeatures().addAll(features);
			group.setParentFeature(parentFeature);
			if (group.getChildFeatures().isEmpty()) {
				removeGroups=true;//memory a group for removal.
				removeGroupsList.add(group);
				continue;
			}
			if (group.getMaxCardinality() > 0) { // max could be -1
				group.setMaxCardinality(group.getMaxCardinality() - (numberOfOriginalFeatures - group.getChildFeatures().size()));
				if (group.getMaxCardinality() < group.getMinCardinality()) {
					group.setMaxCardinality(group.getMinCardinality());
				}
			}
//			System.out.println(group.getMinCardinality() + ":" + group.getMaxCardinality());
		}
		if (removeGroups) {
			groups.removeAll(removeGroupsList);
		}
	}
}

package org.feature.model.slicer.modelSlicer;

import org.feature.model.slicer.extendedModel.classification.ClassifierHandler;
import org.featuremapper.models.feature.Feature;
import org.featuremapper.models.feature.FeatureModel;
import org.featuremapper.models.feature.Group;

public class ModelSlicer {

	/**
	 * remove all features which are classified with dead or alive
	 * 
	 * @param model
	 *            to slice
	 * @param cHandler
	 *            with meta informations about classification
	 * @return
	 */
	public FeatureModel slice(FeatureModel model, ClassifierHandler cHandler) {
		for (Feature toRemove : cHandler.getBoundAliveFeatures()) {
			moveGroupsUp(toRemove);
			remove(toRemove, true);
		}

		for (Feature toRemove : cHandler.getBoundDeadFeatures()) {
			moveGroupsUp(toRemove);
			remove(toRemove, false);
		}

		return model;
	}

	/**
	 * remove the feature from model and modify the group cardinality to at
	 * least [0,0]
	 * 
	 * @param toRemove toRemove
	 * @param isNotDead
	 */
	protected void remove(Feature toRemove, boolean isNotDead) {
		Group parentGroup = toRemove.getParentGroup();
		parentGroup.getChildFeatures().remove(toRemove);
		if (parentGroup.getChildFeatures().isEmpty()) {
			parentGroup.getParentFeature().getGroups().remove(parentGroup);
		} else if (isNotDead) {
			if (parentGroup.getMaxCardinality() > 0) {
				parentGroup.setMaxCardinality(parentGroup.getMaxCardinality() - 1);
			}
			if (parentGroup.getMinCardinality() > 0) {
				parentGroup.setMinCardinality(parentGroup.getMinCardinality() - 1);
			}
		}

	}

	/**
	 * move all groups of the feature to the parent feature
	 * 
	 * @param toRemove
	 *            which contains the groups to move
	 */
	protected void moveGroupsUp(Feature toRemove) {
		if (!toRemove.getGroups().isEmpty()) {
			toRemove.getParentGroup().getParentFeature().getGroups().addAll(toRemove.getGroups());
		}
	}
}
package org.feature.model.slicer.modelSlicer;

import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.BasicEList;
import org.feature.model.slicer.extendedModel.classification.ClassifierHandler;
import org.featuremapper.models.feature.Constraint;
import org.featuremapper.models.feature.Feature;
import org.featuremapper.models.feature.FeatureModel;
import org.featuremapper.models.feature.Group;

public class MoveUpModelSlicer {

	/**
	 * Logger
	 */
	private static Logger logger = Logger.getLogger(MoveUpModelSlicer.class);

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
		Set<String> bounded = new HashSet<String>();
		for (Feature toRemove : cHandler.getBoundDeadFeatures()) {
			logger.debug("remove bound dead feature " + toRemove.getName());
			remove(toRemove, false);
			bounded.add(toRemove.getName());
		}

		for (Feature toRemove : cHandler.getBoundAliveFeatures()) {
			logger.debug("remove bound alive feature " + toRemove.getName());
			moveGroupsUp(toRemove);
			remove(toRemove, true);
			bounded.add(toRemove.getName());
		}

		for (Constraint constraint : new BasicEList<Constraint>(model.getConstraints())) {
			if (checkConstraint(constraint, bounded)) {
				logger.debug("remove constraint " + constraint.getExpression());
				model.getConstraints().remove(constraint);
			}
		}

		return model;
	}

	/**
	 * check if the constraint contains a feature which name is part of the
	 * feature name set
	 * 
	 * @param constraint
	 *            to check
	 * @param featureNames
	 *            set of feature names
	 * @return true if a feature name is part of the constraint, else false
	 */
	protected boolean checkConstraint(Constraint constraint, Set<String> featureNames) {
		String expression = constraint.getExpression();
		for (String featureName : featureNames) {
			if (expression.contains(featureName)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * remove the feature from model and modify the group cardinality to at
	 * least [0,0]
	 * 
	 * @param toRemove
	 *            toRemove
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
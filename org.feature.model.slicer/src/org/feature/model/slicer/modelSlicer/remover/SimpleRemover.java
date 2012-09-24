package org.feature.model.slicer.modelSlicer.remover;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.tud.es.madras.featuresc.model.DependencyType;
import de.tud.es.madras.featuresc.model.FeatureType;
import de.tud.es.madras.featuresc.model.SCFeature;
import de.tud.es.madras.featuresc.model.SCModel;

/**
 * a simple remover for features, which remove the feature and all sub features
 * and the dependencies to other features
 * 
 * @author Ingo Reimund
 * @create 27.06.2012
 * 
 */
public class SimpleRemover implements IRemover {

	/**
	 * Logger
	 */
	private static Logger logger = LoggerFactory.getLogger(SimpleRemover.class);

	@Override
	public boolean remove(SCFeature removed, SCModel model) {
		logger.info("remove feature '{}'", removed.getName());
		removeChildren(removed, model);
		removeDependencies(removed);
		removeFromParents(removed);
		model.remove(removed.getIdentifier());
		logger.info("finish removing");
		return true;
	}

	/**
	 * remove all children of the given removed feature
	 * 
	 * @param removed
	 *            removed feature
	 * @param model
	 *            model
	 */
	void removeChildren(SCFeature removed, SCModel model) {
		for (FeatureType type : FeatureType.values()) {
			if (FeatureType.NONE.equals(type)) {
				continue;
			}
			for (SCFeature feature : removed.getChildren(type)) {
				model.remove(feature.getIdentifier());
			}
		}
	}

	/**
	 * remove the given feature from all parents
	 * 
	 * @param removed
	 *            removed feature
	 */
	void removeFromParents(SCFeature removed) {
		if (removed.getParent() != null) {
			logger.debug("disconnect feature '{}' from parent '{}'", removed.getName(), removed.getParent().getName());
			removed.getParent().removeChild(removed.getType(), removed);
			removed.setParent(null);
		}
	}

	/**
	 * remove dependencies of the given feature
	 * 
	 * @param removed
	 *            removed feature
	 */
	void removeDependencies(SCFeature removed) {
		for (SCFeature dependency : removed.getDependencies(DependencyType.REQUIRE)) {
			logger.debug("disconnect require from '{}' to '{}'", removed.getName(), dependency.getName());
			removed.removeDependency(DependencyType.REQUIRE, dependency);
			dependency.removeDependency(DependencyType.REQUIRE_FROM, removed);
		}

		for (SCFeature dependency : removed.getDependencies(DependencyType.REQUIRE_FROM)) {
			logger.debug("disconnect requiredFrom from '{}' to '{}'", removed.getName(), dependency.getName());
			removed.removeDependency(DependencyType.REQUIRE_FROM, dependency);
			dependency.removeDependency(DependencyType.REQUIRE, removed);
		}

		for (SCFeature dependency : removed.getDependencies(DependencyType.EXCLUDE)) {
			logger.debug("disconnect exclude from '{}' to '{}'", removed.getName(), dependency.getName());
			removed.removeDependency(DependencyType.EXCLUDE, dependency);
			dependency.removeDependency(DependencyType.EXCLUDE, removed);
		}
	}
}
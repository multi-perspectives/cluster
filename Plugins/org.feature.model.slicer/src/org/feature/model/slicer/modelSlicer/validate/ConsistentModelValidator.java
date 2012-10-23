package org.feature.model.slicer.modelSlicer.validate;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.tud.es.madras.featuresc.FeatureSCProperties;
import de.tud.es.madras.featuresc.model.FeatureType;
import de.tud.es.madras.featuresc.model.InvalidModelException;
import de.tud.es.madras.featuresc.model.SCFeature;
import de.tud.es.madras.featuresc.model.SCModel;
import de.tud.es.madras.featuresc.model.BoundedType;
import de.tud.es.madras.featuresc.model.reasoner.SimpleReasoner;
import de.tud.es.madras.featuresc.model.selector.AlternativeSelector;
import de.tud.es.madras.featuresc.model.selector.OrSelector;

/**
 * validate a model and change an invalid model to a valid one.
 * 
 * @author Ingo Reimund
 * @create 12.05.2012
 * 
 */
public class ConsistentModelValidator {

	/**
	 * Logger
	 */
	private static Logger logger = LoggerFactory.getLogger(ConsistentModelValidator.class);

	/**
	 * name of the property which contains the variability type
	 */
	private String nameVariabilityProperty;

	/**
	 * initialize properties
	 */
	public ConsistentModelValidator() {
		String variabilityIdentifer = FeatureSCProperties.PROPERTY_TYPE_VARIABILITY_GENERATED;
		nameVariabilityProperty = FeatureSCProperties.getInstance().getString(variabilityIdentifer);
	}

	/**
	 * validate a annotated model and check for valid or and alternative groups.
	 * If a group with static parent but without a selection inside the group
	 * was found, the model will be changed to a valid one.
	 * 
	 * @param model
	 *            to check
	 * @throws InvalidModelException 
	 */
	public SCModel validate(SCModel model) throws InvalidModelException {
		for (SCFeature feature : model.getFeatures()) {
			
			if (!isValidAlternative(feature, feature.getChildren(FeatureType.ALTERNATIVE))) {
				AlternativeSelector selector = new AlternativeSelector();
				new SimpleReasoner().reasoning(selector.select(feature.getChildren(FeatureType.ALTERNATIVE)));
				return validate(model);
			}

			if (!isValidOr(feature, feature.getChildren(FeatureType.OR))) {
				OrSelector selector = new OrSelector();
				new SimpleReasoner().reasoning(selector.select(feature.getChildren(FeatureType.OR)));
				return validate(model);
			}
		}
		return model;
	}

	boolean isValidAlternative(SCFeature parent, Set<SCFeature> alternatives) {
		logger.debug("check for valid alternative group of feature '{}'", parent.getName());

		String type = parent.getProperty(nameVariabilityProperty).getValue();

		if (BoundedType.value(type) != BoundedType.ALIVE) {
			logger.debug("parent is not static, group is valid");
			return true;
		}

		if (alternatives.isEmpty()) {
			logger.debug("group is empty, group is valid");
			return true;
		}

		for (SCFeature feature : alternatives) {
			type = feature.getProperty(nameVariabilityProperty).getValue();

			if (BoundedType.value(type) == BoundedType.ALIVE) {
				logger.debug("group have static feature, group is valid");
				return true;
			}
		}

		logger.debug("alternative group of feature '{}' is not valid", parent.getName());
		return false;
	}

	boolean isValidOr(SCFeature parent, Set<SCFeature> ors) {
		logger.debug("check for valid or group of feature '{}'", parent.getName());

		String type = parent.getProperty(nameVariabilityProperty).getValue();

		if (BoundedType.value(type) != BoundedType.ALIVE) {
			logger.debug("parent is not static, group is valid");
			return true;
		}

		if (ors.isEmpty()) {
			logger.debug("group is empty, group is valid");
			return true;
		}

		for (SCFeature feature : ors) {
			type = feature.getProperty(nameVariabilityProperty).getValue();

			if (BoundedType.value(type) == BoundedType.ALIVE) {
				logger.debug("group have static feature, group is valid");
				return true;
			}
		}

		logger.debug("or group of feature '{}' is not valid", parent.getName());
		return false;
	}
}
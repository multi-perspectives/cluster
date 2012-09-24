package org.feature.model.slicer.modelSlicer.scissors.rater;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.tud.es.madras.featuresc.FeatureSCProperties;
import de.tud.es.madras.featuresc.model.SCFeature;
import de.tud.es.madras.featuresc.model.BoundedType;

/**
 * Rate dead feature to remove and alive features to keep
 * 
 * @author Ingo Reimund
 * @create 12.05.2012
 * 
 */
public class NotDeadRater implements IRater {

	/**
	 * Logger
	 */
	private static Logger logger = LoggerFactory.getLogger(NotDeadRater.class);

	/**
	 * name of the property which contains the variability type
	 */
	private String nameVariabilityProperty;

	/**
	 * set name of variability property
	 */
	public NotDeadRater() {
		String variabilityIdentifer = FeatureSCProperties.PROPERTY_TYPE_VARIABILITY_GENERATED;
		nameVariabilityProperty = FeatureSCProperties.getInstance().getString(variabilityIdentifer);
	}

	@Override
	public Rating rate(SCFeature feature) {
		String value = feature.getProperty(nameVariabilityProperty).getValue();
		BoundedType variability = BoundedType.value(value);

		if (variability == null) {
			variability = BoundedType.ALIVE;
		}

		switch (variability) {
		case DEAD:
			logger.debug("feature '{}' is dead", feature.getName());
			return Rating.REMOVE;
		}
		return Rating.KEEP;
	}
}
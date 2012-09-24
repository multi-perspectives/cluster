package org.feature.model.slicer.modelSlicer.scissors.rater;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.tud.es.madras.featuresc.FeatureSCProperties;
import de.tud.es.madras.featuresc.model.SCFeature;
import de.tud.es.madras.featuresc.model.BoundedType;

/**
 * Rate static features to keep and other features to remove
 * 
 * @author Ingo Reimund
 * @create 12.05.2012
 *
 */
public class StaticRater implements IRater {
	
	/**
	 * Logger
	 */
	private static Logger logger = LoggerFactory.getLogger(StaticRater.class);

	/**
	 * name of the property which contains the variability type
	 */
	private String nameVariabilityProperty;
	
	/**
	 * set name of variability property
	 */
	public StaticRater() {
		String variabilityIdentifer = FeatureSCProperties.PROPERTY_TYPE_VARIABILITY_GENERATED;
		nameVariabilityProperty = FeatureSCProperties.getInstance().getString(variabilityIdentifer);
	}

	@Override
	public Rating rate(SCFeature feature) {
		String value = feature.getProperty(nameVariabilityProperty).getValue();
		BoundedType variability = BoundedType.value(value);
		
		if (variability == null) {
			variability = BoundedType.UNBOUND;
		}
		
		switch (variability) {
		case DEAD:
		case UNBOUND:
			logger.debug("feature '{}' is '{}'", feature.getName(), variability);
			return Rating.REMOVE;
		}
		return Rating.KEEP;
	}
}
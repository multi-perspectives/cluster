package org.feature.model.slicer.modelSlicer.scissors.rater;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.tud.es.madras.featuresc.FeatureSCProperties;
import de.tud.es.madras.featuresc.model.FeatureType;
import de.tud.es.madras.featuresc.model.SCFeature;
import de.tud.es.madras.featuresc.model.BoundedType;

/**
 * Rate dynamic features to keep, dead to remove and static to keep, if the
 * static features contains at least one dynamic child.
 * 
 * @author Ingo Reimund
 * @create 12.05.2012
 * 
 */
public class VariableRater implements IRater {

	/**
	 * Logger
	 */
	private static Logger logger = LoggerFactory.getLogger(VariableRater.class);

	/**
	 * store rating
	 */
	private Map<SCFeature, Rating> rated = new HashMap<SCFeature, Rating>();

	/**
	 * name of the property which contains the variability type
	 */
	private String nameVariabilityProperty;

	/**
	 * set name of variability property
	 */
	public VariableRater() {
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

		Rating rating = Rating.KEEP;
		switch (variability) {
		case ROOT:
		case ALIVE:
			rating = validateChildren(feature);
			break;
		case DEAD:
			rating = Rating.REMOVE;
			break;
		}
		logger.debug("rating for feature '{}' is '{}'", feature.getName(), rating);
		rated.put(feature, rating);
		return rating;
	}

	/**
	 * validate children of the given features to find a dynamic child
	 * 
	 * @param feature
	 *            to rate
	 * @return rating
	 */
	public Rating validateChildren(SCFeature feature) {
		for (FeatureType featureType : FeatureType.values()) {
			for (SCFeature child : feature.getChildren(featureType)) {
				Rating rating;
				if (rated.containsKey(child)) {
					rating = rated.get(child);
				} else {
					rating = rate(child);
					rated.put(child, rating);
					logger.debug("child '{}' rated with '{}'", child.getName(), rating);
				}

				if (rating.equals(Rating.KEEP) || rating.equals(Rating.REPLACE)) {
					return Rating.REPLACE;
				}
			}
		}
		return Rating.REMOVE;
	}
}
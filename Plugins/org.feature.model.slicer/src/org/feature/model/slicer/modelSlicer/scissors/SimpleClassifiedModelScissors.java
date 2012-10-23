package org.feature.model.slicer.modelSlicer.scissors;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.tud.es.madras.featuresc.model.SCFeature;
import de.tud.es.madras.featuresc.model.SCModel;
import de.tud.es.madras.featuresc.model.scissors.rater.IRater;

/**
 * Scissors to cut off features which rated to remove based on a given rater.
 * This class require a classified model and ignore some given bounded alive and
 * dead features.
 * 
 * @author Ingo Reimund
 * @create 12.05.2012
 * 
 */
public class SimpleClassifiedModelScissors implements IScissors {

	/**
	 * Logger
	 */
	private static Logger logger = LoggerFactory.getLogger(SimpleClassifiedModelScissors.class);

	/**
	 * rater to handle classified model
	 */
	private IRater rater;

	public SimpleClassifiedModelScissors(IRater rater) {
		this.rater = rater;
	}

	/**
	 * bounded alive and dead features which are given to the method will be
	 * ignored
	 */
	@Override
	public SCModel cut(SCModel model, Set<String> boundedAlive, Set<String> boundedDead) {
		for (SCFeature feature : model.getFeatures()) {
			switch (rater.rate(feature)) {
			case KEEP:
				break;
			case REMOVE:
				logger.debug("remove feature '{}' of model '{}'", feature.getName(), model.getName());
				model.remove(feature.getIdentifier());
				break;
			default:
				logger.warn("rating of feature '{}' is unknown", feature.getName());
			}
		}
		return model;
	}
}
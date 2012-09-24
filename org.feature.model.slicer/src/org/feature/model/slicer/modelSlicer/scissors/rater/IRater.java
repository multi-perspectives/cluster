package org.feature.model.slicer.modelSlicer.scissors.rater;

import de.tud.es.madras.featuresc.model.SCFeature;

/**
 * Interface for feature rating
 * 
 * @author Ingo Reimund
 * @create 12.05.2012
 * 
 */
public interface IRater {

	/**
	 * rate a feature
	 * 
	 * @param feature
	 *            to rate
	 * @return rating of the feature
	 */
	public Rating rate(SCFeature feature);
}
package org.feature.model.slicer.modelSlicer.scissors;

import java.util.Set;

import de.tud.es.madras.featuresc.model.SCModel;

/**
 * Strategies to cut off of features from the model, using the rating function
 * to identifier features to remove.
 * 
 * @author Ingo Reimund
 * @create 27.03.2012
 * 
 */
public interface IScissors {

	/**
	 * use the rater to rate all features of the model and cut off features
	 * which are rated to remove
	 * 
	 * @param model
	 *            to cut
	 * @param boundedAlive
	 *            alive features
	 * @param boundedDead
	 *            dead features
	 * @return modified model
	 */
	public SCModel cut(SCModel model, Set<String> boundedAlive, Set<String> boundedDead);
}
package org.feature.model.slicer.extendedModel.classification;

import java.util.Set;

import org.feature.model.sat.solver.IFeatureSolver;
import org.feature.model.slicer.exceptions.ContradictingClassificationException;
import org.featuremapper.models.feature.Feature;

/**
 * Abstract class for classification which hold the solver for the
 * classification of a model
 * 
 * @author Ingo Reimund
 * @create 27.06.2012
 * 
 */
public interface IClassifier {

	/**
	 * start the classification using the given solver and the model which
	 * carried by the solver
	 * 
	 * @param solver
	 *            for classification which contains the model
	 * @param boundedAlive
	 *            bounded alive features
	 * @param boundedDead
	 *            bounded dead features
	 * @return annotated model
	 */
	public abstract ClassifierHandler classify(IFeatureSolver solver, Set<Feature> boundedAlive, Set<Feature> boundedDead) throws ContradictingClassificationException;

	/**
	 * start the classification using the given solver and the model which
	 * carried by the solver
	 * 
	 * @param solver
	 *            for classification which contains the model; the feature model has to be fully annotated
	 * @return annotated model
	 */
	public abstract ClassifierHandler classify(IFeatureSolver solver) throws ContradictingClassificationException;
	
}
package org.feature.model.slicer.extendedModel.classification;

import org.feature.model.sat.solver.IFeatureSolver;

/**
 * Interface for a trimming algorithm. This means, that the model is classified
 * internal and then trimmed by using the trim function of the solver. This
 * method does not return a classified model but it return a minimized model
 * after the trim process applied.
 * 
 * @author Ingo Reimund
 * @create 04.07.2012
 * 
 */
public interface ITrimmer {

	/**
	 * start so classify the model and trim it using the trim function
	 * 
	 * @param solver
	 *            for trimming
	 * @param cHandler
	 *            classifier handler that contains the dully classified feature
	 *            annotations
	 * @return true if the trim process was applied, else false
	 */
	public boolean trim(IFeatureSolver solver, ClassifierHandler cHandler);
}
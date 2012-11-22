package org.feature.model.sat.solver;

import java.util.Set;

import org.feature.model.sat.builder.ISolverModelBuilder;
import org.featuremapper.models.feature.Feature;
import org.featuremapper.models.feature.FeatureModel;

/**
 * Interface which encapsulate a solver and keep the model the solver works
 * with.
 * 
 * @author Ingo Reimund
 * @since 0.5.0
 * 
 */
public interface IFeatureSolver {


	/**
	 * return a set model or throws an NullPointerException of no model is set
	 * 
	 * @return the base model without any modifications
	 */
	public ISolverModelBuilder getBaseModel();



	/**
	 * 
	 * @return the feature model that is the basis for the solver
	 */
	public FeatureModel getFeatureModel();

	/**
	 * check is the model is satisfiable, without any additional constraints
	 * 
	 * @return true if the model is satisfiable
	 */
	public abstract boolean isSolvable();

	/**
	 * 
	 * @param aliveFeatures
	 *            list of features that should be in a configuration
	 * @param deadFeatures
	 *            list of features that should not be in a configuration
	 * @return true if the model with the feature constraints is solveable
	 */
	public abstract boolean isSolvable(Set<Feature> aliveFeatures,
			Set<Feature> deadFeatures);

	/**
	 * Compute a possible configuration for the given feature model
	 * 
	 * @return list of features that are contained in the configuration
	 */
	public abstract Set<Feature> getConfiguration();

	/**
	 * Compute all possible configurations for the given feature model
	 * 
	 * @return list of all possible configurations for the feature model
	 */
	public abstract Set<Set<FeatureModel>> getAllConfigurations();

	/**
	 * Compute a possible configuration for the given feature model with the specified feature constraints
	 * 
	 * @param aliveFeatures list of features that should be contained in every configuration
	 * @param deadFeatures list of features that should not be contained in any configuration
	 * @return list of features that are contained in the configuration
	 */
	public abstract Set<Feature> getConfiguration(Set<Feature> aliveFeatures,
			Set<Feature> deadFeatures);

	/**
	 * 
	 * Compute a possible configuration for the given feature model with the specified feature constraints
	 * 
	 * @param aliveFeatures list of features that should be contained in every configuration
	 * @param deadFeatures list of features that should not be contained in any configuration
	 * @return list of all possible configurations for the feature model
	 */
	public abstract Set<Set<FeatureModel>> getAllConfigurations(
			Set<Feature> aliveFeatures, Set<Feature> deadFeatures);

}
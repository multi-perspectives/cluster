package org.feature.model.sat.solver;

import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;
import org.feature.model.sat.builder.ISolverModelBuilder;
import org.feature.model.sat.builder.SATModelBuilder;
import org.feature.model.sat.exception.UnknownStatementException;
import org.featuremapper.models.feature.Feature;
import org.featuremapper.models.feature.FeatureModel;
import org.sat4j.core.VecInt;
import org.sat4j.specs.IVecInt;
import org.sat4j.specs.TimeoutException;

/**
 * Solver for a sat4j problem. Replace the evaluation strategy
 * 
 * @author Ingo Reimund
 * @since 0.5.0
 * 
 */
public class SimpleSAT4JSolver implements IFeatureSolver {

	/**
	 * Logger
	 */
	private static Logger logger = Logger.getLogger(SimpleSAT4JSolver.class);

	/**
	 * SAT model builder
	 */
	private ISolverModelBuilder builder;

	/**
	 * Feature model on which the operations are executed
	 */
	private FeatureModel featureModel;

	/**
	 * 
	 * @param model
	 *            SAT model representation of the feature model
	 * @param fm
	 *            feature model on which the solving operations are executed
	 */
	public SimpleSAT4JSolver(ISolverModelBuilder model, FeatureModel fm) {
		this.builder = model;
		this.featureModel = fm;
	}

	@Override
	public void setBaseModel(SATModelBuilder model, FeatureModel fm) {
		this.builder = model;
		this.featureModel = fm;
	}

	@Override
	public boolean isSolvable(Set<Feature> boundedAlive,
			Set<Feature> boundedDead) {
		IVecInt selected = new VecInt();

		try {
			for (Feature aliveFeature : boundedAlive) {
				selected.push(builder.getMapping(aliveFeature));
			}

			for (Feature deadFeature : boundedDead) {
				selected.push(-builder.getMapping(deadFeature));
			}

			int[] model = builder.getModel().findModel(selected);
			if (model == null) {
				logger.info("no products found");
				return false;
			}
			logger.info("product found");
			return true;
		} catch (TimeoutException e) {
			logger.error(e.getMessage());
			return false;
		} catch (UnknownStatementException e) {
			logger.error(e.getMessage());
			return false;
		}
	}

	@Override
	public Set<Feature> getConfiguration(Set<Feature> boundedAlive,
			Set<Feature> boundedDead) {
		IVecInt selected = new VecInt();

		try {
			for (Feature alive : boundedAlive) {
				selected.push(builder.getMapping(alive));
			}

			for (Feature dead : boundedDead) {
				selected.push(-builder.getMapping(dead));
			}

			int[] model = builder.getModel().findModel(selected);
			if (model == null) {
				logger.info("no products found");
				return null;
			}
			logger.info("product found");

			return convert(model);
		} catch (TimeoutException | UnknownStatementException e) {
			logger.error(e.getMessage());
			return null;
		}
	}

	/**
	 * Convert a list of feature ids (representing a configuration) to the
	 * according set of EMF feature objects
	 * 
	 * @param model list of feature ids
	 * @return set of the according EMF feature objects
	 */
	private Set<Feature> convert(int[] model) {
		Set<Feature> product = new HashSet<>();

		for (int i : model)
			product.add(builder.getMapping(i));
		return product;
	}

	@Override
	public boolean isSolvable() {
		try {
			return this.getBaseModel().getModel().isSatisfiable();
		} catch (TimeoutException e) {
			logger.info("Model" + this.getFeatureModel() + "is not solvable");
			return false;
		}
	}

	@Override
	public Set<Feature> getConfiguration() {

		try {

			int[] model = builder.getModel().findModel();
			if (model == null) {
				logger.info("no products found");
				return null;
			}
			logger.info("product found");

			return convert(model);
		} catch (TimeoutException e) {
			logger.error("Configuration for model '"
					+ this.getFeatureModel().getName()
					+ "' could not be computed");
			return null;
		}
	}

	@Override
	public Set<Set<FeatureModel>> getAllConfigurations() {
		logger.warn("findProducts is not implemented");
		return null;
	}

	@Override
	public Set<Set<FeatureModel>> getAllConfigurations(
			Set<Feature> aliveFeatures, Set<Feature> deadFeatures) {
		logger.warn("findProducts is not implemented");
		return null;
	}

	@Override
	public ISolverModelBuilder getBaseModel() {
		return builder;
	}

	@Override
	public FeatureModel getFeatureModel() {
		return featureModel;
	}
}
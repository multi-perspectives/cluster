package org.feature.model.sat.solver;

import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;
import org.feature.model.sat.ISolverModelBuilder;
import org.feature.model.sat.SATModelBuilder;
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

	private ISolverModelBuilder problem;

	private FeatureModel featureModel;

	public SimpleSAT4JSolver(ISolverModelBuilder model, FeatureModel fm) {
		this.problem = model;
		this.featureModel = fm;
	}

	@Override
	public void setBaseModel(SATModelBuilder model, FeatureModel fm) {
		this.problem = model;
		this.featureModel = fm;
	}
	
	@Override
	public boolean isSolvable(Set<Feature> boundedAlive,
			Set<Feature> boundedDead) {
		IVecInt selected = new VecInt();

		try {
			for (Feature aliveFeature : boundedAlive) {
				selected.push(problem.getMapping(aliveFeature));
			}

			for (Feature deadFeature : boundedDead) {
				selected.push(-problem.getMapping(deadFeature));
			}

			int[] model = problem.getModel().findModel(selected);
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

	// @Override
	// public boolean trim(Set<Feature> boundedAlive, Set<Feature> boundedDead)
	// {
	// super.trim(boundedAlive, boundedDead);
	// for (String alive : boundedAlive) {
	// try {
	// problem.getSolver().gateTrue(problem.getMapping(alive));
	// } catch (ContradictionException e) {
	// logger.error(e.getMessage(), e);
	// }
	// }
	// for (String dead : boundedDead) {
	// try {
	// problem.getSolver().gateFalse(problem.getMapping(dead));
	// } catch (ContradictionException e) {
	// logger.error(e.getMessage(), e);
	// }
	// }
	// return true;
	// }



	@Override
	public Set<Feature> getConfiguration(Set<Feature> boundedAlive,
			Set<Feature> boundedDead) {
		IVecInt selected = new VecInt();

		try {
			for (Feature alive : boundedAlive) {
				selected.push(problem.getMapping(alive));
			}

			for (Feature dead : boundedDead) {
				selected.push(-problem.getMapping(dead));
			}

			int[] model = problem.getModel().findModel(selected);
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

	private Set<Feature> convert(int[] model) {
		Set<Feature> product = new HashSet<>();

		for (int i : model)
			product.add(problem.getMapping(i));
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

			int[] model = problem.getModel().findModel();
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
		return problem;
	}

	@Override
	public FeatureModel getFeatureModel() {
		return featureModel;
	}
}
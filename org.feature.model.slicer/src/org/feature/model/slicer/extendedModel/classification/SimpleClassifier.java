package org.feature.model.slicer.extendedModel.classification;

import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;
import org.feature.model.sat.solver.IFeatureSolver;
import org.feature.model.slicer.exceptions.ContradictingClassificationException;
import org.featuremapper.models.feature.Feature;
import org.featuremapper.models.feature.FeatureModel;

/**
 * a simple strategy for a classification of a model. It test all features which
 * a are not bound
 * 
 * @author Ingo Reimund
 * @create 27.06.2012
 * 
 */
public class SimpleClassifier implements IClassifier {

	private ClassifierHandler cHandler;

	/**
	 * Logger
	 */
	private static Logger logger = Logger.getLogger(SimpleClassifier.class);

	@Override
	public ClassifierHandler classify(IFeatureSolver solver,
			Set<Feature> boundedAlive, Set<Feature> boundedDead)
			throws ContradictingClassificationException {
		FeatureModel model = solver.getFeatureModel();

		cHandler = new ClassifierHandler(model);

		logger.info("start to evaluate all features of model '"
				+ model.getName() + "'");
		if (!solver.isSolvable(boundedAlive, boundedDead)) {
			logger.warn("not solvable");
			throw new ContradictingClassificationException(
					"Classification of the given feature model is not solvable");
		}

		for (Feature alive : boundedAlive)
			cHandler.classifyBoundAlive(alive, true);

		for (Feature dead : boundedDead)
			cHandler.classifyBoundDead(dead, true);

		for (Feature feature : model.getAllFeatures()) {
			if (!cHandler.getNonClassifiedFeatures().contains(feature)) {
				logger.debug("feature '" + feature.getName()
						+ "' was classified manually");
				continue;
			}
			classify(solver, feature);
		}
		logger.info("finish evaluation of the model '" + model.getName() + "'");
		return cHandler;
	}

	/**
	 * classify a feature with the bounded features of the model which carried
	 * by the given solver
	 * 
	 * @param solver
	 *            for the classification
	 * @param feature
	 *            to evaluate
	 */
	protected Feature classify(IFeatureSolver solver, Feature feature) {
		logger.info("evaluate feature '" + feature.getName() + "'");

		Set<Feature> toEvaluate = new HashSet<Feature>(
				cHandler.getBoundAliveFeatures());

		toEvaluate.add(feature);
		if (!solver.isSolvable(toEvaluate, cHandler.getBoundDeadFeatures())) {
			logger.debug("feature '{" + feature.getName() + "}' is bound dead");
			cHandler.classifyBoundDead(feature, false);
		} else {
			toEvaluate = new HashSet<Feature>(cHandler.getBoundDeadFeatures());

			toEvaluate.add(feature);
			if (solver.isSolvable(cHandler.getBoundAliveFeatures(), toEvaluate)) {
				logger.debug("feature '" + feature.getName() + "' is unbound");
				cHandler.classifyUnbound(feature, false);
			} else {
				logger.debug("feature '{" + feature.getName()
						+ "}' is bound alive");
				cHandler.classifyBoundAlive(feature, false);
			}
		}
		return feature;
	}

	@Override
	public ClassifierHandler classify(IFeatureSolver solver) {
		FeatureModel model = solver.getFeatureModel();

		cHandler = new ClassifierHandler(model);

		logger.info("start to evaluate all features of model '"
				+ model.getName() + "'");
		if (!solver.isSolvable(cHandler.getBoundAliveFeatures(), cHandler.getBoundDeadFeatures())) {
			logger.warn("not solvable");
			throw new ContradictingClassificationException(
					"Classification of the given feature model is not solvable");
		}

		for (Feature feature : model.getAllFeatures()) {
			if (!cHandler.getNonClassifiedFeatures().contains(feature)) {
				logger.debug("feature '" + feature.getName()
						+ "' was classified manually");
				continue;
			}
			classify(solver, feature);
		}
		logger.info("finish evaluation of the model '" + model.getName() + "'");
		return cHandler;
	}
}
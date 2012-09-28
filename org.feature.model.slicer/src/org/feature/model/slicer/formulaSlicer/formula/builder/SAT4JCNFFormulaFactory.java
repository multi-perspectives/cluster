package org.feature.model.slicer.formulaSlicer.formula.builder;

import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;
import org.feature.model.sat.builder.ISolverModelBuilder;
import org.feature.model.sat.builder.SATModelBuilder;
import org.feature.model.sat.exception.UnknownStatementException;
import org.feature.model.sat.solver.IFeatureSolver;
import org.feature.model.slicer.extendedModel.classification.ClassifierHandler;
import org.feature.model.slicer.extendedModel.classification.SimpleClassifier;
import org.feature.model.slicer.formulaSlicer.formula.trimmer.TrimSAT4JCNF;
import org.featuremapper.models.feature.Feature;
import org.featuremapper.models.feature.FeatureModel;
import org.sat4j.specs.ContradictionException;
import org.sat4j.tools.DimacsStringSolver;

/**
 * factory to convert a model to a formula using the SAT4J solver factory
 * DimacsStringSolver
 * 
 * @author Karsten Saller
 * 
 */
public class SAT4JCNFFormulaFactory implements IFormulaFactory {

	SATModelBuilder builder;

	/**
	 * Logger
	 */
	private static Logger logger = Logger
			.getLogger(SAT4JCNFFormulaFactory.class);

	@Override
	public String createFormulaName(FeatureModel model) {

		DimacsStringSolver solver = new DimacsStringSolver();
		builder = new SATModelBuilder(solver);

		builder.buildSolverModel(model);

		String result = solver.getOut().toString().trim();
		for (Feature feature : model.getAllFeatures()) {
			try {
				result = result.replaceFirst("^" + builder.getMapping(feature)
						+ " ", "" + feature.getName() + " ");
				result = result.replaceFirst("^-" + builder.getMapping(feature)
						+ " ", "-" + feature.getName() + " ");
				result = result.replaceAll("\n" + builder.getMapping(feature)
						+ " ", "\n" + feature.getName() + " ");
				result = result.replaceAll("-" + builder.getMapping(feature)
						+ " ", "-" + feature.getName() + " ");
				result = result.replaceAll(" " + builder.getMapping(feature)
						+ " ", " " + feature.getName() + " ");
			} catch (UnknownStatementException e) {
				logger.error("Feature '"
						+ feature.getName()
						+ "' could not be found. skipping the CNF transformation");
			}

		}
		return result;
	}

	@Override
	public String createFormulaName(FeatureModel model,
			Set<Feature> boundedAlive, Set<Feature> boundedDead) {
		DimacsStringSolver solver = new DimacsStringSolver();

		builder = new SATModelBuilder(solver);
		builder.buildSolverModel(model);

		for (Feature alive : boundedAlive) {
			try {
				try {
					builder.getModel().gateTrue(builder.getMapping(alive));
				} catch (UnknownStatementException e) {
					logger.error("Could not resolve feature mapping while building CNF");
				}
			} catch (ContradictionException e) {
				logger.error(e.getMessage(), e);
			}
		}
		for (Feature dead : boundedDead) {
			try {
				try {
					builder.getModel().gateFalse(builder.getMapping(dead));
				} catch (UnknownStatementException e) {
					logger.error("Could not resolve feature mapping while building CNF");
				}
			} catch (ContradictionException e) {
				logger.error(e.getMessage(), e);
			}
		}

		String result = solver.getOut().toString().trim();
		for (Feature feature : model.getAllFeatures()) {
			try {
				result = result.replaceFirst("^" + builder.getMapping(feature)
						+ " ", "" + feature.getName() + " ");
				result = result.replaceFirst("^-" + builder.getMapping(feature)
						+ " ", "-" + feature.getName() + " ");
				result = result.replaceAll("\n" + builder.getMapping(feature)
						+ " ", "\n" + feature.getName() + " ");
				result = result.replaceAll("-" + builder.getMapping(feature)
						+ " ", "-" + feature.getName() + " ");
				result = result.replaceAll(" " + builder.getMapping(feature)
						+ " ", " " + feature.getName() + " ");
			} catch (UnknownStatementException e) {
				logger.error("Could not resolve feature mapping while building CNF");
			}

		}
		return result;
	}

	@Override
	public String createFormulaId(FeatureModel model) {
		DimacsStringSolver solver = new DimacsStringSolver();
		builder = new SATModelBuilder(solver);

		builder.buildSolverModel(model);

		String result = solver.getOut().toString().trim();

		return result;
	}

	@Override
	public String createFormulaId(FeatureModel model,
			Set<Feature> boundedAlive, Set<Feature> boundedDead) {
		DimacsStringSolver solver = new DimacsStringSolver();

		builder = new SATModelBuilder(solver);
		builder.buildSolverModel(model);

		for (Feature alive : boundedAlive) {
			try {
				try {
					builder.getModel().gateTrue(builder.getMapping(alive));
				} catch (UnknownStatementException e) {
					logger.error("Could not resolve feature mapping while building CNF");
				}
			} catch (ContradictionException e) {
				logger.error(e.getMessage(), e);
			}
		}
		for (Feature dead : boundedDead) {
			try {
				try {
					builder.getModel().gateFalse(builder.getMapping(dead));
				} catch (UnknownStatementException e) {
					logger.error("Could not resolve feature mapping while building CNF");
				}
			} catch (ContradictionException e) {
				logger.error(e.getMessage(), e);
			}
		}

		String result = solver.getOut().toString().trim();

		return result;
	}

	@Override
	public String createFormulaNameMinimized(IFeatureSolver solverModel,
			Set<Feature> boundedAlive, Set<Feature> boundedDead) {
		String cnf = createFormulaName(solverModel.getFeatureModel());

		TrimSAT4JCNF trimmer = new TrimSAT4JCNF();

		ClassifierHandler handler = new ClassifierHandler(
				solverModel.getFeatureModel());
		SimpleClassifier classifier = new SimpleClassifier();
		
		handler = classifier.classify(solverModel, boundedAlive, boundedDead);
		
		Set<String> aliveStrings = new HashSet<String>();

		for (Feature alive : handler.getBoundAliveFeatures())
			aliveStrings.add(alive.getName());

		Set<String> deadStrings = new HashSet<String>();

		for (Feature dead : handler.getBoundDeadFeatures())
			deadStrings.add(dead.getName());

		trimmer.trimCnf(cnf, solverModel.getFeatureModel().getRoot().getName(), aliveStrings, deadStrings);

		return trimmer.getCnfString();
	}

	@Override
	public String createFormulaIdMinimized(FeatureModel model,
			Set<Feature> boundedAlive, Set<Feature> boundedDead) {
		String cnf = createFormulaId(model, boundedAlive, boundedDead);

		TrimSAT4JCNF trimmer = new TrimSAT4JCNF();

		Set<String> aliveStrings = new HashSet<String>();
		Set<String> deadStrings = new HashSet<String>();

		try {
			for (Feature alive : boundedAlive)
				aliveStrings.add(builder.getMapping(alive) + "");

			for (Feature dead : boundedDead)
				deadStrings.add(builder.getMapping(dead) + "");
			
			trimmer.trimCnf(cnf, builder.getMapping(model.getRoot()).toString(), aliveStrings, deadStrings);

		} catch (UnknownStatementException e) {
			logger.error("Could not resolve all features for CNF creation");
		}


		return trimmer.getCnfString();
	}
}
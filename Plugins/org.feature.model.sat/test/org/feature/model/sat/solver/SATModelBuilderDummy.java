package org.feature.model.sat.solver;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.feature.model.ModelLoader;
import org.feature.model.sat.builder.ISolverModelBuilder;
import org.feature.model.sat.builder.SATModelBuilder;
import org.feature.model.sat.exception.UnknownStatementException;
import org.featuremapper.models.feature.Feature;
import org.featuremapper.models.feature.FeatureModel;
import org.sat4j.core.VecInt;
import org.sat4j.minisat.SolverFactory;
import org.sat4j.tools.GateTranslator;

/**
 * dummy which use the SimplePhoneSAtSmall feature model
 * 
 * @author Ingo Reimund
 * 
 */
public class SATModelBuilderDummy implements ISolverModelBuilder {

	/**
	 * logger
	 */
	private static Logger logger = Logger.getLogger(SATModelBuilder.class);

	/**
	 * association of feature identifier to Integer
	 */
	private Map<Feature, Integer> featureToId = new HashMap<Feature, Integer>();

	/**
	 * association of integer to feature identifier
	 */
	private Map<Integer, Feature> idToFeature = new HashMap<Integer, Feature>();

	/**
	 * used solver
	 */
	private GateTranslator solver = new GateTranslator(SolverFactory.newDefault());

	private FeatureModel model;

	/**
	 * create SimplePhoneSAtSmall feature model
	 */
	public SATModelBuilderDummy() {
		model = new ModelLoader().loadModel("testdata/SimplePhoneSATSmall.feature");
		for (Feature feature : model.getAllFeatures()) {
			addMapping(feature);
		}

		try {
			// SmallFeaturePhone (1)
			solver.gateTrue(1);

			// Message (2)
			VecInt clause = new VecInt();
			clause.push(2);
			solver.and(1, clause);

			// SMS (3)
			clause = new VecInt();
			clause.push(3);
			solver.and(1, clause);

			// Extras (4)
			clause = new VecInt();
			clause.push(4);
			solver.halfOr(1, clause);
			clause = new VecInt();
			clause.push(-4);
			clause.push(1);
			solver.addClause(clause);

			// MP3 (5) Camera (6)
			clause = new VecInt();
			clause.push(5);
			clause.push(6);
			solver.halfOr(4, clause);
			clause.push(-4);
			solver.addAtLeast(clause, 1);
			clause = new VecInt();
			clause.push(-5);
			clause.push(1);
			solver.addClause(clause);
			clause = new VecInt();
			clause.push(-6);
			clause.push(1);
			solver.addClause(clause);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new RuntimeException(e);
		}
	}

	@Override
	public void setSolverModel(GateTranslator gt) {

	}

	@Override
	public GateTranslator getModel() {
		return solver;
	}

	@Override
	public GateTranslator buildSolverModel(FeatureModel featuremodel) {
		return solver;
	}

	@Override
	public void addMapping(Feature newFeature) {
		int id = -1;
		switch (newFeature.getName()) {
		case "SmallFeaturePhone":
			id = 1;
			break;
		case "Message":
			id = 2;
			break;
		case "SMS":
			id = 3;
			break;
		case "Extras":
			id = 4;
			break;
		case "MP3":
			id = 5;
			break;
		case "Camera":
			id = 6;
			break;
		}

		if (id == -1) {
			logger.error("something goes wrong");
			throw new RuntimeException("No mapping for this feature");
		}
		featureToId.put(newFeature, id);
		idToFeature.put(id, newFeature);

	}

	@Override
	public Integer getMapping(Feature featureIdentifier) throws UnknownStatementException {
		if (featureToId.get(featureIdentifier) == null)
			throw new UnknownStatementException("Feature can not be found in the feature model");
		return featureToId.get(featureIdentifier);
	}

	@Override
	public Feature getMapping(int feature) {
		return idToFeature.get(feature);
	}

	@Override
	public void removeMapping(Feature featureId) throws UnknownStatementException {
		idToFeature.remove(getMapping(featureId));
		featureToId.remove(featureId);
	}

	public FeatureModel getFeatureModel() {
		return model;
	}
}
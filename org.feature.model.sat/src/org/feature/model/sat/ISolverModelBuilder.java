package org.feature.model.sat;

import org.feature.model.sat.exception.UnknownStatementException;
import org.featuremapper.models.feature.Feature;
import org.featuremapper.models.feature.FeatureModel;
import org.sat4j.tools.GateTranslator;

public interface ISolverModelBuilder {

	public void setSolverModel(GateTranslator gt);

	public GateTranslator getModel();

	/**
	 * Transform a cardinality-based feature model into a constraint model.
	 * 
	 * @param featuremodel
	 */
	public GateTranslator buildSolverModel(FeatureModel featuremodel);
	
	public void addMapping(Feature newFeature);

	public Integer getMapping(Feature featureIdentifier)
			throws UnknownStatementException;

	public Feature getMapping(int feature);

	public void removeMapping(Feature featureId) throws UnknownStatementException;
	
}

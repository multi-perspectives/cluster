package org.feature.model.sat.builder;

import org.feature.model.sat.exception.UnknownStatementException;
import org.featuremapper.models.feature.Feature;
import org.featuremapper.models.feature.FeatureModel;
import org.sat4j.tools.GateTranslator;

/**
 * Interface to build a gerneric solver model for a EMF feature model
 * 
 * @author saller
 * 
 */
public interface ISolverModelBuilder {

	public void setSolverModel(GateTranslator gt);

	public GateTranslator getModel();

	/**
	 * Transform a cardinality-based feature model into a constraint model.
	 * 
	 * @param featuremodel
	 */
	public GateTranslator buildSolverModel(FeatureModel featuremodel);

	/**
	 * add a new feature to the model manually
	 * 
	 * @param newFeature
	 */
	public void addMapping(Feature newFeature);

	/**
	 * get a mapping Feature object to id wihtin the solver
	 * 
	 * @param featureIdentifier
	 *            EMF feature object
	 * @return id representation of the feature
	 * @throws UnknownStatementException
	 */
	public Integer getMapping(Feature featureIdentifier)
			throws UnknownStatementException;

	/**
	 * 
	 * get a mapping feature id to feature object
	 * 
	 * @param feature
	 *            id representation of the feature
	 * @return EMF feature object
	 */
	public Feature getMapping(int feature);

	/**
	 * remove an existing mapping
	 * 
	 * @param featureId
	 *            od of the feature which should be removed
	 * @throws UnknownStatementException
	 */
	public void removeMapping(Feature featureId)
			throws UnknownStatementException;

}

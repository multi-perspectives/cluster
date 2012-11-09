package org.feature.model.sat.builder;

import org.feature.model.sat.builder.SATModelBuilder;
import org.feature.model.sat.exception.UnknownStatementException;
import org.featuremapper.models.feature.Feature;
import org.featuremapper.models.feature.FeatureModel;

/**
 * convert a sat4j cnf to something needed
 * 
 * @author Ingo Reimund
 * 
 */
public class CNFConverter {

	/**
	 * convert a sat4j cnf to an readable version
	 * 
	 * @param sat4JCNF
	 *            cnf in sat4j format
	 * @param featureModel
	 *            feature model
	 * @param builder
	 *            builder which create the sat4jcnf
	 * @return
	 */
	public String convertToReadable(String sat4JCNF, FeatureModel featureModel, SATModelBuilder builder) {
		sat4JCNF = sat4JCNF.replace(" 0", " ");

		for (Feature feature : featureModel.getAllFeatures()) {
			try {
				String integer = builder.getMapping(feature).toString();
				sat4JCNF = sat4JCNF.replaceAll("\\n" + integer + "\\s", "\n" + feature.getName() + " ");
				sat4JCNF = sat4JCNF.replaceAll("\\s" + integer + "\\s", " " + feature.getName() + " ");
				sat4JCNF = sat4JCNF.replaceAll("-" + integer + "\\s", "-" + feature.getName() + " ");
				sat4JCNF = sat4JCNF.replaceAll("-" + integer + "\\s", "-" + feature.getName() + " ");
			} catch (UnknownStatementException e) {

			}
		}
		return sat4JCNF;
	}
}
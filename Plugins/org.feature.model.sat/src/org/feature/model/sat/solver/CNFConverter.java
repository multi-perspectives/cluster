package org.feature.model.sat.solver;

import org.feature.model.sat.builder.ISolverModelBuilder;
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
	public String convertCNFToReadable(String sat4JCNF, FeatureModel featureModel, SATModelBuilder builder) {
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

	/**
	 * convert a list of integers to a list of features
	 * 
	 * @param model
	 *            list of integers
	 * @param builder
	 *            builder which contains the mapping
	 * @return list of features
	 */
	public String convertSATModelToReadable(int[] model, ISolverModelBuilder builder) {
		StringBuffer buffer = new StringBuffer();
		for (int i : model) {
			if (i < 0) {
				buffer.append("-");
			}
			buffer.append(builder.getMapping(Math.abs(i)).getName());
			buffer.append(", ");
		}
		return buffer.toString().substring(0, buffer.toString().lastIndexOf(", "));
	}

	/**
	 * convert a list of integers to a list of features
	 * 
	 * @param model
	 *            list of integers
	 * @param builder
	 *            builder which contains the mapping
	 * @return list of features
	 */
	public String convertClauseToReadable(int[] clause, ISolverModelBuilder builder) {
		return convertSATModelToReadable(clause, builder);
	}

	/**
	 * convert a list of integers to an string of integers
	 * 
	 * @param model
	 *            list of integers
	 * @return string of integers
	 */

	public String convertSATModelToString(int[] model) {
		StringBuffer buffer = new StringBuffer();
		for (int i : model) {
			buffer.append(i);
			buffer.append(", ");
		}
		return buffer.toString().substring(0, buffer.toString().lastIndexOf(", "));
	}
}
package org.feature.model.sat.builder;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.PropertyConfigurator;
import org.feature.model.FileHandler;
import org.feature.model.ModelLoader;
import org.feature.model.sat.exception.UnknownStatementException;
import org.featuremapper.models.feature.Feature;
import org.featuremapper.models.feature.FeatureModel;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.sat4j.tools.DimacsStringSolver;
import org.sat4j.tools.GateTranslator;

/**
 * @author Ingo Reimund
 * 
 */
public class TestExtensionModelBuilder {

	/**
	 * under test
	 */
	private SATModelBuilder builder;

	private DimacsStringSolver solver;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		solver = new DimacsStringSolver();
		builder = new SATModelBuilder(new GateTranslator(solver));
	}

	/**
	 * Test method for
	 * {@link org.feature.model.sat.builder.SATModelBuilder#buildSolverModel(org.featuremapper.models.feature.FeatureModel)}
	 * .
	 * 
	 * @throws IOException
	 */
	@Test
	public void testBuildSmallOrModel() throws IOException {
		FeatureModel model = new ModelLoader().loadModel("testdata/SimplePhoneSATSmallOr.feature");
		builder.buildSolverModel(model);

		String result = solver.getOut().toString();
		result = result.replace(" 0", "");

		for (Feature feature : model.getAllFeatures()) {
			try {
				result = result.replaceAll(builder.getMapping(feature).toString(), feature.getName());
			} catch (UnknownStatementException e) {

			}
		}

		String expected = "testdata" + File.separator + "expected" + File.separator + "SimplePhoneSATSmallOr.txt";
		assertEquals(new FileHandler().readFile(expected), result.trim());
	}

	/**
	 * Test method for
	 * {@link org.feature.model.sat.builder.SATModelBuilder#buildSolverModel(org.featuremapper.models.feature.FeatureModel)}
	 * .
	 * 
	 * @throws IOException
	 */
	@Test
	public void testBuildSmallAlternativeModel() throws IOException {
		FeatureModel model = new ModelLoader().loadModel("testdata/SimplePhoneSATSmallAlternative.feature");
		builder.buildSolverModel(model);

		String result = solver.getOut().toString();
		result = result.replace(" 0", "");

		for (Feature feature : model.getAllFeatures()) {
			try {
				result = result.replaceAll(builder.getMapping(feature).toString(), feature.getName());
			} catch (UnknownStatementException e) {

			}
		}

		String expected = "testdata" + File.separator + "expected" + File.separator
				+ "SimplePhoneSATSmallAlternative.txt";
		assertEquals(new FileHandler().readFile(expected), result.trim());
	}

	@BeforeClass
	public static void BeforeClass() {
		PropertyConfigurator.configure("conf/log4j.properties");
		BasicConfigurator.configure();
	}
}
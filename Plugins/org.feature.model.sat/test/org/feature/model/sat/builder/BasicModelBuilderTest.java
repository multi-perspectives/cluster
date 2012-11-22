package org.feature.model.sat.builder;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.feature.model.sat.exception.UnknownStatementException;
import org.feature.model.sat.solver.CNFConverter;
import org.feature.model.utilities.FeatureModelLoader;
import org.featuremapper.models.feature.Feature;
import org.featuremapper.models.feature.FeatureModel;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.sat4j.core.VecInt;
import org.sat4j.minisat.SolverFactory;
import org.sat4j.specs.ISolver;
import org.sat4j.specs.TimeoutException;
import org.sat4j.tools.GateTranslator;

/**
 * Test basic transformations and mapping of SATModelBuilder
 * 
 * @author Ingo Reimund
 * 
 */
public class BasicModelBuilderTest {

	/**
	 * model for test
	 */
	private FeatureModel model;

	/**
	 * object under test
	 */
	private SATModelBuilder builder;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		builder = new SATModelBuilder(new GateTranslator(SolverFactory.newDefault()));
	}

	@Test
	public void testMapping() throws UnknownStatementException {
		model = new FeatureModelLoader().load("testdata/SimplePhoneSATSmall.feature");
		builder.buildSolverModel(model);

		for (Feature feature : model.getAllFeatures()) {
			switch (feature.getName()) {
			case "SmallFeaturePhone":
				assertEquals(new Integer(1), builder.getMapping(feature));
				break;
			case "Message":
				assertEquals(new Integer(2), builder.getMapping(feature));
				break;
			case "SMS":
				assertEquals(new Integer(3), builder.getMapping(feature));
				break;
			case "Extras":
				assertEquals(new Integer(4), builder.getMapping(feature));
				break;
			case "MP3":
				assertEquals(new Integer(5), builder.getMapping(feature));
				break;
			case "Camera":
				assertEquals(new Integer(6), builder.getMapping(feature));
				break;
			default:
				fail("No mapping for feature " + feature.getName());
			}
		}
	}

	/**
	 * test root is always true
	 * 
	 * @throws UnknownStatementException
	 * @throws TimeoutException
	 */
	@Test
	public void testRootClause() throws UnknownStatementException, TimeoutException {
		FeatureModelLoader loader = new FeatureModelLoader();
		model = loader.load("testdata/SimplePhoneSATSmallRootOnly.feature");
		builder.buildSolverModel(model);

		ISolver solver = builder.getModel();
		assertTrue(solver.isSatisfiable());

		VecInt bound = new VecInt();
		bound.push(builder.getMapping(loader.findFeature(model, "SmallFeaturePhone")));
		assertTrue(solver.isSatisfiable(bound));

		bound = new VecInt();
		bound.push(-builder.getMapping(loader.findFeature(model, "SmallFeaturePhone")));
		assertFalse(solver.isSatisfiable(bound));
	}

	/**
	 * Test mandatory clause
	 * 
	 * @throws UnknownStatementException
	 * @throws TimeoutException
	 */
	@Test
	public void testMandatoryClause() throws UnknownStatementException, TimeoutException {
		FeatureModelLoader loader = new FeatureModelLoader();
		model = loader.load("testdata/SimplePhoneSATSmallMandatoryOnly.feature");
		builder.buildSolverModel(model);

		ISolver solver = builder.getModel();
		assertTrue(solver.isSatisfiable());

		VecInt bound = new VecInt();
		bound.push(builder.getMapping(loader.findFeature(model, "SMS")));
		bound.push(builder.getMapping(loader.findFeature(model, "Message")));
		assertTrue(solver.isSatisfiable(bound));

		bound = new VecInt();
		bound.push(-builder.getMapping(loader.findFeature(model, "SMS")));
		assertFalse(solver.isSatisfiable(bound));
	}

	@Test
	public void testOrClause() throws UnknownStatementException, TimeoutException {
		FeatureModelLoader loader = new FeatureModelLoader();
		model = loader.load("testdata/SimplePhoneSATSmallOptionalWithOrOnly.feature");
		builder.buildSolverModel(model);

		ISolver solver = builder.getModel();
		assertTrue(solver.isSatisfiable());

		VecInt bound = new VecInt();
		bound.push(builder.getMapping(loader.findFeature(model, "Extras")));
		assertTrue(solver.isSatisfiable(bound));

		bound = new VecInt();
		bound.push(-builder.getMapping(loader.findFeature(model, "Extras")));
		assertTrue(solver.isSatisfiable(bound));

		bound = new VecInt();
		bound.push(builder.getMapping(loader.findFeature(model, "Camera")));
		assertTrue(solver.isSatisfiable(bound));

		bound = new VecInt();
		bound.push(-builder.getMapping(loader.findFeature(model, "Camera")));
		assertTrue(solver.isSatisfiable(bound));

		bound = new VecInt();
		bound.push(builder.getMapping(loader.findFeature(model, "Extras")));
		bound.push(-builder.getMapping(loader.findFeature(model, "Camera")));
		assertTrue(solver.isSatisfiable(bound));

		bound = new VecInt();
		bound.push(builder.getMapping(loader.findFeature(model, "Extras")));
		bound.push(-builder.getMapping(loader.findFeature(model, "Camera")));
		bound.push(-builder.getMapping(loader.findFeature(model, "MP3")));
		assertFalse(solver.isSatisfiable(bound));
	}

	@Test
	public void testSmallFeaturePhone() throws UnknownStatementException, TimeoutException {
		FeatureModelLoader loader = new FeatureModelLoader();
		CNFConverter converter = new CNFConverter();
		model = loader.load("testdata/SimplePhoneSATSmall.feature");
		builder.buildSolverModel(model);

		ISolver solver = builder.getModel();
		assertTrue(solver.isSatisfiable());

		VecInt bound = new VecInt();
		bound.push(builder.getMapping(loader.findFeature(model, "Extras")));
		bound.push(-builder.getMapping(loader.findFeature(model, "SMS")));
		assertFalse(solver.isSatisfiable(bound));

		bound = new VecInt();
		bound.push(builder.getMapping(loader.findFeature(model, "Extras")));
		bound.push(builder.getMapping(loader.findFeature(model, "SMS")));
		assertTrue(solver.isSatisfiable(bound));

		bound = new VecInt();
		bound.push(builder.getMapping(loader.findFeature(model, "Extras")));
		assertTrue(solver.isSatisfiable(bound));

		Set<Integer> satisfiedModel = new HashSet<>();
		for (int i : solver.model()) {
			satisfiedModel.add(new Integer(i));
		}
		assertTrue("Found model : " + converter.convertSATModelToReadable(solver.model(), builder),
				satisfiedModel.contains(new Integer(builder.getMapping(loader.findFeature(model, "SMS")))));
		assertTrue("Found model : " + converter.convertSATModelToReadable(solver.model(), builder),
				satisfiedModel.contains(new Integer(builder.getMapping(loader.findFeature(model, "Extras")))));
		assertTrue("Found model : " + converter.convertSATModelToReadable(solver.model(), builder),
				satisfiedModel.contains(new Integer(builder.getMapping(loader.findFeature(model, "Message")))));
	}
}
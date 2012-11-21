package org.feature.model.sat.solver;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.feature.model.ModelLoader;
import org.feature.model.sat.builder.SATModelBuilder;
import org.featuremapper.models.feature.Feature;
import org.featuremapper.models.feature.FeatureModel;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.sat4j.minisat.SolverFactory;

/**
 * @author Ingo Reimund
 *
 */
public class SimpleSAT4JSolverTest {
	
	/**
	 * to test
	 */
	private SimpleSAT4JSolver solver;
	
	/**
	 * model for test
	 */
	private FeatureModel model;
	
	private SATModelBuilderDummy builder;

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
		builder = new SATModelBuilderDummy();
		model = builder.getFeatureModel();
		solver = new SimpleSAT4JSolver(builder, model);
	}

	/**
	 * Test method for {@link org.feature.model.sat.solver.SimpleSAT4JSolver#isSolvable(java.util.Set, java.util.Set)}.
	 */
	@Test
	public void testIsSolvableSMSMessage() {
		ModelLoader loader = new ModelLoader();
		
		Set<Feature> boundedAlive = new HashSet<>();
		boundedAlive.add(loader.findFeature(model, "SMS"));
		boundedAlive.add(loader.findFeature(model, "Message"));
		Set<Feature> boundedDead = new HashSet<>();

		assertEquals("some features are missing", 2, boundedAlive.size());
		assertTrue(solver.isSolvable(boundedAlive, boundedDead));
	}
	
	/**
	 * Test method for {@link org.feature.model.sat.solver.SimpleSAT4JSolver#isSolvable(java.util.Set, java.util.Set)}.
	 */
	@Test
	public void testIsSolvableNotSMS() {
		ModelLoader loader = new ModelLoader();
		
		Set<Feature> boundedAlive = new HashSet<>();
		Set<Feature> boundedDead = new HashSet<>();
		boundedDead.add(loader.findFeature(model, "SMS"));
		

		assertEquals("some features are missing", 1, boundedDead.size());
		assertFalse(solver.isSolvable(boundedAlive, boundedDead));
	}
	
	/**
	 * Test method for {@link org.feature.model.sat.solver.SimpleSAT4JSolver#isSolvable(java.util.Set, java.util.Set)}.
	 */
	@Test
	public void testIsSolvableSMSExtras() {
		ModelLoader loader = new ModelLoader();
		
		Set<Feature> boundedAlive = new HashSet<>();
		boundedAlive.add(loader.findFeature(model, "SMS"));
		boundedAlive.add(loader.findFeature(model, "Extras"));
		Set<Feature> boundedDead = new HashSet<>();
		
		assertEquals("some features are missing", 2, boundedAlive.size());
		assertTrue(solver.isSolvable(boundedAlive, boundedDead));
	}
	
	/**
	 * Test method for {@link org.feature.model.sat.solver.SimpleSAT4JSolver#isSolvable(java.util.Set, java.util.Set)}.
	 */
	@Test
	public void testIsSolvableNOTSMSExtras() {
		ModelLoader loader = new ModelLoader();
		
		Set<Feature> boundedAlive = new HashSet<>();
		boundedAlive.add(loader.findFeature(model, "Extras"));
		Set<Feature> boundedDead = new HashSet<>();
		boundedDead.add(loader.findFeature(model, "SMS"));
		
		assertEquals("some features are missing", 1, boundedAlive.size());
		assertEquals("some features are missing", 1, boundedDead.size());
		assertFalse(solver.isSolvable(boundedAlive, boundedDead));
	}

	/**
	 * Test method for {@link org.feature.model.sat.solver.SimpleSAT4JSolver#isSolvable()}.
	 */
	@Test
	public void testIsSolvable() {
		assertTrue(solver.isSolvable());
	}
	
	@Test
	public void testRemoveMandatoryFeature() throws InterruptedException, IOException {
		ModelLoader loader = new ModelLoader();
		model = loader.loadModel("testdata" + File.separator + "SimplePhoneSAT.feature");
		SATModelBuilder builder = new SATModelBuilder(SolverFactory.newDefault());
		builder.buildSolverModel(model);
		IFeatureSolver solver = new SimpleSAT4JSolver(builder, model);
		
		Set<Feature> bounded = new HashSet<>();
		bounded.add(loader.findFeature(model, "Camera"));
		
		assertTrue(solver.isSolvable(bounded, new HashSet<Feature>()));
		assertTrue(solver.isSolvable(new HashSet<Feature>(), bounded));
	}
}
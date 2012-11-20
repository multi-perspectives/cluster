package org.feature.model.slicer.extendedModel.classification;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.feature.model.ModelLoader;
import org.feature.model.sat.builder.SATModelBuilder;
import org.feature.model.sat.solver.IFeatureSolver;
import org.feature.model.sat.solver.SimpleSAT4JSolver;
import org.featuremapper.models.feature.Feature;
import org.featuremapper.models.feature.FeatureModel;
import org.junit.Before;
import org.junit.Test;
import org.sat4j.minisat.SolverFactory;

/**
 * @author Ingo Reimund
 * @since 02.11.2012
 * 
 */
public class TestSimpleClassifier {

	/**
	 * test model
	 */
	private FeatureModel model;

	/**
	 * under test
	 */
	private SimpleClassifier classifier;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		classifier = new SimpleClassifier();
	}

	/**
	 * Test method for
	 * {@link org.feature.model.slicer.extendedModel.classification.SimpleClassifier#classify(org.feature.model.sat.solver.IFeatureSolver, java.util.Set, java.util.Set)}
	 * .
	 */
	@Test
	public void testClassifyIFeatureSolver() {
		model = new ModelLoader().loadModel("testdata/SimplePhoneSATSmall.feature");
		
		SATModelBuilder builder = new SATModelBuilder(SolverFactory.newDefault());
		builder.buildSolverModel(model);
		IFeatureSolver solver = new SimpleSAT4JSolver(builder, model);

		ClassifierHandler cHandler = classifier.classify(solver);

		assertEquals(2, cHandler.getBoundAliveFeatures().size());
		Set<String> alive = new HashSet<>(Arrays.asList(new String[] { "SMS", "Message" }));
		for (Feature feature : cHandler.getBoundAliveFeatures()) {
			assertTrue("feature " + feature.getName() + " should not be alive", alive.contains(feature.getName()));
		}

		assertEquals(0, cHandler.getBoundDeadFeatures().size());
		assertEquals(3, cHandler.getUnboundFeatures().size());
	}

	/**
	 * Test method for
	 * {@link org.feature.model.slicer.extendedModel.classification.SimpleClassifier#classify(org.feature.model.sat.solver.IFeatureSolver)}
	 * .
	 */
	@Test
	public void testClassifyIFeatureSolverSetOfFeatureSetOfFeature() {
		model = new ModelLoader().loadModel("testdata/SimplePhoneSATSmall.feature");
		
		SATModelBuilder builder = new SATModelBuilder(SolverFactory.newDefault());
		builder.buildSolverModel(model);
		IFeatureSolver solver = new SimpleSAT4JSolver(builder, model);

		Set<Feature> boundAlive = new HashSet<>();
		boundAlive.add(new ModelLoader().findFeature(model, "Extras"));
		Set<Feature> boundDead = new HashSet<>();

		assertFalse(boundAlive.isEmpty());
		ClassifierHandler cHandler = classifier.classify(solver, boundAlive, boundDead);
		assertEquals(3, cHandler.getBoundAliveFeatures().size());
		Set<String> alive = new HashSet<>(Arrays.asList(new String[] { "SMS", "Message", "Extras" }));
		for (Feature feature : cHandler.getBoundAliveFeatures()) {
			assertTrue("feature " + feature.getName() + " should not be alive", alive.remove(feature.getName()));
		}
		assertTrue("features " + alive.toString() + " should be alive", alive.isEmpty());

		assertEquals(0, cHandler.getBoundDeadFeatures().size());
		assertEquals(2, cHandler.getUnboundFeatures().size());
	}

	/**
	 * Test method for
	 * {@link org.feature.model.slicer.extendedModel.classification.SimpleClassifier#classify(org.feature.model.sat.solver.IFeatureSolver)}
	 * .
	 */
	@Test
	public void testClassifyIFeatureSolverSetOfFeatureSetOfFeatureWithEmptyLists() {
		model = new ModelLoader().loadModel("testdata/SimplePhoneSATSmall.feature");
		
		SATModelBuilder builder = new SATModelBuilder(SolverFactory.newDefault());
		builder.buildSolverModel(model);
		IFeatureSolver solver = new SimpleSAT4JSolver(builder, model);

		Set<Feature> boundAlive = new HashSet<>();
		Set<Feature> boundDead = new HashSet<>();

		SimpleClassifier classifier = new SimpleClassifier();
		ClassifierHandler cHandler = classifier.classify(solver, boundAlive, boundDead);
		assertEquals(2, cHandler.getBoundAliveFeatures().size());
		Set<String> alive = new HashSet<>(Arrays.asList(new String[] { "SMS", "Message" }));
		for (Feature feature : cHandler.getBoundAliveFeatures()) {
			assertTrue("feature " + feature.getName() + " should not be alive", alive.remove(feature.getName()));
		}
		assertTrue("features " + alive.toString() + " should be alive", alive.isEmpty());
		
		assertEquals(0, cHandler.getBoundDeadFeatures().size());
		assertEquals(3, cHandler.getUnboundFeatures().size());
	}
}
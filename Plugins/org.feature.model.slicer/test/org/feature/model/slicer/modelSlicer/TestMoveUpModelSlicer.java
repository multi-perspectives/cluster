package org.feature.model.slicer.modelSlicer;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.feature.model.sat.builder.SATModelBuilder;
import org.feature.model.sat.solver.IFeatureSolver;
import org.feature.model.sat.solver.SimpleSAT4JSolver;
import org.feature.model.slicer.extendedModel.classification.ClassifierHandler;
import org.feature.model.slicer.extendedModel.classification.SimpleClassifier;
import org.feature.model.slicer.modelSlicer.MoveUpModelSlicer;
import org.feature.model.utilities.FeatureModelLoader;
import org.feature.model.utilities.ModelComparator;
import org.featuremapper.models.feature.Feature;
import org.featuremapper.models.feature.FeatureModel;
import org.junit.Before;
import org.junit.Test;
import org.sat4j.minisat.SolverFactory;

public class TestMoveUpModelSlicer {

	private FeatureModelLoader loader = new FeatureModelLoader();

	/**
	 * test model
	 */
	private FeatureModel model;

	/**
	 * object under test
	 */
	private MoveUpModelSlicer slicer;

	/**
	 * path to expected files
	 */
	private String pathToExpected = "testdata" + File.separator + "expected" + File.separator;

	/**
	 * path to expected files
	 */
	private String pathToCurrent = "testdata" + File.separator + "current" + File.separator;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		slicer = new MoveUpModelSlicer();
	}

	@Test
	public void testRemoveMandatoryFeature() throws InterruptedException, IOException {
		model = loader.load("testdata" + File.separator + "SimplePhoneSAT.feature");
		SATModelBuilder builder = new SATModelBuilder(SolverFactory.newDefault());
		builder.buildSolverModel(model);
		IFeatureSolver solver = new SimpleSAT4JSolver(builder, model);

		SimpleClassifier classifier = new SimpleClassifier();
		ClassifierHandler cHandler = classifier.classify(solver);
		assertEquals(2, cHandler.getBoundAliveFeatures().size());

		FeatureModel trimmed = slicer.slice(model, cHandler);
		assertFalse(trimmed.getAllFeatures().isEmpty());
		assertNull(loader.findFeature(trimmed, "SMS"));
		assertNotNull(loader.findFeature(trimmed, "Extras"));
		assertNotNull(loader.findFeature(trimmed, "Communication"));
		assertEquals(model, trimmed);

		loader.save(trimmed, pathToCurrent + "MandatoryFeatureRemoved.feature");
		FeatureModel expected = loader.load(pathToExpected + "MandatoryFeatureRemoved.feature");
		assertTrue(new ModelComparator().unorderdDiff(trimmed, expected));
	}

	@Test
	public void testRemoveBoundOrFeature() throws InterruptedException, IOException {
		model = loader.load("testdata" + File.separator + "SimplePhoneSAT.feature");
		SATModelBuilder builder = new SATModelBuilder(SolverFactory.newDefault());
		builder.buildSolverModel(model);
		IFeatureSolver solver = new SimpleSAT4JSolver(builder, model);

		Set<Feature> boundAlive = new HashSet<>();
		boundAlive.add(loader.findFeature(model, "MP3")); // or feature
		Set<Feature> boundDead = new HashSet<>();

		assertNotNull(loader.findFeature(model, "MP3"));
		assertNotNull(loader.findFeature(model, "Extras"));

		SimpleClassifier classifier = new SimpleClassifier();
		ClassifierHandler cHandler = classifier.classify(solver, boundAlive, boundDead);

		FeatureModel trimmed = slicer.slice(model, cHandler);
		assertFalse(trimmed.getAllFeatures().isEmpty());
		assertNull(loader.findFeature(trimmed, "MP3"));
		assertNull(loader.findFeature(trimmed, "Extras"));
		assertNotNull(loader.findFeature(trimmed, "Camera"));
		assertEquals(model, trimmed);

		loader.save(trimmed, pathToCurrent + "OrFeatureBoundAndRemoved.feature");
		FeatureModel expected = loader.load(pathToExpected + "OrFeatureBoundAndRemoved.feature");
		assertTrue(new ModelComparator().unorderdDiff(trimmed, expected));
	}

	@Test
	public void testRemoveBoundAlternativeFeature() throws InterruptedException, IOException {
		model = loader.load("testdata" + File.separator + "SimplePhoneSAT.feature");
		SATModelBuilder builder = new SATModelBuilder(SolverFactory.newDefault());
		builder.buildSolverModel(model);
		IFeatureSolver solver = new SimpleSAT4JSolver(builder, model);

		Set<Feature> boundAlive = new HashSet<>();
		boundAlive.add(loader.findFeature(model, "M_8")); // Alternative feature
		Set<Feature> boundDead = new HashSet<>();

		assertNotNull(loader.findFeature(model, "M_8"));
		assertNotNull(loader.findFeature(model, "Camera"));
		assertNotNull(loader.findFeature(model, "Extras"));

		SimpleClassifier classifier = new SimpleClassifier();
		ClassifierHandler cHandler = classifier.classify(solver, boundAlive, boundDead);

		FeatureModel trimmed = slicer.slice(model, cHandler);
		assertFalse(trimmed.getAllFeatures().isEmpty());
		assertNull(loader.findFeature(trimmed, "M_8"));
		assertNull(loader.findFeature(trimmed, "Camera"));
		assertNull(loader.findFeature(trimmed, "Extras"));
		assertEquals(model, trimmed);

		loader.save(trimmed, pathToCurrent + "AlternativeFeatureBoundAndRemoved.feature");
		FeatureModel expected = loader.load(pathToExpected + "AlternativeFeatureBoundAndRemoved.feature");
		assertTrue(new ModelComparator().unorderdDiff(trimmed, expected));
	}

	@Test
	public void testRemoveBoundOptionalFeature() throws InterruptedException, IOException {
		model = loader.load("testdata" + File.separator + "SimplePhoneSAT.feature");
		SATModelBuilder builder = new SATModelBuilder(SolverFactory.newDefault());
		builder.buildSolverModel(model);
		IFeatureSolver solver = new SimpleSAT4JSolver(builder, model);

		Set<Feature> boundAlive = new HashSet<>();
		boundAlive.add(loader.findFeature(model, "MMS")); // optional
		Set<Feature> boundDead = new HashSet<>();

		assertNotNull(loader.findFeature(model, "MMS"));
		assertNotNull(loader.findFeature(model, "Camera"));
		assertNotNull(loader.findFeature(model, "Extras"));

		SimpleClassifier classifier = new SimpleClassifier();
		ClassifierHandler cHandler = classifier.classify(solver, boundAlive, boundDead);

		FeatureModel trimmed = slicer.slice(model, cHandler);
		assertFalse(trimmed.getAllFeatures().isEmpty());
		assertNull(loader.findFeature(trimmed, "MMS"));
		assertEquals(model, trimmed);

		loader.save(trimmed, pathToCurrent + "OptionalFeatureBoundAndRemoved.feature");
		FeatureModel expected = loader.load(pathToExpected + "OptionalFeatureBoundAndRemoved.feature");
		assertTrue(new ModelComparator().unorderdDiff(trimmed, expected));
	}

	@Test
	public void testRemoveCameraConstraint() throws InterruptedException, IOException {
		model = loader.load("testdata" + File.separator + "SimplePhoneSAT.feature");
		SATModelBuilder builder = new SATModelBuilder(SolverFactory.newDefault());
		builder.buildSolverModel(model);
		IFeatureSolver solver = new SimpleSAT4JSolver(builder, model);

		Set<Feature> boundAlive = new HashSet<>();
		boundAlive.add(loader.findFeature(model, "Camera")); // part of one
																// constraint
		Set<Feature> boundDead = new HashSet<>();

		assertNotNull(loader.findFeature(model, "Camera"));
		assertEquals("some constraints missing?", 2, model.getConstraints().size());

		SimpleClassifier classifier = new SimpleClassifier();
		ClassifierHandler cHandler = classifier.classify(solver, boundAlive, boundDead);
		FeatureModel trimmed = slicer.slice(model, cHandler);

		assertNull(loader.findFeature(trimmed, "Camera"));
		assertEquals("constraint not removed", 1, model.getConstraints().size());

		loader.save(trimmed, pathToCurrent + "ConstraintCameraRemoved.feature");
		FeatureModel expected = loader.load(pathToExpected + "ConstraintCameraRemoved.feature");
		assertTrue(new ModelComparator().unorderdDiff(trimmed, expected));
	}
}
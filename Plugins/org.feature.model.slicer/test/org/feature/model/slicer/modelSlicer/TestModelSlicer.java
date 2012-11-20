package org.feature.model.slicer.modelSlicer;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.compare.diff.metamodel.DiffModel;
import org.eclipse.emf.compare.diff.service.DiffService;
import org.eclipse.emf.compare.match.metamodel.MatchModel;
import org.eclipse.emf.compare.match.service.MatchService;
import org.eclipse.emf.compare.util.ModelUtils;
import org.feature.model.ModelLoader;
import org.feature.model.sat.builder.SATModelBuilder;
import org.feature.model.sat.solver.IFeatureSolver;
import org.feature.model.sat.solver.SimpleSAT4JSolver;
import org.feature.model.slicer.extendedModel.classification.ClassifierHandler;
import org.feature.model.slicer.extendedModel.classification.SimpleClassifier;
import org.feature.model.slicer.modelSlicer.ModelSlicer;
import org.featuremapper.models.feature.Feature;
import org.featuremapper.models.feature.FeatureModel;
import org.junit.Before;
import org.junit.Test;
import org.sat4j.minisat.SolverFactory;

public class TestModelSlicer {

	private ModelLoader loader = new ModelLoader();

	/**
	 * test model
	 */
	private FeatureModel model;

	/**
	 * object under test
	 */
	private ModelSlicer slicer;

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
		slicer = new ModelSlicer();
	}

	@Test
	public void testRemoveOneFeature() throws InterruptedException, IOException {
		model = loader.loadModel("testdata" + File.separator + "SimplePhoneSATSmall.feature");
		SATModelBuilder builder = new SATModelBuilder(SolverFactory.newDefault());
		builder.buildSolverModel(model);
		IFeatureSolver solver = new SimpleSAT4JSolver(builder, model);

		Set<Feature> boundAlive = new HashSet<>();
		boundAlive.add(loader.findFeature(model, "SMS"));
		Set<Feature> boundDead = new HashSet<>();

		assertNotNull(loader.findFeature(model, "SMS"));
		assertNotNull(loader.findFeature(model, "Extras"));

		SimpleClassifier classifier = new SimpleClassifier();
		ClassifierHandler cHandler = classifier.classify(solver, boundAlive, boundDead);

		FeatureModel trimmed = slicer.slice(model, cHandler);
		assertFalse(trimmed.getAllFeatures().isEmpty());
		assertNull(loader.findFeature(trimmed, "SMS"));
		assertNotNull(loader.findFeature(trimmed, "Extras"));
		assertEquals(model, trimmed);

		ModelUtils.save(trimmed, pathToCurrent + "OneFeatureRemoved.feature");
		FeatureModel expected = loader.loadModel(pathToExpected + "OneFeatureRemoved.feature");
		MatchModel match = MatchService.doMatch(trimmed, expected, new HashMap<String,Object>());
		DiffModel diff = DiffService.doDiff(match);
		assertTrue(diff.getDifferences().isEmpty());
	}
}
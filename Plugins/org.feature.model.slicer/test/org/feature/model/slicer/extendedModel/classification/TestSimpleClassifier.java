/**
 * 
 */
package org.feature.model.slicer.extendedModel.classification;

import static org.junit.Assert.*;

import java.io.File;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.PropertyConfigurator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.feature.model.sat.builder.SATModelBuilder;
import org.feature.model.sat.solver.IFeatureSolver;
import org.feature.model.sat.solver.SimpleSAT4JSolver;
import org.featuremapper.models.feature.Feature;
import org.featuremapper.models.feature.FeatureModel;
import org.featuremapper.models.feature.FeaturePackage;
import org.junit.Before;
import org.junit.BeforeClass;
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
		model = loadModel("testdata/SimplePhoneSATSmall.feature");
		classifier = new SimpleClassifier();
	}

	/**
	 * Test method for {@link org.feature.model.slicer.extendedModel.classification.SimpleClassifier#classify(org.feature.model.sat.solver.IFeatureSolver, java.util.Set, java.util.Set)}.
	 */
	@Test
	public void testClassifyIFeatureSolver() {
		SATModelBuilder builder = new SATModelBuilder(SolverFactory.newDefault());
		builder.buildSolverModel(model);
		IFeatureSolver solver = new SimpleSAT4JSolver(builder, model);
		
		ClassifierHandler cHandler = classifier.classify(solver);
		
		assertEquals(3, cHandler.getBoundAliveFeatures().size());
		Set<String> alive = new HashSet<>(Arrays.asList(new String[]{"SMS", "Message"}));
		for(Feature feature : cHandler.getBoundAliveFeatures()) {
			assertTrue("feature " + feature.getName() + " should not be alive", alive.contains(feature.getName()));
		}
		
		assertEquals(0, cHandler.getBoundDeadFeatures().size());
		
		
		assertEquals(3, cHandler.getUnboundFeatures().size());
	}

	/**
	 * Test method for {@link org.feature.model.slicer.extendedModel.classification.SimpleClassifier#classify(org.feature.model.sat.solver.IFeatureSolver, org.featuremapper.models.feature.Feature)}.
	 */
	@Test
	public void testClassifyIFeatureSolverFeature() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.feature.model.slicer.extendedModel.classification.SimpleClassifier#classify(org.feature.model.sat.solver.IFeatureSolver)}.
	 */
	@Test
	public void testClassifyIFeatureSolverSetOfFeatureSetOfFeature() {
		SATModelBuilder builder = new SATModelBuilder(SolverFactory.newDefault());
		builder.buildSolverModel(model);
		IFeatureSolver solver = new SimpleSAT4JSolver(builder, model);
		
		Set<Feature> boundAlive = findFeature(model, "Communication");
		Set<Feature> boundDead = new HashSet<>();
		
		assertFalse(boundAlive.isEmpty());
		SimpleClassifier classifier = new SimpleClassifier();
		ClassifierHandler cHandler = classifier.classify(solver, boundAlive, boundDead);
		assertEquals(3, cHandler.getBoundAliveFeatures().size());
		Set<String> alive = new HashSet<>(Arrays.asList(new String[]{"SMS", "Message, Communication"}));
		for(Feature feature : cHandler.getBoundAliveFeatures()) {
			assertTrue("feature " + feature.getName() + " should not be alive", alive.contains(feature.getName()));
		}
		
		assertEquals(0, cHandler.getBoundDeadFeatures().size());
		assertEquals(9, cHandler.getUnboundFeatures().size());
	}
	
	/**
	 * Test method for {@link org.feature.model.slicer.extendedModel.classification.SimpleClassifier#classify(org.feature.model.sat.solver.IFeatureSolver)}.
	 */
	@Test
	public void testClassifyIFeatureSolverSetOfFeatureSetOfFeatureWithEmptyLists() {
		SATModelBuilder builder = new SATModelBuilder(SolverFactory.newDefault());
		builder.buildSolverModel(model);
		IFeatureSolver solver = new SimpleSAT4JSolver(builder, model);
		
		Set<Feature> boundAlive = new HashSet<>();
		Set<Feature> boundDead = new HashSet<>();
		
		SimpleClassifier classifier = new SimpleClassifier();
		ClassifierHandler cHandler = classifier.classify(solver, boundAlive, boundDead);
		assertEquals(3, cHandler.getBoundAliveFeatures().size());
		assertEquals(0, cHandler.getBoundDeadFeatures().size());
		assertEquals(10, cHandler.getUnboundFeatures().size());
	}
	
	/**
	 * find features which name is matching to the given list of features
	 * 
	 * @param model
	 *            feature model
	 * @param features
	 *            name of wanted features
	 * @return set of wanted features
	 */
	public Set<Feature> findFeature(FeatureModel model, String... features) {
		Set<String> wanted = new HashSet<>(Arrays.asList(features));
		Set<Feature> set = new HashSet<>();
		for (Feature feature : model.getAllFeatures()) {
			for(String name : wanted) {
				if (wanted.contains(feature.getName())) {
					set.add(feature);
				}
			}
		}
		return set;
	}

	/**
	 * load feature model from file
	 * 
	 * @param pathToModel
	 *            path to file
	 * @return feature model
	 */
	private FeatureModel loadModel(String pathToModel) {
		// convert model path to uri
		URI uriToModel = URI.createFileURI(new File(pathToModel).getAbsolutePath());

		// load feature model from uri with a new resource set
		return FeatureModel.class.cast(loadModel(uriToModel, new ResourceSetImpl()));
	}

	/**
	 * load feature model from uri as EObject
	 * 
	 * @param uri
	 *            to model
	 * @param resourceSet
	 *            set of resources
	 * @return feature model
	 */
	private EObject loadModel(URI uri, ResourceSet resourceSet) {
		// Get the resource
		Resource resource = resourceSet.getResource(uri, true);
		
		// Add adapter for reverse navigation along unidirectional links
		ECrossReferenceAdapter adapter = ECrossReferenceAdapter.getCrossReferenceAdapter(resourceSet);
		if (adapter == null)
			resourceSet.eAdapters().add(new ECrossReferenceAdapter());

		// Return root model element
		return resource.getContents().get(0);
	}

	@BeforeClass
	public static void BeforeClass() {
		PropertyConfigurator.configure("conf/log4j.properties");
		BasicConfigurator.configure();

		// Add XMI factory to registry
		FeaturePackage.eINSTANCE.getName();
		Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		Map<String, Object> m = reg.getExtensionToFactoryMap();
		m.put("*", new XMIResourceFactoryImpl());
	}
}
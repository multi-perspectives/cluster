/**
 * 
 */
package org.feature.model.slicer.modelSlicer;

import static org.junit.Assert.*;

import java.io.File;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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
import org.feature.model.slicer.extendedModel.classification.ClassifierHandler;
import org.feature.model.slicer.extendedModel.classification.SimpleClassifier;
import org.feature.model.slicer.modelSlicer.ModelSlicer;
import org.featuremapper.models.feature.Feature;
import org.featuremapper.models.feature.FeatureModel;
import org.featuremapper.models.feature.FeaturePackage;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.sat4j.minisat.SolverFactory;

public class TestModelSlicer {

	/**
	 * test model
	 */
	private FeatureModel model;

	/**
	 * object under test
	 */
	private ModelSlicer slicer;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		slicer = new ModelSlicer();
	}

	@Test
	public void testRemoveOneFeature() {
		model = loadModel("testdata/SimplePhone.feature");
		SATModelBuilder builder = new SATModelBuilder(SolverFactory.newDefault());
		IFeatureSolver solver = new SimpleSAT4JSolver(builder, model);
		
		Set<Feature> boundAlive = findFeature(model, "MMS");
		Set<Feature> boundDead = new HashSet<>();
		
		SimpleClassifier classifier = new SimpleClassifier();
		ClassifierHandler cHandler = classifier.classify(solver, boundAlive, boundDead);

		FeatureModel trimmed = slicer.slice(model, cHandler);
		Set<Feature> unwanted = findFeature(trimmed, "MMS");
		assertTrue(unwanted.isEmpty());
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
				if (feature.getName().equals(name)) {
					set.add(feature);
				}
			}
//			if (wanted.contains(feature.getName())) {
//				set.add(feature);
//			}
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

		// Add XMI factory to registry
		FeaturePackage.eINSTANCE.getName();
		Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		Map<String, Object> m = reg.getExtensionToFactoryMap();
		m.put("*", new XMIResourceFactoryImpl());
	}
}
package org.feature.model.sat.builder;

import java.io.File;
import java.util.Map;

import org.apache.log4j.PropertyConfigurator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.feature.model.sat.builder.ISolverModelBuilder;
import org.feature.model.sat.builder.SATModelBuilder;
import org.feature.model.sat.exception.UnknownStatementException;
import org.featuremapper.models.feature.Feature;
import org.featuremapper.models.feature.FeatureModel;
import org.featuremapper.models.feature.FeaturePackage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.sat4j.core.VecInt;
import org.sat4j.minisat.SolverFactory;
import org.sat4j.specs.TimeoutException;
import org.sat4j.tools.GateTranslator;

public class TestModelBuilder {

	FeatureModel fm;

	@Before
	public void setUp() {
		// load activators of dependent plugins
		PropertyConfigurator.configure("conf/log4j.properties");
	}

	@Test
	/**
	 * Simple test if a given feature model is solvable. Feature Model on its own is solvable.
	 */
	public void testGetModelSuccess() {

		fm = (FeatureModel) loadModel(FeaturePackage.eINSTANCE,
				"testdata/SimplePhoneNoCTC.feature", null);

		GateTranslator solver = new GateTranslator(SolverFactory.newDefault());
		ISolverModelBuilder builder = new SATModelBuilder(solver);
		builder.buildSolverModel(fm);
		try {
			Assert.assertTrue(builder.getModel().isSatisfiable());
		} catch (TimeoutException e) {
			Assert.fail();
			e.printStackTrace();
		}
	}

	@Test
	/**
	 * Test if feature model with valid constraints is solvable.
	 */
	public void testGetModelSuccessReq() {

		fm = (FeatureModel) loadModel(FeaturePackage.eINSTANCE,
				"testdata/SimplePhoneNoCTC.feature", null);

		Feature testfeature1 = null, testfeature2 = null, testfeature3 = null, testfeature4 = null;

		for (Feature f : fm.getAllFeatures()) {
			if (f.getName().equals("UMTS")) {
				testfeature1 = f;
			} else if (f.getName().equals("SMS")) {
				testfeature2 = f;
			} else if (f.getName().equals("M_3")) {
				testfeature3 = f;
			} else if (f.getName().equals("WLAN")) {
				testfeature4 = f;
			}
		}

		if (testfeature1 == null || testfeature2 == null
				|| testfeature3 == null || testfeature4 == null)
			Assert.fail();

		GateTranslator solver = new GateTranslator(SolverFactory.newDefault());
		SATModelBuilder builder = new SATModelBuilder(solver);
		builder.buildSolverModel(fm);

		try {
			VecInt req = new VecInt();
			req.push(builder.getMapping(testfeature1));
			req.push(builder.getMapping(testfeature2));
			req.push(builder.getMapping(testfeature3));
			req.push(-builder.getMapping(testfeature4));

			Assert.assertEquals(true, builder.getModel().isSatisfiable(req));
		} catch (TimeoutException e) {
			Assert.fail();
			e.printStackTrace();
		} catch (UnknownStatementException e) {
			Assert.fail();
			e.printStackTrace();
		}
	}

	@Test
	/**
	 * Test for contradicting constraints in an alternative group
	 */
	public void testGetModelFailContAlternative() {

		fm = (FeatureModel) loadModel(FeaturePackage.eINSTANCE,
				"testdata/SimplePhoneNoCTC.feature", null);

		Feature testfeature1 = null, testfeature2 = null;

		for (Feature f : fm.getAllFeatures()) {
			if (f.getName().equals("M_8")) {
				testfeature1 = f;
			} else if (f.getName().equals("M_3")) {
				testfeature2 = f;
			}
		}

		if (testfeature1 == null || testfeature2 == null)
			Assert.fail();

		GateTranslator solver = new GateTranslator(SolverFactory.newDefault());
		SATModelBuilder builder = new SATModelBuilder(solver);
		builder.buildSolverModel(fm);

		try {
			VecInt req = new VecInt();
			req.push(builder.getMapping(testfeature1));
			req.push(builder.getMapping(testfeature2));

			Assert.assertEquals(false, builder.getModel().isSatisfiable(req));
		} catch (TimeoutException e) {
			Assert.fail();
			e.printStackTrace();
		} catch (UnknownStatementException e) {
			Assert.fail();
			e.printStackTrace();
		}
	}

	@Test
	/**
	 * Test for contradicting constraints child->parent
	 */
	public void testGetModelFailMandatoryParent() {

		fm = (FeatureModel) loadModel(FeaturePackage.eINSTANCE,
				"testdata/SimplePhoneNoCTC.feature", null);

		Feature testfeature1 = null, testfeature2 = null;

		for (Feature f : fm.getAllFeatures()) {
			if (f.getName().equals("GSM")) {
				testfeature1 = f;
			} else if (f.getName().equals("Communication")) {
				testfeature2 = f;
			}
		}

		if (testfeature1 == null || testfeature2 == null)
			Assert.fail();

		GateTranslator solver = new GateTranslator(SolverFactory.newDefault());
		SATModelBuilder builder = new SATModelBuilder(solver);
		builder.buildSolverModel(fm);

		try {
			VecInt req = new VecInt();
			req.push(builder.getMapping(testfeature1));
			req.push(-builder.getMapping(testfeature2));

			Assert.assertEquals(false, builder.getModel().isSatisfiable(req));
		} catch (TimeoutException e) {
			Assert.fail();
			e.printStackTrace();
		} catch (UnknownStatementException e) {
			Assert.fail();
			e.printStackTrace();
		}
	}

	@Test
	/**
	 * Test for contradicting constraints in a requirement relation
	 */
	public void testGetModelFailContReq() {

		fm = (FeatureModel) loadModel(FeaturePackage.eINSTANCE,
				"testdata/SimplePhoneNoCTC.feature", null);

		Feature testfeature1 = null, testfeature2 = null;

		for (Feature f : fm.getAllFeatures()) {
			if (f.getName().equals("M_8")) {
				testfeature1 = f;
			} else if (f.getName().equals("Extras")) {
				testfeature2 = f;
			}
		}

		if (testfeature1 == null || testfeature2 == null)
			Assert.fail();

		GateTranslator solver = new GateTranslator(SolverFactory.newDefault());
		SATModelBuilder builder = new SATModelBuilder(solver);
		builder.buildSolverModel(fm);

		try {
			VecInt req = new VecInt();
			req.push(builder.getMapping(testfeature1));
			req.push(-builder.getMapping(testfeature2));

			Assert.assertEquals(false, builder.getModel().isSatisfiable(req));
		} catch (TimeoutException e) {
			Assert.fail();
			e.printStackTrace();
		} catch (UnknownStatementException e) {
			Assert.fail();
			e.printStackTrace();
		}
	}

	@Test
	public void testGetModelFailReq() {

		fm = (FeatureModel) loadModel(FeaturePackage.eINSTANCE,
				"testdata/SimplePhoneNoCTC.feature", null);

		Feature testfeature1 = null;

		for (Feature f : fm.getAllFeatures()) {
			if (f.getName().equals("Message")) {
				testfeature1 = f;
				break;
			}
		}

		if (testfeature1 == null)
			Assert.fail();

		GateTranslator solver = new GateTranslator(SolverFactory.newDefault());
		SATModelBuilder builder = new SATModelBuilder(solver);
		builder.buildSolverModel(fm);

		try {
			VecInt req = new VecInt();
			req.push(-builder.getMapping(testfeature1));

			Assert.assertEquals(false, builder.getModel().isSatisfiable(req));
		} catch (TimeoutException e) {
			Assert.fail();
			e.printStackTrace();
		} catch (UnknownStatementException e) {
			Assert.fail();
			e.printStackTrace();
		}
	}

	@Test
	/**
	 * Test feature model with invalid specified cross tree constraints
	 */
	public void testGetModelFailModelConstraint() {

		fm = (FeatureModel) loadModel(FeaturePackage.eINSTANCE,
				"testdata/SimplePhoneFail.feature", null);

		GateTranslator solver = new GateTranslator(SolverFactory.newDefault());
		SATModelBuilder builder = new SATModelBuilder(solver);
		builder.buildSolverModel(fm);

		try {
			Assert.assertEquals(false, builder.getModel().isSatisfiable());
		} catch (TimeoutException e) {
			Assert.fail();
			e.printStackTrace();
		}
	}

	@Test
	/**
	 * test feature model specified with valid cross tree constraints
	 */
	public void testGetModelSuccessModelConstraint() {

		fm = (FeatureModel) loadModel(FeaturePackage.eINSTANCE,
				"testdata/SimplePhone.feature", null);

		GateTranslator solver = new GateTranslator(SolverFactory.newDefault());
		SATModelBuilder builder = new SATModelBuilder(solver);
		builder.buildSolverModel(fm);

		try {
			Assert.assertEquals(true, builder.getModel().isSatisfiable());
		} catch (TimeoutException e) {
			Assert.fail();
			e.printStackTrace();
		}
	}

	@Test
	/**
	 * Test for a selection of features via an exclude selection
	 */
	public void testGetModelFailModelConstraintExclude() {

		fm = (FeatureModel) loadModel(FeaturePackage.eINSTANCE,
				"testdata/SimplePhone.feature", null);

		Feature testfeature1 = null, testfeature2 = null;

		for (Feature f : fm.getAllFeatures()) {
			if (f.getName().equals("M_8")) {
				testfeature1 = f;
			} else if (f.getName().equals("MMS")) {
				testfeature2 = f;
			}
		}

		if (testfeature1 == null || testfeature2 == null)
			Assert.fail();

		GateTranslator solver = new GateTranslator(SolverFactory.newDefault());
		SATModelBuilder builder = new SATModelBuilder(solver);
		builder.buildSolverModel(fm);

		try {
			VecInt req = new VecInt();
			req.push(builder.getMapping(testfeature1));
			req.push(builder.getMapping(testfeature2));

			Assert.assertEquals(false, builder.getModel().isSatisfiable(req));
		} catch (TimeoutException e) {
			Assert.fail();
			e.printStackTrace();
		} catch (UnknownStatementException e) {
			Assert.fail();
			e.printStackTrace();
		}
	}

	@Test
	/**
	 * Test for a selection of features via an require selection
	 */
	public void testGetModelFailModelConstraintRequire() {

		fm = (FeatureModel) loadModel(FeaturePackage.eINSTANCE,
				"testdata/SimplePhone.feature", null);

		Feature testfeature1 = null, testfeature2 = null;

		for (Feature f : fm.getAllFeatures()) {
			if (f.getName().equals("Camera")) {
				testfeature1 = f;
			} else if (f.getName().equals("MMS")) {
				testfeature2 = f;
			}
		}

		if (testfeature1 == null || testfeature2 == null)
			Assert.fail();

		GateTranslator solver = new GateTranslator(SolverFactory.newDefault());
		SATModelBuilder builder = new SATModelBuilder(solver);
		builder.buildSolverModel(fm);

		try {
			VecInt req = new VecInt();
			req.push(-builder.getMapping(testfeature1));
			req.push(builder.getMapping(testfeature2));

			Assert.assertEquals(false, builder.getModel().isSatisfiable(req));
		} catch (TimeoutException e) {
			Assert.fail();
			e.printStackTrace();
		} catch (UnknownStatementException e) {
			Assert.fail();
			e.printStackTrace();
		}
	}

	@Test
	/**
	 * Test for a SAT constraint specification
	 */
	public void testGetModelFailModelConstraintSATRequire() {

		fm = (FeatureModel) loadModel(FeaturePackage.eINSTANCE,
				"testdata/SimplePhoneSAT.feature", null);

		Feature testfeature1 = null, testfeature2 = null;

		for (Feature f : fm.getAllFeatures()) {
			if (f.getName().equals("Camera")) {
				testfeature1 = f;
			} else if (f.getName().equals("MMS")) {
				testfeature2 = f;
			}
		}

		if (testfeature1 == null || testfeature2 == null)
			Assert.fail();

		GateTranslator solver = new GateTranslator(SolverFactory.newDefault());
		SATModelBuilder builder = new SATModelBuilder(solver);
		builder.buildSolverModel(fm);

		try {
			VecInt req = new VecInt();
			req.push(-builder.getMapping(testfeature1));
			req.push(builder.getMapping(testfeature2));

			Assert.assertEquals(false, builder.getModel().isSatisfiable(req));
		} catch (TimeoutException e) {
			Assert.fail();
			e.printStackTrace();
		} catch (UnknownStatementException e) {
			Assert.fail();
			e.printStackTrace();
		}

		try {
			VecInt req = new VecInt();
			req.push(builder.getMapping(testfeature1));
			req.push(-builder.getMapping(testfeature2));

			Assert.assertEquals(true, builder.getModel().isSatisfiable(req));
		} catch (TimeoutException e) {
			Assert.fail();
			e.printStackTrace();
		} catch (UnknownStatementException e) {
			Assert.fail();
			e.printStackTrace();
		}
	}

	private EObject loadModel(EPackage ePackage, String path,
			ResourceSet resourceSet) {
		initEMF(ePackage);

		return loadModel(createFileURI(path, true), resourceSet);
	}

	private EObject loadModel(URI uri, ResourceSet resourceSet) {
		// Obtain a new resource set if necessary
		if (resourceSet == null)
			resourceSet = new ResourceSetImpl();

		// Get the resource
		Resource resource = resourceSet.getResource(uri, true);

		// Add adapter for reverse navigation along unidirectional links
		ECrossReferenceAdapter adapter = ECrossReferenceAdapter
				.getCrossReferenceAdapter(resourceSet);
		if (adapter == null)
			resourceSet.eAdapters().add(new ECrossReferenceAdapter());

		// Return root model element
		return resource.getContents().get(0);
	}

	private URI createFileURI(String path, boolean mustExist) {
		File filePath = new File(path);
		if (!filePath.exists() && mustExist)
			throw new IllegalArgumentException(path + " does not exist.");

		return URI.createFileURI(filePath.getAbsolutePath());
	}

	private void registerXMIFactoryAsDefault() {
		// Add XMI factory to registry
		Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		Map<String, Object> m = reg.getExtensionToFactoryMap();
		m.put("*", new XMIResourceFactoryImpl());
	}

	private void initEMF(EPackage ePackage) {
		// Initialize the model
		// logger.debug("Initializing " + ePackage.getName());

		ePackage.getName();
		registerXMIFactoryAsDefault();
	}

}

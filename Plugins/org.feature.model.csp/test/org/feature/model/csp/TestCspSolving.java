package org.feature.model.csp;


import java.io.File;
import java.util.List;
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
import org.feature.model.csp.analyze.FeatureModelAnalyzer;
import org.feature.model.csp.analyze.FeatureVariant;
import org.featuremapper.models.feature.FeatureModel;
import org.featuremapper.models.feature.FeaturePackage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestCspSolving {

	@Before
	public void setUp() {
		PropertyConfigurator.configure("conf/log4j.properties");
		// load activators of dependent plugins
	}
	
	@Test
	public void test() {
		FeatureModel fm = (FeatureModel) loadModel(FeaturePackage.eINSTANCE,
				"testdata/SimplePhoneNoCTC.feature", null);

		FeatureModelAnalyzer fma = new FeatureModelAnalyzer(fm);

		List<FeatureVariant> productList;
		
		productList = fma.getAllVariants();
		
		int size = productList.size();
		
		Assert.assertTrue(size==108);
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

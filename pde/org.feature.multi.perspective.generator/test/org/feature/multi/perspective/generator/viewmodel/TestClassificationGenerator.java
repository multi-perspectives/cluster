package org.feature.multi.perspective.generator.viewmodel;

import static org.junit.Assert.*;

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
import org.feature.multi.perspective.classification.Classification;
import org.feature.multi.perspective.classification.ClassificationModel;
import org.feature.multi.perspective.mapping.viewmapping.Mapping;
import org.feature.multi.perspective.mapping.viewmapping.MappingModel;
import org.feature.multi.perspective.mapping.viewmapping.ViewmappingPackage;
import org.feature.multi.perspective.model.viewmodel.GroupModel;
import org.feature.multi.perspective.model.viewmodel.ViewmodelPackage;
import org.featuremapper.models.feature.FeatureModel;
import org.featuremapper.models.feature.FeaturePackage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestClassificationGenerator {

	@Before
	public void setUp() {
		PropertyConfigurator.configure("conf/log4j.properties");
		// load activators of dependent plugins
	}
	
	
	@Test
	public void test() {
		FeatureModel fm = (FeatureModel) loadModel(FeaturePackage.eINSTANCE,
				"testdata/feature/documentmanagement.feature", null);
		GroupModel gp = (GroupModel) loadModel(ViewmodelPackage.eINSTANCE,
				"testdata/viewmodel/documentmanagement.viewmodel", null);
		MappingModel mm = (MappingModel) loadModel(ViewmappingPackage.eINSTANCE,
				"testdata/mapping/mapping.viewmapping", null);
		
		ClassificationGenerator generator = new ClassificationGenerator();
		
		
		generator.setPercentUnbound(10);
		generator.setPercentUnclassified(0);
		
		
		generator.generateClassification(mm);
		
		ClassificationModel cModel = generator.getClassificationModel();
		cModel.getClassifications().size();
		int expectedContexts = generator.getNumContextPerView() * mm.getMappings().size() - generator.getNumContextPerView();
		
		Assert.assertEquals(expectedContexts, cModel.getClassifications().size());
		
		int overallNumAlive = 0;
		int overallNumDead = 0;
		int overallNumUnbound = 0;
		int overallNumUnclassified = 0;//TODO
		for(Classification c : cModel.getClassifications()) {
			overallNumAlive+=c.getAliveFeatures().size();
			overallNumDead+=c.getDeadFeatures().size();
			overallNumUnbound+=c.getUnboundFeatures().size();
		}
		
		Assert.assertTrue(overallNumAlive>0);
		Assert.assertTrue(overallNumDead>0);
		Assert.assertTrue(overallNumUnbound>0);
		
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

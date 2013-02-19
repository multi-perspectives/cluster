package org.feature.multi.perspective.classification;

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
import org.feature.multi.perspective.classification.impl.ClassificationFactoryImpl;
import org.feature.multi.perspective.classification.util.ClassificationAdapterFactory;
import org.feature.multi.perspective.mapping.viewmapping.Mapping;
import org.feature.multi.perspective.mapping.viewmapping.MappingModel;
import org.feature.multi.perspective.mapping.viewmapping.ViewmappingPackage;
import org.feature.multi.perspective.model.viewmodel.AbstractGroup;
import org.feature.multi.perspective.model.viewmodel.GroupModel;
import org.feature.multi.perspective.model.viewmodel.ViewmodelPackage;
import org.feature.multi.perspective.model.viewmodel.impl.ViewmodelFactoryImpl;
import org.featuremapper.models.feature.Feature;
import org.featuremapper.models.feature.FeatureModel;
import org.featuremapper.models.feature.FeaturePackage;
import org.featuremapper.models.feature.impl.FeatureFactoryImpl;
import org.featuremapper.models.feature.impl.FeatureImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestClassificationComposition {
	
	@Before
	public void setUp() {
		PropertyConfigurator.configure("conf/log4j.properties");
		// load activators of dependent plugins
	}	

	@Test
	public void succsessfullComposition() {
		
		FeatureModel fm = (FeatureModel) loadModel(FeaturePackage.eINSTANCE,
				"testdata/feature/documentmanagement.feature", null);
		GroupModel gp = (GroupModel) loadModel(ViewmodelPackage.eINSTANCE,
				"testdata/viewmodel/documentmanagement.viewmodel", null);
		MappingModel mm = (MappingModel) loadModel(ViewmappingPackage.eINSTANCE,
				"testdata/mapping/mapping.viewmapping", null);
		
		Feature pdf = null, imageType = null, titleIndex=null;
		
		//Grap Mapping basic and premium
		AbstractGroup basic=null, premium=null;
		for(Mapping m : mm.getMappings()){
			if(m.getViewgroup().getName().equals("Basic")){
				basic = m.getViewgroup();
				for (Feature f: m.getFeatures())
				{
					if(f.getName().equals("PDFType"))
						pdf = f;
					else if(f.getName().equals("PDFType"))
						imageType = f;
				}
				
			}
			else if(m.getViewgroup().getName().equals("Premium")){
				premium = m.getViewgroup();
				
				for (Feature f: m.getFeatures())
				{
					if(f.getName().equals("TitelIndex"))
						titleIndex = f;				
				}
			}
		}
		
		Assert.assertNotNull(premium);
		Assert.assertNotNull(basic);
		
		Classification classification1 = ClassificationFactoryImpl.eINSTANCE.createClassification();
		classification1.getViewgroups().add(basic);
		//Features ImageType, PDFType		
		ClassificationUtil.addClassifiedFeature(classification1, ClassificationUtil.createUnboundFeature(pdf));
		ClassificationUtil.addClassifiedFeature(classification1, ClassificationUtil.createAliveFeature(imageType));
		
		Classification classification2 = ClassificationFactoryImpl.eINSTANCE.createClassification();
		classification2.getViewgroups().add(premium);
		//Features PDFType, MetaDataIndex, TitelIndex, ContentIndex	
		ClassificationUtil.addClassifiedFeature(classification2, ClassificationUtil.createDeadFeature(pdf));
		ClassificationUtil.addClassifiedFeature(classification2, ClassificationUtil.createUnboundFeature(titleIndex));
		
		//TODO
//		Classification testCl = ClassificationUtil.composition(classification1, classification2);
		
//		Assert.assertNotNull(testCl);
	}
	
	@Test
	public void contradictingComposition() {
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

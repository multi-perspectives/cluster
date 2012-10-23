package formulaSlicer.formula;

import java.io.File;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import junit.framework.Assert;

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
import org.feature.model.sat.solver.IFeatureSolver;
import org.feature.model.sat.solver.SimpleSAT4JSolver;
import org.feature.model.slicer.formulaSlicer.formula.builder.SAT4JCNFFormulaFactory;
import org.featuremapper.models.feature.Feature;
import org.featuremapper.models.feature.FeatureModel;
import org.featuremapper.models.feature.FeaturePackage;
import org.junit.Before;
import org.junit.Test;
import org.sat4j.minisat.SolverFactory;
import org.sat4j.tools.GateTranslator;

public class TestCNFSlicing {

	@Before
	public void setUp() {
		PropertyConfigurator.configure("conf/log4j.properties");
		// load activators of dependent plugins
	}
	
	@Test
	public void testSimpleModelSlice() {
		
		FeatureModel fm = (FeatureModel) loadModel(FeaturePackage.eINSTANCE,
				"testdata/SimplePhoneNoCTC.feature", null);
		
		Set<Feature> deadFeatures = new HashSet<Feature>();
		Set<Feature> aliveFeatures = new HashSet<Feature>();
			
		for(Feature f : fm.getAllFeatures()) {
			if(f.getName().equals("M_8"))
				aliveFeatures.add(f);
			else if(f.getName().equals("Communication"))
				deadFeatures.add(f);
		}
		
		GateTranslator solver = new GateTranslator(SolverFactory.newDefault());
		ISolverModelBuilder satBuilder = new SATModelBuilder(solver);
		satBuilder.buildSolverModel(fm);
		IFeatureSolver featureSolver = new SimpleSAT4JSolver(satBuilder, fm);
		
		SAT4JCNFFormulaFactory cnfBuilder = new SAT4JCNFFormulaFactory();
		String trimmedCNF = cnfBuilder.createFormulaNameMinimized(featureSolver, aliveFeatures, deadFeatures);
				
		Assert.assertEquals(true, trimmedCNF.contains("MMS"));
		Assert.assertEquals(true, trimmedCNF.contains("MP3"));

		Assert.assertEquals(false, trimmedCNF.contains("Camera"));
		Assert.assertEquals(false, trimmedCNF.contains("M_8"));
		Assert.assertEquals(false, trimmedCNF.contains("Camera"));
		Assert.assertEquals(false, trimmedCNF.contains("Extras"));
		Assert.assertEquals(false, trimmedCNF.contains("WLAN"));
		Assert.assertEquals(false, trimmedCNF.contains("GSM"));
		Assert.assertEquals(false, trimmedCNF.contains("Bluetooth"));
	}
	
	@Test
	public void testCTCModelSlice() {
		
		FeatureModel fm = (FeatureModel) loadModel(FeaturePackage.eINSTANCE,
				"testdata/SimplePhoneSAT.feature", null);
		
		Set<Feature> deadFeatures = new HashSet<Feature>();
		Set<Feature> aliveFeatures = new HashSet<Feature>();
			
		for(Feature f : fm.getAllFeatures()) {
			if(f.getName().equals("MMS"))
				aliveFeatures.add(f);
		}
		
		GateTranslator solver = new GateTranslator(SolverFactory.newDefault());
		ISolverModelBuilder satBuilder = new SATModelBuilder(solver);
		satBuilder.buildSolverModel(fm);
		IFeatureSolver featureSolver = new SimpleSAT4JSolver(satBuilder, fm);
		
		SAT4JCNFFormulaFactory cnfBuilder = new SAT4JCNFFormulaFactory();
		String trimmedCNF = cnfBuilder.createFormulaNameMinimized(featureSolver, aliveFeatures, deadFeatures);
				
		Assert.assertEquals(false, trimmedCNF.contains("MMS"));
		Assert.assertEquals(false, trimmedCNF.contains("Camera"));
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

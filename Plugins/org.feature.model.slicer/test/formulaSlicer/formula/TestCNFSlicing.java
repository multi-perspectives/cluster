package formulaSlicer.formula;

import java.util.HashSet;
import java.util.Set;

import junit.framework.Assert;

import org.apache.log4j.PropertyConfigurator;
import org.feature.model.ModelLoader;
import org.feature.model.sat.builder.ISolverModelBuilder;
import org.feature.model.sat.builder.SATModelBuilder;
import org.feature.model.sat.solver.IFeatureSolver;
import org.feature.model.sat.solver.SimpleSAT4JSolver;
import org.feature.model.slicer.formulaSlicer.formula.builder.SAT4JCNFFormulaFactory;
import org.featuremapper.models.feature.Feature;
import org.featuremapper.models.feature.FeatureModel;
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

		FeatureModel fm = new ModelLoader().loadModel("testdata/SimplePhoneNoCTC.feature");

		Set<Feature> deadFeatures = new HashSet<Feature>();
		Set<Feature> aliveFeatures = new HashSet<Feature>();

		for (Feature f : fm.getAllFeatures()) {
			if (f.getName().equals("M_8"))
				aliveFeatures.add(f);
			else if (f.getName().equals("Communication"))
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

		FeatureModel fm = new ModelLoader().loadModel("testdata/SimplePhoneSAT.feature");

		Set<Feature> deadFeatures = new HashSet<Feature>();
		Set<Feature> aliveFeatures = new HashSet<Feature>();

		Feature feature = new ModelLoader().findFeature(fm, "MMS");
		if (feature != null) {
			aliveFeatures.add(feature);
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
}
package formulaSlicer.formula;


import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.PropertyConfigurator;
import org.feature.model.slicer.formulaSlicer.formula.builder.SAT4JCNFFormulaFactory;
import org.feature.model.utilities.FeatureModelLoader;
import org.featuremapper.models.feature.FeatureModel;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestCNFBuild {
	
	@Before
	public void setUp() {
		PropertyConfigurator.configure("conf/log4j.properties");
		BasicConfigurator.configure();
		// load activators of dependent plugins
	}

	@Test
	public void testSimpleCNFBuild() {
		FeatureModel fm = new FeatureModelLoader().load("testdata/SimplePhoneNoCTC.feature");
		
		SAT4JCNFFormulaFactory builder = new SAT4JCNFFormulaFactory();
		String cnf = builder.createFormulaName(fm);
		Assert.assertEquals(true, cnf.contains("Message"));
		Assert.assertEquals(true, cnf.contains("SMS"));		
	}
}
/**
 * 
 */
package org.feature.model.slicer.extendedModel.classification;

import static org.junit.Assert.*;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.PropertyConfigurator;
import org.feature.model.ModelLoader;
import org.featuremapper.models.feature.Feature;
import org.featuremapper.models.feature.FeatureModel;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author ireimund
 * 
 */
public class TestClassifierHandler {

	/**
	 * feature model
	 */
	private FeatureModel model;

	/**
	 * to test
	 */
	private ClassifierHandler handler;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		PropertyConfigurator.configure("conf/log4j.properties");
		BasicConfigurator.configure();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		model = new ModelLoader().loadModel("testdata/SimplePhone.feature");
		handler = new ClassifierHandler(model);
	}

	/**
	 * Test method for {@link
	 * org.feature.model.slicer.extendedModel.classification.ClassifierHandler.
	 * ClassifierHandler(org.featuremapper.models.feature.FeatureModel)}.
	 */
	@Test
	public void testClassifierHandler() {
		assertEquals(0, handler.getUnboundFeatures().size());
		assertEquals(0, handler.getBoundAliveFeatures().size());
		assertEquals(0, handler.getBoundDeadFeatures().size());
		assertFalse(handler.isCompletelyClassified());
		assertEquals(13, handler.getNonClassifiedFeatures().size());
		assertEquals(0, handler.getComputedClassifications().size());
	}

	/**
	 * Test method for
	 * {@link org.feature.model.slicer.extendedModel.classification.ClassifierHandler#classifyBoundAlive(org.featuremapper.models.feature.Feature, boolean)}
	 * .
	 */
	@Test
	public void testClassifyBoundAlive() {
		Feature f = new ModelLoader().findFeature(model, "SMS");
		
		assertTrue(handler.getNonClassifiedFeatures().contains(f));
		assertFalse(handler.getBoundAliveFeatures().contains(f));
		handler.classifyBoundAlive(f, false);
		assertTrue(handler.getBoundAliveFeatures().contains(f));
		assertFalse(handler.getNonClassifiedFeatures().contains(f));
	}

	/**
	 * Test method for
	 * {@link org.feature.model.slicer.extendedModel.classification.ClassifierHandler#classifyBoundDead(org.featuremapper.models.feature.Feature, boolean)}
	 * .
	 */
	@Test
	public void testClassifyBoundDead() {
		Feature f = new ModelLoader().findFeature(model, "SMS");
		
		assertTrue(handler.getNonClassifiedFeatures().contains(f));
		assertFalse(handler.getBoundDeadFeatures().contains(f));
		handler.classifyBoundDead(f, false);
		assertTrue(handler.getBoundDeadFeatures().contains(f));
		assertFalse(handler.getNonClassifiedFeatures().contains(f));
	}

	/**
	 * Test method for
	 * {@link org.feature.model.slicer.extendedModel.classification.ClassifierHandler#classifyUnbound(org.featuremapper.models.feature.Feature, boolean)}
	 * .
	 */
	@Test
	public void testClassifyUnbound() {
		Feature f = new ModelLoader().findFeature(model, "SMS");
		
		assertTrue(handler.getNonClassifiedFeatures().contains(f));
		assertFalse(handler.getUnboundFeatures().contains(f));
		handler.classifyUnbound(f, false);
		assertTrue(handler.getUnboundFeatures().contains(f));
		assertFalse(handler.getNonClassifiedFeatures().contains(f));
	}

	/**
	 * Test method for
	 * {@link org.feature.model.slicer.extendedModel.classification.ClassifierHandler#removeClassification(org.featuremapper.models.feature.Feature)}
	 * .
	 */
	@Test
	public void testRemoveClassification() {
		Feature f = new ModelLoader().findFeature(model, "SMS");
		handler.classifyBoundAlive(f, false);
		
		assertTrue(handler.getBoundAliveFeatures().contains(f));
		assertFalse(handler.getNonClassifiedFeatures().contains(f));
		handler.removeClassification(f);
		assertTrue(handler.getNonClassifiedFeatures().contains(f));
		assertFalse(handler.getBoundAliveFeatures().contains(f));
	}
}
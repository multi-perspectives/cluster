/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.feature.cluster.model.cluster.tests;

import junit.textui.TestRunner;

import org.feature.cluster.model.cluster.ClusterFactory;
import org.feature.cluster.model.cluster.ViewPoint;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>View Point</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class ViewPointTest extends ElementTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(ViewPointTest.class);
	}

	/**
	 * Constructs a new View Point test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ViewPointTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this View Point test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected ViewPoint getFixture() {
		return (ViewPoint)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(ClusterFactory.eINSTANCE.createViewPoint());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}

} //ViewPointTest

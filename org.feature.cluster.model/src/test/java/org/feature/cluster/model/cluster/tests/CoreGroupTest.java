/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.feature.cluster.model.cluster.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import org.feature.cluster.model.cluster.ClusterFactory;
import org.feature.cluster.model.cluster.CoreGroup;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Core Group</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class CoreGroupTest extends TestCase {

	/**
	 * The fixture for this Core Group test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CoreGroup fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(CoreGroupTest.class);
	}

	/**
	 * Constructs a new Core Group test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CoreGroupTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Core Group test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(CoreGroup fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Core Group test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CoreGroup getFixture() {
		return fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(ClusterFactory.eINSTANCE.createCoreGroup());
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

} //CoreGroupTest

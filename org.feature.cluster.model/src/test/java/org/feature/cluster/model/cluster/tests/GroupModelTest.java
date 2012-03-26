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
import org.feature.cluster.model.cluster.GroupModel;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Group Model</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class GroupModelTest extends TestCase {

	/**
    * The fixture for this Group Model test case.
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	protected GroupModel fixture = null;

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	public static void main(String[] args) {
      TestRunner.run(GroupModelTest.class);
   }

	/**
    * Constructs a new Group Model test case with the given name.
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	public GroupModelTest(String name) {
      super(name);
   }

	/**
    * Sets the fixture for this Group Model test case.
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	protected void setFixture(GroupModel fixture) {
      this.fixture = fixture;
   }

	/**
    * Returns the fixture for this Group Model test case.
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	protected GroupModel getFixture() {
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
      setFixture(ClusterFactory.eINSTANCE.createGroupModel());
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

} //GroupModelTest

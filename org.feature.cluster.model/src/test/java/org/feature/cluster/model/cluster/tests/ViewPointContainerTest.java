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
import org.feature.cluster.model.cluster.ViewPointContainer;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>View Point Container</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class ViewPointContainerTest extends TestCase {

   /**
    * The fixture for this View Point Container test case.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   protected ViewPointContainer fixture = null;

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public static void main(String[] args) {
      TestRunner.run(ViewPointContainerTest.class);
   }

   /**
    * Constructs a new View Point Container test case with the given name.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public ViewPointContainerTest(String name) {
      super(name);
   }

   /**
    * Sets the fixture for this View Point Container test case.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   protected void setFixture(ViewPointContainer fixture) {
      this.fixture = fixture;
   }

   /**
    * Returns the fixture for this View Point Container test case.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   protected ViewPointContainer getFixture() {
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
      setFixture(ClusterFactory.eINSTANCE.createViewPointContainer());
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

} //ViewPointContainerTest

/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.feature.cluster.model.tests;

import junit.framework.Test;
import junit.framework.TestSuite;

import junit.textui.TestRunner;

import org.feature.cluster.model.cluster.tests.ClusterTests;

/**
 * <!-- begin-user-doc -->
 * A test suite for the '<em><b>Cluster</b></em>' model.
 * <!-- end-user-doc -->
 * @generated
 */
public class ClusterAllTests extends TestSuite {

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public static void main(String[] args) {
		TestRunner.run(suite());
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public static Test suite() {
		TestSuite suite = new ClusterAllTests("Cluster Tests");
		suite.addTest(ClusterTests.suite());
		return suite;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public ClusterAllTests(String name) {
		super(name);
	}

} //ClusterAllTests

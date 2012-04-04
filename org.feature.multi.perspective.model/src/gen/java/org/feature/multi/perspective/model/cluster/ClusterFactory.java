/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.feature.multi.perspective.model.cluster;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.feature.multi.perspective.model.cluster.ClusterPackage
 * @generated
 */
public interface ClusterFactory extends EFactory {
	/**
    * The singleton instance of the factory.
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	ClusterFactory eINSTANCE = org.feature.multi.perspective.model.cluster.impl.ClusterFactoryImpl.init();

	/**
    * Returns a new object of class '<em>Core Group</em>'.
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @return a new object of class '<em>Core Group</em>'.
    * @generated
    */
	CoreGroup createCoreGroup();

	/**
    * Returns a new object of class '<em>Group</em>'.
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @return a new object of class '<em>Group</em>'.
    * @generated
    */
	Group createGroup();

	/**
    * Returns a new object of class '<em>View Point</em>'.
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @return a new object of class '<em>View Point</em>'.
    * @generated
    */
	ViewPoint createViewPoint();

	/**
    * Returns a new object of class '<em>Group Model</em>'.
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @return a new object of class '<em>Group Model</em>'.
    * @generated
    */
	GroupModel createGroupModel();

	/**
    * Returns a new object of class '<em>View Point Container</em>'.
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @return a new object of class '<em>View Point Container</em>'.
    * @generated
    */
	ViewPointContainer createViewPointContainer();

	/**
    * Returns the package supported by this factory.
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @return the package supported by this factory.
    * @generated
    */
	ClusterPackage getClusterPackage();

} //ClusterFactory

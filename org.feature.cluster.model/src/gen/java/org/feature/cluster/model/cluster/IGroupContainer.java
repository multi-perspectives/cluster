/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.feature.cluster.model.cluster;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>IGroup Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.feature.cluster.model.cluster.IGroupContainer#getGroups <em>Groups</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.feature.cluster.model.cluster.ClusterPackage#getIGroupContainer()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface IGroupContainer extends EObject {
	/**
	 * Returns the value of the '<em><b>Groups</b></em>' containment reference list.
	 * The list contents are of type {@link org.feature.cluster.model.cluster.Group}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Groups</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Groups</em>' containment reference list.
	 * @see org.feature.cluster.model.cluster.ClusterPackage#getIGroupContainer_Groups()
	 * @model containment="true"
	 * @generated
	 */
	EList<Group> getGroups();

} // IGroupContainer

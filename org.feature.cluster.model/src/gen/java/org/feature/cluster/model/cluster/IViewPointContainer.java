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
 * A representation of the model object '<em><b>IView Point Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.feature.cluster.model.cluster.IViewPointContainer#getViewPoints <em>View Points</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.feature.cluster.model.cluster.ClusterPackage#getIViewPointContainer()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface IViewPointContainer extends EObject {
	/**
	 * Returns the value of the '<em><b>View Points</b></em>' containment reference list.
	 * The list contents are of type {@link org.feature.cluster.model.cluster.ViewPoint}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>View Points</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>View Points</em>' containment reference list.
	 * @see org.feature.cluster.model.cluster.ClusterPackage#getIViewPointContainer_ViewPoints()
	 * @model containment="true"
	 * @generated
	 */
	EList<ViewPoint> getViewPoints();

} // IViewPointContainer

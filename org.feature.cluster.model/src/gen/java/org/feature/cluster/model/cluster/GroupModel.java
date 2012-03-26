/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.feature.cluster.model.cluster;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Group Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.feature.cluster.model.cluster.GroupModel#getCoreGroup <em>Core Group</em>}</li>
 *   <li>{@link org.feature.cluster.model.cluster.GroupModel#getViewPointContainer <em>View Point Container</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.feature.cluster.model.cluster.ClusterPackage#getGroupModel()
 * @model
 * @generated
 */
public interface GroupModel extends EObject {
	/**
    * Returns the value of the '<em><b>Core Group</b></em>' containment reference.
    * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Core Group</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
    * @return the value of the '<em>Core Group</em>' containment reference.
    * @see #setCoreGroup(CoreGroup)
    * @see org.feature.cluster.model.cluster.ClusterPackage#getGroupModel_CoreGroup()
    * @model containment="true" required="true"
    * @generated
    */
	CoreGroup getCoreGroup();

	/**
    * Sets the value of the '{@link org.feature.cluster.model.cluster.GroupModel#getCoreGroup <em>Core Group</em>}' containment reference.
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @param value the new value of the '<em>Core Group</em>' containment reference.
    * @see #getCoreGroup()
    * @generated
    */
	void setCoreGroup(CoreGroup value);

	/**
    * Returns the value of the '<em><b>View Point Container</b></em>' containment reference.
    * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>View Point Container</em>' containment reference isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
    * @return the value of the '<em>View Point Container</em>' containment reference.
    * @see #setViewPointContainer(ViewPointContainer)
    * @see org.feature.cluster.model.cluster.ClusterPackage#getGroupModel_ViewPointContainer()
    * @model containment="true" required="true"
    * @generated
    */
   ViewPointContainer getViewPointContainer();

   /**
    * Sets the value of the '{@link org.feature.cluster.model.cluster.GroupModel#getViewPointContainer <em>View Point Container</em>}' containment reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @param value the new value of the '<em>View Point Container</em>' containment reference.
    * @see #getViewPointContainer()
    * @generated
    */
   void setViewPointContainer(ViewPointContainer value);

} // GroupModel

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
 * A representation of the model object '<em><b>IGroup</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.feature.cluster.model.cluster.IGroup#getGroups <em>Groups</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.feature.cluster.model.cluster.ClusterPackage#getIGroup()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface IGroup extends EObject {
   /**
    * Returns the value of the '<em><b>Groups</b></em>' containment reference list.
    * The list contents are of type {@link org.feature.cluster.model.cluster.Group}.
    * It is bidirectional and its opposite is '{@link org.feature.cluster.model.cluster.Group#getParentGroup <em>Parent Group</em>}'.
    * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Groups</em>' containment reference list isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
    * @return the value of the '<em>Groups</em>' containment reference list.
    * @see org.feature.cluster.model.cluster.ClusterPackage#getIGroup_Groups()
    * @see org.feature.cluster.model.cluster.Group#getParentGroup
    * @model opposite="parentGroup" containment="true"
    * @generated
    */
   EList<Group> getGroups();

} // IGroup

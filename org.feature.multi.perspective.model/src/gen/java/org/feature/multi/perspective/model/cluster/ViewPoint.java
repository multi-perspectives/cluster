/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.feature.multi.perspective.model.cluster;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>View Point</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.feature.multi.perspective.model.cluster.ViewPoint#getContainedInGroup <em>Contained In Group</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.feature.multi.perspective.model.cluster.ClusterPackage#getViewPoint()
 * @model
 * @generated
 */
public interface ViewPoint extends Element {
	/**
    * Returns the value of the '<em><b>Contained In Group</b></em>' reference list.
    * The list contents are of type {@link org.feature.multi.perspective.model.cluster.Group}.
    * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Contained In Group</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
    * @return the value of the '<em>Contained In Group</em>' reference list.
    * @see org.feature.multi.perspective.model.cluster.ClusterPackage#getViewPoint_ContainedInGroup()
    * @model changeable="false"
    * @generated
    */
	EList<Group> getContainedInGroup();

} // ViewPoint

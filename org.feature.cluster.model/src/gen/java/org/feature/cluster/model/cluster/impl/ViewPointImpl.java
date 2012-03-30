/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.feature.cluster.model.cluster.impl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.feature.cluster.model.cluster.ClusterPackage;
import org.feature.cluster.model.cluster.Group;
import org.feature.cluster.model.cluster.ViewPoint;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>View Point</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.feature.cluster.model.cluster.impl.ViewPointImpl#getContainedInGroup <em>Contained In Group</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ViewPointImpl extends ElementImpl implements ViewPoint {
	/**
	 * The cached value of the '{@link #getContainedInGroup() <em>Contained In Group</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContainedInGroup()
	 * @generated
	 * @ordered
	 */
	protected EList<Group> containedInGroup;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ViewPointImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ClusterPackage.Literals.VIEW_POINT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Group> getContainedInGroup() {
		if (containedInGroup == null) {
			containedInGroup = new EObjectResolvingEList<Group>(Group.class, this, ClusterPackage.VIEW_POINT__CONTAINED_IN_GROUP);
		}
		return containedInGroup;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ClusterPackage.VIEW_POINT__CONTAINED_IN_GROUP:
				return getContainedInGroup();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ClusterPackage.VIEW_POINT__CONTAINED_IN_GROUP:
				return containedInGroup != null && !containedInGroup.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ViewPointImpl

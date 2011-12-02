/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.feature.cluster.model.cluster.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.feature.cluster.model.cluster.ClusterPackage;
import org.feature.cluster.model.cluster.CoreGroup;
import org.feature.cluster.model.cluster.GroupModel;
import org.feature.cluster.model.cluster.ViewPointContainer;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Group Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.feature.cluster.model.cluster.impl.GroupModelImpl#getCoreGroup <em>Core Group</em>}</li>
 *   <li>{@link org.feature.cluster.model.cluster.impl.GroupModelImpl#getViewPoints <em>View Points</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GroupModelImpl extends EObjectImpl implements GroupModel {
	/**
	 * The cached value of the '{@link #getCoreGroup() <em>Core Group</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCoreGroup()
	 * @generated
	 * @ordered
	 */
	protected CoreGroup coreGroup;

	/**
	 * The cached value of the '{@link #getViewPoints() <em>View Points</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getViewPoints()
	 * @generated
	 * @ordered
	 */
	protected ViewPointContainer viewPoints;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GroupModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ClusterPackage.Literals.GROUP_MODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CoreGroup getCoreGroup() {
		return coreGroup;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCoreGroup(CoreGroup newCoreGroup, NotificationChain msgs) {
		CoreGroup oldCoreGroup = coreGroup;
		coreGroup = newCoreGroup;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ClusterPackage.GROUP_MODEL__CORE_GROUP, oldCoreGroup, newCoreGroup);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCoreGroup(CoreGroup newCoreGroup) {
		if (newCoreGroup != coreGroup) {
			NotificationChain msgs = null;
			if (coreGroup != null)
				msgs = ((InternalEObject)coreGroup).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ClusterPackage.GROUP_MODEL__CORE_GROUP, null, msgs);
			if (newCoreGroup != null)
				msgs = ((InternalEObject)newCoreGroup).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ClusterPackage.GROUP_MODEL__CORE_GROUP, null, msgs);
			msgs = basicSetCoreGroup(newCoreGroup, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ClusterPackage.GROUP_MODEL__CORE_GROUP, newCoreGroup, newCoreGroup));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ViewPointContainer getViewPoints() {
		return viewPoints;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetViewPoints(ViewPointContainer newViewPoints, NotificationChain msgs) {
		ViewPointContainer oldViewPoints = viewPoints;
		viewPoints = newViewPoints;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ClusterPackage.GROUP_MODEL__VIEW_POINTS, oldViewPoints, newViewPoints);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setViewPoints(ViewPointContainer newViewPoints) {
		if (newViewPoints != viewPoints) {
			NotificationChain msgs = null;
			if (viewPoints != null)
				msgs = ((InternalEObject)viewPoints).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ClusterPackage.GROUP_MODEL__VIEW_POINTS, null, msgs);
			if (newViewPoints != null)
				msgs = ((InternalEObject)newViewPoints).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ClusterPackage.GROUP_MODEL__VIEW_POINTS, null, msgs);
			msgs = basicSetViewPoints(newViewPoints, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ClusterPackage.GROUP_MODEL__VIEW_POINTS, newViewPoints, newViewPoints));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ClusterPackage.GROUP_MODEL__CORE_GROUP:
				return basicSetCoreGroup(null, msgs);
			case ClusterPackage.GROUP_MODEL__VIEW_POINTS:
				return basicSetViewPoints(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ClusterPackage.GROUP_MODEL__CORE_GROUP:
				return getCoreGroup();
			case ClusterPackage.GROUP_MODEL__VIEW_POINTS:
				return getViewPoints();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ClusterPackage.GROUP_MODEL__CORE_GROUP:
				setCoreGroup((CoreGroup)newValue);
				return;
			case ClusterPackage.GROUP_MODEL__VIEW_POINTS:
				setViewPoints((ViewPointContainer)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ClusterPackage.GROUP_MODEL__CORE_GROUP:
				setCoreGroup((CoreGroup)null);
				return;
			case ClusterPackage.GROUP_MODEL__VIEW_POINTS:
				setViewPoints((ViewPointContainer)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ClusterPackage.GROUP_MODEL__CORE_GROUP:
				return coreGroup != null;
			case ClusterPackage.GROUP_MODEL__VIEW_POINTS:
				return viewPoints != null;
		}
		return super.eIsSet(featureID);
	}

} //GroupModelImpl

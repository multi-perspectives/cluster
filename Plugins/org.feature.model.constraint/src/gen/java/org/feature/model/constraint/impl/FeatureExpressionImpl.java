/**
 */
package org.feature.model.constraint.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.feature.model.constraint.ConstraintPackage;
import org.feature.model.constraint.FeatureExpression;

import org.featuremapper.models.feature.Feature;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Feature Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.feature.model.constraint.impl.FeatureExpressionImpl#getLeftFeature <em>Left Feature</em>}</li>
 *   <li>{@link org.feature.model.constraint.impl.FeatureExpressionImpl#getRightFeature <em>Right Feature</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class FeatureExpressionImpl extends EObjectImpl implements FeatureExpression
{
  /**
   * The cached value of the '{@link #getLeftFeature() <em>Left Feature</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLeftFeature()
   * @generated
   * @ordered
   */
  protected Feature leftFeature;

  /**
   * The cached value of the '{@link #getRightFeature() <em>Right Feature</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRightFeature()
   * @generated
   * @ordered
   */
  protected Feature rightFeature;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected FeatureExpressionImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return ConstraintPackage.Literals.FEATURE_EXPRESSION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Feature getLeftFeature()
  {
    if (leftFeature != null && leftFeature.eIsProxy())
    {
      InternalEObject oldLeftFeature = (InternalEObject)leftFeature;
      leftFeature = (Feature)eResolveProxy(oldLeftFeature);
      if (leftFeature != oldLeftFeature)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ConstraintPackage.FEATURE_EXPRESSION__LEFT_FEATURE, oldLeftFeature, leftFeature));
      }
    }
    return leftFeature;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Feature basicGetLeftFeature()
  {
    return leftFeature;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLeftFeature(Feature newLeftFeature)
  {
    Feature oldLeftFeature = leftFeature;
    leftFeature = newLeftFeature;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ConstraintPackage.FEATURE_EXPRESSION__LEFT_FEATURE, oldLeftFeature, leftFeature));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Feature getRightFeature()
  {
    if (rightFeature != null && rightFeature.eIsProxy())
    {
      InternalEObject oldRightFeature = (InternalEObject)rightFeature;
      rightFeature = (Feature)eResolveProxy(oldRightFeature);
      if (rightFeature != oldRightFeature)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ConstraintPackage.FEATURE_EXPRESSION__RIGHT_FEATURE, oldRightFeature, rightFeature));
      }
    }
    return rightFeature;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Feature basicGetRightFeature()
  {
    return rightFeature;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRightFeature(Feature newRightFeature)
  {
    Feature oldRightFeature = rightFeature;
    rightFeature = newRightFeature;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ConstraintPackage.FEATURE_EXPRESSION__RIGHT_FEATURE, oldRightFeature, rightFeature));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case ConstraintPackage.FEATURE_EXPRESSION__LEFT_FEATURE:
        if (resolve) return getLeftFeature();
        return basicGetLeftFeature();
      case ConstraintPackage.FEATURE_EXPRESSION__RIGHT_FEATURE:
        if (resolve) return getRightFeature();
        return basicGetRightFeature();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case ConstraintPackage.FEATURE_EXPRESSION__LEFT_FEATURE:
        setLeftFeature((Feature)newValue);
        return;
      case ConstraintPackage.FEATURE_EXPRESSION__RIGHT_FEATURE:
        setRightFeature((Feature)newValue);
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
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case ConstraintPackage.FEATURE_EXPRESSION__LEFT_FEATURE:
        setLeftFeature((Feature)null);
        return;
      case ConstraintPackage.FEATURE_EXPRESSION__RIGHT_FEATURE:
        setRightFeature((Feature)null);
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
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case ConstraintPackage.FEATURE_EXPRESSION__LEFT_FEATURE:
        return leftFeature != null;
      case ConstraintPackage.FEATURE_EXPRESSION__RIGHT_FEATURE:
        return rightFeature != null;
    }
    return super.eIsSet(featureID);
  }

} //FeatureExpressionImpl

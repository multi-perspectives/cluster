/**
 */
package org.feature.model.constraint.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.feature.model.constraint.Constraint;
import org.feature.model.constraint.ConstraintPackage;

import org.feature.model.constraint.FeatureExpression;
import org.featuremapper.models.feature.Feature;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Constraint</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.feature.model.constraint.impl.ConstraintImpl#getExpression <em>Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConstraintImpl extends EObjectImpl implements Constraint {
   /**
   * The cached value of the '{@link #getExpression() <em>Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExpression()
   * @generated
   * @ordered
   */
  protected FeatureExpression expression;

  /**
   * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
   * @generated
   */
   protected ConstraintImpl() {
    super();
  }

   /**
   * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
   * @generated
   */
   @Override
   protected EClass eStaticClass() {
    return ConstraintPackage.Literals.CONSTRAINT;
  }

   /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FeatureExpression getExpression()
  {
    return expression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetExpression(FeatureExpression newExpression, NotificationChain msgs)
  {
    FeatureExpression oldExpression = expression;
    expression = newExpression;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ConstraintPackage.CONSTRAINT__EXPRESSION, oldExpression, newExpression);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setExpression(FeatureExpression newExpression)
  {
    if (newExpression != expression)
    {
      NotificationChain msgs = null;
      if (expression != null)
        msgs = ((InternalEObject)expression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ConstraintPackage.CONSTRAINT__EXPRESSION, null, msgs);
      if (newExpression != null)
        msgs = ((InternalEObject)newExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ConstraintPackage.CONSTRAINT__EXPRESSION, null, msgs);
      msgs = basicSetExpression(newExpression, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ConstraintPackage.CONSTRAINT__EXPRESSION, newExpression, newExpression));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case ConstraintPackage.CONSTRAINT__EXPRESSION:
        return basicSetExpression(null, msgs);
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
    switch (featureID)
    {
      case ConstraintPackage.CONSTRAINT__EXPRESSION:
        return getExpression();
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
    switch (featureID)
    {
      case ConstraintPackage.CONSTRAINT__EXPRESSION:
        setExpression((FeatureExpression)newValue);
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
    switch (featureID)
    {
      case ConstraintPackage.CONSTRAINT__EXPRESSION:
        setExpression((FeatureExpression)null);
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
    switch (featureID)
    {
      case ConstraintPackage.CONSTRAINT__EXPRESSION:
        return expression != null;
    }
    return super.eIsSet(featureID);
  }

} //ConstraintImpl

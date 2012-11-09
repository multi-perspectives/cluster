/**
 */
package org.feature.multi.perspective.classification.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.feature.multi.perspective.classification.ClassificationPackage;
import org.feature.multi.perspective.classification.ClassifiedFeature;
import org.feature.multi.perspective.classification.Classifier;

import org.featuremapper.models.feature.Feature;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Classified Feature</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.feature.multi.perspective.classification.impl.ClassifiedFeatureImpl#getFeature <em>Feature</em>}</li>
 *   <li>{@link org.feature.multi.perspective.classification.impl.ClassifiedFeatureImpl#getClassified <em>Classified</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ClassifiedFeatureImpl extends EObjectImpl implements ClassifiedFeature {
   /**
   * The cached value of the '{@link #getFeature() <em>Feature</em>}' reference.
   * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
   * @see #getFeature()
   * @generated
   * @ordered
   */
   protected Feature feature;

   /**
   * The default value of the '{@link #getClassified() <em>Classified</em>}' attribute.
   * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
   * @see #getClassified()
   * @generated
   * @ordered
   */
   protected static final Classifier CLASSIFIED_EDEFAULT = Classifier.UNCLASSIFIED;

   /**
   * The cached value of the '{@link #getClassified() <em>Classified</em>}' attribute.
   * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
   * @see #getClassified()
   * @generated
   * @ordered
   */
   protected Classifier classified = CLASSIFIED_EDEFAULT;

   /**
   * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
   * @generated
   */
   protected ClassifiedFeatureImpl() {
    super();
  }

   /**
   * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
   * @generated
   */
   @Override
   protected EClass eStaticClass() {
    return ClassificationPackage.Literals.CLASSIFIED_FEATURE;
  }

   /**
   * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
   * @generated
   */
   public Feature getFeature() {
    if (feature != null && feature.eIsProxy())
    {
      InternalEObject oldFeature = (InternalEObject)feature;
      feature = (Feature)eResolveProxy(oldFeature);
      if (feature != oldFeature)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ClassificationPackage.CLASSIFIED_FEATURE__FEATURE, oldFeature, feature));
      }
    }
    return feature;
  }

   /**
   * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
   * @generated
   */
   public Feature basicGetFeature() {
    return feature;
  }

   /**
   * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
   * @generated
   */
   public void setFeature(Feature newFeature) {
    Feature oldFeature = feature;
    feature = newFeature;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ClassificationPackage.CLASSIFIED_FEATURE__FEATURE, oldFeature, feature));
  }

   /**
   * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
   * @generated
   */
   public Classifier getClassified() {
    return classified;
  }

   /**
   * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
   * @generated
   */
   public void setClassified(Classifier newClassified) {
    Classifier oldClassified = classified;
    classified = newClassified == null ? CLASSIFIED_EDEFAULT : newClassified;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ClassificationPackage.CLASSIFIED_FEATURE__CLASSIFIED, oldClassified, classified));
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
      case ClassificationPackage.CLASSIFIED_FEATURE__FEATURE:
        if (resolve) return getFeature();
        return basicGetFeature();
      case ClassificationPackage.CLASSIFIED_FEATURE__CLASSIFIED:
        return getClassified();
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
      case ClassificationPackage.CLASSIFIED_FEATURE__FEATURE:
        setFeature((Feature)newValue);
        return;
      case ClassificationPackage.CLASSIFIED_FEATURE__CLASSIFIED:
        setClassified((Classifier)newValue);
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
      case ClassificationPackage.CLASSIFIED_FEATURE__FEATURE:
        setFeature((Feature)null);
        return;
      case ClassificationPackage.CLASSIFIED_FEATURE__CLASSIFIED:
        setClassified(CLASSIFIED_EDEFAULT);
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
      case ClassificationPackage.CLASSIFIED_FEATURE__FEATURE:
        return feature != null;
      case ClassificationPackage.CLASSIFIED_FEATURE__CLASSIFIED:
        return classified != CLASSIFIED_EDEFAULT;
    }
    return super.eIsSet(featureID);
  }

   /**
   * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
   * @generated
   */
   @Override
   public String toString() {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (classified: ");
    result.append(classified);
    result.append(')');
    return result.toString();
  }

} //ClassifiedFeatureImpl

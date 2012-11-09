/**
 */
package org.feature.multi.perspective.classification.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.feature.multi.perspective.classification.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ClassificationFactoryImpl extends EFactoryImpl implements ClassificationFactory {
   /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
   * @generated
   */
   public static ClassificationFactory init() {
    try
    {
      ClassificationFactory theClassificationFactory = (ClassificationFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.conper.de/classification"); 
      if (theClassificationFactory != null)
      {
        return theClassificationFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new ClassificationFactoryImpl();
  }

   /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
   * @generated
   */
   public ClassificationFactoryImpl() {
    super();
  }

   /**
   * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
   * @generated
   */
   @Override
   public EObject create(EClass eClass) {
    switch (eClass.getClassifierID())
    {
      case ClassificationPackage.CLASSIFICATION_MODEL: return createClassificationModel();
      case ClassificationPackage.CLASSIFICATION: return createClassification();
      case ClassificationPackage.CLASSIFIED_FEATURE: return createClassifiedFeature();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

   /**
   * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
   * @generated
   */
   @Override
   public Object createFromString(EDataType eDataType, String initialValue) {
    switch (eDataType.getClassifierID())
    {
      case ClassificationPackage.CLASSIFIER:
        return createClassifierFromString(eDataType, initialValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

   /**
   * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
   * @generated
   */
   @Override
   public String convertToString(EDataType eDataType, Object instanceValue) {
    switch (eDataType.getClassifierID())
    {
      case ClassificationPackage.CLASSIFIER:
        return convertClassifierToString(eDataType, instanceValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

   /**
   * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
   * @generated
   */
   public ClassificationModel createClassificationModel() {
    ClassificationModelImpl classificationModel = new ClassificationModelImpl();
    return classificationModel;
  }

   /**
   * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
   * @generated
   */
   public Classification createClassification() {
    ClassificationImpl classification = new ClassificationImpl();
    return classification;
  }

   /**
   * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
   * @generated
   */
   public ClassifiedFeature createClassifiedFeature() {
    ClassifiedFeatureImpl classifiedFeature = new ClassifiedFeatureImpl();
    return classifiedFeature;
  }

   /**
   * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
   * @generated
   */
   public Classifier createClassifierFromString(EDataType eDataType, String initialValue) {
    Classifier result = Classifier.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

   /**
   * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
   * @generated
   */
   public String convertClassifierToString(EDataType eDataType, Object instanceValue) {
    return instanceValue == null ? null : instanceValue.toString();
  }

   /**
   * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
   * @generated
   */
   public ClassificationPackage getClassificationPackage() {
    return (ClassificationPackage)getEPackage();
  }

   /**
   * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
   @Deprecated
   public static ClassificationPackage getPackage() {
    return ClassificationPackage.eINSTANCE;
  }

} //ClassificationFactoryImpl

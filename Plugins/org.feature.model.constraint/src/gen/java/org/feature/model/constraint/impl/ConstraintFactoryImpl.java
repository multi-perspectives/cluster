/**
 */
package org.feature.model.constraint.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.feature.model.constraint.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ConstraintFactoryImpl extends EFactoryImpl implements ConstraintFactory {
   /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
   * @generated
   */
   public static ConstraintFactory init() {
    try
    {
      ConstraintFactory theConstraintFactory = (ConstraintFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.conper.de/constraint"); 
      if (theConstraintFactory != null)
      {
        return theConstraintFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new ConstraintFactoryImpl();
  }

   /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
   * @generated
   */
   public ConstraintFactoryImpl() {
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
      case ConstraintPackage.CONSTRAINT: return createConstraint();
      case ConstraintPackage.REQUIRE: return createRequire();
      case ConstraintPackage.EXCLUDE: return createExclude();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

   /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Constraint createConstraint()
  {
    ConstraintImpl constraint = new ConstraintImpl();
    return constraint;
  }

  /**
   * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
   * @generated
   */
   public Require createRequire() {
    RequireImpl require = new RequireImpl();
    return require;
  }

   /**
   * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
   * @generated
   */
   public Exclude createExclude() {
    ExcludeImpl exclude = new ExcludeImpl();
    return exclude;
  }

   /**
   * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
   * @generated
   */
   public ConstraintPackage getConstraintPackage() {
    return (ConstraintPackage)getEPackage();
  }

   /**
   * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
   @Deprecated
   public static ConstraintPackage getPackage() {
    return ConstraintPackage.eINSTANCE;
  }

} //ConstraintFactoryImpl

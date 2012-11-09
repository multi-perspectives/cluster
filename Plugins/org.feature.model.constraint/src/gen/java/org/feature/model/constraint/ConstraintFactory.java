/**
 */
package org.feature.model.constraint;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.feature.model.constraint.ConstraintPackage
 * @generated
 */
public interface ConstraintFactory extends EFactory {
   /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
   * @generated
   */
   ConstraintFactory eINSTANCE = org.feature.model.constraint.impl.ConstraintFactoryImpl.init();

   /**
   * Returns a new object of class '<em>Constraint</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Constraint</em>'.
   * @generated
   */
  Constraint createConstraint();

  /**
   * Returns a new object of class '<em>Require</em>'.
   * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
   * @return a new object of class '<em>Require</em>'.
   * @generated
   */
   Require createRequire();

   /**
   * Returns a new object of class '<em>Exclude</em>'.
   * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
   * @return a new object of class '<em>Exclude</em>'.
   * @generated
   */
   Exclude createExclude();

   /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
   ConstraintPackage getConstraintPackage();

} //ConstraintFactory

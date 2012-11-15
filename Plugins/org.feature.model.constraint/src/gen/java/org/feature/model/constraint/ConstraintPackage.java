/**
 */
package org.feature.model.constraint;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.feature.model.constraint.ConstraintFactory
 * @model kind="package"
 * @generated
 */
public interface ConstraintPackage extends EPackage {
   /**
   * The package name.
   * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
   * @generated
   */
   String eNAME = "constraint";

   /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
   * @generated
   */
   String eNS_URI = "http://www.conper.de/constraint";

   /**
   * The package namespace name.
   * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
   * @generated
   */
   String eNS_PREFIX = "constraint";

   /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
   * @generated
   */
   ConstraintPackage eINSTANCE = org.feature.model.constraint.impl.ConstraintPackageImpl.init();

   /**
   * The meta object id for the '{@link org.feature.model.constraint.impl.ConstraintImpl <em>Constraint</em>}' class.
   * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
   * @see org.feature.model.constraint.impl.ConstraintImpl
   * @see org.feature.model.constraint.impl.ConstraintPackageImpl#getConstraint()
   * @generated
   */
   int CONSTRAINT = 0;

   /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTRAINT__EXPRESSION = 0;

  /**
   * The number of structural features of the '<em>Constraint</em>' class.
   * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
   int CONSTRAINT_FEATURE_COUNT = 1;

   /**
   * The meta object id for the '{@link org.feature.model.constraint.impl.FeatureExpressionImpl <em>Feature Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.feature.model.constraint.impl.FeatureExpressionImpl
   * @see org.feature.model.constraint.impl.ConstraintPackageImpl#getFeatureExpression()
   * @generated
   */
  int FEATURE_EXPRESSION = 1;

  /**
   * The feature id for the '<em><b>Left Feature</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FEATURE_EXPRESSION__LEFT_FEATURE = 0;

  /**
   * The feature id for the '<em><b>Right Feature</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FEATURE_EXPRESSION__RIGHT_FEATURE = 1;

  /**
   * The number of structural features of the '<em>Feature Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FEATURE_EXPRESSION_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.feature.model.constraint.impl.RequireImpl <em>Require</em>}' class.
   * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
   * @see org.feature.model.constraint.impl.RequireImpl
   * @see org.feature.model.constraint.impl.ConstraintPackageImpl#getRequire()
   * @generated
   */
   int REQUIRE = 2;

   /**
   * The feature id for the '<em><b>Left Feature</b></em>' reference.
   * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
   int REQUIRE__LEFT_FEATURE = FEATURE_EXPRESSION__LEFT_FEATURE;

   /**
   * The feature id for the '<em><b>Right Feature</b></em>' reference.
   * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
   int REQUIRE__RIGHT_FEATURE = FEATURE_EXPRESSION__RIGHT_FEATURE;

   /**
   * The number of structural features of the '<em>Require</em>' class.
   * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
   int REQUIRE_FEATURE_COUNT = FEATURE_EXPRESSION_FEATURE_COUNT + 0;

   /**
   * The meta object id for the '{@link org.feature.model.constraint.impl.ExcludeImpl <em>Exclude</em>}' class.
   * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
   * @see org.feature.model.constraint.impl.ExcludeImpl
   * @see org.feature.model.constraint.impl.ConstraintPackageImpl#getExclude()
   * @generated
   */
   int EXCLUDE = 3;

   /**
   * The feature id for the '<em><b>Left Feature</b></em>' reference.
   * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
   int EXCLUDE__LEFT_FEATURE = FEATURE_EXPRESSION__LEFT_FEATURE;

   /**
   * The feature id for the '<em><b>Right Feature</b></em>' reference.
   * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
   int EXCLUDE__RIGHT_FEATURE = FEATURE_EXPRESSION__RIGHT_FEATURE;

   /**
   * The number of structural features of the '<em>Exclude</em>' class.
   * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
   int EXCLUDE_FEATURE_COUNT = FEATURE_EXPRESSION_FEATURE_COUNT + 0;


   /**
   * Returns the meta object for class '{@link org.feature.model.constraint.Constraint <em>Constraint</em>}'.
   * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
   * @return the meta object for class '<em>Constraint</em>'.
   * @see org.feature.model.constraint.Constraint
   * @generated
   */
   EClass getConstraint();

   /**
   * Returns the meta object for the containment reference '{@link org.feature.model.constraint.Constraint#getExpression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expression</em>'.
   * @see org.feature.model.constraint.Constraint#getExpression()
   * @see #getConstraint()
   * @generated
   */
  EReference getConstraint_Expression();

  /**
   * Returns the meta object for class '{@link org.feature.model.constraint.FeatureExpression <em>Feature Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Feature Expression</em>'.
   * @see org.feature.model.constraint.FeatureExpression
   * @generated
   */
  EClass getFeatureExpression();

  /**
   * Returns the meta object for the reference '{@link org.feature.model.constraint.FeatureExpression#getLeftFeature <em>Left Feature</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Left Feature</em>'.
   * @see org.feature.model.constraint.FeatureExpression#getLeftFeature()
   * @see #getFeatureExpression()
   * @generated
   */
  EReference getFeatureExpression_LeftFeature();

  /**
   * Returns the meta object for the reference '{@link org.feature.model.constraint.FeatureExpression#getRightFeature <em>Right Feature</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Right Feature</em>'.
   * @see org.feature.model.constraint.FeatureExpression#getRightFeature()
   * @see #getFeatureExpression()
   * @generated
   */
  EReference getFeatureExpression_RightFeature();

  /**
   * Returns the meta object for class '{@link org.feature.model.constraint.Require <em>Require</em>}'.
   * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
   * @return the meta object for class '<em>Require</em>'.
   * @see org.feature.model.constraint.Require
   * @generated
   */
   EClass getRequire();

   /**
   * Returns the meta object for class '{@link org.feature.model.constraint.Exclude <em>Exclude</em>}'.
   * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
   * @return the meta object for class '<em>Exclude</em>'.
   * @see org.feature.model.constraint.Exclude
   * @generated
   */
   EClass getExclude();

   /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
   ConstraintFactory getConstraintFactory();

   /**
   * <!-- begin-user-doc -->
    * Defines literals for the meta objects that represent
    * <ul>
    *   <li>each class,</li>
    *   <li>each feature of each class,</li>
    *   <li>each enum,</li>
    *   <li>and each data type</li>
    * </ul>
    * <!-- end-user-doc -->
   * @generated
   */
   interface Literals {
      /**
     * The meta object literal for the '{@link org.feature.model.constraint.impl.ConstraintImpl <em>Constraint</em>}' class.
     * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
     * @see org.feature.model.constraint.impl.ConstraintImpl
     * @see org.feature.model.constraint.impl.ConstraintPackageImpl#getConstraint()
     * @generated
     */
      EClass CONSTRAINT = eINSTANCE.getConstraint();

      /**
     * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONSTRAINT__EXPRESSION = eINSTANCE.getConstraint_Expression();

      /**
     * The meta object literal for the '{@link org.feature.model.constraint.impl.FeatureExpressionImpl <em>Feature Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.feature.model.constraint.impl.FeatureExpressionImpl
     * @see org.feature.model.constraint.impl.ConstraintPackageImpl#getFeatureExpression()
     * @generated
     */
    EClass FEATURE_EXPRESSION = eINSTANCE.getFeatureExpression();

      /**
     * The meta object literal for the '<em><b>Left Feature</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FEATURE_EXPRESSION__LEFT_FEATURE = eINSTANCE.getFeatureExpression_LeftFeature();

      /**
     * The meta object literal for the '<em><b>Right Feature</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FEATURE_EXPRESSION__RIGHT_FEATURE = eINSTANCE.getFeatureExpression_RightFeature();

      /**
     * The meta object literal for the '{@link org.feature.model.constraint.impl.RequireImpl <em>Require</em>}' class.
     * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
     * @see org.feature.model.constraint.impl.RequireImpl
     * @see org.feature.model.constraint.impl.ConstraintPackageImpl#getRequire()
     * @generated
     */
      EClass REQUIRE = eINSTANCE.getRequire();

      /**
     * The meta object literal for the '{@link org.feature.model.constraint.impl.ExcludeImpl <em>Exclude</em>}' class.
     * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
     * @see org.feature.model.constraint.impl.ExcludeImpl
     * @see org.feature.model.constraint.impl.ConstraintPackageImpl#getExclude()
     * @generated
     */
      EClass EXCLUDE = eINSTANCE.getExclude();

   }

} //ConstraintPackage

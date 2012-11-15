/**
 */
package org.feature.model.constraint;

import org.eclipse.emf.ecore.EObject;

import org.featuremapper.models.feature.Feature;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Feature Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.feature.model.constraint.FeatureExpression#getLeftFeature <em>Left Feature</em>}</li>
 *   <li>{@link org.feature.model.constraint.FeatureExpression#getRightFeature <em>Right Feature</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.feature.model.constraint.ConstraintPackage#getFeatureExpression()
 * @model abstract="true"
 * @generated
 */
public interface FeatureExpression extends EObject
{
  /**
   * Returns the value of the '<em><b>Left Feature</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Left Feature</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Left Feature</em>' reference.
   * @see #setLeftFeature(Feature)
   * @see org.feature.model.constraint.ConstraintPackage#getFeatureExpression_LeftFeature()
   * @model required="true"
   * @generated
   */
  Feature getLeftFeature();

  /**
   * Sets the value of the '{@link org.feature.model.constraint.FeatureExpression#getLeftFeature <em>Left Feature</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Left Feature</em>' reference.
   * @see #getLeftFeature()
   * @generated
   */
  void setLeftFeature(Feature value);

  /**
   * Returns the value of the '<em><b>Right Feature</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Right Feature</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Right Feature</em>' reference.
   * @see #setRightFeature(Feature)
   * @see org.feature.model.constraint.ConstraintPackage#getFeatureExpression_RightFeature()
   * @model required="true"
   * @generated
   */
  Feature getRightFeature();

  /**
   * Sets the value of the '{@link org.feature.model.constraint.FeatureExpression#getRightFeature <em>Right Feature</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Right Feature</em>' reference.
   * @see #getRightFeature()
   * @generated
   */
  void setRightFeature(Feature value);

} // FeatureExpression

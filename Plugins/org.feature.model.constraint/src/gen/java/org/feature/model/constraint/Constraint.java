/**
 */
package org.feature.model.constraint;

import org.eclipse.emf.ecore.EObject;

import org.featuremapper.models.feature.Feature;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.feature.model.constraint.Constraint#getExpression <em>Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.feature.model.constraint.ConstraintPackage#getConstraint()
 * @model
 * @generated
 */
public interface Constraint extends EObject {
   /**
   * Returns the value of the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Expression</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Expression</em>' containment reference.
   * @see #setExpression(FeatureExpression)
   * @see org.feature.model.constraint.ConstraintPackage#getConstraint_Expression()
   * @model containment="true" required="true"
   * @generated
   */
  FeatureExpression getExpression();

  /**
   * Sets the value of the '{@link org.feature.model.constraint.Constraint#getExpression <em>Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Expression</em>' containment reference.
   * @see #getExpression()
   * @generated
   */
  void setExpression(FeatureExpression value);

} // Constraint

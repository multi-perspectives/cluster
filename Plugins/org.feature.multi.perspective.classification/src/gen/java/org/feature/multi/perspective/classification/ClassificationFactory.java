/**
 */
package org.feature.multi.perspective.classification;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.feature.multi.perspective.classification.ClassificationPackage
 * @generated
 */
public interface ClassificationFactory extends EFactory {
   /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
   * @generated
   */
   ClassificationFactory eINSTANCE = org.feature.multi.perspective.classification.impl.ClassificationFactoryImpl.init();

   /**
   * Returns a new object of class '<em>Model</em>'.
   * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
   * @return a new object of class '<em>Model</em>'.
   * @generated
   */
   ClassificationModel createClassificationModel();

   /**
   * Returns a new object of class '<em>Classification</em>'.
   * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
   * @return a new object of class '<em>Classification</em>'.
   * @generated
   */
   Classification createClassification();

   /**
   * Returns a new object of class '<em>Classified Feature</em>'.
   * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
   * @return a new object of class '<em>Classified Feature</em>'.
   * @generated
   */
   ClassifiedFeature createClassifiedFeature();

   /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
   ClassificationPackage getClassificationPackage();

} //ClassificationFactory

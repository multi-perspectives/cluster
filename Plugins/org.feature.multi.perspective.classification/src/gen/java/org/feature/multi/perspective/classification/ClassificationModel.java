/**
 */
package org.feature.multi.perspective.classification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.feature.multi.perspective.mapping.viewmapping.MappingModel;

import org.featuremapper.models.feature.FeatureModel;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.feature.multi.perspective.classification.ClassificationModel#getFeatureModel <em>Feature Model</em>}</li>
 *   <li>{@link org.feature.multi.perspective.classification.ClassificationModel#getClassifications <em>Classifications</em>}</li>
 *   <li>{@link org.feature.multi.perspective.classification.ClassificationModel#getViewMapping <em>View Mapping</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.feature.multi.perspective.classification.ClassificationPackage#getClassificationModel()
 * @model
 * @generated
 */
public interface ClassificationModel extends EObject {
   /**
	 * Returns the value of the '<em><b>Feature Model</b></em>' reference.
	 * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Feature Model</em>' reference isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
	 * @return the value of the '<em>Feature Model</em>' reference.
	 * @see #setFeatureModel(FeatureModel)
	 * @see org.feature.multi.perspective.classification.ClassificationPackage#getClassificationModel_FeatureModel()
	 * @model
	 * @generated
	 */
   FeatureModel getFeatureModel();

   /**
	 * Sets the value of the '{@link org.feature.multi.perspective.classification.ClassificationModel#getFeatureModel <em>Feature Model</em>}' reference.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Feature Model</em>' reference.
	 * @see #getFeatureModel()
	 * @generated
	 */
   void setFeatureModel(FeatureModel value);

   /**
	 * Returns the value of the '<em><b>Classifications</b></em>' containment reference list.
	 * The list contents are of type {@link org.feature.multi.perspective.classification.Classification}.
	 * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Classifications</em>' containment reference list isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
	 * @return the value of the '<em>Classifications</em>' containment reference list.
	 * @see org.feature.multi.perspective.classification.ClassificationPackage#getClassificationModel_Classifications()
	 * @model containment="true"
	 * @generated
	 */
   EList<Classification> getClassifications();

   /**
	 * Returns the value of the '<em><b>View Mapping</b></em>' reference.
	 * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>View Mapping</em>' reference isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
	 * @return the value of the '<em>View Mapping</em>' reference.
	 * @see #setViewMapping(MappingModel)
	 * @see org.feature.multi.perspective.classification.ClassificationPackage#getClassificationModel_ViewMapping()
	 * @model
	 * @generated
	 */
   MappingModel getViewMapping();

   /**
	 * Sets the value of the '{@link org.feature.multi.perspective.classification.ClassificationModel#getViewMapping <em>View Mapping</em>}' reference.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @param value the new value of the '<em>View Mapping</em>' reference.
	 * @see #getViewMapping()
	 * @generated
	 */
   void setViewMapping(MappingModel value);

} // ClassificationModel

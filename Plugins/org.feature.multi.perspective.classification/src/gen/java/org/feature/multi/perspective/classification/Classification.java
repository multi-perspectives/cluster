/**
 */
package org.feature.multi.perspective.classification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.feature.multi.perspective.model.viewmodel.AbstractGroup;

import org.featuremapper.models.feature.Feature;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Classification</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.feature.multi.perspective.classification.Classification#getViewgroups <em>Viewgroups</em>}</li>
 *   <li>{@link org.feature.multi.perspective.classification.Classification#getClassifiedFeatures <em>Classified Features</em>}</li>
 *   <li>{@link org.feature.multi.perspective.classification.Classification#getAutoCompleteFeatures <em>Auto Complete Features</em>}</li>
 *   <li>{@link org.feature.multi.perspective.classification.Classification#getUnboundFeatures <em>Unbound Features</em>}</li>
 *   <li>{@link org.feature.multi.perspective.classification.Classification#getAliveFeatures <em>Alive Features</em>}</li>
 *   <li>{@link org.feature.multi.perspective.classification.Classification#getDeadFeatures <em>Dead Features</em>}</li>
 *   <li>{@link org.feature.multi.perspective.classification.Classification#getId <em>Id</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.feature.multi.perspective.classification.ClassificationPackage#getClassification()
 * @model
 * @generated
 */
public interface Classification extends EObject {
   /**
	 * Returns the value of the '<em><b>Viewgroups</b></em>' reference list.
	 * The list contents are of type {@link org.feature.multi.perspective.model.viewmodel.AbstractGroup}.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Viewgroups</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Viewgroups</em>' reference list.
	 * @see org.feature.multi.perspective.classification.ClassificationPackage#getClassification_Viewgroups()
	 * @model
	 * @generated
	 */
  EList<AbstractGroup> getViewgroups();

  /**
	 * Returns the value of the '<em><b>Classified Features</b></em>' containment reference list.
	 * The list contents are of type {@link org.feature.multi.perspective.classification.ClassifiedFeature}.
	 * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Classified Features</em>' containment reference list isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
	 * @return the value of the '<em>Classified Features</em>' containment reference list.
	 * @see org.feature.multi.perspective.classification.ClassificationPackage#getClassification_ClassifiedFeatures()
	 * @model containment="true"
	 * @generated
	 */
   EList<ClassifiedFeature> getClassifiedFeatures();

   /**
	 * Returns the value of the '<em><b>Auto Complete Features</b></em>' containment reference list.
	 * The list contents are of type {@link org.feature.multi.perspective.classification.ClassifiedFeature}.
	 * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Auto Complete Features</em>' containment reference list isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
	 * @return the value of the '<em>Auto Complete Features</em>' containment reference list.
	 * @see org.feature.multi.perspective.classification.ClassificationPackage#getClassification_AutoCompleteFeatures()
	 * @model containment="true"
	 * @generated
	 */
   EList<ClassifiedFeature> getAutoCompleteFeatures();

   /**
	 * Returns the value of the '<em><b>Unbound Features</b></em>' reference list.
	 * The list contents are of type {@link org.featuremapper.models.feature.Feature}.
	 * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Unbound Features</em>' reference list isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
	 * @return the value of the '<em>Unbound Features</em>' reference list.
	 * @see org.feature.multi.perspective.classification.ClassificationPackage#getClassification_UnboundFeatures()
	 * @model
	 * @generated
	 */
   EList<Feature> getUnboundFeatures();

   /**
	 * Returns the value of the '<em><b>Alive Features</b></em>' reference list.
	 * The list contents are of type {@link org.featuremapper.models.feature.Feature}.
	 * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Alive Features</em>' reference list isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
	 * @return the value of the '<em>Alive Features</em>' reference list.
	 * @see org.feature.multi.perspective.classification.ClassificationPackage#getClassification_AliveFeatures()
	 * @model
	 * @generated
	 */
   EList<Feature> getAliveFeatures();

   /**
	 * Returns the value of the '<em><b>Dead Features</b></em>' reference list.
	 * The list contents are of type {@link org.featuremapper.models.feature.Feature}.
	 * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Dead Features</em>' reference list isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
	 * @return the value of the '<em>Dead Features</em>' reference list.
	 * @see org.feature.multi.perspective.classification.ClassificationPackage#getClassification_DeadFeatures()
	 * @model
	 * @generated
	 */
   EList<Feature> getDeadFeatures();

   /**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Id</em>' attribute isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see org.feature.multi.perspective.classification.ClassificationPackage#getClassification_Id()
	 * @model id="true" required="true"
	 * @generated
	 */
   String getId();

   /**
	 * Sets the value of the '{@link org.feature.multi.perspective.classification.Classification#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
   void setId(String value);

} // Classification

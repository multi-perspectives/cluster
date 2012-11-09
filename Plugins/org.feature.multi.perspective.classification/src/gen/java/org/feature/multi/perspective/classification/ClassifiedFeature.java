/**
 */
package org.feature.multi.perspective.classification;

import org.eclipse.emf.ecore.EObject;

import org.featuremapper.models.feature.Feature;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Classified Feature</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.feature.multi.perspective.classification.ClassifiedFeature#getFeature <em>Feature</em>}</li>
 *   <li>{@link org.feature.multi.perspective.classification.ClassifiedFeature#getClassified <em>Classified</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.feature.multi.perspective.classification.ClassificationPackage#getClassifiedFeature()
 * @model
 * @generated
 */
public interface ClassifiedFeature extends EObject {
   /**
	 * Returns the value of the '<em><b>Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Feature</em>' reference isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
	 * @return the value of the '<em>Feature</em>' reference.
	 * @see #setFeature(Feature)
	 * @see org.feature.multi.perspective.classification.ClassificationPackage#getClassifiedFeature_Feature()
	 * @model required="true"
	 * @generated
	 */
   Feature getFeature();

   /**
	 * Sets the value of the '{@link org.feature.multi.perspective.classification.ClassifiedFeature#getFeature <em>Feature</em>}' reference.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Feature</em>' reference.
	 * @see #getFeature()
	 * @generated
	 */
   void setFeature(Feature value);

   /**
	 * Returns the value of the '<em><b>Classified</b></em>' attribute.
	 * The default value is <code>"Unclassified"</code>.
	 * The literals are from the enumeration {@link org.feature.multi.perspective.classification.Classifier}.
	 * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Classified</em>' attribute isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
	 * @return the value of the '<em>Classified</em>' attribute.
	 * @see org.feature.multi.perspective.classification.Classifier
	 * @see #setClassified(Classifier)
	 * @see org.feature.multi.perspective.classification.ClassificationPackage#getClassifiedFeature_Classified()
	 * @model default="Unclassified" required="true"
	 * @generated
	 */
   Classifier getClassified();

   /**
	 * Sets the value of the '{@link org.feature.multi.perspective.classification.ClassifiedFeature#getClassified <em>Classified</em>}' attribute.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Classified</em>' attribute.
	 * @see org.feature.multi.perspective.classification.Classifier
	 * @see #getClassified()
	 * @generated
	 */
   void setClassified(Classifier value);

} // ClassifiedFeature

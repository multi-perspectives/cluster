/**
 */
package org.feature.multi.perspective.classification;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
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
 * @see org.feature.multi.perspective.classification.ClassificationFactory
 * @model kind="package"
 * @generated
 */
public interface ClassificationPackage extends EPackage {
   /**
   * The package name.
   * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
   * @generated
   */
   String eNAME = "classification";

   /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
   * @generated
   */
   String eNS_URI = "http://www.conper.de/classification";

   /**
   * The package namespace name.
   * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
   * @generated
   */
   String eNS_PREFIX = "classification";

   /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
   * @generated
   */
   ClassificationPackage eINSTANCE = org.feature.multi.perspective.classification.impl.ClassificationPackageImpl.init();

   /**
   * The meta object id for the '{@link org.feature.multi.perspective.classification.impl.ClassificationModelImpl <em>Model</em>}' class.
   * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
   * @see org.feature.multi.perspective.classification.impl.ClassificationModelImpl
   * @see org.feature.multi.perspective.classification.impl.ClassificationPackageImpl#getClassificationModel()
   * @generated
   */
   int CLASSIFICATION_MODEL = 0;

   /**
   * The feature id for the '<em><b>Feature Model</b></em>' reference.
   * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
   int CLASSIFICATION_MODEL__FEATURE_MODEL = 0;

   /**
   * The feature id for the '<em><b>Classifications</b></em>' containment reference list.
   * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
   int CLASSIFICATION_MODEL__CLASSIFICATIONS = 1;

   /**
   * The feature id for the '<em><b>View Mapping</b></em>' reference.
   * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
   int CLASSIFICATION_MODEL__VIEW_MAPPING = 2;

   /**
   * The number of structural features of the '<em>Model</em>' class.
   * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
   int CLASSIFICATION_MODEL_FEATURE_COUNT = 3;

   /**
   * The meta object id for the '{@link org.feature.multi.perspective.classification.impl.ClassificationImpl <em>Classification</em>}' class.
   * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
   * @see org.feature.multi.perspective.classification.impl.ClassificationImpl
   * @see org.feature.multi.perspective.classification.impl.ClassificationPackageImpl#getClassification()
   * @generated
   */
   int CLASSIFICATION = 1;

   /**
   * The feature id for the '<em><b>Viewgroups</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASSIFICATION__VIEWGROUPS = 0;

  /**
   * The feature id for the '<em><b>Classified Features</b></em>' containment reference list.
   * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
   int CLASSIFICATION__CLASSIFIED_FEATURES = 1;

   /**
   * The feature id for the '<em><b>Auto Complete Features</b></em>' containment reference list.
   * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
   int CLASSIFICATION__AUTO_COMPLETE_FEATURES = 2;

   /**
   * The feature id for the '<em><b>Unbound Features</b></em>' reference list.
   * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
   int CLASSIFICATION__UNBOUND_FEATURES = 3;

   /**
   * The feature id for the '<em><b>Alive Features</b></em>' reference list.
   * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
   int CLASSIFICATION__ALIVE_FEATURES = 4;

   /**
   * The feature id for the '<em><b>Dead Features</b></em>' reference list.
   * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
   int CLASSIFICATION__DEAD_FEATURES = 5;

   /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
   int CLASSIFICATION__ID = 6;

   /**
   * The number of structural features of the '<em>Classification</em>' class.
   * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
   int CLASSIFICATION_FEATURE_COUNT = 7;

   /**
   * The meta object id for the '{@link org.feature.multi.perspective.classification.impl.ClassifiedFeatureImpl <em>Classified Feature</em>}' class.
   * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
   * @see org.feature.multi.perspective.classification.impl.ClassifiedFeatureImpl
   * @see org.feature.multi.perspective.classification.impl.ClassificationPackageImpl#getClassifiedFeature()
   * @generated
   */
   int CLASSIFIED_FEATURE = 2;

   /**
   * The feature id for the '<em><b>Feature</b></em>' reference.
   * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
   int CLASSIFIED_FEATURE__FEATURE = 0;

   /**
   * The feature id for the '<em><b>Classified</b></em>' attribute.
   * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
   int CLASSIFIED_FEATURE__CLASSIFIED = 1;

   /**
   * The number of structural features of the '<em>Classified Feature</em>' class.
   * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
   int CLASSIFIED_FEATURE_FEATURE_COUNT = 2;

   /**
   * The meta object id for the '{@link org.feature.multi.perspective.classification.Classifier <em>Classifier</em>}' enum.
   * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
   * @see org.feature.multi.perspective.classification.Classifier
   * @see org.feature.multi.perspective.classification.impl.ClassificationPackageImpl#getClassifier()
   * @generated
   */
   int CLASSIFIER = 3;


   /**
   * Returns the meta object for class '{@link org.feature.multi.perspective.classification.ClassificationModel <em>Model</em>}'.
   * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
   * @return the meta object for class '<em>Model</em>'.
   * @see org.feature.multi.perspective.classification.ClassificationModel
   * @generated
   */
   EClass getClassificationModel();

   /**
   * Returns the meta object for the reference '{@link org.feature.multi.perspective.classification.ClassificationModel#getFeatureModel <em>Feature Model</em>}'.
   * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Feature Model</em>'.
   * @see org.feature.multi.perspective.classification.ClassificationModel#getFeatureModel()
   * @see #getClassificationModel()
   * @generated
   */
   EReference getClassificationModel_FeatureModel();

   /**
   * Returns the meta object for the containment reference list '{@link org.feature.multi.perspective.classification.ClassificationModel#getClassifications <em>Classifications</em>}'.
   * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Classifications</em>'.
   * @see org.feature.multi.perspective.classification.ClassificationModel#getClassifications()
   * @see #getClassificationModel()
   * @generated
   */
   EReference getClassificationModel_Classifications();

   /**
   * Returns the meta object for the reference '{@link org.feature.multi.perspective.classification.ClassificationModel#getViewMapping <em>View Mapping</em>}'.
   * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>View Mapping</em>'.
   * @see org.feature.multi.perspective.classification.ClassificationModel#getViewMapping()
   * @see #getClassificationModel()
   * @generated
   */
   EReference getClassificationModel_ViewMapping();

   /**
   * Returns the meta object for class '{@link org.feature.multi.perspective.classification.Classification <em>Classification</em>}'.
   * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
   * @return the meta object for class '<em>Classification</em>'.
   * @see org.feature.multi.perspective.classification.Classification
   * @generated
   */
   EClass getClassification();

   /**
   * Returns the meta object for the reference list '{@link org.feature.multi.perspective.classification.Classification#getViewgroups <em>Viewgroups</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Viewgroups</em>'.
   * @see org.feature.multi.perspective.classification.Classification#getViewgroups()
   * @see #getClassification()
   * @generated
   */
  EReference getClassification_Viewgroups();

  /**
   * Returns the meta object for the containment reference list '{@link org.feature.multi.perspective.classification.Classification#getClassifiedFeatures <em>Classified Features</em>}'.
   * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Classified Features</em>'.
   * @see org.feature.multi.perspective.classification.Classification#getClassifiedFeatures()
   * @see #getClassification()
   * @generated
   */
   EReference getClassification_ClassifiedFeatures();

   /**
   * Returns the meta object for the containment reference list '{@link org.feature.multi.perspective.classification.Classification#getAutoCompleteFeatures <em>Auto Complete Features</em>}'.
   * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Auto Complete Features</em>'.
   * @see org.feature.multi.perspective.classification.Classification#getAutoCompleteFeatures()
   * @see #getClassification()
   * @generated
   */
   EReference getClassification_AutoCompleteFeatures();

   /**
   * Returns the meta object for the reference list '{@link org.feature.multi.perspective.classification.Classification#getUnboundFeatures <em>Unbound Features</em>}'.
   * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Unbound Features</em>'.
   * @see org.feature.multi.perspective.classification.Classification#getUnboundFeatures()
   * @see #getClassification()
   * @generated
   */
   EReference getClassification_UnboundFeatures();

   /**
   * Returns the meta object for the reference list '{@link org.feature.multi.perspective.classification.Classification#getAliveFeatures <em>Alive Features</em>}'.
   * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Alive Features</em>'.
   * @see org.feature.multi.perspective.classification.Classification#getAliveFeatures()
   * @see #getClassification()
   * @generated
   */
   EReference getClassification_AliveFeatures();

   /**
   * Returns the meta object for the reference list '{@link org.feature.multi.perspective.classification.Classification#getDeadFeatures <em>Dead Features</em>}'.
   * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Dead Features</em>'.
   * @see org.feature.multi.perspective.classification.Classification#getDeadFeatures()
   * @see #getClassification()
   * @generated
   */
   EReference getClassification_DeadFeatures();

   /**
   * Returns the meta object for the attribute '{@link org.feature.multi.perspective.classification.Classification#getId <em>Id</em>}'.
   * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Id</em>'.
   * @see org.feature.multi.perspective.classification.Classification#getId()
   * @see #getClassification()
   * @generated
   */
   EAttribute getClassification_Id();

   /**
   * Returns the meta object for class '{@link org.feature.multi.perspective.classification.ClassifiedFeature <em>Classified Feature</em>}'.
   * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
   * @return the meta object for class '<em>Classified Feature</em>'.
   * @see org.feature.multi.perspective.classification.ClassifiedFeature
   * @generated
   */
   EClass getClassifiedFeature();

   /**
   * Returns the meta object for the reference '{@link org.feature.multi.perspective.classification.ClassifiedFeature#getFeature <em>Feature</em>}'.
   * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Feature</em>'.
   * @see org.feature.multi.perspective.classification.ClassifiedFeature#getFeature()
   * @see #getClassifiedFeature()
   * @generated
   */
   EReference getClassifiedFeature_Feature();

   /**
   * Returns the meta object for the attribute '{@link org.feature.multi.perspective.classification.ClassifiedFeature#getClassified <em>Classified</em>}'.
   * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Classified</em>'.
   * @see org.feature.multi.perspective.classification.ClassifiedFeature#getClassified()
   * @see #getClassifiedFeature()
   * @generated
   */
   EAttribute getClassifiedFeature_Classified();

   /**
   * Returns the meta object for enum '{@link org.feature.multi.perspective.classification.Classifier <em>Classifier</em>}'.
   * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Classifier</em>'.
   * @see org.feature.multi.perspective.classification.Classifier
   * @generated
   */
   EEnum getClassifier();

   /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
   ClassificationFactory getClassificationFactory();

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
     * The meta object literal for the '{@link org.feature.multi.perspective.classification.impl.ClassificationModelImpl <em>Model</em>}' class.
     * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
     * @see org.feature.multi.perspective.classification.impl.ClassificationModelImpl
     * @see org.feature.multi.perspective.classification.impl.ClassificationPackageImpl#getClassificationModel()
     * @generated
     */
      EClass CLASSIFICATION_MODEL = eINSTANCE.getClassificationModel();

      /**
     * The meta object literal for the '<em><b>Feature Model</b></em>' reference feature.
     * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
     * @generated
     */
      EReference CLASSIFICATION_MODEL__FEATURE_MODEL = eINSTANCE.getClassificationModel_FeatureModel();

      /**
     * The meta object literal for the '<em><b>Classifications</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
     * @generated
     */
      EReference CLASSIFICATION_MODEL__CLASSIFICATIONS = eINSTANCE.getClassificationModel_Classifications();

      /**
     * The meta object literal for the '<em><b>View Mapping</b></em>' reference feature.
     * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
     * @generated
     */
      EReference CLASSIFICATION_MODEL__VIEW_MAPPING = eINSTANCE.getClassificationModel_ViewMapping();

      /**
     * The meta object literal for the '{@link org.feature.multi.perspective.classification.impl.ClassificationImpl <em>Classification</em>}' class.
     * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
     * @see org.feature.multi.perspective.classification.impl.ClassificationImpl
     * @see org.feature.multi.perspective.classification.impl.ClassificationPackageImpl#getClassification()
     * @generated
     */
      EClass CLASSIFICATION = eINSTANCE.getClassification();

      /**
     * The meta object literal for the '<em><b>Viewgroups</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CLASSIFICATION__VIEWGROUPS = eINSTANCE.getClassification_Viewgroups();

      /**
     * The meta object literal for the '<em><b>Classified Features</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
     * @generated
     */
      EReference CLASSIFICATION__CLASSIFIED_FEATURES = eINSTANCE.getClassification_ClassifiedFeatures();

      /**
     * The meta object literal for the '<em><b>Auto Complete Features</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
     * @generated
     */
      EReference CLASSIFICATION__AUTO_COMPLETE_FEATURES = eINSTANCE.getClassification_AutoCompleteFeatures();

      /**
     * The meta object literal for the '<em><b>Unbound Features</b></em>' reference list feature.
     * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
     * @generated
     */
      EReference CLASSIFICATION__UNBOUND_FEATURES = eINSTANCE.getClassification_UnboundFeatures();

      /**
     * The meta object literal for the '<em><b>Alive Features</b></em>' reference list feature.
     * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
     * @generated
     */
      EReference CLASSIFICATION__ALIVE_FEATURES = eINSTANCE.getClassification_AliveFeatures();

      /**
     * The meta object literal for the '<em><b>Dead Features</b></em>' reference list feature.
     * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
     * @generated
     */
      EReference CLASSIFICATION__DEAD_FEATURES = eINSTANCE.getClassification_DeadFeatures();

      /**
     * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
     * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
     * @generated
     */
      EAttribute CLASSIFICATION__ID = eINSTANCE.getClassification_Id();

      /**
     * The meta object literal for the '{@link org.feature.multi.perspective.classification.impl.ClassifiedFeatureImpl <em>Classified Feature</em>}' class.
     * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
     * @see org.feature.multi.perspective.classification.impl.ClassifiedFeatureImpl
     * @see org.feature.multi.perspective.classification.impl.ClassificationPackageImpl#getClassifiedFeature()
     * @generated
     */
      EClass CLASSIFIED_FEATURE = eINSTANCE.getClassifiedFeature();

      /**
     * The meta object literal for the '<em><b>Feature</b></em>' reference feature.
     * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
     * @generated
     */
      EReference CLASSIFIED_FEATURE__FEATURE = eINSTANCE.getClassifiedFeature_Feature();

      /**
     * The meta object literal for the '<em><b>Classified</b></em>' attribute feature.
     * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
     * @generated
     */
      EAttribute CLASSIFIED_FEATURE__CLASSIFIED = eINSTANCE.getClassifiedFeature_Classified();

      /**
     * The meta object literal for the '{@link org.feature.multi.perspective.classification.Classifier <em>Classifier</em>}' enum.
     * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
     * @see org.feature.multi.perspective.classification.Classifier
     * @see org.feature.multi.perspective.classification.impl.ClassificationPackageImpl#getClassifier()
     * @generated
     */
      EEnum CLASSIFIER = eINSTANCE.getClassifier();

   }

} //ClassificationPackage

/**
 */
package org.feature.multi.perspective.classification.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.feature.multi.perspective.classification.Classification;
import org.feature.multi.perspective.classification.ClassificationFactory;
import org.feature.multi.perspective.classification.ClassificationModel;
import org.feature.multi.perspective.classification.ClassificationPackage;
import org.feature.multi.perspective.classification.ClassifiedFeature;
import org.feature.multi.perspective.classification.Classifier;

import org.feature.multi.perspective.mapping.viewmapping.ViewmappingPackage;

import org.feature.multi.perspective.model.viewmodel.ViewmodelPackage;

import org.featuremapper.models.feature.FeaturePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ClassificationPackageImpl extends EPackageImpl implements ClassificationPackage {
   /**
   * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
   * @generated
   */
   private EClass classificationModelEClass = null;

   /**
   * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
   * @generated
   */
   private EClass classificationEClass = null;

   /**
   * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
   * @generated
   */
   private EClass classifiedFeatureEClass = null;

   /**
   * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
   * @generated
   */
   private EEnum classifierEEnum = null;

   /**
   * Creates an instance of the model <b>Package</b>, registered with
   * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
   * package URI value.
   * <p>Note: the correct way to create the package is via the static
   * factory method {@link #init init()}, which also performs
   * initialization of the package, or returns the registered package,
   * if one already exists.
   * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
   * @see org.eclipse.emf.ecore.EPackage.Registry
   * @see org.feature.multi.perspective.classification.ClassificationPackage#eNS_URI
   * @see #init()
   * @generated
   */
   private ClassificationPackageImpl() {
    super(eNS_URI, ClassificationFactory.eINSTANCE);
  }

   /**
   * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
   * @generated
   */
   private static boolean isInited = false;

   /**
   * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
   * 
   * <p>This method is used to initialize {@link ClassificationPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
   public static ClassificationPackage init() {
    if (isInited) return (ClassificationPackage)EPackage.Registry.INSTANCE.getEPackage(ClassificationPackage.eNS_URI);

    // Obtain or create and register package
    ClassificationPackageImpl theClassificationPackage = (ClassificationPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ClassificationPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ClassificationPackageImpl());

    isInited = true;

    // Initialize simple dependencies
    ViewmappingPackage.eINSTANCE.eClass();

    // Create package meta-data objects
    theClassificationPackage.createPackageContents();

    // Initialize created meta-data
    theClassificationPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theClassificationPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(ClassificationPackage.eNS_URI, theClassificationPackage);
    return theClassificationPackage;
  }

   /**
   * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
   * @generated
   */
   public EClass getClassificationModel() {
    return classificationModelEClass;
  }

   /**
   * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
   * @generated
   */
   public EReference getClassificationModel_FeatureModel() {
    return (EReference)classificationModelEClass.getEStructuralFeatures().get(0);
  }

   /**
   * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
   * @generated
   */
   public EReference getClassificationModel_Classifications() {
    return (EReference)classificationModelEClass.getEStructuralFeatures().get(1);
  }

   /**
   * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
   * @generated
   */
   public EReference getClassificationModel_ViewMapping() {
    return (EReference)classificationModelEClass.getEStructuralFeatures().get(2);
  }

   /**
   * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
   * @generated
   */
   public EClass getClassification() {
    return classificationEClass;
  }

   /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getClassification_Viewgroups()
  {
    return (EReference)classificationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
   * @generated
   */
   public EReference getClassification_ClassifiedFeatures() {
    return (EReference)classificationEClass.getEStructuralFeatures().get(1);
  }

   /**
   * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
   * @generated
   */
   public EReference getClassification_AutoCompleteFeatures() {
    return (EReference)classificationEClass.getEStructuralFeatures().get(2);
  }

   /**
   * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
   * @generated
   */
   public EReference getClassification_UnboundFeatures() {
    return (EReference)classificationEClass.getEStructuralFeatures().get(3);
  }

   /**
   * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
   * @generated
   */
   public EReference getClassification_AliveFeatures() {
    return (EReference)classificationEClass.getEStructuralFeatures().get(4);
  }

   /**
   * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
   * @generated
   */
   public EReference getClassification_DeadFeatures() {
    return (EReference)classificationEClass.getEStructuralFeatures().get(5);
  }

   /**
   * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
   * @generated
   */
   public EAttribute getClassification_Id() {
    return (EAttribute)classificationEClass.getEStructuralFeatures().get(6);
  }

   /**
   * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
   * @generated
   */
   public EClass getClassifiedFeature() {
    return classifiedFeatureEClass;
  }

   /**
   * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
   * @generated
   */
   public EReference getClassifiedFeature_Feature() {
    return (EReference)classifiedFeatureEClass.getEStructuralFeatures().get(0);
  }

   /**
   * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
   * @generated
   */
   public EAttribute getClassifiedFeature_Classified() {
    return (EAttribute)classifiedFeatureEClass.getEStructuralFeatures().get(1);
  }

   /**
   * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
   * @generated
   */
   public EEnum getClassifier() {
    return classifierEEnum;
  }

   /**
   * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
   * @generated
   */
   public ClassificationFactory getClassificationFactory() {
    return (ClassificationFactory)getEFactoryInstance();
  }

   /**
   * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
   * @generated
   */
   private boolean isCreated = false;

   /**
   * Creates the meta-model objects for the package.  This method is
   * guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
   * @generated
   */
   public void createPackageContents() {
    if (isCreated) return;
    isCreated = true;

    // Create classes and their features
    classificationModelEClass = createEClass(CLASSIFICATION_MODEL);
    createEReference(classificationModelEClass, CLASSIFICATION_MODEL__FEATURE_MODEL);
    createEReference(classificationModelEClass, CLASSIFICATION_MODEL__CLASSIFICATIONS);
    createEReference(classificationModelEClass, CLASSIFICATION_MODEL__VIEW_MAPPING);

    classificationEClass = createEClass(CLASSIFICATION);
    createEReference(classificationEClass, CLASSIFICATION__VIEWGROUPS);
    createEReference(classificationEClass, CLASSIFICATION__CLASSIFIED_FEATURES);
    createEReference(classificationEClass, CLASSIFICATION__AUTO_COMPLETE_FEATURES);
    createEReference(classificationEClass, CLASSIFICATION__UNBOUND_FEATURES);
    createEReference(classificationEClass, CLASSIFICATION__ALIVE_FEATURES);
    createEReference(classificationEClass, CLASSIFICATION__DEAD_FEATURES);
    createEAttribute(classificationEClass, CLASSIFICATION__ID);

    classifiedFeatureEClass = createEClass(CLASSIFIED_FEATURE);
    createEReference(classifiedFeatureEClass, CLASSIFIED_FEATURE__FEATURE);
    createEAttribute(classifiedFeatureEClass, CLASSIFIED_FEATURE__CLASSIFIED);

    // Create enums
    classifierEEnum = createEEnum(CLASSIFIER);
  }

   /**
   * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
   * @generated
   */
   private boolean isInitialized = false;

   /**
   * Complete the initialization of the package and its meta-model.  This
   * method is guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
   * @generated
   */
   public void initializePackageContents() {
    if (isInitialized) return;
    isInitialized = true;

    // Initialize package
    setName(eNAME);
    setNsPrefix(eNS_PREFIX);
    setNsURI(eNS_URI);

    // Obtain other dependent packages
    FeaturePackage theFeaturePackage = (FeaturePackage)EPackage.Registry.INSTANCE.getEPackage(FeaturePackage.eNS_URI);
    ViewmappingPackage theViewmappingPackage = (ViewmappingPackage)EPackage.Registry.INSTANCE.getEPackage(ViewmappingPackage.eNS_URI);
    ViewmodelPackage theViewmodelPackage = (ViewmodelPackage)EPackage.Registry.INSTANCE.getEPackage(ViewmodelPackage.eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes

    // Initialize classes and features; add operations and parameters
    initEClass(classificationModelEClass, ClassificationModel.class, "ClassificationModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getClassificationModel_FeatureModel(), theFeaturePackage.getFeatureModel(), null, "featureModel", null, 0, 1, ClassificationModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getClassificationModel_Classifications(), this.getClassification(), null, "classifications", null, 0, -1, ClassificationModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getClassificationModel_ViewMapping(), theViewmappingPackage.getMappingModel(), null, "viewMapping", null, 0, 1, ClassificationModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(classificationEClass, Classification.class, "Classification", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getClassification_Viewgroups(), theViewmodelPackage.getAbstractGroup(), null, "viewgroups", null, 0, -1, Classification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getClassification_ClassifiedFeatures(), this.getClassifiedFeature(), null, "classifiedFeatures", null, 0, -1, Classification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getClassification_AutoCompleteFeatures(), this.getClassifiedFeature(), null, "autoCompleteFeatures", null, 0, -1, Classification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getClassification_UnboundFeatures(), theFeaturePackage.getFeature(), null, "unboundFeatures", null, 0, -1, Classification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getClassification_AliveFeatures(), theFeaturePackage.getFeature(), null, "aliveFeatures", null, 0, -1, Classification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getClassification_DeadFeatures(), theFeaturePackage.getFeature(), null, "deadFeatures", null, 0, -1, Classification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getClassification_Id(), ecorePackage.getEString(), "id", null, 1, 1, Classification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(classifiedFeatureEClass, ClassifiedFeature.class, "ClassifiedFeature", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getClassifiedFeature_Feature(), theFeaturePackage.getFeature(), null, "feature", null, 1, 1, ClassifiedFeature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getClassifiedFeature_Classified(), this.getClassifier(), "classified", "Unclassified", 1, 1, ClassifiedFeature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Initialize enums and add enum literals
    initEEnum(classifierEEnum, Classifier.class, "Classifier");
    addEEnumLiteral(classifierEEnum, Classifier.UNCLASSIFIED);
    addEEnumLiteral(classifierEEnum, Classifier.UNBOUND);
    addEEnumLiteral(classifierEEnum, Classifier.ALIVE);
    addEEnumLiteral(classifierEEnum, Classifier.DEAD);

    // Create resource
    createResource(eNS_URI);
  }

} //ClassificationPackageImpl

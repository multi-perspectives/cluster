/**
 */
package org.feature.model.constraint.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.feature.model.constraint.Constraint;
import org.feature.model.constraint.ConstraintFactory;
import org.feature.model.constraint.ConstraintPackage;
import org.feature.model.constraint.Exclude;
import org.feature.model.constraint.FeatureExpression;
import org.feature.model.constraint.Require;

import org.featuremapper.models.feature.FeaturePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ConstraintPackageImpl extends EPackageImpl implements ConstraintPackage {
   /**
   * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
   * @generated
   */
   private EClass constraintEClass = null;

   /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass featureExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
   * @generated
   */
   private EClass requireEClass = null;

   /**
   * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
   * @generated
   */
   private EClass excludeEClass = null;

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
   * @see org.feature.model.constraint.ConstraintPackage#eNS_URI
   * @see #init()
   * @generated
   */
   private ConstraintPackageImpl() {
    super(eNS_URI, ConstraintFactory.eINSTANCE);
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
   * <p>This method is used to initialize {@link ConstraintPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
   public static ConstraintPackage init() {
    if (isInited) return (ConstraintPackage)EPackage.Registry.INSTANCE.getEPackage(ConstraintPackage.eNS_URI);

    // Obtain or create and register package
    ConstraintPackageImpl theConstraintPackage = (ConstraintPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ConstraintPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ConstraintPackageImpl());

    isInited = true;

    // Initialize simple dependencies
    FeaturePackage.eINSTANCE.eClass();

    // Create package meta-data objects
    theConstraintPackage.createPackageContents();

    // Initialize created meta-data
    theConstraintPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theConstraintPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(ConstraintPackage.eNS_URI, theConstraintPackage);
    return theConstraintPackage;
  }

   /**
   * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
   * @generated
   */
   public EClass getConstraint() {
    return constraintEClass;
  }

   /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getConstraint_Expression()
  {
    return (EReference)constraintEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFeatureExpression()
  {
    return featureExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFeatureExpression_LeftFeature()
  {
    return (EReference)featureExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFeatureExpression_RightFeature()
  {
    return (EReference)featureExpressionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
   * @generated
   */
   public EClass getRequire() {
    return requireEClass;
  }

   /**
   * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
   * @generated
   */
   public EClass getExclude() {
    return excludeEClass;
  }

   /**
   * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
   * @generated
   */
   public ConstraintFactory getConstraintFactory() {
    return (ConstraintFactory)getEFactoryInstance();
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
    constraintEClass = createEClass(CONSTRAINT);
    createEReference(constraintEClass, CONSTRAINT__EXPRESSION);

    featureExpressionEClass = createEClass(FEATURE_EXPRESSION);
    createEReference(featureExpressionEClass, FEATURE_EXPRESSION__LEFT_FEATURE);
    createEReference(featureExpressionEClass, FEATURE_EXPRESSION__RIGHT_FEATURE);

    requireEClass = createEClass(REQUIRE);

    excludeEClass = createEClass(EXCLUDE);
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

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    requireEClass.getESuperTypes().add(this.getFeatureExpression());
    excludeEClass.getESuperTypes().add(this.getFeatureExpression());

    // Initialize classes and features; add operations and parameters
    initEClass(constraintEClass, Constraint.class, "Constraint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getConstraint_Expression(), this.getFeatureExpression(), null, "expression", null, 1, 1, Constraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(featureExpressionEClass, FeatureExpression.class, "FeatureExpression", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getFeatureExpression_LeftFeature(), theFeaturePackage.getFeature(), null, "leftFeature", null, 1, 1, FeatureExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getFeatureExpression_RightFeature(), theFeaturePackage.getFeature(), null, "rightFeature", null, 1, 1, FeatureExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(requireEClass, Require.class, "Require", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(excludeEClass, Exclude.class, "Exclude", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    // Create resource
    createResource(eNS_URI);
  }

} //ConstraintPackageImpl

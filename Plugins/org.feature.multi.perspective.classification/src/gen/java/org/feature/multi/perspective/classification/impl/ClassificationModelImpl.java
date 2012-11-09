/**
 */
package org.feature.multi.perspective.classification.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.feature.multi.perspective.classification.Classification;
import org.feature.multi.perspective.classification.ClassificationModel;
import org.feature.multi.perspective.classification.ClassificationPackage;

import org.feature.multi.perspective.mapping.viewmapping.MappingModel;

import org.featuremapper.models.feature.FeatureModel;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.feature.multi.perspective.classification.impl.ClassificationModelImpl#getFeatureModel <em>Feature Model</em>}</li>
 *   <li>{@link org.feature.multi.perspective.classification.impl.ClassificationModelImpl#getClassifications <em>Classifications</em>}</li>
 *   <li>{@link org.feature.multi.perspective.classification.impl.ClassificationModelImpl#getViewMapping <em>View Mapping</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ClassificationModelImpl extends EObjectImpl implements ClassificationModel {
   /**
	 * The cached value of the '{@link #getFeatureModel() <em>Feature Model</em>}' reference.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @see #getFeatureModel()
	 * @generated
	 * @ordered
	 */
   protected FeatureModel featureModel;

   /**
	 * The cached value of the '{@link #getClassifications() <em>Classifications</em>}' containment reference list.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @see #getClassifications()
	 * @generated
	 * @ordered
	 */
   protected EList<Classification> classifications;

   /**
	 * The cached value of the '{@link #getViewMapping() <em>View Mapping</em>}' reference.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @see #getViewMapping()
	 * @generated
	 * @ordered
	 */
   protected MappingModel viewMapping;

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   protected ClassificationModelImpl() {
		super();
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   @Override
   protected EClass eStaticClass() {
		return ClassificationPackage.Literals.CLASSIFICATION_MODEL;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public FeatureModel getFeatureModel() {
		if (featureModel != null && featureModel.eIsProxy()) {
			InternalEObject oldFeatureModel = (InternalEObject)featureModel;
			featureModel = (FeatureModel)eResolveProxy(oldFeatureModel);
			if (featureModel != oldFeatureModel) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ClassificationPackage.CLASSIFICATION_MODEL__FEATURE_MODEL, oldFeatureModel, featureModel));
			}
		}
		return featureModel;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public FeatureModel basicGetFeatureModel() {
		return featureModel;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public void setFeatureModel(FeatureModel newFeatureModel) {
		FeatureModel oldFeatureModel = featureModel;
		featureModel = newFeatureModel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ClassificationPackage.CLASSIFICATION_MODEL__FEATURE_MODEL, oldFeatureModel, featureModel));
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public EList<Classification> getClassifications() {
		if (classifications == null) {
			classifications = new EObjectContainmentEList<Classification>(Classification.class, this, ClassificationPackage.CLASSIFICATION_MODEL__CLASSIFICATIONS);
		}
		return classifications;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public MappingModel getViewMapping() {
		if (viewMapping != null && viewMapping.eIsProxy()) {
			InternalEObject oldViewMapping = (InternalEObject)viewMapping;
			viewMapping = (MappingModel)eResolveProxy(oldViewMapping);
			if (viewMapping != oldViewMapping) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ClassificationPackage.CLASSIFICATION_MODEL__VIEW_MAPPING, oldViewMapping, viewMapping));
			}
		}
		return viewMapping;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public MappingModel basicGetViewMapping() {
		return viewMapping;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public void setViewMapping(MappingModel newViewMapping) {
		MappingModel oldViewMapping = viewMapping;
		viewMapping = newViewMapping;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ClassificationPackage.CLASSIFICATION_MODEL__VIEW_MAPPING, oldViewMapping, viewMapping));
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   @Override
   public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ClassificationPackage.CLASSIFICATION_MODEL__CLASSIFICATIONS:
				return ((InternalEList<?>)getClassifications()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   @Override
   public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ClassificationPackage.CLASSIFICATION_MODEL__FEATURE_MODEL:
				if (resolve) return getFeatureModel();
				return basicGetFeatureModel();
			case ClassificationPackage.CLASSIFICATION_MODEL__CLASSIFICATIONS:
				return getClassifications();
			case ClassificationPackage.CLASSIFICATION_MODEL__VIEW_MAPPING:
				if (resolve) return getViewMapping();
				return basicGetViewMapping();
		}
		return super.eGet(featureID, resolve, coreType);
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   @SuppressWarnings("unchecked")
   @Override
   public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ClassificationPackage.CLASSIFICATION_MODEL__FEATURE_MODEL:
				setFeatureModel((FeatureModel)newValue);
				return;
			case ClassificationPackage.CLASSIFICATION_MODEL__CLASSIFICATIONS:
				getClassifications().clear();
				getClassifications().addAll((Collection<? extends Classification>)newValue);
				return;
			case ClassificationPackage.CLASSIFICATION_MODEL__VIEW_MAPPING:
				setViewMapping((MappingModel)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   @Override
   public void eUnset(int featureID) {
		switch (featureID) {
			case ClassificationPackage.CLASSIFICATION_MODEL__FEATURE_MODEL:
				setFeatureModel((FeatureModel)null);
				return;
			case ClassificationPackage.CLASSIFICATION_MODEL__CLASSIFICATIONS:
				getClassifications().clear();
				return;
			case ClassificationPackage.CLASSIFICATION_MODEL__VIEW_MAPPING:
				setViewMapping((MappingModel)null);
				return;
		}
		super.eUnset(featureID);
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   @Override
   public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ClassificationPackage.CLASSIFICATION_MODEL__FEATURE_MODEL:
				return featureModel != null;
			case ClassificationPackage.CLASSIFICATION_MODEL__CLASSIFICATIONS:
				return classifications != null && !classifications.isEmpty();
			case ClassificationPackage.CLASSIFICATION_MODEL__VIEW_MAPPING:
				return viewMapping != null;
		}
		return super.eIsSet(featureID);
	}

} //ClassificationModelImpl

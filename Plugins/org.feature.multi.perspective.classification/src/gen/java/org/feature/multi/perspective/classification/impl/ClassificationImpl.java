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
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.feature.multi.perspective.classification.Classification;
import org.feature.multi.perspective.classification.ClassificationPackage;
import org.feature.multi.perspective.classification.ClassifiedFeature;

import org.feature.multi.perspective.model.viewmodel.AbstractGroup;

import org.featuremapper.models.feature.Feature;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Classification</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.feature.multi.perspective.classification.impl.ClassificationImpl#getViewgroups <em>Viewgroups</em>}</li>
 *   <li>{@link org.feature.multi.perspective.classification.impl.ClassificationImpl#getClassifiedFeatures <em>Classified Features</em>}</li>
 *   <li>{@link org.feature.multi.perspective.classification.impl.ClassificationImpl#getAutoCompleteFeatures <em>Auto Complete Features</em>}</li>
 *   <li>{@link org.feature.multi.perspective.classification.impl.ClassificationImpl#getUnboundFeatures <em>Unbound Features</em>}</li>
 *   <li>{@link org.feature.multi.perspective.classification.impl.ClassificationImpl#getAliveFeatures <em>Alive Features</em>}</li>
 *   <li>{@link org.feature.multi.perspective.classification.impl.ClassificationImpl#getDeadFeatures <em>Dead Features</em>}</li>
 *   <li>{@link org.feature.multi.perspective.classification.impl.ClassificationImpl#getId <em>Id</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ClassificationImpl extends EObjectImpl implements Classification {
   /**
   * The cached value of the '{@link #getViewgroups() <em>Viewgroups</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getViewgroups()
   * @generated
   * @ordered
   */
  protected EList<AbstractGroup> viewgroups;

  /**
   * The cached value of the '{@link #getClassifiedFeatures() <em>Classified Features</em>}' containment reference list.
   * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
   * @see #getClassifiedFeatures()
   * @generated
   * @ordered
   */
   protected EList<ClassifiedFeature> classifiedFeatures;

   /**
   * The cached value of the '{@link #getAutoCompleteFeatures() <em>Auto Complete Features</em>}' containment reference list.
   * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
   * @see #getAutoCompleteFeatures()
   * @generated
   * @ordered
   */
   protected EList<ClassifiedFeature> autoCompleteFeatures;

   /**
   * The cached value of the '{@link #getUnboundFeatures() <em>Unbound Features</em>}' reference list.
   * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
   * @see #getUnboundFeatures()
   * @generated
   * @ordered
   */
   protected EList<Feature> unboundFeatures;

   /**
   * The cached value of the '{@link #getAliveFeatures() <em>Alive Features</em>}' reference list.
   * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
   * @see #getAliveFeatures()
   * @generated
   * @ordered
   */
   protected EList<Feature> aliveFeatures;

   /**
   * The cached value of the '{@link #getDeadFeatures() <em>Dead Features</em>}' reference list.
   * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
   * @see #getDeadFeatures()
   * @generated
   * @ordered
   */
   protected EList<Feature> deadFeatures;

   /**
   * The default value of the '{@link #getId() <em>Id</em>}' attribute.
   * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
   * @see #getId()
   * @generated
   * @ordered
   */
   protected static final String ID_EDEFAULT = null;

   /**
   * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
   * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
   * @see #getId()
   * @generated
   * @ordered
   */
   protected String id = ID_EDEFAULT;

   /**
   * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
   * @generated
   */
   protected ClassificationImpl() {
    super();
  }

   /**
   * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
   * @generated
   */
   @Override
   protected EClass eStaticClass() {
    return ClassificationPackage.Literals.CLASSIFICATION;
  }

   /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<AbstractGroup> getViewgroups()
  {
    if (viewgroups == null)
    {
      viewgroups = new EObjectResolvingEList<AbstractGroup>(AbstractGroup.class, this, ClassificationPackage.CLASSIFICATION__VIEWGROUPS);
    }
    return viewgroups;
  }

  /**
   * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
   * @generated
   */
   public EList<ClassifiedFeature> getClassifiedFeatures() {
    if (classifiedFeatures == null)
    {
      classifiedFeatures = new EObjectContainmentEList<ClassifiedFeature>(ClassifiedFeature.class, this, ClassificationPackage.CLASSIFICATION__CLASSIFIED_FEATURES);
    }
    return classifiedFeatures;
  }

   /**
   * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
   * @generated
   */
   public EList<ClassifiedFeature> getAutoCompleteFeatures() {
    if (autoCompleteFeatures == null)
    {
      autoCompleteFeatures = new EObjectContainmentEList<ClassifiedFeature>(ClassifiedFeature.class, this, ClassificationPackage.CLASSIFICATION__AUTO_COMPLETE_FEATURES);
    }
    return autoCompleteFeatures;
  }

   /**
   * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
   * @generated
   */
   public EList<Feature> getUnboundFeatures() {
    if (unboundFeatures == null)
    {
      unboundFeatures = new EObjectResolvingEList<Feature>(Feature.class, this, ClassificationPackage.CLASSIFICATION__UNBOUND_FEATURES);
    }
    return unboundFeatures;
  }

   /**
   * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
   * @generated
   */
   public EList<Feature> getAliveFeatures() {
    if (aliveFeatures == null)
    {
      aliveFeatures = new EObjectResolvingEList<Feature>(Feature.class, this, ClassificationPackage.CLASSIFICATION__ALIVE_FEATURES);
    }
    return aliveFeatures;
  }

   /**
   * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
   * @generated
   */
   public EList<Feature> getDeadFeatures() {
    if (deadFeatures == null)
    {
      deadFeatures = new EObjectResolvingEList<Feature>(Feature.class, this, ClassificationPackage.CLASSIFICATION__DEAD_FEATURES);
    }
    return deadFeatures;
  }

   /**
   * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
   * @generated
   */
   public String getId() {
    return id;
  }

   /**
   * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
   * @generated
   */
   public void setId(String newId) {
    String oldId = id;
    id = newId;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ClassificationPackage.CLASSIFICATION__ID, oldId, id));
  }

   /**
   * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
   * @generated
   */
   @Override
   public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID)
    {
      case ClassificationPackage.CLASSIFICATION__CLASSIFIED_FEATURES:
        return ((InternalEList<?>)getClassifiedFeatures()).basicRemove(otherEnd, msgs);
      case ClassificationPackage.CLASSIFICATION__AUTO_COMPLETE_FEATURES:
        return ((InternalEList<?>)getAutoCompleteFeatures()).basicRemove(otherEnd, msgs);
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
    switch (featureID)
    {
      case ClassificationPackage.CLASSIFICATION__VIEWGROUPS:
        return getViewgroups();
      case ClassificationPackage.CLASSIFICATION__CLASSIFIED_FEATURES:
        return getClassifiedFeatures();
      case ClassificationPackage.CLASSIFICATION__AUTO_COMPLETE_FEATURES:
        return getAutoCompleteFeatures();
      case ClassificationPackage.CLASSIFICATION__UNBOUND_FEATURES:
        return getUnboundFeatures();
      case ClassificationPackage.CLASSIFICATION__ALIVE_FEATURES:
        return getAliveFeatures();
      case ClassificationPackage.CLASSIFICATION__DEAD_FEATURES:
        return getDeadFeatures();
      case ClassificationPackage.CLASSIFICATION__ID:
        return getId();
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
    switch (featureID)
    {
      case ClassificationPackage.CLASSIFICATION__VIEWGROUPS:
        getViewgroups().clear();
        getViewgroups().addAll((Collection<? extends AbstractGroup>)newValue);
        return;
      case ClassificationPackage.CLASSIFICATION__CLASSIFIED_FEATURES:
        getClassifiedFeatures().clear();
        getClassifiedFeatures().addAll((Collection<? extends ClassifiedFeature>)newValue);
        return;
      case ClassificationPackage.CLASSIFICATION__AUTO_COMPLETE_FEATURES:
        getAutoCompleteFeatures().clear();
        getAutoCompleteFeatures().addAll((Collection<? extends ClassifiedFeature>)newValue);
        return;
      case ClassificationPackage.CLASSIFICATION__UNBOUND_FEATURES:
        getUnboundFeatures().clear();
        getUnboundFeatures().addAll((Collection<? extends Feature>)newValue);
        return;
      case ClassificationPackage.CLASSIFICATION__ALIVE_FEATURES:
        getAliveFeatures().clear();
        getAliveFeatures().addAll((Collection<? extends Feature>)newValue);
        return;
      case ClassificationPackage.CLASSIFICATION__DEAD_FEATURES:
        getDeadFeatures().clear();
        getDeadFeatures().addAll((Collection<? extends Feature>)newValue);
        return;
      case ClassificationPackage.CLASSIFICATION__ID:
        setId((String)newValue);
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
    switch (featureID)
    {
      case ClassificationPackage.CLASSIFICATION__VIEWGROUPS:
        getViewgroups().clear();
        return;
      case ClassificationPackage.CLASSIFICATION__CLASSIFIED_FEATURES:
        getClassifiedFeatures().clear();
        return;
      case ClassificationPackage.CLASSIFICATION__AUTO_COMPLETE_FEATURES:
        getAutoCompleteFeatures().clear();
        return;
      case ClassificationPackage.CLASSIFICATION__UNBOUND_FEATURES:
        getUnboundFeatures().clear();
        return;
      case ClassificationPackage.CLASSIFICATION__ALIVE_FEATURES:
        getAliveFeatures().clear();
        return;
      case ClassificationPackage.CLASSIFICATION__DEAD_FEATURES:
        getDeadFeatures().clear();
        return;
      case ClassificationPackage.CLASSIFICATION__ID:
        setId(ID_EDEFAULT);
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
    switch (featureID)
    {
      case ClassificationPackage.CLASSIFICATION__VIEWGROUPS:
        return viewgroups != null && !viewgroups.isEmpty();
      case ClassificationPackage.CLASSIFICATION__CLASSIFIED_FEATURES:
        return classifiedFeatures != null && !classifiedFeatures.isEmpty();
      case ClassificationPackage.CLASSIFICATION__AUTO_COMPLETE_FEATURES:
        return autoCompleteFeatures != null && !autoCompleteFeatures.isEmpty();
      case ClassificationPackage.CLASSIFICATION__UNBOUND_FEATURES:
        return unboundFeatures != null && !unboundFeatures.isEmpty();
      case ClassificationPackage.CLASSIFICATION__ALIVE_FEATURES:
        return aliveFeatures != null && !aliveFeatures.isEmpty();
      case ClassificationPackage.CLASSIFICATION__DEAD_FEATURES:
        return deadFeatures != null && !deadFeatures.isEmpty();
      case ClassificationPackage.CLASSIFICATION__ID:
        return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
    }
    return super.eIsSet(featureID);
  }

   /**
   * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
   * @generated
   */
   @Override
   public String toString() {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (id: ");
    result.append(id);
    result.append(')');
    return result.toString();
  }

} //ClassificationImpl

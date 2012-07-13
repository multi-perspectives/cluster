/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.feature.multi.perspective.model.viewmodel.impl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.feature.multi.perspective.model.viewmodel.Group;
import org.feature.multi.perspective.model.viewmodel.ViewPoint;
import org.feature.multi.perspective.model.viewmodel.ViewmodelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>View Point</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.feature.multi.perspective.model.viewmodel.impl.ViewPointImpl#getContainedInGroup <em>Contained In Group</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ViewPointImpl extends ElementImpl implements ViewPoint {
   /**
    * The cached value of the '{@link #getContainedInGroup() <em>Contained In Group</em>}' reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see #getContainedInGroup()
    * @generated
    * @ordered
    */
   protected EList<Group> containedInGroup;

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   protected ViewPointImpl() {
      super();
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   @Override
   protected EClass eStaticClass() {
      return ViewmodelPackage.Literals.VIEW_POINT;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EList<Group> getContainedInGroup() {
      if (containedInGroup == null) {
         containedInGroup = new EObjectResolvingEList<Group>(Group.class, this, ViewmodelPackage.VIEW_POINT__CONTAINED_IN_GROUP);
      }
      return containedInGroup;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   @Override
   public Object eGet(int featureID, boolean resolve, boolean coreType) {
      switch (featureID) {
         case ViewmodelPackage.VIEW_POINT__CONTAINED_IN_GROUP:
            return getContainedInGroup();
      }
      return super.eGet(featureID, resolve, coreType);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   @Override
   public boolean eIsSet(int featureID) {
      switch (featureID) {
         case ViewmodelPackage.VIEW_POINT__CONTAINED_IN_GROUP:
            return containedInGroup != null && !containedInGroup.isEmpty();
      }
      return super.eIsSet(featureID);
   }

} //ViewPointImpl

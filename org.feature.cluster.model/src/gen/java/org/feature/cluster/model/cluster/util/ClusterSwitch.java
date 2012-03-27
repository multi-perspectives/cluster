/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.feature.cluster.model.cluster.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.feature.cluster.model.cluster.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.feature.cluster.model.cluster.ClusterPackage
 * @generated
 */
public class ClusterSwitch<T> extends Switch<T> {
	/**
    * The cached model package
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	protected static ClusterPackage modelPackage;

	/**
    * Creates an instance of the switch.
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	public ClusterSwitch() {
      if (modelPackage == null) {
         modelPackage = ClusterPackage.eINSTANCE;
      }
   }

	/**
    * Checks whether this is a switch for the given package.
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @parameter ePackage the package in question.
    * @return whether this is a switch for the given package.
    * @generated
    */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
      return ePackage == modelPackage;
   }

	/**
    * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @return the first non-null result returned by a <code>caseXXX</code> call.
    * @generated
    */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
      switch (classifierID) {
         case ClusterPackage.CORE_GROUP: {
            CoreGroup coreGroup = (CoreGroup)theEObject;
            T result = caseCoreGroup(coreGroup);
            if (result == null) result = caseIGroup(coreGroup);
            if (result == null) result = defaultCase(theEObject);
            return result;
         }
         case ClusterPackage.GROUP: {
            Group group = (Group)theEObject;
            T result = caseGroup(group);
            if (result == null) result = caseIGroup(group);
            if (result == null) result = caseElement(group);
            if (result == null) result = defaultCase(theEObject);
            return result;
         }
         case ClusterPackage.VIEW_POINT: {
            ViewPoint viewPoint = (ViewPoint)theEObject;
            T result = caseViewPoint(viewPoint);
            if (result == null) result = caseElement(viewPoint);
            if (result == null) result = defaultCase(theEObject);
            return result;
         }
         case ClusterPackage.ELEMENT: {
            Element element = (Element)theEObject;
            T result = caseElement(element);
            if (result == null) result = defaultCase(theEObject);
            return result;
         }
         case ClusterPackage.IGROUP: {
            IGroup iGroup = (IGroup)theEObject;
            T result = caseIGroup(iGroup);
            if (result == null) result = defaultCase(theEObject);
            return result;
         }
         case ClusterPackage.GROUP_MODEL: {
            GroupModel groupModel = (GroupModel)theEObject;
            T result = caseGroupModel(groupModel);
            if (result == null) result = defaultCase(theEObject);
            return result;
         }
         case ClusterPackage.VIEW_POINT_CONTAINER: {
            ViewPointContainer viewPointContainer = (ViewPointContainer)theEObject;
            T result = caseViewPointContainer(viewPointContainer);
            if (result == null) result = defaultCase(theEObject);
            return result;
         }
         default: return defaultCase(theEObject);
      }
   }

	/**
    * Returns the result of interpreting the object as an instance of '<em>Core Group</em>'.
    * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
    * @param object the target of the switch.
    * @return the result of interpreting the object as an instance of '<em>Core Group</em>'.
    * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
    * @generated
    */
	public T caseCoreGroup(CoreGroup object) {
      return null;
   }

	/**
    * Returns the result of interpreting the object as an instance of '<em>Group</em>'.
    * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
    * @param object the target of the switch.
    * @return the result of interpreting the object as an instance of '<em>Group</em>'.
    * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
    * @generated
    */
	public T caseGroup(Group object) {
      return null;
   }

	/**
    * Returns the result of interpreting the object as an instance of '<em>View Point</em>'.
    * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
    * @param object the target of the switch.
    * @return the result of interpreting the object as an instance of '<em>View Point</em>'.
    * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
    * @generated
    */
	public T caseViewPoint(ViewPoint object) {
      return null;
   }

	/**
    * Returns the result of interpreting the object as an instance of '<em>Element</em>'.
    * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
    * @param object the target of the switch.
    * @return the result of interpreting the object as an instance of '<em>Element</em>'.
    * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
    * @generated
    */
	public T caseElement(Element object) {
      return null;
   }

	/**
    * Returns the result of interpreting the object as an instance of '<em>IGroup</em>'.
    * <!-- begin-user-doc -->
    * This implementation returns null;
    * returning a non-null result will terminate the switch.
    * <!-- end-user-doc -->
    * @param object the target of the switch.
    * @return the result of interpreting the object as an instance of '<em>IGroup</em>'.
    * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
    * @generated
    */
   public T caseIGroup(IGroup object) {
      return null;
   }

   /**
    * Returns the result of interpreting the object as an instance of '<em>Group Model</em>'.
    * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
    * @param object the target of the switch.
    * @return the result of interpreting the object as an instance of '<em>Group Model</em>'.
    * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
    * @generated
    */
	public T caseGroupModel(GroupModel object) {
      return null;
   }

	/**
    * Returns the result of interpreting the object as an instance of '<em>View Point Container</em>'.
    * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
    * @param object the target of the switch.
    * @return the result of interpreting the object as an instance of '<em>View Point Container</em>'.
    * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
    * @generated
    */
	public T caseViewPointContainer(ViewPointContainer object) {
      return null;
   }

	/**
    * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
    * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
    * @param object the target of the switch.
    * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
    * @see #doSwitch(org.eclipse.emf.ecore.EObject)
    * @generated
    */
	@Override
	public T defaultCase(EObject object) {
      return null;
   }

} //ClusterSwitch

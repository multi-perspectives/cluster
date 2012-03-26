/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.feature.cluster.model.cluster.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.feature.cluster.model.cluster.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ClusterFactoryImpl extends EFactoryImpl implements ClusterFactory {
	/**
    * Creates the default factory implementation.
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	public static ClusterFactory init() {
      try {
         ClusterFactory theClusterFactory = (ClusterFactory)EPackage.Registry.INSTANCE.getEFactory("http://org.feature.cluster.model/schema/1.0"); 
         if (theClusterFactory != null) {
            return theClusterFactory;
         }
      }
      catch (Exception exception) {
         EcorePlugin.INSTANCE.log(exception);
      }
      return new ClusterFactoryImpl();
   }

	/**
    * Creates an instance of the factory.
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	public ClusterFactoryImpl() {
      super();
   }

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	@Override
	public EObject create(EClass eClass) {
      switch (eClass.getClassifierID()) {
         case ClusterPackage.CORE_GROUP: return createCoreGroup();
         case ClusterPackage.GROUP: return createGroup();
         case ClusterPackage.VIEW_POINT: return createViewPoint();
         case ClusterPackage.GROUP_MODEL: return createGroupModel();
         case ClusterPackage.VIEW_POINT_CONTAINER: return createViewPointContainer();
         default:
            throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
      }
   }

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	public CoreGroup createCoreGroup() {
      CoreGroupImpl coreGroup = new CoreGroupImpl();
      return coreGroup;
   }

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	public Group createGroup() {
      GroupImpl group = new GroupImpl();
      return group;
   }

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	public ViewPoint createViewPoint() {
      ViewPointImpl viewPoint = new ViewPointImpl();
      return viewPoint;
   }

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	public GroupModel createGroupModel() {
      GroupModelImpl groupModel = new GroupModelImpl();
      return groupModel;
   }

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	public ViewPointContainer createViewPointContainer() {
      ViewPointContainerImpl viewPointContainer = new ViewPointContainerImpl();
      return viewPointContainer;
   }

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	public ClusterPackage getClusterPackage() {
      return (ClusterPackage)getEPackage();
   }

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @deprecated
    * @generated
    */
	@Deprecated
	public static ClusterPackage getPackage() {
      return ClusterPackage.eINSTANCE;
   }

} //ClusterFactoryImpl

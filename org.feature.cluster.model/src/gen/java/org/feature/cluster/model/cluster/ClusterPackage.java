/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.feature.cluster.model.cluster;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
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
 * @see org.feature.cluster.model.cluster.ClusterFactory
 * @model kind="package"
 * @generated
 */
public interface ClusterPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "cluster";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://org.feature.cluster.model/schema/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "cluster";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ClusterPackage eINSTANCE = org.feature.cluster.model.cluster.impl.ClusterPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.feature.cluster.model.cluster.IGroup <em>IGroup</em>}' class.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @see org.feature.cluster.model.cluster.IGroup
	 * @see org.feature.cluster.model.cluster.impl.ClusterPackageImpl#getIGroup()
	 * @generated
	 */
   int IGROUP = 4;

   /**
	 * The feature id for the '<em><b>Groups</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
   int IGROUP__GROUPS = 0;

   /**
	 * The number of structural features of the '<em>IGroup</em>' class.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
   int IGROUP_FEATURE_COUNT = 1;

   /**
	 * The meta object id for the '{@link org.feature.cluster.model.cluster.impl.CoreGroupImpl <em>Core Group</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.feature.cluster.model.cluster.impl.CoreGroupImpl
	 * @see org.feature.cluster.model.cluster.impl.ClusterPackageImpl#getCoreGroup()
	 * @generated
	 */
	int CORE_GROUP = 0;

	/**
	 * The feature id for the '<em><b>Groups</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_GROUP__GROUPS = IGROUP__GROUPS;

	/**
	 * The number of structural features of the '<em>Core Group</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_GROUP_FEATURE_COUNT = IGROUP_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.feature.cluster.model.cluster.impl.ElementImpl <em>Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.feature.cluster.model.cluster.impl.ElementImpl
	 * @see org.feature.cluster.model.cluster.impl.ClusterPackageImpl#getElement()
	 * @generated
	 */
	int ELEMENT = 3;

	/**
	 * The meta object id for the '{@link org.feature.cluster.model.cluster.impl.GroupImpl <em>Group</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.feature.cluster.model.cluster.impl.GroupImpl
	 * @see org.feature.cluster.model.cluster.impl.ClusterPackageImpl#getGroup()
	 * @generated
	 */
	int GROUP = 1;

	/**
	 * The feature id for the '<em><b>Groups</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP__GROUPS = IGROUP__GROUPS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP__NAME = IGROUP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>View Point Reference</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP__VIEW_POINT_REFERENCE = IGROUP_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Parent Group</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP__PARENT_GROUP = IGROUP_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Group</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP_FEATURE_COUNT = IGROUP_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT__NAME = 0;

	/**
	 * The number of structural features of the '<em>Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.feature.cluster.model.cluster.impl.ViewPointImpl <em>View Point</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.feature.cluster.model.cluster.impl.ViewPointImpl
	 * @see org.feature.cluster.model.cluster.impl.ClusterPackageImpl#getViewPoint()
	 * @generated
	 */
	int VIEW_POINT = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_POINT__NAME = ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Contained In Group</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_POINT__CONTAINED_IN_GROUP = ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>View Point</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_POINT_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.feature.cluster.model.cluster.impl.GroupModelImpl <em>Group Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.feature.cluster.model.cluster.impl.GroupModelImpl
	 * @see org.feature.cluster.model.cluster.impl.ClusterPackageImpl#getGroupModel()
	 * @generated
	 */
	int GROUP_MODEL = 5;

	/**
	 * The feature id for the '<em><b>Core Group</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP_MODEL__CORE_GROUP = 0;

	/**
	 * The feature id for the '<em><b>View Point Container</b></em>' containment reference.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
   int GROUP_MODEL__VIEW_POINT_CONTAINER = 1;

   /**
	 * The number of structural features of the '<em>Group Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP_MODEL_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.feature.cluster.model.cluster.impl.ViewPointContainerImpl <em>View Point Container</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.feature.cluster.model.cluster.impl.ViewPointContainerImpl
	 * @see org.feature.cluster.model.cluster.impl.ClusterPackageImpl#getViewPointContainer()
	 * @generated
	 */
	int VIEW_POINT_CONTAINER = 6;

	/**
	 * The feature id for the '<em><b>View Points</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_POINT_CONTAINER__VIEW_POINTS = 0;

	/**
	 * The number of structural features of the '<em>View Point Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_POINT_CONTAINER_FEATURE_COUNT = 1;


	/**
	 * Returns the meta object for class '{@link org.feature.cluster.model.cluster.CoreGroup <em>Core Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Core Group</em>'.
	 * @see org.feature.cluster.model.cluster.CoreGroup
	 * @generated
	 */
	EClass getCoreGroup();

	/**
	 * Returns the meta object for class '{@link org.feature.cluster.model.cluster.Group <em>Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Group</em>'.
	 * @see org.feature.cluster.model.cluster.Group
	 * @generated
	 */
	EClass getGroup();

	/**
	 * Returns the meta object for the reference list '{@link org.feature.cluster.model.cluster.Group#getViewPointReference <em>View Point Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>View Point Reference</em>'.
	 * @see org.feature.cluster.model.cluster.Group#getViewPointReference()
	 * @see #getGroup()
	 * @generated
	 */
	EReference getGroup_ViewPointReference();

	/**
	 * Returns the meta object for the container reference '{@link org.feature.cluster.model.cluster.Group#getParentGroup <em>Parent Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Parent Group</em>'.
	 * @see org.feature.cluster.model.cluster.Group#getParentGroup()
	 * @see #getGroup()
	 * @generated
	 */
	EReference getGroup_ParentGroup();

	/**
	 * Returns the meta object for class '{@link org.feature.cluster.model.cluster.ViewPoint <em>View Point</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>View Point</em>'.
	 * @see org.feature.cluster.model.cluster.ViewPoint
	 * @generated
	 */
	EClass getViewPoint();

	/**
	 * Returns the meta object for the reference list '{@link org.feature.cluster.model.cluster.ViewPoint#getContainedInGroup <em>Contained In Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Contained In Group</em>'.
	 * @see org.feature.cluster.model.cluster.ViewPoint#getContainedInGroup()
	 * @see #getViewPoint()
	 * @generated
	 */
	EReference getViewPoint_ContainedInGroup();

	/**
	 * Returns the meta object for class '{@link org.feature.cluster.model.cluster.Element <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Element</em>'.
	 * @see org.feature.cluster.model.cluster.Element
	 * @generated
	 */
	EClass getElement();

	/**
	 * Returns the meta object for the attribute '{@link org.feature.cluster.model.cluster.Element#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.feature.cluster.model.cluster.Element#getName()
	 * @see #getElement()
	 * @generated
	 */
	EAttribute getElement_Name();

	/**
	 * Returns the meta object for class '{@link org.feature.cluster.model.cluster.IGroup <em>IGroup</em>}'.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IGroup</em>'.
	 * @see org.feature.cluster.model.cluster.IGroup
	 * @generated
	 */
   EClass getIGroup();

   /**
	 * Returns the meta object for the containment reference list '{@link org.feature.cluster.model.cluster.IGroup#getGroups <em>Groups</em>}'.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Groups</em>'.
	 * @see org.feature.cluster.model.cluster.IGroup#getGroups()
	 * @see #getIGroup()
	 * @generated
	 */
   EReference getIGroup_Groups();

   /**
	 * Returns the meta object for class '{@link org.feature.cluster.model.cluster.GroupModel <em>Group Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Group Model</em>'.
	 * @see org.feature.cluster.model.cluster.GroupModel
	 * @generated
	 */
	EClass getGroupModel();

	/**
	 * Returns the meta object for the containment reference '{@link org.feature.cluster.model.cluster.GroupModel#getCoreGroup <em>Core Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Core Group</em>'.
	 * @see org.feature.cluster.model.cluster.GroupModel#getCoreGroup()
	 * @see #getGroupModel()
	 * @generated
	 */
	EReference getGroupModel_CoreGroup();

	/**
	 * Returns the meta object for the containment reference '{@link org.feature.cluster.model.cluster.GroupModel#getViewPointContainer <em>View Point Container</em>}'.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>View Point Container</em>'.
	 * @see org.feature.cluster.model.cluster.GroupModel#getViewPointContainer()
	 * @see #getGroupModel()
	 * @generated
	 */
   EReference getGroupModel_ViewPointContainer();

   /**
	 * Returns the meta object for class '{@link org.feature.cluster.model.cluster.ViewPointContainer <em>View Point Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>View Point Container</em>'.
	 * @see org.feature.cluster.model.cluster.ViewPointContainer
	 * @generated
	 */
	EClass getViewPointContainer();

	/**
	 * Returns the meta object for the containment reference list '{@link org.feature.cluster.model.cluster.ViewPointContainer#getViewPoints <em>View Points</em>}'.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>View Points</em>'.
	 * @see org.feature.cluster.model.cluster.ViewPointContainer#getViewPoints()
	 * @see #getViewPointContainer()
	 * @generated
	 */
   EReference getViewPointContainer_ViewPoints();

   /**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ClusterFactory getClusterFactory();

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
		 * The meta object literal for the '{@link org.feature.cluster.model.cluster.impl.CoreGroupImpl <em>Core Group</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.feature.cluster.model.cluster.impl.CoreGroupImpl
		 * @see org.feature.cluster.model.cluster.impl.ClusterPackageImpl#getCoreGroup()
		 * @generated
		 */
		EClass CORE_GROUP = eINSTANCE.getCoreGroup();

		/**
		 * The meta object literal for the '{@link org.feature.cluster.model.cluster.impl.GroupImpl <em>Group</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.feature.cluster.model.cluster.impl.GroupImpl
		 * @see org.feature.cluster.model.cluster.impl.ClusterPackageImpl#getGroup()
		 * @generated
		 */
		EClass GROUP = eINSTANCE.getGroup();

		/**
		 * The meta object literal for the '<em><b>View Point Reference</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GROUP__VIEW_POINT_REFERENCE = eINSTANCE.getGroup_ViewPointReference();

		/**
		 * The meta object literal for the '<em><b>Parent Group</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GROUP__PARENT_GROUP = eINSTANCE.getGroup_ParentGroup();

		/**
		 * The meta object literal for the '{@link org.feature.cluster.model.cluster.impl.ViewPointImpl <em>View Point</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.feature.cluster.model.cluster.impl.ViewPointImpl
		 * @see org.feature.cluster.model.cluster.impl.ClusterPackageImpl#getViewPoint()
		 * @generated
		 */
		EClass VIEW_POINT = eINSTANCE.getViewPoint();

		/**
		 * The meta object literal for the '<em><b>Contained In Group</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VIEW_POINT__CONTAINED_IN_GROUP = eINSTANCE.getViewPoint_ContainedInGroup();

		/**
		 * The meta object literal for the '{@link org.feature.cluster.model.cluster.impl.ElementImpl <em>Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.feature.cluster.model.cluster.impl.ElementImpl
		 * @see org.feature.cluster.model.cluster.impl.ClusterPackageImpl#getElement()
		 * @generated
		 */
		EClass ELEMENT = eINSTANCE.getElement();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ELEMENT__NAME = eINSTANCE.getElement_Name();

		/**
		 * The meta object literal for the '{@link org.feature.cluster.model.cluster.IGroup <em>IGroup</em>}' class.
		 * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
		 * @see org.feature.cluster.model.cluster.IGroup
		 * @see org.feature.cluster.model.cluster.impl.ClusterPackageImpl#getIGroup()
		 * @generated
		 */
      EClass IGROUP = eINSTANCE.getIGroup();

      /**
		 * The meta object literal for the '<em><b>Groups</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
		 * @generated
		 */
      EReference IGROUP__GROUPS = eINSTANCE.getIGroup_Groups();

      /**
		 * The meta object literal for the '{@link org.feature.cluster.model.cluster.impl.GroupModelImpl <em>Group Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.feature.cluster.model.cluster.impl.GroupModelImpl
		 * @see org.feature.cluster.model.cluster.impl.ClusterPackageImpl#getGroupModel()
		 * @generated
		 */
		EClass GROUP_MODEL = eINSTANCE.getGroupModel();

		/**
		 * The meta object literal for the '<em><b>Core Group</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GROUP_MODEL__CORE_GROUP = eINSTANCE.getGroupModel_CoreGroup();

		/**
		 * The meta object literal for the '<em><b>View Point Container</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
		 * @generated
		 */
      EReference GROUP_MODEL__VIEW_POINT_CONTAINER = eINSTANCE.getGroupModel_ViewPointContainer();

      /**
		 * The meta object literal for the '{@link org.feature.cluster.model.cluster.impl.ViewPointContainerImpl <em>View Point Container</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.feature.cluster.model.cluster.impl.ViewPointContainerImpl
		 * @see org.feature.cluster.model.cluster.impl.ClusterPackageImpl#getViewPointContainer()
		 * @generated
		 */
		EClass VIEW_POINT_CONTAINER = eINSTANCE.getViewPointContainer();

      /**
		 * The meta object literal for the '<em><b>View Points</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
		 * @generated
		 */
      EReference VIEW_POINT_CONTAINER__VIEW_POINTS = eINSTANCE.getViewPointContainer_ViewPoints();

	}

} //ClusterPackage

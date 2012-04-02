/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.feature.cluster.model.cluster.impl;

import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.feature.cluster.model.cluster.ClusterPackage;
import org.feature.cluster.model.cluster.Element;
import org.feature.cluster.model.cluster.Group;
import org.feature.cluster.model.cluster.IGroup;
import org.feature.cluster.model.cluster.ViewPoint;
import org.feature.cluster.model.cluster.util.ClusterValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Group</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.feature.cluster.model.cluster.impl.GroupImpl#getViewPointReference <em>View Point Reference</em>}</li>
 *   <li>{@link org.feature.cluster.model.cluster.impl.GroupImpl#getParentGroup <em>Parent Group</em>}</li>
 *   <li>{@link org.feature.cluster.model.cluster.impl.GroupImpl#getGroups <em>Groups</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GroupImpl extends ElementImpl implements Group {
	/**
    * The cached value of the '{@link #getViewPointReference() <em>View Point Reference</em>}' reference list.
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @see #getViewPointReference()
    * @generated
    * @ordered
    */
	protected EList<ViewPoint> viewPointReference;

	/**
    * The cached value of the '{@link #getGroups() <em>Groups</em>}' containment reference list.
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @see #getGroups()
    * @generated
    * @ordered
    */
	protected EList<Group> groups;

   /**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	protected GroupImpl() {
      super();
   }

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	@Override
	protected EClass eStaticClass() {
      return ClusterPackage.Literals.GROUP;
   }

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	public EList<Group> getGroups() {
      if (groups == null) {
         groups = new EObjectContainmentWithInverseEList<Group>(Group.class, this, ClusterPackage.GROUP__GROUPS, ClusterPackage.GROUP__PARENT_GROUP);
      }
      return groups;
   }

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<ViewPoint> getViewPointReference() {
		if (viewPointReference == null) {
			viewPointReference = new EObjectResolvingEList<ViewPoint>(ViewPoint.class, this, ClusterPackage.GROUP__VIEW_POINT_REFERENCE){

				/* (non-Javadoc)
				 * @see org.eclipse.emf.common.util.AbstractEList#didAdd(int, java.lang.Object)
				 */
				@Override
				protected void didAdd(int index, ViewPoint newObject) {
					super.didAdd(index, newObject);
					newObject.getContainedInGroup().add(GroupImpl.this);
				}

				/* (non-Javadoc)
				 * @see org.eclipse.emf.common.util.AbstractEList#didRemove(int, java.lang.Object)
				 */
				@Override
				protected void didRemove(int index, ViewPoint oldObject) {
					super.didRemove(index, oldObject);
					oldObject.getContainedInGroup().remove(GroupImpl.this);
				}
				
			};
		}
		return viewPointReference;
	}

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	public Group getParentGroup() {
      if (eContainerFeatureID() != ClusterPackage.GROUP__PARENT_GROUP) return null;
      return (Group)eContainer();
   }

	/**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public NotificationChain basicSetParentGroup(Group newParentGroup, NotificationChain msgs) {
      msgs = eBasicSetContainer((InternalEObject)newParentGroup, ClusterPackage.GROUP__PARENT_GROUP, msgs);
      return msgs;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public void setParentGroup(Group newParentGroup) {
      if (newParentGroup != eInternalContainer() || (eContainerFeatureID() != ClusterPackage.GROUP__PARENT_GROUP && newParentGroup != null)) {
         if (EcoreUtil.isAncestor(this, newParentGroup))
            throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
         NotificationChain msgs = null;
         if (eInternalContainer() != null)
            msgs = eBasicRemoveFromContainer(msgs);
         if (newParentGroup != null)
            msgs = ((InternalEObject)newParentGroup).eInverseAdd(this, ClusterPackage.GROUP__GROUPS, Group.class, msgs);
         msgs = basicSetParentGroup(newParentGroup, msgs);
         if (msgs != null) msgs.dispatch();
      }
      else if (eNotificationRequired())
         eNotify(new ENotificationImpl(this, Notification.SET, ClusterPackage.GROUP__PARENT_GROUP, newParentGroup, newParentGroup));
   }

   /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean checkForRedundantViewPoints(DiagnosticChain eDiagnosticChain, Map<?, ?> eMap) {
		if (checkViewPointViolation()) {
			//find out want viewPoint/s are redundant 
			ViewPoint c = null;
			String redundantViewPoints = "";
			if (this.getViewPointReference().size() == 1) {
				c = this.getViewPointReference().get(0);
			}else{
				EList<ViewPoint> viewPoints = getViewPointReference();
				for (ViewPoint viewPoint : viewPoints) {
					EList<Group> subGroups = getGroups();
					for (Group subGroup : subGroups) {
						if (containsViewPoint(viewPoint, subGroup)) {
							if (redundantViewPoints.length() < 1) {
								redundantViewPoints = viewPoint.getName();
							} else{
								redundantViewPoints = redundantViewPoints + ", " + viewPoint.getName();
							}
						}
					}
				}
			}
			//Build Error/Warning 
			if (eDiagnosticChain != null) {
				if (c != null) {
					eDiagnosticChain.add
					(new BasicDiagnostic
						(Diagnostic.WARNING,
						 ClusterValidator.DIAGNOSTIC_SOURCE,
						 ClusterValidator.GROUP__CHECK_FOR_REDUNDANT_VIEW_POINTS,
						 "The ViewPoint: " + c.getName() + " is also present in an extended subgroup of " + 
								 this.getName() + ", this makes the ViewPoint in this group redundant.\n" +
								 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "checkForRedundantViewPoints", EObjectValidator.getObjectLabel(this,(Map<Object, Object>) eMap) }),
						 new Object [] { this }));
				}else{
					eDiagnosticChain.add
					(new BasicDiagnostic
						(Diagnostic.WARNING,
						 ClusterValidator.DIAGNOSTIC_SOURCE,
						 ClusterValidator.GROUP__CHECK_FOR_REDUNDANT_VIEW_POINTS,
						 "The following ViewPoints ("+ redundantViewPoints + ") are also present in an extended subgroup of\n" + 
								 this.getName() + ", this makes the ViewPoint in this group redundant.\n" + 
								 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "checkForRedundantViewPoints", EObjectValidator.getObjectLabel(this,(Map<Object, Object>) eMap) }),
						 new Object [] { this }));
				}
			}
			return false;
		}
		return true;
	}
	
/**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   @SuppressWarnings("unchecked")
   @Override
   public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
      switch (featureID) {
         case ClusterPackage.GROUP__PARENT_GROUP:
            if (eInternalContainer() != null)
               msgs = eBasicRemoveFromContainer(msgs);
            return basicSetParentGroup((Group)otherEnd, msgs);
         case ClusterPackage.GROUP__GROUPS:
            return ((InternalEList<InternalEObject>)(InternalEList<?>)getGroups()).basicAdd(otherEnd, msgs);
      }
      return super.eInverseAdd(otherEnd, featureID, msgs);
   }

/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
      switch (featureID) {
         case ClusterPackage.GROUP__PARENT_GROUP:
            return basicSetParentGroup(null, msgs);
         case ClusterPackage.GROUP__GROUPS:
            return ((InternalEList<?>)getGroups()).basicRemove(otherEnd, msgs);
      }
      return super.eInverseRemove(otherEnd, featureID, msgs);
   }

	/**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   @Override
   public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
      switch (eContainerFeatureID()) {
         case ClusterPackage.GROUP__PARENT_GROUP:
            return eInternalContainer().eInverseRemove(this, ClusterPackage.GROUP__GROUPS, Group.class, msgs);
      }
      return super.eBasicRemoveFromContainerFeature(msgs);
   }

   /**
	 * returns true if a {@link ViewPoint} found in a sub {@link Group}.
	 * @return true if a {@link ViewPoint} found in a sub {@link Group}.
	 */
	private boolean checkViewPointViolation(){
		EList<ViewPoint> viewPoints = this.getViewPointReference();
		if (viewPoints.size() > 0 && this.getGroups().size() > 0) {
			for (ViewPoint viewPoint : viewPoints) {
				EList<Group> groups = this.getGroups();
				for (Group subGroup : groups) {
					if (containsViewPoint(viewPoint,subGroup)) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
	/**
	 * returns true if a sub group contains the same {@link ViewPoint} as the {@link Group}.
	 * @param viewPoint a {@link ViewPoint} of {@link Group}.
	 * @param subGroup a sub {@link Group} of {@link Group}.
	 * @return true if a sub {@link Group} contains the same {@link ViewPoint} as the {@link Group}.
	 */
	private boolean containsViewPoint(ViewPoint viewPoint, Group subGroup) {
		EList<ViewPoint> viewPoints = subGroup.getViewPointReference();
		for (ViewPoint subViewPoint : viewPoints) {
			if (viewPoint.getName().equals(subViewPoint.getName())) {
				return true;
			}
		}
		EList<Group> subSubGroups = subGroup.getGroups();
		for (Group subSubGroup : subSubGroups) {
			if (containsViewPoint(viewPoint, subSubGroup)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Invoking validation
	 * @param eObject
	 * @return true if there is no violation.
	 */
	public static boolean validateObject(EObject eObject){
		Diagnostic diagnostic = Diagnostician.INSTANCE.validate(eObject);
		return diagnostic.getSeverity() == Diagnostic.OK;
	}
	
	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
      switch (featureID) {
         case ClusterPackage.GROUP__VIEW_POINT_REFERENCE:
            return getViewPointReference();
         case ClusterPackage.GROUP__PARENT_GROUP:
            return getParentGroup();
         case ClusterPackage.GROUP__GROUPS:
            return getGroups();
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
         case ClusterPackage.GROUP__VIEW_POINT_REFERENCE:
            getViewPointReference().clear();
            getViewPointReference().addAll((Collection<? extends ViewPoint>)newValue);
            return;
         case ClusterPackage.GROUP__PARENT_GROUP:
            setParentGroup((Group)newValue);
            return;
         case ClusterPackage.GROUP__GROUPS:
            getGroups().clear();
            getGroups().addAll((Collection<? extends Group>)newValue);
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
         case ClusterPackage.GROUP__VIEW_POINT_REFERENCE:
            getViewPointReference().clear();
            return;
         case ClusterPackage.GROUP__PARENT_GROUP:
            setParentGroup((Group)null);
            return;
         case ClusterPackage.GROUP__GROUPS:
            getGroups().clear();
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
         case ClusterPackage.GROUP__VIEW_POINT_REFERENCE:
            return viewPointReference != null && !viewPointReference.isEmpty();
         case ClusterPackage.GROUP__PARENT_GROUP:
            return getParentGroup() != null;
         case ClusterPackage.GROUP__GROUPS:
            return groups != null && !groups.isEmpty();
      }
      return super.eIsSet(featureID);
   }

} //GroupImpl

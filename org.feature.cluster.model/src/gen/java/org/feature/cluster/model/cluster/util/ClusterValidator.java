/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.feature.cluster.model.cluster.util;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.EObjectValidator;

import org.feature.cluster.model.cluster.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see org.feature.cluster.model.cluster.ClusterPackage
 * @generated
 */
public class ClusterValidator extends EObjectValidator {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final ClusterValidator INSTANCE = new ClusterValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "org.feature.cluster.model.cluster";

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Check For Redundant View Points' of 'Group'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int GROUP__CHECK_FOR_REDUNDANT_VIEW_POINTS = 1;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 1;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants in a derived class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final int DIAGNOSTIC_CODE_COUNT = GENERATED_DIAGNOSTIC_CODE_COUNT;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClusterValidator() {
		super();
	}

	/**
	 * Returns the package of this validator switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EPackage getEPackage() {
	  return ClusterPackage.eINSTANCE;
	}

	/**
	 * Calls <code>validateXXX</code> for the corresponding classifier of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected boolean validate(int classifierID, Object value, DiagnosticChain diagnostics, Map<Object, Object> context) {
		switch (classifierID) {
			case ClusterPackage.CORE_GROUP:
				return validateCoreGroup((CoreGroup)value, diagnostics, context);
			case ClusterPackage.GROUP:
				return validateGroup((Group)value, diagnostics, context);
			case ClusterPackage.VIEW_POINT:
				return validateViewPoint((ViewPoint)value, diagnostics, context);
			case ClusterPackage.ELEMENT:
				return validateElement((Element)value, diagnostics, context);
			case ClusterPackage.IGROUP:
				return validateIGroup((IGroup)value, diagnostics, context);
			case ClusterPackage.GROUP_MODEL:
				return validateGroupModel((GroupModel)value, diagnostics, context);
			case ClusterPackage.VIEW_POINT_CONTAINER:
				return validateViewPointContainer((ViewPointContainer)value, diagnostics, context);
			default:
				return true;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCoreGroup(CoreGroup coreGroup, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(coreGroup, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateGroup(Group group, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(group, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(group, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(group, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(group, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(group, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(group, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(group, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(group, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(group, diagnostics, context);
		if (result || diagnostics != null) result &= validateGroup_checkForRedundantViewPoints(group, diagnostics, context);
		return result;
	}

	/**
	 * Validates the checkForRedundantViewPoints constraint of '<em>Group</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateGroup_checkForRedundantViewPoints(Group group, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return group.checkForRedundantViewPoints(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateViewPoint(ViewPoint viewPoint, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(viewPoint, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateElement(Element element, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(element, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public boolean validateIGroup(IGroup iGroup, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(iGroup, diagnostics, context);
	}

   /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateGroupModel(GroupModel groupModel, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(groupModel, diagnostics, context);
	}

	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateViewPointContainer(ViewPointContainer viewPointContainer, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(viewPointContainer, diagnostics, context);
	}

	/**
	 * Returns the resource locator that will be used to fetch messages for this validator's diagnostics.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		// TODO
		// Specialize this to return a resource locator for messages specific to this validator.
		// Ensure that you remove @generated or mark it @generated NOT
		return super.getResourceLocator();
	}

} //ClusterValidator

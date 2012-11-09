/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.model.constraint.resource.csl.mopp;

public class CslSyntaxCoverageInformationProvider {
	
	public org.eclipse.emf.ecore.EClass[] getClassesWithSyntax() {
		return new org.eclipse.emf.ecore.EClass[] {
			org.feature.model.constraint.ConstraintPackage.eINSTANCE.getConstraint(),
			org.feature.model.constraint.ConstraintPackage.eINSTANCE.getRequire(),
			org.feature.model.constraint.ConstraintPackage.eINSTANCE.getExclude(),
		};
	}
	
	public org.eclipse.emf.ecore.EClass[] getStartSymbols() {
		return new org.eclipse.emf.ecore.EClass[] {
			org.feature.model.constraint.ConstraintPackage.eINSTANCE.getConstraint(),
		};
	}
	
}

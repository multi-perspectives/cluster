/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.multi.perspective.classification.resource.clt.mopp;

public class CltSyntaxCoverageInformationProvider {
	
	public org.eclipse.emf.ecore.EClass[] getClassesWithSyntax() {
		return new org.eclipse.emf.ecore.EClass[] {
			org.feature.multi.perspective.classification.ClassificationPackage.eINSTANCE.getClassificationModel(),
			org.feature.multi.perspective.classification.ClassificationPackage.eINSTANCE.getClassification(),
			org.feature.multi.perspective.classification.ClassificationPackage.eINSTANCE.getClassifiedFeature(),
		};
	}
	
	public org.eclipse.emf.ecore.EClass[] getStartSymbols() {
		return new org.eclipse.emf.ecore.EClass[] {
			org.feature.multi.perspective.classification.ClassificationPackage.eINSTANCE.getClassificationModel(),
		};
	}
	
}

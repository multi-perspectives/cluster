/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.multi.perspective.classification.resource.clt.grammar;

public class CltContainment extends org.feature.multi.perspective.classification.resource.clt.grammar.CltTerminal {
	
	private final org.eclipse.emf.ecore.EClass[] allowedTypes;
	
	public CltContainment(org.eclipse.emf.ecore.EStructuralFeature feature, org.feature.multi.perspective.classification.resource.clt.grammar.CltCardinality cardinality, org.eclipse.emf.ecore.EClass[] allowedTypes, int mandatoryOccurencesAfter) {
		super(feature, cardinality, mandatoryOccurencesAfter);
		this.allowedTypes = allowedTypes;
	}
	
	public org.eclipse.emf.ecore.EClass[] getAllowedTypes() {
		return allowedTypes;
	}
	
	public String toString() {
		String typeRestrictions = null;
		if (allowedTypes != null && allowedTypes.length > 0) {
			typeRestrictions = org.feature.multi.perspective.classification.resource.clt.util.CltStringUtil.explode(allowedTypes, ", ", new org.feature.multi.perspective.classification.resource.clt.ICltFunction1<String, org.eclipse.emf.ecore.EClass>() {
				public String execute(org.eclipse.emf.ecore.EClass eClass) {
					return eClass.getName();
				}
			});
		}
		return getFeature().getName() + (typeRestrictions == null ? "" : "[" + typeRestrictions + "]");
	}
	
}

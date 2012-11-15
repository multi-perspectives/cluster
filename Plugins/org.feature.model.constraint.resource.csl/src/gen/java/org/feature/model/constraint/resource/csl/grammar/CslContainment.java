/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.model.constraint.resource.csl.grammar;

public class CslContainment extends org.feature.model.constraint.resource.csl.grammar.CslTerminal {
	
	private final org.eclipse.emf.ecore.EClass[] allowedTypes;
	
	public CslContainment(org.eclipse.emf.ecore.EStructuralFeature feature, org.feature.model.constraint.resource.csl.grammar.CslCardinality cardinality, org.eclipse.emf.ecore.EClass[] allowedTypes, int mandatoryOccurencesAfter) {
		super(feature, cardinality, mandatoryOccurencesAfter);
		this.allowedTypes = allowedTypes;
	}
	
	public org.eclipse.emf.ecore.EClass[] getAllowedTypes() {
		return allowedTypes;
	}
	
	public String toString() {
		String typeRestrictions = null;
		if (allowedTypes != null && allowedTypes.length > 0) {
			typeRestrictions = org.feature.model.constraint.resource.csl.util.CslStringUtil.explode(allowedTypes, ", ", new org.feature.model.constraint.resource.csl.ICslFunction1<String, org.eclipse.emf.ecore.EClass>() {
				public String execute(org.eclipse.emf.ecore.EClass eClass) {
					return eClass.getName();
				}
			});
		}
		return getFeature().getName() + (typeRestrictions == null ? "" : "[" + typeRestrictions + "]");
	}
	
}

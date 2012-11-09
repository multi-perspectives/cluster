/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.multi.perspective.classification.resource.clt.grammar;

public class CltTerminal extends org.feature.multi.perspective.classification.resource.clt.grammar.CltSyntaxElement {
	
	private final org.eclipse.emf.ecore.EStructuralFeature feature;
	private final int mandatoryOccurencesAfter;
	
	public CltTerminal(org.eclipse.emf.ecore.EStructuralFeature feature, org.feature.multi.perspective.classification.resource.clt.grammar.CltCardinality cardinality, int mandatoryOccurencesAfter) {
		super(cardinality, null);
		this.feature = feature;
		this.mandatoryOccurencesAfter = mandatoryOccurencesAfter;
	}
	
	public org.eclipse.emf.ecore.EStructuralFeature getFeature() {
		return feature;
	}
	
	public int getMandatoryOccurencesAfter() {
		return mandatoryOccurencesAfter;
	}
	
	public String toString() {
		return feature.getName() + "[]";
	}
	
}

/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.model.constraint.resource.csl.grammar;

/**
 * A class to represent placeholders in a grammar.
 */
public class CslPlaceholder extends org.feature.model.constraint.resource.csl.grammar.CslTerminal {
	
	private final String tokenName;
	
	public CslPlaceholder(org.eclipse.emf.ecore.EStructuralFeature feature, String tokenName, org.feature.model.constraint.resource.csl.grammar.CslCardinality cardinality, int mandatoryOccurencesAfter) {
		super(feature, cardinality, mandatoryOccurencesAfter);
		this.tokenName = tokenName;
	}
	
	public String getTokenName() {
		return tokenName;
	}
	
}

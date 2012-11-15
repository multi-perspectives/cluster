/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.multi.perspective.classification.resource.clt.grammar;

/**
 * A class to represent placeholders in a grammar.
 */
public class CltPlaceholder extends org.feature.multi.perspective.classification.resource.clt.grammar.CltTerminal {
	
	private final String tokenName;
	
	public CltPlaceholder(org.eclipse.emf.ecore.EStructuralFeature feature, String tokenName, org.feature.multi.perspective.classification.resource.clt.grammar.CltCardinality cardinality, int mandatoryOccurencesAfter) {
		super(feature, cardinality, mandatoryOccurencesAfter);
		this.tokenName = tokenName;
	}
	
	public String getTokenName() {
		return tokenName;
	}
	
}

/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.multi.perspective.classification.resource.clt.grammar;

/**
 * A class to represent a keyword in the grammar.
 */
public class CltKeyword extends org.feature.multi.perspective.classification.resource.clt.grammar.CltSyntaxElement {
	
	private final String value;
	
	public CltKeyword(String value, org.feature.multi.perspective.classification.resource.clt.grammar.CltCardinality cardinality) {
		super(cardinality, null);
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
	
	public String toString() {
		return value;
	}
	
}

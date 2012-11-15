/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.model.constraint.resource.csl.grammar;

/**
 * A class to represent a keyword in the grammar.
 */
public class CslKeyword extends org.feature.model.constraint.resource.csl.grammar.CslSyntaxElement {
	
	private final String value;
	
	public CslKeyword(String value, org.feature.model.constraint.resource.csl.grammar.CslCardinality cardinality) {
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

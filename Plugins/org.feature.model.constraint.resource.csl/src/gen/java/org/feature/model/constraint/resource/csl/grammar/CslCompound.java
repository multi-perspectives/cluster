/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.model.constraint.resource.csl.grammar;

public class CslCompound extends org.feature.model.constraint.resource.csl.grammar.CslSyntaxElement {
	
	public CslCompound(org.feature.model.constraint.resource.csl.grammar.CslChoice choice, org.feature.model.constraint.resource.csl.grammar.CslCardinality cardinality) {
		super(cardinality, new org.feature.model.constraint.resource.csl.grammar.CslSyntaxElement[] {choice});
	}
	
	public String toString() {
		return "(" + getChildren()[0] + ")";
	}
	
}

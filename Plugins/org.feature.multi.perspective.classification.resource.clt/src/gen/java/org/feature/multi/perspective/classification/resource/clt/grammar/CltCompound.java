/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.multi.perspective.classification.resource.clt.grammar;

public class CltCompound extends org.feature.multi.perspective.classification.resource.clt.grammar.CltSyntaxElement {
	
	public CltCompound(org.feature.multi.perspective.classification.resource.clt.grammar.CltChoice choice, org.feature.multi.perspective.classification.resource.clt.grammar.CltCardinality cardinality) {
		super(cardinality, new org.feature.multi.perspective.classification.resource.clt.grammar.CltSyntaxElement[] {choice});
	}
	
	public String toString() {
		return "(" + getChildren()[0] + ")";
	}
	
}

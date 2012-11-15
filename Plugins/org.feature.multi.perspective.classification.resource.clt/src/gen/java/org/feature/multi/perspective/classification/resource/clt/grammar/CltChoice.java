/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.multi.perspective.classification.resource.clt.grammar;

public class CltChoice extends org.feature.multi.perspective.classification.resource.clt.grammar.CltSyntaxElement {
	
	public CltChoice(org.feature.multi.perspective.classification.resource.clt.grammar.CltCardinality cardinality, org.feature.multi.perspective.classification.resource.clt.grammar.CltSyntaxElement... choices) {
		super(cardinality, choices);
	}
	
	public String toString() {
		return org.feature.multi.perspective.classification.resource.clt.util.CltStringUtil.explode(getChildren(), "|");
	}
	
}

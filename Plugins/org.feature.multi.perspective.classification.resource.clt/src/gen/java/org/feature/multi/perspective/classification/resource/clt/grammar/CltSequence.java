/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.multi.perspective.classification.resource.clt.grammar;

public class CltSequence extends org.feature.multi.perspective.classification.resource.clt.grammar.CltSyntaxElement {
	
	public CltSequence(org.feature.multi.perspective.classification.resource.clt.grammar.CltCardinality cardinality, org.feature.multi.perspective.classification.resource.clt.grammar.CltSyntaxElement... elements) {
		super(cardinality, elements);
	}
	
	public String toString() {
		return org.feature.multi.perspective.classification.resource.clt.util.CltStringUtil.explode(getChildren(), " ");
	}
	
}

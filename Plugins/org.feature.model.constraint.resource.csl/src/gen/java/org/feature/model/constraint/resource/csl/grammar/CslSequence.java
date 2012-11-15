/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.model.constraint.resource.csl.grammar;

public class CslSequence extends org.feature.model.constraint.resource.csl.grammar.CslSyntaxElement {
	
	public CslSequence(org.feature.model.constraint.resource.csl.grammar.CslCardinality cardinality, org.feature.model.constraint.resource.csl.grammar.CslSyntaxElement... elements) {
		super(cardinality, elements);
	}
	
	public String toString() {
		return org.feature.model.constraint.resource.csl.util.CslStringUtil.explode(getChildren(), " ");
	}
	
}

/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.model.constraint.resource.csl.grammar;

public class CslChoice extends org.feature.model.constraint.resource.csl.grammar.CslSyntaxElement {
	
	public CslChoice(org.feature.model.constraint.resource.csl.grammar.CslCardinality cardinality, org.feature.model.constraint.resource.csl.grammar.CslSyntaxElement... choices) {
		super(cardinality, choices);
	}
	
	public String toString() {
		return org.feature.model.constraint.resource.csl.util.CslStringUtil.explode(getChildren(), "|");
	}
	
}

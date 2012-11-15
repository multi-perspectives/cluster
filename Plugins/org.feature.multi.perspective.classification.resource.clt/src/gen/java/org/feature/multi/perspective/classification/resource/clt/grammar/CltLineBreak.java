/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.multi.perspective.classification.resource.clt.grammar;

public class CltLineBreak extends org.feature.multi.perspective.classification.resource.clt.grammar.CltFormattingElement {
	
	private final int tabs;
	
	public CltLineBreak(org.feature.multi.perspective.classification.resource.clt.grammar.CltCardinality cardinality, int tabs) {
		super(cardinality);
		this.tabs = tabs;
	}
	
	public int getTabs() {
		return tabs;
	}
	
	public String toString() {
		return "!" + getTabs();
	}
	
}

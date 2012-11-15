/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.model.constraint.resource.csl.grammar;

public class CslLineBreak extends org.feature.model.constraint.resource.csl.grammar.CslFormattingElement {
	
	private final int tabs;
	
	public CslLineBreak(org.feature.model.constraint.resource.csl.grammar.CslCardinality cardinality, int tabs) {
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

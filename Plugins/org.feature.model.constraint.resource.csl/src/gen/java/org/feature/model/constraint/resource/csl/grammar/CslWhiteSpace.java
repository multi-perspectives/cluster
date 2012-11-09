/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.model.constraint.resource.csl.grammar;

public class CslWhiteSpace extends org.feature.model.constraint.resource.csl.grammar.CslFormattingElement {
	
	private final int amount;
	
	public CslWhiteSpace(int amount, org.feature.model.constraint.resource.csl.grammar.CslCardinality cardinality) {
		super(cardinality);
		this.amount = amount;
	}
	
	public int getAmount() {
		return amount;
	}
	
	public String toString() {
		return "#" + getAmount();
	}
	
}

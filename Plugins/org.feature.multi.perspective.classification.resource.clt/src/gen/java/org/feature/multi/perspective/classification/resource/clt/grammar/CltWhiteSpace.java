/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.multi.perspective.classification.resource.clt.grammar;

public class CltWhiteSpace extends org.feature.multi.perspective.classification.resource.clt.grammar.CltFormattingElement {
	
	private final int amount;
	
	public CltWhiteSpace(int amount, org.feature.multi.perspective.classification.resource.clt.grammar.CltCardinality cardinality) {
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

/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.multi.perspective.classification.resource.clt.mopp;

/**
 * A representation for a range in a document where a keyword (i.e., a static
 * string) is expected.
 */
public class CltExpectedCsString extends org.feature.multi.perspective.classification.resource.clt.mopp.CltAbstractExpectedElement {
	
	private org.feature.multi.perspective.classification.resource.clt.grammar.CltKeyword keyword;
	
	public CltExpectedCsString(org.feature.multi.perspective.classification.resource.clt.grammar.CltKeyword keyword) {
		super(keyword.getMetaclass());
		this.keyword = keyword;
	}
	
	public String getValue() {
		return keyword.getValue();
	}
	
	/**
	 * Returns the expected keyword.
	 */
	public org.feature.multi.perspective.classification.resource.clt.grammar.CltSyntaxElement getSymtaxElement() {
		return keyword;
	}
	
	public java.util.Set<String> getTokenNames() {
		return java.util.Collections.singleton("'" + getValue() + "'");
	}
	
	public String toString() {
		return "CsString \"" + getValue() + "\"";
	}
	
	public boolean equals(Object o) {
		if (o instanceof CltExpectedCsString) {
			return getValue().equals(((CltExpectedCsString) o).getValue());
		}
		return false;
	}
	
	@Override	
	public int hashCode() {
		return getValue().hashCode();
	}
	
}

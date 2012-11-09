/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.model.constraint.resource.csl.mopp;

/**
 * A representation for a range in a document where an enumeration literal (i.e.,
 * a set of static strings) is expected.
 */
public class CslExpectedEnumerationTerminal extends org.feature.model.constraint.resource.csl.mopp.CslAbstractExpectedElement {
	
	private org.feature.model.constraint.resource.csl.grammar.CslEnumerationTerminal enumerationTerminal;
	
	public CslExpectedEnumerationTerminal(org.feature.model.constraint.resource.csl.grammar.CslEnumerationTerminal enumerationTerminal) {
		super(enumerationTerminal.getMetaclass());
		this.enumerationTerminal = enumerationTerminal;
	}
	
	public java.util.Set<String> getTokenNames() {
		// EnumerationTerminals are associated with multiple tokens, one for each literal
		// that was mapped to a string
		java.util.Set<String> tokenNames = new java.util.LinkedHashSet<String>();
		java.util.Map<String, String> mapping = enumerationTerminal.getLiteralMapping();
		for (String literalName : mapping.keySet()) {
			String text = mapping.get(literalName);
			if (text != null && !"".equals(text)) {
				tokenNames.add("'" + text + "'");
			}
		}
		return tokenNames;
	}
	
	public org.feature.model.constraint.resource.csl.grammar.CslEnumerationTerminal getEnumerationTerminal() {
		return this.enumerationTerminal;
	}
	
	/**
	 * Returns the expected enumeration terminal.
	 */
	public org.feature.model.constraint.resource.csl.grammar.CslSyntaxElement getSymtaxElement() {
		return enumerationTerminal;
	}
	
	public String toString() {
		return "EnumTerminal \"" + getEnumerationTerminal() + "\"";
	}
	
}

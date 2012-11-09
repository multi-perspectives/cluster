/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.model.constraint.resource.csl.mopp;

public class CslAntlrScanner implements org.feature.model.constraint.resource.csl.ICslTextScanner {
	
	private org.antlr.runtime3_4_0.Lexer antlrLexer;
	
	public CslAntlrScanner(org.antlr.runtime3_4_0.Lexer antlrLexer) {
		this.antlrLexer = antlrLexer;
	}
	
	public org.feature.model.constraint.resource.csl.ICslTextToken getNextToken() {
		if (antlrLexer.getCharStream() == null) {
			return null;
		}
		final org.antlr.runtime3_4_0.Token current = antlrLexer.nextToken();
		if (current == null || current.getType() < 0) {
			return null;
		}
		org.feature.model.constraint.resource.csl.ICslTextToken result = new org.feature.model.constraint.resource.csl.mopp.CslANTLRTextToken(current);
		return result;
	}
	
	public void setText(String text) {
		antlrLexer.setCharStream(new org.antlr.runtime3_4_0.ANTLRStringStream(text));
	}
	
}

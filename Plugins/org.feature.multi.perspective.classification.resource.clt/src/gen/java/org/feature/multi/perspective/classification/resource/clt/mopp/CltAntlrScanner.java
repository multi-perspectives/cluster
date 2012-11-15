/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.multi.perspective.classification.resource.clt.mopp;

public class CltAntlrScanner implements org.feature.multi.perspective.classification.resource.clt.ICltTextScanner {
	
	private org.antlr.runtime3_4_0.Lexer antlrLexer;
	
	public CltAntlrScanner(org.antlr.runtime3_4_0.Lexer antlrLexer) {
		this.antlrLexer = antlrLexer;
	}
	
	public org.feature.multi.perspective.classification.resource.clt.ICltTextToken getNextToken() {
		if (antlrLexer.getCharStream() == null) {
			return null;
		}
		final org.antlr.runtime3_4_0.Token current = antlrLexer.nextToken();
		if (current == null || current.getType() < 0) {
			return null;
		}
		org.feature.multi.perspective.classification.resource.clt.ICltTextToken result = new org.feature.multi.perspective.classification.resource.clt.mopp.CltANTLRTextToken(current);
		return result;
	}
	
	public void setText(String text) {
		antlrLexer.setCharStream(new org.antlr.runtime3_4_0.ANTLRStringStream(text));
	}
	
}

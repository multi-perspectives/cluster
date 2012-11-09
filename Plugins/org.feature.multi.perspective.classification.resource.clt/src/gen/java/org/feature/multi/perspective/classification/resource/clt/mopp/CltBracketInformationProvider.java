/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.multi.perspective.classification.resource.clt.mopp;

public class CltBracketInformationProvider {
	
	public class BracketPair implements org.feature.multi.perspective.classification.resource.clt.ICltBracketPair {
		
		private String opening;
		private String closing;
		private boolean closingEnabledInside;
		
		public BracketPair(String opening, String closing, boolean closingEnabledInside) {
			super();
			this.opening = opening;
			this.closing = closing;
			this.closingEnabledInside = closingEnabledInside;
		}
		
		public String getOpeningBracket() {
			return opening;
		}
		
		public String getClosingBracket() {
			return closing;
		}
		
		public boolean isClosingEnabledInside() {
			return closingEnabledInside;
		}
	}
	
	public java.util.Collection<org.feature.multi.perspective.classification.resource.clt.ICltBracketPair> getBracketPairs() {
		java.util.Collection<org.feature.multi.perspective.classification.resource.clt.ICltBracketPair> result = new java.util.ArrayList<org.feature.multi.perspective.classification.resource.clt.ICltBracketPair>();
		result.add(new BracketPair("{", "}", true));
		result.add(new BracketPair("<", ">", false));
		result.add(new BracketPair("\"", "\"", false));
		return result;
	}
	
}

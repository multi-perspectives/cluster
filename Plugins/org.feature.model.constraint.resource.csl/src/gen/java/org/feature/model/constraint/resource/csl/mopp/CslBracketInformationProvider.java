/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.model.constraint.resource.csl.mopp;

public class CslBracketInformationProvider {
	
	public class BracketPair implements org.feature.model.constraint.resource.csl.ICslBracketPair {
		
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
	
	public java.util.Collection<org.feature.model.constraint.resource.csl.ICslBracketPair> getBracketPairs() {
		java.util.Collection<org.feature.model.constraint.resource.csl.ICslBracketPair> result = new java.util.ArrayList<org.feature.model.constraint.resource.csl.ICslBracketPair>();
		result.add(new BracketPair("'", "'", false));
		result.add(new BracketPair("\"", "\"", false));
		return result;
	}
	
}

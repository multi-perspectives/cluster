/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.term.propositional.expression.resource.expression.mopp;

public class ExpressionTokenStyleInformationProvider {
	
	public org.emftext.term.propositional.expression.resource.expression.IExpressionTokenStyle getDefaultTokenStyle(String tokenName) {
		if ("or".equals(tokenName)) {
			return new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("and".equals(tokenName)) {
			return new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("not".equals(tokenName)) {
			return new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		return null;
	}
	
}

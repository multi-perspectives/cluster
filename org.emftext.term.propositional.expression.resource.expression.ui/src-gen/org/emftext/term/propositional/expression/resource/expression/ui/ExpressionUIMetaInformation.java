/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.term.propositional.expression.resource.expression.ui;

public class ExpressionUIMetaInformation extends org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionMetaInformation {
	
	public org.emftext.term.propositional.expression.resource.expression.IExpressionHoverTextProvider getHoverTextProvider() {
		return new org.emftext.term.propositional.expression.resource.expression.ui.ExpressionHoverTextProvider();
	}
	
	public org.emftext.term.propositional.expression.resource.expression.ui.ExpressionImageProvider getImageProvider() {
		return org.emftext.term.propositional.expression.resource.expression.ui.ExpressionImageProvider.INSTANCE;
	}
	
	public org.emftext.term.propositional.expression.resource.expression.ui.ExpressionColorManager createColorManager() {
		return new org.emftext.term.propositional.expression.resource.expression.ui.ExpressionColorManager();
	}
	
	/**
	 * @deprecated this method is only provided to preserve API compatibility. Use
	 * createTokenScanner(org.emftext.term.propositional.expression.resource.expression
	 * .IExpressionTextResource,
	 * org.emftext.term.propositional.expression.resource.expression.ui.ExpressionColor
	 * Manager) instead.
	 */
	public org.emftext.term.propositional.expression.resource.expression.ui.ExpressionTokenScanner createTokenScanner(org.emftext.term.propositional.expression.resource.expression.ui.ExpressionColorManager colorManager) {
		return createTokenScanner(null, colorManager);
	}
	
	public org.emftext.term.propositional.expression.resource.expression.ui.ExpressionTokenScanner createTokenScanner(org.emftext.term.propositional.expression.resource.expression.IExpressionTextResource resource, org.emftext.term.propositional.expression.resource.expression.ui.ExpressionColorManager colorManager) {
		return new org.emftext.term.propositional.expression.resource.expression.ui.ExpressionTokenScanner(resource, colorManager);
	}
	
	public org.emftext.term.propositional.expression.resource.expression.ui.ExpressionCodeCompletionHelper createCodeCompletionHelper() {
		return new org.emftext.term.propositional.expression.resource.expression.ui.ExpressionCodeCompletionHelper();
	}
	
}

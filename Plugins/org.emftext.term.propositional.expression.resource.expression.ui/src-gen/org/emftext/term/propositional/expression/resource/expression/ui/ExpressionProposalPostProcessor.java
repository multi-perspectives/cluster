/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.term.propositional.expression.resource.expression.ui;

/**
 * A class which can be overridden to customize code completion proposals.
 */
public class ExpressionProposalPostProcessor {
	
	public java.util.List<org.emftext.term.propositional.expression.resource.expression.ui.ExpressionCompletionProposal> process(java.util.List<org.emftext.term.propositional.expression.resource.expression.ui.ExpressionCompletionProposal> proposals) {
		// the default implementation does returns the proposals as they are
		return proposals;
	}
	
}

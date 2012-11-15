/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.model.constraint.resource.csl.ui;

/**
 * A class which can be overridden to customize code completion proposals.
 */
public class CslProposalPostProcessor {
	
	public java.util.List<org.feature.model.constraint.resource.csl.ui.CslCompletionProposal> process(java.util.List<org.feature.model.constraint.resource.csl.ui.CslCompletionProposal> proposals) {
		// the default implementation does returns the proposals as they are
		return proposals;
	}
	
}

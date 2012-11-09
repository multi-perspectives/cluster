/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.multi.perspective.classification.resource.clt.ui;

/**
 * A class which can be overridden to customize code completion proposals.
 */
public class CltProposalPostProcessor {
	
	public java.util.List<org.feature.multi.perspective.classification.resource.clt.ui.CltCompletionProposal> process(java.util.List<org.feature.multi.perspective.classification.resource.clt.ui.CltCompletionProposal> proposals) {
		// the default implementation does returns the proposals as they are
		return proposals;
	}
	
}

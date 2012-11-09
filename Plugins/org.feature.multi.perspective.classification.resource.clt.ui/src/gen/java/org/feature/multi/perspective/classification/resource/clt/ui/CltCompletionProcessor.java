/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.multi.perspective.classification.resource.clt.ui;

public class CltCompletionProcessor implements org.eclipse.jface.text.contentassist.IContentAssistProcessor {
	
	private org.feature.multi.perspective.classification.resource.clt.ICltResourceProvider resourceProvider;
	private org.feature.multi.perspective.classification.resource.clt.ui.ICltBracketHandlerProvider bracketHandlerProvider;
	
	public CltCompletionProcessor(org.feature.multi.perspective.classification.resource.clt.ICltResourceProvider resourceProvider, org.feature.multi.perspective.classification.resource.clt.ui.ICltBracketHandlerProvider bracketHandlerProvider) {
		this.resourceProvider = resourceProvider;
		this.bracketHandlerProvider = bracketHandlerProvider;
	}
	
	public org.eclipse.jface.text.contentassist.ICompletionProposal[] computeCompletionProposals(org.eclipse.jface.text.ITextViewer viewer, int offset) {
		org.feature.multi.perspective.classification.resource.clt.ICltTextResource textResource = resourceProvider.getResource();
		if (textResource == null) {
			return new org.eclipse.jface.text.contentassist.ICompletionProposal[0];
		}
		String content = viewer.getDocument().get();
		org.feature.multi.perspective.classification.resource.clt.ui.CltCodeCompletionHelper helper = new org.feature.multi.perspective.classification.resource.clt.ui.CltCodeCompletionHelper();
		org.feature.multi.perspective.classification.resource.clt.ui.CltCompletionProposal[] computedProposals = helper.computeCompletionProposals(textResource, content, offset);
		
		// call completion proposal post processor to allow for customizing the proposals
		org.feature.multi.perspective.classification.resource.clt.ui.CltProposalPostProcessor proposalPostProcessor = new org.feature.multi.perspective.classification.resource.clt.ui.CltProposalPostProcessor();
		java.util.List<org.feature.multi.perspective.classification.resource.clt.ui.CltCompletionProposal> computedProposalList = java.util.Arrays.asList(computedProposals);
		java.util.List<org.feature.multi.perspective.classification.resource.clt.ui.CltCompletionProposal> extendedProposalList = proposalPostProcessor.process(computedProposalList);
		if (extendedProposalList == null) {
			extendedProposalList = java.util.Collections.emptyList();
		}
		java.util.List<org.feature.multi.perspective.classification.resource.clt.ui.CltCompletionProposal> finalProposalList = new java.util.ArrayList<org.feature.multi.perspective.classification.resource.clt.ui.CltCompletionProposal>();
		for (org.feature.multi.perspective.classification.resource.clt.ui.CltCompletionProposal proposal : extendedProposalList) {
			if (proposal.getMatchesPrefix()) {
				finalProposalList.add(proposal);
			}
		}
		org.eclipse.jface.text.contentassist.ICompletionProposal[] result = new org.eclipse.jface.text.contentassist.ICompletionProposal[finalProposalList.size()];
		int i = 0;
		for (org.feature.multi.perspective.classification.resource.clt.ui.CltCompletionProposal proposal : finalProposalList) {
			String proposalString = proposal.getInsertString();
			String displayString = proposal.getDisplayString();
			String prefix = proposal.getPrefix();
			org.eclipse.swt.graphics.Image image = proposal.getImage();
			org.eclipse.jface.text.contentassist.IContextInformation info;
			info = new org.eclipse.jface.text.contentassist.ContextInformation(image, proposalString, proposalString);
			int begin = offset - prefix.length();
			int replacementLength = prefix.length();
			// if a closing bracket was automatically inserted right before, we enlarge the
			// replacement length in order to overwrite the bracket.
			org.feature.multi.perspective.classification.resource.clt.ui.ICltBracketHandler bracketHandler = bracketHandlerProvider.getBracketHandler();
			String closingBracket = bracketHandler.getClosingBracket();
			if (bracketHandler.addedClosingBracket() && proposalString.endsWith(closingBracket)) {
				replacementLength += closingBracket.length();
			}
			result[i++] = new org.eclipse.jface.text.contentassist.CompletionProposal(proposalString, begin, replacementLength, proposalString.length(), image, displayString, info, proposalString);
		}
		return result;
	}
	
	public org.eclipse.jface.text.contentassist.IContextInformation[] computeContextInformation(org.eclipse.jface.text.ITextViewer viewer, int offset) {
		return null;
	}
	
	public char[] getCompletionProposalAutoActivationCharacters() {
		return null;
	}
	
	public char[] getContextInformationAutoActivationCharacters() {
		return null;
	}
	
	public org.eclipse.jface.text.contentassist.IContextInformationValidator getContextInformationValidator() {
		return null;
	}
	
	public String getErrorMessage() {
		return null;
	}
}

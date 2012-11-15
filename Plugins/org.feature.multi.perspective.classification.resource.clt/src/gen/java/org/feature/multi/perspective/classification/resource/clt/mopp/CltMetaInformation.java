/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.multi.perspective.classification.resource.clt.mopp;

public class CltMetaInformation implements org.feature.multi.perspective.classification.resource.clt.ICltMetaInformation {
	
	public String getSyntaxName() {
		return "clt";
	}
	
	public String getURI() {
		return "http://www.conper.de/classification";
	}
	
	public org.feature.multi.perspective.classification.resource.clt.ICltTextScanner createLexer() {
		return new org.feature.multi.perspective.classification.resource.clt.mopp.CltAntlrScanner(new org.feature.multi.perspective.classification.resource.clt.mopp.CltLexer());
	}
	
	public org.feature.multi.perspective.classification.resource.clt.ICltTextParser createParser(java.io.InputStream inputStream, String encoding) {
		return new org.feature.multi.perspective.classification.resource.clt.mopp.CltParser().createInstance(inputStream, encoding);
	}
	
	public org.feature.multi.perspective.classification.resource.clt.ICltTextPrinter createPrinter(java.io.OutputStream outputStream, org.feature.multi.perspective.classification.resource.clt.ICltTextResource resource) {
		return new org.feature.multi.perspective.classification.resource.clt.mopp.CltPrinter2(outputStream, resource);
	}
	
	public org.eclipse.emf.ecore.EClass[] getClassesWithSyntax() {
		return new org.feature.multi.perspective.classification.resource.clt.mopp.CltSyntaxCoverageInformationProvider().getClassesWithSyntax();
	}
	
	public org.eclipse.emf.ecore.EClass[] getStartSymbols() {
		return new org.feature.multi.perspective.classification.resource.clt.mopp.CltSyntaxCoverageInformationProvider().getStartSymbols();
	}
	
	public org.feature.multi.perspective.classification.resource.clt.ICltReferenceResolverSwitch getReferenceResolverSwitch() {
		return new org.feature.multi.perspective.classification.resource.clt.mopp.CltReferenceResolverSwitch();
	}
	
	public org.feature.multi.perspective.classification.resource.clt.ICltTokenResolverFactory getTokenResolverFactory() {
		return new org.feature.multi.perspective.classification.resource.clt.mopp.CltTokenResolverFactory();
	}
	
	public String getPathToCSDefinition() {
		return "org.feature.multi.perspective.classification/src/main/model/classification.cs";
	}
	
	public String[] getTokenNames() {
		return org.feature.multi.perspective.classification.resource.clt.mopp.CltParser.tokenNames;
	}
	
	public org.feature.multi.perspective.classification.resource.clt.ICltTokenStyle getDefaultTokenStyle(String tokenName) {
		return new org.feature.multi.perspective.classification.resource.clt.mopp.CltTokenStyleInformationProvider().getDefaultTokenStyle(tokenName);
	}
	
	public java.util.Collection<org.feature.multi.perspective.classification.resource.clt.ICltBracketPair> getBracketPairs() {
		return new org.feature.multi.perspective.classification.resource.clt.mopp.CltBracketInformationProvider().getBracketPairs();
	}
	
	public org.eclipse.emf.ecore.EClass[] getFoldableClasses() {
		return new org.feature.multi.perspective.classification.resource.clt.mopp.CltFoldingInformationProvider().getFoldableClasses();
	}
	
	public org.eclipse.emf.ecore.resource.Resource.Factory createResourceFactory() {
		return new org.feature.multi.perspective.classification.resource.clt.mopp.CltResourceFactory();
	}
	
	public org.feature.multi.perspective.classification.resource.clt.mopp.CltNewFileContentProvider getNewFileContentProvider() {
		return new org.feature.multi.perspective.classification.resource.clt.mopp.CltNewFileContentProvider();
	}
	
	public void registerResourceFactory() {
		org.eclipse.emf.ecore.resource.Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(getSyntaxName(), new org.feature.multi.perspective.classification.resource.clt.mopp.CltResourceFactory());
	}
	
	/**
	 * Returns the key of the option that can be used to register a preprocessor that
	 * is used as a pipe when loading resources. This key is language-specific. To
	 * register one preprocessor for multiple resource types, it must be registered
	 * individually using all keys.
	 */
	public String getInputStreamPreprocessorProviderOptionKey() {
		return getSyntaxName() + "_" + "INPUT_STREAM_PREPROCESSOR_PROVIDER";
	}
	
	/**
	 * Returns the key of the option that can be used to register a post-processors
	 * that are invoked after loading resources. This key is language-specific. To
	 * register one post-processor for multiple resource types, it must be registered
	 * individually using all keys.
	 */
	public String getResourcePostProcessorProviderOptionKey() {
		return getSyntaxName() + "_" + "RESOURCE_POSTPROCESSOR_PROVIDER";
	}
	
	public String getLaunchConfigurationType() {
		return "org.feature.multi.perspective.classification.resource.clt.ui.launchConfigurationType";
	}
	
	public org.feature.multi.perspective.classification.resource.clt.ICltNameProvider createNameProvider() {
		return new org.feature.multi.perspective.classification.resource.clt.analysis.CltDefaultNameProvider();
	}
	
	public String[] getSyntaxHighlightableTokenNames() {
		org.feature.multi.perspective.classification.resource.clt.mopp.CltAntlrTokenHelper tokenHelper = new org.feature.multi.perspective.classification.resource.clt.mopp.CltAntlrTokenHelper();
		java.util.List<String> highlightableTokens = new java.util.ArrayList<String>();
		String[] parserTokenNames = getTokenNames();
		for (int i = 0; i < parserTokenNames.length; i++) {
			// If ANTLR is used we need to normalize the token names
			if (!tokenHelper.canBeUsedForSyntaxHighlighting(i)) {
				continue;
			}
			String tokenName = tokenHelper.getTokenName(parserTokenNames, i);
			if (tokenName == null) {
				continue;
			}
			highlightableTokens.add(tokenName);
		}
		highlightableTokens.add(org.feature.multi.perspective.classification.resource.clt.mopp.CltTokenStyleInformationProvider.TASK_ITEM_TOKEN_NAME);
		return highlightableTokens.toArray(new String[highlightableTokens.size()]);
	}
	
}

/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.model.constraint.resource.csl.mopp;

public class CslMetaInformation implements org.feature.model.constraint.resource.csl.ICslMetaInformation {
	
	public String getSyntaxName() {
		return "csl";
	}
	
	public String getURI() {
		return "http://www.conper.de/constraint";
	}
	
	public org.feature.model.constraint.resource.csl.ICslTextScanner createLexer() {
		return new org.feature.model.constraint.resource.csl.mopp.CslAntlrScanner(new org.feature.model.constraint.resource.csl.mopp.CslLexer());
	}
	
	public org.feature.model.constraint.resource.csl.ICslTextParser createParser(java.io.InputStream inputStream, String encoding) {
		return new org.feature.model.constraint.resource.csl.mopp.CslParser().createInstance(inputStream, encoding);
	}
	
	public org.feature.model.constraint.resource.csl.ICslTextPrinter createPrinter(java.io.OutputStream outputStream, org.feature.model.constraint.resource.csl.ICslTextResource resource) {
		return new org.feature.model.constraint.resource.csl.mopp.CslPrinter2(outputStream, resource);
	}
	
	public org.eclipse.emf.ecore.EClass[] getClassesWithSyntax() {
		return new org.feature.model.constraint.resource.csl.mopp.CslSyntaxCoverageInformationProvider().getClassesWithSyntax();
	}
	
	public org.eclipse.emf.ecore.EClass[] getStartSymbols() {
		return new org.feature.model.constraint.resource.csl.mopp.CslSyntaxCoverageInformationProvider().getStartSymbols();
	}
	
	public org.feature.model.constraint.resource.csl.ICslReferenceResolverSwitch getReferenceResolverSwitch() {
		return new org.feature.model.constraint.resource.csl.mopp.CslReferenceResolverSwitch();
	}
	
	public org.feature.model.constraint.resource.csl.ICslTokenResolverFactory getTokenResolverFactory() {
		return new org.feature.model.constraint.resource.csl.mopp.CslTokenResolverFactory();
	}
	
	public String getPathToCSDefinition() {
		return "org.feature.model.constraint/src/main/model/constraint.cs";
	}
	
	public String[] getTokenNames() {
		return org.feature.model.constraint.resource.csl.mopp.CslParser.tokenNames;
	}
	
	public org.feature.model.constraint.resource.csl.ICslTokenStyle getDefaultTokenStyle(String tokenName) {
		return new org.feature.model.constraint.resource.csl.mopp.CslTokenStyleInformationProvider().getDefaultTokenStyle(tokenName);
	}
	
	public java.util.Collection<org.feature.model.constraint.resource.csl.ICslBracketPair> getBracketPairs() {
		return new org.feature.model.constraint.resource.csl.mopp.CslBracketInformationProvider().getBracketPairs();
	}
	
	public org.eclipse.emf.ecore.EClass[] getFoldableClasses() {
		return new org.feature.model.constraint.resource.csl.mopp.CslFoldingInformationProvider().getFoldableClasses();
	}
	
	public org.eclipse.emf.ecore.resource.Resource.Factory createResourceFactory() {
		return new org.feature.model.constraint.resource.csl.mopp.CslResourceFactory();
	}
	
	public org.feature.model.constraint.resource.csl.mopp.CslNewFileContentProvider getNewFileContentProvider() {
		return new org.feature.model.constraint.resource.csl.mopp.CslNewFileContentProvider();
	}
	
	public void registerResourceFactory() {
		org.eclipse.emf.ecore.resource.Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(getSyntaxName(), new org.feature.model.constraint.resource.csl.mopp.CslResourceFactory());
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
		return "org.feature.model.constraint.resource.csl.ui.launchConfigurationType";
	}
	
	public org.feature.model.constraint.resource.csl.ICslNameProvider createNameProvider() {
		return new org.feature.model.constraint.resource.csl.analysis.CslDefaultNameProvider();
	}
	
	public String[] getSyntaxHighlightableTokenNames() {
		org.feature.model.constraint.resource.csl.mopp.CslAntlrTokenHelper tokenHelper = new org.feature.model.constraint.resource.csl.mopp.CslAntlrTokenHelper();
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
		highlightableTokens.add(org.feature.model.constraint.resource.csl.mopp.CslTokenStyleInformationProvider.TASK_ITEM_TOKEN_NAME);
		return highlightableTokens.toArray(new String[highlightableTokens.size()]);
	}
	
}

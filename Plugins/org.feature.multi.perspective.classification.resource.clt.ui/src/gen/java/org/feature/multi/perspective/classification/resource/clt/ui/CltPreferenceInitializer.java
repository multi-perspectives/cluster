/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.multi.perspective.classification.resource.clt.ui;

/**
 * A class used to initialize default preference values.
 */
public class CltPreferenceInitializer extends org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer {
	
	public void initializeDefaultPreferences() {
		
		initializeDefaultSyntaxHighlighting();
		initializeDefaultBrackets();
		
		org.eclipse.jface.preference.IPreferenceStore store = org.feature.multi.perspective.classification.resource.clt.ui.CltUIPlugin.getDefault().getPreferenceStore();
		// Set default value for matching brackets
		store.setDefault(org.feature.multi.perspective.classification.resource.clt.ui.CltPreferenceConstants.EDITOR_MATCHING_BRACKETS_COLOR, "192,192,192");
		store.setDefault(org.feature.multi.perspective.classification.resource.clt.ui.CltPreferenceConstants.EDITOR_MATCHING_BRACKETS_CHECKBOX, true);
		
	}
	
	private void initializeDefaultBrackets() {
		org.eclipse.jface.preference.IPreferenceStore store = org.feature.multi.perspective.classification.resource.clt.ui.CltUIPlugin.getDefault().getPreferenceStore();
		initializeDefaultBrackets(store, new org.feature.multi.perspective.classification.resource.clt.mopp.CltMetaInformation());
	}
	
	public void initializeDefaultSyntaxHighlighting() {
		org.eclipse.jface.preference.IPreferenceStore store = org.feature.multi.perspective.classification.resource.clt.ui.CltUIPlugin.getDefault().getPreferenceStore();
		initializeDefaultSyntaxHighlighting(store, new org.feature.multi.perspective.classification.resource.clt.mopp.CltMetaInformation());
	}
	
	private void initializeDefaultBrackets(org.eclipse.jface.preference.IPreferenceStore store, org.feature.multi.perspective.classification.resource.clt.ICltMetaInformation metaInformation) {
		String languageId = metaInformation.getSyntaxName();
		// set default brackets for ITextResource bracket set
		org.feature.multi.perspective.classification.resource.clt.ui.CltBracketSet bracketSet = new org.feature.multi.perspective.classification.resource.clt.ui.CltBracketSet(null, null);
		final java.util.Collection<org.feature.multi.perspective.classification.resource.clt.ICltBracketPair> bracketPairs = metaInformation.getBracketPairs();
		if (bracketPairs != null) {
			for (org.feature.multi.perspective.classification.resource.clt.ICltBracketPair bracketPair : bracketPairs) {
				bracketSet.addBracketPair(bracketPair.getOpeningBracket(), bracketPair.getClosingBracket(), bracketPair.isClosingEnabledInside());
			}
		}
		store.setDefault(languageId + org.feature.multi.perspective.classification.resource.clt.ui.CltPreferenceConstants.EDITOR_BRACKETS_SUFFIX, bracketSet.getBracketString());
	}
	
	private void initializeDefaultSyntaxHighlighting(org.eclipse.jface.preference.IPreferenceStore store, org.feature.multi.perspective.classification.resource.clt.mopp.CltMetaInformation metaInformation) {
		String languageId = metaInformation.getSyntaxName();
		String[] tokenNames = metaInformation.getSyntaxHighlightableTokenNames();
		if (tokenNames == null) {
			return;
		}
		for (int i = 0; i < tokenNames.length; i++) {
			String tokenName = tokenNames[i];
			org.feature.multi.perspective.classification.resource.clt.ICltTokenStyle style = metaInformation.getDefaultTokenStyle(tokenName);
			if (style != null) {
				String color = getColorString(style.getColorAsRGB());
				setProperties(store, languageId, tokenName, color, style.isBold(), true, style.isItalic(), style.isStrikethrough(), style.isUnderline());
			} else {
				setProperties(store, languageId, tokenName, "0,0,0", false, false, false, false, false);
			}
		}
	}
	
	private void setProperties(org.eclipse.jface.preference.IPreferenceStore store, String languageID, String tokenName, String color, boolean bold, boolean enable, boolean italic, boolean strikethrough, boolean underline) {
		store.setDefault(org.feature.multi.perspective.classification.resource.clt.ui.CltSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, org.feature.multi.perspective.classification.resource.clt.ui.CltSyntaxColoringHelper.StyleProperty.BOLD), bold);
		store.setDefault(org.feature.multi.perspective.classification.resource.clt.ui.CltSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, org.feature.multi.perspective.classification.resource.clt.ui.CltSyntaxColoringHelper.StyleProperty.COLOR), color);
		store.setDefault(org.feature.multi.perspective.classification.resource.clt.ui.CltSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, org.feature.multi.perspective.classification.resource.clt.ui.CltSyntaxColoringHelper.StyleProperty.ENABLE), enable);
		store.setDefault(org.feature.multi.perspective.classification.resource.clt.ui.CltSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, org.feature.multi.perspective.classification.resource.clt.ui.CltSyntaxColoringHelper.StyleProperty.ITALIC), italic);
		store.setDefault(org.feature.multi.perspective.classification.resource.clt.ui.CltSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, org.feature.multi.perspective.classification.resource.clt.ui.CltSyntaxColoringHelper.StyleProperty.STRIKETHROUGH), strikethrough);
		store.setDefault(org.feature.multi.perspective.classification.resource.clt.ui.CltSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, org.feature.multi.perspective.classification.resource.clt.ui.CltSyntaxColoringHelper.StyleProperty.UNDERLINE), underline);
	}
	
	private String getColorString(int[] colorAsRGB) {
		if (colorAsRGB == null) {
			return "0,0,0";
		}
		if (colorAsRGB.length != 3) {
			return "0,0,0";
		}
		return colorAsRGB[0] + "," +colorAsRGB[1] + ","+ colorAsRGB[2];
	}
}

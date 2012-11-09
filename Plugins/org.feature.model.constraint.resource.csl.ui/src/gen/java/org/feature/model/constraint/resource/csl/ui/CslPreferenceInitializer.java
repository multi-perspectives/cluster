/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.model.constraint.resource.csl.ui;

/**
 * A class used to initialize default preference values.
 */
public class CslPreferenceInitializer extends org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer {
	
	public void initializeDefaultPreferences() {
		
		initializeDefaultSyntaxHighlighting();
		initializeDefaultBrackets();
		
		org.eclipse.jface.preference.IPreferenceStore store = org.feature.model.constraint.resource.csl.ui.CslUIPlugin.getDefault().getPreferenceStore();
		// Set default value for matching brackets
		store.setDefault(org.feature.model.constraint.resource.csl.ui.CslPreferenceConstants.EDITOR_MATCHING_BRACKETS_COLOR, "192,192,192");
		store.setDefault(org.feature.model.constraint.resource.csl.ui.CslPreferenceConstants.EDITOR_MATCHING_BRACKETS_CHECKBOX, true);
		
	}
	
	private void initializeDefaultBrackets() {
		org.eclipse.jface.preference.IPreferenceStore store = org.feature.model.constraint.resource.csl.ui.CslUIPlugin.getDefault().getPreferenceStore();
		initializeDefaultBrackets(store, new org.feature.model.constraint.resource.csl.mopp.CslMetaInformation());
	}
	
	public void initializeDefaultSyntaxHighlighting() {
		org.eclipse.jface.preference.IPreferenceStore store = org.feature.model.constraint.resource.csl.ui.CslUIPlugin.getDefault().getPreferenceStore();
		initializeDefaultSyntaxHighlighting(store, new org.feature.model.constraint.resource.csl.mopp.CslMetaInformation());
	}
	
	private void initializeDefaultBrackets(org.eclipse.jface.preference.IPreferenceStore store, org.feature.model.constraint.resource.csl.ICslMetaInformation metaInformation) {
		String languageId = metaInformation.getSyntaxName();
		// set default brackets for ITextResource bracket set
		org.feature.model.constraint.resource.csl.ui.CslBracketSet bracketSet = new org.feature.model.constraint.resource.csl.ui.CslBracketSet(null, null);
		final java.util.Collection<org.feature.model.constraint.resource.csl.ICslBracketPair> bracketPairs = metaInformation.getBracketPairs();
		if (bracketPairs != null) {
			for (org.feature.model.constraint.resource.csl.ICslBracketPair bracketPair : bracketPairs) {
				bracketSet.addBracketPair(bracketPair.getOpeningBracket(), bracketPair.getClosingBracket(), bracketPair.isClosingEnabledInside());
			}
		}
		store.setDefault(languageId + org.feature.model.constraint.resource.csl.ui.CslPreferenceConstants.EDITOR_BRACKETS_SUFFIX, bracketSet.getBracketString());
	}
	
	private void initializeDefaultSyntaxHighlighting(org.eclipse.jface.preference.IPreferenceStore store, org.feature.model.constraint.resource.csl.mopp.CslMetaInformation metaInformation) {
		String languageId = metaInformation.getSyntaxName();
		String[] tokenNames = metaInformation.getSyntaxHighlightableTokenNames();
		if (tokenNames == null) {
			return;
		}
		for (int i = 0; i < tokenNames.length; i++) {
			String tokenName = tokenNames[i];
			org.feature.model.constraint.resource.csl.ICslTokenStyle style = metaInformation.getDefaultTokenStyle(tokenName);
			if (style != null) {
				String color = getColorString(style.getColorAsRGB());
				setProperties(store, languageId, tokenName, color, style.isBold(), true, style.isItalic(), style.isStrikethrough(), style.isUnderline());
			} else {
				setProperties(store, languageId, tokenName, "0,0,0", false, false, false, false, false);
			}
		}
	}
	
	private void setProperties(org.eclipse.jface.preference.IPreferenceStore store, String languageID, String tokenName, String color, boolean bold, boolean enable, boolean italic, boolean strikethrough, boolean underline) {
		store.setDefault(org.feature.model.constraint.resource.csl.ui.CslSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, org.feature.model.constraint.resource.csl.ui.CslSyntaxColoringHelper.StyleProperty.BOLD), bold);
		store.setDefault(org.feature.model.constraint.resource.csl.ui.CslSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, org.feature.model.constraint.resource.csl.ui.CslSyntaxColoringHelper.StyleProperty.COLOR), color);
		store.setDefault(org.feature.model.constraint.resource.csl.ui.CslSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, org.feature.model.constraint.resource.csl.ui.CslSyntaxColoringHelper.StyleProperty.ENABLE), enable);
		store.setDefault(org.feature.model.constraint.resource.csl.ui.CslSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, org.feature.model.constraint.resource.csl.ui.CslSyntaxColoringHelper.StyleProperty.ITALIC), italic);
		store.setDefault(org.feature.model.constraint.resource.csl.ui.CslSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, org.feature.model.constraint.resource.csl.ui.CslSyntaxColoringHelper.StyleProperty.STRIKETHROUGH), strikethrough);
		store.setDefault(org.feature.model.constraint.resource.csl.ui.CslSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, org.feature.model.constraint.resource.csl.ui.CslSyntaxColoringHelper.StyleProperty.UNDERLINE), underline);
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

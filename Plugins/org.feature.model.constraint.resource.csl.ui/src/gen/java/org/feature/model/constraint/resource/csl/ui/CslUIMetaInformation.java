/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.model.constraint.resource.csl.ui;

public class CslUIMetaInformation extends org.feature.model.constraint.resource.csl.mopp.CslMetaInformation {
	
	public org.feature.model.constraint.resource.csl.ICslHoverTextProvider getHoverTextProvider() {
		return new org.feature.model.constraint.resource.csl.ui.CslHoverTextProvider();
	}
	
	public org.feature.model.constraint.resource.csl.ui.CslImageProvider getImageProvider() {
		return org.feature.model.constraint.resource.csl.ui.CslImageProvider.INSTANCE;
	}
	
	public org.feature.model.constraint.resource.csl.ui.CslColorManager createColorManager() {
		return new org.feature.model.constraint.resource.csl.ui.CslColorManager();
	}
	
	/**
	 * @deprecated this method is only provided to preserve API compatibility. Use
	 * createTokenScanner(org.feature.model.constraint.resource.csl.ICslTextResource,
	 * org.feature.model.constraint.resource.csl.ui.CslColorManager) instead.
	 */
	public org.feature.model.constraint.resource.csl.ui.CslTokenScanner createTokenScanner(org.feature.model.constraint.resource.csl.ui.CslColorManager colorManager) {
		return createTokenScanner(null, colorManager);
	}
	
	public org.feature.model.constraint.resource.csl.ui.CslTokenScanner createTokenScanner(org.feature.model.constraint.resource.csl.ICslTextResource resource, org.feature.model.constraint.resource.csl.ui.CslColorManager colorManager) {
		return new org.feature.model.constraint.resource.csl.ui.CslTokenScanner(resource, colorManager);
	}
	
	public org.feature.model.constraint.resource.csl.ui.CslCodeCompletionHelper createCodeCompletionHelper() {
		return new org.feature.model.constraint.resource.csl.ui.CslCodeCompletionHelper();
	}
	
}

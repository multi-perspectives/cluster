/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.multi.perspective.classification.resource.clt.ui;

public class CltUIMetaInformation extends org.feature.multi.perspective.classification.resource.clt.mopp.CltMetaInformation {
	
	public org.feature.multi.perspective.classification.resource.clt.ICltHoverTextProvider getHoverTextProvider() {
		return new org.feature.multi.perspective.classification.resource.clt.ui.CltHoverTextProvider();
	}
	
	public org.feature.multi.perspective.classification.resource.clt.ui.CltImageProvider getImageProvider() {
		return org.feature.multi.perspective.classification.resource.clt.ui.CltImageProvider.INSTANCE;
	}
	
	public org.feature.multi.perspective.classification.resource.clt.ui.CltColorManager createColorManager() {
		return new org.feature.multi.perspective.classification.resource.clt.ui.CltColorManager();
	}
	
	/**
	 * @deprecated this method is only provided to preserve API compatibility. Use
	 * createTokenScanner(org.feature.multi.perspective.classification.resource.clt.ICl
	 * tTextResource,
	 * org.feature.multi.perspective.classification.resource.clt.ui.CltColorManager)
	 * instead.
	 */
	public org.feature.multi.perspective.classification.resource.clt.ui.CltTokenScanner createTokenScanner(org.feature.multi.perspective.classification.resource.clt.ui.CltColorManager colorManager) {
		return createTokenScanner(null, colorManager);
	}
	
	public org.feature.multi.perspective.classification.resource.clt.ui.CltTokenScanner createTokenScanner(org.feature.multi.perspective.classification.resource.clt.ICltTextResource resource, org.feature.multi.perspective.classification.resource.clt.ui.CltColorManager colorManager) {
		return new org.feature.multi.perspective.classification.resource.clt.ui.CltTokenScanner(resource, colorManager);
	}
	
	public org.feature.multi.perspective.classification.resource.clt.ui.CltCodeCompletionHelper createCodeCompletionHelper() {
		return new org.feature.multi.perspective.classification.resource.clt.ui.CltCodeCompletionHelper();
	}
	
}

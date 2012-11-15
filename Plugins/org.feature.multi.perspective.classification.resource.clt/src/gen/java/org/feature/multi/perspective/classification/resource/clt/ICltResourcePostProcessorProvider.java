/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.multi.perspective.classification.resource.clt;

/**
 * Implementors of this interface can provide a post-processor for text resources.
 */
public interface ICltResourcePostProcessorProvider {
	
	/**
	 * Returns the processor that shall be called after text resource are successfully
	 * parsed.
	 */
	public org.feature.multi.perspective.classification.resource.clt.ICltResourcePostProcessor getResourcePostProcessor();
	
}

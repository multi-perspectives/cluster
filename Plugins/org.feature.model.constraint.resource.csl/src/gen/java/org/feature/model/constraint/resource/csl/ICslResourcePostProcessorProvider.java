/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.model.constraint.resource.csl;

/**
 * Implementors of this interface can provide a post-processor for text resources.
 */
public interface ICslResourcePostProcessorProvider {
	
	/**
	 * Returns the processor that shall be called after text resource are successfully
	 * parsed.
	 */
	public org.feature.model.constraint.resource.csl.ICslResourcePostProcessor getResourcePostProcessor();
	
}

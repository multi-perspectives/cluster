/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.multi.perspective.classification.resource.clt;

/**
 * Implementors of this interface can provide options that are used when resources
 * are loaded.
 */
public interface ICltOptionProvider {
	
	/**
	 * Returns a map of options. The keys are the names of the options, the values are
	 * arbitrary objects that provide additional information or logic for the option.
	 */
	public java.util.Map<?,?> getOptions();
	
}

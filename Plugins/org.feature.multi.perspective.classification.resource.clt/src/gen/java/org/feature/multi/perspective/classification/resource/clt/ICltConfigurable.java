/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.multi.perspective.classification.resource.clt;

/**
 * Implementors of this interface can be configured by a map of options (or
 * parameters).
 */
public interface ICltConfigurable {
	
	/**
	 * Passes the options given by the map to the configurable object.
	 */
	public void setOptions(java.util.Map<?,?> options);
}

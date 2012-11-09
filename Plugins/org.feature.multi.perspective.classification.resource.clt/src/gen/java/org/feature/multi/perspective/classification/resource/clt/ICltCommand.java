/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.multi.perspective.classification.resource.clt;

/**
 * A simple interface for commands that can be executed and that return
 * information about the success of their execution.
 */
public interface ICltCommand<ContextType> {
	
	public boolean execute(ContextType context);
}

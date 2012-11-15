/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.model.constraint.resource.csl;

/**
 * A simple interface for commands that can be executed and that return
 * information about the success of their execution.
 */
public interface ICslCommand<ContextType> {
	
	public boolean execute(ContextType context);
}

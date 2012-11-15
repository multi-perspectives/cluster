/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.model.constraint.resource.csl;

/**
 * An interface used to access the result of parsing a document.
 */
public interface ICslParseResult {
	
	/**
	 * Returns the root object of the document.
	 */
	public org.eclipse.emf.ecore.EObject getRoot();
	
	/**
	 * Returns a list of commands that must be executed after parsing the document.
	 */
	public java.util.Collection<org.feature.model.constraint.resource.csl.ICslCommand<org.feature.model.constraint.resource.csl.ICslTextResource>> getPostParseCommands();
	
}

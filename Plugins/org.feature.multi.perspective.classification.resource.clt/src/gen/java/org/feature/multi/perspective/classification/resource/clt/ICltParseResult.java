/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.multi.perspective.classification.resource.clt;

/**
 * An interface used to access the result of parsing a document.
 */
public interface ICltParseResult {
	
	/**
	 * Returns the root object of the document.
	 */
	public org.eclipse.emf.ecore.EObject getRoot();
	
	/**
	 * Returns a list of commands that must be executed after parsing the document.
	 */
	public java.util.Collection<org.feature.multi.perspective.classification.resource.clt.ICltCommand<org.feature.multi.perspective.classification.resource.clt.ICltTextResource>> getPostParseCommands();
	
}

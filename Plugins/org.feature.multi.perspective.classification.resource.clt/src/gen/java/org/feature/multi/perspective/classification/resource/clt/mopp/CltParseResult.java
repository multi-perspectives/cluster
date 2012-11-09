/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.multi.perspective.classification.resource.clt.mopp;

public class CltParseResult implements org.feature.multi.perspective.classification.resource.clt.ICltParseResult {
	
	private org.eclipse.emf.ecore.EObject root;
	private java.util.Collection<org.feature.multi.perspective.classification.resource.clt.ICltCommand<org.feature.multi.perspective.classification.resource.clt.ICltTextResource>> commands = new java.util.ArrayList<org.feature.multi.perspective.classification.resource.clt.ICltCommand<org.feature.multi.perspective.classification.resource.clt.ICltTextResource>>();
	
	public CltParseResult() {
		super();
	}
	
	public void setRoot(org.eclipse.emf.ecore.EObject root) {
		this.root = root;
	}
	
	public org.eclipse.emf.ecore.EObject getRoot() {
		return root;
	}
	
	public java.util.Collection<org.feature.multi.perspective.classification.resource.clt.ICltCommand<org.feature.multi.perspective.classification.resource.clt.ICltTextResource>> getPostParseCommands() {
		return commands;
	}
	
}

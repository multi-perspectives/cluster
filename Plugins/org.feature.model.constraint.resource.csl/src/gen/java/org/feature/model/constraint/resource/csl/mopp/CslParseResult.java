/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.model.constraint.resource.csl.mopp;

public class CslParseResult implements org.feature.model.constraint.resource.csl.ICslParseResult {
	
	private org.eclipse.emf.ecore.EObject root;
	private java.util.Collection<org.feature.model.constraint.resource.csl.ICslCommand<org.feature.model.constraint.resource.csl.ICslTextResource>> commands = new java.util.ArrayList<org.feature.model.constraint.resource.csl.ICslCommand<org.feature.model.constraint.resource.csl.ICslTextResource>>();
	
	public CslParseResult() {
		super();
	}
	
	public void setRoot(org.eclipse.emf.ecore.EObject root) {
		this.root = root;
	}
	
	public org.eclipse.emf.ecore.EObject getRoot() {
		return root;
	}
	
	public java.util.Collection<org.feature.model.constraint.resource.csl.ICslCommand<org.feature.model.constraint.resource.csl.ICslTextResource>> getPostParseCommands() {
		return commands;
	}
	
}

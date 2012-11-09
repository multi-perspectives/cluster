/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.model.constraint.resource.csl.ui;

public class CslPropertyTester extends org.eclipse.core.expressions.PropertyTester {
	
	public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {
		if (receiver instanceof org.eclipse.core.resources.IResource) {
			org.eclipse.core.resources.IResource resource = (org.eclipse.core.resources.IResource) receiver;
			return hasMatchingURI(resource);
		} else if (receiver instanceof org.eclipse.ui.part.FileEditorInput) {
			org.eclipse.ui.part.FileEditorInput editorInput = (org.eclipse.ui.part.FileEditorInput) receiver;
			org.eclipse.core.resources.IFile file = editorInput.getFile();
			return hasMatchingURI(file);
		}
		return false;
	}
	
	private boolean hasMatchingURI(org.eclipse.core.resources.IResource resource) {
		String path = resource.getLocationURI().getPath();
		return path.endsWith("." + new org.feature.model.constraint.resource.csl.mopp.CslMetaInformation().getSyntaxName());
	}
	
}

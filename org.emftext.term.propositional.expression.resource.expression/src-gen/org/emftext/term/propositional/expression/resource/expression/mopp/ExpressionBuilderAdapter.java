/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.term.propositional.expression.resource.expression.mopp;

public class ExpressionBuilderAdapter extends org.eclipse.core.resources.IncrementalProjectBuilder {
	
	/**
	 * The ID of the default, generated builder.
	 */
	public final static String BUILDER_ID = "org.emftext.term.propositional.expression.resource.expression.builder";
	
	private org.emftext.term.propositional.expression.resource.expression.IExpressionBuilder defaultBuilder = new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionBuilder();
	
	public org.eclipse.core.resources.IProject[] build(int kind, java.util.Map<String, String> args, final org.eclipse.core.runtime.IProgressMonitor monitor) throws org.eclipse.core.runtime.CoreException {
		org.eclipse.core.resources.IResourceDelta delta = getDelta(getProject());
		if (delta == null) {
			return null;
		}
		delta.accept(new org.eclipse.core.resources.IResourceDeltaVisitor() {
			public boolean visit(org.eclipse.core.resources.IResourceDelta delta) throws org.eclipse.core.runtime.CoreException {
				org.eclipse.core.resources.IResource resource = delta.getResource();
				if (delta.getKind() == org.eclipse.core.resources.IResourceDelta.REMOVED) {
					org.eclipse.emf.common.util.URI uri = org.eclipse.emf.common.util.URI.createPlatformResourceURI(resource.getFullPath().toString(), true);
					org.emftext.term.propositional.expression.resource.expression.IExpressionBuilder builder = getBuilder();
					if (builder.isBuildingNeeded(uri)) {
						builder.handleDeletion(uri, monitor);
					}
					new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionMarkerHelper().removeAllMarkers(resource, getBuilderMarkerId());
					return false;
				}
				if (resource instanceof org.eclipse.core.resources.IFile && resource.getName().endsWith("." + new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionMetaInformation().getSyntaxName())) {
					build((org.eclipse.core.resources.IFile) resource, monitor);
					return false;
				}
				return true;
			}
		});
		return null;
	}
	
	public void build(org.eclipse.core.resources.IFile resource, org.eclipse.core.runtime.IProgressMonitor monitor) {
		org.eclipse.emf.common.util.URI uri = org.eclipse.emf.common.util.URI.createPlatformResourceURI(resource.getFullPath().toString(), true);
		org.emftext.term.propositional.expression.resource.expression.IExpressionBuilder builder = getBuilder();
		if (builder.isBuildingNeeded(uri)) {
			org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionResource customResource = (org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionResource) new org.eclipse.emf.ecore.resource.impl.ResourceSetImpl().getResource(uri, true);
			new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionMarkerHelper().removeAllMarkers(resource, getBuilderMarkerId());
			builder.build(customResource, monitor);
		}
	}
	
	/**
	 * Returns the builder that shall be used by this adapter. This allows subclasses
	 * to perform builds with different builders.
	 */
	public org.emftext.term.propositional.expression.resource.expression.IExpressionBuilder getBuilder() {
		return defaultBuilder;
	}
	
	/**
	 * Returns the id for the markers that are created by this builder. This allows
	 * subclasses to produce different kinds of markers.
	 */
	public String getBuilderMarkerId() {
		return org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionMarkerHelper.getMarkerID(org.emftext.term.propositional.expression.resource.expression.ExpressionEProblemType.BUILDER_ERROR);
	}
	
}

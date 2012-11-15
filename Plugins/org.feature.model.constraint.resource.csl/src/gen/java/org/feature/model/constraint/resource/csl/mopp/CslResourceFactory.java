/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.model.constraint.resource.csl.mopp;

public class CslResourceFactory implements org.eclipse.emf.ecore.resource.Resource.Factory {
	
	public CslResourceFactory() {
		super();
	}
	
	public org.eclipse.emf.ecore.resource.Resource createResource(org.eclipse.emf.common.util.URI uri) {
		return new org.feature.model.constraint.resource.csl.mopp.CslResource(uri);
	}
	
}

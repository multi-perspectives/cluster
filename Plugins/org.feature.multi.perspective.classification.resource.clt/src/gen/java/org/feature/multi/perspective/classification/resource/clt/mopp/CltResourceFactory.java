/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.multi.perspective.classification.resource.clt.mopp;

public class CltResourceFactory implements org.eclipse.emf.ecore.resource.Resource.Factory {
	
	public CltResourceFactory() {
		super();
	}
	
	public org.eclipse.emf.ecore.resource.Resource createResource(org.eclipse.emf.common.util.URI uri) {
		return new org.feature.multi.perspective.classification.resource.clt.mopp.CltResource(uri);
	}
	
}

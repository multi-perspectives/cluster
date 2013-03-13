/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.multi.perspective.classification.resource.clt.analysis;

public class CltTEXTTokenResolver implements org.feature.multi.perspective.classification.resource.clt.ICltTokenResolver {
	
	private org.feature.multi.perspective.classification.resource.clt.analysis.CltDefaultTokenResolver defaultTokenResolver = new org.feature.multi.perspective.classification.resource.clt.analysis.CltDefaultTokenResolver(true);
	
	public String deResolve(Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		// By default token de-resolving is delegated to the DefaultTokenResolver.
		String result = defaultTokenResolver.deResolve(value, feature, container, null, null, null);
		return result;
	}
	
	public void resolve(String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, org.feature.multi.perspective.classification.resource.clt.ICltTokenResolveResult result) {
		// By default token resolving is delegated to the DefaultTokenResolver.
		defaultTokenResolver.resolve(lexem, feature, result, null, null, null);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		defaultTokenResolver.setOptions(options);
	}
	
}

/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.model.constraint.resource.csl.analysis;

public class CslQUOTED_39_39TokenResolver implements org.feature.model.constraint.resource.csl.ICslTokenResolver {
	
	private org.feature.model.constraint.resource.csl.analysis.CslDefaultTokenResolver defaultTokenResolver = new org.feature.model.constraint.resource.csl.analysis.CslDefaultTokenResolver(true);
	
	public String deResolve(Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		// By default token de-resolving is delegated to the DefaultTokenResolver.
		String result = defaultTokenResolver.deResolve(value, feature, container, "'", "'", null);
		return result;
	}
	
	public void resolve(String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, org.feature.model.constraint.resource.csl.ICslTokenResolveResult result) {
		// By default token resolving is delegated to the DefaultTokenResolver.
		defaultTokenResolver.resolve(lexem, feature, result, "'", "'", null);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		defaultTokenResolver.setOptions(options);
	}
	
}

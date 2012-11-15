/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.model.constraint.resource.csl.mopp;

/**
 * The CslTokenResolverFactory class provides access to all generated token
 * resolvers. By giving the name of a defined token, the corresponding resolve can
 * be obtained. Despite the fact that this class is called TokenResolverFactory is
 * does NOT create new token resolvers whenever a client calls methods to obtain a
 * resolver. Rather, this class maintains a map of all resolvers and creates each
 * resolver at most once.
 */
public class CslTokenResolverFactory implements org.feature.model.constraint.resource.csl.ICslTokenResolverFactory {
	
	private java.util.Map<String, org.feature.model.constraint.resource.csl.ICslTokenResolver> tokenName2TokenResolver;
	private java.util.Map<String, org.feature.model.constraint.resource.csl.ICslTokenResolver> featureName2CollectInTokenResolver;
	private static org.feature.model.constraint.resource.csl.ICslTokenResolver defaultResolver = new org.feature.model.constraint.resource.csl.analysis.CslDefaultTokenResolver();
	
	public CslTokenResolverFactory() {
		tokenName2TokenResolver = new java.util.LinkedHashMap<String, org.feature.model.constraint.resource.csl.ICslTokenResolver>();
		featureName2CollectInTokenResolver = new java.util.LinkedHashMap<String, org.feature.model.constraint.resource.csl.ICslTokenResolver>();
		registerTokenResolver("QUOTED_34_34", new org.feature.model.constraint.resource.csl.analysis.CslQUOTED_34_34TokenResolver());
	}
	
	public org.feature.model.constraint.resource.csl.ICslTokenResolver createTokenResolver(String tokenName) {
		return internalCreateResolver(tokenName2TokenResolver, tokenName);
	}
	
	public org.feature.model.constraint.resource.csl.ICslTokenResolver createCollectInTokenResolver(String featureName) {
		return internalCreateResolver(featureName2CollectInTokenResolver, featureName);
	}
	
	protected boolean registerTokenResolver(String tokenName, org.feature.model.constraint.resource.csl.ICslTokenResolver resolver){
		return internalRegisterTokenResolver(tokenName2TokenResolver, tokenName, resolver);
	}
	
	protected boolean registerCollectInTokenResolver(String featureName, org.feature.model.constraint.resource.csl.ICslTokenResolver resolver){
		return internalRegisterTokenResolver(featureName2CollectInTokenResolver, featureName, resolver);
	}
	
	protected org.feature.model.constraint.resource.csl.ICslTokenResolver deRegisterTokenResolver(String tokenName){
		return tokenName2TokenResolver.remove(tokenName);
	}
	
	private org.feature.model.constraint.resource.csl.ICslTokenResolver internalCreateResolver(java.util.Map<String, org.feature.model.constraint.resource.csl.ICslTokenResolver> resolverMap, String key) {
		if (resolverMap.containsKey(key)){
			return resolverMap.get(key);
		} else {
			return defaultResolver;
		}
	}
	
	private boolean internalRegisterTokenResolver(java.util.Map<String, org.feature.model.constraint.resource.csl.ICslTokenResolver> resolverMap, String key, org.feature.model.constraint.resource.csl.ICslTokenResolver resolver) {
		if (!resolverMap.containsKey(key)) {
			resolverMap.put(key,resolver);
			return true;
		}
		return false;
	}
	
}

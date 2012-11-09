/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.multi.perspective.classification.resource.clt.mopp;

/**
 * The CltTokenResolverFactory class provides access to all generated token
 * resolvers. By giving the name of a defined token, the corresponding resolve can
 * be obtained. Despite the fact that this class is called TokenResolverFactory is
 * does NOT create new token resolvers whenever a client calls methods to obtain a
 * resolver. Rather, this class maintains a map of all resolvers and creates each
 * resolver at most once.
 */
public class CltTokenResolverFactory implements org.feature.multi.perspective.classification.resource.clt.ICltTokenResolverFactory {
	
	private java.util.Map<String, org.feature.multi.perspective.classification.resource.clt.ICltTokenResolver> tokenName2TokenResolver;
	private java.util.Map<String, org.feature.multi.perspective.classification.resource.clt.ICltTokenResolver> featureName2CollectInTokenResolver;
	private static org.feature.multi.perspective.classification.resource.clt.ICltTokenResolver defaultResolver = new org.feature.multi.perspective.classification.resource.clt.analysis.CltDefaultTokenResolver();
	
	public CltTokenResolverFactory() {
		tokenName2TokenResolver = new java.util.LinkedHashMap<String, org.feature.multi.perspective.classification.resource.clt.ICltTokenResolver>();
		featureName2CollectInTokenResolver = new java.util.LinkedHashMap<String, org.feature.multi.perspective.classification.resource.clt.ICltTokenResolver>();
		registerTokenResolver("QUOTED_60_62", new org.feature.multi.perspective.classification.resource.clt.analysis.CltQUOTED_60_62TokenResolver());
		registerTokenResolver("QUOTED_34_34", new org.feature.multi.perspective.classification.resource.clt.analysis.CltQUOTED_34_34TokenResolver());
	}
	
	public org.feature.multi.perspective.classification.resource.clt.ICltTokenResolver createTokenResolver(String tokenName) {
		return internalCreateResolver(tokenName2TokenResolver, tokenName);
	}
	
	public org.feature.multi.perspective.classification.resource.clt.ICltTokenResolver createCollectInTokenResolver(String featureName) {
		return internalCreateResolver(featureName2CollectInTokenResolver, featureName);
	}
	
	protected boolean registerTokenResolver(String tokenName, org.feature.multi.perspective.classification.resource.clt.ICltTokenResolver resolver){
		return internalRegisterTokenResolver(tokenName2TokenResolver, tokenName, resolver);
	}
	
	protected boolean registerCollectInTokenResolver(String featureName, org.feature.multi.perspective.classification.resource.clt.ICltTokenResolver resolver){
		return internalRegisterTokenResolver(featureName2CollectInTokenResolver, featureName, resolver);
	}
	
	protected org.feature.multi.perspective.classification.resource.clt.ICltTokenResolver deRegisterTokenResolver(String tokenName){
		return tokenName2TokenResolver.remove(tokenName);
	}
	
	private org.feature.multi.perspective.classification.resource.clt.ICltTokenResolver internalCreateResolver(java.util.Map<String, org.feature.multi.perspective.classification.resource.clt.ICltTokenResolver> resolverMap, String key) {
		if (resolverMap.containsKey(key)){
			return resolverMap.get(key);
		} else {
			return defaultResolver;
		}
	}
	
	private boolean internalRegisterTokenResolver(java.util.Map<String, org.feature.multi.perspective.classification.resource.clt.ICltTokenResolver> resolverMap, String key, org.feature.multi.perspective.classification.resource.clt.ICltTokenResolver resolver) {
		if (!resolverMap.containsKey(key)) {
			resolverMap.put(key,resolver);
			return true;
		}
		return false;
	}
	
}

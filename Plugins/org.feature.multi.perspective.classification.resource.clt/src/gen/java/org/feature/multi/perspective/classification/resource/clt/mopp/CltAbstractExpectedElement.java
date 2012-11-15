/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.multi.perspective.classification.resource.clt.mopp;

/**
 * Abstract super class for all expected elements. Provides methods to add
 * followers.
 */
public abstract class CltAbstractExpectedElement implements org.feature.multi.perspective.classification.resource.clt.ICltExpectedElement {
	
	private org.eclipse.emf.ecore.EClass ruleMetaclass;
	
	private java.util.Set<org.feature.multi.perspective.classification.resource.clt.util.CltPair<org.feature.multi.perspective.classification.resource.clt.ICltExpectedElement, org.feature.multi.perspective.classification.resource.clt.mopp.CltContainedFeature[]>> followers = new java.util.LinkedHashSet<org.feature.multi.perspective.classification.resource.clt.util.CltPair<org.feature.multi.perspective.classification.resource.clt.ICltExpectedElement, org.feature.multi.perspective.classification.resource.clt.mopp.CltContainedFeature[]>>();
	
	public CltAbstractExpectedElement(org.eclipse.emf.ecore.EClass ruleMetaclass) {
		super();
		this.ruleMetaclass = ruleMetaclass;
	}
	
	public org.eclipse.emf.ecore.EClass getRuleMetaclass() {
		return ruleMetaclass;
	}
	
	public void addFollower(org.feature.multi.perspective.classification.resource.clt.ICltExpectedElement follower, org.feature.multi.perspective.classification.resource.clt.mopp.CltContainedFeature[] path) {
		followers.add(new org.feature.multi.perspective.classification.resource.clt.util.CltPair<org.feature.multi.perspective.classification.resource.clt.ICltExpectedElement, org.feature.multi.perspective.classification.resource.clt.mopp.CltContainedFeature[]>(follower, path));
	}
	
	public java.util.Collection<org.feature.multi.perspective.classification.resource.clt.util.CltPair<org.feature.multi.perspective.classification.resource.clt.ICltExpectedElement, org.feature.multi.perspective.classification.resource.clt.mopp.CltContainedFeature[]>> getFollowers() {
		return followers;
	}
	
}

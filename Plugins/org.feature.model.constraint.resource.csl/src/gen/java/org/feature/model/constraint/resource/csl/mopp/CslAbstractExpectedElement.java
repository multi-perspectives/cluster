/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.model.constraint.resource.csl.mopp;

/**
 * Abstract super class for all expected elements. Provides methods to add
 * followers.
 */
public abstract class CslAbstractExpectedElement implements org.feature.model.constraint.resource.csl.ICslExpectedElement {
	
	private org.eclipse.emf.ecore.EClass ruleMetaclass;
	
	private java.util.Set<org.feature.model.constraint.resource.csl.util.CslPair<org.feature.model.constraint.resource.csl.ICslExpectedElement, org.feature.model.constraint.resource.csl.mopp.CslContainedFeature[]>> followers = new java.util.LinkedHashSet<org.feature.model.constraint.resource.csl.util.CslPair<org.feature.model.constraint.resource.csl.ICslExpectedElement, org.feature.model.constraint.resource.csl.mopp.CslContainedFeature[]>>();
	
	public CslAbstractExpectedElement(org.eclipse.emf.ecore.EClass ruleMetaclass) {
		super();
		this.ruleMetaclass = ruleMetaclass;
	}
	
	public org.eclipse.emf.ecore.EClass getRuleMetaclass() {
		return ruleMetaclass;
	}
	
	public void addFollower(org.feature.model.constraint.resource.csl.ICslExpectedElement follower, org.feature.model.constraint.resource.csl.mopp.CslContainedFeature[] path) {
		followers.add(new org.feature.model.constraint.resource.csl.util.CslPair<org.feature.model.constraint.resource.csl.ICslExpectedElement, org.feature.model.constraint.resource.csl.mopp.CslContainedFeature[]>(follower, path));
	}
	
	public java.util.Collection<org.feature.model.constraint.resource.csl.util.CslPair<org.feature.model.constraint.resource.csl.ICslExpectedElement, org.feature.model.constraint.resource.csl.mopp.CslContainedFeature[]>> getFollowers() {
		return followers;
	}
	
}

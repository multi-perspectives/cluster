/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.model.constraint.resource.csl;

/**
 * An element that is expected at a given position in a resource stream.
 */
public interface ICslExpectedElement {
	
	/**
	 * Returns the names of all tokens that are expected at the given position.
	 */
	public java.util.Set<String> getTokenNames();
	
	/**
	 * Returns the metaclass of the rule that contains the expected element.
	 */
	public org.eclipse.emf.ecore.EClass getRuleMetaclass();
	
	/**
	 * Returns the syntax element that is expected.
	 */
	public org.feature.model.constraint.resource.csl.grammar.CslSyntaxElement getSymtaxElement();
	
	/**
	 * Adds an element that is a valid follower for this element.
	 */
	public void addFollower(org.feature.model.constraint.resource.csl.ICslExpectedElement follower, org.feature.model.constraint.resource.csl.mopp.CslContainedFeature[] path);
	
	/**
	 * Returns all valid followers for this element. Each follower is represented by a
	 * pair of an expected elements and the containment trace that leads from the
	 * current element to the follower.
	 */
	public java.util.Collection<org.feature.model.constraint.resource.csl.util.CslPair<org.feature.model.constraint.resource.csl.ICslExpectedElement, org.feature.model.constraint.resource.csl.mopp.CslContainedFeature[]>> getFollowers();
	
}

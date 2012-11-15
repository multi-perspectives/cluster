/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.multi.perspective.classification.resource.clt;

/**
 * An element that is expected at a given position in a resource stream.
 */
public interface ICltExpectedElement {
	
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
	public org.feature.multi.perspective.classification.resource.clt.grammar.CltSyntaxElement getSymtaxElement();
	
	/**
	 * Adds an element that is a valid follower for this element.
	 */
	public void addFollower(org.feature.multi.perspective.classification.resource.clt.ICltExpectedElement follower, org.feature.multi.perspective.classification.resource.clt.mopp.CltContainedFeature[] path);
	
	/**
	 * Returns all valid followers for this element. Each follower is represented by a
	 * pair of an expected elements and the containment trace that leads from the
	 * current element to the follower.
	 */
	public java.util.Collection<org.feature.multi.perspective.classification.resource.clt.util.CltPair<org.feature.multi.perspective.classification.resource.clt.ICltExpectedElement, org.feature.multi.perspective.classification.resource.clt.mopp.CltContainedFeature[]>> getFollowers();
	
}

/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.model.constraint.resource.csl.grammar;

/**
 * The abstract super class for all elements of a grammar. This class provides
 * methods to traverse the grammar rules.
 */
public abstract class CslSyntaxElement {
	
	private CslSyntaxElement[] children;
	private CslSyntaxElement parent;
	private org.feature.model.constraint.resource.csl.grammar.CslCardinality cardinality;
	
	public CslSyntaxElement(org.feature.model.constraint.resource.csl.grammar.CslCardinality cardinality, CslSyntaxElement[] children) {
		this.cardinality = cardinality;
		this.children = children;
		if (this.children != null) {
			for (CslSyntaxElement child : this.children) {
				child.setParent(this);
			}
		}
	}
	
	/**
	 * Sets the parent of this syntax element. This method must be invoked at most
	 * once.
	 */
	public void setParent(CslSyntaxElement parent) {
		assert this.parent == null;
		this.parent = parent;
	}
	
	/**
	 * Returns the parent of this syntax element. This parent is determined by the
	 * containment hierarchy in the CS model.
	 */
	public CslSyntaxElement getParent() {
		return parent;
	}
	
	public CslSyntaxElement[] getChildren() {
		if (children == null) {
			return new CslSyntaxElement[0];
		}
		return children;
	}
	
	public org.eclipse.emf.ecore.EClass getMetaclass() {
		return parent.getMetaclass();
	}
	
	public org.feature.model.constraint.resource.csl.grammar.CslCardinality getCardinality() {
		return cardinality;
	}
	
}

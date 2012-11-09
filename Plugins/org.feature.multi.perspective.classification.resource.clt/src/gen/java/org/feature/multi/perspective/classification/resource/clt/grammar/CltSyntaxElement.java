/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.multi.perspective.classification.resource.clt.grammar;

/**
 * The abstract super class for all elements of a grammar. This class provides
 * methods to traverse the grammar rules.
 */
public abstract class CltSyntaxElement {
	
	private CltSyntaxElement[] children;
	private CltSyntaxElement parent;
	private org.feature.multi.perspective.classification.resource.clt.grammar.CltCardinality cardinality;
	
	public CltSyntaxElement(org.feature.multi.perspective.classification.resource.clt.grammar.CltCardinality cardinality, CltSyntaxElement[] children) {
		this.cardinality = cardinality;
		this.children = children;
		if (this.children != null) {
			for (CltSyntaxElement child : this.children) {
				child.setParent(this);
			}
		}
	}
	
	/**
	 * Sets the parent of this syntax element. This method must be invoked at most
	 * once.
	 */
	public void setParent(CltSyntaxElement parent) {
		assert this.parent == null;
		this.parent = parent;
	}
	
	/**
	 * Returns the parent of this syntax element. This parent is determined by the
	 * containment hierarchy in the CS model.
	 */
	public CltSyntaxElement getParent() {
		return parent;
	}
	
	public CltSyntaxElement[] getChildren() {
		if (children == null) {
			return new CltSyntaxElement[0];
		}
		return children;
	}
	
	public org.eclipse.emf.ecore.EClass getMetaclass() {
		return parent.getMetaclass();
	}
	
	public org.feature.multi.perspective.classification.resource.clt.grammar.CltCardinality getCardinality() {
		return cardinality;
	}
	
}

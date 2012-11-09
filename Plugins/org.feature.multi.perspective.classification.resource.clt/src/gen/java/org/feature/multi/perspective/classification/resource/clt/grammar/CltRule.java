/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.multi.perspective.classification.resource.clt.grammar;

/**
 * A class to represent a rules in the grammar.
 */
public class CltRule extends org.feature.multi.perspective.classification.resource.clt.grammar.CltSyntaxElement {
	
	private final org.eclipse.emf.ecore.EClass metaclass;
	
	public CltRule(org.eclipse.emf.ecore.EClass metaclass, org.feature.multi.perspective.classification.resource.clt.grammar.CltChoice choice, org.feature.multi.perspective.classification.resource.clt.grammar.CltCardinality cardinality) {
		super(cardinality, new org.feature.multi.perspective.classification.resource.clt.grammar.CltSyntaxElement[] {choice});
		this.metaclass = metaclass;
	}
	
	public org.eclipse.emf.ecore.EClass getMetaclass() {
		return metaclass;
	}
	
	public org.feature.multi.perspective.classification.resource.clt.grammar.CltChoice getDefinition() {
		return (org.feature.multi.perspective.classification.resource.clt.grammar.CltChoice) getChildren()[0];
	}
	
}


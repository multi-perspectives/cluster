/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.model.constraint.resource.csl.grammar;

/**
 * A class to represent a rules in the grammar.
 */
public class CslRule extends org.feature.model.constraint.resource.csl.grammar.CslSyntaxElement {
	
	private final org.eclipse.emf.ecore.EClass metaclass;
	
	public CslRule(org.eclipse.emf.ecore.EClass metaclass, org.feature.model.constraint.resource.csl.grammar.CslChoice choice, org.feature.model.constraint.resource.csl.grammar.CslCardinality cardinality) {
		super(cardinality, new org.feature.model.constraint.resource.csl.grammar.CslSyntaxElement[] {choice});
		this.metaclass = metaclass;
	}
	
	public org.eclipse.emf.ecore.EClass getMetaclass() {
		return metaclass;
	}
	
	public org.feature.model.constraint.resource.csl.grammar.CslChoice getDefinition() {
		return (org.feature.model.constraint.resource.csl.grammar.CslChoice) getChildren()[0];
	}
	
}


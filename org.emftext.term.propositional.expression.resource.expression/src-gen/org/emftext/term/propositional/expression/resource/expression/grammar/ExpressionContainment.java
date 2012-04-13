/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.term.propositional.expression.resource.expression.grammar;

public class ExpressionContainment extends org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionTerminal {
	
	public ExpressionContainment(org.eclipse.emf.ecore.EStructuralFeature feature, org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionCardinality cardinality, int mandatoryOccurencesAfter) {
		super(feature, cardinality, mandatoryOccurencesAfter);
	}
	
	public String toString() {
		return getFeature().getName();
	}
	
}

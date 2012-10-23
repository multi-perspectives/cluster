/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.term.propositional.expression.resource.expression.grammar;

/**
 * This class provides the follow sets for all terminals of the grammar. These
 * sets are used during code completion.
 */
public class ExpressionFollowSetProvider {
	
	public final static org.emftext.term.propositional.expression.resource.expression.IExpressionExpectedElement TERMINAL_0 = new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionExpectedCsString(org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionGrammarInformationProvider.EXPRESSION_3_0_0_0);
	public final static org.emftext.term.propositional.expression.resource.expression.IExpressionExpectedElement TERMINAL_1 = new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionExpectedCsString(org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionGrammarInformationProvider.EXPRESSION_4_0_0_0);
	public final static org.emftext.term.propositional.expression.resource.expression.IExpressionExpectedElement TERMINAL_2 = new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionExpectedStructuralFeature(org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionGrammarInformationProvider.EXPRESSION_5_0_0_0);
	public final static org.emftext.term.propositional.expression.resource.expression.IExpressionExpectedElement TERMINAL_3 = new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionExpectedCsString(org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionGrammarInformationProvider.EXPRESSION_1_0_0_1);
	public final static org.emftext.term.propositional.expression.resource.expression.IExpressionExpectedElement TERMINAL_4 = new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionExpectedCsString(org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionGrammarInformationProvider.EXPRESSION_2_0_0_1);
	public final static org.emftext.term.propositional.expression.resource.expression.IExpressionExpectedElement TERMINAL_5 = new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionExpectedCsString(org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionGrammarInformationProvider.EXPRESSION_4_0_0_2);
	
	public final static org.eclipse.emf.ecore.EStructuralFeature FEATURE_0 = org.emftext.term.propositional.expression.TermPackage.eINSTANCE.getBinaryOperator().getEStructuralFeature(org.emftext.term.propositional.expression.TermPackage.BINARY_OPERATOR__OPERAND1);
	public final static org.eclipse.emf.ecore.EStructuralFeature FEATURE_1 = org.emftext.term.propositional.expression.TermPackage.eINSTANCE.getConstraint().getEStructuralFeature(org.emftext.term.propositional.expression.TermPackage.CONSTRAINT__TERM);
	public final static org.eclipse.emf.ecore.EStructuralFeature FEATURE_2 = org.emftext.term.propositional.expression.TermPackage.eINSTANCE.getBinaryOperator().getEStructuralFeature(org.emftext.term.propositional.expression.TermPackage.BINARY_OPERATOR__OPERAND2);
	public final static org.eclipse.emf.ecore.EStructuralFeature FEATURE_3 = org.emftext.term.propositional.expression.TermPackage.eINSTANCE.getUnaryOperator().getEStructuralFeature(org.emftext.term.propositional.expression.TermPackage.UNARY_OPERATOR__OPERAND);
	
	public final static org.eclipse.emf.ecore.EStructuralFeature[] EMPTY_FEATURE_ARRAY = new org.eclipse.emf.ecore.EStructuralFeature[0];
	
	public static void wire0() {
		TERMINAL_3.addFollower(TERMINAL_0, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_0, FEATURE_0, FEATURE_2, });
		TERMINAL_3.addFollower(TERMINAL_1, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_0, FEATURE_0, FEATURE_2, });
		TERMINAL_3.addFollower(TERMINAL_2, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_0, FEATURE_0, FEATURE_2, });
		TERMINAL_4.addFollower(TERMINAL_0, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_0, FEATURE_0, FEATURE_2, });
		TERMINAL_4.addFollower(TERMINAL_1, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_0, FEATURE_0, FEATURE_2, });
		TERMINAL_4.addFollower(TERMINAL_2, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_0, FEATURE_0, FEATURE_2, });
		TERMINAL_0.addFollower(TERMINAL_0, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_0, FEATURE_0, FEATURE_3, });
		TERMINAL_0.addFollower(TERMINAL_1, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_0, FEATURE_0, FEATURE_3, });
		TERMINAL_0.addFollower(TERMINAL_2, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_0, FEATURE_0, FEATURE_3, });
		TERMINAL_1.addFollower(TERMINAL_0, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_0, FEATURE_0, FEATURE_3, });
		TERMINAL_1.addFollower(TERMINAL_1, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_0, FEATURE_0, FEATURE_3, });
		TERMINAL_1.addFollower(TERMINAL_2, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_0, FEATURE_0, FEATURE_3, });
		TERMINAL_5.addFollower(TERMINAL_3, EMPTY_FEATURE_ARRAY);
		TERMINAL_5.addFollower(TERMINAL_4, EMPTY_FEATURE_ARRAY);
		TERMINAL_5.addFollower(TERMINAL_5, EMPTY_FEATURE_ARRAY);
		TERMINAL_2.addFollower(TERMINAL_3, EMPTY_FEATURE_ARRAY);
		TERMINAL_2.addFollower(TERMINAL_4, EMPTY_FEATURE_ARRAY);
		TERMINAL_2.addFollower(TERMINAL_5, EMPTY_FEATURE_ARRAY);
	}
	// wire the terminals
	static {
		wire0();
	}
}

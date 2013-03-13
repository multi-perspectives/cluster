/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.model.constraint.resource.csl.grammar;

public class CslGrammarInformationProvider {
	
	public final static org.eclipse.emf.ecore.EStructuralFeature ANONYMOUS_FEATURE = org.eclipse.emf.ecore.EcoreFactory.eINSTANCE.createEAttribute();
	static {
		ANONYMOUS_FEATURE.setName("_");
	}
	
	public final static CslGrammarInformationProvider INSTANCE = new CslGrammarInformationProvider();
	
	private java.util.Set<String> keywords;
	
	public final static org.feature.model.constraint.resource.csl.grammar.CslContainment CSL_0_0_0_0 = new org.feature.model.constraint.resource.csl.grammar.CslContainment(org.feature.model.constraint.ConstraintPackage.eINSTANCE.getConstraint().getEStructuralFeature(org.feature.model.constraint.ConstraintPackage.CONSTRAINT__EXPRESSION), org.feature.model.constraint.resource.csl.grammar.CslCardinality.ONE, new org.eclipse.emf.ecore.EClass[] {org.feature.model.constraint.ConstraintPackage.eINSTANCE.getFeatureExpression(), }, 0);
	public final static org.feature.model.constraint.resource.csl.grammar.CslSequence CSL_0_0_0 = new org.feature.model.constraint.resource.csl.grammar.CslSequence(org.feature.model.constraint.resource.csl.grammar.CslCardinality.ONE, CSL_0_0_0_0);
	public final static org.feature.model.constraint.resource.csl.grammar.CslChoice CSL_0_0 = new org.feature.model.constraint.resource.csl.grammar.CslChoice(org.feature.model.constraint.resource.csl.grammar.CslCardinality.ONE, CSL_0_0_0);
	public final static org.feature.model.constraint.resource.csl.grammar.CslRule CSL_0 = new org.feature.model.constraint.resource.csl.grammar.CslRule(org.feature.model.constraint.ConstraintPackage.eINSTANCE.getConstraint(), CSL_0_0, org.feature.model.constraint.resource.csl.grammar.CslCardinality.ONE);
	public final static org.feature.model.constraint.resource.csl.grammar.CslPlaceholder CSL_1_0_0_0 = new org.feature.model.constraint.resource.csl.grammar.CslPlaceholder(org.feature.model.constraint.ConstraintPackage.eINSTANCE.getRequire().getEStructuralFeature(org.feature.model.constraint.ConstraintPackage.REQUIRE__LEFT_FEATURE), "QUOTED_39_39", org.feature.model.constraint.resource.csl.grammar.CslCardinality.ONE, 0);
	public final static org.feature.model.constraint.resource.csl.grammar.CslWhiteSpace CSL_1_0_0_1 = new org.feature.model.constraint.resource.csl.grammar.CslWhiteSpace(1, org.feature.model.constraint.resource.csl.grammar.CslCardinality.ONE);
	public final static org.feature.model.constraint.resource.csl.grammar.CslKeyword CSL_1_0_0_2 = new org.feature.model.constraint.resource.csl.grammar.CslKeyword("requires", org.feature.model.constraint.resource.csl.grammar.CslCardinality.ONE);
	public final static org.feature.model.constraint.resource.csl.grammar.CslWhiteSpace CSL_1_0_0_3 = new org.feature.model.constraint.resource.csl.grammar.CslWhiteSpace(1, org.feature.model.constraint.resource.csl.grammar.CslCardinality.ONE);
	public final static org.feature.model.constraint.resource.csl.grammar.CslPlaceholder CSL_1_0_0_4 = new org.feature.model.constraint.resource.csl.grammar.CslPlaceholder(org.feature.model.constraint.ConstraintPackage.eINSTANCE.getRequire().getEStructuralFeature(org.feature.model.constraint.ConstraintPackage.REQUIRE__RIGHT_FEATURE), "QUOTED_34_34", org.feature.model.constraint.resource.csl.grammar.CslCardinality.ONE, 0);
	public final static org.feature.model.constraint.resource.csl.grammar.CslSequence CSL_1_0_0 = new org.feature.model.constraint.resource.csl.grammar.CslSequence(org.feature.model.constraint.resource.csl.grammar.CslCardinality.ONE, CSL_1_0_0_0, CSL_1_0_0_1, CSL_1_0_0_2, CSL_1_0_0_3, CSL_1_0_0_4);
	public final static org.feature.model.constraint.resource.csl.grammar.CslChoice CSL_1_0 = new org.feature.model.constraint.resource.csl.grammar.CslChoice(org.feature.model.constraint.resource.csl.grammar.CslCardinality.ONE, CSL_1_0_0);
	public final static org.feature.model.constraint.resource.csl.grammar.CslRule CSL_1 = new org.feature.model.constraint.resource.csl.grammar.CslRule(org.feature.model.constraint.ConstraintPackage.eINSTANCE.getRequire(), CSL_1_0, org.feature.model.constraint.resource.csl.grammar.CslCardinality.ONE);
	public final static org.feature.model.constraint.resource.csl.grammar.CslPlaceholder CSL_2_0_0_0 = new org.feature.model.constraint.resource.csl.grammar.CslPlaceholder(org.feature.model.constraint.ConstraintPackage.eINSTANCE.getExclude().getEStructuralFeature(org.feature.model.constraint.ConstraintPackage.EXCLUDE__LEFT_FEATURE), "QUOTED_34_34", org.feature.model.constraint.resource.csl.grammar.CslCardinality.ONE, 0);
	public final static org.feature.model.constraint.resource.csl.grammar.CslWhiteSpace CSL_2_0_0_1 = new org.feature.model.constraint.resource.csl.grammar.CslWhiteSpace(1, org.feature.model.constraint.resource.csl.grammar.CslCardinality.ONE);
	public final static org.feature.model.constraint.resource.csl.grammar.CslKeyword CSL_2_0_0_2 = new org.feature.model.constraint.resource.csl.grammar.CslKeyword("excludes", org.feature.model.constraint.resource.csl.grammar.CslCardinality.ONE);
	public final static org.feature.model.constraint.resource.csl.grammar.CslWhiteSpace CSL_2_0_0_3 = new org.feature.model.constraint.resource.csl.grammar.CslWhiteSpace(1, org.feature.model.constraint.resource.csl.grammar.CslCardinality.ONE);
	public final static org.feature.model.constraint.resource.csl.grammar.CslPlaceholder CSL_2_0_0_4 = new org.feature.model.constraint.resource.csl.grammar.CslPlaceholder(org.feature.model.constraint.ConstraintPackage.eINSTANCE.getExclude().getEStructuralFeature(org.feature.model.constraint.ConstraintPackage.EXCLUDE__RIGHT_FEATURE), "QUOTED_34_34", org.feature.model.constraint.resource.csl.grammar.CslCardinality.ONE, 0);
	public final static org.feature.model.constraint.resource.csl.grammar.CslSequence CSL_2_0_0 = new org.feature.model.constraint.resource.csl.grammar.CslSequence(org.feature.model.constraint.resource.csl.grammar.CslCardinality.ONE, CSL_2_0_0_0, CSL_2_0_0_1, CSL_2_0_0_2, CSL_2_0_0_3, CSL_2_0_0_4);
	public final static org.feature.model.constraint.resource.csl.grammar.CslChoice CSL_2_0 = new org.feature.model.constraint.resource.csl.grammar.CslChoice(org.feature.model.constraint.resource.csl.grammar.CslCardinality.ONE, CSL_2_0_0);
	public final static org.feature.model.constraint.resource.csl.grammar.CslRule CSL_2 = new org.feature.model.constraint.resource.csl.grammar.CslRule(org.feature.model.constraint.ConstraintPackage.eINSTANCE.getExclude(), CSL_2_0, org.feature.model.constraint.resource.csl.grammar.CslCardinality.ONE);
	
	public static String getSyntaxElementID(org.feature.model.constraint.resource.csl.grammar.CslSyntaxElement syntaxElement) {
		if (syntaxElement == null) {
			// null indicates EOF
			return "<EOF>";
		}
		for (java.lang.reflect.Field field : org.feature.model.constraint.resource.csl.grammar.CslGrammarInformationProvider.class.getFields()) {
			Object fieldValue;
			try {
				fieldValue = field.get(null);
				if (fieldValue == syntaxElement) {
					String id = field.getName();
					return id;
				}
			} catch (Exception e) { }
		}
		return null;
	}
	
	public static org.feature.model.constraint.resource.csl.grammar.CslSyntaxElement getSyntaxElementByID(String syntaxElementID) {
		try {
			return (org.feature.model.constraint.resource.csl.grammar.CslSyntaxElement) org.feature.model.constraint.resource.csl.grammar.CslGrammarInformationProvider.class.getField(syntaxElementID).get(null);
		} catch (Exception e) {
			return null;
		}
	}
	
	public final static org.feature.model.constraint.resource.csl.grammar.CslRule[] RULES = new org.feature.model.constraint.resource.csl.grammar.CslRule[] {
		CSL_0,
		CSL_1,
		CSL_2,
	};
	
	/**
	 * Returns all keywords of the grammar. This includes all literals for boolean and
	 * enumeration terminals.
	 */
	public java.util.Set<String> getKeywords() {
		if (this.keywords == null) {
			this.keywords = new java.util.LinkedHashSet<String>();
			for (org.feature.model.constraint.resource.csl.grammar.CslRule rule : RULES) {
				findKeywords(rule, this.keywords);
			}
		}
		return keywords;
	}
	
	/**
	 * Finds all keywords in the given element and its children and adds them to the
	 * set. This includes all literals for boolean and enumeration terminals.
	 */
	private void findKeywords(org.feature.model.constraint.resource.csl.grammar.CslSyntaxElement element, java.util.Set<String> keywords) {
		if (element instanceof org.feature.model.constraint.resource.csl.grammar.CslKeyword) {
			keywords.add(((org.feature.model.constraint.resource.csl.grammar.CslKeyword) element).getValue());
		} else if (element instanceof org.feature.model.constraint.resource.csl.grammar.CslBooleanTerminal) {
			keywords.add(((org.feature.model.constraint.resource.csl.grammar.CslBooleanTerminal) element).getTrueLiteral());
			keywords.add(((org.feature.model.constraint.resource.csl.grammar.CslBooleanTerminal) element).getFalseLiteral());
		} else if (element instanceof org.feature.model.constraint.resource.csl.grammar.CslEnumerationTerminal) {
			org.feature.model.constraint.resource.csl.grammar.CslEnumerationTerminal terminal = (org.feature.model.constraint.resource.csl.grammar.CslEnumerationTerminal) element;
			for (String key : terminal.getLiteralMapping().keySet()) {
				keywords.add(key);
			}
		}
		for (org.feature.model.constraint.resource.csl.grammar.CslSyntaxElement child : element.getChildren()) {
			findKeywords(child, this.keywords);
		}
	}
	
}

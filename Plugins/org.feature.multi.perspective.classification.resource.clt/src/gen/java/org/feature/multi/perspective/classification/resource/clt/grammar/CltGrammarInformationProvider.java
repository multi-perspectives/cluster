/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.multi.perspective.classification.resource.clt.grammar;

public class CltGrammarInformationProvider {
	
	public final static org.eclipse.emf.ecore.EStructuralFeature ANONYMOUS_FEATURE = org.eclipse.emf.ecore.EcoreFactory.eINSTANCE.createEAttribute();
	static {
		ANONYMOUS_FEATURE.setName("_");
	}
	
	public final static CltGrammarInformationProvider INSTANCE = new CltGrammarInformationProvider();
	
	private java.util.Set<String> keywords;
	
	public final static org.feature.multi.perspective.classification.resource.clt.grammar.CltKeyword CLT_0_0_0_0 = new org.feature.multi.perspective.classification.resource.clt.grammar.CltKeyword("classification", org.feature.multi.perspective.classification.resource.clt.grammar.CltCardinality.ONE);
	public final static org.feature.multi.perspective.classification.resource.clt.grammar.CltLineBreak CLT_0_0_0_1 = new org.feature.multi.perspective.classification.resource.clt.grammar.CltLineBreak(org.feature.multi.perspective.classification.resource.clt.grammar.CltCardinality.ONE, 0);
	public final static org.feature.multi.perspective.classification.resource.clt.grammar.CltKeyword CLT_0_0_0_2 = new org.feature.multi.perspective.classification.resource.clt.grammar.CltKeyword("references", org.feature.multi.perspective.classification.resource.clt.grammar.CltCardinality.ONE);
	public final static org.feature.multi.perspective.classification.resource.clt.grammar.CltWhiteSpace CLT_0_0_0_3 = new org.feature.multi.perspective.classification.resource.clt.grammar.CltWhiteSpace(1, org.feature.multi.perspective.classification.resource.clt.grammar.CltCardinality.ONE);
	public final static org.feature.multi.perspective.classification.resource.clt.grammar.CltKeyword CLT_0_0_0_4_0_0_0_0_0_0 = new org.feature.multi.perspective.classification.resource.clt.grammar.CltKeyword("mapping", org.feature.multi.perspective.classification.resource.clt.grammar.CltCardinality.ONE);
	public final static org.feature.multi.perspective.classification.resource.clt.grammar.CltWhiteSpace CLT_0_0_0_4_0_0_0_0_0_1 = new org.feature.multi.perspective.classification.resource.clt.grammar.CltWhiteSpace(1, org.feature.multi.perspective.classification.resource.clt.grammar.CltCardinality.ONE);
	public final static org.feature.multi.perspective.classification.resource.clt.grammar.CltPlaceholder CLT_0_0_0_4_0_0_0_0_0_2 = new org.feature.multi.perspective.classification.resource.clt.grammar.CltPlaceholder(org.feature.multi.perspective.classification.ClassificationPackage.eINSTANCE.getClassificationModel().getEStructuralFeature(org.feature.multi.perspective.classification.ClassificationPackage.CLASSIFICATION_MODEL__VIEW_MAPPING), "QUOTED_60_62", org.feature.multi.perspective.classification.resource.clt.grammar.CltCardinality.ONE, 0);
	public final static org.feature.multi.perspective.classification.resource.clt.grammar.CltSequence CLT_0_0_0_4_0_0_0_0_0 = new org.feature.multi.perspective.classification.resource.clt.grammar.CltSequence(org.feature.multi.perspective.classification.resource.clt.grammar.CltCardinality.ONE, CLT_0_0_0_4_0_0_0_0_0_0, CLT_0_0_0_4_0_0_0_0_0_1, CLT_0_0_0_4_0_0_0_0_0_2);
	public final static org.feature.multi.perspective.classification.resource.clt.grammar.CltChoice CLT_0_0_0_4_0_0_0_0 = new org.feature.multi.perspective.classification.resource.clt.grammar.CltChoice(org.feature.multi.perspective.classification.resource.clt.grammar.CltCardinality.ONE, CLT_0_0_0_4_0_0_0_0_0);
	public final static org.feature.multi.perspective.classification.resource.clt.grammar.CltCompound CLT_0_0_0_4_0_0_0 = new org.feature.multi.perspective.classification.resource.clt.grammar.CltCompound(CLT_0_0_0_4_0_0_0_0, org.feature.multi.perspective.classification.resource.clt.grammar.CltCardinality.ONE);
	public final static org.feature.multi.perspective.classification.resource.clt.grammar.CltSequence CLT_0_0_0_4_0_0 = new org.feature.multi.perspective.classification.resource.clt.grammar.CltSequence(org.feature.multi.perspective.classification.resource.clt.grammar.CltCardinality.ONE, CLT_0_0_0_4_0_0_0);
	public final static org.feature.multi.perspective.classification.resource.clt.grammar.CltKeyword CLT_0_0_0_4_0_1_0_0_0_0 = new org.feature.multi.perspective.classification.resource.clt.grammar.CltKeyword("featuremodel", org.feature.multi.perspective.classification.resource.clt.grammar.CltCardinality.ONE);
	public final static org.feature.multi.perspective.classification.resource.clt.grammar.CltWhiteSpace CLT_0_0_0_4_0_1_0_0_0_1 = new org.feature.multi.perspective.classification.resource.clt.grammar.CltWhiteSpace(1, org.feature.multi.perspective.classification.resource.clt.grammar.CltCardinality.ONE);
	public final static org.feature.multi.perspective.classification.resource.clt.grammar.CltPlaceholder CLT_0_0_0_4_0_1_0_0_0_2 = new org.feature.multi.perspective.classification.resource.clt.grammar.CltPlaceholder(org.feature.multi.perspective.classification.ClassificationPackage.eINSTANCE.getClassificationModel().getEStructuralFeature(org.feature.multi.perspective.classification.ClassificationPackage.CLASSIFICATION_MODEL__FEATURE_MODEL), "QUOTED_60_62", org.feature.multi.perspective.classification.resource.clt.grammar.CltCardinality.ONE, 0);
	public final static org.feature.multi.perspective.classification.resource.clt.grammar.CltSequence CLT_0_0_0_4_0_1_0_0_0 = new org.feature.multi.perspective.classification.resource.clt.grammar.CltSequence(org.feature.multi.perspective.classification.resource.clt.grammar.CltCardinality.ONE, CLT_0_0_0_4_0_1_0_0_0_0, CLT_0_0_0_4_0_1_0_0_0_1, CLT_0_0_0_4_0_1_0_0_0_2);
	public final static org.feature.multi.perspective.classification.resource.clt.grammar.CltChoice CLT_0_0_0_4_0_1_0_0 = new org.feature.multi.perspective.classification.resource.clt.grammar.CltChoice(org.feature.multi.perspective.classification.resource.clt.grammar.CltCardinality.ONE, CLT_0_0_0_4_0_1_0_0_0);
	public final static org.feature.multi.perspective.classification.resource.clt.grammar.CltCompound CLT_0_0_0_4_0_1_0 = new org.feature.multi.perspective.classification.resource.clt.grammar.CltCompound(CLT_0_0_0_4_0_1_0_0, org.feature.multi.perspective.classification.resource.clt.grammar.CltCardinality.ONE);
	public final static org.feature.multi.perspective.classification.resource.clt.grammar.CltSequence CLT_0_0_0_4_0_1 = new org.feature.multi.perspective.classification.resource.clt.grammar.CltSequence(org.feature.multi.perspective.classification.resource.clt.grammar.CltCardinality.ONE, CLT_0_0_0_4_0_1_0);
	public final static org.feature.multi.perspective.classification.resource.clt.grammar.CltChoice CLT_0_0_0_4_0 = new org.feature.multi.perspective.classification.resource.clt.grammar.CltChoice(org.feature.multi.perspective.classification.resource.clt.grammar.CltCardinality.ONE, CLT_0_0_0_4_0_0, CLT_0_0_0_4_0_1);
	public final static org.feature.multi.perspective.classification.resource.clt.grammar.CltCompound CLT_0_0_0_4 = new org.feature.multi.perspective.classification.resource.clt.grammar.CltCompound(CLT_0_0_0_4_0, org.feature.multi.perspective.classification.resource.clt.grammar.CltCardinality.PLUS);
	public final static org.feature.multi.perspective.classification.resource.clt.grammar.CltLineBreak CLT_0_0_0_5 = new org.feature.multi.perspective.classification.resource.clt.grammar.CltLineBreak(org.feature.multi.perspective.classification.resource.clt.grammar.CltCardinality.ONE, 0);
	public final static org.feature.multi.perspective.classification.resource.clt.grammar.CltLineBreak CLT_0_0_0_6 = new org.feature.multi.perspective.classification.resource.clt.grammar.CltLineBreak(org.feature.multi.perspective.classification.resource.clt.grammar.CltCardinality.ONE, 0);
	public final static org.feature.multi.perspective.classification.resource.clt.grammar.CltContainment CLT_0_0_0_7 = new org.feature.multi.perspective.classification.resource.clt.grammar.CltContainment(org.feature.multi.perspective.classification.ClassificationPackage.eINSTANCE.getClassificationModel().getEStructuralFeature(org.feature.multi.perspective.classification.ClassificationPackage.CLASSIFICATION_MODEL__CLASSIFICATIONS), org.feature.multi.perspective.classification.resource.clt.grammar.CltCardinality.STAR, new org.eclipse.emf.ecore.EClass[] {org.feature.multi.perspective.classification.ClassificationPackage.eINSTANCE.getClassification(), }, 0);
	public final static org.feature.multi.perspective.classification.resource.clt.grammar.CltSequence CLT_0_0_0 = new org.feature.multi.perspective.classification.resource.clt.grammar.CltSequence(org.feature.multi.perspective.classification.resource.clt.grammar.CltCardinality.ONE, CLT_0_0_0_0, CLT_0_0_0_1, CLT_0_0_0_2, CLT_0_0_0_3, CLT_0_0_0_4, CLT_0_0_0_5, CLT_0_0_0_6, CLT_0_0_0_7);
	public final static org.feature.multi.perspective.classification.resource.clt.grammar.CltChoice CLT_0_0 = new org.feature.multi.perspective.classification.resource.clt.grammar.CltChoice(org.feature.multi.perspective.classification.resource.clt.grammar.CltCardinality.ONE, CLT_0_0_0);
	public final static org.feature.multi.perspective.classification.resource.clt.grammar.CltRule CLT_0 = new org.feature.multi.perspective.classification.resource.clt.grammar.CltRule(org.feature.multi.perspective.classification.ClassificationPackage.eINSTANCE.getClassificationModel(), CLT_0_0, org.feature.multi.perspective.classification.resource.clt.grammar.CltCardinality.ONE);
	public final static org.feature.multi.perspective.classification.resource.clt.grammar.CltKeyword CLT_1_0_0_0 = new org.feature.multi.perspective.classification.resource.clt.grammar.CltKeyword("stage", org.feature.multi.perspective.classification.resource.clt.grammar.CltCardinality.ONE);
	public final static org.feature.multi.perspective.classification.resource.clt.grammar.CltWhiteSpace CLT_1_0_0_1 = new org.feature.multi.perspective.classification.resource.clt.grammar.CltWhiteSpace(1, org.feature.multi.perspective.classification.resource.clt.grammar.CltCardinality.ONE);
	public final static org.feature.multi.perspective.classification.resource.clt.grammar.CltPlaceholder CLT_1_0_0_2 = new org.feature.multi.perspective.classification.resource.clt.grammar.CltPlaceholder(org.feature.multi.perspective.classification.ClassificationPackage.eINSTANCE.getClassification().getEStructuralFeature(org.feature.multi.perspective.classification.ClassificationPackage.CLASSIFICATION__ID), "QUOTED_60_62", org.feature.multi.perspective.classification.resource.clt.grammar.CltCardinality.ONE, 0);
	public final static org.feature.multi.perspective.classification.resource.clt.grammar.CltWhiteSpace CLT_1_0_0_3 = new org.feature.multi.perspective.classification.resource.clt.grammar.CltWhiteSpace(1, org.feature.multi.perspective.classification.resource.clt.grammar.CltCardinality.ONE);
	public final static org.feature.multi.perspective.classification.resource.clt.grammar.CltKeyword CLT_1_0_0_4 = new org.feature.multi.perspective.classification.resource.clt.grammar.CltKeyword("on", org.feature.multi.perspective.classification.resource.clt.grammar.CltCardinality.ONE);
	public final static org.feature.multi.perspective.classification.resource.clt.grammar.CltKeyword CLT_1_0_0_5 = new org.feature.multi.perspective.classification.resource.clt.grammar.CltKeyword("view", org.feature.multi.perspective.classification.resource.clt.grammar.CltCardinality.ONE);
	public final static org.feature.multi.perspective.classification.resource.clt.grammar.CltWhiteSpace CLT_1_0_0_6 = new org.feature.multi.perspective.classification.resource.clt.grammar.CltWhiteSpace(1, org.feature.multi.perspective.classification.resource.clt.grammar.CltCardinality.ONE);
	public final static org.feature.multi.perspective.classification.resource.clt.grammar.CltPlaceholder CLT_1_0_0_7 = new org.feature.multi.perspective.classification.resource.clt.grammar.CltPlaceholder(org.feature.multi.perspective.classification.ClassificationPackage.eINSTANCE.getClassification().getEStructuralFeature(org.feature.multi.perspective.classification.ClassificationPackage.CLASSIFICATION__VIEWGROUPS), "QUOTED_34_34", org.feature.multi.perspective.classification.resource.clt.grammar.CltCardinality.ONE, 0);
	public final static org.feature.multi.perspective.classification.resource.clt.grammar.CltWhiteSpace CLT_1_0_0_8 = new org.feature.multi.perspective.classification.resource.clt.grammar.CltWhiteSpace(1, org.feature.multi.perspective.classification.resource.clt.grammar.CltCardinality.ONE);
	public final static org.feature.multi.perspective.classification.resource.clt.grammar.CltKeyword CLT_1_0_0_9 = new org.feature.multi.perspective.classification.resource.clt.grammar.CltKeyword(":", org.feature.multi.perspective.classification.resource.clt.grammar.CltCardinality.ONE);
	public final static org.feature.multi.perspective.classification.resource.clt.grammar.CltLineBreak CLT_1_0_0_10 = new org.feature.multi.perspective.classification.resource.clt.grammar.CltLineBreak(org.feature.multi.perspective.classification.resource.clt.grammar.CltCardinality.ONE, 0);
	public final static org.feature.multi.perspective.classification.resource.clt.grammar.CltContainment CLT_1_0_0_11 = new org.feature.multi.perspective.classification.resource.clt.grammar.CltContainment(org.feature.multi.perspective.classification.ClassificationPackage.eINSTANCE.getClassification().getEStructuralFeature(org.feature.multi.perspective.classification.ClassificationPackage.CLASSIFICATION__CLASSIFIED_FEATURES), org.feature.multi.perspective.classification.resource.clt.grammar.CltCardinality.STAR, new org.eclipse.emf.ecore.EClass[] {org.feature.multi.perspective.classification.ClassificationPackage.eINSTANCE.getClassifiedFeature(), }, 0);
	public final static org.feature.multi.perspective.classification.resource.clt.grammar.CltWhiteSpace CLT_1_0_0_12_0_0_0 = new org.feature.multi.perspective.classification.resource.clt.grammar.CltWhiteSpace(3, org.feature.multi.perspective.classification.resource.clt.grammar.CltCardinality.ONE);
	public final static org.feature.multi.perspective.classification.resource.clt.grammar.CltKeyword CLT_1_0_0_12_0_0_1 = new org.feature.multi.perspective.classification.resource.clt.grammar.CltKeyword("autocomplete", org.feature.multi.perspective.classification.resource.clt.grammar.CltCardinality.ONE);
	public final static org.feature.multi.perspective.classification.resource.clt.grammar.CltWhiteSpace CLT_1_0_0_12_0_0_2 = new org.feature.multi.perspective.classification.resource.clt.grammar.CltWhiteSpace(1, org.feature.multi.perspective.classification.resource.clt.grammar.CltCardinality.ONE);
	public final static org.feature.multi.perspective.classification.resource.clt.grammar.CltKeyword CLT_1_0_0_12_0_0_3 = new org.feature.multi.perspective.classification.resource.clt.grammar.CltKeyword("{", org.feature.multi.perspective.classification.resource.clt.grammar.CltCardinality.ONE);
	public final static org.feature.multi.perspective.classification.resource.clt.grammar.CltLineBreak CLT_1_0_0_12_0_0_4 = new org.feature.multi.perspective.classification.resource.clt.grammar.CltLineBreak(org.feature.multi.perspective.classification.resource.clt.grammar.CltCardinality.ONE, 0);
	public final static org.feature.multi.perspective.classification.resource.clt.grammar.CltContainment CLT_1_0_0_12_0_0_5 = new org.feature.multi.perspective.classification.resource.clt.grammar.CltContainment(org.feature.multi.perspective.classification.ClassificationPackage.eINSTANCE.getClassification().getEStructuralFeature(org.feature.multi.perspective.classification.ClassificationPackage.CLASSIFICATION__AUTO_COMPLETE_FEATURES), org.feature.multi.perspective.classification.resource.clt.grammar.CltCardinality.STAR, new org.eclipse.emf.ecore.EClass[] {org.feature.multi.perspective.classification.ClassificationPackage.eINSTANCE.getClassifiedFeature(), }, 0);
	public final static org.feature.multi.perspective.classification.resource.clt.grammar.CltWhiteSpace CLT_1_0_0_12_0_0_6 = new org.feature.multi.perspective.classification.resource.clt.grammar.CltWhiteSpace(3, org.feature.multi.perspective.classification.resource.clt.grammar.CltCardinality.ONE);
	public final static org.feature.multi.perspective.classification.resource.clt.grammar.CltKeyword CLT_1_0_0_12_0_0_7 = new org.feature.multi.perspective.classification.resource.clt.grammar.CltKeyword("}", org.feature.multi.perspective.classification.resource.clt.grammar.CltCardinality.ONE);
	public final static org.feature.multi.perspective.classification.resource.clt.grammar.CltSequence CLT_1_0_0_12_0_0 = new org.feature.multi.perspective.classification.resource.clt.grammar.CltSequence(org.feature.multi.perspective.classification.resource.clt.grammar.CltCardinality.ONE, CLT_1_0_0_12_0_0_0, CLT_1_0_0_12_0_0_1, CLT_1_0_0_12_0_0_2, CLT_1_0_0_12_0_0_3, CLT_1_0_0_12_0_0_4, CLT_1_0_0_12_0_0_5, CLT_1_0_0_12_0_0_6, CLT_1_0_0_12_0_0_7);
	public final static org.feature.multi.perspective.classification.resource.clt.grammar.CltChoice CLT_1_0_0_12_0 = new org.feature.multi.perspective.classification.resource.clt.grammar.CltChoice(org.feature.multi.perspective.classification.resource.clt.grammar.CltCardinality.ONE, CLT_1_0_0_12_0_0);
	public final static org.feature.multi.perspective.classification.resource.clt.grammar.CltCompound CLT_1_0_0_12 = new org.feature.multi.perspective.classification.resource.clt.grammar.CltCompound(CLT_1_0_0_12_0, org.feature.multi.perspective.classification.resource.clt.grammar.CltCardinality.QUESTIONMARK);
	public final static org.feature.multi.perspective.classification.resource.clt.grammar.CltLineBreak CLT_1_0_0_13 = new org.feature.multi.perspective.classification.resource.clt.grammar.CltLineBreak(org.feature.multi.perspective.classification.resource.clt.grammar.CltCardinality.ONE, 0);
	public final static org.feature.multi.perspective.classification.resource.clt.grammar.CltSequence CLT_1_0_0 = new org.feature.multi.perspective.classification.resource.clt.grammar.CltSequence(org.feature.multi.perspective.classification.resource.clt.grammar.CltCardinality.ONE, CLT_1_0_0_0, CLT_1_0_0_1, CLT_1_0_0_2, CLT_1_0_0_3, CLT_1_0_0_4, CLT_1_0_0_5, CLT_1_0_0_6, CLT_1_0_0_7, CLT_1_0_0_8, CLT_1_0_0_9, CLT_1_0_0_10, CLT_1_0_0_11, CLT_1_0_0_12, CLT_1_0_0_13);
	public final static org.feature.multi.perspective.classification.resource.clt.grammar.CltChoice CLT_1_0 = new org.feature.multi.perspective.classification.resource.clt.grammar.CltChoice(org.feature.multi.perspective.classification.resource.clt.grammar.CltCardinality.ONE, CLT_1_0_0);
	public final static org.feature.multi.perspective.classification.resource.clt.grammar.CltRule CLT_1 = new org.feature.multi.perspective.classification.resource.clt.grammar.CltRule(org.feature.multi.perspective.classification.ClassificationPackage.eINSTANCE.getClassification(), CLT_1_0, org.feature.multi.perspective.classification.resource.clt.grammar.CltCardinality.ONE);
	public final static org.feature.multi.perspective.classification.resource.clt.grammar.CltWhiteSpace CLT_2_0_0_0_0_0_0 = new org.feature.multi.perspective.classification.resource.clt.grammar.CltWhiteSpace(3, org.feature.multi.perspective.classification.resource.clt.grammar.CltCardinality.ONE);
	public final static org.feature.multi.perspective.classification.resource.clt.grammar.CltKeyword CLT_2_0_0_0_0_0_1 = new org.feature.multi.perspective.classification.resource.clt.grammar.CltKeyword("feature", org.feature.multi.perspective.classification.resource.clt.grammar.CltCardinality.ONE);
	public final static org.feature.multi.perspective.classification.resource.clt.grammar.CltWhiteSpace CLT_2_0_0_0_0_0_2 = new org.feature.multi.perspective.classification.resource.clt.grammar.CltWhiteSpace(1, org.feature.multi.perspective.classification.resource.clt.grammar.CltCardinality.ONE);
	public final static org.feature.multi.perspective.classification.resource.clt.grammar.CltPlaceholder CLT_2_0_0_0_0_0_3 = new org.feature.multi.perspective.classification.resource.clt.grammar.CltPlaceholder(org.feature.multi.perspective.classification.ClassificationPackage.eINSTANCE.getClassifiedFeature().getEStructuralFeature(org.feature.multi.perspective.classification.ClassificationPackage.CLASSIFIED_FEATURE__FEATURE), "QUOTED_34_34", org.feature.multi.perspective.classification.resource.clt.grammar.CltCardinality.ONE, 0);
	public final static org.feature.multi.perspective.classification.resource.clt.grammar.CltWhiteSpace CLT_2_0_0_0_0_0_4 = new org.feature.multi.perspective.classification.resource.clt.grammar.CltWhiteSpace(1, org.feature.multi.perspective.classification.resource.clt.grammar.CltCardinality.ONE);
	public final static org.feature.multi.perspective.classification.resource.clt.grammar.CltEnumerationTerminal CLT_2_0_0_0_0_0_5 = new org.feature.multi.perspective.classification.resource.clt.grammar.CltEnumerationTerminal(org.feature.multi.perspective.classification.ClassificationPackage.eINSTANCE.getClassifiedFeature().getEStructuralFeature(org.feature.multi.perspective.classification.ClassificationPackage.CLASSIFIED_FEATURE__CLASSIFIED), new String[] {"Unclassified", "", "Unbound", "unbound", "Dead", "dead", "Alive", "alive", }, org.feature.multi.perspective.classification.resource.clt.grammar.CltCardinality.ONE, 0);
	public final static org.feature.multi.perspective.classification.resource.clt.grammar.CltSequence CLT_2_0_0_0_0_0 = new org.feature.multi.perspective.classification.resource.clt.grammar.CltSequence(org.feature.multi.perspective.classification.resource.clt.grammar.CltCardinality.ONE, CLT_2_0_0_0_0_0_0, CLT_2_0_0_0_0_0_1, CLT_2_0_0_0_0_0_2, CLT_2_0_0_0_0_0_3, CLT_2_0_0_0_0_0_4, CLT_2_0_0_0_0_0_5);
	public final static org.feature.multi.perspective.classification.resource.clt.grammar.CltChoice CLT_2_0_0_0_0 = new org.feature.multi.perspective.classification.resource.clt.grammar.CltChoice(org.feature.multi.perspective.classification.resource.clt.grammar.CltCardinality.ONE, CLT_2_0_0_0_0_0);
	public final static org.feature.multi.perspective.classification.resource.clt.grammar.CltCompound CLT_2_0_0_0 = new org.feature.multi.perspective.classification.resource.clt.grammar.CltCompound(CLT_2_0_0_0_0, org.feature.multi.perspective.classification.resource.clt.grammar.CltCardinality.ONE);
	public final static org.feature.multi.perspective.classification.resource.clt.grammar.CltLineBreak CLT_2_0_0_1 = new org.feature.multi.perspective.classification.resource.clt.grammar.CltLineBreak(org.feature.multi.perspective.classification.resource.clt.grammar.CltCardinality.ONE, 0);
	public final static org.feature.multi.perspective.classification.resource.clt.grammar.CltSequence CLT_2_0_0 = new org.feature.multi.perspective.classification.resource.clt.grammar.CltSequence(org.feature.multi.perspective.classification.resource.clt.grammar.CltCardinality.ONE, CLT_2_0_0_0, CLT_2_0_0_1);
	public final static org.feature.multi.perspective.classification.resource.clt.grammar.CltChoice CLT_2_0 = new org.feature.multi.perspective.classification.resource.clt.grammar.CltChoice(org.feature.multi.perspective.classification.resource.clt.grammar.CltCardinality.ONE, CLT_2_0_0);
	public final static org.feature.multi.perspective.classification.resource.clt.grammar.CltRule CLT_2 = new org.feature.multi.perspective.classification.resource.clt.grammar.CltRule(org.feature.multi.perspective.classification.ClassificationPackage.eINSTANCE.getClassifiedFeature(), CLT_2_0, org.feature.multi.perspective.classification.resource.clt.grammar.CltCardinality.ONE);
	
	public static String getSyntaxElementID(org.feature.multi.perspective.classification.resource.clt.grammar.CltSyntaxElement syntaxElement) {
		if (syntaxElement == null) {
			// null indicates EOF
			return "<EOF>";
		}
		for (java.lang.reflect.Field field : org.feature.multi.perspective.classification.resource.clt.grammar.CltGrammarInformationProvider.class.getFields()) {
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
	
	public static org.feature.multi.perspective.classification.resource.clt.grammar.CltSyntaxElement getSyntaxElementByID(String syntaxElementID) {
		try {
			return (org.feature.multi.perspective.classification.resource.clt.grammar.CltSyntaxElement) org.feature.multi.perspective.classification.resource.clt.grammar.CltGrammarInformationProvider.class.getField(syntaxElementID).get(null);
		} catch (Exception e) {
			return null;
		}
	}
	
	public final static org.feature.multi.perspective.classification.resource.clt.grammar.CltRule[] RULES = new org.feature.multi.perspective.classification.resource.clt.grammar.CltRule[] {
		CLT_0,
		CLT_1,
		CLT_2,
	};
	
	/**
	 * Returns all keywords of the grammar. This includes all literals for boolean and
	 * enumeration terminals.
	 */
	public java.util.Set<String> getKeywords() {
		if (this.keywords == null) {
			this.keywords = new java.util.LinkedHashSet<String>();
			for (org.feature.multi.perspective.classification.resource.clt.grammar.CltRule rule : RULES) {
				findKeywords(rule, this.keywords);
			}
		}
		return keywords;
	}
	
	/**
	 * Finds all keywords in the given element and its children and adds them to the
	 * set. This includes all literals for boolean and enumeration terminals.
	 */
	private void findKeywords(org.feature.multi.perspective.classification.resource.clt.grammar.CltSyntaxElement element, java.util.Set<String> keywords) {
		if (element instanceof org.feature.multi.perspective.classification.resource.clt.grammar.CltKeyword) {
			keywords.add(((org.feature.multi.perspective.classification.resource.clt.grammar.CltKeyword) element).getValue());
		} else if (element instanceof org.feature.multi.perspective.classification.resource.clt.grammar.CltBooleanTerminal) {
			keywords.add(((org.feature.multi.perspective.classification.resource.clt.grammar.CltBooleanTerminal) element).getTrueLiteral());
			keywords.add(((org.feature.multi.perspective.classification.resource.clt.grammar.CltBooleanTerminal) element).getFalseLiteral());
		} else if (element instanceof org.feature.multi.perspective.classification.resource.clt.grammar.CltEnumerationTerminal) {
			org.feature.multi.perspective.classification.resource.clt.grammar.CltEnumerationTerminal terminal = (org.feature.multi.perspective.classification.resource.clt.grammar.CltEnumerationTerminal) element;
			for (String key : terminal.getLiteralMapping().keySet()) {
				keywords.add(key);
			}
		}
		for (org.feature.multi.perspective.classification.resource.clt.grammar.CltSyntaxElement child : element.getChildren()) {
			findKeywords(child, this.keywords);
		}
	}
	
}

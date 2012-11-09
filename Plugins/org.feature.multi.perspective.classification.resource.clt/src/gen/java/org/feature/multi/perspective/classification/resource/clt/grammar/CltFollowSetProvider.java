/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.multi.perspective.classification.resource.clt.grammar;

/**
 * This class provides the follow sets for all terminals of the grammar. These
 * sets are used during code completion.
 */
public class CltFollowSetProvider {
	
	public final static org.feature.multi.perspective.classification.resource.clt.ICltExpectedElement TERMINALS[] = new org.feature.multi.perspective.classification.resource.clt.ICltExpectedElement[19];
	
	public final static org.eclipse.emf.ecore.EStructuralFeature[] FEATURES = new org.eclipse.emf.ecore.EStructuralFeature[3];
	
	public final static org.feature.multi.perspective.classification.resource.clt.mopp.CltContainedFeature[] LINKS = new org.feature.multi.perspective.classification.resource.clt.mopp.CltContainedFeature[18];
	
	public final static org.feature.multi.perspective.classification.resource.clt.mopp.CltContainedFeature[] EMPTY_LINK_ARRAY = new org.feature.multi.perspective.classification.resource.clt.mopp.CltContainedFeature[0];
	
	public static void initializeTerminals0() {
		TERMINALS[0] = new org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectedCsString(org.feature.multi.perspective.classification.resource.clt.grammar.CltGrammarInformationProvider.CLT_0_0_0_0);
		TERMINALS[1] = new org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectedCsString(org.feature.multi.perspective.classification.resource.clt.grammar.CltGrammarInformationProvider.CLT_0_0_0_2);
		TERMINALS[2] = new org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectedCsString(org.feature.multi.perspective.classification.resource.clt.grammar.CltGrammarInformationProvider.CLT_0_0_0_4_0_0_0_0_0_0);
		TERMINALS[3] = new org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectedCsString(org.feature.multi.perspective.classification.resource.clt.grammar.CltGrammarInformationProvider.CLT_0_0_0_4_0_1_0_0_0_0);
		TERMINALS[4] = new org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectedStructuralFeature(org.feature.multi.perspective.classification.resource.clt.grammar.CltGrammarInformationProvider.CLT_0_0_0_4_0_0_0_0_0_2);
		TERMINALS[5] = new org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectedCsString(org.feature.multi.perspective.classification.resource.clt.grammar.CltGrammarInformationProvider.CLT_1_0_0_0);
		TERMINALS[6] = new org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectedStructuralFeature(org.feature.multi.perspective.classification.resource.clt.grammar.CltGrammarInformationProvider.CLT_0_0_0_4_0_1_0_0_0_2);
		TERMINALS[7] = new org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectedStructuralFeature(org.feature.multi.perspective.classification.resource.clt.grammar.CltGrammarInformationProvider.CLT_1_0_0_2);
		TERMINALS[8] = new org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectedCsString(org.feature.multi.perspective.classification.resource.clt.grammar.CltGrammarInformationProvider.CLT_1_0_0_4);
		TERMINALS[9] = new org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectedCsString(org.feature.multi.perspective.classification.resource.clt.grammar.CltGrammarInformationProvider.CLT_1_0_0_5);
		TERMINALS[10] = new org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectedStructuralFeature(org.feature.multi.perspective.classification.resource.clt.grammar.CltGrammarInformationProvider.CLT_1_0_0_6_0_0_1);
		TERMINALS[11] = new org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectedCsString(org.feature.multi.perspective.classification.resource.clt.grammar.CltGrammarInformationProvider.CLT_1_0_0_8);
		TERMINALS[12] = new org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectedStructuralFeature(org.feature.multi.perspective.classification.resource.clt.grammar.CltGrammarInformationProvider.CLT_1_0_0_6_0_0_2_0_0_1);
		TERMINALS[13] = new org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectedCsString(org.feature.multi.perspective.classification.resource.clt.grammar.CltGrammarInformationProvider.CLT_2_0_0_0_0_0_1);
		TERMINALS[14] = new org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectedCsString(org.feature.multi.perspective.classification.resource.clt.grammar.CltGrammarInformationProvider.CLT_1_0_0_11_0_0_1);
		TERMINALS[15] = new org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectedCsString(org.feature.multi.perspective.classification.resource.clt.grammar.CltGrammarInformationProvider.CLT_1_0_0_11_0_0_3);
		TERMINALS[16] = new org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectedCsString(org.feature.multi.perspective.classification.resource.clt.grammar.CltGrammarInformationProvider.CLT_1_0_0_11_0_0_7);
		TERMINALS[17] = new org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectedStructuralFeature(org.feature.multi.perspective.classification.resource.clt.grammar.CltGrammarInformationProvider.CLT_2_0_0_0_0_0_3);
		TERMINALS[18] = new org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectedEnumerationTerminal(org.feature.multi.perspective.classification.resource.clt.grammar.CltGrammarInformationProvider.CLT_2_0_0_0_0_0_5);
	}
	
	public static void initializeTerminals() {
		initializeTerminals0();
	}
	
	public static void initializeFeatures0() {
		FEATURES[0] = org.feature.multi.perspective.classification.ClassificationPackage.eINSTANCE.getClassificationModel().getEStructuralFeature(org.feature.multi.perspective.classification.ClassificationPackage.CLASSIFICATION_MODEL__CLASSIFICATIONS);
		FEATURES[1] = org.feature.multi.perspective.classification.ClassificationPackage.eINSTANCE.getClassification().getEStructuralFeature(org.feature.multi.perspective.classification.ClassificationPackage.CLASSIFICATION__CLASSIFIED_FEATURES);
		FEATURES[2] = org.feature.multi.perspective.classification.ClassificationPackage.eINSTANCE.getClassification().getEStructuralFeature(org.feature.multi.perspective.classification.ClassificationPackage.CLASSIFICATION__AUTO_COMPLETE_FEATURES);
	}
	
	public static void initializeFeatures() {
		initializeFeatures0();
	}
	
	public static void initializeLinks0() {
		LINKS[0] = new org.feature.multi.perspective.classification.resource.clt.mopp.CltContainedFeature(org.feature.multi.perspective.classification.ClassificationPackage.eINSTANCE.getClassification(), FEATURES[0]);
		LINKS[1] = new org.feature.multi.perspective.classification.resource.clt.mopp.CltContainedFeature(org.feature.multi.perspective.classification.ClassificationPackage.eINSTANCE.getClassification(), FEATURES[0]);
		LINKS[2] = new org.feature.multi.perspective.classification.resource.clt.mopp.CltContainedFeature(org.feature.multi.perspective.classification.ClassificationPackage.eINSTANCE.getClassification(), FEATURES[0]);
		LINKS[3] = new org.feature.multi.perspective.classification.resource.clt.mopp.CltContainedFeature(org.feature.multi.perspective.classification.ClassificationPackage.eINSTANCE.getClassification(), FEATURES[0]);
		LINKS[4] = new org.feature.multi.perspective.classification.resource.clt.mopp.CltContainedFeature(org.feature.multi.perspective.classification.ClassificationPackage.eINSTANCE.getClassification(), FEATURES[0]);
		LINKS[5] = new org.feature.multi.perspective.classification.resource.clt.mopp.CltContainedFeature(org.feature.multi.perspective.classification.ClassificationPackage.eINSTANCE.getClassification(), FEATURES[0]);
		LINKS[6] = new org.feature.multi.perspective.classification.resource.clt.mopp.CltContainedFeature(org.feature.multi.perspective.classification.ClassificationPackage.eINSTANCE.getClassifiedFeature(), FEATURES[1]);
		LINKS[7] = new org.feature.multi.perspective.classification.resource.clt.mopp.CltContainedFeature(org.feature.multi.perspective.classification.ClassificationPackage.eINSTANCE.getClassification(), FEATURES[0]);
		LINKS[8] = new org.feature.multi.perspective.classification.resource.clt.mopp.CltContainedFeature(org.feature.multi.perspective.classification.ClassificationPackage.eINSTANCE.getClassifiedFeature(), FEATURES[1]);
		LINKS[9] = new org.feature.multi.perspective.classification.resource.clt.mopp.CltContainedFeature(org.feature.multi.perspective.classification.ClassificationPackage.eINSTANCE.getClassification(), FEATURES[0]);
		LINKS[10] = new org.feature.multi.perspective.classification.resource.clt.mopp.CltContainedFeature(org.feature.multi.perspective.classification.ClassificationPackage.eINSTANCE.getClassifiedFeature(), FEATURES[2]);
		LINKS[11] = new org.feature.multi.perspective.classification.resource.clt.mopp.CltContainedFeature(org.feature.multi.perspective.classification.ClassificationPackage.eINSTANCE.getClassifiedFeature(), FEATURES[2]);
		LINKS[12] = new org.feature.multi.perspective.classification.resource.clt.mopp.CltContainedFeature(org.feature.multi.perspective.classification.ClassificationPackage.eINSTANCE.getClassification(), FEATURES[0]);
		LINKS[13] = new org.feature.multi.perspective.classification.resource.clt.mopp.CltContainedFeature(org.feature.multi.perspective.classification.ClassificationPackage.eINSTANCE.getClassification(), FEATURES[0]);
		LINKS[14] = new org.feature.multi.perspective.classification.resource.clt.mopp.CltContainedFeature(org.feature.multi.perspective.classification.ClassificationPackage.eINSTANCE.getClassifiedFeature(), FEATURES[1]);
		LINKS[15] = new org.feature.multi.perspective.classification.resource.clt.mopp.CltContainedFeature(org.feature.multi.perspective.classification.ClassificationPackage.eINSTANCE.getClassification(), FEATURES[0]);
		LINKS[16] = new org.feature.multi.perspective.classification.resource.clt.mopp.CltContainedFeature(org.feature.multi.perspective.classification.ClassificationPackage.eINSTANCE.getClassifiedFeature(), FEATURES[1]);
		LINKS[17] = new org.feature.multi.perspective.classification.resource.clt.mopp.CltContainedFeature(org.feature.multi.perspective.classification.ClassificationPackage.eINSTANCE.getClassification(), FEATURES[0]);
	}
	
	public static void initializeLinks() {
		initializeLinks0();
	}
	
	public static void wire0() {
		TERMINALS[0].addFollower(TERMINALS[1], EMPTY_LINK_ARRAY);
		TERMINALS[1].addFollower(TERMINALS[2], EMPTY_LINK_ARRAY);
		TERMINALS[1].addFollower(TERMINALS[3], EMPTY_LINK_ARRAY);
		TERMINALS[2].addFollower(TERMINALS[4], EMPTY_LINK_ARRAY);
		TERMINALS[4].addFollower(TERMINALS[2], EMPTY_LINK_ARRAY);
		TERMINALS[4].addFollower(TERMINALS[3], EMPTY_LINK_ARRAY);
		TERMINALS[4].addFollower(TERMINALS[5], new org.feature.multi.perspective.classification.resource.clt.mopp.CltContainedFeature[] {new org.feature.multi.perspective.classification.resource.clt.mopp.CltContainedFeature(org.feature.multi.perspective.classification.ClassificationPackage.eINSTANCE.getClassification(), FEATURES[0]), });
		TERMINALS[3].addFollower(TERMINALS[6], EMPTY_LINK_ARRAY);
		TERMINALS[6].addFollower(TERMINALS[2], EMPTY_LINK_ARRAY);
		TERMINALS[6].addFollower(TERMINALS[3], EMPTY_LINK_ARRAY);
		TERMINALS[6].addFollower(TERMINALS[5], new org.feature.multi.perspective.classification.resource.clt.mopp.CltContainedFeature[] {new org.feature.multi.perspective.classification.resource.clt.mopp.CltContainedFeature(org.feature.multi.perspective.classification.ClassificationPackage.eINSTANCE.getClassification(), FEATURES[0]), });
		TERMINALS[5].addFollower(TERMINALS[7], EMPTY_LINK_ARRAY);
		TERMINALS[7].addFollower(TERMINALS[8], EMPTY_LINK_ARRAY);
		TERMINALS[8].addFollower(TERMINALS[9], EMPTY_LINK_ARRAY);
		TERMINALS[9].addFollower(TERMINALS[10], EMPTY_LINK_ARRAY);
		TERMINALS[9].addFollower(TERMINALS[11], EMPTY_LINK_ARRAY);
		TERMINALS[10].addFollower(TERMINALS[12], EMPTY_LINK_ARRAY);
		TERMINALS[10].addFollower(TERMINALS[11], EMPTY_LINK_ARRAY);
		TERMINALS[12].addFollower(TERMINALS[12], EMPTY_LINK_ARRAY);
		TERMINALS[12].addFollower(TERMINALS[11], EMPTY_LINK_ARRAY);
		TERMINALS[11].addFollower(TERMINALS[13], new org.feature.multi.perspective.classification.resource.clt.mopp.CltContainedFeature[] {new org.feature.multi.perspective.classification.resource.clt.mopp.CltContainedFeature(org.feature.multi.perspective.classification.ClassificationPackage.eINSTANCE.getClassifiedFeature(), FEATURES[1]), });
		TERMINALS[11].addFollower(TERMINALS[14], EMPTY_LINK_ARRAY);
		TERMINALS[11].addFollower(TERMINALS[5], new org.feature.multi.perspective.classification.resource.clt.mopp.CltContainedFeature[] {new org.feature.multi.perspective.classification.resource.clt.mopp.CltContainedFeature(org.feature.multi.perspective.classification.ClassificationPackage.eINSTANCE.getClassification(), FEATURES[0]), });
		TERMINALS[14].addFollower(TERMINALS[15], EMPTY_LINK_ARRAY);
		TERMINALS[15].addFollower(TERMINALS[13], new org.feature.multi.perspective.classification.resource.clt.mopp.CltContainedFeature[] {new org.feature.multi.perspective.classification.resource.clt.mopp.CltContainedFeature(org.feature.multi.perspective.classification.ClassificationPackage.eINSTANCE.getClassifiedFeature(), FEATURES[2]), });
		TERMINALS[15].addFollower(TERMINALS[16], EMPTY_LINK_ARRAY);
		TERMINALS[16].addFollower(TERMINALS[5], new org.feature.multi.perspective.classification.resource.clt.mopp.CltContainedFeature[] {new org.feature.multi.perspective.classification.resource.clt.mopp.CltContainedFeature(org.feature.multi.perspective.classification.ClassificationPackage.eINSTANCE.getClassification(), FEATURES[0]), });
		TERMINALS[13].addFollower(TERMINALS[17], EMPTY_LINK_ARRAY);
		TERMINALS[17].addFollower(TERMINALS[18], EMPTY_LINK_ARRAY);
	}
	
	public static void wire() {
		wire0();
	}
	
	static {
		// initialize the arrays
		initializeTerminals();
		initializeFeatures();
		initializeLinks();
		// wire the terminals
		wire();
	}
}

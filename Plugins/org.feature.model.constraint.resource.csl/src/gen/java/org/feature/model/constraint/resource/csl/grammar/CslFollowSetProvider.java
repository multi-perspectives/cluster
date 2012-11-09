/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.model.constraint.resource.csl.grammar;

/**
 * This class provides the follow sets for all terminals of the grammar. These
 * sets are used during code completion.
 */
public class CslFollowSetProvider {
	
	public final static org.feature.model.constraint.resource.csl.ICslExpectedElement TERMINALS[] = new org.feature.model.constraint.resource.csl.ICslExpectedElement[6];
	
	public final static org.eclipse.emf.ecore.EStructuralFeature[] FEATURES = new org.eclipse.emf.ecore.EStructuralFeature[1];
	
	public final static org.feature.model.constraint.resource.csl.mopp.CslContainedFeature[] LINKS = new org.feature.model.constraint.resource.csl.mopp.CslContainedFeature[2];
	
	public final static org.feature.model.constraint.resource.csl.mopp.CslContainedFeature[] EMPTY_LINK_ARRAY = new org.feature.model.constraint.resource.csl.mopp.CslContainedFeature[0];
	
	public static void initializeTerminals0() {
		TERMINALS[0] = new org.feature.model.constraint.resource.csl.mopp.CslExpectedStructuralFeature(org.feature.model.constraint.resource.csl.grammar.CslGrammarInformationProvider.CSL_1_0_0_0);
		TERMINALS[1] = new org.feature.model.constraint.resource.csl.mopp.CslExpectedStructuralFeature(org.feature.model.constraint.resource.csl.grammar.CslGrammarInformationProvider.CSL_2_0_0_0);
		TERMINALS[2] = new org.feature.model.constraint.resource.csl.mopp.CslExpectedCsString(org.feature.model.constraint.resource.csl.grammar.CslGrammarInformationProvider.CSL_1_0_0_2);
		TERMINALS[3] = new org.feature.model.constraint.resource.csl.mopp.CslExpectedStructuralFeature(org.feature.model.constraint.resource.csl.grammar.CslGrammarInformationProvider.CSL_1_0_0_4);
		TERMINALS[4] = new org.feature.model.constraint.resource.csl.mopp.CslExpectedCsString(org.feature.model.constraint.resource.csl.grammar.CslGrammarInformationProvider.CSL_2_0_0_2);
		TERMINALS[5] = new org.feature.model.constraint.resource.csl.mopp.CslExpectedStructuralFeature(org.feature.model.constraint.resource.csl.grammar.CslGrammarInformationProvider.CSL_2_0_0_4);
	}
	
	public static void initializeTerminals() {
		initializeTerminals0();
	}
	
	public static void initializeFeatures0() {
		FEATURES[0] = org.feature.model.constraint.ConstraintPackage.eINSTANCE.getConstraint().getEStructuralFeature(org.feature.model.constraint.ConstraintPackage.CONSTRAINT__EXPRESSION);
	}
	
	public static void initializeFeatures() {
		initializeFeatures0();
	}
	
	public static void initializeLinks0() {
		LINKS[0] = new org.feature.model.constraint.resource.csl.mopp.CslContainedFeature(org.feature.model.constraint.ConstraintPackage.eINSTANCE.getRequire(), FEATURES[0]);
		LINKS[1] = new org.feature.model.constraint.resource.csl.mopp.CslContainedFeature(org.feature.model.constraint.ConstraintPackage.eINSTANCE.getExclude(), FEATURES[0]);
	}
	
	public static void initializeLinks() {
		initializeLinks0();
	}
	
	public static void wire0() {
		TERMINALS[0].addFollower(TERMINALS[2], EMPTY_LINK_ARRAY);
		TERMINALS[2].addFollower(TERMINALS[3], EMPTY_LINK_ARRAY);
		TERMINALS[1].addFollower(TERMINALS[4], EMPTY_LINK_ARRAY);
		TERMINALS[4].addFollower(TERMINALS[5], EMPTY_LINK_ARRAY);
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

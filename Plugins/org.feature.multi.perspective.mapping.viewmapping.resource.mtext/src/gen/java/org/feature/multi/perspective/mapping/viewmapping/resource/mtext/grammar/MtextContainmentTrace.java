/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar;

/**
 * A MtextContainmentTrace represents a specific path to a structural feature by
 * navigating over a set of a structural feature from a start class.
 * MtextContainmentTraces are used during code completion to reconstruct
 * containment trees that are not created by the parser, for example, if the first
 * character of the contained object has not been typed yet.
 */
public class MtextContainmentTrace {
	
	/**
	 * The class where the trace starts.
	 */
	private org.eclipse.emf.ecore.EClass startClass;
	
	/**
	 * The path of contained features.
	 */
	private org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextContainedFeature[] path;
	
	public MtextContainmentTrace(org.eclipse.emf.ecore.EClass startClass, org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextContainedFeature[] path) {
		super();
		// Verify arguments
		if (startClass != null) {
			if (path.length > 0) {
				org.eclipse.emf.ecore.EStructuralFeature feature = path[path.length - 1].getFeature();
				if (!startClass.getEAllStructuralFeatures().contains(feature)) {
					throw new RuntimeException("Metaclass " + startClass.getName() + " must contain feature " + feature.getName());
				}
			}
		}
		this.startClass = startClass;
		this.path = path;
	}
	
	public org.eclipse.emf.ecore.EClass getStartClass() {
		return startClass;
	}
	
	public org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextContainedFeature[] getPath() {
		return path;
	}
	
	public String toString() {
		return (startClass == null ? "null" : startClass.getName()) + "->" + org.feature.multi.perspective.mapping.viewmapping.resource.mtext.util.MtextStringUtil.explode(path, "->");
	}
	
}

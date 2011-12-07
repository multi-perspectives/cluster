/**
 * 
 */
package org.feature.cluster.model.editor.util;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.emf.common.util.EList;
import org.eclipse.swt.graphics.Color;
import org.eclipse.zest.core.widgets.GraphConnection;
import org.eclipse.zest.core.widgets.GraphNode;
import org.featuremapper.models.feature.Constraint;
import org.featuremapper.models.feature.Feature;

/**
 * Utility class for the cluster editor.
 * @author Tim Winkelmann
 * 
 */
public class Util {
	public static final Color attachedGraphNodeBackgroundColor = ColorConstants.green;
	public static final Color unattachedGraphNodeBackgroundColor = new Color(null, 216, 228, 248);
	public static final Color attachedGraphConnectionLineColor = ColorConstants.green;
	public static final Color unattachedGraphConnectionLineColor = new Color(null, 192, 192, 192);
	public static List<GraphNode> attachedGraphNodes = new LinkedList<GraphNode>();
	public static List<GraphConnection> highlightedGraphConnections = new LinkedList<GraphConnection>();
	
	/**
	 * checks the hierarchy of the features, the cardininalities and the constraint.
	 * @return true is it is consistent.
	 */
	public static boolean isConsistent(Set<Feature> features){
		return  checkHierarchy(features) & checkCardinalities(features) & checkConstraints(features);
	}

	/**
	 * checks every constraint from the features.
	 * @return true if every constraint related feature is in features
	 */
	private static boolean checkConstraints(Set<Feature> features) {
		for (Feature feature : features) {
			EList<Constraint> constraints = feature.getConstraints();
			for (Constraint constraint : constraints) {
				// check constraint
				if(features.containsAll(constraint.getConstrainedFeatures())){
					if (constraint.getLanguage().equals("OWL")) {
						boolean exprCheck = false;
						for (Feature feature2 : features) {
							if (constraint.getExpression().contains(feature2.getName())) {
								exprCheck = true;
								break;
							}
						}
						if (!exprCheck) {
//							log.debug("Constraintcheck: expression doesnt fit");
							return false;
						}
					}
				}else{
//					log.debug("Constraintcheck: missing feature");
					return false;
				}
			}
		}
		return true;
	}
	
	/**
	 * checks the cardinalities from the features.
	 * @return true if a no cardinality is compromised
	 */
	private static boolean checkCardinalities(Set<Feature> features) {
		for (Feature feature : features) {
			EList<org.featuremapper.models.feature.Group> groups = feature.getGroups();
			for (org.featuremapper.models.feature.Group fGroup : groups) {
				if (fGroup.getMinCardinality() > 0) {
					EList<Feature> childFeatures = fGroup.getChildFeatures();
					int i = 0;
					for (Feature feature2 : childFeatures) {
						if (features.contains(feature2)) {
							i++;
						}
					}
					if (i < fGroup.getMinCardinality()) {
//						log.debug("Cardinalitycheck: " + feature.getName() + " l:" + fGroup.getMinCardinality() + " l':" + i);
						return false;
					}
				}
			}
		}
		return true;
	}
	
	/**
	 * checks every ancestor from all features
	 * @return true if the hierarchy is complete for all features
	 */
	private static boolean checkHierarchy(Set<Feature> features) {
		for (Feature feature : features) {
			if (!checkAncestors(feature,features)) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * checks the ancestors of a feature.
	 * @param feature the feature to be checked.
	 * @return true if the hierarchy is complete
	 */
	private static boolean checkAncestors(Feature feature,Set<Feature> features) {
		if (feature.getParentGroup() == null) {
			return true;//root feature
		}
		Feature parentFeature = feature.getParentGroup().getParentFeature();
		if (features.contains(parentFeature)) {
			return checkAncestors(parentFeature,features);
		}else{
//			log.debug("\t" + feature.getName() + " is missing his parent: " + parentFeature.getName());
			return false;
		}
	}
}

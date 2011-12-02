package org.feature.cluster.model.editor.editors;

import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.feature.cluster.model.cluster.Group;
import org.featuremapper.models.feature.Constraint;
import org.featuremapper.models.feature.Feature;

public class View {
//	private static Logger log = Logger.getLogger(View.class);
	EObject group;
	Set<Feature> features;
	
	/**
	 * @param group
	 * @param features
	 */
	public View(EObject group, Set<Feature> features) {
		super();
		this.group = group;
		this.features = features;
	}
	
	/**
	 * checks if the view can be used as a viewpoint
	 * @return true if this is a viewpoint.
	 */
	public boolean isViewPoint(){
		if (this.group instanceof Group) {
			Group group = (Group) this.group;
			return !group.getViewPointReference().isEmpty();
		}else{
			return false;//core group
		}
	}
	
	/**
	 * checks the hierarchy of the features, the cardninalities and the constraint
	 * @return
	 */
	public boolean isConsistent(){
		return checkHierarchy() & checkCardinalities() & checkConstraints();
	}

	/**
	 * checks every constraint from the features.
	 * @return true if every constraint related feature is in features
	 */
	private boolean checkConstraints() {
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
	private boolean checkCardinalities() {
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
	private boolean checkHierarchy() {
		for (Feature feature : features) {
			if (!checkAncestors(feature)) {
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
	private boolean checkAncestors(Feature feature) {
		if (feature.getParentGroup() == null) {
			return true;//root feature
		}
		Feature parentFeature = feature.getParentGroup().getParentFeature();
		if (features.contains(parentFeature)) {
			return checkAncestors(parentFeature);
		}else{
//			log.debug("\t" + feature.getName() + " is missing his parent: " + parentFeature.getName());
			return false;
		}
	}
}

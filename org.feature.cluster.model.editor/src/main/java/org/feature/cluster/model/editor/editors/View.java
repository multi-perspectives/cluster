package org.feature.cluster.model.editor.editors;

import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.feature.cluster.model.cluster.Group;
import org.feature.cluster.model.editor.util.Util;
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
	 * checks the hierarchy of the features, the cardininalities and the constraint
	 * @return
	 */
	public boolean isConsistent(){
		return Util.isConsistent(features);
	}
}

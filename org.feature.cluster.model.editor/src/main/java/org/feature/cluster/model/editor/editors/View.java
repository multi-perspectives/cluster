package org.feature.cluster.model.editor.editors;

import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.feature.cluster.model.cluster.Group;
import org.feature.cluster.model.cluster.GroupModel;
import org.feature.cluster.model.editor.util.Util;
import org.featuremapper.models.feature.Feature;

/**
 * This class represents a mapping between a {@link Group} from the {@link GroupModel} and a {@link Set} of {@link Feature}. 
 * @author Tim Winkelmann
 *
 */
public class View {
//	private static Logger log = Logger.getLogger(View.class);
	private EObject group;
	private Set<Feature> features;
	
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
	 * checks the hierarchy of the features, the cardinalities and the constraint.
	 * @return true if no violation is found.
	 */
	public boolean isConsistent(){
		return Util.isConsistent(features);
	}

	/**
	 * @return the group
	 */
	public EObject getGroup() {
		return group;
	}

	/**
	 * @return the features
	 */
	public Set<Feature> getFeatures() {
		return features;
	}
}

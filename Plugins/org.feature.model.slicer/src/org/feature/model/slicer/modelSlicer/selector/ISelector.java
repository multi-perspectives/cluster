package org.feature.model.slicer.modelSlicer.selector;

import java.util.List;
import java.util.Set;

import de.tud.es.madras.featuresc.model.SCFeature;

/**
 * Interface for selector implementations, which choose one feature and set it
 * to static. The default selection does not process consequences of selection.
 * To process this, a special method should be called.
 * 
 * @author Ingo Reimund
 * @create 13.05.2012
 * 
 */
public interface ISelector {

	/**
	 * select one of the features and set this feature to static
	 * 
	 * @param children
	 *            list of selectable features
	 * @return list of changed features
	 */
	public List<SCFeature> select(Set<SCFeature> children);
}
package org.feature.model.slicer.modelSlicer.remover;

import de.tud.es.madras.featuresc.model.SCFeature;
import de.tud.es.madras.featuresc.model.SCModel;

/**
 * interface for a remove action of a feature. To Remove a feature out of a
 * model is not a simple process, because you have to handle dependencies and
 * children
 * 
 * @author Ingo Reimund
 * @create 27.06.2012
 * 
 */
public interface IRemover {

	/**
	 * remove a feature
	 * 
	 * @param toRemove
	 *            feature to remove
	 * @param model
	 *            which contains the feature
	 * @return true if the feature was remove, else false
	 */
	public boolean remove(SCFeature removed, SCModel model);
}
package org.feature.model.slicer.modelSlicer.remover;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.tud.es.madras.featuresc.FeatureSCMessages;
import de.tud.es.madras.featuresc.model.SCFeature;
import de.tud.es.madras.featuresc.model.SCModel;

/**
 * simple replacer replace a removed feature with an pseudo feature
 * 
 * @author Ingo Reimund
 * @create 27.06.2012
 * 
 */
public class SimpleReplacer extends SimpleRemover {

	/**
	 * Logger
	 */
	private static Logger logger = LoggerFactory.getLogger(SimpleRemover.class);

	/**
	 * messages
	 */
	private FeatureSCMessages messages = FeatureSCMessages.getInstance();

	@Override
	public boolean remove(SCFeature removed, SCModel model) {
		logger.debug("change feature '{}' to pseudo feature", removed.getName());
		removeDependencies(removed);
		removed.setName(removed.getName() + " " + messages.get(FeatureSCMessages.FEATURE_PSEUDO));
		model.add(removed);
		return true;
	}
}
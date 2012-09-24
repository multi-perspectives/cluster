package org.feature.model.slicer.modelSlicer.remover;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.tud.es.madras.featuresc.model.FeatureType;
import de.tud.es.madras.featuresc.model.SCFeature;
import de.tud.es.madras.featuresc.model.SCModel;
import de.tud.es.madras.featuresc.model.transformer.AlternativeTransformer;
import de.tud.es.madras.featuresc.model.transformer.OrTransformer;

/**
 * remove a feature and process some transformation if it is required
 * 
 * @author Ingo Reimund
 * @create 27.06.2012
 * 
 */
public class TransformRemover extends SimpleRemover {

	/**
	 * Logger
	 */
	private static Logger logger = LoggerFactory.getLogger(TransformRemover.class);

	/**
	 * transformer for or groups
	 */
	private OrTransformer orTransformer = new OrTransformer();

	/**
	 * transformer for alternative groups
	 */
	private AlternativeTransformer alternativeTransformer = new AlternativeTransformer();

	@Override
	public boolean remove(SCFeature removed, SCModel model) {
		logger.info("remove feature '{}'", removed.getName());
		SCFeature parent = removed.getParent();
		super.remove(removed, model);
		logger.info("finish removing");

		switch (removed.getType()) {
		case OR:
			logger.debug("transform remaining 'or' children of the parent, if necessary");
			orTransformer.transform(parent.getChildren(FeatureType.OR), removed);
			break;
		case ALTERNATIVE:
			logger.debug("transform remaining 'alternative' children of the parent '{}', if necessary", parent.getName());
			alternativeTransformer.transform(parent.getChildren(FeatureType.ALTERNATIVE), removed);
			break;
		}
		return true;
	}
}
package org.feature.model.slicer.modelSlicer.selector;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.tud.es.madras.featuresc.FeatureSCProperties;
import de.tud.es.madras.featuresc.model.SCFeature;
import de.tud.es.madras.featuresc.model.SCProperty;
import de.tud.es.madras.featuresc.model.BoundedType;

/**
 * Class to choose one feature of a list of selectable features and set this
 * feature to static. The default selection does not process consequences of
 * selection.
 * 
 * @author Ingo Reimund
 * @create 13.05.2012
 * 
 */
public class OrSelector implements ISelector {

	/**
	 * Logger
	 */
	private static Logger logger = LoggerFactory.getLogger(OrSelector.class);


	/**
	 * properties
	 */
	private FeatureSCProperties properties = FeatureSCProperties.getInstance();

	/**
	 * name of the property which contains the variability
	 */
	private String nameVProperty;

	/**
	 * type of the property which contains the variability
	 */
	private String typeVProperty;

	/**
	 * initialize or transformer
	 */
	public OrSelector() {
		nameVProperty = properties.getString(FeatureSCProperties.PROPERTY_TYPE_VARIABILITY_GENERATED);
		typeVProperty = properties.getString(FeatureSCProperties.PROPERTY_VALUE_TYPE_STRING);
	}

	@Override
	public List<SCFeature> select(Set<SCFeature> children) {
		List<SCFeature> changed = new ArrayList<>();
		if (children.isEmpty()) {
			logger.info("list is empty, nothing to do");
			return changed;
		}

		String variability = BoundedType.ALIVE.toString();
		SCProperty staticProperty = new SCProperty(nameVProperty, variability, typeVProperty, true, false);
		staticProperty.setRequired(true);

		for(SCFeature child : children) {
			String value = child.getProperty(nameVProperty).getValue();
			
			if (BoundedType.value(value) == BoundedType.UNBOUND) {
				child.addProperty(staticProperty);
				changed.add(child);
				return changed;
			}
		}
		return changed;
	}
}
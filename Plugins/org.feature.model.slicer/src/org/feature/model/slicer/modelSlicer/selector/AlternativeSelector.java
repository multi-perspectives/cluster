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
 * feature to static and the other to dead, because the list of features are an
 * alternative group and only one feature can be selected. The default selection
 * does not process consequences of selection.
 * 
 * @author Ingo Reimund
 * @create 13.05.2012
 * 
 */
public class AlternativeSelector implements ISelector {

	/**
	 * Logger
	 */
	private static Logger logger = LoggerFactory.getLogger(AlternativeSelector.class);

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
	public AlternativeSelector() {
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

		logger.debug("search for dynamic child to set static");
		for (SCFeature child : children) {
			String value = child.getProperty(nameVProperty).getValue();

			if (BoundedType.value(value) == BoundedType.UNBOUND) {
				logger.debug("change feature '{}' to static", child.getName());
				String variability = BoundedType.ALIVE.toString();
				SCProperty property = new SCProperty(nameVProperty, variability, typeVProperty, true, false);
				property.setRequired(true);
				child.addProperty(property);
				changed.add(child);
				break;
			}
		}
		return changed;
	}
}
package org.feature.model.slicer.modelSlicer.reasoner;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.tud.es.madras.featuresc.FeatureSCMessages;
import de.tud.es.madras.featuresc.FeatureSCProperties;
import de.tud.es.madras.featuresc.model.DependencyType;
import de.tud.es.madras.featuresc.model.FeatureType;
import de.tud.es.madras.featuresc.model.InvalidModelException;
import de.tud.es.madras.featuresc.model.SCFeature;
import de.tud.es.madras.featuresc.model.SCProperty;
import de.tud.es.madras.featuresc.model.BoundedType;

/**
 * Process consequence of changed features
 * 
 * @author Ingo Reimund
 * @create 13.05.2012
 * 
 */
public class SimpleReasoner {

	/**
	 * Logger
	 */
	private static Logger logger = LoggerFactory.getLogger(SimpleReasoner.class);

	/**
	 * properties
	 */
	private FeatureSCProperties properties = FeatureSCProperties.getInstance();

	/**
	 * messages
	 */
	private FeatureSCMessages messages = FeatureSCMessages.getInstance();

	/**
	 * name of the property which contains the variability
	 */
	private String nameVProperty;

	/**
	 * type of the property which contains the variability
	 */
	private String typeVProperty;

	private LinkedList<SCFeature> changed = new LinkedList<>();

	/**
	 * initialize or transformer
	 */
	public SimpleReasoner() {
		nameVProperty = properties.getString(FeatureSCProperties.PROPERTY_TYPE_VARIABILITY_GENERATED);
		typeVProperty = properties.getString(FeatureSCProperties.PROPERTY_VALUE_TYPE_STRING);
	}

	/**
	 * process reasoning of changed feature.
	 * 
	 * @param changed
	 * @throws InvalidModelException 
	 */
	public void reasoning(List<SCFeature> changedFeatures) throws InvalidModelException {
		changed.addAll(changedFeatures);

		while (!changed.isEmpty()) {

			SCFeature feature = changed.removeFirst();
			if (!feature.containsProperty(nameVProperty)) {
				continue;
			}

			String type = feature.getProperty(nameVProperty).getValue();
			switch (BoundedType.value(type)) {
			case DEAD:
				logger.info("process consequences of dead feature '{}'", feature.getName());
				processDeadConsequences(feature);
				break;
			case ALIVE:
				logger.info("process consequences of static feature '{}'", feature.getName());
				processStaticConsequences(feature);
				break;
			}
		}
	}

	/**
	 * process all consequences of the given dead feature
	 * 
	 * @param feature
	 * @throws InvalidModelException 
	 */
	protected void processDeadConsequences(SCFeature feature) throws InvalidModelException {
		processDeadParent(feature, feature.getParent());
		processDeadChildren(feature);
		processDeadRequiredFromDependencies(feature.getDependencies(DependencyType.REQUIRE_FROM));
		processDeadGroup(feature, feature.getParent());
	}

	/**
	 * process required from dependencies of a dead feature
	 * 
	 * @param requiredFrom
	 *            list of features which require this feature
	 * @throws InvalidModelException 
	 */
	protected void processDeadRequiredFromDependencies(List<SCFeature> requiredFrom) throws InvalidModelException {
		logger.info("process consequences for required from of dead feature");
		for (SCFeature required : requiredFrom) {
			changeToDead(required);
		}
	}

	/**
	 * process parent of a dead feature
	 * 
	 * @param feature
	 *            dead feature
	 * @param parent
	 *            parent of the dead feature
	 * @throws InvalidModelException 
	 */
	protected void processDeadParent(SCFeature feature, SCFeature parent) throws InvalidModelException {
		logger.info("process consequences for parent of dead mandatory feature");
		if (parent != null) {

			if (feature.getType() == FeatureType.MANDATORY) {
				changeToDead(parent);
			}
		}
	}

	/**
	 * process group of static feature. If the group is a alternative or a or
	 * group, this method should transform the other feature of the group
	 * 
	 * @param feature
	 *            feature which part of the group
	 * @param parent
	 *            of the group
	 * @throws InvalidModelException 
	 */
	protected void processDeadGroup(SCFeature feature, SCFeature parent) throws InvalidModelException {
		if (feature.getType() == FeatureType.ALTERNATIVE) {
			logger.info("process consequences for alternative group of dead feature");

			for (SCFeature child : parent.getChildren(FeatureType.ALTERNATIVE)) {
				String type = child.getProperty(nameVProperty).getValue();
				if (BoundedType.value(type) != BoundedType.DEAD) {
					logger.debug("not all elements of feature '{}' are dead", parent.getName());
					return;
				}
				changeToDead(parent);
			}
		}

		if (feature.getType() == FeatureType.OR) {

			for (SCFeature child : parent.getChildren(FeatureType.OR)) {
				logger.info("process consequences for or group of dead feature");
				String type = child.getProperty(nameVProperty).getValue();

				if (BoundedType.value(type) != BoundedType.DEAD) {
					logger.debug("not all elements of feature '{}' are dead", parent.getName());
					return;
				}

				changeToDead(parent);
			}
		}
	}

	/**
	 * process children of the given dead feature
	 * 
	 * @param feature
	 *            dead feature
	 * @throws InvalidModelException 
	 */
	protected void processDeadChildren(SCFeature feature) throws InvalidModelException {
		logger.info("process consequences for children of dead feature");
		for (FeatureType type : FeatureType.values()) {
			for (SCFeature child : feature.getChildren(type)) {
				changeToDead(child);
			}
		}
	}

	/**
	 * process all consequences of the given static feature
	 * 
	 * @param feature
	 * @throws InvalidModelException 
	 */
	protected void processStaticConsequences(SCFeature feature) throws InvalidModelException {
		processStaticParent(feature, feature.getParent());
		processStaticMandatoryChildren(feature.getChildren(FeatureType.MANDATORY));
		processStaticRequireDependencies(feature.getDependencies(DependencyType.REQUIRE));
		processStaticExcludeDependencies(feature.getDependencies(DependencyType.EXCLUDE));
		processStaticGroup(feature);
	}

	/**
	 * process group of static feature. If the group is a alternative group,
	 * this method should transform the oder feature to dead.
	 * 
	 * @param children
	 *            feature which part of the group
	 * @throws InvalidModelException 
	 */
	protected void processStaticGroup(SCFeature feature) throws InvalidModelException {
		if (feature.getType() == FeatureType.ALTERNATIVE) {

			for (SCFeature alternative : feature.getParent().getChildren(FeatureType.ALTERNATIVE)) {
				String type = alternative.getProperty(nameVProperty).getValue();
				if (BoundedType.value(type) == BoundedType.UNBOUND) {
					changeToDead(alternative);
				}
			}
		}
	}

	/**
	 * process parent of a static feature
	 * 
	 * @param children
	 *            parent of static feature which should be static
	 * @throws InvalidModelException 
	 * @parent of the feature
	 */
	protected void processStaticParent(SCFeature feature, SCFeature parent) throws InvalidModelException {
		logger.info("process consequences for parent of static feature");
		if (parent != null) {
			changeToStatic(parent);
		}
	}

	/**
	 * process mandatory child of a static feature
	 * 
	 * @param children
	 *            mandatory children which should be set to static
	 * @throws InvalidModelException 
	 */
	protected void processStaticMandatoryChildren(Set<SCFeature> children) throws InvalidModelException {
		logger.info("process consequences for mandatory children of static feature");
		for (SCFeature child : children) {
			changeToStatic(child);
		}
	}

	/**
	 * process require dependencies of a static feature
	 * 
	 * @param requires
	 *            required features which should set to static
	 * @throws InvalidModelException 
	 */
	protected void processStaticRequireDependencies(List<SCFeature> requires) throws InvalidModelException {
		logger.info("process consequences for require dependencies of static feature");
		for (SCFeature child : requires) {
			changeToStatic(child);
		}
	}

	/**
	 * process exclude dependencies of a static feature
	 * 
	 * @param excludes
	 *            excludes features which should set to dead
	 * @throws InvalidModelException 
	 */
	protected void processStaticExcludeDependencies(List<SCFeature> excludes) throws InvalidModelException {
		logger.info("process consequences for exclude dependencies of static feature");
		for (SCFeature child : excludes) {
			changeToDead(child);
		}
	}

	/**
	 * change feature variability to dead. If the feature is static, this method
	 * throws an exception
	 * 
	 * @param feature
	 *            set to dead
	 * @throws InvalidModelException 
	 */
	void changeToDead(SCFeature feature) throws InvalidModelException {
		String type = feature.getProperty(nameVProperty).getValue();
		switch (BoundedType.value(type)) {
		case DEAD:
			return;
		case ALIVE:
			String className = getClass().getSimpleName();
			String featureName = feature.getName();
			String message = messages.get(FeatureSCMessages.MODEL_INVALID, className, featureName, type, "DEAD");
			changed.clear();
			logger.error(message);
			throw new InvalidModelException(message);
		default:
			logger.info("change feature '{}' to dead", feature.getName());
			String variability = BoundedType.DEAD.toString();
			SCProperty property = new SCProperty(nameVProperty, variability, typeVProperty, true, false);
			property.setRequired(true);
			feature.addProperty(property);
			changed.add(feature);
		}
	}

	/**
	 * change feature variability to static. If the feature is dead, this method
	 * throws an exception
	 * 
	 * @param feature
	 *            set to static
	 * @throws InvalidModelException
	 */
	void changeToStatic(SCFeature feature) throws InvalidModelException {
		String type = feature.getProperty(nameVProperty).getValue();
		switch (BoundedType.value(type)) {
		case ALIVE:
			return;
		case DEAD:
			String className = getClass().getSimpleName();
			String featureName = feature.getName();
			String message = messages.get(FeatureSCMessages.MODEL_INVALID, className, featureName,  type, "STATIC");
			changed.clear();
			logger.error(message);
			throw new InvalidModelException(message);
		default:
			logger.info("change feature '{}' to static", feature.getName());
			String variability = BoundedType.ALIVE.toString();
			SCProperty property = new SCProperty(nameVProperty, variability, typeVProperty, true, false);
			property.setRequired(true);
			feature.addProperty(property);
			changed.add(feature);
		}
	}
}
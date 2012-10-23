package org.feature.model.slicer.extendedModel.classification;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.featuremapper.models.feature.Attribute;
import org.featuremapper.models.feature.Feature;
import org.featuremapper.models.feature.FeatureModel;

/**
 * 
 * Class is a meta-data container for a feature model that handles the
 * classificatin state of all features
 * 
 * @author saller
 * 
 */
public class ClassifierHandler {

	/**
	 * string specification how features are classified wihtin the feature model
	 */
	private final String attributeStringBoundAlive = "alive";
	private final String attributeStringBoundDead = "dead";
	private final String attributeStringUnbound = "unbound";
	private final String attributeStringNotClassified = "notclassified";
	private final String attributePrefix = "es:variabilityType";

	/**
	 * mapping of a feature to its classification. if feature is not classified,
	 * it is not contained
	 */
	private Map<Feature, BoundedType> featureToClassification;
	/**
	 * unbound features
	 */
	private Set<Feature> unboundSet;
	/**
	 * bound alive features
	 */
	private Set<Feature> boundAliveSet;
	/**
	 * bound dead features
	 */
	private Set<Feature> boundDeadSet;
	/**
	 * not classified features
	 */
	private Set<Feature> notClassifiedSet;
	/**
	 * features that were classified to compute transitive closure
	 */
	private Set<Feature> computedClassificationSet;

	/**
	 * the classified feature model
	 */
	private FeatureModel featureModel;

	/**
	 * initialize handler but do not parse feature model for initial
	 * classification
	 */
	public ClassifierHandler() {
		featureToClassification = new HashMap<Feature, BoundedType>();
		unboundSet = new HashSet<Feature>();
		boundAliveSet = new HashSet<Feature>();
		boundDeadSet = new HashSet<Feature>();
		notClassifiedSet = new HashSet<Feature>();
		computedClassificationSet = new HashSet<Feature>();
	}

	/**
	 * initialize handler wiht the classified feature model and derive basic
	 * classification (not transitive closure)
	 * 
	 * @param fm
	 *            (partially) classified feature model
	 */
	public ClassifierHandler(FeatureModel fm) {
		this.featureModel = fm;
		featureToClassification = new HashMap<Feature, BoundedType>();
		unboundSet = new HashSet<Feature>();
		boundAliveSet = new HashSet<Feature>();
		boundDeadSet = new HashSet<Feature>();
		notClassifiedSet = new HashSet<Feature>();
		computedClassificationSet = new HashSet<Feature>();

		notClassifiedSet.addAll(fm.getAllFeatures());

		init();
	}

	/**
	 * derive initial classification (without transitive closure)
	 */
	private void init() {
		for (Feature f : featureModel.getAllFeatures()) {
			String classifiedValue = "";

			for (Attribute a : f.getAttributes()) {

				if (a.getName().equals(attributePrefix)) {
					classifiedValue = a.getValue();
					break;
				}
			}

			switch (classifiedValue) {

			case (""):
				continue;

			case (attributeStringBoundAlive):
				classifyBoundAlive(f, true);
				break;

			case (attributeStringBoundDead):
				classifyBoundDead(f, true);
				break;

			case (attributeStringUnbound):
				classifyUnbound(f, true);
				break;

			case (attributeStringNotClassified):
				classifyNotClassified(f, true);
				break;

			default:
				break;
			}
		}
	}

	/**
	 * remove the classification of a feature within the internal representation
	 * 
	 * @param f
	 *            feature that should NOT be classified
	 * @param manualClassifed
	 *            manual annotation or computational annotation
	 */
	public void classifyNotClassified(Feature f, boolean manualClassifed) {
		if (!manualClassifed)
			computedClassificationSet.add(f);

		if (notClassifiedSet.contains(f)) {
			return;
		}

		notClassifiedSet.add(f);
		unboundSet.remove(f);
		boundDeadSet.remove(f);
		boundAliveSet.remove(f);

		featureToClassification.remove(f);
	}

	/**
	 * 
	 * @param f
	 *            Feature that should be classified as bound alive
	 * @param manualClassifed
	 *            manual annotation or computational annotation
	 */
	public void classifyBoundAlive(Feature f, boolean manualClassifed) {

		if (!manualClassifed)
			computedClassificationSet.add(f);

		if (featureToClassification.containsKey(f)) {
			if (featureToClassification.get(f).equals(BoundedType.ALIVE))
				return;
			else
				featureToClassification.remove(f);
		}

		notClassifiedSet.remove(f);
		unboundSet.remove(f);
		boundDeadSet.remove(f);
		boundAliveSet.add(f);

		featureToClassification.put(f, BoundedType.ALIVE);
	}

	/**
	 * 
	 * @param f
	 *            feature that should be classified as bound dead
	 * @param manualClassifed
	 *            manual annotation or computational annotation
	 */
	public void classifyBoundDead(Feature f, boolean manualClassifed) {

		if (!manualClassifed)
			computedClassificationSet.add(f);

		if (featureToClassification.containsKey(f)) {
			if (featureToClassification.get(f).equals(BoundedType.DEAD))
				return;
			else
				featureToClassification.remove(f);
		}

		notClassifiedSet.remove(f);
		unboundSet.remove(f);
		boundAliveSet.remove(f);
		boundDeadSet.add(f);

		featureToClassification.put(f, BoundedType.DEAD);
	}

	/**
	 * 
	 * @param f
	 *            feature that should be classified as unbound
	 * @param manualClassifed
	 *            manual annotation or computational annotation
	 */
	public void classifyUnbound(Feature f, boolean manualClassifed) {

		if (!manualClassifed)
			computedClassificationSet.add(f);

		if (featureToClassification.containsKey(f)) {
			if (featureToClassification.get(f).equals(BoundedType.UNBOUND))
				return;
			else
				featureToClassification.remove(f);
		}

		notClassifiedSet.remove(f);
		boundAliveSet.remove(f);
		boundDeadSet.remove(f);
		unboundSet.add(f);

		featureToClassification.put(f, BoundedType.UNBOUND);
	}

	/**
	 * 
	 * @param f
	 */
	public void removeClassification(Feature f) {

		featureToClassification.remove(f);
		notClassifiedSet.add(f);
		boundAliveSet.remove(f);
		boundDeadSet.remove(f);
		unboundSet.remove(f);

	}

	/**
	 * 
	 * @return set of unbound features
	 */
	public Set<Feature> getUnboundFeatures() {
		return unboundSet;
	}

	/**
	 * 
	 * @return set of bound alive features
	 */
	public Set<Feature> getBoundAliveFeatures() {
		return boundAliveSet;
	}

	/**
	 * 
	 * @return set of bound dead features
	 */
	public Set<Feature> getBoundDeadFeatures() {
		return boundDeadSet;
	}

	/**
	 * 
	 * @return true if everything is classified
	 */
	public boolean isCompletelyClassified() {
		return notClassifiedSet.isEmpty();
	}

	/**
	 * 
	 * @return set of not-classified features
	 */
	public Set<Feature> getNonClassifiedFeatures() {
		return notClassifiedSet;
	}

	/**
	 * 
	 * @return set of features that were classified by algorithm
	 */
	public Set<Feature> getComputedClassifications() {
		return computedClassificationSet;
	}

}

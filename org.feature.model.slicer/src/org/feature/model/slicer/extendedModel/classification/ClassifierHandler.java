package org.feature.model.slicer.extendedModel.classification;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.featuremapper.models.feature.Attribute;
import org.featuremapper.models.feature.Feature;
import org.featuremapper.models.feature.FeatureModel;

public class ClassifierHandler {

	private final String attributeStringBoundAlive = "alive";
	private final String attributeStringBoundDead = "dead";
	private final String attributeStringUnbound = "unbound";
	private final String attributePrefix = "es:variabilityType";

	private Map<Feature, BoundedType> featureToClassification;
	private Set<Feature> unboundSet;
	private Set<Feature> boundAliveSet;
	private Set<Feature> boundDeadSet;
	private Set<Feature> notClassifiedSet;
	private Set<Feature> computedClassificationSet;

	private FeatureModel featureModel;

	public ClassifierHandler() {
		featureToClassification = new HashMap<Feature, BoundedType>();
		unboundSet = new HashSet<Feature>();
		boundAliveSet = new HashSet<Feature>();
		boundDeadSet = new HashSet<Feature>();
		notClassifiedSet = new HashSet<Feature>();
		computedClassificationSet = new HashSet<Feature>();
	}
	
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

			default:
				break;
			}
		}
	}

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

	public void removeClassification(Feature f) {

		featureToClassification.remove(f);
		notClassifiedSet.add(f);
		boundAliveSet.remove(f);
		boundDeadSet.remove(f);
		unboundSet.remove(f);

	}

	public Set<Feature> getUnboundFeatures() {
		return unboundSet;		
	}
	
	public Set<Feature> getBoundAliveFeatures() {
		return boundAliveSet;		
	}
	
	public Set<Feature> getBoundDeadFeatures() {
		return boundDeadSet;		
	}
	
	public boolean isReadyForSlicing(){
		return notClassifiedSet.isEmpty();
	}
	
	public Set<Feature> getNonClassifiedFeatures(){
		return notClassifiedSet;
	}
	
	public Set<Feature> getComputedClassifications(){
		return computedClassificationSet;
	}
	
}

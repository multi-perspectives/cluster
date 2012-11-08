package org.feature.multi.perspective.generator.viewmodel;

import java.util.HashSet;
import java.util.Set;

import org.feature.model.csp.analyze.FeatureVariant;
import org.feature.multi.perspective.model.viewmodel.AbstractGroup;
import org.featuremapper.models.feature.Feature;

public class FullVariantClassification {
	
	private Set<Feature> deadFeatures;
	private Set<Feature> aliveFeatures;
	
	private FeatureVariant variant;
	
	
	public FullVariantClassification(FeatureVariant variant){
		this.variant = variant;		
		deadFeatures = new HashSet<Feature>();
		aliveFeatures = new HashSet<Feature>();
	}
	
	public FeatureVariant getVariant() {
		return variant;
	}

	public void setVariant(FeatureVariant variant) {
		this.variant = variant;
	}

	public Set<Feature> getDeadFeatures() {
		return deadFeatures;
	}

	public Set<Feature> getAliveFeatures() {
		return aliveFeatures;
	}

}

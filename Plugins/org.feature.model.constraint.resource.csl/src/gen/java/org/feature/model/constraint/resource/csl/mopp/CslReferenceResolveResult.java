/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.model.constraint.resource.csl.mopp;

/**
 * A basic implementation of the
 * org.feature.model.constraint.resource.csl.ICslReferenceResolveResult interface
 * that collects mappings in a list.
 * 
 * @param <ReferenceType> the type of the references that can be contained in this
 * result
 */
public class CslReferenceResolveResult<ReferenceType> implements org.feature.model.constraint.resource.csl.ICslReferenceResolveResult<ReferenceType> {
	
	private java.util.Collection<org.feature.model.constraint.resource.csl.ICslReferenceMapping<ReferenceType>> mappings;
	private String errorMessage;
	private boolean resolveFuzzy;
	private java.util.Set<org.feature.model.constraint.resource.csl.ICslQuickFix> quickFixes;
	
	public CslReferenceResolveResult(boolean resolveFuzzy) {
		super();
		this.resolveFuzzy = resolveFuzzy;
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}
	
	public java.util.Collection<org.feature.model.constraint.resource.csl.ICslQuickFix> getQuickFixes() {
		if (quickFixes == null) {
			quickFixes = new java.util.LinkedHashSet<org.feature.model.constraint.resource.csl.ICslQuickFix>();
		}
		return java.util.Collections.unmodifiableSet(quickFixes);
	}
	
	public void addQuickFix(org.feature.model.constraint.resource.csl.ICslQuickFix quickFix) {
		if (quickFixes == null) {
			quickFixes = new java.util.LinkedHashSet<org.feature.model.constraint.resource.csl.ICslQuickFix>();
		}
		quickFixes.add(quickFix);
	}
	
	public java.util.Collection<org.feature.model.constraint.resource.csl.ICslReferenceMapping<ReferenceType>> getMappings() {
		return mappings;
	}
	
	public boolean wasResolved() {
		return mappings != null;
	}
	
	public boolean wasResolvedMultiple() {
		return mappings != null && mappings.size() > 1;
	}
	
	public boolean wasResolvedUniquely() {
		return mappings != null && mappings.size() == 1;
	}
	
	public void setErrorMessage(String message) {
		errorMessage = message;
	}
	
	public void addMapping(String identifier, ReferenceType target) {
		if (!resolveFuzzy && target == null) {
			throw new IllegalArgumentException("Mapping references to null is only allowed for fuzzy resolution.");
		}
		addMapping(identifier, target, null);
	}
	
	public void addMapping(String identifier, ReferenceType target, String warning) {
		if (mappings == null) {
			mappings = new java.util.ArrayList<org.feature.model.constraint.resource.csl.ICslReferenceMapping<ReferenceType>>(1);
		}
		mappings.add(new org.feature.model.constraint.resource.csl.mopp.CslElementMapping<ReferenceType>(identifier, target, warning));
		errorMessage = null;
	}
	
	public void addMapping(String identifier, org.eclipse.emf.common.util.URI uri) {
		addMapping(identifier, uri, null);
	}
	
	public void addMapping(String identifier, org.eclipse.emf.common.util.URI uri, String warning) {
		if (mappings == null) {
			mappings = new java.util.ArrayList<org.feature.model.constraint.resource.csl.ICslReferenceMapping<ReferenceType>>(1);
		}
		mappings.add(new org.feature.model.constraint.resource.csl.mopp.CslURIMapping<ReferenceType>(identifier, uri, warning));
	}
}

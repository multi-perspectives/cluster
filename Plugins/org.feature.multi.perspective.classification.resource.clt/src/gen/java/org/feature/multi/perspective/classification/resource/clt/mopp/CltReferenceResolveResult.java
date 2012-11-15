/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.multi.perspective.classification.resource.clt.mopp;

/**
 * A basic implementation of the
 * org.feature.multi.perspective.classification.resource.clt.ICltReferenceResolveRe
 * sult interface that collects mappings in a list.
 * 
 * @param <ReferenceType> the type of the references that can be contained in this
 * result
 */
public class CltReferenceResolveResult<ReferenceType> implements org.feature.multi.perspective.classification.resource.clt.ICltReferenceResolveResult<ReferenceType> {
	
	private java.util.Collection<org.feature.multi.perspective.classification.resource.clt.ICltReferenceMapping<ReferenceType>> mappings;
	private String errorMessage;
	private boolean resolveFuzzy;
	private java.util.Set<org.feature.multi.perspective.classification.resource.clt.ICltQuickFix> quickFixes;
	
	public CltReferenceResolveResult(boolean resolveFuzzy) {
		super();
		this.resolveFuzzy = resolveFuzzy;
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}
	
	public java.util.Collection<org.feature.multi.perspective.classification.resource.clt.ICltQuickFix> getQuickFixes() {
		if (quickFixes == null) {
			quickFixes = new java.util.LinkedHashSet<org.feature.multi.perspective.classification.resource.clt.ICltQuickFix>();
		}
		return java.util.Collections.unmodifiableSet(quickFixes);
	}
	
	public void addQuickFix(org.feature.multi.perspective.classification.resource.clt.ICltQuickFix quickFix) {
		if (quickFixes == null) {
			quickFixes = new java.util.LinkedHashSet<org.feature.multi.perspective.classification.resource.clt.ICltQuickFix>();
		}
		quickFixes.add(quickFix);
	}
	
	public java.util.Collection<org.feature.multi.perspective.classification.resource.clt.ICltReferenceMapping<ReferenceType>> getMappings() {
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
			mappings = new java.util.ArrayList<org.feature.multi.perspective.classification.resource.clt.ICltReferenceMapping<ReferenceType>>(1);
		}
		mappings.add(new org.feature.multi.perspective.classification.resource.clt.mopp.CltElementMapping<ReferenceType>(identifier, target, warning));
		errorMessage = null;
	}
	
	public void addMapping(String identifier, org.eclipse.emf.common.util.URI uri) {
		addMapping(identifier, uri, null);
	}
	
	public void addMapping(String identifier, org.eclipse.emf.common.util.URI uri, String warning) {
		if (mappings == null) {
			mappings = new java.util.ArrayList<org.feature.multi.perspective.classification.resource.clt.ICltReferenceMapping<ReferenceType>>(1);
		}
		mappings.add(new org.feature.multi.perspective.classification.resource.clt.mopp.CltURIMapping<ReferenceType>(identifier, uri, warning));
	}
}

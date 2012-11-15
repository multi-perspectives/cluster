/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.model.constraint.resource.csl.mopp;

/**
 * A basic implementation of the
 * org.feature.model.constraint.resource.csl.ICslElementMapping interface.
 * 
 * @param <ReferenceType> the type of the reference that can be mapped to
 */
public class CslElementMapping<ReferenceType> implements org.feature.model.constraint.resource.csl.ICslElementMapping<ReferenceType> {
	
	private final ReferenceType target;
	private String identifier;
	private String warning;
	
	public CslElementMapping(String identifier, ReferenceType target, String warning) {
		super();
		this.target = target;
		this.identifier = identifier;
		this.warning = warning;
	}
	
	public ReferenceType getTargetElement() {
		return target;
	}
	
	public String getIdentifier() {
		return identifier;
	}
	
	public String getWarning() {
		return warning;
	}
	
}

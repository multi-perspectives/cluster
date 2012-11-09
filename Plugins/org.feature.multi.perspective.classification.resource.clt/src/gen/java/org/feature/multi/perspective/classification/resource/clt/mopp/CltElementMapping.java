/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.multi.perspective.classification.resource.clt.mopp;

/**
 * A basic implementation of the
 * org.feature.multi.perspective.classification.resource.clt.ICltElementMapping
 * interface.
 * 
 * @param <ReferenceType> the type of the reference that can be mapped to
 */
public class CltElementMapping<ReferenceType> implements org.feature.multi.perspective.classification.resource.clt.ICltElementMapping<ReferenceType> {
	
	private final ReferenceType target;
	private String identifier;
	private String warning;
	
	public CltElementMapping(String identifier, ReferenceType target, String warning) {
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

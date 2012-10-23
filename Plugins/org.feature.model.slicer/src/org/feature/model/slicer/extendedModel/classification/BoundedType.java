package org.feature.model.slicer.extendedModel.classification;

/**
 * A feature may have four states
 * 
 * (initial) not classified
 * ->
 * unbound
 * -> 
 * alive or dead (contradict each other)
 * (final state)
 * 
 * @author Ingo Reimund
 * @create 15.03.2012
 */
public enum BoundedType {
	ALIVE, UNBOUND, DEAD, ROOT, NOTCLASSIFIED;
	
	/**
	 * convert an given String to upper case and search for equivalent value
	 * 
	 * @param value
	 *            as String in upper or lower case
	 * @return VariabilityType or IllegalArgumentException if the value is not a
	 *         variabilityType
	 */
	public static BoundedType value(String value) {
		return valueOf(value.toUpperCase());
	}
}
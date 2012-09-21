package org.feature.model.sat;


public enum GroupType {
	OR, ALTERNATIVE, MANDATORY, OPTIONAL;
	
	
	/**
	 * convert an given String to upper case and search for equivalent value
	 * 
	 * @param value
	 *            as String in upper or lower case
	 * @return VariabilityType or IllegalArgumentException if the value is not a
	 *         variabilityType
	 */
	public static GroupType value(String value) {
		return valueOf(value.toUpperCase());
	}
}

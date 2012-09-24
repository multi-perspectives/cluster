package org.feature.model.slicer.extendedModel.classification;

/**
 * Additional type of features
 * 
 * @author Ingo Reimund
 * @create 15.03.2012
 */
public enum BoundedType {
	ALIVE, UNBOUND, DEAD, ROOT;
	
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
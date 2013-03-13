/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.model.constraint.resource.csl.mopp;

public class CslTokenStyleInformationProvider {
	
	public static String TASK_ITEM_TOKEN_NAME = "TASK_ITEM";
	
	public org.feature.model.constraint.resource.csl.ICslTokenStyle getDefaultTokenStyle(String tokenName) {
		if ("requires".equals(tokenName)) {
			return new org.feature.model.constraint.resource.csl.mopp.CslTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("excludes".equals(tokenName)) {
			return new org.feature.model.constraint.resource.csl.mopp.CslTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("QUOTED_39_39".equals(tokenName)) {
			return new org.feature.model.constraint.resource.csl.mopp.CslTokenStyle(new int[] {0x2A, 0x00, 0xFF}, null, false, false, false, false);
		}
		if ("QUOTED_34_34".equals(tokenName)) {
			return new org.feature.model.constraint.resource.csl.mopp.CslTokenStyle(new int[] {0x2A, 0x00, 0xFF}, null, false, false, false, false);
		}
		if ("TASK_ITEM".equals(tokenName)) {
			return new org.feature.model.constraint.resource.csl.mopp.CslTokenStyle(new int[] {0x7F, 0x9F, 0xBF}, null, true, false, false, false);
		}
		return null;
	}
	
}

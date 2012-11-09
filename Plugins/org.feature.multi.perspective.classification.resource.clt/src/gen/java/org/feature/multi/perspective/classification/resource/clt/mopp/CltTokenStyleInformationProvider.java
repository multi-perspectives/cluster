/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.multi.perspective.classification.resource.clt.mopp;

public class CltTokenStyleInformationProvider {
	
	public static String TASK_ITEM_TOKEN_NAME = "TASK_ITEM";
	
	public org.feature.multi.perspective.classification.resource.clt.ICltTokenStyle getDefaultTokenStyle(String tokenName) {
		if ("COMMENT".equals(tokenName)) {
			return new org.feature.multi.perspective.classification.resource.clt.mopp.CltTokenStyle(new int[] {0xAA, 0xAA, 0xAA}, null, false, false, false, false);
		}
		if ("classification".equals(tokenName)) {
			return new org.feature.multi.perspective.classification.resource.clt.mopp.CltTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("references".equals(tokenName)) {
			return new org.feature.multi.perspective.classification.resource.clt.mopp.CltTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("mapping".equals(tokenName)) {
			return new org.feature.multi.perspective.classification.resource.clt.mopp.CltTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("featuremodel".equals(tokenName)) {
			return new org.feature.multi.perspective.classification.resource.clt.mopp.CltTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("stage".equals(tokenName)) {
			return new org.feature.multi.perspective.classification.resource.clt.mopp.CltTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("on".equals(tokenName)) {
			return new org.feature.multi.perspective.classification.resource.clt.mopp.CltTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("views".equals(tokenName)) {
			return new org.feature.multi.perspective.classification.resource.clt.mopp.CltTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("autocomplete".equals(tokenName)) {
			return new org.feature.multi.perspective.classification.resource.clt.mopp.CltTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("feature".equals(tokenName)) {
			return new org.feature.multi.perspective.classification.resource.clt.mopp.CltTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("unbound".equals(tokenName)) {
			return new org.feature.multi.perspective.classification.resource.clt.mopp.CltTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("dead".equals(tokenName)) {
			return new org.feature.multi.perspective.classification.resource.clt.mopp.CltTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("alive".equals(tokenName)) {
			return new org.feature.multi.perspective.classification.resource.clt.mopp.CltTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("QUOTED_60_62".equals(tokenName)) {
			return new org.feature.multi.perspective.classification.resource.clt.mopp.CltTokenStyle(new int[] {0x2A, 0x00, 0xFF}, null, false, false, false, false);
		}
		if ("QUOTED_34_34".equals(tokenName)) {
			return new org.feature.multi.perspective.classification.resource.clt.mopp.CltTokenStyle(new int[] {0x2A, 0x00, 0xFF}, null, false, false, false, false);
		}
		if ("TASK_ITEM".equals(tokenName)) {
			return new org.feature.multi.perspective.classification.resource.clt.mopp.CltTokenStyle(new int[] {0x7F, 0x9F, 0xBF}, null, true, false, false, false);
		}
		return null;
	}
	
}

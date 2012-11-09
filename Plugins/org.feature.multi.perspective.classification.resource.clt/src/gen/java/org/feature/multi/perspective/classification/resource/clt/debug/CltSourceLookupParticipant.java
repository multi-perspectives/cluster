/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.multi.perspective.classification.resource.clt.debug;

public class CltSourceLookupParticipant extends org.eclipse.debug.core.sourcelookup.AbstractSourceLookupParticipant {
	
	public String getSourceName(Object object) throws org.eclipse.core.runtime.CoreException {
		if (object instanceof org.feature.multi.perspective.classification.resource.clt.debug.CltStackFrame) {
			org.feature.multi.perspective.classification.resource.clt.debug.CltStackFrame frame = (org.feature.multi.perspective.classification.resource.clt.debug.CltStackFrame) object;
			return frame.getResourceURI();
		}
		return null;
	}
	
}

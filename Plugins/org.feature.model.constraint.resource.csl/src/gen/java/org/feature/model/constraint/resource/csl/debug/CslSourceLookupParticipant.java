/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.model.constraint.resource.csl.debug;

public class CslSourceLookupParticipant extends org.eclipse.debug.core.sourcelookup.AbstractSourceLookupParticipant {
	
	public String getSourceName(Object object) throws org.eclipse.core.runtime.CoreException {
		if (object instanceof org.feature.model.constraint.resource.csl.debug.CslStackFrame) {
			org.feature.model.constraint.resource.csl.debug.CslStackFrame frame = (org.feature.model.constraint.resource.csl.debug.CslStackFrame) object;
			return frame.getResourceURI();
		}
		return null;
	}
	
}

/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.multi.perspective.classification.resource.clt;

public interface ICltProblem {
	public String getMessage();
	public org.feature.multi.perspective.classification.resource.clt.CltEProblemSeverity getSeverity();
	public org.feature.multi.perspective.classification.resource.clt.CltEProblemType getType();
	public java.util.Collection<org.feature.multi.perspective.classification.resource.clt.ICltQuickFix> getQuickFixes();
}

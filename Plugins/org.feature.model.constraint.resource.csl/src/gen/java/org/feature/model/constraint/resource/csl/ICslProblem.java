/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.model.constraint.resource.csl;

public interface ICslProblem {
	public String getMessage();
	public org.feature.model.constraint.resource.csl.CslEProblemSeverity getSeverity();
	public org.feature.model.constraint.resource.csl.CslEProblemType getType();
	public java.util.Collection<org.feature.model.constraint.resource.csl.ICslQuickFix> getQuickFixes();
}

/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.model.constraint.resource.csl.mopp;

public class CslProblem implements org.feature.model.constraint.resource.csl.ICslProblem {
	
	private String message;
	private org.feature.model.constraint.resource.csl.CslEProblemType type;
	private org.feature.model.constraint.resource.csl.CslEProblemSeverity severity;
	private java.util.Collection<org.feature.model.constraint.resource.csl.ICslQuickFix> quickFixes;
	
	public CslProblem(String message, org.feature.model.constraint.resource.csl.CslEProblemType type, org.feature.model.constraint.resource.csl.CslEProblemSeverity severity) {
		this(message, type, severity, java.util.Collections.<org.feature.model.constraint.resource.csl.ICslQuickFix>emptySet());
	}
	
	public CslProblem(String message, org.feature.model.constraint.resource.csl.CslEProblemType type, org.feature.model.constraint.resource.csl.CslEProblemSeverity severity, org.feature.model.constraint.resource.csl.ICslQuickFix quickFix) {
		this(message, type, severity, java.util.Collections.singleton(quickFix));
	}
	
	public CslProblem(String message, org.feature.model.constraint.resource.csl.CslEProblemType type, org.feature.model.constraint.resource.csl.CslEProblemSeverity severity, java.util.Collection<org.feature.model.constraint.resource.csl.ICslQuickFix> quickFixes) {
		super();
		this.message = message;
		this.type = type;
		this.severity = severity;
		this.quickFixes = new java.util.LinkedHashSet<org.feature.model.constraint.resource.csl.ICslQuickFix>();
		this.quickFixes.addAll(quickFixes);
	}
	
	public org.feature.model.constraint.resource.csl.CslEProblemType getType() {
		return type;
	}
	
	public org.feature.model.constraint.resource.csl.CslEProblemSeverity getSeverity() {
		return severity;
	}
	
	public String getMessage() {
		return message;
	}
	
	public java.util.Collection<org.feature.model.constraint.resource.csl.ICslQuickFix> getQuickFixes() {
		return quickFixes;
	}
	
}

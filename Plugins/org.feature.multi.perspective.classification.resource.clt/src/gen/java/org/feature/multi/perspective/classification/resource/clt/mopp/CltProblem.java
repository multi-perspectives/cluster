/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.multi.perspective.classification.resource.clt.mopp;

public class CltProblem implements org.feature.multi.perspective.classification.resource.clt.ICltProblem {
	
	private String message;
	private org.feature.multi.perspective.classification.resource.clt.CltEProblemType type;
	private org.feature.multi.perspective.classification.resource.clt.CltEProblemSeverity severity;
	private java.util.Collection<org.feature.multi.perspective.classification.resource.clt.ICltQuickFix> quickFixes;
	
	public CltProblem(String message, org.feature.multi.perspective.classification.resource.clt.CltEProblemType type, org.feature.multi.perspective.classification.resource.clt.CltEProblemSeverity severity) {
		this(message, type, severity, java.util.Collections.<org.feature.multi.perspective.classification.resource.clt.ICltQuickFix>emptySet());
	}
	
	public CltProblem(String message, org.feature.multi.perspective.classification.resource.clt.CltEProblemType type, org.feature.multi.perspective.classification.resource.clt.CltEProblemSeverity severity, org.feature.multi.perspective.classification.resource.clt.ICltQuickFix quickFix) {
		this(message, type, severity, java.util.Collections.singleton(quickFix));
	}
	
	public CltProblem(String message, org.feature.multi.perspective.classification.resource.clt.CltEProblemType type, org.feature.multi.perspective.classification.resource.clt.CltEProblemSeverity severity, java.util.Collection<org.feature.multi.perspective.classification.resource.clt.ICltQuickFix> quickFixes) {
		super();
		this.message = message;
		this.type = type;
		this.severity = severity;
		this.quickFixes = new java.util.LinkedHashSet<org.feature.multi.perspective.classification.resource.clt.ICltQuickFix>();
		this.quickFixes.addAll(quickFixes);
	}
	
	public org.feature.multi.perspective.classification.resource.clt.CltEProblemType getType() {
		return type;
	}
	
	public org.feature.multi.perspective.classification.resource.clt.CltEProblemSeverity getSeverity() {
		return severity;
	}
	
	public String getMessage() {
		return message;
	}
	
	public java.util.Collection<org.feature.multi.perspective.classification.resource.clt.ICltQuickFix> getQuickFixes() {
		return quickFixes;
	}
	
}

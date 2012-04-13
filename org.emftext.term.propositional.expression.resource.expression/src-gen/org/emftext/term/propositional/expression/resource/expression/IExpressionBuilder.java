/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.term.propositional.expression.resource.expression;

public interface IExpressionBuilder {
	
	public boolean isBuildingNeeded(org.eclipse.emf.common.util.URI uri);
	
	public org.eclipse.core.runtime.IStatus build(org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionResource resource, org.eclipse.core.runtime.IProgressMonitor monitor);
}

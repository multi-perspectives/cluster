/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.term.propositional.expression.resource.expression.util;

/**
 * Class ExpressionTextResourceUtil can be used to perform common tasks on text
 * resources, such as loading and saving resources, as well as, checking them for
 * errors. This class is deprecated and has been replaced by
 * org.emftext.term.propositional.expression.resource.expression.util.ExpressionRes
 * ourceUtil.
 */
public class ExpressionTextResourceUtil {
	
	@Deprecated	
	public static org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionResource getResource(org.eclipse.core.resources.IFile file) {
		return org.emftext.term.propositional.expression.resource.expression.util.ExpressionResourceUtil.getResource(file);
	}
	
	@Deprecated	
	public static org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionResource getResource(java.io.File file, java.util.Map<?,?> options) {
		return org.emftext.term.propositional.expression.resource.expression.util.ExpressionResourceUtil.getResource(file, options);
	}
	
	@Deprecated	
	public static org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionResource getResource(org.eclipse.emf.common.util.URI uri) {
		return org.emftext.term.propositional.expression.resource.expression.util.ExpressionResourceUtil.getResource(uri);
	}
	
	@Deprecated	
	public static org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionResource getResource(org.eclipse.emf.common.util.URI uri, java.util.Map<?,?> options) {
		return org.emftext.term.propositional.expression.resource.expression.util.ExpressionResourceUtil.getResource(uri, options);
	}
	
}

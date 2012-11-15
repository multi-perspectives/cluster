/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.model.constraint.resource.csl.util;

/**
 * Class CslTextResourceUtil can be used to perform common tasks on text
 * resources, such as loading and saving resources, as well as, checking them for
 * errors. This class is deprecated and has been replaced by
 * org.feature.model.constraint.resource.csl.util.CslResourceUtil.
 */
public class CslTextResourceUtil {
	
	/**
	 * Use
	 * org.feature.model.constraint.resource.csl.util.CslResourceUtil.getResource()
	 * instead.
	 */
	@Deprecated	
	public static org.feature.model.constraint.resource.csl.mopp.CslResource getResource(org.eclipse.core.resources.IFile file) {
		return new org.feature.model.constraint.resource.csl.util.CslEclipseProxy().getResource(file);
	}
	
	/**
	 * Use
	 * org.feature.model.constraint.resource.csl.util.CslResourceUtil.getResource()
	 * instead.
	 */
	@Deprecated	
	public static org.feature.model.constraint.resource.csl.mopp.CslResource getResource(java.io.File file, java.util.Map<?,?> options) {
		return org.feature.model.constraint.resource.csl.util.CslResourceUtil.getResource(file, options);
	}
	
	/**
	 * Use
	 * org.feature.model.constraint.resource.csl.util.CslResourceUtil.getResource()
	 * instead.
	 */
	@Deprecated	
	public static org.feature.model.constraint.resource.csl.mopp.CslResource getResource(org.eclipse.emf.common.util.URI uri) {
		return org.feature.model.constraint.resource.csl.util.CslResourceUtil.getResource(uri);
	}
	
	/**
	 * Use
	 * org.feature.model.constraint.resource.csl.util.CslResourceUtil.getResource()
	 * instead.
	 */
	@Deprecated	
	public static org.feature.model.constraint.resource.csl.mopp.CslResource getResource(org.eclipse.emf.common.util.URI uri, java.util.Map<?,?> options) {
		return org.feature.model.constraint.resource.csl.util.CslResourceUtil.getResource(uri, options);
	}
	
}

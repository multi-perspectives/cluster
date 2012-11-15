/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.multi.perspective.classification.resource.clt.util;

/**
 * Class CltTextResourceUtil can be used to perform common tasks on text
 * resources, such as loading and saving resources, as well as, checking them for
 * errors. This class is deprecated and has been replaced by
 * org.feature.multi.perspective.classification.resource.clt.util.CltResourceUtil.
 */
public class CltTextResourceUtil {
	
	/**
	 * Use
	 * org.feature.multi.perspective.classification.resource.clt.util.CltResourceUtil.g
	 * etResource() instead.
	 */
	@Deprecated	
	public static org.feature.multi.perspective.classification.resource.clt.mopp.CltResource getResource(org.eclipse.core.resources.IFile file) {
		return new org.feature.multi.perspective.classification.resource.clt.util.CltEclipseProxy().getResource(file);
	}
	
	/**
	 * Use
	 * org.feature.multi.perspective.classification.resource.clt.util.CltResourceUtil.g
	 * etResource() instead.
	 */
	@Deprecated	
	public static org.feature.multi.perspective.classification.resource.clt.mopp.CltResource getResource(java.io.File file, java.util.Map<?,?> options) {
		return org.feature.multi.perspective.classification.resource.clt.util.CltResourceUtil.getResource(file, options);
	}
	
	/**
	 * Use
	 * org.feature.multi.perspective.classification.resource.clt.util.CltResourceUtil.g
	 * etResource() instead.
	 */
	@Deprecated	
	public static org.feature.multi.perspective.classification.resource.clt.mopp.CltResource getResource(org.eclipse.emf.common.util.URI uri) {
		return org.feature.multi.perspective.classification.resource.clt.util.CltResourceUtil.getResource(uri);
	}
	
	/**
	 * Use
	 * org.feature.multi.perspective.classification.resource.clt.util.CltResourceUtil.g
	 * etResource() instead.
	 */
	@Deprecated	
	public static org.feature.multi.perspective.classification.resource.clt.mopp.CltResource getResource(org.eclipse.emf.common.util.URI uri, java.util.Map<?,?> options) {
		return org.feature.multi.perspective.classification.resource.clt.util.CltResourceUtil.getResource(uri, options);
	}
	
}

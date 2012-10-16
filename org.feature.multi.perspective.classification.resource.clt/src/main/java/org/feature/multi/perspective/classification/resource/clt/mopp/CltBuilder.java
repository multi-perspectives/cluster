/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.multi.perspective.classification.resource.clt.mopp;

import java.io.IOException;

public class CltBuilder implements org.feature.multi.perspective.classification.resource.clt.ICltBuilder {

   public boolean isBuildingNeeded(org.eclipse.emf.common.util.URI uri) {
      // change this to return true to enable building of all resources
      return true;
   }

   public org.eclipse.core.runtime.IStatus build(org.feature.multi.perspective.classification.resource.clt.mopp.CltResource resource,
                                                 org.eclipse.core.runtime.IProgressMonitor monitor) {
      try {
         resource.save(null);
      } catch (IOException e) {
         // handle exception
      }
      return org.eclipse.core.runtime.Status.OK_STATUS;
   }

   /**
    * Handles the deletion of the given resource.
    */
   public org.eclipse.core.runtime.IStatus handleDeletion(org.eclipse.emf.common.util.URI uri,
                                                          org.eclipse.core.runtime.IProgressMonitor monitor) {
      // by default nothing is done when a resource is deleted
      return org.eclipse.core.runtime.Status.OK_STATUS;
   }

}

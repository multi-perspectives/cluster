/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.multi.perspective.classification.resource.clt.mopp;

public class CltResourcePostProcessor implements org.feature.multi.perspective.classification.resource.clt.ICltResourcePostProcessor {
	
	public void process(org.feature.multi.perspective.classification.resource.clt.mopp.CltResource resource) {
		// Set the overrideResourcePostProcessor option to false to customize resource
		// post processing.
	}
	
	public void terminate() {
		// To signal termination to the process() method, setting a boolean field is
		// recommended. Depending on the value of this field process() can stop its
		// computation. However, this is only required for computation intensive
		// post-processors.
	}
	
}

/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.multi.perspective.classification.resource.clt.mopp;

/**
 * A factory for ContextDependentURIFragments. Given a feasible reference
 * resolver, this factory returns a matching fragment that used the resolver to
 * resolver proxy objects.
 * 
 * @param <ContainerType> the type of the class containing the reference to be
 * resolved
 * @param <ReferenceType> the type of the reference to be resolved
 */
public class CltContextDependentURIFragmentFactory<ContainerType extends org.eclipse.emf.ecore.EObject, ReferenceType extends org.eclipse.emf.ecore.EObject>  implements org.feature.multi.perspective.classification.resource.clt.ICltContextDependentURIFragmentFactory<ContainerType, ReferenceType> {
	
	private final org.feature.multi.perspective.classification.resource.clt.ICltReferenceResolver<ContainerType, ReferenceType> resolver;
	
	public CltContextDependentURIFragmentFactory(org.feature.multi.perspective.classification.resource.clt.ICltReferenceResolver<ContainerType, ReferenceType> resolver) {
		this.resolver = resolver;
	}
	
	public org.feature.multi.perspective.classification.resource.clt.ICltContextDependentURIFragment<?> create(String identifier, ContainerType container, org.eclipse.emf.ecore.EReference reference, int positionInReference, org.eclipse.emf.ecore.EObject proxy) {
		
		return new org.feature.multi.perspective.classification.resource.clt.mopp.CltContextDependentURIFragment<ContainerType, ReferenceType>(identifier, container, reference, positionInReference, proxy) {
			public org.feature.multi.perspective.classification.resource.clt.ICltReferenceResolver<ContainerType, ReferenceType> getResolver() {
				return resolver;
			}
		};
	}
}

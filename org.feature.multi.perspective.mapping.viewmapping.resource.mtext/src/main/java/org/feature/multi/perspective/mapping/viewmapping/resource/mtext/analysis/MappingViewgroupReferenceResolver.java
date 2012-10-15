/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.multi.perspective.mapping.viewmapping.resource.mtext.analysis;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.feature.multi.perspective.mapping.viewmapping.MappingModel;
import org.feature.multi.perspective.model.viewmodel.CoreGroup;
import org.feature.multi.perspective.model.viewmodel.Group;
import org.feature.multi.perspective.model.viewmodel.GroupModel;

public class MappingViewgroupReferenceResolver
      implements
      org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextReferenceResolver<org.feature.multi.perspective.mapping.viewmapping.Mapping, org.feature.multi.perspective.model.viewmodel.Group> {

   private org.feature.multi.perspective.mapping.viewmapping.resource.mtext.analysis.MtextDefaultResolverDelegate<org.feature.multi.perspective.mapping.viewmapping.Mapping, org.feature.multi.perspective.model.viewmodel.Group> delegate =
      new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.analysis.MtextDefaultResolverDelegate<org.feature.multi.perspective.mapping.viewmapping.Mapping, org.feature.multi.perspective.model.viewmodel.Group>();

   public void resolve(String identifier,
                       org.feature.multi.perspective.mapping.viewmapping.Mapping container,
                       org.eclipse.emf.ecore.EReference reference,
                       int position,
                       boolean resolveFuzzy,
                       final org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextReferenceResolveResult<org.feature.multi.perspective.model.viewmodel.Group> result) {
      EObject model = container.eContainer();
      if (model instanceof MappingModel) {
         MappingModel mappingModel = (MappingModel) model;
         GroupModel viewModel = mappingModel.getViewModel();
         CoreGroup coreGroup = viewModel.getCoreGroup();
         TreeIterator<EObject> eAllContents = coreGroup.eAllContents();
         while (eAllContents.hasNext()) {
            EObject next = eAllContents.next();
            if (next instanceof Group) {
               Group group = (Group) next;
               String id = EcoreUtil.getID(group);
               if (identifier.equals(id)) {
                  result.addMapping(identifier, group);
                  return;
               }
            }
         }
      }
      delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
   }

   public String deResolve(org.feature.multi.perspective.model.viewmodel.Group element,
                           org.feature.multi.perspective.mapping.viewmapping.Mapping container, org.eclipse.emf.ecore.EReference reference) {
      return delegate.deResolve(element, container, reference);
   }

   public void setOptions(java.util.Map< ? , ? > options) {
      // save options in a field or leave method empty if this resolver does not depend
      // on any option
   }

}

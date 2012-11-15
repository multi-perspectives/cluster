/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.multi.perspective.classification.resource.clt.analysis;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.feature.multi.perspective.classification.ClassificationModel;
import org.feature.multi.perspective.mapping.viewmapping.MappingModel;
import org.feature.multi.perspective.model.viewmodel.CoreGroup;
import org.feature.multi.perspective.model.viewmodel.Group;
import org.feature.multi.perspective.model.viewmodel.GroupModel;

public class ClassificationViewgroupsReferenceResolver implements org.feature.multi.perspective.classification.resource.clt.ICltReferenceResolver<org.feature.multi.perspective.classification.Classification, org.feature.multi.perspective.model.viewmodel.AbstractGroup> {
	
	private org.feature.multi.perspective.classification.resource.clt.analysis.CltDefaultResolverDelegate<org.feature.multi.perspective.classification.Classification, org.feature.multi.perspective.model.viewmodel.AbstractGroup> delegate = new org.feature.multi.perspective.classification.resource.clt.analysis.CltDefaultResolverDelegate<org.feature.multi.perspective.classification.Classification, org.feature.multi.perspective.model.viewmodel.AbstractGroup>();
	
	public void resolve(String identifier, org.feature.multi.perspective.classification.Classification container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.feature.multi.perspective.classification.resource.clt.ICltReferenceResolveResult<org.feature.multi.perspective.model.viewmodel.AbstractGroup> result) {
	   EObject model = container.eContainer();
       if (model instanceof ClassificationModel) {
          ClassificationModel classificationModel = (ClassificationModel) model;

          MappingModel mappingModel = classificationModel.getViewMapping();
          if (mappingModel != null) {
             GroupModel viewModel = mappingModel.getViewModel();
             if (viewModel != null) {
                CoreGroup coreGroup = viewModel.getCoreGroup();
                String coreGroupId = EcoreUtil.getID(coreGroup);
                if (identifier.equals(coreGroupId)) {
                   result.addMapping(identifier, coreGroup);
                   return;
                }
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
          }
       }
	   delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public String deResolve(org.feature.multi.perspective.model.viewmodel.AbstractGroup element, org.feature.multi.perspective.classification.Classification container, org.eclipse.emf.ecore.EReference reference) {
		return element.getName();
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}

/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.term.propositional.expression.resource.expression.analysis;

import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.feature.model.utilities.FeatureModelUtil;
import org.featuremapper.models.feature.Feature;
import org.featuremapper.models.feature.FeatureModel;

public class FeatureRefFeatureReferenceResolver
      implements
      org.emftext.term.propositional.expression.resource.expression.IExpressionReferenceResolver<org.emftext.term.propositional.expression.FeatureRef, org.featuremapper.models.feature.Feature> {

   private org.emftext.term.propositional.expression.resource.expression.analysis.ExpressionDefaultResolverDelegate<org.emftext.term.propositional.expression.FeatureRef, org.featuremapper.models.feature.Feature> delegate =
      new org.emftext.term.propositional.expression.resource.expression.analysis.ExpressionDefaultResolverDelegate<org.emftext.term.propositional.expression.FeatureRef, org.featuremapper.models.feature.Feature>();

   public void resolve(String identifier,
                       org.emftext.term.propositional.expression.FeatureRef container,
                       org.eclipse.emf.ecore.EReference reference,
                       int position,
                       boolean resolveFuzzy,
                       final org.emftext.term.propositional.expression.resource.expression.IExpressionReferenceResolveResult<org.featuremapper.models.feature.Feature> result) {
      URI featureModelResource = container.eResource().getURI().trimFileExtension().trimFileExtension();
      featureModelResource = featureModelResource.appendFileExtension("feature");
      Resource resource = container.eResource().getResourceSet().getResource(featureModelResource, true);
      if (resource != null && resource.getContents().size() == 1 && resource.getContents().get(0) instanceof FeatureModel) {
         FeatureModel fm = (FeatureModel) resource.getContents().get(0);
         List<Feature> allFeatures = FeatureModelUtil.getAllFeatures(fm);
         for (Feature feature : allFeatures) {
            String id = EcoreUtil.getID(feature);
            if (id.equals(identifier)) {
               result.addMapping(identifier, feature);
               return;
            }
         }
      }
      delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
   }

   public String deResolve(org.featuremapper.models.feature.Feature element,
                           org.emftext.term.propositional.expression.FeatureRef container, org.eclipse.emf.ecore.EReference reference) {
      return element.getName();
   }

   public void setOptions(java.util.Map< ? , ? > options) {
      // save options in a field or leave method empty if this resolver does not depend
      // on any option
   }

}

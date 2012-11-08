/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.model.constraint.resource.csl.analysis;

import org.featuremapper.models.feature.Feature;

public class FeatureExpressionRightFeatureReferenceResolver
      implements
      org.feature.model.constraint.resource.csl.ICslReferenceResolver<org.feature.model.constraint.FeatureExpression, org.featuremapper.models.feature.Feature> {

   private org.feature.model.constraint.resource.csl.analysis.CslDefaultResolverDelegate<org.feature.model.constraint.FeatureExpression, org.featuremapper.models.feature.Feature> delegate =
      new org.feature.model.constraint.resource.csl.analysis.CslDefaultResolverDelegate<org.feature.model.constraint.FeatureExpression, org.featuremapper.models.feature.Feature>();

   public void resolve(String identifier,
                       org.feature.model.constraint.FeatureExpression container,
                       org.eclipse.emf.ecore.EReference reference,
                       int position,
                       boolean resolveFuzzy,
                       final org.feature.model.constraint.resource.csl.ICslReferenceResolveResult<org.featuremapper.models.feature.Feature> result) {
      Feature feature = FeatureReferenceHelper.getFeature(identifier, container);
      if (feature != null) {
         result.addMapping(identifier, feature);
      } else {
         delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
      }
   }

   public String deResolve(org.featuremapper.models.feature.Feature element, org.feature.model.constraint.FeatureExpression container,
                           org.eclipse.emf.ecore.EReference reference) {
      return delegate.deResolve(element, container, reference);
   }

   public void setOptions(java.util.Map< ? , ? > options) {
      // save options in a field or leave method empty if this resolver does not depend
      // on any option
   }

}

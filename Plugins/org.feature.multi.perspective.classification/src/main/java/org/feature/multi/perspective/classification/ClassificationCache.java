package org.feature.multi.perspective.classification;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.feature.model.constraint.FeatureExpression;
import org.feature.multi.perspective.mapping.viewmapping.MappingModel;
import org.feature.multi.perspective.model.viewmodel.AbstractGroup;
import org.feature.multi.perspective.view.View;
import org.feature.multi.perspective.view.provider.ViewBuilder;
import org.featuremapper.models.feature.Feature;

public class ClassificationCache {

   private static ClassificationCache cache;

   private Map<String, ViewBuilder> viewBuilders = new HashMap<String, ViewBuilder>();

   public static ClassificationCache getInstance() {
      if (cache == null) {
         cache = new ClassificationCache();
      }
      return cache;
   }

   public Set<FeatureExpression> getConstraints(EObject classificationObject) {
      ViewBuilder viewBuilder = getViewBuilder(classificationObject);
      return viewBuilder.getConstraints();
   }

   private ViewBuilder getViewBuilder(EObject classificationObject) {
      ViewBuilder result = null;
      EObject rootContainer = EcoreUtil.getRootContainer(classificationObject);
      if (rootContainer instanceof ClassificationModel) {
         ClassificationModel model = (ClassificationModel) rootContainer;
         MappingModel viewMapping = model.getViewMapping();
         Resource eResource = viewMapping.eResource();
         if (eResource != null) {
            String resourceUri = eResource.getURI().toString();
            if (viewBuilders.containsKey(resourceUri)) {
               result = viewBuilders.get(resourceUri);
            } else {
               result = initViewBuilder(model, resourceUri);
            }
         }
      }
      return result;
   }

   private ViewBuilder initViewBuilder(ClassificationModel model, String key) {
      MappingModel viewMapping = model.getViewMapping();
      ViewBuilder viewBuilder = new ViewBuilder(viewMapping, false, false);
      this.viewBuilders.put(key, viewBuilder);
      return viewBuilder;
   }

   /**
    * get the first corresponding view for a classification.
    * 
    * @param classification
    * @return
    */
   public View getView(Classification classification, ClassificationModel model) {
      View view = null;
      ViewBuilder viewBuilder = getViewBuilder(model);
      EList<AbstractGroup> viewgroups = classification.getViewgroups();

      if (viewBuilder != null) {
         view = viewBuilder.getView(viewgroups);
      }
      return view;
   }

   /**
    * get the all corresponding views for a (composed) classification.
    * 
    * @param classification
    * @return
    */
   public Set<View> getViewsComplete(Classification classification) {
      ViewBuilder viewBuilder = getViewBuilder(classification);
      List<AbstractGroup> viewgroups = classification.getViewgroups();
      HashSet<View> allViews = new HashSet<View>();
      for (AbstractGroup group : viewgroups) {
         View v = viewBuilder.getView(group);
         allViews.add(v);
      }
      return allViews;
   }

   /**
    * determine if a feature is contained in a view.
    * 
    * @param classification
    * @param feature
    * @return
    */
   public boolean isFeatureContainedInFirstView(Classification classification, Feature feature) {
      AbstractGroup viewgroup = classification.getViewgroups().get(0);
      ViewBuilder viewBuilder = getViewBuilder(classification);
      return viewBuilder.isFeatureContained(feature, viewgroup);
   }

   /**
    * determine if a feature is contained in the view of the given classification.
    * 
    * @param classification
    * @param feature
    * @return
    */
   public boolean isFeatureContainedInView(Classification classification, Feature feature, ClassificationModel model) {
      ViewBuilder viewBuilder = getViewBuilder(model);
      for (AbstractGroup viewgroup : classification.getViewgroups()) {
         if (viewBuilder.isFeatureContained(feature, viewgroup)) {
            return true;
         }
      }
      return false;
   }

   /**
    * determine if a feature is contained in the view of the given classification. May return false if the view could
    * not be determined.
    * 
    * @param classification
    * @param feature
    * @return
    */
   public boolean isFeatureContainedInView(Classification classification, Feature feature) {
      ViewBuilder viewBuilder = getViewBuilder(classification);
      if (viewBuilder != null) {
         for (AbstractGroup viewgroup : classification.getViewgroups()) {
            if (viewBuilder.isFeatureContained(feature, viewgroup)) {
               return true;
            }
         }
      }
      return false;
   }

}

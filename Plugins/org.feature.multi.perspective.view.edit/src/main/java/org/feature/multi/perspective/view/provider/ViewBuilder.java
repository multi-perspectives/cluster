package org.feature.multi.perspective.view.provider;

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.feature.model.constraint.FeatureExpression;
import org.feature.model.csp.TextExpressionParser;
import org.feature.model.utilities.FeatureMappingUtil;
import org.feature.model.utilities.GroupModelUtil;
import org.feature.multi.perspective.mapping.viewmapping.MappingModel;
import org.feature.multi.perspective.model.viewmodel.AbstractGroup;
import org.feature.multi.perspective.model.viewmodel.GroupModel;
import org.feature.multi.perspective.view.View;
import org.feature.multi.perspective.view.ViewContainer;
import org.feature.multi.perspective.view.ViewFactory;
import org.featuremapper.models.feature.Feature;
import org.featuremapper.models.feature.FeatureModel;

/**
 * create all views specified by the given viewmapping.
 * 
 * @author <a href=mailto:julia.schroeter@tu-dresden.de>Julia Schroeter</a>
 * 
 */
public class ViewBuilder {

   private ViewContainer viewContainer;

   private List<FeatureExpression> featureModelConstraints;

   public ViewBuilder(MappingModel viewMapping, boolean initViews) {
      init(initViews, viewMapping);
   }

   private void init(boolean initViews, MappingModel viewMapping) {
      viewContainer = ViewFactory.eINSTANCE.createViewContainer();
      viewContainer.setFeatureMapping(viewMapping);
      initConstraints(viewMapping.getFeatureModel());
      if (initViews) {
         createAllViews();
      }
   }

   private void initConstraints(FeatureModel featuremodel) {
      featureModelConstraints = TextExpressionParser.getConstraints(featuremodel);
   }

   public List<FeatureExpression> getConstraints() {
      return featureModelConstraints;
   }

   private void createAllViews() {
      GroupModel viewModel = viewContainer.getFeatureMapping().getViewModel();
      List<AbstractGroup> allGroups = GroupModelUtil.getAllGroups(viewModel, true);
      for (AbstractGroup abstractGroup : allGroups) {
         createView(abstractGroup);
      }

   }

   /**
    * get the mapping model used to determine views.
    * 
    * @return
    */
   public MappingModel getViewMapping() {
      return viewContainer.getFeatureMapping();
   }

   /**
    * get all created views;
    * 
    * @return
    */
   public List<View> getAllViews() {
      return viewContainer.getViews();
   }

   /**
    * get the according view, i.e., a set of features for the given view group.
    * 
    * @param group
    * @return
    */
   public View getView(AbstractGroup group) {
      View view = getViewInternal(group);
      if (view == null) {
         view = createView(group);
      }
      return view;
   }

   private View getViewInternal(AbstractGroup group) {
      View view = null;
      EList<View> views = viewContainer.getViews();
      for (View cview : views) {
         AbstractGroup viewgroup = cview.getViewgroup();
         if (viewgroup.equals(group)) {
            view = cview;
            break;
         }
      }
      return view;
   }

   private View createView(AbstractGroup group) {
      View view = ViewFactory.eINSTANCE.createView();
      view.setViewgroup(group);
      view.setId(group.getName());
      EList<Feature> features = view.getFeatures();
      MappingModel viewMapping = viewContainer.getFeatureMapping();
      List<Feature> collectedFeatures = FeatureMappingUtil.collectViewFeatures(group, viewMapping);
      features.addAll(collectedFeatures);

      viewContainer.getViews().add(view);
      return view;
   }

   /**
    * check if the given feature is contained in the view belonging to the given viewgroup.
    * 
    * @param feature
    * @param viewgroup
    * @return
    */
   public boolean isFeatureContained(Feature feature, AbstractGroup viewgroup) {
      View view = getView(viewgroup);
      return view.getFeatures().contains(feature);
   }

}

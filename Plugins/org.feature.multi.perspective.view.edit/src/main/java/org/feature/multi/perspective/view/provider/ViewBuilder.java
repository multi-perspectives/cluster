package org.feature.multi.perspective.view.provider;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.feature.model.utilities.FeatureMappingUtil;
import org.feature.model.utilities.GroupModelUtil;
import org.feature.multi.perspective.mapping.viewmapping.MappingModel;
import org.feature.multi.perspective.model.viewmodel.AbstractGroup;
import org.feature.multi.perspective.model.viewmodel.GroupModel;
import org.feature.multi.perspective.view.View;
import org.feature.multi.perspective.view.ViewContainer;
import org.feature.multi.perspective.view.ViewFactory;
import org.featuremapper.models.feature.Feature;

/**
 * create all views specified by the given viewmapping.
 * 
 * @author <a href=mailto:julia.schroeter@tu-dresden.de>Julia Schroeter</a>
 * 
 */
public class ViewBuilder {

   private ViewContainer viewContainer;

   public ViewBuilder(MappingModel viewMapping, boolean initViews) {
      init(initViews, viewMapping);
   }

   private void init(boolean initViews, MappingModel viewMapping) {
      viewContainer = ViewFactory.eINSTANCE.createViewContainer();
      viewContainer.setFeatureMapping(viewMapping);
      if (initViews) {
         createAllViews();
      }
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
    * @return
    */
   public MappingModel getViewMapping(){
      return viewContainer.getFeatureMapping();
   }
   
   /**
    * get all created views;
    * @return
    */
   public List<View> getAllViews(){
      return viewContainer.getViews();
   }
   /**
    * get the according view, i.e., a set of features for the given view group.
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

}

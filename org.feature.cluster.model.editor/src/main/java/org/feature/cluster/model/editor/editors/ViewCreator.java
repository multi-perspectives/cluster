/**
 * 
 */
package org.feature.cluster.model.editor.editors;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.feature.cluster.model.cluster.CoreGroup;
import org.feature.cluster.model.cluster.Group;
import org.feature.cluster.model.cluster.GroupModel;
import org.feature.model.utilities.FeatureMappingUtil;
import org.feature.model.utilities.FeatureModelUtil;
import org.featuremapper.models.feature.Feature;
import org.featuremapper.models.feature.FeatureModel;
import org.featuremapper.models.featuremapping.And;
import org.featuremapper.models.featuremapping.ElementMapping;
import org.featuremapper.models.featuremapping.FeatureMappingModel;
import org.featuremapper.models.featuremapping.FeatureRef;
import org.featuremapper.models.featuremapping.Mapping;
import org.featuremapper.models.featuremapping.Term;

/**
 * This class creates the views for every {@link Group} and the {@link CoreGroup} from the {@link GroupModel}.
 * 
 * @author Tim Winkelmann
 * 
 */
public class ViewCreator {

   private CoreGroup coreGroup;
   private EList<Mapping> mappings;
   private List<View> views;
   private List<Feature> mappedFeatures = new LinkedList<Feature>();


   public ViewCreator(FeatureMappingModel featureMapping) {
      init(featureMapping);
   }

   private void init(FeatureMappingModel featureMapping) {
      setMappings(featureMapping.getMappings());
      GroupModel groupModel = FeatureMappingUtil.getSolutionGroupModel(featureMapping);
      setCoreGroup(groupModel.getCoreGroup());
      FeatureModel featureModel = FeatureMappingUtil.getFeatureModel(featureMapping);

      List<Feature> allFeatures = FeatureModelUtil.getAllFeatures(featureModel);
      initViews(featureModel, allFeatures);
   }

   private void initViews(FeatureModel featureModel, List<Feature> allFeatures) {
      // <Name of Group, {@link Group}||{@link DefaultGroup}>
      List<EObject> listOfGroups = createMapOfGroups();
      views = createViews(listOfGroups, featureModel);
      for (View view : views) {
         if (view.getGroup().equals(coreGroup)) {
            allFeatures.removeAll(mappedFeatures);
            view.getFeatures().addAll(allFeatures);
         }
      }
   }

  public List<Feature> getUnmappedFeatures(FeatureModel featureModel){
     List<Feature> unmapped = FeatureModelUtil.getAllFeatures(featureModel);
     unmapped.removeAll(mappedFeatures);
     return unmapped;
  } 
   
   /**
    * create the views
    * 
    * @param mapOfGroups
    */
   private List<View> createViews(List<EObject> groups, FeatureModel featureModel) {
      List<View> views = new LinkedList<View>();
      for (EObject group : groups) {
         views.add(new View(group, getFeatures(group), featureModel));
      }
      return views;
   }

   /**
    * finds the features mapped to the group. If no mapping exists the list will be empty.
    * 
    * @param group the {@link Group} or {@link CoreGroup}.
    * @return a set of features or an empty list.
    */
   private Set<Feature> getFeatures(EObject group) {
      Set<Feature> features = new HashSet<Feature>();
      for (Mapping mapping : getMappings()) {
         if (mapping instanceof ElementMapping) {
            ElementMapping elementMapping = (ElementMapping) mapping;
            EObject element = elementMapping.getElement();
            if (element.equals(group)) {
               Term term = elementMapping.getTerm();
               if (term instanceof FeatureRef) {
                  FeatureRef featureRef = (FeatureRef) term;
                  features.add(featureRef.getFeature());
                  mappedFeatures.add(featureRef.getFeature());
               } else {
                  if (term instanceof And) {
                     And and = (And) term;
                     EList<Term> terms = and.getTerms();
                     for (Term andTerm : terms) {
                        if (andTerm instanceof FeatureRef) {
                           FeatureRef featureRef = (FeatureRef) andTerm;
                           features.add(featureRef.getFeature());
                           mappedFeatures.add(featureRef.getFeature());
                        }
                     }
                  }
               }
            }
         }
      }
      return features;
   }

   /**
    * creates a list of groups.
    * 
    * @return a list of groups.
    */
   private List<EObject> createMapOfGroups() {
      List<EObject> listOfGroups = new LinkedList<EObject>();
      listOfGroups.add(getCoreGroup());
      EList<Group> groups = getCoreGroup().getGroups();
      createMapOfGroups(groups, listOfGroups);
      return listOfGroups;
   }

   /**
    * used to create the map of groups.
    * 
    * @param groups the groups that will be added
    * @param listOfGroups the map.
    */
   private void createMapOfGroups(EList<Group> groups, List<EObject> listOfGroups) {
      for (Group group : groups) {
         listOfGroups.add(group);
         if (!group.getGroups().isEmpty()) {
            createMapOfGroups(group.getGroups(), listOfGroups);
         }
      }
   }

   /**
    * @return the views
    */
   public List<View> getViews() {
      return views;
   }

   public EList<Mapping> getMappings() {
      return mappings;
   }

   public void setMappings(EList<Mapping> mappings) {
      this.mappings = mappings;
   }

   public CoreGroup getCoreGroup() {
      return coreGroup;
   }

   public void setCoreGroup(CoreGroup coreGroup) {
      this.coreGroup = coreGroup;
   }
}

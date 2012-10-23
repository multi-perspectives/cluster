package org.feature.model.utilities;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.featuremapper.models.feature.Attribute;
import org.featuremapper.models.feature.Constraint;
import org.featuremapper.models.feature.Feature;
import org.featuremapper.models.feature.FeatureFactory;
import org.featuremapper.models.feature.FeatureModel;
import org.featuremapper.models.feature.FeatureTreeNode;
import org.featuremapper.models.feature.Group;

public final class FeatureModelUtil {

   public static String id_prefix = "id_";
   public static String attribute_cardinality = "cardinality";
   public static String delimiter = "_";
   public static String whitespace = " ";
   public static String attribute_type_string = "String";
   public static String attribute_id = "id";
   public static String csp_constraintLanguage = "CSP";

   public static String featuremodel_file_extension = "feature";

   private static Logger log = Logger.getLogger(FeatureModelUtil.class);

   /**
    * Create the featuremodel and initialize it.
    * 
    * @return
    */
   public static FeatureModel initFMFeatureModel() {
      FeatureModel featureModel = FeatureFactory.eINSTANCE.createFeatureModel();
      return featureModel;
   }

   private static Group createFeatureGroup(Feature parentFeature) {
      Group newGroup = FeatureFactory.eINSTANCE.createGroup();
      EcoreUtil.setID(newGroup, getRandomId());
      // newGroup.setId(getRandomId());
      parentFeature.getGroups().add(newGroup);
      return newGroup;
   }

   public static Group createFeatureGroup(Feature parentFeature, int min, int max, String id) {
      Group group = createFeatureGroup(parentFeature);
      // group.setId(id);
      EcoreUtil.setID(group, id);
      group.setMinCardinality(min);
      group.setMaxCardinality(max);
      return group;
   }

   private static Feature createFeature(String name, String id) {
      Feature newFeature = FeatureFactory.eINSTANCE.createFeature();
      newFeature.setName(name);
      // createAttribute(newFeature, attribute_id, id, attribute_type_string);
      EcoreUtil.setID(newFeature, id);
      // newFeature.setId(id);
      return newFeature;
   }

   /**
    * create a feature in a group
    * 
    * @param parent
    * @param name
    * @param id
    * @return
    */
   public static Feature createGroupFeature(Group parent, String name, String id) {
      Feature newFeature = createFeature(name, id);
      FeatureModelUtil.setOptional(newFeature);
      Group group = (Group) parent;
      group.getChildFeatures().add(newFeature);
      return newFeature;
   }

   /**
    * create a single feature and a single group containing only the single feature.
    * 
    * @param node
    * @param name
    * @param id
    * @param optional
    * @return
    */
   public static Feature createSingleFeature(FeatureTreeNode node, String name, String id, boolean optional) {
      Group group = null;
      if (node instanceof Feature) {
         Feature fNode = (Feature) node;
         group = createFeatureGroup(fNode);
         if (optional) {
            FeatureModelUtil.setOptional(group);
         } else {
            FeatureModelUtil.setMandatory(group);
         }
      } else if (node instanceof Group) {
         group = (Group) node;
      }

      Feature newFeature = createFeature(name, id);
      group.getChildFeatures().add(newFeature);

      FeatureModelUtil.setOptional(newFeature);
      return newFeature;
   }

   private static void setMandatory(FeatureTreeNode node) {
      Assert.isNotNull(node);
      node.setMinCardinality(1);
      node.setMaxCardinality(1);
   }

   private static void setOptional(FeatureTreeNode node) {
      Assert.isNotNull(node);
      node.setMinCardinality(0);
      node.setMaxCardinality(1);
   }

   /**
    * create the root feature
    * 
    * @param fm
    * @param rootName
    * @param id
    * @return
    */
   public static Feature createRootFeature(FeatureModel fm, String rootName, String id) {
      Feature feature = FeatureFactory.eINSTANCE.createFeature();
      feature.setName(rootName);
      EcoreUtil.setID(feature, id);
      // feature.setId(id);
      // createAttribute(feature, attribute_id, id, attribute_type_string);
      // root feature is mandatory
      FeatureModelUtil.setMandatory(feature);
      fm.setRoot(feature);
      return feature;
   }

   /**
    * create a new constraint.
    * 
    * @param expression
    * @return
    */
   public static Constraint createConstraint(String expression) {
      Constraint constraint = FeatureFactory.eINSTANCE.createConstraint();
      constraint.setLanguage(csp_constraintLanguage);
      constraint.setExpression(expression);
      return constraint;
   }

   /**
    * save the feature model in the file system.
    * 
    * @param model
    * @param fileName
    */
   public static void persistFMFeatureModel(FeatureModel model, String fileName) {
      ResourceSet set = new ResourceSetImpl();
      URI modelURI = URI.createFileURI(fileName);
      Resource modelResource = set.createResource(modelURI);
      modelResource.getContents().add(model);
      try {
         modelResource.save(null);
         log.info("Featuremodel saved to " + fileName);
         ResourceUtil.refreshModelResource(modelResource);
      } catch (IOException e) {
         log.error("Could not save featuremodel to path " + fileName);
      }
   }

   private static String getRandomId() {
      String id = id_prefix;
      id += RandomStringUtils.randomNumeric(6);
      return id;
   }

   /**
    * create a new attribute of the type String.
    * 
    * @param feature
    * @param name
    * @param value
    */
   public static void createStringAttribute(Feature feature, String name, String value) {
      createAttribute(feature, name, value, FeatureModelUtil.attribute_type_string);
   }

   /**
    * add an attribute to a feature.
    * 
    * @param feature
    * @param name
    * @param value
    * @param type
    */
   public static void createAttribute(Feature feature, String name, String value, String type) {
      Attribute attribute = FeatureFactory.eINSTANCE.createAttribute();
      attribute.setName(name);
      attribute.setType(type);
      attribute.setValue(value);
      feature.getAttributes().add(attribute);
   }

   /**
    * set an attribute value. if the attribute does not exist, create it.
    * 
    * @param feature
    * @param name
    * @param value
    * @param type
    */
   public static void setAttribute(Feature feature, String name, String value, String type) {
      // check if attribute is already available
      EList<Attribute> attributes = feature.getAttributes();
      boolean attrExists = false;
      for (Attribute attribute : attributes) {
         String attrName = attribute.getName();
         String attrType = attribute.getType();
         if (StringUtils.equals(attrName, name) && StringUtils.equals(attrType, type)) {
            attribute.setValue(value);
            attrExists = true;
            break;
         }
      }
      if (!attrExists) {
         createAttribute(feature, name, value, type);
      }
   }

   /**
    * get an attribute by its name
    * 
    * @param feature
    * @param attributeName
    * @return
    */
   public static Attribute getAttribute(Feature feature, String attributeName) {
      Attribute attribute = null;
      EList<Attribute> attributes = feature.getAttributes();
      for (Attribute att : attributes) {
         String name = att.getName();
         if (StringUtils.equals(name, attributeName)) {
            attribute = att;
            break;
         }
      }
      return attribute;
   }

   /**
    * get all features contained in a feature model.
    * 
    * @param featuremodel
    * @return
    */
   public static List<Feature> getAllFeatures(FeatureModel featuremodel) {
      EList<Feature> toReturn = new BasicEList<Feature>();
      Feature root = featuremodel.getRoot();
      if (root != null) {
         if (root.getGroups() != null) {
            for (Group g : root.getGroups()) {
               for (Feature f : g.getChildFeatures()) {
                  toReturn.addAll(getFeatureRecursive(f));
               }
            }
         }

         toReturn.add(root);

         EList<FeatureModel> children = featuremodel.getChildren();

         if (children != null) {
            for (FeatureModel fm : children) {
               toReturn.addAll(FeatureModelUtil.getAllFeatures(fm));
            }
         }
      }

      return toReturn;
   }

   private static EList<Feature> getFeatureRecursive(Feature base) {
      EList<Feature> toReturn = new BasicEList<Feature>();

      if (base != null) {
         toReturn.add(base);

         for (Group g : base.getGroups()) {
            for (Feature f : g.getChildFeatures()) {
               toReturn.addAll(getFeatureRecursive(f));
            }
         }
      }

      return toReturn;
   }

   /**
    * get only the constraints form the feature model of a particular language
    * 
    * @param featuremodel
    * @param language
    * @return
    */
   public static List<Constraint> getConstraints(FeatureModel featuremodel, String language) {
      EList<Constraint> constraints = featuremodel.getConstraints();
      List<Constraint> languageConstraints = new ArrayList<Constraint>(constraints.size());
      for (Constraint constraint : constraints) {
         String constraintLanguage = constraint.getLanguage();
         if (StringUtils.equalsIgnoreCase(language, constraintLanguage)) {
            languageConstraints.add(constraint);
         }
      }
      return languageConstraints;
   }

   /**
    * initialize a featuremodel from an Ifile.
    * 
    * @param file
    * @return
    */
   public static FeatureModel getFeatureModel(IFile file, ResourceSet resourceSet) {
      FeatureModel featuremodel = null;
      EObject object = ResourceUtil.getModel(file, resourceSet);
      if (object instanceof FeatureModel) {
         featuremodel = (FeatureModel) object;
      }
      return featuremodel;
   }

   /**
    * Makes feature names unique.
    * 
    * @param allFeatures
    */
   public static boolean makeFeatureNamesUnique(List<Feature> allFeatures) {
      boolean isChanged = false;
      List<Feature> featuresToCompare = new ArrayList<Feature>(allFeatures.size());
      featuresToCompare.addAll(allFeatures);

      for (Feature current : allFeatures) {
         featuresToCompare.remove(current);
         for (Feature next : featuresToCompare) {
            String currentFeatureName = current.getName();
            String nextFeatureName = next.getName();
            if (currentFeatureName.equals(nextFeatureName)) {
               // try to get feature Id:
               Attribute idAttribute = getAttribute(current, attribute_id);
               if (idAttribute != null) {
                  String id = idAttribute.getValue();
                  currentFeatureName += id;
               } else {
                  int hash = current.hashCode();
                  currentFeatureName += hash;
               }
               log.info("Feature name changed. Was: '" + current.getName() + "' Is: '" + currentFeatureName + "'.");
               current.setName(currentFeatureName);
               isChanged = true;
               break;
            }
         }
      }
      return isChanged;
   }

   /**
    * Makes feature names unique.
    * 
    * @param allFeatures
    */
   public static boolean makeFeatureNamesUnique(FeatureModel featureModel) {
      boolean isChanged = false;
      if (featureModel != null) {
         List<Feature> allFeatures = getAllFeatures(featureModel);
         isChanged = makeFeatureNamesUnique(allFeatures);
      }
      return isChanged;
   }

}

package org.feature.transform.splot2fm.utils;

import java.io.IOException;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.featuremapper.models.feature.Attribute;
import org.featuremapper.models.feature.Constraint;
import org.featuremapper.models.feature.Feature;
import org.featuremapper.models.feature.FeatureFactory;
import org.featuremapper.models.feature.FeatureModel;
import org.featuremapper.models.feature.FeatureTreeNode;
import org.featuremapper.models.feature.Group;

public final class FMUtil {

   public static String attribute_id = "id";
   public static String attribute_type_string = "String";
   public static String delimiter = "_";
   public static String whitespace = " ";

   public static String cspconstraintLanguage = "CSP";

   private static Logger log = Logger.getLogger(FMUtil.class);

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
      parentFeature.getGroups().add(newGroup);
      return newGroup;
   }

   public static Group createFeatureGroup(Feature parentFeature, int min, int max) {
      Group group = createFeatureGroup(parentFeature);
      group.setMinCardinality(min);
      group.setMaxCardinality(max);
      return group;
   }

   private static Feature createFeature(String name, String id) {
      Feature newFeature = FeatureFactory.eINSTANCE.createFeature();
      String nameWithoutWhitespace = replaceWhiteSpace(name);
      newFeature.setName(nameWithoutWhitespace);
      addAttributeId(newFeature, id);
      return newFeature;
   }

   public static Feature createGroupFeature(FeatureTreeNode parent, String name, String id) {
      Group group = null;
      Feature newFeature = createFeature(name, id);
      FMUtil.setOptional(newFeature);
      if (parent instanceof Group) {
         group = (Group) parent;
         group.getChildFeatures().add(newFeature);
      } else {
         log.error("Could not create grouped Feature");
      }
      return newFeature;
   }

   public static Feature createSingleFeature(FeatureTreeNode node, String name, String id, boolean optional) {
      Group group = null;
      if (node instanceof Feature) {
         Feature fNode = (Feature) node;
         group = createFeatureGroup(fNode);
         if (optional) {
            FMUtil.setOptional(group);
         } else {
            FMUtil.setMandatory(group);
         }
      } else if (node instanceof Group) {
         group = (Group) node;
      }

      Feature newFeature = createFeature(name, id);
      group.getChildFeatures().add(newFeature);

      FMUtil.setOptional(newFeature);
      return newFeature;
   }

   public static void addStringAttribute(Feature feature, String name, String value) {
      Attribute attribute = FeatureFactory.eINSTANCE.createAttribute();
      attribute.setName(name);
      attribute.setType(FMUtil.attribute_type_string);
      attribute.setValue(value);
      feature.getAttributes().add(attribute);
   }

   private static void addAttributeId(Feature feature, String id) {
      addStringAttribute(feature, attribute_id, id);
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

   public static Feature createRootFeature(FeatureModel fm, String rootName, String id) {
      Feature feature = FeatureFactory.eINSTANCE.createFeature();
      String name = replaceWhiteSpace(rootName);
      feature.setName(name);
      addAttributeId(feature, id);
      // root feature is mandatory
      FMUtil.setMandatory(feature);
      fm.setRoot(feature);
      return feature;
   }

   public static Constraint createCSPConstraint(String expression) {
      Constraint constraint = FeatureFactory.eINSTANCE.createConstraint();
      constraint.setLanguage(cspconstraintLanguage);
      constraint.setExpression(expression);
      return constraint;
   }

   private static String replaceWhiteSpace(String name) {
      return StringUtils.replace(name, FMUtil.whitespace, FMUtil.delimiter);
   }

   public static void persistFMFeatureModel(FeatureModel model, String fileName) {
      ResourceSet set = new ResourceSetImpl();
      URI modelURI = URI.createFileURI(fileName);
      Resource modelResource = set.createResource(modelURI);
      modelResource.getContents().add(model);
      try {
         modelResource.save(null);
         log.info("Featuremodel saved to " + fileName);
         IFile file = WorkspaceSynchronizer.getFile(modelResource);
         if (file != null) {
            file.refreshLocal(IResource.DEPTH_ZERO, null);
         }
      } catch (CoreException e) {
         log.error("Could not refresh featuremodel at path " + fileName);
      } catch (IOException e) {
         log.error("Could not save featuremodel to path " + fileName);
      }
   }

   public static String getAttributeId(Feature feature) {
      EList<Attribute> attributes = feature.getAttributes();
      String featureId = StringUtils.EMPTY;
      for (Attribute attribute : attributes) {
         String attrName = attribute.getName();
         if (StringUtils.equalsIgnoreCase(FMUtil.attribute_id, attrName)) {
            featureId = attribute.getValue();
            break;
         }
      }
      return featureId;
   }

}

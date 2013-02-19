package org.feature.transform.splot2fm;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.EList;
import org.feature.model.utilities.FeatureModelUtil;
import org.featuremapper.models.feature.Constraint;
import org.featuremapper.models.feature.Feature;
import org.featuremapper.models.feature.FeatureModel;
import org.featuremapper.models.feature.Group;
import org.featuremapper.models.feature.presentation.FeatureModelWizard;
import org.feature.transform.splot2fm.utils.FMUtil;
import org.feature.transform.splot2fm.utils.SXFMUtil;

import constraints.BooleanVariable;
import constraints.PropositionalFormula;
import fm.FeatureGroup;
import fm.FeatureModelException;
import fm.FeatureTreeNode;
import fm.GroupedFeature;
import fm.SolitaireFeature;

public class SXFM2FMTransformator {

   private static Logger log = Logger.getLogger(SXFM2FMTransformator.class);

   private static String sxfmModelExtension = "xml";

   public static void parseFiles(List<IFile> files) {
      for (IFile iFile : files) {
         IPath filePath = iFile.getRawLocation();
         String xmlExtension = filePath.getFileExtension();

         if (filePath != null && StringUtils.equalsIgnoreCase(sxfmModelExtension, xmlExtension)) {
            String sxfmFile = filePath.toOSString();

            IPath fmFilePath = filePath.removeFileExtension();
            List<String> extensions = FeatureModelWizard.FILE_EXTENSIONS;
            if (!extensions.isEmpty()) {
               String featureModelExtension = extensions.get(0);
               fmFilePath = fmFilePath.addFileExtension(featureModelExtension);
               String fmFile = fmFilePath.toOSString();

               transform(sxfmFile, fmFile);
            }
         }
      }
   }

   public static void transform(String sxfmFile, String fmFile) {
      try {
         fm.FeatureModel sxfmModel = SXFMUtil.initSXFMFeatureModel(sxfmFile);
         org.featuremapper.models.feature.FeatureModel fmModel = FMUtil.initFMFeatureModel();
         String modelName = sxfmModel.getName();
         fmModel.setName(modelName);
         log.info("----------------------------------------------------");
         log.info("Start Transformation--------------------------------");
         log.info("----------------------------------------------------");
         log.info("Input: '" + sxfmFile + "'");
         log.info("----------------------------------------------------");
         long start = System.currentTimeMillis();
         transform(sxfmModel, fmModel);
         long end = System.currentTimeMillis();
         FMUtil.persistFMFeatureModel(fmModel, fmFile);
         log.info("----------------------------------------------------");
         log.info("Output: '" + fmFile + "'");
         log.info("----------------------------------------------------");
         log.info("Stopp Transformation--------------------------------");
         log.info("----------------------------------------------------");
         log.info("Transformation took " + (end - start) + " ms.");
         analyseModel(fmModel, sxfmModel);

      } catch (FeatureModelException e) {
         log.error("The selected file '" + sxfmFile + "' is not a SXFM feature model and cannot be transformed.");
      }
   }

   private static void analyseModel(FeatureModel fmModel, fm.FeatureModel sxfmModel) {
      int newFeatures = fmModel.getAllFeatures().size();
      int oldFeatures = sxfmModel.countFeatures();
      log.debug("Features parsed  : " + oldFeatures);
      log.debug("Features created : " + newFeatures);
      log.debug("----------------------------------------------------");

      int oldConstraints = sxfmModel.countConstraints();
      int newConstraints = fmModel.getConstraints().size();
      log.debug("Constraints parsed  : " + oldConstraints);
      log.debug("Constraints created : " + newConstraints);
      log.debug("----------------------------------------------------");
      log.debug("----------------------------------------------------");
   }

   private static void transformMetadata(fm.FeatureModel sxfmModel, Feature fmRootFeature) {
      Assert.isNotNull(sxfmModel);
      Assert.isNotNull(fmRootFeature);
      Set<String> metaDataKeys = sxfmModel.getMetaDataKeys();
      log.debug("Add Metadata to Featuremodel.");
      for (String key : metaDataKeys) {
         String value = sxfmModel.getMetaData(key);
         FMUtil.addStringAttribute(fmRootFeature, key, value);
         log.debug("Add Attribute (" + key + " = '" + value + "') to Featuremodel.");
      }
   }

   private static void transform(fm.FeatureModel sxfmModel, org.featuremapper.models.feature.FeatureModel fmModel) {
      Assert.isNotNull(sxfmModel);
      Assert.isNotNull(fmModel);
      log.info("Transformation of Featuremodel '" + sxfmModel.getName() + "'.");

      FeatureTreeNode sxfmRoot = sxfmModel.getRoot();
      String rootName = sxfmRoot.getName();
      String id = sxfmRoot.getID();
      Feature fmRootFeature = FMUtil.createRootFeature(fmModel, rootName, id);
      log.info("Root Node '" + rootName + "' created.");
      transformMetadata(sxfmModel, fmRootFeature);

      for (int i = 0; i < sxfmRoot.getChildCount(); i++) {
         FeatureTreeNode node = (FeatureTreeNode) sxfmRoot.getChildAt(i);
         transformFeatures(node, fmRootFeature);
      }
      
      List<Feature> allFeatures = FeatureModelUtil.getAllFeatures(fmModel);
      FeatureModelUtil.makeFeatureNamesUnique(allFeatures);
      
      transformConstraintsintoExpression(sxfmModel, fmModel);
   }

   private static void transformFeatures(FeatureTreeNode featureNode, org.featuremapper.models.feature.FeatureTreeNode fmParent) {
      // feature is direct child of parent feature -> create single feature
      // group
      if (featureNode instanceof SolitaireFeature) {
         log.debug("SolitaireFeature '" + featureNode.getName() + "' found.");
         SolitaireFeature solitaireFeature = (SolitaireFeature) featureNode;
         Feature fmFeature = transformSolitaireFeature(solitaireFeature, fmParent);
         for (int i = 0; i < featureNode.getChildCount(); i++) {
            FeatureTreeNode node = (FeatureTreeNode) featureNode.getChildAt(i);
            transformFeatures(node, fmFeature);
         }
         // feature is child of feature group -> 1. create group, 2. add
         // further feature to this group
      } else if (featureNode instanceof GroupedFeature) {
         log.debug("GroupedFeature '" + featureNode.getName() + "' found.");
         GroupedFeature groupedFeature = (GroupedFeature) featureNode;
         Feature newFeature = transformGroupedFeature(groupedFeature, fmParent);
         for (int i = 0; i < groupedFeature.getChildCount(); i++) {
            FeatureTreeNode node = (FeatureTreeNode) featureNode.getChildAt(i);
            transformFeatures(node, newFeature);
         }
      } else if (featureNode instanceof FeatureGroup) {
         FeatureGroup fGroup = (FeatureGroup) featureNode;
         log.debug("FeatureGroup " + fGroup.getName() + "[" + fGroup.getMin() + "," + fGroup.getMax() + "]" + " found.");
         transformGroupNode(fGroup, fmParent);
      }

   }

   private static void transformGroupNode(FeatureGroup featureGroup, org.featuremapper.models.feature.FeatureTreeNode fmParent) {
      Group group = null;
      if (fmParent instanceof Feature) {
         Feature parentFeature = (Feature) fmParent;
         int max = featureGroup.getMax();
         int min = featureGroup.getMin();
         group = FMUtil.createFeatureGroup(parentFeature, min, max);
      } else if (fmParent instanceof Group) {
         group = (Group) fmParent;
      }
      for (int i = 0; i < featureGroup.getChildCount(); i++) {
         FeatureTreeNode node = (FeatureTreeNode) featureGroup.getChildAt(i);
         transformFeatures(node, group);
      }
   }

   private static Feature transformSolitaireFeature(SolitaireFeature sxfmNode, org.featuremapper.models.feature.FeatureTreeNode fmParent) {
      String name = sxfmNode.getName();
      String id = sxfmNode.getID();
      boolean optional = sxfmNode.isOptional();
      Feature fmSolitairefeature = FMUtil.createSingleFeature(fmParent, name, id, optional);
      return fmSolitairefeature;
   }

   private static Feature transformGroupedFeature(GroupedFeature sxfmNode, org.featuremapper.models.feature.FeatureTreeNode fmParent) {
      String name = sxfmNode.getName();
      String id = sxfmNode.getID();
      Feature fmFeature = FMUtil.createGroupFeature(fmParent, name, id);
      return fmFeature;
   }

   private static void transformConstraintsintoExpression(fm.FeatureModel sxfmModel, org.featuremapper.models.feature.FeatureModel fmModel) {
      Assert.isNotNull(sxfmModel);
      Assert.isNotNull(fmModel);

      Collection<PropositionalFormula> constraints = sxfmModel.getConstraints();
      EList<Constraint> fmConstraints = fmModel.getConstraints();

      for (PropositionalFormula propositionalFormula : constraints) {
         String formula = propositionalFormula.getFormula();
         log.debug("Propositional Formula: " + formula);
         Collection<BooleanVariable> variables = propositionalFormula.getVariables();

         // find ~ and replace
         formula = StringUtils.replace(formula, "~", "not ");

         // find ids and replace by featurename
         for (BooleanVariable booleanVariable : variables) {
            String id = booleanVariable.getID();
            boolean replaced = false;

            EList<Feature> allFeatures = fmModel.getAllFeatures();
            for (Feature feature : allFeatures) {
               String featureId = FMUtil.getAttributeId(feature);

               if (StringUtils.equalsIgnoreCase(id, featureId)) {
                  String featureName = feature.getName();
                  String regex = "^" + id + "[\\s|)]|[~|\\s|(]" + id + "[\\s|)]|[~|\\s|(]" + id + "$|^id$";
                  Pattern pattern = Pattern.compile(regex);
                  Matcher matcher = pattern.matcher(formula);
                  while (matcher.find()) {
                     MatchResult result = matcher.toMatchResult();
                     int start = result.start();
                     int end = result.end();
                     formula = replace(formula, id, featureName, start, end);
                  }
                  replaced = true;
                  break;
               }
            }
            if (!replaced) {
               log.error("Could not replace the feature id '" + id + "' in the model constraints.");
            }
         }
         log.debug("Transformed Formula: " + formula);
         Constraint newConstraint = FMUtil.createCSPConstraint(formula);
         EList<Feature> constrainedFeatures = newConstraint.getConstrainedFeatures();
         Feature root = fmModel.getRoot();
         // root feature is "context" of the constraint
         constrainedFeatures.add(root);
         fmConstraints.add(newConstraint);
      }
   }

   private static String replace(String input, String searchString, String replacement, int minPosition, int maxPosition) {
      String substring = StringUtils.substring(input, minPosition, maxPosition);
      String replacedSubstring = StringUtils.replace(substring, searchString, replacement);

      String begin = StringUtils.substring(input, 0, minPosition);
      String end = StringUtils.substring(input, maxPosition);
      String result = begin + replacedSubstring + end;

      return result;
   }

}

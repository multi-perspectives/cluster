package org.feature.model.csp.analyze;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.feature.model.csp.CSPModelBuilder;
import org.feature.model.csp.TextExpressionParser;
import org.feature.model.utilities.FeatureModelUtil;
import org.featuremapper.models.feature.Constraint;
import org.featuremapper.models.feature.Feature;
import org.featuremapper.models.feature.FeatureModel;
import org.featuremapper.models.feature.Group;

import choco.cp.solver.CPSolver;
import choco.kernel.model.Model;
import choco.kernel.model.variables.integer.IntegerVariable;
import choco.kernel.solver.variables.integer.IntDomainVar;

/**
 * This class analyzes a given featuremodel and cashes the analyzed values.
 * 
 * @author <a href="mailto:info@juliaschroeter.de">Julia Schroeter</a>
 * 
 */
public class FeatureModelAnalyzer {

   private static Logger log = Logger.getLogger(FeatureModelAnalyzer.class);

   private final FeatureModel model;

   List<Feature> allFeatures;
   List<Feature> mandatoryFeatures;
   List<Feature> coreFeatures;
   List<Feature> variableFeatures;
   Model cspModel;

   List<FeatureVariant> derivableVariants;

   private List<Constraint> allCSPConstraints;

   /**
    * default constructor.
    * 
    * @param model must not be null.
    */
   public FeatureModelAnalyzer(FeatureModel model) {
      this.model = model;
   }

   /**
    * get all the features contained in the featuremodel.
    * 
    * @return
    */
   public List<Feature> getAllFeatures() {
      if (allFeatures == null) {
         allFeatures = FeatureModelUtil.getAllFeatures(model);
      }
      return allFeatures;
   }

   /**
    * get all CSP constraints contained in the featuremodel.
    * 
    * @return
    */
   public List<Constraint> getAllCSPConstraints() {
      if (allCSPConstraints == null) {
         allCSPConstraints = FeatureModelUtil.getConstraints(model, FeatureModelUtil.cps_constraintLanguage);
      }
      return allCSPConstraints;
   }

   public int getConstraintCoverage() {
      Set<Feature> consFeatures = TextExpressionParser.getConstrainedFeatures(model);
      int constrained = consFeatures.size();
      int allFeatures = getAllFeatures().size();
      int percentage = (constrained * 100) / allFeatures;
      return percentage;
   }

   /**
    * get the total number of all CSP-constraints.
    * 
    * @return
    */
   public int getNumberOfAllCSPConstraints() {
      return getAllCSPConstraints().size();
   }

   /**
    * get the total number of all contained features.
    * 
    * @return
    */
   public int getNumberOfAllFeatures() {
      return getAllFeatures().size();
   }

   /**
    * get all mandatory features.
    * 
    * @return
    */
   public List<Feature> getMandatoryFeatures() {
      if (mandatoryFeatures == null) {
         mandatoryFeatures = new ArrayList<Feature>(2);
         List<Feature> features = getAllFeatures();
         for (Feature feature : features) {
            Group group = feature.getParentGroup();
            if (group != null) {
               EList<Feature> childFeatures = group.getChildFeatures();
               if (childFeatures.size() == 1 && group.getMinCardinality() == 1) {
                  mandatoryFeatures.add(feature);
               }
            }
         }
      }
      return mandatoryFeatures;
   }

   /**
    * get the number of all mandatory features.
    * 
    * @return
    */
   public int getNumberOfMandatoryFeatures() {
      return getMandatoryFeatures().size();
   }

   /**
    * get the number of all core features.
    * 
    * @return
    */
   public int getNumberOfCoreFeatures() {
      return getCoreFeatures().size();
   }

   /**
    * get all core features.
    * 
    * @return
    */
   public List<Feature> getCoreFeatures() {
      if (coreFeatures == null) {
         determineCoreAndVariableFeatures();
      }
      return coreFeatures;
   }

   public String getCoreFeaturesAsString() {
      List<Feature> core = getCoreFeatures();
      StringBuffer buffer = new StringBuffer();
      buffer.append("[");
      for (Feature feature : core) {
         if (buffer.length() > 1) {
            buffer.append(", ");
         }
         String name = feature.getName();
         buffer.append(name);
      }
      buffer.append("]");
      return buffer.toString();
   }

   /**
    * get the number of all variable features.
    * 
    * @return
    */
   public int getNumberOfVariableFeatures() {
      return getVariableFeatures().size();
   }

   /**
    * get all features, that are not core.
    * 
    * @return
    */
   public List<Feature> getVariableFeatures() {
      if (variableFeatures == null) {
         determineCoreAndVariableFeatures();
      }
      return variableFeatures;
   }

   private void determineCoreAndVariableFeatures() {
      List<Feature> features = getAllFeatures();
      List<FeatureVariant> variants = getDerivableVariants();
      coreFeatures = new ArrayList<Feature>();
      variableFeatures = new ArrayList<Feature>();

      for (Feature feature : features) {
         boolean isCommon = true;
         Iterator<FeatureVariant> iterator = variants.iterator();
         while (isCommon && iterator.hasNext()) {
            FeatureVariant featureVariant = (FeatureVariant) iterator.next();
            isCommon = featureVariant.containsFeature(feature);
         }
         if (isCommon) {
            coreFeatures.add(feature);
         } else {
            variableFeatures.add(feature);
         }
      }
   }

   public List<FeatureVariant> getDerivableVariants() {
      if (derivableVariants == null) {
         derivableVariants = new ArrayList<FeatureVariant>();
         solveModel();
      }
      return derivableVariants;
   }

   /**
    * get the number of all derivable variants.
    * 
    * @return
    */
   public int getNumberOfDerivableVariants() {
      return getDerivableVariants().size();
   }

   /**
    * Try to find a solution. If one solution was found, return true.
    * @return
    */
   public boolean isSatisfiable(){
      CPSolver solver = new CPSolver();
      Model problemModel = getCSPModel();
      solver.read(problemModel);
      solver.solve();
      return solver.isFeasible();
   }
   
   
   public FeatureVariant getOneVariant(){
      FeatureVariant variant = null;
      CPSolver solver = new CPSolver();
      Model problemModel = getCSPModel();
      solver.read(problemModel);
      log.debug("------------------------------------------");
      int j = 0;
      if (solver.solve()) {
            variant = new FeatureVariant();
            j++;
            for (int i = 0; i < problemModel.getNbIntVars(); i++) {
               IntegerVariable intVar = problemModel.getIntVar(i);
               IntDomainVar var = solver.getVar(intVar);
               int cardinality = var.getVal();
               if (var != null && cardinality > 0) {
                  String id = intVar.getName();
                  if (id != null) {
                     Feature feature = getFeature(id);
                     if (feature != null) {
                        addCardinality(feature, cardinality);
                        variant.addFeature(feature);
                     }
                  }
               }
            }
            log.debug(j + ". variant found: '" + variant.toString() + "'");
            log.debug("------------------------------------------");
         }
      return variant;
   }
   
   private Model getCSPModel() {
      if (cspModel == null) {
         CSPModelBuilder modelBuilder = new CSPModelBuilder();
         cspModel = modelBuilder.getCSPModel(model);
      }
      return cspModel;
   }

   private void solveModel() {
      long start = System.currentTimeMillis();
      CPSolver solver = new CPSolver();
      Model problemModel = getCSPModel();
      solver.read(problemModel);
      log.debug("------------------------------------------");
      int j = 0;
      if (solver.solve()) {
         do {
            FeatureVariant variant = new FeatureVariant();
            j++;
            for (int i = 0; i < problemModel.getNbIntVars(); i++) {
               IntegerVariable intVar = problemModel.getIntVar(i);
               IntDomainVar var = solver.getVar(intVar);
               int cardinality = var.getVal();
               if (var != null && cardinality > 0) {
                  String id = intVar.getName();
                  if (id != null) {
                     Feature feature = getFeature(id);
                     if (feature != null) {
                        addCardinality(feature, cardinality);
                        variant.addFeature(feature);
                     }
                  }
               }
            }
            log.debug(j + ". variant found: '" + variant.toString() + "'");
            log.debug("------------------------------------------");
            derivableVariants.add(variant);
         }
         while (solver.nextSolution());
         long end = System.currentTimeMillis();
         log.info("Check derivable variants took " + (end - start) + " ms.");
         log.info(derivableVariants.size() + " derivable variants found.");
      }
   }

   private void addCardinality(Feature feature, int cardinality) {
      FeatureModelUtil.setAttribute(feature, FeatureModelUtil.attribute_cardinality, Integer.toString(cardinality),
                                    FeatureModelUtil.attribute_type_string);
   }

   private Feature getFeature(String id) {
      Feature foundFeature = null;
      List<Feature> features = getAllFeatures();
      for (Feature feature : features) {
         String featureId = EcoreUtil.getID(feature);
         if (id.equals(featureId)) {
            foundFeature = feature;
            break;
         }
      }
      return foundFeature;
   }

}

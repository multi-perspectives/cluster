/**
 * 
 */
package org.feature.model.csp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.term.propositional.expression.And;
import org.emftext.term.propositional.expression.BinaryOperator;
import org.emftext.term.propositional.expression.FeatureRef;
import org.emftext.term.propositional.expression.Nested;
import org.emftext.term.propositional.expression.Not;
import org.emftext.term.propositional.expression.Or;
import org.emftext.term.propositional.expression.Term;
import org.emftext.term.propositional.expression.UnaryOperator;
import org.feature.model.constraint.Exclude;
import org.feature.model.constraint.FeatureExpression;
import org.feature.model.constraint.Require;
import org.featuremapper.models.feature.Feature;
import org.featuremapper.models.feature.FeatureModel;
import org.featuremapper.models.feature.FeatureTreeNode;
import org.featuremapper.models.feature.Group;

import choco.Choco;
import choco.cp.model.CPModel;
import choco.kernel.model.Model;
import choco.kernel.model.constraints.Constraint;
import choco.kernel.model.variables.integer.IntegerExpressionVariable;
import choco.kernel.model.variables.integer.IntegerVariable;

/**
 * Builder, that transforms a featuremodel into a CSP model.
 * 
 * @author <a href="mailto:info@juliaschroeter.de">Julia Schroeter</a>
 * 
 */
public class CSPModelBuilder {

   private static Logger log = Logger.getLogger(CSPModelBuilder.class);

   private CPModel cspModel;
   private Map<String, IntegerVariable> nodeVariables = new HashMap<String, IntegerVariable>();

   public CPModel getModel() {
      if (cspModel == null) {
         cspModel = new CPModel();
      }
      return cspModel;
   }

   /**
    * Transform a cardinality-based feature model into a constraint model.
    * 
    * @param featuremodel
    */
   public Model getCSPModel(FeatureModel featuremodel) {
      Feature rootFeature = featuremodel.getRoot();
      // according to Benavides2005 transform fm into csp model
      transformFeature(rootFeature);

      transformConstraints(featuremodel);
      // TODO: Parse attributes
      return cspModel;
   }

   private void transformFeature(Feature feature) {
      createFeatureConstraint(feature);

      EList<Group> groups = feature.getGroups();
      for (Group group : groups) {
         transformGroup(group);
      }
   }

   private void transformGroup(Group group) {
      createGroupConstraint(group);
      EList<Feature> childFeatures = group.getChildFeatures();
      for (Feature feature : childFeatures) {
         transformFeature(feature);
      }
   }

   private void transformConstraints(FeatureModel model) {
      List<Term> terms = TextExpressionParser.parseExpressions(model);
      for (Term term : terms) {
         Constraint compound = checkTerm(term);
         getModel().addConstraint(compound);
      }
   }

   private Constraint checkExpression(FeatureExpression featureExpression) {
      Constraint result = null;

      Feature leftFeature = featureExpression.getLeftFeature();
      Feature rightFeature = featureExpression.getRightFeature();
      resolveProxy(leftFeature);
      resolveProxy(rightFeature);
      IntegerVariable leftFeatureVariable = getOrCreateVariable(leftFeature);
      IntegerVariable rightFeatureVariable = getOrCreateVariable(rightFeature);

      if (featureExpression instanceof Require) {
         result = createRequiresConstraint(leftFeatureVariable, rightFeatureVariable);
      } else if (featureExpression instanceof Exclude) {
         result = createExcludesConstraint(leftFeatureVariable, rightFeatureVariable);
      }
      return result;
   }

   private Constraint createExcludesConstraint(IntegerVariable leftFeature, IntegerVariable rightFeature) {
      Constraint leftSelected = Choco.gt(leftFeature, 0);
      Constraint rightNotSelected = Choco.eq(rightFeature, 0);
      Constraint leftRight = Choco.implies(leftSelected, rightNotSelected);

      Constraint rightSelected = Choco.gt(rightFeature, 0);
      Constraint leftNotSelected = Choco.eq(leftFeature, 0);
      Constraint rightLeft = Choco.implies(rightSelected, leftNotSelected);

      Constraint excludeConstraint = Choco.or(leftRight, rightLeft);
      return excludeConstraint;
   }

   private Constraint createRequiresConstraint(IntegerVariable leftFeature, IntegerVariable rightFeature) {
      Constraint leftConstraint = Choco.gt(leftFeature, 0);
      Constraint rightConstraint = Choco.gt(rightFeature, 0);
      Constraint impliesConstraint = Choco.implies(leftConstraint, rightConstraint);
      return impliesConstraint;
   }

   private void resolveProxy(Feature feature) {
      if (feature.eIsProxy()) {
         URI proxyURI = ((org.eclipse.emf.ecore.InternalEObject) feature).eProxyURI();
         String uriFragment = proxyURI.fragment();
         log.warn("Proxy found! UriFragment of proxy is: " + uriFragment);
      }
   }

   private Constraint checkTerm(Term term) {
      Constraint result = null;
      if (term instanceof BinaryOperator) {
         BinaryOperator binTerm = (BinaryOperator) term;
         Term leftTerm = binTerm.getOperand1();
         Constraint leftConstraint = checkTerm(leftTerm);
         Term rightTerm = binTerm.getOperand2();
         Constraint rightConstraint = checkTerm(rightTerm);

         if (term instanceof Or) {
            result = Choco.or(leftConstraint, rightConstraint);
         } else if (term instanceof And) {
            result = Choco.and(leftConstraint, rightConstraint);
         }
      } else if (term instanceof UnaryOperator) {
         UnaryOperator unaryTerm = (UnaryOperator) term;
         Term singleTerm = unaryTerm.getOperand();
         Constraint singleConstraint = checkTerm(singleTerm);
         if (term instanceof Not) {
            result = Choco.not(singleConstraint);
         } else if (term instanceof Nested) {
            result = singleConstraint;
         }
      } else if (term instanceof FeatureRef) {
         FeatureRef featureRefTerm = (FeatureRef) term;
         Feature feature = featureRefTerm.getFeature();
         if (feature.eIsProxy()) {
            URI proxyURI = ((org.eclipse.emf.ecore.InternalEObject) feature).eProxyURI();
            String uriFragment = proxyURI.fragment();
            log.warn("Proxy found! UriFragment of proxy is: " + uriFragment);
         }
         IntegerVariable featureVariable = getOrCreateVariable(feature);
         result = Choco.gt(featureVariable, 0);
      }

      return result;
   }

   private void createFeatureConstraint(Feature feature) {
      Group parentGroup = feature.getParentGroup();
      IntegerVariable childVariable = getOrCreateVariable(feature);

      int minCardinality = getMinChocoCardinality(feature);
      int maxCardinality = getMaxChocoCardinality(feature);

      Constraint greaterThan = Choco.geq(childVariable, minCardinality);
      Constraint smallerThan = Choco.leq(childVariable, maxCardinality);
      Constraint thenConstraint = Choco.and(greaterThan, smallerThan);

      if (parentGroup != null) {
         Feature parentFeature = parentGroup.getParentFeature();
         IntegerVariable parentVariable = getOrCreateVariable(parentFeature);

         // feature value must be in feature cardinality boundaries
         Constraint parentSelected = Choco.gt(parentVariable, 0);
         Constraint parentSelectedAndChildCardinality = Choco.implies(parentSelected, thenConstraint);
         getModel().addConstraint(parentSelectedAndChildCardinality);

         Constraint childSelected = Choco.gt(childVariable, 0);
         Constraint impliesConstraint = Choco.implies(childSelected, parentSelected);
         getModel().addConstraint(impliesConstraint);

      } else {
         // handle rootgroup
         getModel().addConstraint(thenConstraint);
      }

   }

   private void createGroupConstraint(Group group) {
      // group with cardinality {n,m} represented as ifThen(ParentFeature>0;sum(ChildFeature A, ChildFeature
      // B) in {n,m};)
      // if group cardinality is n=m, then ifThen(ParentFeature>0;sum(ChildFeature A, ChildFeature B) = n)
      log.debug("Create constraint for group " + group);
      IntegerVariable parentFeatureVariable = getOrCreateVariable(group.getParentFeature());

      IntegerExpressionVariable childFeatureSum = createChildFeatureVariable(group);
      int minCardinality = getMinChocoCardinality(group);
      int maxCardinality = getMaxChocoCardinality(group);

      Constraint ifConstraint = Choco.gt(parentFeatureVariable, 0);

      Constraint greaterThan = Choco.geq(childFeatureSum, minCardinality);
      Constraint smallerThan = Choco.leq(childFeatureSum, maxCardinality);

      Constraint thenConstraint = Choco.and(greaterThan, smallerThan);

      Constraint groupCardinalityConstraint = Choco.implies(ifConstraint, thenConstraint);
      getModel().addConstraint(groupCardinalityConstraint);
   }

   private int getMaxChocoCardinality(FeatureTreeNode node) {
      int maxCardinality = node.getMaxCardinality();
      int cardinality = maxCardinality;
      if (maxCardinality == -1) {
         cardinality = Choco.MAX_UPPER_BOUND;
      }
      return cardinality;
   }

   private int getMinChocoCardinality(FeatureTreeNode node) {
      int minCardinality = node.getMinCardinality();
      int cardinality = minCardinality;
      if (minCardinality == -1) {
         cardinality = Choco.MIN_LOWER_BOUND;
      }
      return cardinality;
   }

   private IntegerVariable getOrCreateVariable(Feature feature) {
      String id = EcoreUtil.getID(feature);
      IntegerVariable integerVariable = nodeVariables.get(id);
      if (integerVariable == null) {
         integerVariable = createNodeVariable(feature);
      }
      return integerVariable;
   }

   private IntegerVariable createNodeVariable(Feature node) {
      String id = EcoreUtil.getID(node);
      // TODO: wrap node into a [0,1] variable and use the correct [n,m]
      // int minCardinality = getMinChocoCardinality(node);
      int minCardinality = 0;
      int maxCardinality = getMaxChocoCardinality(node);
      log.debug("Create IntegerVariable for '" + id + "' [" + minCardinality + "," + maxCardinality + "].");
      IntegerVariable intNodeVariable = Choco.makeIntVar(id, minCardinality, maxCardinality);
      getModel().addVariable(intNodeVariable);
      nodeVariables.put(id, intNodeVariable);
      return intNodeVariable;
   }

   private IntegerExpressionVariable createChildFeatureVariable(Group group) {
      EList<Feature> childFeatures = group.getChildFeatures();
      List<IntegerVariable> childFeatureVariables = new ArrayList<IntegerVariable>(childFeatures.size());
      for (Feature feature : childFeatures) {
         IntegerVariable childFeatureVariable = getOrCreateVariable(feature);
         childFeatureVariables.add(childFeatureVariable);
      }
      IntegerVariable[] childFeatureVariablesArray = new IntegerVariable[childFeatureVariables.size()];
      childFeatureVariablesArray = childFeatureVariables.toArray(childFeatureVariablesArray);

      IntegerExpressionVariable childFeatureSum = Choco.sum(childFeatureVariablesArray);
      log.debug("Create IntegerExpressionVariable for child features of group " + group);
      return childFeatureSum;
   }

}

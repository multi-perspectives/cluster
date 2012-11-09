/**
 * 
 */
package org.feature.model.csp;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.term.propositional.expression.BinaryOperator;
import org.emftext.term.propositional.expression.FeatureRef;
import org.emftext.term.propositional.expression.Nested;
import org.emftext.term.propositional.expression.Not;
import org.emftext.term.propositional.expression.Or;
import org.emftext.term.propositional.expression.Term;
import org.emftext.term.propositional.expression.UnaryOperator;
import org.emftext.term.propositional.expression.resource.expression.util.ExpressionResourceUtil;
import org.feature.model.constraint.ConstraintFactory;
import org.feature.model.constraint.Exclude;
import org.feature.model.constraint.FeatureExpression;
import org.feature.model.constraint.Require;
import org.feature.model.utilities.FeatureModelUtil;
import org.featuremapper.models.feature.Constraint;
import org.featuremapper.models.feature.Feature;
import org.featuremapper.models.feature.FeatureModel;
import org.featuremapper.models.feature.FeaturePackage;

/**
 * @author <a href="mailto:info@juliaschroeter.de">Julia Schroeter</a>
 * 
 */
public class TextExpressionParser {

   private static Logger log = Logger.getLogger(TextExpressionParser.class);

   /**
    * parse all
    * 
    * @param featuremodel
    */
   public static List<Term> parseExpressions(FeatureModel featuremodel) {
      List<Term> terms = new ArrayList<Term>(featuremodel.getConstraints().size());
      URI uri = EcoreUtil.getURI(featuremodel);
      Resource resource = featuremodel.eResource();
      ResourceSet resourceSet = new ResourceSetImpl();
      if (resource != null) {
         resourceSet = resource.getResourceSet();
      }
      List<Constraint> cspConstraints = FeatureModelUtil.getConstraints(featuremodel, FeatureModelUtil.csp_constraintLanguage);
      for (Constraint constraint : cspConstraints) {
         String expression = constraint.getExpression();
         Term term = parseExpression(expression, uri, resourceSet);
         if (term != null) {
            log.debug("Term for expression '" + expression + "' extracted.");
            terms.add(term);
         }
      }
      return terms;
   }

   public static Set<Feature> getConstrainedFeatures(FeatureModel featuremodel) {
      Set<Feature> constrainedFeatures = new LinkedHashSet<Feature>();
      List<Term> expressions = parseExpressions(featuremodel);
      for (Term term : expressions) {
         constrainedFeatures.addAll(getFeaturesFromTerm(term));
      }
      return constrainedFeatures;
   }

   public static Set<Feature> getFeaturesFromTerm(Term term) {
      Set<Feature> constrainedFeatures = new LinkedHashSet<Feature>();
      Set<FeatureRef> references = getFeatureRefsFromTerm(term);
      for (FeatureRef featureRef : references) {
         constrainedFeatures.add(featureRef.getFeature());
      }
      return constrainedFeatures;
   }

   public static Set<FeatureRef> getFeatureRefsFromTerm(Term term) {
      Set<FeatureRef> constrainedFeatures = new LinkedHashSet<FeatureRef>();
      if (term instanceof BinaryOperator) {
         BinaryOperator binTerm = (BinaryOperator) term;
         Term leftTerm = binTerm.getOperand1();
         constrainedFeatures.addAll(getFeatureRefsFromTerm(leftTerm));
         Term rightTerm = binTerm.getOperand2();
         constrainedFeatures.addAll(getFeatureRefsFromTerm(rightTerm));

      } else if (term instanceof UnaryOperator) {
         UnaryOperator unaryTerm = (UnaryOperator) term;
         Term singleTerm = unaryTerm.getOperand();
         constrainedFeatures.addAll(getFeatureRefsFromTerm(singleTerm));
      } else if (term instanceof FeatureRef) {
         FeatureRef featureRefTerm = (FeatureRef) term;
         constrainedFeatures.add(featureRefTerm);
      }
      return constrainedFeatures;
   }

   /**
    * parse a constraint expression and return the term model
    * 
    * @param expression as String
    * @param featuremodelURI an uri to create a temporary file from
    * @return
    */
   public static Term parseExpression(String expression, URI featuremodelURI, ResourceSet resourceSet) {
      Term term = null;
      InputStream inputStream = new ByteArrayInputStream(expression.getBytes());

      EPackage.Registry.INSTANCE.put(FeaturePackage.eNS_URI, FeaturePackage.eINSTANCE);

      if (inputStream != null) {
         URI uri = featuremodelURI.trimFileExtension().trimFragment();

         String uriString = uri.toString();
         log.debug("FeaturemodelURI: " + uriString);
         uri = URI.createURI(uriString);
         uri = uri.appendFileExtension("_" + inputStream.hashCode());
         uri = uri.appendFileExtension("expression");

         log.debug("Expression resource created for URI " + uri);
         Resource resource = resourceSet.createResource(uri);
         try {
            resource.load(inputStream, Collections.EMPTY_MAP);
            EList<EObject> contents = resource.getContents();
            // an expression must contain only one Term
            if (contents.size() == 1 && contents.get(0) instanceof org.emftext.term.propositional.expression.Constraint) {
               org.emftext.term.propositional.expression.Constraint constraint =
                  (org.emftext.term.propositional.expression.Constraint) contents.get(0);
               term = constraint.getTerm();
            }
            boolean resolved = ExpressionResourceUtil.resolveAll(resource);
            if (resolved) {
               log.debug("All proxies of the expression have been resolved.");
            } else {
               // log.warn("Not all proxies of the expression could be resolved.");
            }

         } catch (IOException e) {
            log.warn("Could not load temporary expression resource '" + uri + "'.");
         }
      }
      return term;
   }

   private static Require createRequires(Feature left, Feature right) {
      Require createRequire = null;
      if (left != null && right != null) {
         createRequire = ConstraintFactory.eINSTANCE.createRequire();
         createRequire.setLeftFeature(left);
         createRequire.setRightFeature(right);
      }
      return createRequire;
   }

   private static Exclude createExcludes(List<Feature> notFeatures) {
      Exclude createExclude = null;
      if (2 == notFeatures.size()) {
         createExclude = ConstraintFactory.eINSTANCE.createExclude();
         createExclude.setLeftFeature(notFeatures.get(0));
         createExclude.setRightFeature(notFeatures.get(1));
      }
      return createExclude;
   }

   public static Require createRequires(Term term) {
      Feature right = null;
      Feature left = null;
      Set<FeatureRef> features = getFeatureRefsFromTerm(term);
      if (features.size() == 2) {
         for (FeatureRef featureRef : features) {
            EObject container = featureRef.eContainer();
            if (container instanceof Nested) {
               container = unnestContainer((Nested) container);
            }
            if (container instanceof Not) {
               left = featureRef.getFeature();
            } else if (container instanceof Or) {
               right = featureRef.getFeature();
            }
         }
      }
      return createRequires(left, right);
   }

   public static Exclude createExcludes(Term term) {
      List<Feature> notFeatures = new ArrayList<Feature>(2);
      Set<FeatureRef> features = getFeatureRefsFromTerm(term);
      if (features.size() == 2) {
         for (FeatureRef featureRef : features) {
            EObject container = featureRef.eContainer();
            if (container instanceof Nested) {
               container = unnestContainer((Nested) container);
            }
            if (container instanceof Not) {
               EObject containerofNot = container.eContainer();
               if (containerofNot instanceof Nested) {
                  containerofNot = unnestContainer((Nested) containerofNot);
               }
               if (containerofNot instanceof Or) {
                  notFeatures.add(featureRef.getFeature());
               }
            }
         }
      }
      return createExcludes(notFeatures);
   }

   private static Term unnestContainer(Nested container) {
      EObject eContainer = container.eContainer();
      if (eContainer instanceof Nested) {
         return unnestContainer((Nested) eContainer);
      }
      Term term = null;
      if (eContainer != null && eContainer instanceof Term) {
         term = (Term) eContainer;
      }
      return term;
   }

   /**
    * get all requires and exclude constraints from the given featuremodel.
    * 
    * @param model
    * @return
    */
   public static Set<FeatureExpression> getConstraints(FeatureModel model) {
      Map<FeatureExpression, Term> map = getTermsMappedToConstraints(model);
      return map.keySet();
   }

   public static Map<FeatureExpression, Term> getTermsMappedToConstraints(FeatureModel featureModel) {
      Map<FeatureExpression, Term> result = new HashMap<FeatureExpression, Term>();
      List<Term> parseExpressions = parseExpressions(featureModel);
      for (Term term : parseExpressions) {
         FeatureExpression expression = createFeatureExpression(term);
         if (expression != null) {
            result.put(expression, term);
         }
      }

      log.debug("found " + parseExpressions.size() + " terms and " + result.size() + " constraints.");
      return result;

   }

   private static FeatureExpression createFeatureExpression(Term term) {
      FeatureExpression expression = null;
      expression = createExcludes(term);
      if (expression == null) {
         expression = createRequires(term);
      }
      return expression;
   }

}

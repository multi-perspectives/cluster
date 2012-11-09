package org.feature.model.csp;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
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
import org.feature.model.constraint.Constraint;
import org.feature.model.constraint.FeatureExpression;
import org.feature.model.constraint.resource.csl.util.CslResourceUtil;
import org.feature.model.utilities.FeatureModelUtil;
import org.featuremapper.models.feature.Feature;
import org.featuremapper.models.feature.FeatureModel;
import org.featuremapper.models.feature.FeaturePackage;

public class ConstraintParser {

   private static Logger log = Logger.getLogger(ConstraintParser.class);

   public static List<FeatureExpression> parseExpressions(FeatureModel featuremodel) {
      List<FeatureExpression> constraints = new ArrayList<FeatureExpression>();
      URI uri = EcoreUtil.getURI(featuremodel);
      Resource resource = featuremodel.eResource();
      ResourceSet resourceSet = new ResourceSetImpl();
      if (resource != null) {
         resourceSet = resource.getResourceSet();
      }
      List<org.featuremapper.models.feature.Constraint> simpleConstraints =
         FeatureModelUtil.getConstraints(featuremodel, FeatureModelUtil.simple_constraintLanguage);
      for (org.featuremapper.models.feature.Constraint simpleConstraint : simpleConstraints) {
         String expression = simpleConstraint.getExpression();
         FeatureExpression con = parseExpression(expression, uri, resourceSet);
         if (con != null && con != null) {
            log.debug("Expression '" + expression + "' extracted.");
            constraints.add(con);
         }
      }
      return constraints;
   }

   /**
    * parse a constraint expression and return the term model
    * 
    * @param expression as String
    * @param featuremodelURI an uri to create a temporary file from
    * @return
    */
   public static FeatureExpression parseExpression(String expression, URI featuremodelURI, ResourceSet resourceSet) {
      FeatureExpression featureExpression = null;
      InputStream inputStream = new ByteArrayInputStream(expression.getBytes());

      EPackage.Registry.INSTANCE.put(FeaturePackage.eNS_URI, FeaturePackage.eINSTANCE);

      if (inputStream != null) {
         URI uri = featuremodelURI.trimFileExtension().trimFragment();

         String uriString = uri.toString();
         log.debug("FeaturemodelURI: " + uriString);
         uri = URI.createURI(uriString);
         uri = uri.appendFileExtension("_" + inputStream.hashCode());
         uri = uri.appendFileExtension("csl");

         log.debug("Expression resource created for URI " + uri);
         Resource resource = resourceSet.createResource(uri);
         try {
            resource.load(inputStream, Collections.EMPTY_MAP);
            EList<EObject> contents = resource.getContents();
            // an expression must contain only one Term
            if (contents.size() == 1 && contents.get(0) instanceof Constraint) {
               Constraint con = (Constraint) contents.get(0);
               featureExpression = con.getExpression();
            }
            boolean resolved = CslResourceUtil.resolveAll(resource);
            if (resolved) {
               log.debug("All proxies of the expression are resolved.");
            } else {
               // log.warn("Not all proxies of the expression could be resolved.");
            }

         } catch (IOException e) {
            log.warn("Could not load temporary expression resource '" + uri + "'.");
         }
      }
      return featureExpression;
   }

   /**
    * return all constrained features.
    * 
    * @param featuremodel
    * @return
    */
   public static Set<Feature> getConstrainedFeatures(FeatureModel featuremodel) {
      Set<Feature> constrainedFeatures = new LinkedHashSet<Feature>();
      List<FeatureExpression> expressions = parseExpressions(featuremodel);
      for (FeatureExpression constraint : expressions) {
         constrainedFeatures.addAll(getFeaturesFromConstraint(constraint));
      }
      return constrainedFeatures;
   }

   public static Set<Feature> getFeaturesFromConstraint(FeatureExpression con) {
      Set<Feature> constrainedFeatures = new LinkedHashSet<Feature>();
      Feature leftFeature = con.getLeftFeature();
      Feature rightFeature = con.getRightFeature();
      if (leftFeature != null) {
         constrainedFeatures.add(leftFeature);
      }
      if (rightFeature != null) {
         constrainedFeatures.add(rightFeature);
      }
      return constrainedFeatures;
   }

}

package org.feature.multi.perspective.measure.performance;

import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.feature.model.utilities.ResourceUtil;
import org.feature.multi.perspective.classification.AutoClassification;
import org.feature.multi.perspective.classification.ClassificationModel;

public class ClassificationCheckHandler extends AbstractCheckHandler {

   String measure = "Measure Performance of Autoclassification";

   Logger log = Logger.getLogger(ClassificationCheckHandler.class);

   protected void measurePerformance(String projectName) {
      log.debug("-------------------------------");
      String folderName = classificationFolder;
      log.debug("check classification of " + projectName);
      try {
         checkModelsInProject(projectName, folderName);
      } catch (CoreException e) {
         log.error("Could not determine children of folder " + folderName);
      }
      // }
   }

   List<Long> autoCLassificationTimeList = new LinkedList<Long>();

   @Override
   void clearLists() {
      autoCLassificationTimeList.clear();
   }

   @Override
   String getMeasureName() {
      return measure;
   }

   @Override
   void printPerformanceMeasure() {
      printCollection("Time AutoClassification ", autoCLassificationTimeList);

   }

   @Override
   void check(IFile file) {
      EObject model = ResourceUtil.getModel(file, new ResourceSetImpl());
      if (model instanceof ClassificationModel) {
         ClassificationModel classificationModel = (ClassificationModel) model;
         measureClassification(classificationModel);
      }
   }

   private void measureClassification(ClassificationModel classificationModel) {
      long startCl = System.currentTimeMillis();
      AutoClassification autoClassification = new AutoClassification(classificationModel);
      autoClassification.autoComplete();
      long endCl = System.currentTimeMillis();
      long timeCl = endCl - startCl;
      autoCLassificationTimeList.add(timeCl);
   }

   @Override
   Logger getLogger() {
      return log;
   }

}

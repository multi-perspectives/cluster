package org.feature.multi.perspective.measure.performance;

import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.EObject;
import org.feature.multi.perspective.classification.AutoClassification;
import org.feature.multi.perspective.classification.ClassificationModel;
import org.feature.multi.perspective.classification.resource.clt.ICltParseResult;
import org.feature.multi.perspective.classification.resource.clt.ICltTextParser;
import org.feature.multi.perspective.classification.resource.clt.mopp.CltMetaInformation;

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
      CltMetaInformation metaInfo = new CltMetaInformation();
      try {
         InputStream contents = file.getContents();
         ICltTextParser createParser = metaInfo.createParser(contents, null);
         ICltParseResult parse = createParser.parse();
         EObject root = parse.getRoot();
         if (root instanceof ClassificationModel) {
            ClassificationModel classificationModel = (ClassificationModel) root;
            measureClassification(classificationModel);
         }
      } catch (CoreException e) {
         log.error(e.getMessage());
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

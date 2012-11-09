/**
 * 
 */
package org.feature.multi.perspective.measure.performance;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.IJobChangeEvent;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.core.runtime.jobs.JobChangeAdapter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.feature.model.utilities.WorkbenchUtil;
import org.feature.multi.perspective.mapping.viewmapping.ViewmappingPackage;

/**
 * @author <a href=mailto:julia.schroeter@tu-dresden.de>Julia Schroeter</a>
 * 
 */
public abstract class AbstractCheckHandler extends AbstractHandler {

   protected Job job;

   protected static String generatedProject = "generatedProject";
   // private static String[] genProjects = new String[] {
   // "vp100nc_cnf5000", "vp100nc_cnf5000",
   // "vp100nc_cnf10000", "vp100nc_cnf10000", "vp100nc_cnf10000",
   // "vp100nc_cnf2000","vp100nc_cnf2000","vp100nc_cnf2000" };

   protected static String mappingFolder = ViewmappingPackage.eNS_PREFIX;

   @Override
   public Object execute(ExecutionEvent event) throws ExecutionException {
      createJob();
      return null;
   }

   private void createJob() {

      final Job job = new Job("Measure Performance of Consistency Check") {

         protected IStatus run(IProgressMonitor monitor) {
            try {
               measurePerformance();
               printPerformanceMeasure();
               if (monitor.isCanceled()) return Status.CANCEL_STATUS;
               return Status.OK_STATUS;
            }
            finally {
               // schedule(60000); // start again in an hour
            }
         }
      };

      job.addJobChangeListener(new JobChangeAdapter() {

         public void done(IJobChangeEvent event) {
            if (event.getResult().isOK())
               postMessage("Performance Measurement completed successfully");
            else
               postError("Performance Measurement did not complete successfully");
         }

         private void postError(String msg) {
            Shell shell = WorkbenchUtil.getShell();
            if (shell != null) {
               MessageBox msgBox = new MessageBox(shell, SWT.OK | SWT.ICON_ERROR);
               msgBox.setMessage(msg);
               msgBox.open();
            }
         }

         private void postMessage(String msg) {
            Shell shell = WorkbenchUtil.getShell();
            if (shell != null) {
               MessageBox msgBox = new MessageBox(shell, SWT.OK | SWT.ICON_INFORMATION);
               msgBox.setMessage(msg);
               msgBox.open();
            }
         }
      });
      job.setSystem(true);
      job.schedule(); // start as soon as possible
   }

   abstract void measurePerformance();

   abstract void printPerformanceMeasure();

   @Override
   public void dispose() {
      if (job != null) {
         job.cancel();
      }
      super.dispose();
   }
   
}

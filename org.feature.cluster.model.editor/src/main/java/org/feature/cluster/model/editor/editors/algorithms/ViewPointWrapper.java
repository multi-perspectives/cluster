/**
 * 
 */
package org.feature.cluster.model.editor.editors.algorithms;

/**
 * @author <a href=mailto:info@juliaschroeter.de>Julia Schroeter</a>
 * 
 */
public class ViewPointWrapper {

   String vpName;
   boolean isConsistent;

   public ViewPointWrapper(String vpName, boolean isConsistent) {
      this.vpName = vpName;
      this.isConsistent = isConsistent;
   }

   /**
    * return the name of the viewpoint.
    * @return
    */
   public String getVpName() {
      return vpName;
   }

   /**
    * return whether the viewpoint is consistent.
    * @return tru if consistent
    */
   public boolean isConsistent() {
      return isConsistent;
   }

   @Override
   public String toString() {
      return vpName + "[" + isConsistent + "]";
   }

}

/**
 * 
 */
package org.feature.model.utilities;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.feature.multi.perspective.model.cluster.CoreGroup;
import org.feature.multi.perspective.model.cluster.Group;
import org.feature.multi.perspective.model.cluster.GroupModel;

/**
 * 
 * Utility class for commonly used GroupModel access and modification methods.
 * 
 * @author <a href=mailto:info@juliaschroeter.de>Julia Schroeter</a>
 * 
 */
public final class GroupModelUtil {

   /**
    * get all groups contained in the groupmodel.
    * 
    * @param grupModel
    * @return list containing all groups
    */
   public static List<Group> getAllGroups(GroupModel groupModel) {
      List<Group> result = new ArrayList<Group>();
      CoreGroup core = groupModel.getCoreGroup();
      if (core != null) {
         result.addAll(getGroups(core));
      }
      return result;
   }

   private static List<Group> getGroups(Group parent) {
      List<Group> result = new ArrayList<Group>();
      EList<Group> groups = parent.getGroups();
      result.addAll(groups);
      for (Group group : groups) {
         result.addAll(getGroups(group));
      }
      return result;
   }

}

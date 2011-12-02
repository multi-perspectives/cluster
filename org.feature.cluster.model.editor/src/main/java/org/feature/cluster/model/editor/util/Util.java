/**
 * 
 */
package org.feature.cluster.model.editor.util;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.swt.graphics.Color;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsoleManager;
import org.eclipse.ui.console.MessageConsole;
import org.eclipse.zest.core.widgets.GraphConnection;
import org.eclipse.zest.core.widgets.GraphNode;

/**
 * @author winkelti
 *
 */
public class Util {
	public static final Color attachedGraphNodeBackgroundColor = ColorConstants.green;
	public static final Color unattachedGraphNodeBackgroundColor = new Color(null, 216, 228, 248);
	public static final Color attachedGraphConnectionLineColor = ColorConstants.green;
	public static final Color unattachedGraphConnectionLineColor = new Color(null, 192, 192, 192);
	public static List<GraphNode> attachedGraphNodes = new LinkedList<GraphNode>();
	public static List<GraphConnection> highlightedGraphConnections = new LinkedList<GraphConnection>();
	
	public static final String consoleName = "Cluster";
	/**
	 * fins a console by a name.
	 * @param name use the {@link Util}.consoleName
	 * @return a Console
	 */
	public static MessageConsole findConsole(String name) {
	      ConsolePlugin plugin = ConsolePlugin.getDefault();
	      IConsoleManager conMan = plugin.getConsoleManager();
	      IConsole[] existing = conMan.getConsoles();
	      for (int i = 0; i < existing.length; i++)
	         if (name.equals(existing[i].getName()))
	            return (MessageConsole) existing[i];
	      //no console found, so create a new one
	      MessageConsole myConsole = new MessageConsole(name, null);
	      conMan.addConsoles(new IConsole[]{myConsole});
	      return myConsole;
	   }
}

/**
 * 
 */
package org.feature.cluster.model.editor.editors;

import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;
import org.apache.log4j.WriterAppender;
import org.feature.cluster.model.editor.util.Util;

/**
 * @author winkelti
 *
 */
public class Log4JAppender extends WriterAppender {
	public static Log4JAppender app = new Log4JAppender();
	
	private Log4JAppender() {
		super(new SimpleLayout(), Util.findConsole(Util.consoleName).newMessageStream());
		Logger.getRootLogger().addAppender(this);
	}
}

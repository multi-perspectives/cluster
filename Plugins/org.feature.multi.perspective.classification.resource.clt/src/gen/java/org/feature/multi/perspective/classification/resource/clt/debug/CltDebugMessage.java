/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.multi.perspective.classification.resource.clt.debug;

/**
 * DebugMessages are exchanged between the debug server (the Eclipse debug
 * framework) and the debug client (a running process or interpreter). To exchange
 * messages they are serialized and sent over sockets.
 */
public class CltDebugMessage {
	
	private static final char DELIMITER = ':';
	private org.feature.multi.perspective.classification.resource.clt.debug.ECltDebugMessageTypes messageType;
	private String[] arguments;
	
	public CltDebugMessage(org.feature.multi.perspective.classification.resource.clt.debug.ECltDebugMessageTypes messageType, String[] arguments) {
		super();
		this.messageType = messageType;
		this.arguments = arguments;
	}
	
	public CltDebugMessage(org.feature.multi.perspective.classification.resource.clt.debug.ECltDebugMessageTypes messageType, java.util.List<String> arguments) {
		super();
		this.messageType = messageType;
		this.arguments = new String[arguments.size()];
		for (int i = 0; i < arguments.size(); i++) {
			this.arguments[i] = arguments.get(i);
		}
	}
	
	public org.feature.multi.perspective.classification.resource.clt.debug.ECltDebugMessageTypes getMessageType() {
		return messageType;
	}
	
	public String[] getArguments() {
		return arguments;
	}
	
	public String serialize() {
		java.util.List<String> parts = new java.util.ArrayList<String>();
		parts.add(messageType.name());
		for (String argument : arguments) {
			parts.add(argument);
		}
		return org.feature.multi.perspective.classification.resource.clt.util.CltStringUtil.encode(DELIMITER, parts);
	}
	
	public static CltDebugMessage deserialize(String response) {
		java.util.List<String> parts = org.feature.multi.perspective.classification.resource.clt.util.CltStringUtil.decode(response, DELIMITER);
		String messageType = parts.get(0);
		String[] arguments = new String[parts.size() - 1];
		for (int i = 1; i < parts.size(); i++) {
			arguments[i - 1] = parts.get(i);
		}
		org.feature.multi.perspective.classification.resource.clt.debug.ECltDebugMessageTypes type = org.feature.multi.perspective.classification.resource.clt.debug.ECltDebugMessageTypes.valueOf(messageType);
		CltDebugMessage message = new CltDebugMessage(type, arguments);
		return message;
	}
	
	public boolean hasType(org.feature.multi.perspective.classification.resource.clt.debug.ECltDebugMessageTypes type) {
		return this.messageType == type;
	}
	
	public String getArgument(int index) {
		return getArguments()[index];
	}
	
	public String toString() {
		return this.getClass().getSimpleName() + "[" + messageType.name() + ": " + org.feature.multi.perspective.classification.resource.clt.util.CltStringUtil.explode(arguments, ", ") + "]";
	}
	
}

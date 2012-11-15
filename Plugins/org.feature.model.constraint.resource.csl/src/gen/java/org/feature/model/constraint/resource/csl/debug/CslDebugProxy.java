/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.model.constraint.resource.csl.debug;

/**
 * The DebugProxy allows to communicate between the interpreter, which runs in a
 * separate thread or process and the Eclipse Debug framework (i.e., the
 * DebugTarget class).
 */
public class CslDebugProxy {
	
	public static final int STARTUP_DELAY = 1000;
	
	private java.io.PrintStream output;
	
	private java.io.BufferedReader reader;
	
	private org.feature.model.constraint.resource.csl.debug.CslDebugTarget debugTarget;
	
	private org.feature.model.constraint.resource.csl.debug.CslDebugCommunicationHelper communicationHelper = new org.feature.model.constraint.resource.csl.debug.CslDebugCommunicationHelper();
	
	public CslDebugProxy(org.feature.model.constraint.resource.csl.debug.CslDebugTarget debugTarget, int requestPort) throws java.net.UnknownHostException, java.io.IOException {
		this.debugTarget = debugTarget;
		// give interpreter a chance to start
		try {
			Thread.sleep(STARTUP_DELAY);
		} catch (InterruptedException e) {
		}
		startSocket(requestPort);
	}
	
	private void startSocket(int requestPort) throws java.net.UnknownHostException, java.io.IOException {
		// creating client proxy socket (trying to connect)...
		java.net.Socket client = new java.net.Socket("localhost", requestPort);
		// creating client proxy socket - done. (connected)
		try {
			java.io.BufferedInputStream input = new java.io.BufferedInputStream(client.getInputStream());
			reader = new java.io.BufferedReader(new java.io.InputStreamReader(input));
		} catch (java.io.IOException e) {
			System.out.println(e);
		}
		try {
			output = new java.io.PrintStream(client.getOutputStream());
		} catch (java.io.IOException e) {
			System.out.println(e);
		}
	}
	
	public void resume() {
		sendCommand(org.feature.model.constraint.resource.csl.debug.ECslDebugMessageTypes.RESUME);
	}
	
	public void stepOver() {
		sendCommand(org.feature.model.constraint.resource.csl.debug.ECslDebugMessageTypes.STEP_OVER);
	}
	
	public void stepInto() {
		sendCommand(org.feature.model.constraint.resource.csl.debug.ECslDebugMessageTypes.STEP_INTO);
	}
	
	public void stepReturn() {
		sendCommand(org.feature.model.constraint.resource.csl.debug.ECslDebugMessageTypes.STEP_RETURN);
	}
	
	public void terminate() {
		sendCommand(org.feature.model.constraint.resource.csl.debug.ECslDebugMessageTypes.EXIT);
	}
	
	public org.feature.model.constraint.resource.csl.debug.CslDebugMessage getStack() {
		return sendCommandAndRead(org.feature.model.constraint.resource.csl.debug.ECslDebugMessageTypes.GET_STACK);
	}
	
	public void addLineBreakpoint(String location, int line) {
		org.feature.model.constraint.resource.csl.debug.CslDebugMessage message = new org.feature.model.constraint.resource.csl.debug.CslDebugMessage(org.feature.model.constraint.resource.csl.debug.ECslDebugMessageTypes.ADD_LINE_BREAKPOINT, new String[] {location, Integer.toString(line)});
		communicationHelper.sendEvent(message, output);
	}
	
	public void removeLineBreakpoint(String location, int line) {
		org.feature.model.constraint.resource.csl.debug.CslDebugMessage message = new org.feature.model.constraint.resource.csl.debug.CslDebugMessage(org.feature.model.constraint.resource.csl.debug.ECslDebugMessageTypes.REMOVE_LINE_BREAKPOINT, new String[] {location, Integer.toString(line)});
		communicationHelper.sendEvent(message, output);
	}
	
	public org.eclipse.debug.core.model.IVariable[] getStackVariables(String stackFrame) {
		org.feature.model.constraint.resource.csl.debug.CslDebugMessage response = sendCommandAndRead(org.feature.model.constraint.resource.csl.debug.ECslDebugMessageTypes.GET_FRAME_VARIABLES, new String[] {stackFrame});
		String[] ids = response.getArguments();
		// fetch all variables
		org.eclipse.debug.core.model.IVariable[] variables = getVariables(ids);
		return variables;
	}
	
	public org.eclipse.debug.core.model.IVariable[] getVariables(String... requestedIDs) {
		org.feature.model.constraint.resource.csl.debug.CslDebugMessage response = sendCommandAndRead(org.feature.model.constraint.resource.csl.debug.ECslDebugMessageTypes.GET_VARIABLES, requestedIDs);
		String[] varStrings = response.getArguments();
		org.feature.model.constraint.resource.csl.debug.CslDebugVariable[] variables  = new org.feature.model.constraint.resource.csl.debug.CslDebugVariable[varStrings.length];
		int i = 0;
		for (String varString : varStrings) {
			java.util.Map<String, String> properties = org.feature.model.constraint.resource.csl.util.CslStringUtil.convertFromString(varString);
			
			// convert varString to variables and values
			String valueString = properties.get("!valueString");
			String valueRefType = "valueRefType";
			java.util.Map<String, Long> childVariables = new java.util.TreeMap<String, Long>(new java.util.Comparator<String>() {
				public int compare(String s1, String s2) {
					return s1.compareToIgnoreCase(s2);
				}
			});
			for (String property : properties.keySet()) {
				// ignore special properties - they are not children
				if (property.startsWith("!")) {
					continue;
				}
				childVariables.put(property, Long.parseLong(properties.get(property)));
			}
			String id = properties.get("!id");
			org.eclipse.debug.core.model.IValue value = new org.feature.model.constraint.resource.csl.debug.CslDebugValue(debugTarget, id, valueString, valueRefType, childVariables);
			
			String variableName = properties.get("!name");
			String variableRefType = properties.get("!type");
			
			org.feature.model.constraint.resource.csl.debug.CslDebugVariable variable = new org.feature.model.constraint.resource.csl.debug.CslDebugVariable(debugTarget, variableName, value, variableRefType);
			variables[i++] = variable;
		}
		return variables;
	}
	
	private void sendCommand(org.feature.model.constraint.resource.csl.debug.ECslDebugMessageTypes command, String... parameters) {
		org.feature.model.constraint.resource.csl.debug.CslDebugMessage message = new org.feature.model.constraint.resource.csl.debug.CslDebugMessage(command, parameters);
		communicationHelper.sendEvent(message, output);
	}
	
	private org.feature.model.constraint.resource.csl.debug.CslDebugMessage sendCommandAndRead(org.feature.model.constraint.resource.csl.debug.ECslDebugMessageTypes command, String... parameters) {
		org.feature.model.constraint.resource.csl.debug.CslDebugMessage message = new org.feature.model.constraint.resource.csl.debug.CslDebugMessage(command, parameters);
		return communicationHelper.sendAndReceive(message, output, reader);
	}
	
}

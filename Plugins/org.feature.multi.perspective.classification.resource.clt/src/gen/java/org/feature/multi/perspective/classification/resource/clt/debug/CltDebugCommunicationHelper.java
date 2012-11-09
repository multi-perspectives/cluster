/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.multi.perspective.classification.resource.clt.debug;

public class CltDebugCommunicationHelper {
	
	public void sendEvent(org.feature.multi.perspective.classification.resource.clt.debug.CltDebugMessage message, java.io.PrintStream stream) {
		synchronized (stream) {
			stream.println(message.serialize());
		}
	}
	
	/**
	 * Sends a message using the given stream and waits for an answer.
	 * 
	 * @param messageType the type of message to send
	 * @param stream the stream to send the message to
	 * @param reader the reader to obtain the answer from
	 * @param parameters additional parameter to send
	 * 
	 * @return the answer that is received
	 */
	public org.feature.multi.perspective.classification.resource.clt.debug.CltDebugMessage sendAndReceive(org.feature.multi.perspective.classification.resource.clt.debug.CltDebugMessage message, java.io.PrintStream stream, java.io.BufferedReader reader) {
		synchronized (stream) {
			sendEvent(message, stream);
			org.feature.multi.perspective.classification.resource.clt.debug.CltDebugMessage response = receive(reader);
			return response;
		}
	}
	
	/**
	 * Receives a message from the given reader. This method block until a message has
	 * arrived.
	 * 
	 * @param reader the read to obtain the message from
	 * 
	 * @return the received message
	 */
	public org.feature.multi.perspective.classification.resource.clt.debug.CltDebugMessage receive(java.io.BufferedReader reader) {
		try {
			String response = reader.readLine();
			if (response == null) {
				return null;
			}
			org.feature.multi.perspective.classification.resource.clt.debug.CltDebugMessage receivedMessage = org.feature.multi.perspective.classification.resource.clt.debug.CltDebugMessage.deserialize(response);
			return receivedMessage;
		} catch (java.io.IOException e) {
			return null;
		}
	}
	
}

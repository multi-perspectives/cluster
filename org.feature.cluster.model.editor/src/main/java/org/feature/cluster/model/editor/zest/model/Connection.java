package org.feature.cluster.model.editor.zest.model;

/**
 * This class represents a connection between two {@link Node}.
 * @author Tim Winkelmann
 *
 */
public class Connection {
	private Node sourceNode;
	private Node targetNode;
	
	/**
	 * creates a connection between two node.
	 * @param src the source {@link Node}.
	 * @param target the target {@link Node}.
	 */
	public Connection(Node src, Node target) {
		this.sourceNode = src;
		this.targetNode = target;
	}
	
	/**
	 * No Label required.
	 * @return
	 */
	public String getLabel() {
		return "";
	}

	/**
	 * @return the sourceNode
	 */
	public Node getSourceNode() {
		return sourceNode;
	}

	/**
	 * @return the targetNode
	 */
	public Node getTargetNode() {
		return targetNode;
	}
}

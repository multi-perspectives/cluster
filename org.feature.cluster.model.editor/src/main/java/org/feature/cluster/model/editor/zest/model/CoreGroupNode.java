/**
 * 
 */
package org.feature.cluster.model.editor.zest.model;

import org.feature.cluster.model.cluster.CoreGroup;

/**
 * This class represents the {@link CoreGroup} node
 * @author winkelti
 *
 */
public class CoreGroupNode extends Node {
	private CoreGroup coreGroup;
	
	/**
	 * @param coreGroup
	 */
	public CoreGroupNode(CoreGroup coreGroup) {
		super();
		this.coreGroup = coreGroup;
	}

	/* (non-Javadoc)
	 * @see org.feature.cluster.model.editor.zest.model.Node#getName()
	 */
	@Override
	public String getName() {
		return "CoreGroup";
	}

	/**
	 * @return the defaultGroup
	 */
	public CoreGroup getCoreGroup() {
		return coreGroup;
	}
}

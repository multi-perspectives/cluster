/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.model.constraint.resource.csl.mopp;

/**
 * This class contains some constants that are used during code completion.
 */
public class CslExpectationConstants {
	
	public final static int EXPECTATIONS[][] = new int[6][];
	
	public static void initialize0() {
		EXPECTATIONS[0] = new int[3];
		EXPECTATIONS[0][0] = 0;
		EXPECTATIONS[0][1] = 0;
		EXPECTATIONS[0][2] = 0;
		EXPECTATIONS[1] = new int[3];
		EXPECTATIONS[1][0] = 1;
		EXPECTATIONS[1][1] = 0;
		EXPECTATIONS[1][2] = 1;
		EXPECTATIONS[2] = new int[2];
		EXPECTATIONS[2][0] = 2;
		EXPECTATIONS[2][1] = 2;
		EXPECTATIONS[3] = new int[2];
		EXPECTATIONS[3][0] = 3;
		EXPECTATIONS[3][1] = 3;
		EXPECTATIONS[4] = new int[2];
		EXPECTATIONS[4][0] = 4;
		EXPECTATIONS[4][1] = 5;
		EXPECTATIONS[5] = new int[2];
		EXPECTATIONS[5][0] = 5;
		EXPECTATIONS[5][1] = 6;
	}
	
	public static void initialize() {
		initialize0();
	}
	
	static {
		initialize();
	}
	
}

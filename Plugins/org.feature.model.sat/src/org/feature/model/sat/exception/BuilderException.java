package org.feature.model.sat.exception;

/**
 * exception to handle problems during the build process
 * 
 * @author Ingo Reimund
 * @create 12.03.2012
 */
public class BuilderException extends RuntimeException {

	/**
	 * serial
	 */
	private static final long serialVersionUID = 6354925615258490710L;

	/**
	 * initialize the exception with message and a exception which cause the
	 * this exception
	 * 
	 * @param message
	 *            message of the exception
	 * @param throwable
	 *            throwable which occurs this exception
	 */
	public BuilderException(String message, Throwable e) {
		super(message, e);
	}
	
	/**
	 * initialize the exception with message
	 * 
	 * @param message
	 *            message of the exception
	 */
	public BuilderException(String message) {
		super(message);
	}
}
package org.feature.model.sat.exception;

/**
 * exception for unknown statements of pure::variants
 * 
 * @author Ingo Reimund
 * @create 06.03.2012
 */
public class UnknownStatementException extends Exception {

	/**
	 * serial
	 */
	private static final long serialVersionUID = 493568501918210337L;

	/**
	 * initialize the exception with message and a exception which cause the
	 * this exception
	 * 
	 * @param message
	 *            message of the exception
	 */
	public UnknownStatementException(String message) {
		super(message);
	}

	/**
	 * initialize the exception with message and a exception which cause the
	 * this exception
	 * 
	 * @param message
	 *            message of the exception
	 * @param throwable
	 *            throwable which occurs this exception
	 */
	public UnknownStatementException(String message, Throwable throwable) {
		super(message, throwable);
	}
}
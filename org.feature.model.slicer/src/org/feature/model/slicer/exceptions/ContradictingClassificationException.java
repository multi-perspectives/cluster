package org.feature.model.slicer.exceptions;

public class ContradictingClassificationException extends RuntimeException {

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
	public ContradictingClassificationException(String message, Throwable e) {
		super(message, e);
	}
	
	/**
	 * initialize the exception with message
	 * 
	 * @param message
	 *            message of the exception
	 */
	public ContradictingClassificationException(String message) {
		super(message);
	}
}

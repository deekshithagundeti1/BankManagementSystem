package com.bms.customer.exception;

/**
 * @author javacloudmc446
 *
 */
public class CustomerInsertionFailedException extends RuntimeException {

	private static final long serialVersionUID = 1L;


	/**Customer Insertion Failed Exception method
	 * 
	 * @param message
	 */
	public CustomerInsertionFailedException(String message) {
		super(message);
	}

}

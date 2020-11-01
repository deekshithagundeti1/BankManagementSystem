package com.bms.customer.exception;

/**
 * @author javacloudmc446
 *
 */
public class CustomerNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;


	/**Customer not found exception method
	 * 
	 * @param message
	 */
	public CustomerNotFoundException(String message) {
		super(message);
	}

}

package com.bms.loan.exception;

/**
 * @author javacloudmc446
 *
 */
public class LoanInsertionFailedException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	/**
	 * Loan Insertion Failed Exception Method
	 * 
	 * @param message
	 */
	public LoanInsertionFailedException(String message) {
		super(message);
	}

}

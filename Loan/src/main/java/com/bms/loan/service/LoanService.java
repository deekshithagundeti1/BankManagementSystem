package com.bms.loan.service;

import com.bms.customer.model.Loan;



/**
 * @author javacloudmc446
 *
 */
public interface LoanService {

	/**Applying loan
	 * 
	 * @param loan
	 * @return
	 */
	public Loan applyLoan( Loan loan);

}

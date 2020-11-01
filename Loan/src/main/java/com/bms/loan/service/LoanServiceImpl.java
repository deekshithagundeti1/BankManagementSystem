package com.bms.loan.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bms.loan.exception.LoanInsertionFailedException;
import com.bms.customer.model.Loan;
import com.bms.loan.repository.LoanRepository;

/**
 * @author javacloudmc446
 *
 */
@Service
public class LoanServiceImpl implements LoanService {

	
	@Autowired
	LoanRepository loanRepository;
	
	public static final Logger logger = LoggerFactory.getLogger(LoanServiceImpl.class);
	
	/**Applying loan
	 * 
	 * @param loan
	 * @return
	 */
	@Override
	public Loan applyLoan(Loan loan) {
		logger.info("Saving Loan details in Db");
		Loan loan1 =loanRepository.save(loan);
		if (loan1 == null)
			throw new LoanInsertionFailedException("Loan application Failed.Check your details");
		else
			return loan1;
	}

}

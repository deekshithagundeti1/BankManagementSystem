package com.bms.loan.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bms.customer.model.Loan;
import com.bms.customer.response.CustomResponse;
import com.bms.loan.service.LoanService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;


/**
 * @author javacloudmc446
 *
 */
@RestController
@RequestMapping("/v1/loan")
public class LoanController {
	
	@Autowired
	LoanService loanService;
	
	public static final Logger logger = LoggerFactory.getLogger(LoanController.class);
	
	/**Controller for applyLoan
	 * 
	 * @param loan
	 * @return
	 */
	@HystrixCommand(fallbackMethod="circuitBreaker")
	@PostMapping(path = "")
	public ResponseEntity<CustomResponse> applyLoan(@RequestBody Loan loan) {
		logger.info("Received Loan details to insert in Db");
		return new ResponseEntity<>(new CustomResponse(HttpStatus.CREATED.value(),
				"Loan successfully applied",loanService.applyLoan(loan)),HttpStatus.CREATED);
	}
	
	public ResponseEntity<CustomResponse> circuitBreaker(@RequestBody Loan loan)
	{
		return new ResponseEntity<>(new CustomResponse(HttpStatus.GATEWAY_TIMEOUT.value(),"Timeout",null), HttpStatus.GATEWAY_TIMEOUT);
	}

}

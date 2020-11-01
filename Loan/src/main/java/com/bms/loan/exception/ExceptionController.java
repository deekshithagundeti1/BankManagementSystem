package com.bms.loan.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.bms.customer.response.CustomResponse;

/**
 * @author javacloudmc446
 *
 */
@ControllerAdvice
public class ExceptionController {
	
	/**Controller for Loan InsertionFailedException
	 * 
	 * @param exception
	 * @return
	 */
   @ExceptionHandler(value = LoanInsertionFailedException.class)
   public ResponseEntity<CustomResponse> loanInsertionFailedException(LoanInsertionFailedException exception) {
      return new ResponseEntity<>(new CustomResponse(HttpStatus.NOT_FOUND.value(), 
				exception.getMessage(),null), HttpStatus.NOT_FOUND);
   }
}
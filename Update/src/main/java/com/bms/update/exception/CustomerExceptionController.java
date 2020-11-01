package com.bms.update.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.bms.customer.exception.CustomerInsertionFailedException;
import com.bms.customer.response.CustomResponse;

/**
 * @author javacloudmc446
 *
 */
@ControllerAdvice
public class CustomerExceptionController {
   
	/** Controller for Customer insertion failed exception
	 * @param exception
	 * @return
	 */
   @ExceptionHandler(value = CustomerInsertionFailedException.class)
   public ResponseEntity<CustomResponse> customerInsertionFailedException(CustomerInsertionFailedException exception) {
      return new ResponseEntity<>(new CustomResponse(HttpStatus.NOT_FOUND.value(), 
				exception.getMessage(),null), HttpStatus.NOT_FOUND);
   }
}
package com.bms.customer.exception;

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
	
	/**Controller for CustomerNotFoundException
	 * 
	 * @param exception
	 * @return
	 */
   @ExceptionHandler(value = CustomerNotFoundException.class)
   public ResponseEntity<CustomResponse> customerNotfoundException(CustomerNotFoundException exception) {
      return new ResponseEntity<>(new CustomResponse(HttpStatus.NOT_FOUND.value(), 
				exception.getMessage(),null), HttpStatus.NOT_FOUND);
   }
   
   @ExceptionHandler(value = CustomerInsertionFailedException.class)
   public ResponseEntity<CustomResponse> customerInsertionFailedException(CustomerInsertionFailedException exception) {
      return new ResponseEntity<>(new CustomResponse(HttpStatus.NOT_FOUND.value(), 
				exception.getMessage(),null), HttpStatus.NOT_FOUND);
   }
   
}
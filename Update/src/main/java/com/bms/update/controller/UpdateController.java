package com.bms.update.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bms.customer.model.Customer;
import com.bms.customer.response.CustomResponse;
import com.bms.update.service.UpdateService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/**
 * @author javacloudmc446
 *
 */
@RestController
@RequestMapping("/v1/update")
public class UpdateController {

	@Autowired
	UpdateService updateService;

	public static final Logger logger = LoggerFactory.getLogger(UpdateController.class);

	/**Updating Customer Details
	 * 
	 * @param customer
	 * @return
	 */
	@HystrixCommand(fallbackMethod="circuitBreaker")
	@PutMapping(path = "")
	public ResponseEntity<CustomResponse> updateCustomer(@RequestBody Customer customer) {
		logger.info("Received Customer details to update in Db");
		return new ResponseEntity<>(new CustomResponse(HttpStatus.CREATED.value(),
				"Customer successfully updated",updateService.updateCustomer(customer)),HttpStatus.CREATED);	

	}
	
	/**Breaker for updateCustomer
	 * 
	 * @param customer
	 * @return
	 */
	public ResponseEntity<CustomResponse> circuitBreaker(@RequestBody Customer customer)
	{
		return new ResponseEntity<>(new CustomResponse(HttpStatus.GATEWAY_TIMEOUT.value(),"Timeout",null), HttpStatus.GATEWAY_TIMEOUT);
	}

}

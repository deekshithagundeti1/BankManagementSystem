package com.bms.customer.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bms.customer.model.Customer;
import com.bms.customer.model.Login;
import com.bms.customer.response.CustomResponse;
import com.bms.customer.service.CustomerService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
/**
 * @author javacloudmc446
 *
 */
@RestController
@RequestMapping("/v1/customer")
public class CustomerController {

	@Autowired
	CustomerService customerService;

	public static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

	/**Controller for creating customer
	 * 
	 * @param customer
	 * @return
	 */
	@HystrixCommand(fallbackMethod="circuitBreaker1")
	@PostMapping(path = "")
	public ResponseEntity<CustomResponse> createCustomer(@RequestBody Customer customer) {
		logger.info("Received Customer details to insert in Db");
		return new ResponseEntity<>(new CustomResponse(HttpStatus.CREATED.value(),
				"Customer successfully created",customerService.addCustomer(customer)),HttpStatus.CREATED);	
	}

	/**Controller for customer login
	 * 
	 * @param login
	 * @return
	 */
	@PostMapping(path = "/login")
	public ResponseEntity<CustomResponse> loginCustomer(@RequestBody Login login) {
		Customer cust = customerService.getCustomerByuserName(login.getUserName());
		logger.info("Received Username and password for login");	
		if (cust.getPassword().contentEquals(login.getPassword())) {
			logger.info("Login Successful");
			return new ResponseEntity<>(new CustomResponse(HttpStatus.OK.value(),"Login Successful",cust), HttpStatus.OK);
		} else {
			logger.info("Login Failure");
			return new ResponseEntity<>(new CustomResponse(HttpStatus.NOT_FOUND.value(),"Login Failure",null), HttpStatus.NOT_FOUND);
		}
	}
	
	/**Controller to get customer by id
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping(path = "/{id}")
	public ResponseEntity<CustomResponse> getCustomerById(@PathVariable Long id) {
		logger.info("Received id to fetch customer");
		return new ResponseEntity<>(new CustomResponse(HttpStatus.OK.value(),
				"Customers Retrieved Successfully",customerService.getCustomerById(id)),HttpStatus.OK);
	}

	/**Controller to get all customers
	 * 
	 * @return
	 */
	@GetMapping(path = "")
	public ResponseEntity<CustomResponse> getAllCustomers() {
		logger.info("Received id to fetch customer");
		return new ResponseEntity<>(new CustomResponse(HttpStatus.OK.value(),
				"Customers Retrieved Successfully",customerService.getAllCustomers()),HttpStatus.OK);
	}
	

	/**Circuit breaker for createCustomer
	 * 
	 * @param customer
	 * @return
	 */
	public ResponseEntity<CustomResponse> circuitBreaker1(@RequestBody Customer customer)
	{
		return new ResponseEntity<>(new CustomResponse(HttpStatus.GATEWAY_TIMEOUT.value(),"Timeout",null), HttpStatus.GATEWAY_TIMEOUT);
	}
	

}

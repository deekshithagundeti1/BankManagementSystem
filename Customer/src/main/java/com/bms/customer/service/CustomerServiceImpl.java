package com.bms.customer.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bms.customer.exception.CustomerInsertionFailedException;
import com.bms.customer.exception.CustomerNotFoundException;
import com.bms.customer.model.Customer;
import com.bms.customer.repository.CustomerRepository;

/**
 * @author javacloudmc446
 *
 */
@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;

	public static final Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);

	/**Adding customer
	 * 
	 * @param customer
	 * @return
	 */
	@Override
	public Customer addCustomer(Customer customer) {
		logger.info("Saving Customer details in Db");

		Customer cust = customerRepository.save(customer);
		if (cust == null)
		{
			throw new CustomerInsertionFailedException("Registration Failed.Check your details");
		}
		return cust;
	}

	/**Retrieving customer by username
	 * 
	 * @param userName
	 * @return
	 */
	@Override
	public Customer getCustomerByuserName(String userName) {
		logger.info("Getting Customer details by Username");
		Customer customer = customerRepository.findByUserName(userName);
		if (customer == null)
			throw new CustomerNotFoundException(userName + ": Invalid User Name");
		else
			return customer;
	}

	/**Retrieving customer by id
	 * 
	 * @param id
	 * @return
	 */
	@Override
	public Optional<Customer> getCustomerById(Long id) {
		logger.info("Retrieving Customer details by Id");
		Optional<Customer> customer = customerRepository.findById(id);
		if (customer.isEmpty())
			throw new CustomerNotFoundException(id + ": Invalid customer Id");
		else
			return customer;
	}

	/**Retrieving all customers
	 * 
	 * @return
	 */
	@Override
	public List<Customer> getAllCustomers() {
		logger.info("Retrieving all Customer details from Db");
		List<Customer> cust = customerRepository.findAll();
		logger.info("Retrieved all Customer details from Db");
		return cust;
	}

}

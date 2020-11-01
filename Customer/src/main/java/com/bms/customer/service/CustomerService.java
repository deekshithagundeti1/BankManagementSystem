package com.bms.customer.service;

import java.util.List;
import java.util.Optional;

import com.bms.customer.model.Customer;

/**
 * @author javacloudmc446
 *
 */
public interface CustomerService {

	/**Adding customer
	 * 
	 * @param customer
	 * @return
	 */
	public Customer addCustomer(Customer customer);

	/**Retrieving customer by username
	 * 
	 * @param userName
	 * @return
	 */
	public Customer getCustomerByuserName(String userName);

	/**Retrieving customer by id
	 * 
	 * @param id
	 * @return
	 */
	public Optional<Customer> getCustomerById(Long id);

	/**Retrieving all customers
	 * 
	 * @return
	 */
	public List<Customer> getAllCustomers();


}

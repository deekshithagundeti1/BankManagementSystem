package com.bms.update.service;

import com.bms.customer.model.Customer;

/**
 * @author javacloudmc446
 *
 */
public interface UpdateService {
	/**
	 * Updating customer details
	 * 
	 * @param customer
	 * @return
	 */
	Customer updateCustomer(Customer customer);

}

package com.bms.update.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bms.customer.exception.CustomerInsertionFailedException;
import com.bms.customer.model.Customer;
import com.bms.update.repository.UpdateRepository;

/**
 * @author javacloudmc446
 *
 */
@Service
public class UpdateServiceImpl implements UpdateService {

	@Autowired
	UpdateRepository updateRepository;

	public static final Logger logger = LoggerFactory.getLogger(UpdateServiceImpl.class);

	/**
	 * Updating customer details
	 * 
	 * @param customer
	 * @return
	 */
	@Override
	public Customer updateCustomer(Customer customer) {
		logger.info("Updating Customer details in Db");
		Customer cust = updateRepository.save(customer);
		if (cust == null)
			throw new CustomerInsertionFailedException("Updation Failed.Check your details");
		else
			return cust;
	}

}

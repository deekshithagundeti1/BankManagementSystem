package com.bms.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bms.customer.model.Customer;

/**
 * @author javacloudmc446
 *
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {
	
	Customer findByUserName(String userName);

}
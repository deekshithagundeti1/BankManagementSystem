package com.bms.update.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bms.customer.model.Customer;


/**
 * @author javacloudmc446
 *
 */
public interface UpdateRepository extends JpaRepository<Customer, Long> {


}

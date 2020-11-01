package com.bms.loan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bms.customer.model.Loan;


/**
 * @author javacloudmc446
 *
 */
public interface LoanRepository extends JpaRepository<Loan, Long> {

}

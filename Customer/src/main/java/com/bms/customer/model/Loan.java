package com.bms.customer.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * @author javacloudmc446
 *
 */
@Entity
@Table(name = "loan")
public class Loan implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long loanId;

	private String loanType;
	private long loanAmount;
	private String date;	
	private String rateOfInterest;
	private String durationOfLoan;

	@ManyToOne
	@JoinColumn(name = "cust_id")
	private Customer customer;

	public long getLoanId() {
		return loanId;
	}

	public void setLoanId(long loanId) {
		this.loanId = loanId;
	}

	public String getLoanType() {
		return loanType;
	}

	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}

	public long getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(long loanAmount) {
		this.loanAmount = loanAmount;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getRateOfInterest() {
		return rateOfInterest;
	}

	public void setRateOfInterest(String rateOfInterest) {
		this.rateOfInterest = rateOfInterest;
	}

	public String getDurationOfLoan() {
		return durationOfLoan;
	}

	public void setDurationOfLoan(String durationOfLoan) {
		this.durationOfLoan = durationOfLoan;
	}

	@JsonBackReference
	public Customer getCustomer() {
		return customer;
	}
	
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Loan(Customer customer,String loanType, long loanAmount, String date, String rateOfInterest, String durationOfLoan
			) {
		super();
		this.loanType = loanType;
		this.loanAmount = loanAmount;
		this.date = date;
		this.rateOfInterest = rateOfInterest;
		this.durationOfLoan = durationOfLoan;
		this.customer = customer;
	}
	public Loan() {}

}

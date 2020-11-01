package com.bms.customer.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * @author javacloudmc446
 *
 */
@Entity
@Table(name = "customer")
public class Customer implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long custId;

	private String name;

	private String userName;

	private String password;

	private String address;

	private String state;

	private String country;

	private String emailAddress;

	private String pan;

	private String contactNo;

	private String dob;

	private String accountType;

	private long accountNum = RandomNumberGenerator.random();

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "customer", cascade = CascadeType.ALL)
	private List<Loan> loans;

	public long getCustId() {
		return custId;
	}

	public void setCustId(long custId) {
		this.custId = custId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public long getAccountNum() {
		return accountNum;
	}

	public void setAccountNum(long accountNum) {
		this.accountNum = accountNum;
	}

	@JsonManagedReference
	public List<Loan> getLoans() {
		return loans;
	}

	public void setLoans(List<Loan> loans) {
		this.loans = loans;
	}

	public Customer() {
	}


	public Customer(long custId, String name, String userName, String password, String address, String state,
			String country, String emailAddress, String pan, String contactNo, String dob, String accountType,
			long accountNum) {
		super();
		this.custId = custId;
		this.name = name;
		this.userName = userName;
		this.password = password;
		this.address = address;
		this.state = state;
		this.country = country;
		this.emailAddress = emailAddress;
		this.pan = pan;
		this.contactNo = contactNo;
		this.dob = dob;
		this.accountType = accountType;
		this.accountNum = accountNum;
	}

	public Customer(long custId) {
		this.custId=custId;
	}

	public Customer(long custId, String name, String userName, String password, String address, String state,
			String country, String emailAddress, String pan, String contactNo, String dob, String accountType,
			long accountNum, List<Loan> loans) {
		super();
		this.custId = custId;
		this.name = name;
		this.userName = userName;
		this.password = password;
		this.address = address;
		this.state = state;
		this.country = country;
		this.emailAddress = emailAddress;
		this.pan = pan;
		this.contactNo = contactNo;
		this.dob = dob;
		this.accountType = accountType;
		this.accountNum = accountNum;
		this.loans = loans;
	}

	

}

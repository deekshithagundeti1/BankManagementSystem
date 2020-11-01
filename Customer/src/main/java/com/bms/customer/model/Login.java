package com.bms.customer.model;

/**
 * @author javacloudmc446
 *
 */
public class Login {
	

	private String userName;
	private String password;

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
	
	public Login(){}

	public Login(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}


}

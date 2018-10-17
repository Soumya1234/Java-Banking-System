package com.bankingsystem.entities;

import java.util.ArrayList;

import com.bankingsystem.constants.UserType;

/**
 * Entity class representing customers in the Banking System
 * 
 * @author Soumyadeep Ganguly
 *
 */

public class Customer extends User {
	private ArrayList<String> accounts;

	public Customer(UserCredential credential, String fName, String lName, String email, String mobile) {
		super.setCredential(credential);
		super.setFirstName(fName);
		super.setLastName(lName);
		super.setEmail(email);
		super.setMobile(mobile);
		this.accounts = new ArrayList<String>();
		this.setUserType();
	}

	public ArrayList<String> getAccounts() {
		return accounts;
	}

	public void addAccount(String accountId) {
		accounts.add(accountId);
	}

	@Override
	final void setUserType() {
		userType = UserType.CUSTOMER;
	}

}

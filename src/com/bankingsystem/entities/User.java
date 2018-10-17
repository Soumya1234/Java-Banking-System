package com.bankingsystem.entities;

import com.bankingsystem.constants.UserType;

/**
 * Abstract Entity class for different types of Users of the Banking System
 * 
 * @author Soumyadeep Ganguly
 *
 */
public abstract class User {
	private UserCredential credential;
	private String firstName;
	private String lastName;
	private String email;
	private String mobile;
	protected UserType userType;

	public UserCredential getCredential()
	{
		return credential;
	}
	
	public void setCredential(UserCredential credential)
	{
		this.credential=credential;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public UserType getUserType() {
		return userType;
	}

     abstract void setUserType();
}

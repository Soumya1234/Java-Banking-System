package com.bankingsystem.constants;

/**
 * Defines the various types of Users in the Banking System
 * 
 * @author Soumyadeep Ganguly
 */
public enum UserType {
	ADMIN("Administrator"), CUSTOMER("Customer");

	private String description;

	private UserType(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return this.description;
	}
}

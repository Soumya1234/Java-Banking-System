package com.bankingsystem.constants;

/**
 * Defines the various types of Accounts in the Banking System
 * 
 * @author Soumyadeep Ganguly
 */
public enum AccountType {
	SAVINGS_ACCOUNT("SV A/C"), RECURRING_DEPOSIT_ACCOUNT("RD A/C"), FIXED_DEPOSIT_ACCOUNT("FD A/C"),
	PPF_ACCOUNT("PPF A/C");
	
	private String description;

	private AccountType(String description) {
		this.description = description;

	}

	@Override
	public String toString() {
		return this.description;
	}

}

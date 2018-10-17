package com.bankingsystem.constants;

/**
 * Defines the various types of Transactions in the Banking System
 * 
 * @author Soumyadeep Ganguly
 *
 */
public enum TransactionType {
	DEBIT("Withdrawl"), CREDIT("Deposit"), MONEY_TRANSFER("Transfer");

	private String description;

	private TransactionType(String description) {
		this.description = description;

	}

	@Override
	public String toString() {
		return this.description;
	}
}

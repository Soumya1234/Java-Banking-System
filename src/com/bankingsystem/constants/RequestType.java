package com.bankingsystem.constants;

/**
 * Defines the various types of Requests forwarded by the Customer to
 * Administrator
 * 
 * @author Soumyadeep Ganguly
 *
 */
public enum RequestType {
	NEW_CUSTOMER_REGISTRATION("New Customer Reg."), OPEN_ACCOUNT_REQUEST("Open A/C Req."),
	CLOSE_ACCOUNT_REQUEST("Close A/C Req."), LOAN_APPROVAL_REQUEST("Loan Appr. Req."),
	MONEY_TRANSFER_REQUEST("Money Trnf. Req.");
	private String description;

	private RequestType(String description) {
		this.description = description;

	}

	@Override
	public String toString() {
		return this.description;
	}

}

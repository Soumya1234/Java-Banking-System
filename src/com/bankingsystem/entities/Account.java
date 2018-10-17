package com.bankingsystem.entities;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;

import com.bankingsystem.constants.AccountType;

/**
 * Abstract Entity class for different types of Accounts in the Banking System
 * 
 * @author Soumyadeep Ganguly
 *
 */

public abstract class Account {
	private String accountId;
	private String accountNo;
	private BigDecimal balance;
	private ArrayList<String> customers=new ArrayList<String>();
	private LocalDate openingDate;
	private BigDecimal interest_rate;
	protected AccountType accountType;

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public LocalDate getOpeningDate() {
		return openingDate;
	}

	public void setOpeningDate(LocalDate openingDate) {
		this.openingDate = openingDate;
	}

	public BigDecimal getInterest_rate() {
		return interest_rate;
	}

	public void setInterest_rate(BigDecimal interest_rate) {
		this.interest_rate = interest_rate;
	}

	public AccountType getAccountType() {
		return accountType;
	}
	
	void setBalance(BigDecimal amount)
	{
		balance=amount;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public ArrayList<String> getCustomers() {
		return customers;
	}

	public void addCustomer(String customerId) {
		customers.add(customerId);
	}

	abstract void setAccountType();

	/**
	 * Abstract Method for performing debit from the Account Balance.This method is
	 * to be implemented by all subclasses with own debit business logic
	 * 
	 * @param amount
	 * @throws Exception 
	 */
	public abstract void debit(BigDecimal amount) throws Exception;

	/**
	 * Abstract Method for performing credit to the Account Balance.This method is
	 * to be implemented by all subclasses with own credit business logic
	 * 
	 * @param amount
	 */
	public abstract void credit(BigDecimal amount);

	/**
	 * Abstract Method for calculating Interest on the Account Balance.This method
	 * is to be implemented by all subclasses with own business logic for Interest
	 * calculation
	 * 
	 * @return interest rate of type BigDecimal
	 */
	public abstract BigDecimal getCalculatedInterest();

	/**Abstract Method for accruing Interest on the Account Balance.This method 
	 * is to be implemented by all subclasses with own business logic for Interest
	 * accrual
	 * 
	 */
	public abstract void addInterest();

}

package com.bankingsystem.entities;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

import com.bankingsystem.constants.AccountType;

public class SavingsAccount extends Account{
	
	public SavingsAccount(BigDecimal interest_rate,Customer customer,String accountNo)
	{
		this.setInterest_rate(interest_rate);
		this.setAccountType();
		this.setAccountId(UUID.randomUUID().toString());
		this.setAccountNo(accountNo);
		this.setOpeningDate(LocalDate.now());
		this.addCustomer(customer.getCredential().getuserId());
		customer.addAccount(this.getAccountId());
		super.setBalance(new BigDecimal(0));
	}
	@Override
     void setAccountType() {
		accountType=AccountType.SAVINGS_ACCOUNT;
	}

	@Override
	public void debit(BigDecimal amount) throws Exception{
		if(super.getBalance().compareTo(amount)>0)
			super.setBalance(super.getBalance().subtract(amount));
		else 
			throw new Exception("Balance Insufficient!!");
	}

	@Override
	public void credit(BigDecimal amount) {
		super.setBalance(super.getBalance().add(amount));
	}

	@Override
	public BigDecimal getCalculatedInterest() {
		return super.getBalance().multiply(this.getInterest_rate());
	}

	@Override
	public void addInterest() {
		super.setBalance(super.getBalance().add(this.getCalculatedInterest()));
		
	}

}

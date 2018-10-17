package com.bankingsystem.entities;

import java.math.BigDecimal;
import java.time.*;

import com.bankingsystem.constants.TransactionType;

/**
 * Entity class for different Transactions that User make in the Banking System
 * 
 * @author Soumyadeep Ganguly
 *
 */

public class Transaction {
	private Account account;
	private LocalDate tDate;
	private LocalTime tTime;
	private TransactionType tType;
	private BigDecimal tAmount;

	public Transaction(Account account, LocalDate tDate, LocalTime tTime, TransactionType tType, BigDecimal tAmount) {
		this.account = account;
		this.tDate = tDate;
		this.tTime = tTime;
		this.tType = tType;
		this.tAmount = tAmount;
	}

	public Account getAccount() {
		return account;
	}

	public LocalDate gettDate() {
		return tDate;
	}

	public LocalTime gettTime() {
		return tTime;
	}

	public TransactionType gettType() {
		return tType;
	}

	public BigDecimal gettAmount() {
		return tAmount;
	}

	@Override
	public String toString() {
		return ("\nDate:" + tDate + " Time:" + tTime + " Amount:" + tAmount + " Type:" + tType+" Balance:"+account.getBalance());
	}

}

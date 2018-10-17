package com.bankingsystem.managers;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

import com.bankingsystem.constants.*;
import com.bankingsystem.dao.*;
import com.bankingsystem.database.DataStore;
import com.bankingsystem.entities.*;

public class CustomerManager {
	private static CustomerManager instance = null;
	DataStore database;

	private CustomerManager() {
	}

	public static CustomerManager getInstance() {
		if (instance == null) {
			instance = new CustomerManager();
		}
		return instance;
	}

	public void setDataConnectionObject(DataStore database) {
		this.database = database;
	}

	public void submitNewAccountRequest() {

	}

	public void depositMoney(String amount, String accountNo) {
		IAccountDAO accountdao = new AccountDAO(database);
		ITransactionDAO tDAO = new TransactionDAO(database);
		accountdao.getAccount(accountdao.mapNoToId(accountNo)).credit(new BigDecimal(amount));
		tDAO.commitTransaction(new Transaction(accountdao.getAccount(accountdao.mapNoToId(accountNo)), LocalDate.now(),
				LocalTime.now(), TransactionType.CREDIT, new BigDecimal(amount)));

	}

	public void withdrawMoney(String amount, String accountNo) throws Exception{
		IAccountDAO accountdao = new AccountDAO(database);
		ITransactionDAO tDAO = new TransactionDAO(database);
		accountdao.getAccount(accountdao.mapNoToId(accountNo)).debit(new BigDecimal(amount));
		tDAO.commitTransaction(new Transaction(accountdao.getAccount(accountdao.mapNoToId(accountNo)), LocalDate.now(),
				LocalTime.now(), TransactionType.DEBIT, new BigDecimal(amount)));
	}

	public void transferMoney(String sourceAccountNo, String targetAccountNo, BigDecimal amount) {

	}

	public void modifyPasword(String oldPassword, String newPassword) {

	}

	public void modifyEmail(String newEmail) {

	}

	public void modifyMobileNo(String newMobile) {

	}

	public void submitAccountClosingRequest(String accountNo) {

	}

	public void submitLoanRequest(BigDecimal amount) {

	}

	public void login(String userId, String password) {

	}

	public void logout() {

	}

	private void submitMoneyTransferOverLimitRequest() {

	}
}

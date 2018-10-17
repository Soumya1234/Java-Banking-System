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
	User currentUser = null;
	boolean isLoggedIn = false;

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
		if (isLoggedIn) {
			IAccountDAO accountdao = new AccountDAO(database);
			ITransactionDAO tDAO = new TransactionDAO(database);
			accountdao.getAccount(accountdao.mapNoToId(accountNo)).credit(new BigDecimal(amount));
			tDAO.commitTransaction(new Transaction(accountdao.getAccount(accountdao.mapNoToId(accountNo)),
					LocalDate.now(), LocalTime.now(), TransactionType.CREDIT, new BigDecimal(amount)));
		}

	}

	public void withdrawMoney(String amount, String accountNo) throws Exception {
		if (isLoggedIn) {
			IAccountDAO accountdao = new AccountDAO(database);
			ITransactionDAO tDAO = new TransactionDAO(database);
			accountdao.getAccount(accountdao.mapNoToId(accountNo)).debit(new BigDecimal(amount));
			tDAO.commitTransaction(new Transaction(accountdao.getAccount(accountdao.mapNoToId(accountNo)),
					LocalDate.now(), LocalTime.now(), TransactionType.DEBIT, new BigDecimal(amount)));
		}
	}

	public void transferMoney(String sourceAccountNo, String targetAccountNo, String amount) throws Exception {
		if (isLoggedIn) {
			IAccountDAO accountdao = new AccountDAO(database);
			ITransactionDAO tDAO = new TransactionDAO(database);
			accountdao.getAccount(accountdao.mapNoToId(sourceAccountNo)).debit(new BigDecimal(amount));
			tDAO.commitTransaction(new Transaction(accountdao.getAccount(accountdao.mapNoToId(sourceAccountNo)),
					LocalDate.now(), LocalTime.now(), TransactionType.MONEY_TRANSFER, new BigDecimal(amount)));
			accountdao.getAccount(accountdao.mapNoToId(targetAccountNo)).credit(new BigDecimal(amount));
			tDAO.commitTransaction(new Transaction(accountdao.getAccount(accountdao.mapNoToId(sourceAccountNo)),
					LocalDate.now(), LocalTime.now(), TransactionType.MONEY_TRANSFER, new BigDecimal(amount)));
		}
	}

	public void modifyPasword(String oldPassword, String newPassword) {
		if(currentUser.getCredential().getPassword().equals(oldPassword)) {
			IUserDAO userDAO = new UserDAO(database);
			currentUser.setCredential(new UserCredential(currentUser.getCredential().getuserId(),newPassword));
			userDAO.updateUserDetails(currentUser);
		}
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
		IUserDAO userDAO = new UserDAO(database);
		if (userDAO.getUser(new UserCredential(userId, password)) != null) {
			currentUser = userDAO.getUser(new UserCredential(userId, password));
			isLoggedIn = true;
		}
	}

	public void logout() {
		isLoggedIn =false;
	}

	private void submitMoneyTransferOverLimitRequest() {

	}
}

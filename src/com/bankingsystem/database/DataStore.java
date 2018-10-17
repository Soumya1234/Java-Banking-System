package com.bankingsystem.database;

import java.util.ArrayList;

import com.bankingsystem.entities.*;

public final class DataStore {

	private static DataStore instance = null;

	private DataStore() {
		userTable = new ArrayList<User>();
		accountTable = new ArrayList<Account>();
		transactionTable = new ArrayList<Transaction>();
		requestTable = new ArrayList<Request>();
	}

	public static DataStore getInstance() {
		if (instance == null) {
			instance = new DataStore();
		}
		return instance;
	}

	private ArrayList<User> userTable;
	private ArrayList<Account> accountTable;
	private ArrayList<Transaction> transactionTable;
	private ArrayList<Request> requestTable;

	public ArrayList<User> getUserTable() {
		return userTable;
	}

	public ArrayList<Account> getAccountTable() {
		return accountTable;
	}

	public ArrayList<Transaction> getTransactionTable() {
		return transactionTable;
	}

	public ArrayList<Request> getRequestTable() {
		return requestTable;
	}

	public void insertIntoUser(User user) {
		userTable.add(user);
	}

	public void insertIntoAccount(Account account) {
		accountTable.add(account);
	}

	public void insertIntoTransaction(Transaction trasaction) {
		transactionTable.add(trasaction);
	}

	public void insertIntoRequest(Request request) {
		requestTable.add(request);
	}
}

package com.bankingsystem.dao;

import java.util.ArrayList;

import com.bankingsystem.database.DataStore;
import com.bankingsystem.entities.Account;

/**
 * The Data Access Object class for Account Entity
 * 
 * @author Soumyadeep Ganguly
 *
 */
public class AccountDAO implements IAccountDAO {
	private DataStore database;

	public AccountDAO(DataStore datastore) {
		this.database = datastore;
	}

	/*
	 * Returns the Account object corresponding to the given accountId 
	 * If no account is found it returns null
	 * 
	 * @see com.bankingsystem.dao.IAccountDAO#getAccount(java.lang.String)
	 */
	@Override
	public Account getAccount(String accountId) {
		ArrayList<Account> accounts = database.getAccountTable();
		Account[] accountArray = new Account[accounts.size()];
		for (Account account : accounts.toArray(accountArray)) {
			if (account.getAccountId().equals(accountId))
				return account;
		}
		return null;
	}

	/*
	 * Returns the accountId corresponding to the given accountNo. Useful because
	 * the client code will most usually be using the accountNo for all transactions
	 * 
	 * @see com.bankingsystem.dao.IAccountDAO#mapNoToId(java.lang.String)
	 */
	@Override
	public String mapNoToId(String accountNo) {
		ArrayList<Account> accounts = database.getAccountTable();
		Account[] accountArray = new Account[accounts.size()];
		for (Account account : accounts.toArray(accountArray)) {
			if (account.getAccountNo().equals(accountNo))
				return account.getAccountId();
		}
		return null;
	}

	/*
	 * Adds an account to the Database. It first queries the database to see if
	 * there is any existing account with the given accountId If no such account
	 * exists it then creates the account and returns true else returns false
	 * 
	 * NEEDS MODIFICATION OF LOGIC
	 * 
	 * @see com.bankingsystem.dao.IAccountDAO#addAccount(com.bankingsystem.entities.
	 * Account)
	 */
	@Override
	public boolean addAccount(Account account) {
		if (getAccount(account.getAccountId()) != null) {
			return false;
		}
		database.insertIntoAccount(account);
		return true;
	}

	/*
	 * Updates an existing account by replacing it with the given account object.If
	 * no such account is found it returns false else it returns true
	 * 
	 * @see
	 * com.bankingsystem.dao.IAccountDAO#updateAccount(com.bankingsystem.entities.
	 * Account)
	 */
	@Override
	public boolean updateAccount(Account account) {
		Account accountInDataBase = getAccount(account.getAccountId());
		if (accountInDataBase != null) {
			int indexOfAccount = database.getAccountTable().indexOf(accountInDataBase);
			database.getAccountTable().set(indexOfAccount, account);
			return true;
		}
		return false;
	}

	/*
	 * Removes the given account object from the database. If no such account is
	 * found it returns false else returns true
	 * 
	 * @see
	 * com.bankingsystem.dao.IAccountDAO#removeAccount(com.bankingsystem.entities.
	 * Account)
	 */
	@Override
	public boolean removeAccount(Account account) {
		if (getAccount(account.getAccountId()) != null) {
			database.getAccountTable().remove(account);
			return true;
		}
		return false;
	}

}

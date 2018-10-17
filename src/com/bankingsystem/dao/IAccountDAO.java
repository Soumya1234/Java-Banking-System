package com.bankingsystem.dao;

import com.bankingsystem.entities.Account;

/**
 * API for performing various account related operations
 * 
 * @author Soumyadeep Ganguly
 *
 */
public interface IAccountDAO {
	/**
	 * Returns the Account object corresponding to the given accountId. If no
	 * account is found it returns null
	 * 
	 * @param accountId
	 * @return Account
	 */
	public abstract Account getAccount(String accountId);

	/**
	 * Maps the given accountNo to the corresponding accountId. Useful where clients
	 * mostly use the accountNo to perform transactions
	 * 
	 * @param accountNo
	 * @return accountId(String)
	 */
	public abstract String mapNoToId(String accountNo);

	/**
	 * 
	 * Adds the given account object to the Database. If there is an existing
	 * account with the given accountId it returns false else returns true on
	 * successful addition of account
	 * 
	 * @param account
	 * @return boolean
	 */

	public abstract boolean addAccount(Account account);

	/**
	 * Updates an existing account by replacing it with the given account object.If
	 * no such account is found it returns false else it returns true
	 * 
	 * @param account
	 * @return boolean
	 */
	public abstract boolean updateAccount(Account account);

	/**
	 * Removes the given account object from the database. If no such account is
	 * found it returns false else returns true
	 * 
	 * @param account
	 * @return
	 */
	public abstract boolean removeAccount(Account account);
}

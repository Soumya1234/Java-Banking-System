package com.bankingsystem.dao;

import java.util.List;
import com.bankingsystem.entities.Transaction;

/**
 * API for Transaction related operations
 * 
 * @author Soumyadeep Ganguly
 *
 */
public interface ITransactionDAO {
	/**
	 * Method to log the transaction into the Database. Returns true on success else
	 * returns false;
	 * 
	 * @param transaction
	 * @return
	 */
	public abstract boolean commitTransaction(Transaction transaction);

	/**
	 * Returns all the transactions corresponding to the given accountNo
	 * 
	 * @param accountNo
	 * @return
	 */
	public abstract List<Transaction> getTransactionDetails(String accountNo);
}

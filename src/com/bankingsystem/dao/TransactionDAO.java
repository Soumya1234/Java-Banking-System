package com.bankingsystem.dao;

import java.util.ArrayList;
import java.util.List;

import com.bankingsystem.database.DataStore;
import com.bankingsystem.entities.Transaction;

public class TransactionDAO implements ITransactionDAO {
	private DataStore database;
	
	public TransactionDAO(DataStore datastore)
	{
		database=datastore;
	}

	@Override
	public boolean commitTransaction(Transaction transaction) {
		if(transaction !=null) {
			database.insertIntoTransaction(transaction);
			return true;
		}
		return false;
	}

	@Override
	public List<Transaction> getTransactionDetails(String accountNo) {
		ArrayList<Transaction> result=new ArrayList<>();
		Transaction[] transactions=new Transaction[database.getTransactionTable().size()];
		for(Transaction tr:database.getTransactionTable().toArray(transactions)) {
			if(tr.getAccount().getAccountNo().equals(accountNo)) {
				result.add(tr);
			}
		}
		return result;
	}

}

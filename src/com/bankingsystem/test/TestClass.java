package com.bankingsystem.test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import com.bankingsystem.constants.TransactionType;
import com.bankingsystem.dao.*;
import com.bankingsystem.database.DataStore;
import com.bankingsystem.entities.*;

public class TestClass {
	public static void main(String[] args) {

		/* Testing the User Hierarchy */
		UserCredential credential = new UserCredential("Soumya@1234", "rohit");
		User user = new Customer(credential, "Soumyadeep", "Ganguly", "sganguly1992@gmail.com", "9064535614");
		// ((Customer) user).addAccount("1245663948948938");
		UserCredential credential2 = new UserCredential("Soumya@1234", "rohit@123");
		User user2 = new Customer(credential2, "Soumyadeep", "Ganguly", "sganguly1992@gmail.com", "9064535614");
		System.out.println(user.getCredential().matches(user2.getCredential()));

		/* Testing the Account Hierarchy */
		Account account = new SavingsAccount(new BigDecimal("0.4"), (Customer) user, "33479490777");
		System.out.println(account.getAccountId());
		System.out.println(account.getAccountType());
		System.out.println(account.getBalance());
		account.credit(new BigDecimal("200"));
		System.out.println(account.getBalance());
		System.out.println(account.getOpeningDate());
		System.out.println(account.getCustomers());
		try {
			account.debit(new BigDecimal("160"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println(account.getBalance());
		account.addInterest();
		System.out.println(account.getBalance());

		/* Testing whether Customer has been updated with the new Account or not */
		System.out.println(((Customer) user).getAccounts());

		/* Getting instance of DataStore Singleton */
		DataStore datastore = DataStore.getInstance();

		/* Testing UserDAO class */
		IUserDAO userdao = new UserDAO(datastore);
		userdao.addUser(user2);
		System.out.println(userdao.getUser(credential2).getFirstName());
		// System.out.println(userdao.removeUser(user2));
		User updatedUser = new Customer(credential2, "Soumyadeep", "Ganguly", "soumyadeepganguly41@gmail.com",
				"9064535614");
		System.out.println("User email before update:" + userdao.getUser(credential2).getEmail());
		System.out.println(userdao.updateUserDetails(updatedUser));
		System.out.println("User email after update:" + userdao.getUser(credential2).getEmail());

		/* Testing AccountDAO class */
		IAccountDAO accountdao = new AccountDAO(datastore);
		accountdao.addAccount(account);
		System.out.println(accountdao.getAccount(account.getAccountId()).getAccountNo());
		System.out.println(accountdao.getAccount(account.getAccountId()).getBalance());
		System.out.println(accountdao.getAccount(account.getAccountId()).getAccountType());
		System.out.println(accountdao.getAccount(account.getAccountId()).getCustomers());
		System.out.println(accountdao.getAccount(account.getAccountId()).getOpeningDate());
		System.out.println(accountdao.getAccount(account.getAccountId()).getInterest_rate());
		try {
			accountdao.getAccount(account.getAccountId()).credit(new BigDecimal("50"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		// System.out.println(accountdao.updateAccount(account));
		System.out.println("Balance after debit operation through DAO Class");
		System.out.println(accountdao.getAccount(account.getAccountId()).getBalance());

		/* Testing the TransactionDAO class */
		System.out.println("Let us perform a transaction and log it..");
		System.out.println("Balance in account no:"+account.getAccountNo()+" before transaction: "+account.getBalance());
		accountdao.getAccount(account.getAccountId()).credit(new BigDecimal("2000"));
		Transaction transaction = new Transaction(account, LocalDate.now(), LocalTime.now(), TransactionType.CREDIT,
				new BigDecimal("2000"));
		ITransactionDAO tDAO=new TransactionDAO(datastore);
		tDAO.commitTransaction(transaction);
		System.out.println("Transaction successful");
		System.out.println("Balance in account no:"+account.getAccountNo()+" after transaction: "+account.getBalance());
		List<Transaction> trs=tDAO.getTransactionDetails(account.getAccountNo());
		System.out.println(trs);
		accountdao.getAccount(account.getAccountId()).credit(new BigDecimal("8000"));
		Transaction transaction2 = new Transaction(account, LocalDate.now(), LocalTime.now(), TransactionType.CREDIT,
				new BigDecimal("8000"));
		ITransactionDAO tDAO2=new TransactionDAO(datastore);
		tDAO2.commitTransaction(transaction2);
		List<Transaction> trs2=tDAO.getTransactionDetails(account.getAccountNo());
		System.out.println(trs2);
		

	}
}
package com.bankingsystem.dao;

import java.util.ArrayList;
import com.bankingsystem.database.DataStore;
import com.bankingsystem.entities.User;
import com.bankingsystem.entities.UserCredential;

public class UserDAO implements IUserDAO {
	private DataStore database;

	public UserDAO(DataStore datastore) {
		this.database = datastore;
	}

	@Override
	public User getUser(UserCredential credential) {
		ArrayList<User> users = database.getUserTable();
		User[] userArray = new User[users.size()];
		for (User user : users.toArray(userArray)) {
			if (user.getCredential().matches(credential))
				return user;
		}
		return null;
	}

	@Override
	public boolean addUser(User user) {
		if (getUser(user.getCredential()) != null) {
			return false;
		}
		database.insertIntoUser(user);
		return true;
	}

	@Override
	public boolean updateUserDetails(User user) {
		User userInDataBase = getUser(user.getCredential());
		if (userInDataBase != null) {
			userInDataBase.setEmail(user.getEmail());
			userInDataBase.setFirstName(user.getFirstName());
			userInDataBase.setLastName(user.getLastName());
			userInDataBase.setMobile(user.getMobile());
			return true;
		}
		return false;
	}

	@Override
	public boolean removeUser(User user) {
		if (getUser(user.getCredential()) != null) {
			database.getUserTable().remove(user);
			return true;
		}
		return false;
	}

}

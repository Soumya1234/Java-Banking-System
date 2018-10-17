package com.bankingsystem.dao;

import com.bankingsystem.entities.*;

/**
 * API for handling User related operations
 * 
 * @author Soumyadeep Ganguly
 *
 */
public interface IUserDAO {
	/**
	 * Returns the user object from the database matching the given credential
	 * 
	 * @param credential
	 * @return User
	 */
	public abstract User getUser(UserCredential credential);
	/**
	 * Adds the given user to the database Returns true on success else returns
	 * false
	 * 
	 * @param user
	 * @return boolean
	 */
	public abstract boolean addUser(User user);
	/**
	 * Updates the existing user with the given user. 
	 * Returns true on success else returns false.
	 * @param user
	 * @return boolean
	 */
	public abstract boolean updateUserDetails(User user);
	/**
	 * Removes the existing user from the database.
	 * Returns true on success else returns false.
	 * @param user
	 * @return boolean
	 */
	public abstract boolean removeUser(User user);
}

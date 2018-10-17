package com.bankingsystem.dao;

import java.util.List;
import com.bankingsystem.entities.Request;

/**
 * API for Request related operations
 * 
 * @author Soumyadeep Ganguly
 *
 */

public interface IRequestDAO {
	/**
	 * Returns the list of Request objects from the Database
	 * 
	 * @return List
	 */
	public abstract List<Request> getAllRequests();

	/**
	 * Adds a request object to the database.Returns true if given request object is
	 * successfully added else returns false
	 * 
	 * @param request
	 * @return boolean
	 */
	public abstract boolean addRequest(Request request);

	/**
	 * Removes the request from the Database. On success returns true else returns
	 * false.
	 * 
	 * @param request
	 * @return boolean
	 */
	public abstract boolean removeRequest(Request request);
}

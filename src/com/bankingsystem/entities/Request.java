package com.bankingsystem.entities;

import com.bankingsystem.constants.RequestStatus;
import com.bankingsystem.constants.RequestType;

/**
 * Entity class for different requests that customers generate
 * 
 * @author Soumyadeep Ganguly
 *
 */

public class Request {
	private Customer customer;
	private int reqID;
	private RequestType requestType;
	private RequestStatus requestStatus;

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public int getReqID() {
		return reqID;
	}

	public void setReqID(int reqID) {
		this.reqID = reqID;
	}

	public RequestType getRequestType() {
		return requestType;
	}

	public void setRequestType(RequestType requestType) {
		this.requestType = requestType;
	}

	public RequestStatus getRequestStatus() {
		return requestStatus;
	}

	public void setRequestStatus(RequestStatus requestStatus) {
		this.requestStatus = requestStatus;
	}

}

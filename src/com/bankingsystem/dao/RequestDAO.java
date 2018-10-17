package com.bankingsystem.dao;

import java.util.List;

import com.bankingsystem.database.DataStore;
import com.bankingsystem.entities.Request;

public class RequestDAO implements IRequestDAO {
	private DataStore database;
	
	public RequestDAO(DataStore datastore) {
		this.database=datastore;
	}
	@Override
	public List<Request> getAllRequests() {
		return database.getRequestTable();
	}

	@Override
	public boolean addRequest(Request request) {
		if(request!=null) {
			database.insertIntoRequest(request);
			return true;
		}
		return false;
	}

	@Override
	public boolean removeRequest(Request request) {
		if(request!=null) {
			database.getRequestTable().remove(request);
			return true;
		}
		return false;
	}
}

package com.bankingsystem.entities;

public class UserCredential {
	private String userId;
	private String password;

	public UserCredential(String userId, String password) {
		this.userId = userId;
		this.password = password;
	}

	public String getuserId() {
		return userId;
	}

	public void setuserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean matches(UserCredential userCredential)
	{
		if(userCredential!=null) {
			if(this.userId.equals(userCredential.userId) && this.password.equals(userCredential.password)) {
				return true;
			}
		}
		return false;
	}

}

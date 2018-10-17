package com.bankingsystem.entities;

import com.bankingsystem.constants.UserType;
/**
 * Entity for the Administrator type users of the Banking System
 * @author Soumyadeep Ganguly
 *
 */
public class Administrator extends User{

	@Override
	protected final void setUserType() {
		userType=UserType.ADMIN;
	}
	

}

package com.praveen.service;

import com.praveen.model.User;

public class LoginService {

	public boolean verifyLogin(User user) {
		if(user.getUserid().equalsIgnoreCase("Praveen") && user.getPassword().equalsIgnoreCase("Password") ) {
			return true;
		}
		return false;
	}
}

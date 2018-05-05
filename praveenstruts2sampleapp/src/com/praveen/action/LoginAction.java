package com.praveen.action;

import org.apache.commons.lang.xwork.StringUtils;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.praveen.model.User;
import com.praveen.service.LoginService;

public class LoginAction extends ActionSupport implements ModelDriven<User> {
	private static final long serialVersionUID = -1965878195011833360L;
	
	private User user= new User();

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void validate() {
		if(StringUtils.isEmpty(user.getUserid())) {			
			addFieldError( user.getUserid(),"userid cannot be blank");
		}
		
		if(StringUtils.isEmpty( user.getPassword())) {
			addFieldError( user.getPassword(),"password cannot be blank");
		}
	}

	public String execute() {
		LoginService loginService= new LoginService();	
		if (loginService.verifyLogin(user)) {
			return SUCCESS;
		}
		return LOGIN;
	}

	@Override
	public User getModel() {		
		return user;
	}	
}

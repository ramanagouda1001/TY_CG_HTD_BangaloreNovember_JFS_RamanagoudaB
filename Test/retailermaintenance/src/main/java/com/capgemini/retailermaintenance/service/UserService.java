package com.capgemini.retailermaintenance.service;

import com.capgemini.retailermaintenance.bean.UserInfo;

public interface UserService {

	public boolean create(UserInfo bean);//done
	
	public boolean authUser(String email,String password);//done
	
	public boolean updatepassword(String email,String password);//done
	
}

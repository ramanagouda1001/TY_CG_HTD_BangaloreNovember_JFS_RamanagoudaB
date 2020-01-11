package com.capgemini.retailermaintenance.dao;

import com.capgemini.retailermaintenance.bean.UserInfo;

public interface UserDAO {

	public boolean create(UserInfo bean);

	public boolean authUser(String email,String password);
	

	public boolean updatepassword(String email,String password);

}

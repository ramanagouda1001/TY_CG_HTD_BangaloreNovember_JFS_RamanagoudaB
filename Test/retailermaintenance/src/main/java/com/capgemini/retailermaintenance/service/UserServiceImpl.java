package com.capgemini.retailermaintenance.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.retailermaintenance.bean.UserInfo;
import com.capgemini.retailermaintenance.dao.UserDAO;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO dao;
	

	@Override
	public boolean create(UserInfo bean) {
		// TODO Auto-generated method stub
		return dao.create(bean);
	}


	@Override
	public boolean authUser(String email, String password) {
		// TODO Auto-generated method stub
		return dao.authUser(email, password);
	}


	@Override
	public boolean updatepassword(String email, String password) {
		// TODO Auto-generated method stub
		return dao.updatepassword(email, password);
	}

}

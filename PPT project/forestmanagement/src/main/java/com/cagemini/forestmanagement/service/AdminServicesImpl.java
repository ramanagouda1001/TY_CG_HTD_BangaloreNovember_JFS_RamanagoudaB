package com.cagemini.forestmanagement.service;

import java.util.List;

import com.cagemini.forestmanagement.bean.Account;
import com.cagemini.forestmanagement.dao.AdminDAO;
import com.cagemini.forestmanagement.factory.AdminFactory;

public class AdminServicesImpl implements AdminServices{

	AdminDAO dao=AdminFactory.instanceOfAdminDAO();
	@Override
	public boolean getAdmin(Account admin) {
		// TODO Auto-generated method stub
		return dao.getAdmin(admin);
	}
	@Override
	public boolean addAccount(Account bean) {
		// TODO Auto-generated method stub
		return dao.addAccount(bean);
	}
	@Override
	public boolean getAccount(String username, String password) {
		// TODO Auto-generated method stub
		return dao.getAccount(username, password);
	}
	@Override
	public boolean deleteAccount(Account bean) {
		// TODO Auto-generated method stub
		return dao.deleteAccount(bean);
	}
	@Override
	public List<Account> listAccount() {
		// TODO Auto-generated method stub
		return dao.listAccount();
	}
	@Override
	public boolean updateAccount(String newPassword, String oldPassword) {
		// TODO Auto-generated method stub
		return dao.updateAccount(newPassword, oldPassword);
	}
	@Override
	public boolean getAccountSchedular(String username, String password) {
		// TODO Auto-generated method stub
		return dao.getAccountSchedular(username, password);
	}
}

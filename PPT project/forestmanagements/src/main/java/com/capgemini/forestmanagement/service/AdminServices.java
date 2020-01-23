package com.capgemini.forestmanagement.service;

import java.util.List;

import com.capgemini.forestmanagement.bean.Account;
import com.capgemini.forestmanagement.bean.Admin;

public interface AdminServices {
	public boolean getAdmin(Admin admin);

	public 	boolean addAccount(Account bean);
	
	public boolean getAccount(String username,String password);

	public boolean deleteAccount(Account bean);

	public List<Account> listAccount();
	
	public boolean updateAccount(String newPassword,String oldPassword);
	
	public boolean getSchedular(String username,String password);

	
}

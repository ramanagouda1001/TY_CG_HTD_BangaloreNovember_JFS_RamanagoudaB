package com.cagemini.forestmanagement.service;

import java.util.List;

import com.cagemini.forestmanagement.bean.Account;

public interface AdminServices {
	public boolean getAdmin(Account admin);

	public 	boolean addAccount(Account bean);
	
	public boolean getAccount(String username,String password);

	public boolean deleteAccount(Account bean);

	public List<Account> listAccount();
	
	public boolean updateAccount(String newPassword,String oldPassword);
	
	public boolean getAccountSchedular(String username, String password);

}

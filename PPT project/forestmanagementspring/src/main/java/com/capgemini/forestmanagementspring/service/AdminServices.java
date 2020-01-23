package com.capgemini.forestmanagementspring.service;

import java.util.List;

import com.capgemini.forestmanagementspring.bean.Account;

public interface AdminServices {
	public Account getAdmin(Account admin);//done

	public 	boolean addAccount(Account bean);//done
	
	public boolean deleteAccount(Account bean);//done

	public List<Account> listAccount();//done
	
	public boolean updateAccount(Account bean);

}

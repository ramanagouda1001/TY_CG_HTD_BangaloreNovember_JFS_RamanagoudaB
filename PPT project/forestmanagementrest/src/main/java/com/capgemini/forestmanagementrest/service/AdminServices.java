package com.capgemini.forestmanagementrest.service;

import java.util.List;

import com.capgemini.forestmanagementrest.bean.Account;

public interface AdminServices {
	public boolean getAdmin(Account admin);//done

	public 	boolean addAccount(Account bean);//done
	
	public boolean deleteAccount(Account bean);//done

	public List<Account> listAccount();//done
	

}

package com.capgemini.forestmanagement.service;

import java.util.List;

import com.capgemini.forestmanagement.bean.Client;

public interface ClientServices {
	public boolean add(Client bean);//Accessed by admin

	public boolean specificClient(Client bean);

	public List<Client> getClient();//Accessed by Admin
	
	public boolean delete(Client bean);
	
	public boolean modify(String newPassword,String oldPassword);

}

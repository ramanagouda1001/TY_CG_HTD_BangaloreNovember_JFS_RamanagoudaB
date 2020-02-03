package com.capgemini.forestmanagement.factory;

import com.capgemini.forestmanagement.dao.ClientDAO;
import com.capgemini.forestmanagement.dao.ClientDAOImpl;
import com.capgemini.forestmanagement.service.ClientServices;
import com.capgemini.forestmanagement.service.ClientServicesImpl;

public class ClientFactory {
	private ClientFactory()
	{
		
	}
	public static ClientDAO instanceOfClientDAOImpl()
	{
		ClientDAO dao=new ClientDAOImpl();
		return dao;
	}
	public static ClientServices  instanceOfClientServicesImpl()
	{
		ClientServices service=new ClientServicesImpl();
		return service;
	}
}

package com.capgemini.forestrymanagementcollection.factory;

import com.capgemini.forestrymanagementcollection.dao.ClientDAO;
import com.capgemini.forestrymanagementcollection.dao.ClientDAOImpl;
import com.capgemini.forestrymanagementcollection.service.ClientServices;
import com.capgemini.forestrymanagementcollection.service.ClientServicesImpl;

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

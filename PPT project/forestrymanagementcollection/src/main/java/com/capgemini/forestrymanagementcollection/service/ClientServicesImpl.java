package com.capgemini.forestrymanagementcollection.service;

import java.util.List;

import com.capgemini.forestrymanagementcollection.bean.Client;
import com.capgemini.forestrymanagementcollection.dao.ClientDAO;
import com.capgemini.forestrymanagementcollection.factory.ClientFactory;

public class ClientServicesImpl implements ClientServices{

	ClientDAO dao=ClientFactory.instanceOfClientDAOImpl();
	
	public boolean add(Client bean) {
		// TODO Auto-generated method stub
		return dao.add(bean);
	}

	public boolean specificClient(Client bean) {
		// TODO Auto-generated method stub
		return dao.specificClient(bean);
	}

	public List<Client> getClient() {
		// TODO Auto-generated method stub
		return dao.getClient();
	}

	public boolean delete(Client bean) {
		// TODO Auto-generated method stub
		return dao.delete(bean);
	}

	public boolean modify(String newPassword, String oldPassword) {
		// TODO Auto-generated method stub
		return dao.modify(newPassword, oldPassword);
	}

}

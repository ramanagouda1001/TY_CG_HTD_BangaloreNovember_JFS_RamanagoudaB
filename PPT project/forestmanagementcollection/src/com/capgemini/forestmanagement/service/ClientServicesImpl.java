package com.capgemini.forestmanagement.service;

import java.util.List;

import com.capgemini.forestmanagement.bean.Client;
import com.capgemini.forestmanagement.dao.ClientDAO;
import com.capgemini.forestmanagement.factory.ClientFactory;

public class ClientServicesImpl implements ClientServices{

	ClientDAO dao=ClientFactory.instanceOfClientDAOImpl();
	@Override
	public boolean add(Client bean) {
		// TODO Auto-generated method stub
		return dao.add(bean);
	}

	@Override
	public boolean specificClient(Client bean) {
		// TODO Auto-generated method stub
		return dao.specificClient(bean);
	}

	@Override
	public List<Client> getClient() {
		// TODO Auto-generated method stub
		return dao.getClient();
	}

	@Override
	public boolean delete(Client bean) {
		// TODO Auto-generated method stub
		return dao.delete(bean);
	}

	@Override
	public boolean modify(String newPassword, String oldPassword) {
		// TODO Auto-generated method stub
		return dao.modify(newPassword, oldPassword);
	}

}

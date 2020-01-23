package com.capgemini.forestmanagement.dao;

import java.util.ArrayList;
import java.util.List;

import com.capgemini.forestmanagement.bean.Client;
import com.capgemini.forestmanagement.exception.ForestManagementException;

public class ClientDAOImpl implements ClientDAO{

	List<Client> list=new ArrayList<Client>();
	@Override
	public boolean add(Client bean) {
		boolean status=true;
		for (Client client : list) {
				if(client.getUsername().equals(bean.getUsername()))
				{
					throw new ForestManagementException("AllReady Account Present");
				}
		}
		list.add(bean);
		return status;
	}
	@Override
	public List<Client> getClient() {
		return list;
	}

	@Override
	public boolean specificClient(Client bean) {
		boolean status=true;
		for (Client client : list) {
			if(client.getUsername().equals(bean.getUsername()))
			{
				if(client.getPassword().equals(bean.getPassword()))
				{
					return status;
				}
			}
		}
		throw new ForestManagementException("Account is not Present");
	}
	@Override
	public boolean delete(Client bean) {
		boolean status=true;
		for (Client client : list) {
			if(client.getUsername().equals(bean.getUsername()))
			{
				if(client.getPassword().equals(bean.getPassword()))
				{
					list.remove(client);
					return status;
				}
			}
		}
		throw new ForestManagementException("Account is not Present");
	}

	@Override
	public boolean modify(String newPassowrd, String oldPassword) {
		boolean status=true;
		for (Client client : list) {
			if(client.getPassword().equals(oldPassword))
			{
				client.setPassword(newPassowrd);
				return status;
			}
		}
		throw new ForestManagementException("Unable to Modify");
		}
	}

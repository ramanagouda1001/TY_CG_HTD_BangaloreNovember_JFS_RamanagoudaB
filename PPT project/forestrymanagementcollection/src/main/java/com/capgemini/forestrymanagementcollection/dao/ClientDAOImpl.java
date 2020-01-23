package com.capgemini.forestrymanagementcollection.dao;

import java.util.ArrayList;
import java.util.List;

import com.capgemini.forestrymanagementcollection.bean.Client;
import com.capgemini.forestrymanagementcollection.exception.ForestManagementException;

public class ClientDAOImpl implements ClientDAO{

	List<Client> list=new ArrayList<Client>();

	
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
	
	public List<Client> getClient() {
		return list;
	}

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

package com.capgemini.forestmanagement.dao;



import java.util.ArrayList;
import java.util.List;

import com.capgemini.forestmanagement.bean.Client;


public class ClientDAOImpl implements ClientDAO{

	List<Client> list=new ArrayList<Client>();
	@Override
	public boolean add(Client bean) {
		for (Client client : list) {
			if(client.getUsername().equals(bean.getUsername()))
			{
				return false;
			}
		}
		list.add(bean);
		return true;
	}

	@Override
	public List<Client> getClient() {
		return list;
	}

	@Override
	public boolean specificClient(Client bean) {
		for (Client client : list) {
			if(client.getUsername().equals(bean.getUsername()))
			{
				if(client.getPassword().equals(bean.getPassword()))
				{
					return true;
				}
			}
		}
		return false;
	}
	@Override
	public boolean delete(Client bean) {
		for (Client client : list) {
			if(client.getUsername().equals(bean.getUsername()))
			{
				if(client.getPassword().equals(bean.getPassword()))
				{
					list.remove(client);
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public boolean modify(String newPassowrd, String oldPassword) {
		for (Client client : list) {
			if(client.getPassword().equals(oldPassword))
			{
				client.setPassword(newPassowrd);
				return true;
			}
		}
		return false;
		}
	}

package com.capgemini.forestmanagement.dao;


import java.util.List;

import com.capgemini.forestmanagement.bean.Client;


public interface ClientDAO {
	public boolean add(Client bean);

	public List<Client> getClient();

	public boolean specificClient(Client bean);

	public boolean delete(Client bean);

	public boolean modify(String newPassowrd, String oldPassword);
}

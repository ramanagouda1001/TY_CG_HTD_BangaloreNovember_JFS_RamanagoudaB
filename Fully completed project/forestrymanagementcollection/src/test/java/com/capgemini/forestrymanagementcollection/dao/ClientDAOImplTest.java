package com.capgemini.forestrymanagementcollection.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.capgemini.forestrymanagementcollection.bean.Client;

class ClientDAOImplTest {

	private ClientDAO clientDAO=new ClientDAOImpl();
	private Client client =new Client();
	
	@BeforeEach
	void addClient() {
		client.setUsername("Rohan@gmail.com");
		client.setPassword("Ramubb143@");
	}
	@Test	
	void testAdd() {
		boolean flag=clientDAO.add(client);
		assertEquals(flag, true);
	}

	@Test
	void testGetClient() {
		List<Client> list=clientDAO.getClient();
		boolean flag= list!=null;
		assertEquals(flag, true);
	}

	@Test
	void testSpecificClient() {
		Client object=new Client();
		object.setUsername("Rohan@gmail.com");
		object.setPassword("Ramubb143@");
		clientDAO.add(object);
		boolean flag=clientDAO.specificClient(object);
		assertEquals(flag, true);
	}

	@Test
	void testDelete() {
		Client object=new Client();
		object.setUsername("Rohan@gmail.com");
		object.setPassword("Ramubb143@");
		clientDAO.add(object);
		boolean flag=clientDAO.delete(object);
		assertEquals(flag, true);	
	}

	@Test
	void testModify() {
		Client object=new Client();
		object.setUsername("Rohan@gmail.com");
		object.setPassword("Ramubb143@");
		clientDAO.add(object);
		boolean flag=clientDAO.modify("Akki123@",object.getPassword());
		assertEquals(flag, true);	
	
	}

}
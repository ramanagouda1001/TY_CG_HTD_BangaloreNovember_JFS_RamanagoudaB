package com.cagemini.forestmanagement.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.cagemini.forestmanagement.bean.Account;
import com.cagemini.forestmanagement.exception.ForestManagementSystem;

class AdminDAOImplTest {

	Account account=null;
	AdminDAOImpl obj=null;
	
	@BeforeEach
	void loadDriver() {
		obj=new AdminDAOImpl();
		
	}
	
	@Test
	public void testGetAdmin() {
		account=new Account();
		account.setUsername("Rohan@gmail.com");
		account.setPassword("Ramubb143@");
		try {
			boolean flag=obj.getAdmin(account);
			assertEquals(flag, true);
		}
		catch (Exception e) {
			assertThrows(ForestManagementSystem.class, () -> {
				obj.addAccount(account);
		});
		}
	}

	@Test
	public void testAddAccount() {
		account=new Account();
		account.setUsername("Dilipa123@gmail.com");
		account.setPassword("Dilipa123@");
		account.setRole("Schedular");
		try {
			boolean flag=obj.addAccount(account);
			assertEquals(flag,true);
		}catch(Exception e) {
			assertThrows(ForestManagementSystem.class,() ->{
				obj.addAccount(account);
			});
		}

	}

	@Test
	public void testGetAccount() {
		account=new Account();
		account.setUsername("kki123@gmail.com");
		account.setPassword("Akki12@");
		try {
		boolean flag=obj.getAccount(account.getUsername(), account.getPassword());
		assertEquals(flag,true);
		}
		catch (Exception e) {
			assertThrows(ForestManagementSystem.class, () ->{
				obj.getAccount(account.getUsername(), account.getPassword());
			});
		}
	}

	@Test
	public void testDeleteAccount() {
		account=new Account();
		account.setUsername("Akki123@gmail.com");
		account.setPassword("Akki123@");
		try {
			boolean flag=obj.deleteAccount(account);
			assertEquals(flag, true);
		}
		catch(Exception e) {
			assertThrows(ForestManagementSystem.class,()->{
				obj.deleteAccount(account);
			});
		}
	}

	@Test
	public void testGetAccountSchedular() {
		account=new Account();
		account.setUsername("Dilipa123@gmail.com");
		account.setPassword("Dilipa123@");
		try {
			boolean flag=obj.getAccountSchedular(account.getUsername(), account.getPassword());
			assertEquals(flag, true);
		}
		catch(Exception e) {
			assertThrows(ForestManagementSystem.class,()->{
				obj.deleteAccount(account);
			});
		}
	}
}

package com.capgemini.forestmanagement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.cagemini.forestmanagement.bean.Account;
import com.cagemini.forestmanagement.dao.AdminDAOImpl;
import com.cagemini.forestmanagement.exception.ForestManagementSystem;

public class AdminTest {
	
	Account account=null;
	AdminDAOImpl obj=null;
	
	@BeforeEach
	void loadDriver() {
		obj=new AdminDAOImpl();
		
	}
	
	@Test
	void getAdminTest() { //passed
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
	void addAccountTest() {
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
	void getClientTest() {
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
	void accountDeleteTest() {
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
	void getSchedularTest() {
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

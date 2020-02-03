package com.capgemini.forestmanagement.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileReader;
import java.util.List;
import java.util.Properties;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.capgemini.forestmanagement.bean.Account;
import com.capgemini.forestmanagement.bean.Admin;
import com.capgemini.forestmanagement.exception.ForestManagementException;

class AdminDAOImplTest {

	Account account=null;
	Admin admin=null;
	AdminDAOImpl obj=null;
	@BeforeEach
	void testAdminDAOImpl() {
		{
			FileReader reader;
			Properties prop;
			try {
				reader = new FileReader("db.properties");
				prop = new Properties();
				prop.load(reader);
				Class.forName(prop.getProperty("driver"));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("hi");
			}
			obj=new AdminDAOImpl();
		}
	}

	@Test
	void testGetAdmin() {
		admin=new Admin();
		admin.setName("Rohan@gmail.com");
		admin.setPassword("Ramubb143@");
		boolean flag=obj.getAdmin(admin);
		assertEquals(flag, false);
	}

	@Test
	void testAddAccount() {
		account=new Account();
		account.setUsername("Rohit@gmail.com");
		account.setPassword("Rohit123@");
		account.setRole("client");
		try {
			boolean flag=obj.addAccount(account);
			assertEquals(flag, true);
		}
		catch (Exception e) {
			assertThrows(ForestManagementException.class, () -> {
				obj.addAccount(account);
		});
		}

	}

	@Test
	void testGetAccount() {
		boolean flag=obj.getAccount("Rohan@gmail.com", "Akki123@");
		assertEquals(flag,false);
	}

	@Test
	void testDeleteAccount() {
		account=new Account();
		account.setUsername("Rohit@gmail.com");
		account.setPassword("Rohit123@");
		boolean flag=obj.deleteAccount(account);
		if(flag==true)
			assertEquals(flag, true);
		else
			assertEquals(flag, false);
	}

	@Test
	void testListAccount() {
		List<Account> list=obj.listAccount();
		boolean flag=list!=null;
		assertEquals(flag, true);
	}

	@Test
	void testUpdateAccount() {
		String newPassword="Akki123@";
		String oldPassword="Rohan@123";
		boolean flag=obj.updateAccount(newPassword, oldPassword);
		if(flag==true)
			assertEquals(flag, true);
		else
			assertEquals(flag, false);

	}
}

package com.capgemini.forestmanagementspring.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.forestmanagementspring.bean.Account;
import com.capgemini.forestmanagementspring.exception.ForestManagementSystem;

@SpringBootTest
class AdminServicesImplTest {

	@Autowired
	private AdminServices adminServices;
	
	@Test
	void testAddAccount() {
		Account account=new Account();
		account.setEmail("Shreehari@gmail.com");
		account.setPassword("Shreehari123@");
		account.setRole("admin");
		try {
			boolean flag=adminServices.addAccount(account);
			assertEquals(flag, true);
			}
			catch (Exception e) {
				assertThrows(ForestManagementSystem.class, () -> {
					adminServices.addAccount(account);
			});
		}
	}

	@Test
	void testDeleteAccount() {
		Account account=new Account();
		account.setEmail("Shreehari@gmail.com");
		account.setPassword("Shreehari123@");
		account.setRole("admin");
		try {
			boolean flag=adminServices.deleteAccount(account);
			assertEquals(flag, true);
			}
			catch (Exception e) {
				assertThrows(ForestManagementSystem.class, () -> {
					adminServices.addAccount(account);
			});
		}	
	}

	@Test
	void testListAccount() {
		List<Account> list=adminServices.listAccount();
		assertNotNull(list);
	}

	@Test
	void testGetAdmin() {
		Account account=new Account();
		account.setEmail("Rohan@gmail.com");
		account.setPassword("Ramubb143@");
		account.setRole("admin");
		try {
			Account object=adminServices.getAdmin(account);
			assertEquals(object, account);
			}
			catch (Exception e) {
				assertThrows(ForestManagementSystem.class, () -> {
					adminServices.addAccount(account);
			});
		}

	}

	@Test
	void testUpdateAccount() {
		Account account=new Account();
		account.setEmail("Sai123@gmail.com");
		account.setRole("Schedular");
		account.setPassword("Rohan123#");
		try {
			boolean flag=adminServices.updateAccount(account);
			assertEquals(flag,true);
			}
			catch (Exception e) {
				assertThrows(ForestManagementSystem.class, () -> {
					adminServices.addAccount(account);
			});
		}
	}
}

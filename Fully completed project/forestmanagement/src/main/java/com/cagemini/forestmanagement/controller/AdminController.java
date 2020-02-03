package com.cagemini.forestmanagement.controller;

import java.util.List;
import java.util.Scanner;

import com.cagemini.forestmanagement.bean.Account;
import com.cagemini.forestmanagement.exception.ForestManagementSystem;
import com.cagemini.forestmanagement.factory.AdminFactory;
import com.cagemini.forestmanagement.service.AdminServices;
import com.cagemini.forestmanagement.validation.Validation;

public class AdminController {
	public static void main(String args[]) {
		System.out.println("-------------WELCOME ADMIN-------------");
		AdminServices servicesAdmin = AdminFactory.instanceOfAdminServices();
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		boolean flag = true;
		boolean status = true;
		String choice;
		while (flag == true) {
			Account admin = new Account();
			status = true;
			while (status == true) {
				System.out.println("Enter the User Email");
				String username = input.next();
				if (Validation.isValidEmail(username)) {
					admin.setUsername(username);
					status = false;
				} else {
					System.err.println("Invalid format(adc@xyz.com.... allowed)");
				}
			}
			status = true;
			while (status == true) {
				System.out.println("Enter the password");
				String password = input.next();
				if (Validation.validPassword(password)) {
					admin.setPassword(password);
					status = false;
				} else {
					System.err.println(
							"Your password must be atleast\n5character\n1uppercase & 1 lowercase character\n1 number \n 1 Special Character");
				}
			}
			try {
				if (servicesAdmin.getAdmin(admin)) {
					System.out.println("You are Successfully logined");
					status = true;
					flag = false;
				} else {
					System.err.println("Invalid credentials");
				}
			} catch (ForestManagementSystem e) {
				System.out.println(e.getMessage());
			}
		}
		while (true) {
			System.out.println("-------------WELCOME ADMIN-------------");
			System.out.println("Press 1 To Add New Account");
			System.out.println("Press 2 Get Account Details");
			System.out.println("press 3 Acess Land Deatils");
			System.out.println("press 4 to Back");
			System.out.println("Enter Your Choice");
			choice = input.next();
			switch (Validation.isNumber2(choice)) {
			case 1:
				flag = true;
				while (flag == true) {
				System.out.println("------------------Create the Account-----------------");
				Account account = new Account();
				status = true;
				while (status == true) {
					System.out.println("Enter the Email");
					String username = input.next();
					if (Validation.isValidEmail(username)) {
						account.setUsername(username);
						status = false;
					} else {
						System.err.println("Invalid format");
					}
				}
				status = true;
				while (status == true) {
					System.out.println("Enter the password");
					String password = input.next();
					if (Validation.validPassword(password)) {
						account.setPassword(password);
						status = false;
					} else {
						System.err.println(
								"Your password must be atleast\n5character\n1uppercase & 1 lowercase character\n1 number \n 1 Special Character");
					}
				}
				status = true;
				while (status == true) {
					System.out.println("Enter the role");
					System.out.println("press 1 for Client");
					System.out.println("press 2 for Schedular");
					System.out.println("press 3 for product");
					choice = input.next();
					if (Validation.isNumber(choice)) {
						switch (Validation.isNumber2(choice)) {
							case 1:
								account.setRole("client");
								status = false;
							break;
							case 2:
								account.setRole("Schedular");
								status = false;
							break;
							case 3:
								account.setRole("product");
								status = false;
							break;
							default:
								System.out.println("Plz select the above option");
								break;
							}
						} else {
							System.err.println("please select the above option");
					}
				}
				try {
					if (servicesAdmin.addAccount(account)) {
						System.out.println("A New Account has Been Created of " + account.getUsername()
								+ " of role=" + account.getRole());
						status = true;
					flag = false;
				} else {
					System.err.println("Invalid credentials");
				}
				} catch (ForestManagementSystem e) {
						System.err.println(e.getMessage());
				}
			}
			break;
			case 2:
				List<Account> list = servicesAdmin.listAccount();
				if (list.isEmpty()) {
					System.out.println("Empty......");
				} else {
					System.out.println(list);
				}
			break;
			case 3:
				LandController.main(args);
			break;
			case 4:
			return;
			} // end of main while loop
		} // end of customer
	}
}


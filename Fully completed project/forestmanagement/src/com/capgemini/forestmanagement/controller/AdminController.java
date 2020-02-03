package com.capgemini.forestmanagement.controller;

import java.util.Scanner;

import com.capgemini.forestmanagement.bean.Admin;
import com.capgemini.forestmanagement.bean.Client;
import com.capgemini.forestmanagement.factory.ClientFactory;
import com.capgemini.forestmanagement.factory.ContractFactory;
import com.capgemini.forestmanagement.factory.ProductFactory;
import com.capgemini.forestmanagement.service.ClientServices;
import com.capgemini.forestmanagement.service.ContractServices;
import com.capgemini.forestmanagement.service.ProductServices;
import com.capgemini.forestmanagement.validation.Validation;

public class AdminController {

	public static ProductServices servicesProduct = ProductFactory.instanceOfProductServicesImpl();
	public static ClientServices serviceClient = ClientFactory.instanceOfClientServicesImpl();
	public static ContractServices servicesContract = ContractFactory.insatnceOfContractServicesImpl();

	public AdminController() {
		System.out.println("-------------WELCOME ADMIN-------------");
		Scanner in = new Scanner(System.in);
		char flag = 'y';
		char ch = 'y';
		char ch2 = 'y';
		String choice;
		while (flag == 'y') {
			Admin admin = new Admin();
			ch = 'y';
			while (ch == 'y') {
				System.out.println("Enter the Email");
				String username = in.next();
				if (Validation.isValidEmail(username)) {
					admin.setName(username);
					ch = 'n';
				} else {
					System.err.println("Invalid format");
				}
			}
			ch = 'y';
			while (ch == 'y') {
				System.out.println("Enter the password");
				String password = in.next();
				if (Validation.validPassword(password)) {
					admin.setPassword(password);
					ch = 'n';
				} else {
					System.err.println("Invalid format");
				}
			}
			if (admin.getName().equals("Rohan@gmail.com") && admin.getPassword().equals("Ramubb143@")) {
				System.out.println("You are sucessfully logined");
				ch = 'y';
				flag = 'n';
			} else {
				System.err.println("Sry your not admin");
			}
		}
		while (true) {
			int choice1 = 0;
			while (ch2 == 'y') {
				System.out.println("-------------WELCOME ADMIN-------------");
				System.out.println("Press 1 To Add New Client");
				System.out.println("Press 2 Get All Client Details");
				System.out.println("press 3 Acess Land details");
				System.out.println("press 4 to Back");
				System.out.println("Enter Your Choice");
				choice = in.next();
				if (Validation.isNumber(choice)) {
					choice1 = Validation.isNumber2(choice);
					if (choice1 == 1 || choice1 == 2 || choice1 == 3 || choice1 == 4) {

					} else {
						System.err.println("plz select above option ");
					}
				} else {
					System.err.println("Invalid Format Please Enter the Number only");
				}
				switch (choice1) {
				case 1:
					flag = 'y';
					Client bean = new Client();
					System.err.println("------Create a New Client---------");
					while (flag == 'y') {
						System.out.println("Enter the Client name");
						String username = in.next();
						if (Validation.isValidEmail(username)) {
							bean.setUsername(username);
							flag = 'n';
						} else {
							System.err.println("Invalid format");
						}
					}
					flag = 'y';
					while (flag == 'y') {
						System.out.println("Enter the Password");
						String password = in.next();
						if (Validation.validPassword(password)) {
							bean.setPassword(password);
							flag = 'n';
						} else {
							System.err.println(
									"Invalid format(Atleast 5 letter one uppercase,one lowercase,one number then atleast a special character");
						}
					}
					if (serviceClient.add(bean)) {
						System.out.println("Successfully created");
					} else {
						System.err.println("client Already Exist");
					}

					break;
				case 2:
					if (serviceClient.getClient() != null) {
						System.out.println(serviceClient.getClient());
					} else {
						System.err.println("Empty");
					}
					break;
				case 3:
					LandController obj=new LandController();
					break;
				case 4:
					return;
				} // end of main while loop
			} // end of customer
		}
	}
}

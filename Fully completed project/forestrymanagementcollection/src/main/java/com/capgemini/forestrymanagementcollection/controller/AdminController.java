package com.capgemini.forestrymanagementcollection.controller;

import java.util.Scanner;

import com.capgemini.forestrymanagementcollection.bean.Client;
import com.capgemini.forestrymanagementcollection.exception.ForestManagementException;
import com.capgemini.forestrymanagementcollection.factory.ClientFactory;
import com.capgemini.forestrymanagementcollection.factory.ContractFactory;
import com.capgemini.forestrymanagementcollection.factory.LandFactory;
import com.capgemini.forestrymanagementcollection.factory.ProductFactory;
import com.capgemini.forestrymanagementcollection.service.ClientServices;
import com.capgemini.forestrymanagementcollection.service.ContractServices;
import com.capgemini.forestrymanagementcollection.service.LandServices;
import com.capgemini.forestrymanagementcollection.service.ProductServices;
import com.capgemini.forestrymanagementcollection.validation.Validation;

public class AdminController {

	public static ClientServices serviceClient = ClientFactory.instanceOfClientServicesImpl();
	public static ProductServices productServices = ProductFactory.instanceOfProductServicesImpl();
	public static ContractServices contractServices = ContractFactory.insatnceOfContractServicesImpl();
	public static LandServices landServices=LandFactory.instanceofLandServices();
	public static void main(String args[]) {
		System.out.println("-------------WELCOME ADMIN-------------");
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		boolean flag = true;
		boolean check = true;
		boolean status = true;
		String choice;
		while (flag == true) {
			String username=null;
			String password=null;
			check = true;
			while (check == true) {
				System.out.println("Enter the Email");
				username = input.next();
				if (Validation.isValidEmail(username)) {
					check = false;
				} else {
					System.err.println("Invalid format (valid format abc@xyz.com)");
				}
			}
			check = true;
			while (check == true) {
				System.out.println("Enter the password");
				password = input.next();
				if (Validation.validPassword(password)) {
					check = false;
				} else {
					System.err.println("Invalid format(\"Invalid format(Atleast 5 letter "
							+ "one uppercase,one lowercase," + "one number then atleast a special character)");
				}
			}
			if (username.equals("Rohan@gmail.com") && password.equals("Ramubb143@")) {
				System.out.println("You are sucessfully logined");
				check = true;
				flag = false;
			} else {
				System.err.println("Sorry Your Not Admin");
			}
		}
		while (true) {
			while (status == true) {
				System.out.println("-------------WELCOME ADMIN-------------");
				System.out.println("Press 1 To Add New Client Details");
				System.out.println("Press 2 Get All Client Details");
				System.out.println("press 3 Acess Land details");
				System.out.println("press 4 to Back");
				System.out.println("Enter Your Choice");
				choice = input.next();
				switch (Validation.isNumber2(choice)) {
				case 1:
					flag = true;
					Client bean = new Client();
					System.err.println("------Create a New Client---------");
					while (flag == true) {
						System.out.println("Enter the Client UserName");
						String username = input.next();
						if (Validation.isValidEmail(username)) {
							bean.setUsername(username);
							flag = false;
						} else {
							System.err.println("Invalid format(valid format abc@xyz.com)");
						}
					}
					flag = true;
					while (flag == true) {
						System.out.println("Enter the Password");
						String password = input.next();
						if (Validation.validPassword(password)) {
							bean.setPassword(password);
							flag = false;
						} else {
							System.err.println(
									"Invalid format(Atleast 5 letter one uppercase,one lowercase,one number then atleast a special character");
						}
					}
					try {
						if (serviceClient.add(bean)) {
							System.out.println("Successfully created");
						} else {
							System.err.println("client Already Exist");
						}
					} catch (ForestManagementException e) {
						System.err.println(e.getMessage());
					}
					break;
				case 2:
					try {
						if (serviceClient.getClient() != null) {
							System.out.println(serviceClient.getClient());
						} else {
							System.err.println("Empty");
						}
					} catch (ForestManagementException e) {
						System.err.println(e.getMessage());
					}
					break;
				case 3:
					LandController.main(args);
					break;
				case 4:
					return;
				default:
					System.err.println("Invalid choice please select the above option");

				} // end of main while loop
			} // end of customer
		}
	}
}

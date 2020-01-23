package com.capgemini.forestmanagement.controller;

import java.util.Scanner;

import com.capgemini.forestmanagement.bean.Client;
import com.capgemini.forestmanagement.exception.ForestManagementException;
import com.capgemini.forestmanagement.validation.Validation;

public class ClientController {
	

	public static void main(String args[]) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		Client controller = null;
		boolean flag = true;
		boolean status = true;
		System.out.println("--------Please Login ------------");
		while (flag == true) {
			controller = new Client();
			status = true;
			while (status == true) {
				System.out.println("Enter the UserEmail");
				String username = input.next();
				if (Validation.isValidEmail(username)) {
					controller.setUsername(username);
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
					controller.setPassword(password);
					status = false;
				} else {
					System.err.println("Invalid format");
				}
			}
			try {
				if (AdminController.serviceClient.specificClient(controller)) {
					System.out.println("You are sucessfully logined");
					status = true;
					flag = false;
				} else {
					System.err.println("Your Account Does Not Exist Please Account");
				}
			} catch (ForestManagementException e) {
				System.err.println(e.getMessage());
			}
		}
		while (true) {
			String choice;
			System.out.println("------------Welcome Client---------");
			while (true) {
				System.out.println("press 1 to Delete the Account");
				System.out.println("Press 2 to Modify the Password");
				System.out.println("Press 3 to Display contract Operation");
				System.out.println("Press 4 to see the availability of Product");
				System.out.println("Press 5 to Back");
				System.out.println("Enter Your Choice");
				choice = input.next();
				switch (Validation.isNumber2(choice)) {
				case 1:
					flag = true;
					controller = new Client();
					System.out.println("For Confirmation purpose please");
					while (flag == true) {
						System.out.println("Enter the Username");
						String username = input.next();
						if (Validation.isValidEmail(username)) {
							controller.setUsername(username);
							flag = false;
						} else {
							System.err.println("Invalid format");
						}
					}
					flag = true;
					while (flag == true) {
						System.out.println("Enter the Password");
						String password = input.next();
						if (Validation.validPassword(password)) {
							controller.setPassword(password);
							flag = false;
						} else {
							System.err.println("Invalid Password");
						}
					}
					flag = true;
					try {
						if (AdminController.serviceClient.delete(controller)) {
							System.out.println("Deleted successfully");
							return;
						} else {
							System.err.println("Not Exist");
						}
					} catch (ForestManagementException e) {
						System.err.println(e.getMessage());
					}
					break;
				case 2:
					flag = true;
					String newPassword = null, oldPassword = null;
					controller = new Client();
					System.out.println("For Confirmation purpose please");
					flag = true;
					while (flag == true) {
						System.out.println("Enter the Password");
						oldPassword = input.next();
						if (Validation.validPassword(oldPassword)) {
							flag = false;
						} else {
							System.err.println("Invalid Password");
						}
					}
					flag = true;
					while (flag == true) {
						System.out.println("Enter the New Password");
						newPassword = input.next();
						if (Validation.validPassword(newPassword)) {
							flag = false;
						} else {
							System.err.println("Invalid Password");
						}
					}
					flag = true;
					try {
						if (AdminController.serviceClient.modify(newPassword, oldPassword)) {
							System.out.println("true");
							return;
						}
					} catch (ForestManagementException e) {
						System.err.println(e.getMessage());
					}
					break;
				case 3:
					ContractController.main(args);
					break;
				case 4:
					try {
						if (AdminController.productServices.getAllProduct().isEmpty())
							System.out.println("Currently No product is Avaliable ");
						else
							System.out.println(AdminController.productServices.getAllProduct());

					} catch (ForestManagementException e) {
						System.err.println(e.getMessage());
					}
					break;
				case 5:
					return;
				default:
					System.err.println("Please Enter The Above Choices Only");
				}
			}
		}
	}// end of constructor
}// end of class
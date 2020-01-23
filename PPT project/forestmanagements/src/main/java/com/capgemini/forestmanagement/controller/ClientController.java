package com.capgemini.forestmanagement.controller;

import java.util.Scanner;

import com.capgemini.forestmanagement.bean.Account;
import com.capgemini.forestmanagement.factory.AdminFactory;
import com.capgemini.forestmanagement.service.AdminServices;
import com.capgemini.forestmanagement.validation.Validation;
public class ClientController {
	public static void main(String args[])
	{
		AdminServices servicesAdmin = AdminFactory.instanceOfAdminServices();
		boolean status=true;
		Account account=null;
		@SuppressWarnings("resource")
		Scanner input=new Scanner(System.in);
		boolean flag=true;
		while (flag == true) {
			System.out.println("------------Welcome Client --------");
			System.out.println("------------Login First-------------");
			account = new Account();
			status = true;
			String username=null;
			String password=null;
			while (status == true) {
				System.out.println("Enter the Email");
				username = input.next();
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
				password = input.next();
				if (Validation.validPassword(password)) {
					account.setPassword(password);
					status = false;
				} else {
					System.err.println("Invalid format");
				}
			}
			status=true;
			if(servicesAdmin.getAccount(account.getUsername(), account.getPassword()))
			{
				flag =false;
				System.out.println("sucessfully logined");
			}
			else
			{
				System.err.println("Account not present");
				System.err.println("Please Account Admin");
			}
		}
		status=true;
		while (status == true) {
			String choice;
			System.out.println("------------Welcome Client---------");
			System.out.println("press 1 to Delete the Account");
			System.out.println("Press 2 to Modify the Password");
			System.out.println("Press 3 to Display Contract Operation");
			System.out.println("Press 4 to exist");
			System.out.println("Enter Your Choice");
			choice = input.next();
			switch (Validation.isNumber2(choice)) {
			case 1:
				status= true;
				String username=null;
				String password=null;
				account=new Account();
				while (status == true) {
					System.out.println("Enter the Email");
					username = input.next();
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
					password = input.next();
					if (Validation.validPassword(password)) {
						account.setPassword(password);
						status = false;
					} else {
						System.err.println("Invalid format");
					}
				}
				if(servicesAdmin.deleteAccount(account))
				{
					System.out.println("Deleted sucessfully");
					return;
				}
				else
				{
					System.out.println("Account is not Present");
				}
				break;
			case 2:
				status = true;
				String oldPassword=null;
				String newPassword=null;
				account=new Account();
				status = true;
				while (status == true) {
					System.out.println("Enter the  old password");
					oldPassword = input.next();
					if (Validation.validPassword(oldPassword)) {
						status = false;
					} else {
						System.err.println("Invalid format");
					}
				}
				status = true;
				while (status == true) {
					System.out.println("Enter the new password");
					newPassword = input.next();
					if (Validation.validPassword(newPassword)) {
						status = false;
					} else {
						System.err.println("Invalid format");
					}
				}
				if(servicesAdmin.updateAccount(newPassword,oldPassword))
				{
					System.out.println("Updated Password");
					return;
				}
				else
				{
					System.out.println("Error..........");
				}
				break;
			case 3:
				ContractController.main(args);
				break;
			case 4:
				return;
			default:
				System.out.println("please enter the above choices");
			}
		}
	}
}

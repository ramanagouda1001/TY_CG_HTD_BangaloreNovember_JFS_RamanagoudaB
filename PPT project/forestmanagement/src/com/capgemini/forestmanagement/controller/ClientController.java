package com.capgemini.forestmanagement.controller;

import java.util.Scanner;

import com.capgemini.forestmanagement.bean.Client;
import com.capgemini.forestmanagement.factory.ClientFactory;
import com.capgemini.forestmanagement.factory.ProductFactory;
import com.capgemini.forestmanagement.service.ClientServices;
import com.capgemini.forestmanagement.service.ProductServices;
import com.capgemini.forestmanagement.validation.Validation;

public class ClientController {
	public static ClientServices services = ClientFactory.instanceOfClientServicesImpl();
	public static ProductServices productServices=ProductFactory.instanceOfProductServicesImpl();
	public ClientController() {
		Scanner in = new Scanner(System.in);
		Client controller=null;
		char flag = 'y';
		char ch = 'y';
		char ch2 = 'y';
		int i=0;
		System.out.println("--------Please Login ------------");
		while (flag == 'y') {
			controller = new Client();
			ch='y';
			while (ch == 'y') {
				System.out.println("Enter the UserName");
				String username = in.next();
				if (Validation.isValidEmail(username)) {
					controller.setUsername(username);
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
					controller.setPassword(password);
					ch = 'n';
				} else {
					System.err.println("Invalid format");
				}
			}
			if (controller.getUsername().equals("Rohan@gmail.com") && controller.getPassword().equals("Ramubb143@")) {
				System.out.println("You are sucessfully logined");
				ch = 'y';
				flag = 'n';
			} else {
				i++;
				System.err.println("Invalid Username and Password");
				if(i==2)
				{
					System.err.println("You have been logged out Contact Admin\n\n");
					return;
				}
			}
		}
		while (true) {
			String choice;
			int choice1 = 0;
			ch2 = 'y';
			System.out.println("------------Welcome Client---------");
			while (ch2 == 'y') {
				System.out.println("press 1 to Delete the Account");
				System.out.println("Press 2 to Modify the Password");
				System.out.println("Press 3 to Display contract Operation");
				System.out.println("Press 4 to see the availability of Product");
				System.out.println("Press 5 to exist");
				System.out.println("Enter Your Choice");
				choice = in.next();
				if (Validation.isNumber(choice)) {
					choice1 = Validation.isNumber2(choice);
					if (choice1 == 1 || choice1 == 2 || choice1 == 3 || choice1 == 4||choice1==5) {
						ch2 = 'n';
					} else {
						System.err.println("plz select above option ");
					}
				} else {
					System.err.println("Invalid Format Please Enter the Number only");
				}
			}
			switch (choice1) {
			case 1:
					flag='y';
					controller=new Client();
					System.out.println("For Confirmation purpose please");
					while(flag=='y')
					{
						System.out.println("Enter the Username");
						String username=in.next();
						if(Validation.isValidEmail(username))
						{
							controller.setUsername(username);
							flag='n';
						}
						else
						{
							System.err.println("Invalid format");
						}
					}
					flag='y';
					while(flag=='y')
					{
						System.out.println("Enter the Password");
						String password=in.next();
						if(Validation.validPassword(password))
						{
							controller.setPassword(password);
							flag='n';
						}
						else
						{
							System.err.println("Invalid Password");
						}
					}
					flag='y';
					if(services.delete(controller))
					{
						System.out.println("Deleted successfully");
						return;
					}
					else
					{
						System.err.println("Not Exist");
					}
				break;
			case 2:
				flag='y';
				String newPassword = null,oldPassword = null;
				controller=new Client();
				System.out.println("For Confirmation purpose please");
				flag='y';
				while(flag=='y')
				{
					System.out.println("Enter the Password");
					oldPassword=in.next();
					if(Validation.validPassword(oldPassword))
					{
						flag='n';
					}
					else
					{
						System.err.println("Invalid Password");
					}
				}
				flag='y';
				while(flag=='y')
				{
					System.out.println("Enter the New Password");
					newPassword=in.next();
					if(Validation.validPassword(newPassword))
					{
						flag='n';
					}
					else
					{
						System.err.println("Invalid Password");
					}
				}
				flag='y';
				if(services.modify(newPassword, oldPassword))
				{
					System.out.println("true");
					return;
				}
				break;
			case 3:
				ContractController obj=new ContractController();
				break;
			case 4:
				if(productServices.getAllProduct()!=null)
					System.out.println("Currently No product is Avaliable ");
				else
					System.out.println(productServices.getAllProduct());
				break;
			case 5:
				System.exit(0);
				break;
			default:
				System.out.println("plz enter the above choices");
			}
		}
	}// end of constructor
}// end of class

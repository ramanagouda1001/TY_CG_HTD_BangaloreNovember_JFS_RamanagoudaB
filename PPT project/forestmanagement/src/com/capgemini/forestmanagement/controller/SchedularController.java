package com.capgemini.forestmanagement.controller;

import java.util.List;
import java.util.Scanner;

import com.capgemini.forestmanagement.bean.Contract;
import com.capgemini.forestmanagement.bean.Product;
import com.capgemini.forestmanagement.factory.ContractFactory;
import com.capgemini.forestmanagement.factory.ProductFactory;
import com.capgemini.forestmanagement.service.ContractServices;
import com.capgemini.forestmanagement.service.ProductServices;
import com.capgemini.forestmanagement.validation.Validation;

public class SchedularController {
	public static ProductServices productServices = ProductFactory.instanceOfProductServicesImpl();
	public static ContractServices contractServices = ContractFactory.insatnceOfContractServicesImpl();
	public SchedularController()
	{
		Scanner in = new Scanner(System.in);
		char ch = 'y';
		char ch2 = 'y';
		char flag='y';
		while (flag == 'y') {
			String password=null;
			String username=null;
			Product product=new Product();
			ch = 'y';
			while (ch == 'y') {
				System.out.println("Enter the Email");
				username = in.next();
				if (Validation.isValidEmail(username)) {

					ch = 'n';
				} else {
					System.err.println("Invalid format");
				}
			}
			ch = 'y';
			while (ch == 'y') {
				System.out.println("Enter the password");
				password = in.next();
				if (Validation.validPassword(password)) {
					ch = 'n';
				} else {
					System.err.println("Invalid format");
				}
			}
			if (username.equals("Schedular@gmail.com") && password.equals("Schedularbb143@")) {
				System.out.println("You are sucessfully logined");
				ch = 'y';
				flag = 'n';
			} else {
				System.err.println("Sry your not admin");
			}
		}
		while(true)
		{
			ch2 = 'y';
			int choice = 0;
			while (ch2 == 'y') {
				System.out.println("---------Welcome product-------------");
				System.out.println("1.Access all product");
				System.out.println("2.Acesss all contract");
				System.out.println("enter the choice");
				choice = in.nextInt();
				if (choice == 1 || choice == 2) {
					ch2 = 'n';
				} else {
					System.err.println("plz select above option ");
				}
				switch(choice)
				{
				case 1:
					List<Product> list=productServices.getAllProduct();
					if(list!=null)
					{
						System.out.println(list);
					}
					else
					{
						System.out.println("Empty");
					}
				break;
				case 2:
					List<Contract> listContract=contractServices.contractDetail();
					if(listContract!=null)
					{
						System.out.println(listContract);
					}
					else
					{
						System.out.println("empty");
					}
				break;
				case 3:
					return;
				default:
				System.out.println("invalid");
				}
			}
		}

	}
	
}

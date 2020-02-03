package com.cagemini.forestmanagement.controller;

import java.util.List;
import java.util.Scanner;

import com.cagemini.forestmanagement.bean.Account;
import com.cagemini.forestmanagement.bean.Contract;
import com.cagemini.forestmanagement.bean.Product;
import com.cagemini.forestmanagement.factory.AdminFactory;
import com.cagemini.forestmanagement.factory.ContractFactory;
import com.cagemini.forestmanagement.factory.ProductFactory;
import com.cagemini.forestmanagement.service.AdminServices;
import com.cagemini.forestmanagement.service.ContractServices;
import com.cagemini.forestmanagement.service.ProductServices;
import com.cagemini.forestmanagement.validation.Validation;

public class SchedularController {
	public static void main(String args[]){
		ProductServices productServices = ProductFactory.instanceOfProductServicesImpl();
		ContractServices ContractServices = ContractFactory.insatnceOfServicesImpl();
		AdminServices servicesAdmin = AdminFactory.instanceOfAdminServices();
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		boolean status = true;
		boolean flag=true;
		Account account;
		while (flag == true) {
			System.out.println("------------Welcome Schedular --------");
			System.out.println("------------Login First-------------");
			account = new Account();
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
			if(servicesAdmin.getAccountSchedular(username, password))
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
		while(true)
		{
			System.out.println("1.Details of Product");
			System.out.println("2.Details of Contract");
			System.out.println("3.Schedular");
			String choice=input.next();
			switch(Validation.isNumber2(choice))
			{
				case 1:
					List<Product> list=productServices.getAllProduct();
					if(list==null)
					{
						System.out.println("No Product items is present");
						System.out.println("Product Administration");
					}
					else
					{
						System.out.println(list);
					}
				break;
				case 2:
					List<Contract> contractList=ContractServices.contractDetail();
					if(contractList==null)
					{
						System.out.println("No Contract is present");
						System.out.println("Contact Client");
					}
					else
					{
						System.out.println(contractList);
					}
				break;
				case 3:
					status=true;
					int contract_number=0;
					Contract contract=null;
					Product product=null;
					while(status==true)
					{
						System.out.println("---------------------");
						System.out.println("Enter the Contract number(Unquie 4 Digits are allowed)");
						String contractString = input.next();
						if (Validation.validateLength(contractString)) {
							contract_number=Integer.parseInt(contractString);
							try {
							contract=ContractServices.search(contract_number);
							status=false;
							} catch (Exception e) {
								System.err.println("Contract Does not Exist");
							}
						} else {
							System.err.println("Only 4 digit Number is allowed ");
						}
					}
					product=productServices.searchProduct(contract.getProductId());
					if(contract.getQuality()>product.getProductQuality())
					{
						System.out.println(product);
						System.out.println("Contract Cannot be Issued as Demand="+contract.getQuality()+" is greater than stock="
								+ product.getProductQuality());
					}
					else
					{
						System.out.println("ISSUED SUCCESSFULLY AS Demand"+contract.getQuality()+" is less than stock="
															+ product.getProductQuality());
					}
					break;
				default:System.err.println("please select the above option");
			}
		}
		}
	}	

package com.capgemini.forestmanagement.controller;

import java.util.List;
import java.util.Scanner;

import com.capgemini.forestmanagement.bean.Contract;
import com.capgemini.forestmanagement.bean.Product;
import com.capgemini.forestmanagement.exception.ForestManagementException;
import com.capgemini.forestmanagement.validation.Validation;

public class SchedularController {
	public static void main(String args[]) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		boolean status = true;
		boolean flag = true;
		String choice;
		while (flag == true) {
			String password = null;
			String username = null;
			status = true;
			while (status == true) {
				System.out.println("Enter the Email");
				username = input.next();
				if (Validation.isValidEmail(username)) {

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
					status = false;
				} else {
					System.err.println("Invalid format");
				}
			}
			if (username.equals("Schedular@gmail.com") && password.equals("Schedularbb143@")) {
				System.out.println("You are sucessfully logined");
				status = true;
				flag = false;
			} else {
				System.err.println("Sry your not admin");
			}
		}
		while (true) {
			System.out.println("---------Welcome product-------------");
			System.out.println("1.Access all product");
			System.out.println("2.Acesss all contract");
			System.out.println("3.Enter the Contract number");
			System.out.println("enter the choice");
			choice = input.next();
			switch (Validation.isNumber2(choice)) {
			case 1:
				List<Product> list = AdminController.productServices.getAllProduct();
				try {
					if (list != null) {
						System.out.println(list);
					} else {
						System.out.println("Empty");
					}

				} catch (ForestManagementException e) {
					System.err.println(e.getMessage());
				}
				break;
			case 2:
				List<Contract> listContract = AdminController.contractServices.contractDetail();
				try {
					if (listContract != null) {
						System.out.println(listContract);
					} else {
						System.out.println("empty");
					}
				} catch (ForestManagementException e) {
					System.err.println(e.getMessage());
				}
				break;
			case 3:
				flag=true;
				int contractNumber = 0;
				Contract contract_object=null;
				while (flag == true) {
					System.out.println("---------------------");
					System.out.println("Enter the Contract number(Unquie 4 Digits are allowed)");
					String contractString = input.next();
					if (Validation.validateLength(contractString)) {
						contractNumber = Integer.parseInt(contractString);
						flag = false;
						try {
							contract_object=AdminController.contractServices.search(contractNumber);
						}
						catch (ForestManagementException e) {
							System.err.println(e.getMessage());
						}
						if(contract_object==null)
						{
							System.err.println("Contract Details are not present");
						}
						else
						{
							Product product_object=AdminController.productServices.searchProduct(contract_object.getProductId());
							if(contract_object.getQuality()>=product_object.getProductQuality())
							{
								System.err.println("Contract Cannot Be Issued As Required is Less and Available Quality");
							}
							else
							{
								System.out.println("Contract can be Assued");
							}
						}
					} else {
						System.err.println("Only 4 digit Number is allowed ");
					}
				}
			break;
			default:
				System.out.println("invalid");
			}
		}
	}
}

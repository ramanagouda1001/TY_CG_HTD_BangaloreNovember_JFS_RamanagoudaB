package com.capgemini.forestmanagement.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.capgemini.forestmanagement.bean.Contract;
import com.capgemini.forestmanagement.bean.Product;
import com.capgemini.forestmanagement.exception.ForestManagementException;
import com.capgemini.forestmanagement.factory.ContractFactory;
import com.capgemini.forestmanagement.factory.ProductFactory;
import com.capgemini.forestmanagement.service.ContractServices;
import com.capgemini.forestmanagement.service.ProductServices;
import com.capgemini.forestmanagement.validation.Validation;

public class ContractController {
	public static void main(String args[]) {
		ContractServices services = ContractFactory.insatnceOfServicesImpl();
		ProductServices productServices = ProductFactory.instanceOfProductServicesImpl();
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		boolean flag = true;
		while (true) {
			String choice;
			System.out.println("------------Welcome contract---------");
			System.out.println("Press 1 for Add the Contract Details");
			System.out.println("Press 2 for Delete the Contract Details");
			System.out.println("Press 3 for Display Product Details");
			System.out.println("press 4 for Exit");
			System.out.println("Enter Your Choice");
			choice = input.next();
			switch (Validation.isNumber2(choice)) {
			case 1:
				Contract con = new Contract();
				while (flag == true) {
					System.out.println("---------------------");
					System.out.println("Enter the Contract number(Unquie 4 Digits are allowed)");
					String contractString = input.next();
					if (Validation.validateLength(contractString)) {
						int contractNumber = Integer.parseInt(contractString);
						con.setContractNo(contractNumber);
						flag = false;
					} else {
						System.err.println("Only 4 digit Number is allowed ");
					}
				}
				flag = true;
				while (flag == true) {
					System.out.println("Enter the CustomerID (Unquie 4 Digits are allowed)");
					String customerString = input.next();
					if (Validation.validateLength(customerString)) {
						int customerNumber = Integer.parseInt(customerString);
						con.setCustomerId(customerNumber);
						flag = false;
					} else {
						System.err.println("Only 4 digit Number is allowed ");
					}
				}
				flag = true;
				while (flag == true) {
					System.out.println("Enter the  product ID(Only 2 Alphabets followed By 2 Digits)");
					String productString = input.next();
					if (Validation.validateAlpaLength(productString)) {
						Product product = productServices.searchProduct(productString);
						if (product == null) {
							System.err.println("PRODUCT DOES NOT EXIST");
						} else {
							con.setProductId(productString);
							flag = false;
						}
					} else {
						System.err.println("Invalid format(XX00,.. allowed)");
					}
				}
				flag = true;
				while (flag == true) {
					System.out.println("Enter the  Vechicle Transport Number(Unquie 4 Digits are allowed)");
					String transportString = input.next();
					if (Validation.validateLength((transportString))) {
						int transportNumber = Integer.parseInt(transportString);
						con.setTransportId(transportNumber);
						flag = false;
					} else {
						System.err.println("Only 4 digit Number is allowed ");
					}
				}
				flag = true;
				while (flag == true) {
					System.out.println("enter the date dd/mm/yyyy");
					String date = input.next();
					String regex = "^(3[01]|[12][0-9]|0[1-9])/(1[0-2]|0[1-9])/[0-9]{4}$";
					Pattern pattern = Pattern.compile(regex);
					Matcher matcher = pattern.matcher(date);
					if (matcher.matches()) {
						if (Validation.validateMonth(date)) {
							SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
							Date todayDate = new Date();
							Date inputDate = null;
							try {
								inputDate = formatter.parse(date);
							} catch (ParseException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							if (inputDate.after(todayDate)) {
								con.setDeliveryDate(date);
								con.setDeliveryDay(Validation.validateWeeks(date));
								flag = false;
							} else if (inputDate.before(todayDate)) {
								System.out.println();
								System.err.print("plz enter date greater than todays ");
								System.out.println("Todays date is=" + todayDate);
							} else if (inputDate.equals(todayDate)) {
								con.setDeliveryDate(date);
								con.setDeliveryDay(Validation.validateWeeks(date));
								flag = false;
							}
						} else {
							System.err.println("The day Does not Exist in this month");
						}
					} else {
						System.out.println();
						System.err.println("Invliad format enter as dd/mm/yyyy");
					}
				}
				flag = true;
				while (flag == true) {
					System.out.println("Enter the Quantity");
					String qualityString = input.next();
					if (Validation.isNumber(qualityString)) {
						int qualityNumber = Integer.parseInt(qualityString);
						con.setQuality(qualityNumber);
						flag = false;
					} else {
						System.err.println("Plz enter the quantity");
					}
				}
				try {
					if (services.addContract(con)) {
						System.out.println("--------Sucessfully Added------------");
					} else {
						System.err.println("Already present");
					}
				} catch (ForestManagementException e) {
					System.err.println(e.getMessage());
				}
				flag = true;
				break;
			case 2:
				Contract con1 = new Contract();
				System.out.println("enter the Contract number");
				con1.setContractNo(input.nextInt());
				try {
					if (services.deleteContact(con1.getContractNo()))
						System.out.println("--------------sucessfully deleted------------");
					else
						System.err.println("Not Present");

				} catch (ForestManagementException e) {
					System.err.println(e.getMessage());
				}
				break;
			case 3:
				List<Product> list=productServices.getAllProduct();
				if(list.isEmpty())
				{
					System.err.println("EMPTY..................");
				}
				else
				{
					System.out.println(list);
				}
				break;
			case 4:
				return;
			default:
				System.out.println("plz enter the above choices");
			}
		}
	}
}

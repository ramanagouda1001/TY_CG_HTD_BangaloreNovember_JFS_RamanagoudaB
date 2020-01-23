package com.capgemini.forestmanagement.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.capgemini.forestmanagement.bean.Contract;
import com.capgemini.forestmanagement.factory.ContractFactory;
import com.capgemini.forestmanagement.service.ContractServices;
import com.capgemini.forestmanagement.validation.Validation;

public class ContractController {
	public static ContractServices services = ContractFactory.insatnceOfContractServicesImpl();
	public static void Contractcontroller() {
		Scanner in = new Scanner(System.in);
		char ch = 'y';
		char ch2 = 'y';
		while ((ch == 'y') || ch == 'Y') {
			char flag = 'y';
			String choice;
			int choice1 = 0;
			ch2='y';
			while (ch2 == 'y') {
				System.out.println("------------Welcome contract---------");
				System.out.println("Press 1 for Add the Contract Details");
				System.out.println("Press 2 for Delete the Contract Details");
				System.out.println("Press 3 for Display Specific Contract Details");
				System.out.println("press 4 for Exit");
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
				Contract con = new Contract();
				while (flag == 'y') {
					System.out.println("---------------------");
					System.out.println("Enter the Contract number(Unquie 4 Digits are allowed)");
					String contractString = in.next();
					if (Validation.validateLength(contractString)) {
						int contractNumber = Integer.parseInt(contractString);
						con.setContract_no(contractNumber);
						flag = 'n';
					} else {
						System.err.println("Only 4 digit Number is allowed ");
					}
				}
				flag = 'y';
				while (flag == 'y') {
					System.out.println("Enter the  product ID(Only 2 Alphabets followed By 2 Digits)");
					String productString = in.next();
					if (Validation.validateAlpaLength(productString)) {

						con.setProduct_id(productString);
						flag = 'n';
					} else {
						System.err.println("Invalid format(XX00,.. allowed)");
					}
				}
				flag = 'y';
				while (flag == 'y') {
					System.out.println("enter the date dd/mm/yyyy");
					String date = in.next();
					String regex = "^(3[01]|[12][0-9]|0[1-9])/(1[0-2]|0[1-9])/[0-9]{4}$";
					Pattern pattern = Pattern.compile(regex);
					Matcher matcher = pattern.matcher(date);
					if (matcher.matches()) {
						if (Validation.validateMonth(date)) {
							SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
							Date Todaydate = new Date();
							String todayAsString = formatter.format(Todaydate);
							if (date.compareTo(todayAsString) > 0) {
								con.setDelivery_date(date);
								flag = 'n';
							} else if (date.compareTo(todayAsString) < 0) {
								System.out.println();
								System.err.print("plz enter date greater than todays ");
								System.out.println("Todays date is=" + Todaydate);
							} else if (date.compareTo(todayAsString) == 0) {
								con.setDelivery_date(date);
								flag = 'n';
							}
						} else {
							System.err.println("The day Does not Exist in this month");
						}
					} else {
						System.out.println();
						System.err.println("Invliad format enter as dd/mm/yyyy");
					}
				}
				flag = 'y';
				while (flag == 'y') {
					System.out.println("Enter the Deliver day");
					String week = in.next();
					if (Validation.validateWeeks(week)) {
						if (Validation.validateWeeks(week)) {
							con.setDelivery_day(week);
							flag = 'n';
						} else {
							System.err.println("Invalid day");
						}
					} else {
						System.err.println("Invalid format");
						flag = 'y';
					}
				}

				flag = 'y';
				while (flag == 'y') {
					System.out.println("Enter the Quantity");
					String qualityString = in.next();
					if (Validation.isNumber(qualityString)) {
						int qualityNumber = Integer.parseInt(qualityString);
						con.setQuality(qualityNumber);
						flag = 'n';
					} else {
						System.err.println("Plz enter the quantity");
					}
				}
				if (services.addContract(con)) {
					System.out.println("--------Sucessfully Added------------");
				} else {
					System.err.println("Already present");
				}
				flag = 'y';
				break;
			case 2:
				Contract con1 = new Contract();
				System.out.println("enter the Contract number");
				con1.setContract_no(in.nextInt());
				if (services.deleteContact(con1.getContract_no()))
					System.out.println("--------------sucessfully deleted------------");
				else
					System.err.println("Not Present");
				break;
			case 3:
				if (services.contractDetail() == null) {
					System.out.println("Empty");
				} else {
					System.out.println(services.contractDetail());
				}
				break;
			case 4:
				return;
			default:
				System.out.println("plz enter the above choices");
			}
			flag = 'y';
		}
	}
}

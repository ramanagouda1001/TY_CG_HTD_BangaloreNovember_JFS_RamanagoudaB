package com.capgemini.forestmanagement.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.capgemini.forestmanagement.bean.Admin;
import com.capgemini.forestmanagement.bean.Product;
import com.capgemini.forestmanagement.factory.ProductFactory;
import com.capgemini.forestmanagement.service.ProductServices;
import com.capgemini.forestmanagement.validation.Validation;


public class ProductController {
	public static ProductServices services = ProductFactory.instanceOfProductServicesImpl();
	public ProductController() {
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
			if (username.equals("Product@gmail.com") && password.equals("Productbb143@")) {
				System.out.println("You are sucessfully logined");
				ch = 'y';
				flag = 'n';
			} else {
				System.err.println("Sry your not admin");
			}
		}
		while ((ch == 'y') || ch == 'Y') {
			ch2 = 'y';
			int choice = 0;
			while (ch2 == 'y') {
				System.out.println("---------Welcome product-------------");
				System.out.println("Press 1 to Add Product Details");
				System.out.println("Press 2 to Delete Product Details");
				System.out.println("Press 3 to Access the Product Details");
				System.out.println("Press 4 to Modify the Product Details");
				System.out.println("press 5 to Exit");
				System.out.println("enter the choice");
				choice = in.nextInt();
				if (choice == 1 || choice == 2 || choice == 3 || choice == 4 || choice == 5) {
					ch2 = 'n';
				} else {
					System.err.println("plz select above option ");
				}
			}
			char ch3 = 'y';
			switch (choice) {
			case 1:
				Product proobj = new Product();
				ch3 = 'y';
				while (ch3 == 'y') {
					System.out.println("Enter the  product ID(Only 2 Alphabets followed By 2 Digits)");
					String proString = in.next();
					if (Validation.validateAlpaLength(proString)) {
						proobj.setProduct_id(proString);
						ch3 = 'n';
					} else {
						System.err.println("Invalid format(XX00,.. allowed)");
					}
				}
				ch3 = 'y';
				while (ch3 == 'y') {
					System.out.println("Enter the product name");
					String product_name = in.next();
					if (product_name.length() >= 3 && product_name.length() <= 13) {
						if (Validation.isString(product_name)) {
							proobj.setProduct_name(product_name);
							ch3 = 'n';
						} else {
							System.err.println("invalid format");
							ch3 = 'y';
						}
					} else {
						System.err.println("Minimum Character length is 3 and Maximam is 13");
					}
				}
				ch3 = 'y';
				while (ch3 == 'y') {
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
								proobj.setProduct_date(date);
								ch3 = 'n';
							} else if (date.compareTo(todayAsString) < 0) {
								System.out.println();
								System.err.print("plz enter date greater than todays ");
								System.out.println("Todays date is=" + Todaydate);
							} else if (date.compareTo(todayAsString) == 0) {
								proobj.setProduct_date(date);
								ch3 = 'n';
							}
						} else {
							System.err.println("The day Does not Exist in this month");
						}
					} else {
						System.out.println();
						System.err.println("Invliad format enter as dd/mm/yyyy");
					}
				}
				break;
			case 2:
				Product proobj1 = new Product();
				ch3 = 'y';
				while (ch3 == 'y') {
					System.out.println("Enter the  product ID(Only 2 Alphabets followed By 2 Digits)");
					String proString = in.next();
					if (Validation.validateAlpaLength(proString)) {
						proobj1.setProduct_id(proString);
						if (services.deleteProduct(proobj1.getProduct_id())) {
							System.out.println("--------Sucessfully Deleted----------");
						} else {
							System.err.println("Does not exist");
						}
						ch3 = 'n';
					} else {
						System.err.println("Invalid format(XX00,.. allowed)");
					}
				}
				ch3 = 'y';
				break;
			case 3:
				Product proobj2 = new Product();
				ch3 = 'y';
				while (ch3 == 'y') {
					System.out.println("Enter the  product ID(Only 2 Alphabets followed By 2 Digits)");
					String proString = in.next();
					if (Validation.validateAlpaLength(proString)) {
						proobj2.setProduct_id(proString);
						ch3 = 'n';
						System.out.println(services.searchProduct(proobj2.getProduct_id()));
					} else {
						System.err.println("Invalid format(XX00,.. allowed)");
					}
				}
				ch3 = 'y';
				break;
			case 4:
				String proString = null;
				int product_id = 0;
				while (ch3 == 'y') {
					System.out.println("Enter the  product ID to Modify(Only 2 Alphabets followed By 2 Digits)");
					proString = in.next();
					if (Validation.validateAlpaLength(proString)) {
						ch3 = 'n';
					} else {
						System.err.println("Invalid format(XX00,.. allowed)");
					}
				}
				ch3 = 'y';
				System.out.println("what You want to modify");
				System.out.println("Press 1 to modify the Product Name");
				System.out.println("Press 2 to Modify the Product Date");
				int choice11 = in.nextInt();
				switch (choice11) {
				case 1:
					ch3 = 'y';
					while (ch3 == 'y') {
						System.out.println("Enter the product name");
						String product_name = in.next();
						if (product_name.length() >= 3 && product_name.length() <= 13) {
							if (Validation.isString(product_name)) {
								if (services.modifyProductName(proString, product_name)) {
									System.out.println("--------Upadted successfully-------");
								} else {
									System.err.println("error");
								}
								ch3 = 'n';
							} else {
								System.err.println("invalid format");
								ch3 = 'y';
							}
						} else {
							System.err.println("Minimum Character length is 3 and Maximam is 13");
						}
					}
					ch3 = 'y';
					break;
				case 2:
					ch3 = 'y';
					while (ch3 == 'y') {
						System.out.println("Enter the date  in dd/mm/yyyy Format");
						String product_date = in.next();
						String regex = "^(3[01]|[12][0-9]|0[1-9])/(1[0-2]|0[1-9])/[0-9]{4}$";
						Pattern pattern = Pattern.compile(regex);
						Matcher matcher = pattern.matcher(product_date);
						if (matcher.matches()) {
							SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
							Date Todaydate = new Date();
							String todayAsString = formatter.format(Todaydate);
							if (product_date.compareTo(todayAsString) > 0) {
								if (services.modifyProductDate(proString, product_date))
									System.out.println("updtaed");
								else
									System.out.println("error");
								ch3 = 'n';
							} else if (product_date.compareTo(todayAsString) < 0) {
								System.out.println();
								System.err.print("plz enter date greater than todays  ");
								System.out.println("Todays date is=" + Todaydate);
							} else if (product_date.compareTo(todayAsString) == 0) {
								if (services.modifyProductDate(proString, product_date))
									System.out.println("updtaed");
								else
									System.out.println("error");
								ch3 = 'n';
							}
						} else {
							System.out.println();
							System.err.println("Invliad format enter as dd/mm/yyyy");
						}
					}
					break;
				}
				break;
				
			}
			ch3 = 'y';
			while (ch3 == 'y') {
				System.out.println("DO YOU WANT TO COUNTINUE Y/N?");
				ch = in.next().charAt(0);
				if (ch == 'y' || ch == 'n' || ch == 'Y' || ch == 'N') {
					ch3 = 'n';
				} else {
					System.err.println("plz Enter y/n ");
				}
			}
		} // end of constructor
	}
}// end of class

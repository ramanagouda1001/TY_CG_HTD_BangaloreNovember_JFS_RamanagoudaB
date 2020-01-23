package com.capgemini.forestmanagement.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.capgemini.forestmanagement.bean.Product;
import com.capgemini.forestmanagement.exception.ForestManagementException;
import com.capgemini.forestmanagement.validation.Validation;


public class ProductController {
	
	public static void main(String args[]) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		boolean status = true;
		boolean flag=true;
		String choice;
		System.out.println("--------Please Login ------------");
		while (flag == true) {
			String password=null;
			String username=null;
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
			if (username.equals("Product@gmail.com") && password.equals("Productbb143@")) {
				System.out.println("You are sucessfully logined");
				status = true;
				flag = false;
			} else {
				System.err.println("Sorry Your Does not Exist Please Admin");
			}
		}
		while (true) {
			System.out.println("---------Welcome product-------------");
			System.out.println("Press 1 to Add Product Details");
			System.out.println("Press 2 to Delete Product Details");
			System.out.println("Press 3 to Access the Product Details");
			System.out.println("Press 4 to Modify the Product Details");
			System.out.println("press 5 to Exit");
			System.out.println("enter the choice");
			choice = input.next();
			switch (Validation.isNumber2(choice)) {
			case 1:
				Product proobj = new Product();
				status=true;
				while (status == true) {
					System.out.println("Enter the  product ID(Only 2 Alphabets followed By 2 Digits)");
					String proString = input.next();
					if (Validation.validateAlpaLength(proString)) {
						proobj.setProductId(proString);
						status = false;
					} else {
						System.err.println("Invalid format(XX00,.. allowed)");
					}
				}
				status = true;
				while (status == true) {
					System.out.println("Enter the product name");
					String product_name = input.next();
					if (product_name.length() >= 3 && product_name.length() <= 13) {
						if (Validation.isString(product_name)) {
							proobj.setProductName(product_name);
							status = false;
						} else {
							System.err.println("invalid format");
							status = true;
						}
					} else {
						System.err.println("Minimum Character length is 3 and Maximam is 13");
					}
				}
				status = true;
				while (status == true) {
					System.out.println("enter the date dd/mm/yyyy");
					String date = input.next();
					String regex = "^(3[01]|[12][0-9]|0[1-9])/(1[0-2]|0[1-9])/[0-9]{4}$";
					Pattern pattern = Pattern.compile(regex);
					Matcher matcher = pattern.matcher(date);
					if (matcher.matches()) {
						if (Validation.validateMonth(date)) {
							SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
							Date Todaydate = new Date();
							String todayAsString = formatter.format(Todaydate);
							if (date.compareTo(todayAsString) > 0) {
								proobj.setProductDate(date);
								status = false;
							} else if (date.compareTo(todayAsString) < 0) {
								System.out.println();
								System.err.print("plz enter date greater than todays ");
								System.out.println("Todays date is=" + Todaydate);
							} else if (date.compareTo(todayAsString) == 0) {
								proobj.setProductDate(date);
								status = false;
							}
						} else {
							System.err.println("The day Does not Exist in this month");
						}
					} else {
						System.out.println();
						System.err.println("Invliad format enter as dd/mm/yyyy");
					}
				}
				status = true;
				while (status == true) {
					System.out.println("Enter the Quantity");
					String qualityString = input.next();
					if (Validation.isNumber(qualityString)) {
						int qualityNumber = Integer.parseInt(qualityString);
						proobj.setProductQuality(qualityNumber);
						status = false;
					} else {
						System.err.println("Please Enter the Number only");
					}
				}
				try {
					if(AdminController.productServices.addProduct(proobj))
					{
						System.out.println("Product are sucessfully added");
					}
					else
					{
						System.out.println("Element is already added");
					}
				} catch (ForestManagementException e) {
					System.err.println(e.getMessage());
				}
				break;
			case 2:
				Product proobj1 = new Product();
				status = true;
				while (status == true) {
					System.out.println("Enter the  product ID(Only 2 Alphabets followed By 2 Digits)");
					String proString = input.next();
					if (Validation.validateAlpaLength(proString)) {
						proobj1.setProductId(proString);
						try {
							if (AdminController.productServices.deleteProduct(proobj1.getProductId())) {
								System.out.println("--------Sucessfully Deleted----------");
							} else {
								System.err.println("Does not exist");
							}
						} catch (ForestManagementException e) {
							System.err.println(e.getMessage());
						}
						status = false;
					} else {
						System.err.println("Invalid format(XX00,.. allowed)");
					}
				}
				status = true;
				break;
			case 3:
				Product proobj2 = new Product();
				status = true;
				while (status == true) {
					System.out.println("Enter the  product ID(Only 2 Alphabets followed By 2 Digits)");
					String proString = input.next();
					if (Validation.validateAlpaLength(proString)) {
						proobj2.setProductId(proString);
						status = false;
						try {
							System.out.println(AdminController.productServices.searchProduct(proobj2.getProductId()));
						} catch (ForestManagementException e) {
							System.err.println(e.getMessage());
						}
					} else {
						System.err.println("Invalid format(XX00,.. allowed)");
					}
				}
				status = true;
				break;
			case 4:
				String proString = null;
				while (status == true) {
					System.out.println("Enter the  product ID to Modify(Only 2 Alphabets followed By 2 Digits)");
					proString = input.next();
					if (Validation.validateAlpaLength(proString)) {
						status = false;
					} else {
						System.err.println("Invalid format(XX00,.. allowed)");
					}
				}
				status = true;
				System.out.println("what You want to modify");
				System.out.println("Press 1 to modify the Product Name");
				System.out.println("Press 2 to Modify the Product Date");
				int choice11 = input.nextInt();
				switch (choice11) {
				case 1:
					status = true;
					while (status == true) {
						System.out.println("Enter the product name");
						String product_name = input.next();
						if (product_name.length() >= 3 && product_name.length() <= 13) {
							if (Validation.isString(product_name)) {
								try {
									if (AdminController.productServices.modifyProductName(proString, product_name)) {
										System.out.println("--------Upadted successfully-------");
									} else {
										System.err.println("error");
									}
								}
								catch (ForestManagementException e) {
									System.err.println(e.getMessage());
								}
								status = false;
							} else {
								System.err.println("invalid format");
								status = true;
							}
						} else {
							System.err.println("Minimum Character length is 3 and Maximam is 13");
						}
					}
					status = true;
					break;
				case 2:
					status = true;
					while (status == true) {
						System.out.println("Enter the date  in dd/mm/yyyy Format");
						String product_date = input.next();
						String regex = "^(3[01]|[12][0-9]|0[1-9])/(1[0-2]|0[1-9])/[0-9]{4}$";
						Pattern pattern = Pattern.compile(regex);
						Matcher matcher = pattern.matcher(product_date);
						if (matcher.matches()) {
							SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
							Date Todaydate = new Date();
							String todayAsString = formatter.format(Todaydate);
							if (product_date.compareTo(todayAsString) > 0) {
								if (AdminController.productServices.modifyProductDate(proString, product_date))
									System.out.println("updtaed");
								else
									System.out.println("error");
								status = false;
							} else if (product_date.compareTo(todayAsString) < 0) {
								System.out.println();
								System.err.print("plz enter date greater than todays  ");
								System.out.println("Todays date is=" + Todaydate);
							} else if (product_date.compareTo(todayAsString) == 0) {
								if (AdminController.productServices.modifyProductDate(proString, product_date))
									System.out.println("updtaed");
								else
									System.out.println("error");
								status = false;
							}
						} else {
							System.out.println();
							System.err.println("Invliad format enter as dd/mm/yyyy");
						}
					}
					break;
					default:
					System.err.println("Invalid Choice Please the Above Choice");
					
				}
				break;
			case 5:
				return;
			default:
				System.err.println("Invalid Choice Please the Above Choice");
			}
		} // end of constructor
	}
}// end of class
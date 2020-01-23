package com.capgemini.forestmanagement.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.capgemini.forestmanagement.bean.Account;
import com.capgemini.forestmanagement.bean.Product;
import com.capgemini.forestmanagement.exception.ForestManagementException;
import com.capgemini.forestmanagement.factory.ProductFactory;
import com.capgemini.forestmanagement.service.ProductServices;
import com.capgemini.forestmanagement.validation.Validation;


public class ProductController {
	public static void main(String args[]) {
		ProductServices services = ProductFactory.instanceOfProductServicesImpl();
		@SuppressWarnings("resource")
		Scanner input= new Scanner(System.in);
		boolean status = true;
		boolean ch2 = true;
		boolean  flag=true;
		Account account;
		while (flag == true) {
			System.out.println("------------Welcome Product --------");
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
			if(services.getAuth(username, password))
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
		while (ch2 == true) {
			System.out.println("---------Welcome product-------------");
			System.out.println("Press 1 to Add Product Details");
			System.out.println("Press 2 to Delete Product Details");
			System.out.println("Press 3 to Display Product Details");
			System.out.println("Press 4 to Access the Product Details");
			System.out.println("Press 5 to Modify the Product Details");
			System.out.println("Press 6 to Return");
			System.out.println("enter the choice");
			String choice;
			status=true;
			choice = input.next();
			switch (Validation.isNumber2(choice)) {
			case 1:
				Product proobj = new Product();
				status = true;
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
					System.out.println("Enter the date in dd/mm/yyyy Format");
					String date = input.next();
					String regex = "^(3[01]|[12][0-9]|0[1-9])/(1[0-2]|0[1-9])/[0-9]{4}$";
					Pattern pattern = Pattern.compile(regex);
					Matcher matcher = pattern.matcher(date);
					if (matcher.matches()) {
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
						System.err.println("Plz enter the quantity");
					}
				}
				try {
					if (services.addProduct(proobj)) {
						System.out.println("------Successfully Added Product-----");
					} else {
						System.err.println("Already exist");
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
							if (services.deleteProduct(proobj1.getProductId())) {
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
				if (services.getAllProduct() == null) {
					System.out.println("empty");
				} else {
					System.out.println(services.getAllProduct());
				}
				break;
			case 4:
				Product proobj2 = new Product();
				status = true;
				while (status == true) {
					System.out.println("Enter the  product ID(Only 2 Alphabets followed By 2 Digits)");
					String proString = input.next();
					if (Validation.validateAlpaLength(proString)) {
						proobj2.setProductId(proString);
						status = false;
						try {
							System.out.println(services.searchProduct(proobj2.getProductId()));
						} catch (ForestManagementException e) {
							System.out.println(e.getMessage());
						}
					} else {
						System.err.println("Invalid format(XX00,.. allowed)");
					}
				}
				status = true;
				break;
			case 5:
				String proString = null;
				while (status == true) {
					System.out.println("Enter the  product ID to Modify(Only 2 Alphabets followed By 2 Digits)");
					proString = input.next();
					if (Validation.validateAlpaLength(proString)) {
						Product product=services.searchProduct(proString);
						if(product==null) {
							System.err.println("PRODUCT DOES NOT EXIST");
						}else {
						status = false;
						}
					}else {
						System.err.println("Invalid format(XX00,.. allowed)");
					}
				}
				status=true;
				String accept = null;
				while(status==true){
					status = true;
					System.out.println("what You want to modify");
					System.out.println("Press 1 to modify the Product Name");
					System.out.println("Press 2 to Modify the Product Date");
					accept= input.next();
					if(Validation.isNumber(accept)) {
						if(Validation.isNumber2(accept)==1||Validation.isNumber2(accept)==2)
						{
							status=false;
						}
					}
					else {
						System.err.println("Invalid Input");
					}
				}
				switch (Validation.isNumber2(accept)) {
				case 1:
					status = true;
					while (status == true) {
						System.out.println("Enter the product name");
						String product_name = input.next();
						if (product_name.length() >= 3 && product_name.length() <= 13) {
							if (Validation.isString(product_name)) {
								try {
									if (services.modifyProductName(proString, product_name)) {
										System.out.println("--------Upadted successfully-------");
									} else {
										System.err.println("error");
									}
								} catch (ForestManagementException e) {
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
								try {
									if (services.modifyProductDate(proString, product_date))
										System.out.println("updtaed");
									else
										System.out.println("error");
								} catch (ForestManagementException e) {
									System.err.println(e.getMessage());
								}
								status = false;
							} else if (product_date.compareTo(todayAsString) < 0) {
								System.out.println();
								System.err.print("plz enter date greater than todays  ");
								System.out.println("Todays date is=" + Todaydate);
							} else if (product_date.compareTo(todayAsString) == 0) {
								try {
									if (services.modifyProductDate(proString, product_date))
										System.out.println("updtaed");
									else
										System.out.println("error");
								} catch (ForestManagementException e) {
									System.err.println(e.getMessage());
								}
								status = false;
							}
						} else {
							System.out.println();
							System.err.println("Invliad format enter as dd/mm/yyyy");
						}
					}
					break;
				default:
					System.out.println("Invalid input");
				}
				break;
			case 6:
				return;
			default:
				System.out.println("Invalid Choice");
			}
		} 
	}
}

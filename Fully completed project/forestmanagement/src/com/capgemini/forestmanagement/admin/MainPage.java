package com.capgemini.forestmanagement.admin;

import java.util.Scanner;

import com.capgemini.forestmanagement.controller.AdminController;
import com.capgemini.forestmanagement.controller.ClientController;
import com.capgemini.forestmanagement.controller.ProductController;
import com.capgemini.forestmanagement.controller.SchedularController;
import com.capgemini.forestmanagement.validation.Validation;

public class MainPage {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (true) {
			System.out.println("------Welcome To Forest Management System-------");
			System.out.println("Please select the below Option");
			System.out.println("Press 1 for Admin Login");
			System.out.println("Press 2 for Client Login");
			System.out.println("Press 3 for Product ");
			System.out.println("Press 4 for Schedular ");
			System.out.println("Press 5 for exit");
			System.out.println("-------------------------------------------------");
			String choice = in.next();
			switch (Validation.isNumber2(choice)) {
			case 1:
				AdminController obj=new AdminController();
				break;
			case 2:
				ClientController obj2=new ClientController();
				break;
			case 3:
				ProductController obj3=new ProductController();
				break;
			case 4:
				SchedularController obj4=new SchedularController();
				break;
			case 5:
				System.exit(0);
				break;
			default:
				System.err.println("Please Select the above option\n\n\n");
			}
			// in.close();
		}
	}
}
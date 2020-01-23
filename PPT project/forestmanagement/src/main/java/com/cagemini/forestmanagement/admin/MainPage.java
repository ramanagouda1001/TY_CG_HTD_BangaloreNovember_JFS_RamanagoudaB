package com.cagemini.forestmanagement.admin;

import java.util.Scanner;

import com.cagemini.forestmanagement.controller.AdminController;
import com.cagemini.forestmanagement.controller.ClientController;
import com.cagemini.forestmanagement.controller.ProductController;
import com.cagemini.forestmanagement.controller.SchedularController;
import com.cagemini.forestmanagement.validation.Validation;

public class MainPage {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		while (true) {
			System.out.println("------Welcome To Forest Management System-------");
			System.out.println("Please select the below Option");
			System.out.println("Press 1 for Admin Login");
			System.out.println("Press 2 for Client Login");
			System.out.println("Press 3 for Product ");
			System.out.println("Press 4 for Schedular ");
			System.out.println("Press 5 for exit");
			System.out.println("-------------------------------------------------");
			String choice = input.next();
			switch (Validation.isNumber2(choice)) {
			case 1:
				AdminController.main(args);
				break;
			case 2:
				ClientController.main(args);
				break;
			case 3:
				ProductController.main(args);
				break;
			case 4:
				SchedularController.main(args);
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
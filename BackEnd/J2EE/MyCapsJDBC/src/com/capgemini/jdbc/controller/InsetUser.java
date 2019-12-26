package com.capgemini.jdbc.controller;

import java.util.Scanner;

import com.capgemini.jdbc.bean.UserBean;
import com.capgemini.jdbc.factory.UserFactory;
import com.capgemini.jdbc.services.UserServices;

public class InsetUser {
	public static void main(String[] args) {

		UserServices serivces = UserFactory.instanceofUserServices();
		UserBean user = new UserBean();
		Scanner in = new Scanner(System.in);

		System.out.println("enter the userid");
		user.setUserid(Integer.parseInt(in.nextLine()));
		System.out.println("enter the username");
		user.setUsername(in.nextLine());
		System.out.println("enter the email");
		user.setEmail(in.nextLine());
		System.out.println("enter the password");
		user.setPassword(in.nextLine());

		if (serivces.insertUser(user)) {
			System.out.println("user inserted..");
		} else {
			System.err.println("error");
		}
		in.close();
	}
}

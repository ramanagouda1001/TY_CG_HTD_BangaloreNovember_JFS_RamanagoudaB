package com.capgemini.jdbc.controller;

import java.util.Scanner;

import com.capgemini.jdbc.bean.UserBean;
import com.capgemini.jdbc.factory.UserFactory;
import com.capgemini.jdbc.services.UserServices;

public class UpdateEmail 
{
	public static void main(String[] args)
	{
		UserServices serivces=UserFactory.instanceofUserServices();
		UserBean user=new UserBean();
		Scanner in=new Scanner(System.in);
		
		System.out.println("Enter the userid");
		user.setUserid(Integer.parseInt(in.nextLine()));
		
		System.out.println("Enter the password");
		user.setPassword(in.nextLine());
		
		System.out.println("enter the Email");
		user.setEmail(in.nextLine());
		
		if(serivces.updateUser(user.getUserid(), user.getPassword(), user.getEmail()))
		{
			System.out.println("Updated sucessfully");
		}
		else
		{
			System.err.println("error");
		}
	}
}

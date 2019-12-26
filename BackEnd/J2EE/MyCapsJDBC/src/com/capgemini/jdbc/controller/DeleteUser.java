package com.capgemini.jdbc.controller;

import java.util.Scanner;

import com.capgemini.jdbc.bean.UserBean;
import com.capgemini.jdbc.factory.UserFactory;
import com.capgemini.jdbc.services.UserServices;

public class DeleteUser 
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
		
		if(serivces.deleteUser(user.getUserid(),user.getPassword()))
		{
			System.out.println("Deleted sucessufully");
		}
		else
		{
			System.err.println("Error");
		}
	
	}
}

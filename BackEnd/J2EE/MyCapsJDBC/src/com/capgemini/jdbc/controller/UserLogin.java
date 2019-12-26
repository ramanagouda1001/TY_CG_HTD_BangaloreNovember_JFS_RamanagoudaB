package com.capgemini.jdbc.controller;

import java.util.*;

import com.capgemini.jdbc.bean.UserBean;
import com.capgemini.jdbc.factory.UserFactory;
import com.capgemini.jdbc.services.UserServices;

public class UserLogin 
{

	public static void main(String[] args) 
	{
		UserServices serivces=UserFactory.instanceofUserServices();
		UserBean user=new UserBean();
		Scanner in=new Scanner(System.in);
		
		System.out.println("enter user name");
		user.setUsername(in.nextLine());
		
		System.out.println("enter the passord");
		user.setPassword(in.nextLine());
		
		user=serivces.userLogin(user.getUsername(), user.getPassword());
		if(user!=null)
		{
			System.out.println(user);
		}
		else
		{
			System.err.println("error");
		}
	}
}

package com.capgemini.jdbc.controller;

import java.util.List;

import com.capgemini.jdbc.bean.UserBean;
import com.capgemini.jdbc.factory.UserFactory;
import com.capgemini.jdbc.services.UserServices;

public class GetAllUser 
{
	public static void main(String[] args) 
	{
		UserServices services=UserFactory.instanceofUserServices();
		
		List<UserBean> list=services.getAllUser();
		
		if(list!=null)
		{
			for (UserBean user : list) {
				System.out.println(user);
			}
		}
	}
}

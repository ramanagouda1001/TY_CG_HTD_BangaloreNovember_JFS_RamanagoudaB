package com.capgemini.forestmanagementrest.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.capgemini.forestmanagementrest.bean.AdminResponce;
import com.capgemini.forestmanagementrest.exception.ForestManagementSystem;

@RestControllerAdvice
public class AdminControllerAdvice {

	@ExceptionHandler(ForestManagementSystem.class)
	public AdminResponce handlAdminResponce(ForestManagementSystem e)
	{
		AdminResponce adminResponce=new AdminResponce();
		adminResponce.setStatusCode(501);
		adminResponce.setMessage("Exception");
		adminResponce.setDescrption(e.getMessage());
		return adminResponce;
	}
}

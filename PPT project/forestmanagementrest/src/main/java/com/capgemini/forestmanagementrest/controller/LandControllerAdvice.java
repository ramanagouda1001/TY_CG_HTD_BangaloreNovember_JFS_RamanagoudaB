package com.capgemini.forestmanagementrest.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.capgemini.forestmanagementrest.bean.LandResponce;
import com.capgemini.forestmanagementrest.exception.ForestManagementSystem;

@RestControllerAdvice
public class LandControllerAdvice {

	@ExceptionHandler(ForestManagementSystem.class)
	public LandResponce handleLandException(ForestManagementSystem e)
	{
		LandResponce landResponce=new LandResponce();
		landResponce.setStatusCode(401);
		landResponce.setMessage("Exception");
		landResponce.setDescrption(e.getMessage());
		return landResponce;
	}
}
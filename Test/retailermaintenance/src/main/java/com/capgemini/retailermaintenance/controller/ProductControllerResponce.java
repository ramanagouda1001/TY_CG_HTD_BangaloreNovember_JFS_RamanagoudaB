package com.capgemini.retailermaintenance.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.capgemini.retailermaintenance.bean.ProductResponce;
import com.capgemini.retailermaintenance.exception.RetailerMaintenanceException;

@RestControllerAdvice
public class ProductControllerResponce {

	@ExceptionHandler(RetailerMaintenanceException.class)
	public ProductResponce handleProduct(RetailerMaintenanceException e)
	{
		ProductResponce responce=new ProductResponce();
		responce.setStatusCode(501);
		responce.setMessage("exception");
		responce.setDiscrption(e.getMessage());
		return responce;
	}
}

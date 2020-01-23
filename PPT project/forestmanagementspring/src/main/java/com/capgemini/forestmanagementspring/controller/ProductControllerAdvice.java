package com.capgemini.forestmanagementspring.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.capgemini.forestmanagementspring.bean.ProductResponce;
import com.capgemini.forestmanagementspring.exception.ForestManagementSystem;

@RestControllerAdvice
public class ProductControllerAdvice {

	@ExceptionHandler(ForestManagementSystem.class)
	public ProductResponce handlerProductException(ForestManagementSystem e) {
		ProductResponce productResponce=new ProductResponce();
		productResponce.setStatusCode(401);
		productResponce.setDescrption("Exception");
		productResponce.setDescrption(e.getMessage());
		return productResponce;
	}
}

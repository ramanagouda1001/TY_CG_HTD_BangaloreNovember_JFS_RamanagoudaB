package com.capgemini.retailermaintenance.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.capgemini.retailermaintenance.bean.UserResponce;
import com.capgemini.retailermaintenance.exception.RetailerMaintenanceException;

@RestControllerAdvice
public class UserControllerAdvice {

	@ExceptionHandler(RetailerMaintenanceException.class)
	public UserResponce handleUserResponce(RetailerMaintenanceException e) {
		UserResponce responce = new UserResponce();
		responce.setStatusCode(501);
		responce.setMessage("exception");
		responce.setDiscrption(e.getMessage());
		return responce;
	}
}

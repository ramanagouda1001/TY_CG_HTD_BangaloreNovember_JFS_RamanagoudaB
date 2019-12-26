package com.capgemini.springrest.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.capgemini.springrest.dto.EmployeeResponce;
import com.capgemini.springrest.exception.EmployeeException;

@RestControllerAdvice
public class EmployeeControllerAdvice {

	@ExceptionHandler(EmployeeException.class)
	public EmployeeResponce handleEmployeeException(EmployeeException e) {
		EmployeeResponce employeeResponce=new EmployeeResponce();
		employeeResponce.setStatusCode(501);
		employeeResponce.setMessage("Exception");
		employeeResponce.setMessage(e.getMessage());
		return employeeResponce;
	}
}

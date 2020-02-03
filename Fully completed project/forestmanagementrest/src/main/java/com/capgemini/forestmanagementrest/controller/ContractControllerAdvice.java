package com.capgemini.forestmanagementrest.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.capgemini.forestmanagementrest.bean.ContractResponce;
import com.capgemini.forestmanagementrest.exception.ForestManagementSystem;

@RestControllerAdvice
public class ContractControllerAdvice {

	@ExceptionHandler(ForestManagementSystem.class)
	public ContractResponce handleContractException(ForestManagementSystem e)
	{
		ContractResponce contractResponce=new ContractResponce();
		contractResponce.setStatusCode(401);
		contractResponce.setMessage("Exceptiion");
		contractResponce.setDescrption(e.getMessage());
		return contractResponce;
	}
	
}

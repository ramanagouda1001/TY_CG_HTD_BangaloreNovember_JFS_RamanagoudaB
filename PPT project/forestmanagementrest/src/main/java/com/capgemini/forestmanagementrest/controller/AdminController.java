package com.capgemini.forestmanagementrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.forestmanagementrest.bean.Account;
import com.capgemini.forestmanagementrest.bean.AdminResponce;
import com.capgemini.forestmanagementrest.service.AdminServices;

@CrossOrigin
@RestController
public class AdminController {

	@Autowired
	private AdminServices services;

	@PostMapping(path="/auth",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
	public AdminResponce auth(@RequestBody Account bean) {
		boolean status = services.getAdmin(bean);
		AdminResponce adminResponce = new AdminResponce();
		if (status == true) {
			adminResponce.setStatusCode(201);
			adminResponce.setMessage("Sucessfully logined In");
			adminResponce.setDescrption("Credentials are found");
		} else {
			adminResponce.setStatusCode(401);
			adminResponce.setMessage("failure");
			adminResponce.setDescrption("Credentials are not found");
		}
		return adminResponce;
	}
	
	@PostMapping(path="/addaccount",produces = MediaType.APPLICATION_JSON_VALUE,consumes =MediaType.APPLICATION_JSON_VALUE)
	public AdminResponce addAcount(@RequestBody Account bean)
	{
		boolean status=services.addAccount(bean);
		AdminResponce adminResponce=new AdminResponce();
		if(status==true) {
			adminResponce.setStatusCode(201);
			adminResponce.setMessage("Sucessfully logined In");
			adminResponce.setDescrption("Admin Credentials are found");
		}
		else
		{
			adminResponce.setStatusCode(401);
			adminResponce.setMessage("failure");
			adminResponce.setDescrption("YOU ARE NOT ADMIN");
		}
		return adminResponce;
	}	
	
	@GetMapping(path="/getlistaccount",produces = MediaType.APPLICATION_JSON_VALUE)
	public AdminResponce listAccount() {
		List<Account> list=services.listAccount();
		AdminResponce adminResponce=new AdminResponce();
		if(list==null) {
			adminResponce.setStatusCode(401);
			adminResponce.setMessage("failure");
			adminResponce.setDescrption("May be no Account is Present");
		}
		else {
			adminResponce.setStatusCode(201);
			adminResponce.setMessage("Sucessfully");
			adminResponce.setDescrption("Here are the details");
			adminResponce.setList(list);
		}
		return adminResponce;
	}
	
	@PostMapping(path="/deleteaccount",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
	public AdminResponce deleteAccount(@RequestBody Account bean) {
		boolean status=services.deleteAccount(bean);
		AdminResponce adminResponce=new AdminResponce();
		if(status==true) {
			adminResponce.setStatusCode(201);
			adminResponce.setMessage("Account is deleted");
			adminResponce.setDescrption("Credentials are valid");
		}
		else {
			adminResponce.setStatusCode(401);
			adminResponce.setMessage("Account cannot be deleted");
			adminResponce.setDescrption("Credentials are invalid");
		}
		return adminResponce;
	}
}

package com.capgemini.retailermaintenance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.retailermaintenance.bean.UserInfo;
import com.capgemini.retailermaintenance.bean.UserResponce;
import com.capgemini.retailermaintenance.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService service;

	@PostMapping(path="/registeruserinfo",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
	public UserResponce register(@RequestBody UserInfo bean)
	{
		boolean status=service.create(bean);
		UserResponce responce=new UserResponce();
		if(status==true)
		{
			responce.setStatusCode(201);
			responce.setMessage("Created");
			responce.setDiscrption("A new Account is created");
		}
		return responce;
	}
	
	@PostMapping(path="/authuserinfo",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
	public UserResponce auth(@RequestBody UserInfo bean)
	{
		boolean status=service.authUser(bean.getEmail(), bean.getPassword());
		UserResponce responce=new UserResponce();
		if(status==true) {
			responce.setStatusCode(201);
			responce.setMessage("Found");
			responce.setDiscrption("credatials are found");
		}
		else {
			responce.setStatusCode(401);
			responce.setMessage("Not found");
			responce.setDiscrption("credatials are not found invalid Password");
		}
		return responce;
	}
	
	@PostMapping(path="/updateuserinfo",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
	public UserResponce updatedPassword(@RequestBody UserInfo bean)
	{
		boolean status=service.updatepassword(bean.getEmail(), bean.getPassword());
		UserResponce responce=new UserResponce();
		if(status==true)
		{
			responce.setStatusCode(201);
			responce.setMessage("Found");
			responce.setDiscrption("credatials are found and updated");
		}
		else {
			responce.setStatusCode(401);
			responce.setMessage("Not found");
			responce.setDiscrption("credatials are not found and not updated");
		}
		return responce;
	}
}

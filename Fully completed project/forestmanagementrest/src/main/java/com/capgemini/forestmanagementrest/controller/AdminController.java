package com.capgemini.forestmanagementrest.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.forestmanagementrest.bean.Account;
import com.capgemini.forestmanagementrest.bean.AdminResponce;
import com.capgemini.forestmanagementrest.bean.Contract;
import com.capgemini.forestmanagementrest.bean.Product;
import com.capgemini.forestmanagementrest.exception.ForestManagementSystem;
import com.capgemini.forestmanagementrest.service.AdminServices;
import com.capgemini.forestmanagementrest.service.ContractServices;
import com.capgemini.forestmanagementrest.service.ProductServices;

@CrossOrigin
@RestController
public class AdminController {

	@Autowired
	private AdminServices services;
	
	@Autowired
	private ContractServices contractService;
	
	@Autowired
	private ProductServices productService;

	@PostMapping(path="/auth",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
	public AdminResponce auth(@RequestBody Account bean) {
		Account responceObject = services.getAdmin(bean);
		AdminResponce adminResponce = new AdminResponce();
		if (responceObject!=null) {
			adminResponce.setStatusCode(201);
			adminResponce.setMessage("Sucessfully logined In");
			adminResponce.setDescrption("Credentials are found ");
			adminResponce.setList(Arrays.asList(responceObject));
			adminResponce.setRole(responceObject.getRole());
		} else {
			adminResponce.setStatusCode(401);
			adminResponce.setMessage("failure");
			adminResponce.setDescrption("Invalid password");
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
			adminResponce.setDescrption("Account is Created of "+bean.getEmail());
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

	@PostMapping(path="/statusContract",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
	public AdminResponce statusCheck(@RequestBody Contract bean) {
		AdminResponce adminResponce=new AdminResponce();
		Contract contractObject=contractService.searchContract(bean.getContract_no());
		try {
			Product productObject=productService.searchProduct(bean.getProduct_id());
			if(productObject.getProduct_quality()>contractObject.getQuality()) {
				adminResponce.setStatusCode(201);
				adminResponce.setMessage("Sucessfully");
				adminResponce.setDescrption("Demand("+contractObject.getQuality()+") is less than Stock("+productObject.getProduct_quality()+")");
			}
			else {
				adminResponce.setStatusCode(401);
				adminResponce.setMessage("Unsucessfully");
				adminResponce.setDescrption("Demand("+contractObject.getQuality()+") is greater than Stock("+productObject.getProduct_quality()+")");
			}
		}
		catch(Exception e)
		{
			throw new ForestManagementSystem("Product does not Exist");
		}
		return adminResponce;
	}
	
	@PutMapping(path="/updateaccount",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
	public AdminResponce updateAccount(@RequestBody Account bean) {
		AdminResponce responce=new AdminResponce();
		boolean status=services.updateAccount(bean);
		if(status== true) {
			responce.setStatusCode(201);
			responce.setMessage("Successfully");
			responce.setDescrption("Account details is updated ");
		}
		return responce;
	}
}
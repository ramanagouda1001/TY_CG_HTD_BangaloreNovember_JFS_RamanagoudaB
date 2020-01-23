package com.capgemini.forestmanagementrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.forestmanagementrest.bean.Contract;
import com.capgemini.forestmanagementrest.bean.ContractResponce;
import com.capgemini.forestmanagementrest.service.ContractServices;

@CrossOrigin
@RestController
public class ContractController {

	@Autowired
	private ContractServices services;
	
	@PostMapping(path="/addcontract",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ContractResponce addContract(@RequestBody Contract bean)
	{
		boolean status=services.addContract(bean);
		ContractResponce contractResponce=new ContractResponce();
		if(status==true) {
			contractResponce.setStatusCode(200);
			contractResponce.setMessage("Contract is Added");
			contractResponce.setDescrption("Client Credentials");
		}
		else {
			contractResponce.setStatusCode(401);
			contractResponce.setMessage("Contract is not Added");
			contractResponce.setDescrption("Client Credentials are invalid");
		}
		return contractResponce;
	}
	
	@GetMapping(path="/listofcontract",produces = MediaType.APPLICATION_JSON_VALUE)
	public ContractResponce getlistContract() {
		List<Contract> list=services.contractDetail();
		ContractResponce contractResponce=new ContractResponce();
		if(list.isEmpty()) {
			contractResponce.setStatusCode(401);
			contractResponce.setMessage("Empty");
			contractResponce.setDescrption("On Contract are their to display");
		}
		else {
			contractResponce.setStatusCode(200);
			contractResponce.setMessage("Sucessfully");
			contractResponce.setDescrption("Here are the Contract Details");
			contractResponce.setList(list);
		}
		return contractResponce;
	}
		
	
	@DeleteMapping(path="/deletecontract/{contract_no}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ContractResponce deleteproduct(@PathVariable(name="contract_no") int contract_no) {
		ContractResponce contractResponce=new ContractResponce();
		boolean status=services.deleteContact(contract_no);
		if(status==true) {
			contractResponce.setStatusCode(200);
			contractResponce.setMessage("Sucessfully");
			contractResponce.setDescrption("Contract details are deleted");
		}
		return contractResponce;
	}

	@PostMapping(path="/updatecontract",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ContractResponce updateContract(@RequestBody Contract bean)
	{
		ContractResponce contractResponce=new ContractResponce();
		boolean status=services.updateContract(bean);
		if(status==true) {
			contractResponce.setStatusCode(200);
			contractResponce.setMessage("Sucessfully");
			contractResponce.setDescrption("Contract details are updated");
		}
		return contractResponce;
	}
}

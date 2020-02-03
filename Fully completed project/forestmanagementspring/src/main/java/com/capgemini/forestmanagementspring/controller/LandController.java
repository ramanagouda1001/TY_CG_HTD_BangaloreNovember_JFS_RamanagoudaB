package com.capgemini.forestmanagementspring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.forestmanagementspring.bean.Land;
import com.capgemini.forestmanagementspring.bean.LandResponce;
import com.capgemini.forestmanagementspring.service.LandServices;

@CrossOrigin
@RestController
public class LandController {

	@Autowired
	private LandServices services;
	
	@PostMapping(path = "/addland",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
	public LandResponce addland(@RequestBody Land bean) {
		boolean status=services.addLand(bean);
		LandResponce landResponce=new LandResponce();
		if(status==true) {
			landResponce.setStatusCode(201);
			landResponce.setMessage("sucessfully");
			landResponce.setDescrption("Land Details are added");
		}
		else {
			landResponce.setStatusCode(401);
			landResponce.setMessage("unSucessfully");
			landResponce.setDescrption("Land Details cannot be added");
		}
		return landResponce;
	}
	
	@GetMapping(path="/getland",produces = MediaType.APPLICATION_JSON_VALUE)
	public LandResponce getland()
	{
		List<Land> list=services.displayLand();
		LandResponce landResponce=new LandResponce();
		if(list.isEmpty()) {
			landResponce.setStatusCode(401);
			landResponce.setMessage("unSucessfully");
			landResponce.setDescrption("No Land Details found");
		} else {
			landResponce.setStatusCode(201);
			landResponce.setMessage("sucessfully");
			landResponce.setDescrption("Land Details are found");
			landResponce.setList(list);
		}
		return landResponce;
	}
	 
	@DeleteMapping(path="/deleteland/{number}",produces = MediaType.APPLICATION_JSON_VALUE)
	public LandResponce deleteland(@PathVariable(name="number")int number)
	{
		boolean status=services.deleteLand(number);
		LandResponce landResponce=new LandResponce();
		if(status==true) {
			landResponce.setStatusCode(201);
			landResponce.setMessage("sucessfully");
			landResponce.setDescrption("Land Details are deleted");
		}else {
			landResponce.setStatusCode(401);
			landResponce.setMessage("unsucessfully");
			landResponce.setDescrption("Land Details are not found");
		}
		return landResponce;
	}
	
	@PostMapping(path = "/updateland",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
	public LandResponce updateland(@RequestBody Land bean) {
		boolean status=services.updateLand(bean);
		LandResponce landResponce=new LandResponce();
		if(status==true) {
			landResponce.setStatusCode(201);
			landResponce.setMessage("sucessfully");
			landResponce.setDescrption("Land Details are updated");
		}
		return landResponce;
	}
}

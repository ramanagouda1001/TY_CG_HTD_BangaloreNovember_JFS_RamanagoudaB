package com.capgemini.retailermaintenance.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.retailermaintenance.bean.ProductResponce;
import com.capgemini.retailermaintenance.bean.OrderInfo;
import com.capgemini.retailermaintenance.bean.ProductInfo;
import com.capgemini.retailermaintenance.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService service;
	
	@PostMapping(path="/productinfoadd",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ProductResponce add(@RequestBody ProductInfo bean)
	{
		ProductResponce responce=new ProductResponce();
		boolean status=service.add(bean);
		if(status==true)
		{
			responce.setStatusCode(200);
			responce.setMessage("added");
			responce.setDiscrption("Product details are added");
		}
		return responce;
	}
	
	@GetMapping(path="/getproductinfo/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ProductResponce get(@PathVariable(name="id") int id)
	{
		ProductResponce responce=new ProductResponce();
		ProductInfo object=service.serach(id);
		if(object!=null)
		{
			responce.setStatusCode(200);
			responce.setMessage("found");
			responce.setDiscrption("Details");
			responce.setList(Arrays.asList(object));
		}
		return responce;		
	}
	
	
	@PostMapping(path="/orderinfoadd",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ProductResponce addOrder(@RequestBody OrderInfo bean)
	{
		ProductResponce responce=new ProductResponce();
		boolean status=service.addOrder(bean);
		if(status==true)
		{
			responce.setStatusCode(200);
			responce.setMessage("added");
			responce.setDiscrption("Product details are added");
		}
		return responce;
	}

}

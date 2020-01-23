package com.capgemini.forestmanagementrest.controller;

import java.util.ArrayList;
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

import com.capgemini.forestmanagementrest.bean.Account;
import com.capgemini.forestmanagementrest.bean.Product;
import com.capgemini.forestmanagementrest.bean.ProductResponce;
import com.capgemini.forestmanagementrest.service.ProductServices;

@CrossOrigin
@RestController
public class ProductController {

	@Autowired
	private ProductServices services;

	@PostMapping(path ="/addproduct",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ProductResponce addProduct(@RequestBody Product proObj) {
		boolean status = services.addProduct(proObj);
		ProductResponce productResponce = new ProductResponce();
		if (status == true) {
			productResponce.setStatusCode(201);
			productResponce.setMessage("ADDED");
			productResponce.setDescrption("Product DEtails added");
		} else {
			productResponce.setStatusCode(401);
			productResponce.setMessage("Cannot Added");
			productResponce.setDescrption("Product are ALready Present");
		}
		return productResponce;
	}
	
	@DeleteMapping(path="/deleteprodct/{product_id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ProductResponce deleteProduct(@PathVariable(name="product_id") String product_id) {
		boolean status = services.deleteProduct(product_id);
		ProductResponce productResponce = new ProductResponce();
		if (status == true) {
			productResponce.setStatusCode(200);
			productResponce.setMessage("Deleted");
			productResponce.setDescrption("Product Details are found are delelted");
		} else {
			productResponce.setStatusCode(401);
			productResponce.setMessage("Connot Deleted");
			productResponce.setDescrption("Product Details are not found");
		}
		return productResponce;
	}
	
	@GetMapping(path="/searchproduct/{product_id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ProductResponce searchProduct(@PathVariable(name="product_id") String product_id) {
		Product product=services.searchProduct(product_id);
		List<Product> list=new ArrayList<Product>();
		list.add(product);
		ProductResponce productResponce=new ProductResponce();
		if(product==null) {
			productResponce.setStatusCode(401);
			productResponce.setMessage("unsucessfully");
			productResponce.setDescrption("NO Product is Found");
		}else {
			productResponce.setStatusCode(200);
			productResponce.setMessage("Sucessfully");
			productResponce.setDescrption("Details of Product");
			productResponce.setList(list);
		}
		return productResponce;
	}
	
	@GetMapping(path="/getallproduct",produces = MediaType.APPLICATION_JSON_VALUE)
	public ProductResponce getAllProduct() {
		List<Product> list=services.getAllProduct();
		ProductResponce productResponce=new ProductResponce();
		if(list.isEmpty()) {
			productResponce.setStatusCode(401);
			productResponce.setMessage("unsucessfully");
			productResponce.setDescrption("Empty..");
		}else {
			productResponce.setStatusCode(200);
			productResponce.setMessage("Sucessfully");
			productResponce.setDescrption("Details of Product");
			productResponce.setList(list);
		}
		return productResponce;
	}
	
	@PostMapping(path ="/updateproduct",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ProductResponce updateProduct(@RequestBody Product proObj) {
		boolean status = services.updateProduct(proObj);
		ProductResponce productResponce = new ProductResponce();
		if (status == true) {
			productResponce.setStatusCode(201);
			productResponce.setMessage("updated");
			productResponce.setDescrption("Product Details updated");
		}
		return productResponce;
	}
}
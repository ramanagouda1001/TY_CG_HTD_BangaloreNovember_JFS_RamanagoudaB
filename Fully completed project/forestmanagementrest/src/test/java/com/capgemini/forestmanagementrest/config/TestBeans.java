package com.capgemini.forestmanagementrest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.capgemini.forestmanagementrest.dao.AdminDAO;
import com.capgemini.forestmanagementrest.dao.AdminDAOImpl;
import com.capgemini.forestmanagementrest.dao.ContractDAO;
import com.capgemini.forestmanagementrest.dao.ContractDAOImpl;
import com.capgemini.forestmanagementrest.dao.LandDAO;
import com.capgemini.forestmanagementrest.dao.LandDAOImpl;
import com.capgemini.forestmanagementrest.dao.ProductDAO;
import com.capgemini.forestmanagementrest.dao.ProductDAOImpl;
import com.capgemini.forestmanagementrest.service.AdminServices;
import com.capgemini.forestmanagementrest.service.AdminServicesImpl;
import com.capgemini.forestmanagementrest.service.ContractServices;
import com.capgemini.forestmanagementrest.service.ContractServicesImpl;
import com.capgemini.forestmanagementrest.service.LandServices;
import com.capgemini.forestmanagementrest.service.LandServicesImpl;
import com.capgemini.forestmanagementrest.service.ProductServices;
import com.capgemini.forestmanagementrest.service.ProductServicesImpl;

@Configuration
public class TestBeans {

	@Bean
	public AdminDAO adminDAO() {
		return new AdminDAOImpl();
	}
	
	@Bean 
	public ContractDAO contractDAO() {
		return new ContractDAOImpl();
	}
	
	@Bean
	public LandDAO landDAO() {
		return new LandDAOImpl();
	}
	
	@Bean
	public ProductDAO productDAO() {
		return new ProductDAOImpl();
	}
	
	@Bean
	public AdminServices adminServices() {
		return new AdminServicesImpl();
	}
	
	@Bean 
	public ContractServices contractServices() {
		return new ContractServicesImpl();
	}
	
	@Bean
	public LandServices landServices() {
		return new LandServicesImpl();
	}
	
	@Bean
	public ProductServices productServices() {
		return new ProductServicesImpl();
	}
}

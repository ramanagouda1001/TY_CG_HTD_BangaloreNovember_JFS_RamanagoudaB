package com.capgemini.forestmanagement.factory;

import com.capgemini.forestmanagement.dao.LandDAO;
import com.capgemini.forestmanagement.dao.LandDAOImpl;
import com.capgemini.forestmanagement.service.LandServices;
import com.capgemini.forestmanagement.service.LandServicesImpl;

public class LandFactory {

	private LandFactory() {
		// TODO Auto-generated constructor stub
	}
	
	public static LandDAO instanceofLandDAO()
	{
		LandDAO dao=new LandDAOImpl(); 
		return dao;
	}

	public static LandServices instanceofLandServices()
	{
		LandServices services=new LandServicesImpl(); 
		return services;
	}
}

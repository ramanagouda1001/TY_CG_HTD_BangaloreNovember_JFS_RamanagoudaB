package com.cagemini.forestmanagement.factory;

import com.cagemini.forestmanagement.dao.LandDAO;
import com.cagemini.forestmanagement.dao.LandDAOImpl;
import com.cagemini.forestmanagement.service.LandServices;
import com.cagemini.forestmanagement.service.LandServicesImpl;

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

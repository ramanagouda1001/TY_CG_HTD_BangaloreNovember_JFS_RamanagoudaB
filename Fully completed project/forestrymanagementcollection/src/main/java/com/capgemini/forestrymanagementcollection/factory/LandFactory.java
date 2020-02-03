package com.capgemini.forestrymanagementcollection.factory;

import com.capgemini.forestrymanagementcollection.dao.LandDAO;
import com.capgemini.forestrymanagementcollection.dao.LandDAOImpl;
import com.capgemini.forestrymanagementcollection.service.LandServices;
import com.capgemini.forestrymanagementcollection.service.LandServicesImpl;

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

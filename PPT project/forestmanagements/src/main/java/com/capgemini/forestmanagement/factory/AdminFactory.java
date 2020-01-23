package com.capgemini.forestmanagement.factory;

import com.capgemini.forestmanagement.dao.AdminDAO;
import com.capgemini.forestmanagement.dao.AdminDAOImpl;
import com.capgemini.forestmanagement.service.AdminServices;
import com.capgemini.forestmanagement.service.AdminServicesImpl;

public class AdminFactory {
	private AdminFactory() {
		// TODO Auto-generated constructor stub
	}
	public static AdminServices instanceOfAdminServices()
	{
		AdminServices services=new AdminServicesImpl();
		return services;
	}
	public static AdminDAO instanceOfAdminDAO()
	{
		AdminDAO dao=new AdminDAOImpl();
		return dao;
	}
}

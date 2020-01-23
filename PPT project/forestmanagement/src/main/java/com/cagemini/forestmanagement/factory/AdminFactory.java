package com.cagemini.forestmanagement.factory;

import com.cagemini.forestmanagement.dao.AdminDAO;
import com.cagemini.forestmanagement.dao.AdminDAOImpl;
import com.cagemini.forestmanagement.service.AdminServices;
import com.cagemini.forestmanagement.service.AdminServicesImpl;

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

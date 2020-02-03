package com.cagemini.forestmanagement.factory;

import com.cagemini.forestmanagement.dao.ContractDAO;
import com.cagemini.forestmanagement.dao.ContractDAOImpl;
import com.cagemini.forestmanagement.service.ContractServices;
import com.cagemini.forestmanagement.service.ContractServicesImpl;

public class ContractFactory {
	private ContractFactory() {

	}

	public static ContractDAO instanceOfContaractDAOImpl() {
		ContractDAO dao = new ContractDAOImpl();
		return dao;
	}

	public static ContractServices insatnceOfServicesImpl()
	{
		ContractServices services=new ContractServicesImpl();
		return services;
		
	}
}

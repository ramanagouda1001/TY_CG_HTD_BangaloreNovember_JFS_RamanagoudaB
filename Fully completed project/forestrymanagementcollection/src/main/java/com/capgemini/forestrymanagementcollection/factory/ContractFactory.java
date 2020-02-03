package com.capgemini.forestrymanagementcollection.factory;

import com.capgemini.forestrymanagementcollection.dao.ContractDAO;
import com.capgemini.forestrymanagementcollection.dao.ContractDAOImpl;
import com.capgemini.forestrymanagementcollection.service.ContractServices;
import com.capgemini.forestrymanagementcollection.service.ContractServicesImpl;

public class ContractFactory {
	private ContractFactory() {

	}

	public static ContractDAO instanceOfContaractDAOImpl() {
		ContractDAO dao = new ContractDAOImpl();
		return dao;
	}

	public static ContractServices insatnceOfContractServicesImpl()
	{
		ContractServices services=new ContractServicesImpl();
		return services;
		
	}
}

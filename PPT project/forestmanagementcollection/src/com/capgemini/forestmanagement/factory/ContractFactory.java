package com.capgemini.forestmanagement.factory;

import com.capgemini.forestmanagement.dao.ContractDAO;
import com.capgemini.forestmanagement.dao.ContractDAOImpl;
import com.capgemini.forestmanagement.service.ContractServices;
import com.capgemini.forestmanagement.service.ContractServicesImpl;

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

package com.capgemini.forestrymanagementcollection.service;

import java.util.List;

import com.capgemini.forestrymanagementcollection.bean.Contract;
import com.capgemini.forestrymanagementcollection.dao.ContractDAO;
import com.capgemini.forestrymanagementcollection.factory.ContractFactory;

public class ContractServicesImpl implements ContractServices{

	ContractDAO dao=ContractFactory.instanceOfContaractDAOImpl();
	public boolean addContract(Contract bean) {
		// TODO Auto-generated method stub
		return dao.addContract(bean);
	}

	public boolean deleteContact(int contract_no) {
		// TODO Auto-generated method stub
		return dao.deleteContact(contract_no);
	}

	public List<Contract> contractDetail() {
		// TODO Auto-generated method stub
		return dao.contractDetail();
	}

	public Contract search(int contract_no) {
		// TODO Auto-generated method stub
		return dao.search(contract_no);
	}

}

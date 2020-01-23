package com.capgemini.forestmanagement.service;

import java.util.List;

import com.capgemini.forestmanagement.bean.Contract;
import com.capgemini.forestmanagement.dao.ContractDAO;
import com.capgemini.forestmanagement.dao.ProductDAO;
import com.capgemini.forestmanagement.exception.ForestManagementException;
import com.capgemini.forestmanagement.factory.ContractFactory;
import com.capgemini.forestmanagement.factory.ProductFactory;

public class ContractServicesImpl implements ContractServices{

	ContractDAO dao=ContractFactory.instanceOfContaractDAOImpl();
	
	ProductDAO productDao=ProductFactory.instanceOfProductDAOImpl();
	@Override
	public boolean addContract(Contract bean) {
		if(productDao.searchProduct(bean.getProductId())!=null) {
			return dao.addContract(bean);
		}
		else {
			throw new ForestManagementException("Product ID not Exist");
		}
		
	}

	@Override
	public boolean deleteContact(int contract_no) {
		// TODO Auto-generated method stub
		return dao.deleteContact(contract_no);
	}

	@Override
	public List<Contract> contractDetail() {
		// TODO Auto-generated method stub
		return dao.contractDetail();
	}

	@Override
	public Contract search(int contract_no) {
		// TODO Auto-generated method stub
		return dao.search(contract_no);
	}

}

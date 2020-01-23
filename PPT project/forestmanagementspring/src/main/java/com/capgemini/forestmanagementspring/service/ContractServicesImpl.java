package com.capgemini.forestmanagementspring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.forestmanagementspring.bean.Contract;
import com.capgemini.forestmanagementspring.dao.ContractDAO;
import com.capgemini.forestmanagementspring.dao.ProductDAO;
import com.capgemini.forestmanagementspring.exception.ForestManagementSystem;
import com.capgemini.forestmanagementspring.validation.Validation;

@Service
public class ContractServicesImpl implements ContractServices {

	@Autowired
	private ContractDAO dao;

	@Autowired
	private ProductDAO proDAO;

	@Override
	public boolean addContract(Contract bean) {

		if (proDAO.searchProduct(bean.getProduct_id()) != null) {
			return dao.addContract(bean);
		} else {
			throw new ForestManagementSystem("Product not exist");
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
	public boolean updateContract(Contract bean) {
		if (proDAO.searchProduct(bean.getProduct_id()) != null) {
			return dao.updateContract(bean);
		} else {
			throw new ForestManagementSystem("Product not exist");
		}
	}

	@Override
	public Contract searchContract(int contract_no) {
		// TODO Auto-generated method stub
		return dao.searchContract(contract_no);
	}

}

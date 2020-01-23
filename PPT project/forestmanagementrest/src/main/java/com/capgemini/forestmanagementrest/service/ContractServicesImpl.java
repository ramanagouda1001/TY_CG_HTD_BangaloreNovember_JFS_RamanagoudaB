package com.capgemini.forestmanagementrest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.forestmanagementrest.bean.Contract;
import com.capgemini.forestmanagementrest.dao.ContractDAO;
import com.capgemini.forestmanagementrest.dao.ProductDAO;
import com.capgemini.forestmanagementrest.exception.ForestManagementSystem;
import com.capgemini.forestmanagementrest.validation.Validation;

@Service
public class ContractServicesImpl implements ContractServices{

	@Autowired
	private ContractDAO dao;
	
	@Autowired
	private ProductDAO proDAO;
	@Override
	public boolean addContract(Contract bean) {
		
		if(proDAO.searchProduct(bean.getProduct_id())!=null) {
			if(Validation.validateDate(bean.getDelivery_date()))
			{
				bean.setDelivery_day(Validation.validateWeeks(bean.getDelivery_date()));
				return dao.addContract(bean);
			}
			else {
				throw new ForestManagementSystem("invalid date");
			}
		}
		else {
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
		if(proDAO.searchProduct(bean.getProduct_id())!=null) {
			if(Validation.validateDate(bean.getDelivery_date()))
			{
				bean.setDelivery_day(Validation.validateWeeks(bean.getDelivery_date()));
				return dao.updateContract(bean);
			}
			else {
				throw new ForestManagementSystem("invalid date");
			}
		}
		else {
			throw new ForestManagementSystem("Product not exist");
		}
	}

}

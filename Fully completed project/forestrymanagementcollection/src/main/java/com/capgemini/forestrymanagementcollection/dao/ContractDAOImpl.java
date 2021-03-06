package com.capgemini.forestrymanagementcollection.dao;

import java.util.ArrayList;
import java.util.List;

import com.capgemini.forestrymanagementcollection.bean.Contract;
import com.capgemini.forestrymanagementcollection.exception.ForestManagementException;


public class ContractDAOImpl implements ContractDAO {
	
	List<Contract> list=new ArrayList<Contract>();
	
	public boolean addContract(Contract bean) {
		boolean status=true;
		for (Contract contract : list) {
			if(contract.getContractNo()==bean.getContractNo())
			{
				throw new ForestManagementException("Account is Already Present");
			}
		}
		list.add(bean);
		return status;
	}

	public boolean deleteContact(int contract_no) {
		boolean status=true;
		for (Contract contract : list) {
			if(contract.getContractNo()==contract_no)
			{
				list.remove(contract);
				return status;
			}
		}
		throw new ForestManagementException("Account is not Present");
	}

	public List<Contract> contractDetail() {
		// TODO Auto-generated method stub
		return list;
	}

	public Contract search(int contract_no) {
		for (Contract contract : list) {
			if(contract.getContractNo()==contract_no)
			{
				return contract;
			}
		}
		throw new ForestManagementException("Account is not Present");
	}
}

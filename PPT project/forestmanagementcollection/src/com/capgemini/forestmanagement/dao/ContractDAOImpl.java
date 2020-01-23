package com.capgemini.forestmanagement.dao;

import java.util.ArrayList;
import java.util.List;

import com.capgemini.forestmanagement.bean.Contract;
import com.capgemini.forestmanagement.exception.ForestManagementException;


public class ContractDAOImpl implements ContractDAO {
	
	List<Contract> list=new ArrayList<Contract>();
	@Override
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

	@Override
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

	@Override
	public List<Contract> contractDetail() {
		// TODO Auto-generated method stub
		return list;
	}

	@Override
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

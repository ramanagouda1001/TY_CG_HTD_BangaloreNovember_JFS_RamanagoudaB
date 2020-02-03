package com.capgemini.forestmanagement.dao;

import java.util.ArrayList;
import java.util.List;

import com.capgemini.forestmanagement.bean.Contract;


public class ContractDAOImpl implements ContractDAO {
	
	List<Contract> list=new ArrayList<Contract>();
	@Override
	public boolean addContract(Contract bean) {
		for (Contract contract : list) {
			if(contract.getContract_no()==bean.getContract_no())
			{
				return false;
			}
		}
		list.add(bean);
		return true;
	}

	@Override
	public boolean deleteContact(int contract_no) {
		for (Contract contract : list) {
			if(contract.getContract_no()==contract_no)
			{
				list.remove(contract);
				return true;
			}
		}
		return false;
	}

	@Override
	public List<Contract> contractDetail() {
		// TODO Auto-generated method stub
		return list;
	}

	@Override
	public Contract search(int contract_no) {
		for (Contract contract : list) {
			if(contract.getContract_no()==contract_no)
			{
				return contract;
			}
		}
		return null;
	}

	
}

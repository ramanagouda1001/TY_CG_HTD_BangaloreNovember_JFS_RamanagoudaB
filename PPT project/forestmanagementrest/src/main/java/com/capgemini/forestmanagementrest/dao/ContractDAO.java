package com.capgemini.forestmanagementrest.dao;

import java.util.List;

import com.capgemini.forestmanagementrest.bean.Contract;

public interface ContractDAO {
	public boolean addContract(Contract bean);//done

	public boolean deleteContact(int contract_no);//done

	public List<Contract> contractDetail();//done
	
	public boolean updateContract(Contract bean);
}

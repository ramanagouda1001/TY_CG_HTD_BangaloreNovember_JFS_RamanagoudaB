package com.capgemini.forestmanagementrest.service;

import java.util.List;

import com.capgemini.forestmanagementrest.bean.Contract;

public interface ContractServices {
	public boolean addContract(Contract bean);//done

	public boolean deleteContact(int contract_no);//done

	public List<Contract> contractDetail();//done
	
	public boolean updateContract(Contract bean);

}

package com.cagemini.forestmanagement.service;

import java.util.List;

import com.cagemini.forestmanagement.bean.Contract;

public interface ContractServices {
	public boolean addContract(Contract bean);

	public boolean deleteContact(int contract_no);

	public List<Contract> contractDetail();

	public Contract search(int contract_no);
	
	public List<Contract> serachProduct(String Product_id);
}

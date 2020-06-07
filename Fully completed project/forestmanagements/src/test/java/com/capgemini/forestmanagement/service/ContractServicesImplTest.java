package com.capgemini.forestmanagement.service;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileReader;
import java.util.Properties;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.capgemini.forestmanagement.bean.Contract;
import com.capgemini.forestmanagement.exception.ForestManagementException;

class ContractServicesImplTest {

	ContractServices obj=null;
	Contract contract=null;
	
	@BeforeEach
	void testContractDAOImpl() {
		FileReader reader;
		Properties prop;
		try {
			reader = new FileReader("db.properties");
			prop = new Properties();
			prop.load(reader);
			Class.forName(prop.getProperty("driver"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("hi");
		}
		obj=new ContractServicesImpl();
	}

	@Test
	void testAddContract() {
		contract=new Contract();
		contract.setContractNo(1111);
		contract.setCustomerId(1212);
		contract.setProductId("ee22");
		contract.setTransportId(2222);
		contract.setDeliveryDate("28/12/2019");
		contract.setDeliveryDay("Tuesday");
		contract.setQuality(12);
		try {
			boolean flag=obj.addContract(contract);
			assertEquals(flag, true);
		}
		catch(Exception e) {
			assertThrows(ForestManagementException.class, () -> {
				obj.addContract(contract);
		});
	}
}

	@Test
	void testDeleteContact() {
		try {
			boolean flag=obj.deleteContact(1111);
			assertEquals(flag, true);
		}
		catch(Exception e) {
			assertThrows(ForestManagementException.class, () -> {
				obj.addContract(contract);
		});
	}
}
	@Test
	void testContractDetail() {
		
		try {
			Contract object=obj.search(1111);
			assertEquals(contract, object);
		}
		catch (Exception e) {
			assertThrows(ForestManagementException.class, () -> {
				obj.deleteContact(1111);
		});
	}
}

	@Test
	void testSearch() {
		contract=new Contract();
		contract.setContractNo(1234);
		contract.setCustomerId(1213);
		contract.setProductId("ww22");
		contract.setTransportId(1234);
		contract.setDeliveryDate("22/12/2019");
		contract.setDeliveryDay("monday");
		contract.setQuality(12);
		Contract bean=obj.search(1234);
		if(bean!=null)
			assertEquals(bean, contract);
		else
			assertEquals(bean,null );
	}
}
package com.capgemini.forestmanagementrest.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.capgemini.forestmanagementrest.bean.Contract;
import com.capgemini.forestmanagementrest.config.ORMConfig;
import com.capgemini.forestmanagementrest.config.TestBeans;
import com.capgemini.forestmanagementrest.exception.ForestManagementSystem;

@SpringJUnitConfig(classes = {TestBeans.class,ORMConfig.class})
class ContractDAOImplTest {

	@Autowired
	ContractDAO contractDAO;

	@Test
	void testAddContract() {
		Contract contract = new Contract();
		contract.setContract_no(1111);
		contract.setCustomer_id(2585);
		contract.setDelivery_date("2020-01-24");
		contract.setProduct_id("uu66");
		contract.setQuality(23);
		contract.setTransport_id(2528);
		try {
			boolean flag = contractDAO.addContract(contract);
			assertEquals(flag, true);
		} catch (Exception e) {
			assertThrows(ForestManagementSystem.class, () -> {
				contractDAO.addContract(contract);
			});
		}
	}

	@Test
	void testDeleteContact() {
		try {
			boolean flag = contractDAO.deleteContact(6565);
			assertEquals(flag, true);
		} catch (Exception e) {
			assertThrows(ForestManagementSystem.class, () -> {
				contractDAO.deleteContact(6565);
			});
		}
	}

	
	@Test
	void testUpdateContract() {
		Contract contract = new Contract();
		contract.setContract_no(1111);
		contract.setCustomer_id(2585);
		contract.setDelivery_date("2020-01-24");
		contract.setProduct_id("uu66");
		contract.setQuality(29);
		contract.setTransport_id(2828);
		try {
			boolean flag = contractDAO.updateContract(contract);
			assertEquals(flag, true);
		} catch (Exception e) {
			assertThrows(ForestManagementSystem.class, () -> {
				contractDAO.updateContract(contract);
			});
		}
	}

	@Test
	void testSearchContract() {
		Contract contract = new Contract();
		contract.setContract_no(1111);
		contract.setCustomer_id(2585);
		contract.setDelivery_date("2020-01-24");
		contract.setProduct_id("uu66");
		contract.setQuality(29);
		contract.setTransport_id(2828);
		try {
			Contract object = contractDAO.searchContract(1111);
			assertEquals(object, contract);
		} catch (Exception e) {
			assertThrows(ForestManagementSystem.class, () -> {
				contractDAO.updateContract(contract);
			});
		}
	}

}
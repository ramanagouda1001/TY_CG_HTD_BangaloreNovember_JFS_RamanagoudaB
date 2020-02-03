package com.capgemini.forestmanagementrest.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.capgemini.forestmanagementrest.bean.Land;
import com.capgemini.forestmanagementrest.config.ORMConfig;
import com.capgemini.forestmanagementrest.config.TestBeans;
import com.capgemini.forestmanagementrest.exception.ForestManagementSystem;


@SpringJUnitConfig(classes = {TestBeans.class,ORMConfig.class})
class LandDAOImplTest {

	@Autowired
	LandDAO landDAO;
	@Test
	void testAddLand() {
		Land land=new Land();
		land.setArea(55);
		land.setNumber(22);
		land.setRegion("north");
		land.setForest_type("Coniferous");
		land.setName("Rohan");
		try {
			boolean flag = landDAO.addLand(land);
			assertEquals(flag, true);
		} catch (Exception e) {
			assertThrows(ForestManagementSystem.class, () -> {
				landDAO.addLand(land);
			});
		}
	}

	@Test
	void testDeleteLand() {
		try {
			boolean flag = landDAO.deleteLand(22);
			assertEquals(flag, true);
		} catch (Exception e) {
			assertThrows(ForestManagementSystem.class, () -> {
				landDAO.deleteLand(22);
			});
		}
	}

	@Test
	void testDisplayLand() {
		List<Land> list=landDAO.displayLand();
		assertNotNull(list);
	}

	@Test
	void testUpdateLand() {
		Land land=new Land();
		land.setArea(857);
		land.setNumber(22);
		land.setRegion("south");
		land.setForest_type("Coniferous");
		land.setName("Biradar");
		try {
			boolean flag = landDAO.updateLand(land);
			assertEquals(flag, true);
		} catch (Exception e) {
			assertThrows(ForestManagementSystem.class, () -> {
				landDAO.updateLand(land);
			});
		}
	}

}

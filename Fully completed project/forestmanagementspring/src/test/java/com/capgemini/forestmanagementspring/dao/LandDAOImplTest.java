package com.capgemini.forestmanagementspring.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.forestmanagementspring.bean.Land;
import com.capgemini.forestmanagementspring.exception.ForestManagementSystem;

@SpringBootTest
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

package com.capgemini.forestmanagementspring.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.forestmanagementspring.bean.Land;
import com.capgemini.forestmanagementspring.exception.ForestManagementSystem;

@SpringBootTest
class LandServicesImplTest {

	@Autowired
	LandServices landService;
	@Test
	void testAddLand() {
		Land land=new Land();
		land.setArea(55);
		land.setNumber(22);
		land.setRegion("north");
		land.setForest_type("Coniferous");
		land.setName("Rohan");
		try {
			boolean flag = landService.addLand(land);
			assertEquals(flag, true);
		} catch (Exception e) {
			assertThrows(ForestManagementSystem.class, () -> {
				landService.addLand(land);
			});
		}
	}

	@Test
	void testDeleteLand() {
		try {
			boolean flag = landService.deleteLand(22);
			assertEquals(flag, true);
		} catch (Exception e) {
			assertThrows(ForestManagementSystem.class, () -> {
				landService.deleteLand(22);
			});
		}
	}

	@Test
	void testDisplayLand() {
		List<Land> list=landService.displayLand();
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
			boolean flag = landService.updateLand(land);
			assertEquals(flag, true);
		} catch (Exception e) {
			assertThrows(ForestManagementSystem.class, () -> {
				landService.updateLand(land);
			});
		}
	}
}

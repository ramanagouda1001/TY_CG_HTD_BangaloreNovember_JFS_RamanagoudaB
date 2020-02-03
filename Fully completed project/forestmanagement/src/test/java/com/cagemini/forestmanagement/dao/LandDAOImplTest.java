package com.cagemini.forestmanagement.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.cagemini.forestmanagement.bean.Land;
import com.cagemini.forestmanagement.exception.ForestManagementSystem;


class LandDAOImplTest {

	LandDAOImpl obj=null;
	Land land=null;
	
	@BeforeEach
	void load() {
		obj=new LandDAOImpl();
	}
	@Test
	void testAddLand() {
		land = new Land();
		land.setNumber(1111);
		land.setArea(2222);
		land.setName(("Bangalore"));
		land.setRegion("North");
		land.setForestType("conforous");
		try {
			boolean flag = obj.addLand(land);
			assertEquals(flag, true);
		} catch (Exception e) {
			assertThrows(ForestManagementSystem.class, () -> {
				obj.addLand(land);
			});
		}
	}

	@Test
	void testDeleteLand() {
		int landNumber = 1111;
		try {
			boolean flag = obj.deleteLand(landNumber);
			assertEquals(flag, true);
		} catch (Exception e) {
			assertThrows(ForestManagementSystem.class, () -> {
				obj.deleteLand(landNumber);
			});
		}
	}

//	@Test
//	void testDisplayLand() {
//		try {
//			List<Land> list=obj.displayLand();
//			assertEquals(list!=null, true);
//		}
//		catch (Exception e) {
//			assertThrows(ForestManagementSystem.class, () -> {
//				obj.displayLand()
//			});
//		}
//	}

}

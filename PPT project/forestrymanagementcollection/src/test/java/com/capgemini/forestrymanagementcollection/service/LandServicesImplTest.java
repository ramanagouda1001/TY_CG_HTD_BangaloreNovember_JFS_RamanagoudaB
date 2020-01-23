package com.capgemini.forestrymanagementcollection.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.capgemini.forestrymanagementcollection.bean.Land;

class LandServicesImplTest {

	private LandServices landDAO= new LandServicesImpl();
	private Land land=new Land();
	
	@BeforeEach
	void  addLand() {
		land.setNumber(1000);
		land.setName("akki");
		land.setRegion("north");
		land.setArea(232);
		land.setForestType("confirous");
	}
	@Test
	void testAddLand() {
		boolean flag=landDAO.addLand(land);
		assertEquals(flag, true);
	}

	@Test
	void testDeleteLand() {
		landDAO.addLand(land);
		boolean flag=landDAO.deleteLand(1000);
		assertEquals(flag,true);
	}

	@Test
	void testDisplayLand() {
		List<Land> list=landDAO.displayLand();
		boolean flag=list!=null;
		assertEquals(flag, true);
	}


}

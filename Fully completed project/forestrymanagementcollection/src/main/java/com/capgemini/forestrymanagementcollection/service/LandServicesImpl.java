package com.capgemini.forestrymanagementcollection.service;

import java.util.List;

import com.capgemini.forestrymanagementcollection.bean.Land;
import com.capgemini.forestrymanagementcollection.dao.LandDAO;
import com.capgemini.forestrymanagementcollection.factory.LandFactory;

public class LandServicesImpl implements LandServices{

	LandDAO dao=LandFactory.instanceofLandDAO();
	public boolean addLand(Land land) {
		// TODO Auto-generated method stub
		return dao.addLand(land);
	}

	public boolean deleteLand(int LandNumber) {
		// TODO Auto-generated method stub
		return dao.deleteLand(LandNumber);
	}

	public List<Land> displayLand() {
		// TODO Auto-generated method stub
		return dao.displayLand();
	}

}

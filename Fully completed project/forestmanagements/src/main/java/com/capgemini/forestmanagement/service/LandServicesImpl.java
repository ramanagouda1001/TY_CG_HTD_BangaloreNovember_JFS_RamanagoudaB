package com.capgemini.forestmanagement.service;

import java.util.List;

import com.capgemini.forestmanagement.bean.Land;
import com.capgemini.forestmanagement.dao.LandDAO;
import com.capgemini.forestmanagement.factory.LandFactory;

public class LandServicesImpl implements LandServices{

	LandDAO dao=LandFactory.instanceofLandDAO();
	@Override
	public boolean addLand(Land land) {
		// TODO Auto-generated method stub
		return dao.addLand(land);
	}

	@Override
	public boolean deleteLand(int LandNumber) {
		// TODO Auto-generated method stub
		return dao.deleteLand(LandNumber);
	}

	@Override
	public List<Land> displayLand() {
		// TODO Auto-generated method stub
		return dao.displayLand();
	}

}

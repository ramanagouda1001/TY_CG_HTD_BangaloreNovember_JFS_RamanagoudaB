package com.capgemini.forestmanagementrest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.forestmanagementrest.bean.Land;
import com.capgemini.forestmanagementrest.dao.LandDAO;
import com.capgemini.forestmanagementrest.exception.ForestManagementSystem;
import com.capgemini.forestmanagementrest.validation.Validation;

@Service
public class LandServicesImpl implements LandServices{

	@Autowired
	private LandDAO dao;
	@Override
	public boolean addLand(Land land) {
			if(Validation.isString(land.getName()))
			{
				if(land.getRegion().equalsIgnoreCase("north")||
						land.getRegion().equalsIgnoreCase("east")||
							land.getRegion().equalsIgnoreCase("west")||
								land.getRegion().equalsIgnoreCase("south"))
				{
					if(land.getForest_type().equalsIgnoreCase("Coniferous")||
							land.getForest_type().equalsIgnoreCase("Borad leaved")||
								land.getForest_type().equalsIgnoreCase("Mixed"))
					{
						return dao.addLand(land);
					} else {
						throw new ForestManagementSystem("only Coniferous,Borad leaved,Mixed");
					}
				} else {
					throw new ForestManagementSystem("Only north,south,east,west allowed");
				}

			} else {
				throw new ForestManagementSystem("Only alphabet is allowed");
			}
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

	@Override
	public boolean updateLand(Land land) {
		// TODO Auto-generated method stub
		return dao.updateLand(land);
	}

}

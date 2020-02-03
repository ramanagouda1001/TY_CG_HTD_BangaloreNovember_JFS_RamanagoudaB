package com.capgemini.forestmanagementrest.dao;

import java.util.List;

import com.capgemini.forestmanagementrest.bean.Land;

public interface LandDAO {
	public boolean addLand(Land land);

	public boolean deleteLand(int LandNumber);
	
	public List<Land> displayLand();
	
	public boolean updateLand(Land land);
	
}

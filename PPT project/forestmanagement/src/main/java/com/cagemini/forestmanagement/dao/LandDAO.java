package com.cagemini.forestmanagement.dao;

import java.util.List;

import com.cagemini.forestmanagement.bean.Land;

public interface LandDAO {
	public boolean addLand(Land land);

	public boolean deleteLand(int LandNumber);
	
	public List<Land> displayLand();
}

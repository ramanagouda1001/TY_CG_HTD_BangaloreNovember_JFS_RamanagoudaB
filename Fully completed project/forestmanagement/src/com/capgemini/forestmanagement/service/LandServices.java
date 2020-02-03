package com.capgemini.forestmanagement.service;

import java.util.List;

import com.capgemini.forestmanagement.bean.Land;

public interface LandServices {
	public boolean addLand(Land land);

	public boolean deleteLand(int LandNumber);
	
	public List<Land> displayLand();
}

package com.cagemini.forestmanagement.service;

import java.util.List;

import com.cagemini.forestmanagement.bean.Land;

public interface LandServices {
	public boolean addLand(Land land);

	public boolean deleteLand(int LandNumber);
	
	public List<Land> displayLand();
}

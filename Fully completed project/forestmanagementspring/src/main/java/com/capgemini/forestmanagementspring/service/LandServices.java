package com.capgemini.forestmanagementspring.service;

import java.util.List;

import com.capgemini.forestmanagementspring.bean.Land;

public interface LandServices {
	public boolean addLand(Land land);//done

	public boolean deleteLand(int LandNumber);//done
	
	public List<Land> displayLand();//done
	
	public boolean updateLand(Land land);
}

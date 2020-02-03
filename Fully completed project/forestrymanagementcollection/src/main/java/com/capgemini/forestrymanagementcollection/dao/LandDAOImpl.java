package com.capgemini.forestrymanagementcollection.dao;

import java.util.ArrayList;
import java.util.List;

import com.capgemini.forestrymanagementcollection.bean.Land;
import com.capgemini.forestrymanagementcollection.exception.ForestManagementException;

public class LandDAOImpl  implements LandDAO{

	List<Land> list=new ArrayList<Land>();
	public boolean addLand(Land land) {
		boolean status=true;
		for (Land obj : list) {
			if(obj.getNumber()==land.getNumber())
			{
				throw new ForestManagementException("Land details are present");
			}
		}
		list.add(land);
		return status;
	}

	public boolean deleteLand(int LandNumber) {
		boolean status=true;
		for (Land obj : list) {
			if(obj.getNumber()==LandNumber)
			{
				list.remove(obj);
				return status;
			}
		}
		throw new ForestManagementException("Account is not present");
	}

	public List<Land> displayLand() {
		// TODO Auto-generated method stub
		return list;
	}

}

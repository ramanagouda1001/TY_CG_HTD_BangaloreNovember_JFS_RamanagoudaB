package com.capgemini.forestmanagement.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.capgemini.forestmanagement.bean.Land;

public class LandDAOImpl  implements LandDAO{

	List<Land> list=new ArrayList<Land>();
	@Override
	public boolean addLand(Land land) {
		for (Land obj : list) {
			if(obj.getNumber()==land.getNumber())
			{
				return false;
			}
		}
		list.add(land);
		return true;
	}

	@Override
	public boolean deleteLand(int LandNumber) {
		for (Land obj : list) {
			if(obj.getNumber()==LandNumber)
			{
				list.remove(obj);
				return true;
			}
		}
		return false;
	}

	@Override
	public List<Land> displayLand() {
		// TODO Auto-generated method stub
		return list;
	}

}

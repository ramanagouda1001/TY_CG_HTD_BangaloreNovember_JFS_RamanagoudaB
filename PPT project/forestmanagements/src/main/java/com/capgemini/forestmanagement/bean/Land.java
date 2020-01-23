package com.capgemini.forestmanagement.bean;

import java.io.Serializable;

import lombok.Data;

@Data
public class Land implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int number;
	private String name;
	private int area;
	private String region;
	private String forestType;
	
	public String toString()
	{
		return "\n\n----Land Deatils---------\nLand Number:-"+number+"\nLand Name:-"+name+"\nLand Area:-"+area
				+"\nLand Region:-"+region+"\nForest Type:-"+forestType;
	}
}

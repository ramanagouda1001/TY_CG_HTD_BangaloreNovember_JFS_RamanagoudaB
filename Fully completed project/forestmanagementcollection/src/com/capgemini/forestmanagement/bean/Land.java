package com.capgemini.forestmanagement.bean;

import java.io.Serializable;

import lombok.Data;

@Data
public class Land implements Serializable {
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
		System.out.println("\n\n-----------Land Details--------");
		
		return String.format("\nLand Number:-"+getName()+"\nLand Name:-"+getName()+"\nLand Area:-"+getArea()+"\nLand Region:-"+
		getRegion()+"\nLand Forest Type"+getForestType());
	}
}

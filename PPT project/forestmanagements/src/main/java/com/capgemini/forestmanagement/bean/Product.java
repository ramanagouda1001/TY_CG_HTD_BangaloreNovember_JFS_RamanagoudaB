package com.capgemini.forestmanagement.bean;


import java.io.Serializable;

import lombok.Data;

@Data
public class Product implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String productId;
	private String productName;
	private String productDate;
	private int productQuality;
	
	public String toString()
	{
		return "\n\n-------Product Details--------------\nProduct Id:-"+productId+"\nProduct Name:-"+productName+"\nProduct Date:-"+productDate+
				"\nProduct Quality:-"+productQuality+"\n\n";
	}
}


package com.capgemini.forestmanagement.bean;

import java.io.Serializable;

import lombok.Data;

@Data
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;
	private String productId;
	private String productName;
	private String productDate;
	private int productQuality;
	
	public String toString()
	{
		System.out.println("\n\n-----------Product details-----");
		return String.format("\nProduct ID:-"+getProductId()+"\nProduct Name:-"+getProductName()+"\nProduct Date:-"+getProductDate()
		+"\nProduct Quality:-"+getProductQuality());
	}
}

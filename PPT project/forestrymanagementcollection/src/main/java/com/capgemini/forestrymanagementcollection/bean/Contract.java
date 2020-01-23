package com.capgemini.forestrymanagementcollection.bean;

import java.io.Serializable;
import lombok.Data;

@Data
public class Contract implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int contractNo;
	private String productId;
	private String deliveryDate;
	private String deliveryDay;
	private int quality;
	
	public String toString()
	{
		System.out.println("\n\n-----Product Details-------");
		return String.format("\nContract No:-"+getContractNo()+"\nProduct No:-"+getProductId()+"\nDelivery Date"+getDeliveryDate()+
				"\nDelivery Day"+getDeliveryDate()+"\nQuality"+getQuality());
	}
}

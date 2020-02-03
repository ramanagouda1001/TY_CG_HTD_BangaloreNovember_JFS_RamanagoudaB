package com.capgemini.forestmanagement.bean;

import java.io.Serializable;

import lombok.Data;

@Data
public class Contract implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int contractNo;
	private int customerId;
	private String productId;
	private int transportId;
	private String deliveryDate;
	private String deliveryDay;
	private int quality;
	
	public String toString()
	{
		return "\n\n\n----------Contract Details--------\nContract No:-"+contractNo+"\nCustomer Id:-"+customerId+"\nProduct Id:-"
				+productId+"\nTransport Id:-"+transportId+"\nDelivery Date:-"+deliveryDate+"\nDelivery Day:-"+deliveryDay+"\nQuality:-"
				+quality+"\n\n";
	}
}

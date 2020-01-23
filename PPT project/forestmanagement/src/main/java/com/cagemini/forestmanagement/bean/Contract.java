package com.cagemini.forestmanagement.bean;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="contract")
public class Contract{
	@Id
	@Column
	private int contractNo;
	
	@Column
	private int customerId;
	
	@Column
	private String productId;
	
	@Column
	private int transportId;
	
	@Column
	private String deliveryDate;
	
	@Column
	private String deliveryDay;
	
	@Column
	private int quality;

	public String toString()
	{
		return "\n\n\n----------Contract Details--------\nContract No:-"+contractNo+"\nCustomer Id:-"+customerId+"\nProduct Id:-"
				+productId+"\nTransport Id:-"+transportId+"\nDelivery Date:-"+deliveryDate+"\nDelivery Day:-"+deliveryDay+"\nQuality:-"
				+quality+"\n\n";
	}
}

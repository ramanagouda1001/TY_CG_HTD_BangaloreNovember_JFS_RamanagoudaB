package com.capgemini.forestmanagementspring.bean;

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
	private int contract_no;
	
	@Column
	private int customer_id;
	
	@Column
	private String product_id;
	
	@Column
	private int transport_id;
	
	@Column
	private String delivery_date;
	
	
	@Column
	private int quality;

}

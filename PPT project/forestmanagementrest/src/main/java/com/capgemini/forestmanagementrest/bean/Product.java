package com.capgemini.forestmanagementrest.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="product")
public class Product{
	
	@Id
	@Column
	private String product_id;
	
	@Column
	private String product_name;
	
	@Column
	private String product_date;
	
	@Column
	private int product_quality;

	
}

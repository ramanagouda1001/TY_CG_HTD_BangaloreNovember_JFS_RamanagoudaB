package com.cagemini.forestmanagement.bean;


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
	private String productId;
	
	@Column
	private String productName;
	
	@Column
	private String productDate;
	
	@Column
	private int productQuality;
	
	public String toString()
	{
		return "\n\n-------Product Details--------------\nProduct Id:-"+productId+"\nProduct Name:-"+productName+"\nProduct Date:-"+productDate+
				"\nProduct Quality:-"+productQuality+"\n\n";
	}

}

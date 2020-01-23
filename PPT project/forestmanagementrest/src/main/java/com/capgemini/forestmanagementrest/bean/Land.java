package com.capgemini.forestmanagementrest.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="land")
public class Land {
	@Id
	@Column
	private int number;
	
	@Column
	private String name;

	@Column
	private int area;
	
	@Column
	private String region;
	
	@Column
	private String forest_type;

}

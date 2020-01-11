package com.capgemini.retailermaintenance.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class ProductInfo {
	
	@Id
	@GeneratedValue
	@Column
	int id;
	
	@Column
	int user_id;
	
	@Column(unique = true)
	String name;
	
	@Column
	int quentity;
	
	@Column
	String details;
}

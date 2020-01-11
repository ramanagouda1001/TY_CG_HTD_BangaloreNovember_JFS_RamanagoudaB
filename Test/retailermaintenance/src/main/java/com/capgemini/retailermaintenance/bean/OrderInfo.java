package com.capgemini.retailermaintenance.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="orderinfo")
public class OrderInfo {

	@Id
	@GeneratedValue
	int id;
	
	@Column
	int product_id;
	
	@Column
	int user_id;
}

package com.capgemini.forestmanagement.bean;

import java.io.Serializable;

import lombok.Data;

@Data
public class Product implements Serializable{ 
	private String product_id;
	private String product_name;
	private String product_date;
}

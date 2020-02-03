package com.capgemini.forestmanagementrest.bean;

import java.util.List;

import lombok.Data;


@Data

public class ProductResponce {

	private int statusCode;
	private String message;
	private String descrption;
	private List<Product> list;
}

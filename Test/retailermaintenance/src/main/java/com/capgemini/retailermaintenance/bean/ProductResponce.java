package com.capgemini.retailermaintenance.bean;

import java.util.List;


import lombok.Data;

@Data
public class ProductResponce {

	private int statusCode;
	private String message;
	private String discrption;
	private List<ProductInfo> list;
}

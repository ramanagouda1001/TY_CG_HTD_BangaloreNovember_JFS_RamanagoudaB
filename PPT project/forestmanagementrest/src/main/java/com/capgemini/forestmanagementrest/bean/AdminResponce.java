package com.capgemini.forestmanagementrest.bean;

import java.util.List;

import lombok.Data;

@Data
public class AdminResponce {
	private int statusCode;
	private String message;
	private String descrption;
	private List<Account> list;

}

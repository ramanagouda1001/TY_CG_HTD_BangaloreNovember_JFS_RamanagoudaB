package com.capgemini.retailermaintenance.bean;

import lombok.Data;

@Data
public class UserResponce {
	private int statusCode;
	private String message;
	private String discrption;
}

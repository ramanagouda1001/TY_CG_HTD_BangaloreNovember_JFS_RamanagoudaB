package com.capgemini.springrest.dto;

import java.util.List;

import lombok.Data;

@Data
public class EmployeeResponce {
	private int statusCode;
	private String message;
	private String discrption;
	private List<EmployeeBean> beans;
}

package com.capgemini.forestmanagementspring.bean;

import java.util.List;

import lombok.Data;

@Data
public class ContractResponce {

	private int statusCode;
	private String message;
	private String descrption;
	private List<Contract> list;
}

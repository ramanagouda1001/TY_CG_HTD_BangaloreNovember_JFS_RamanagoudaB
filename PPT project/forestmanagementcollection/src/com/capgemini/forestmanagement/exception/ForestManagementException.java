package com.capgemini.forestmanagement.exception;

public class ForestManagementException extends RuntimeException {
	
	String msg;
	public ForestManagementException(String msg) {
		super(msg);
	}

}

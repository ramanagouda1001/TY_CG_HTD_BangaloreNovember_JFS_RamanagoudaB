package com.capgemini.forestrymanagementcollection.exception;

public class ForestManagementException extends RuntimeException {
	
	String msg;
	public ForestManagementException(String msg) {
		super(msg);
	}

}

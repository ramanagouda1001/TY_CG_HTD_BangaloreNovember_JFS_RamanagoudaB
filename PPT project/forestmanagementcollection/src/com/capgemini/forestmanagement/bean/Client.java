package com.capgemini.forestmanagement.bean;

import java.io.Serializable;

import lombok.Data;

@Data
public class Client implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;//
	
	private String username;
	
	private String password;
	
	
	public String toString()
	{
		System.out.println("\n\n-----Client Deatils--------");
		return String.format("\nUsername:-"+getUsername()+"\nPassword:-"+getPassword());
	}
}

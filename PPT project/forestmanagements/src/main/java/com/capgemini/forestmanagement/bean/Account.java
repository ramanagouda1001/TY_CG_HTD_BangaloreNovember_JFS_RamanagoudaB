package com.capgemini.forestmanagement.bean;

import java.io.Serializable;

import lombok.Data;

@Data
public class Account implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String username;
	String password;
	String role;
	
	public String toString()
	{

		return "\n\n---Account Details------\nUserName:-"+username+"\nPassword:-"+password+"\nRole:-"+role;
	}
}

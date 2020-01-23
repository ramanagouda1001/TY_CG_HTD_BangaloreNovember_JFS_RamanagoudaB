package com.cagemini.forestmanagement.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="account")
public class Account {

	@Id
	@Column
	String username;
	
	@Column
	String password;
	
	@Column
	String role;
	
	public String toString()
	{

		return "\n\n---Account Details------\nUserName:-"+username+"\nPassword:-"+password+"\nRole:-"+role;
	}

}

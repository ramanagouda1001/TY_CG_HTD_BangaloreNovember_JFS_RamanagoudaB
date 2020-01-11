package com.capgemini.retailermaintenance.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="userinfo")
public class UserInfo {
	
	@Id
	@GeneratedValue
	@Column
	int id;
	
	@Column
	String name;
	
	@Column(unique = true)
	String email;
	
	@Column
	String password;
	
}

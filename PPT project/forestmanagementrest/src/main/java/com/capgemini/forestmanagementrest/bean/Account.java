package com.capgemini.forestmanagementrest.bean;

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
	

}

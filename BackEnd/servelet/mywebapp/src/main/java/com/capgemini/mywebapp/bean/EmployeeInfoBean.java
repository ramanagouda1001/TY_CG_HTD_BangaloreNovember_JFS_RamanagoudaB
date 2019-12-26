package com.capgemini.mywebapp.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="employee_info")
public class EmployeeInfoBean  {
	
	@Id
	@Column
	private int emp_id;
	@Column
	private String name;
	@Column
	private double salary;
	@Column
	private int age;
	@Column
	private String designation;
	@Column
	private String password;
}//End of class

package com.capgemini.onetoone;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table
public class Employee_Exp {
	@Id
	@Column
	private int expId;
	
	@Column
	private String company;
	
	@Column
	private int noOfYear;
	
	@ManyToOne(cascade =CascadeType.ALL )
	@JoinColumn(name="employee_id")
	private Employee_info employee_info; 
}

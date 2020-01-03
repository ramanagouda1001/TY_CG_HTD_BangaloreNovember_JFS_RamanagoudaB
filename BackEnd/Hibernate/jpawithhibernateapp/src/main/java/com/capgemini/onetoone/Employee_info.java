package com.capgemini.onetoone;

import javax.persistence.*;

import lombok.Data;
import lombok.ToString.Exclude;

@Data
@Entity
@Table(name="Employee_info")
public class Employee_info {
	@Id
	@Column
	private int employee_id;
	
	@Column
	private String name;
	
	@Column
	private String email;
	
	@Column
	private int  password;
	@Exclude
	//	@OneToOne(cascade = CascadeType.ALL,mappedBy = "employee")
	//private Employe_others others;
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "employee_info")
	private Employee_Exp exp;
//	
}

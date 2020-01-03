package com.capgemini.manytomany;

import java.util.List;

import javax.persistence.*;

import com.capgemini.onetoone.Employee_info;

import lombok.Data;

@Data
@Entity
@Table
public class TraninigInfo {
	@Id
	@Column
	private int tid;

	@Column
	private String tname;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="Traning_employee",joinColumns=@JoinColumn(name="tid"),inverseJoinColumns = @JoinColumn(name="employee_id"))
	
	private List<Employee_info> emp;
}


package com.capgemini.onetoone;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table
public class Employe_others {
	@Id
	@Column
	private int id;
	
	@Column
	private int adhar_no;
	
	@Column
	private String father_name;

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="employee_id")
	private Employee_info  employee;
}

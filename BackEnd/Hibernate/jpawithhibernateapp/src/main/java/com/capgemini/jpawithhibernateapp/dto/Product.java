package com.capgemini.jpawithhibernateapp.dto;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name="Product_info")

public class Product {
	@Id
	@Column
	private int pid;
	@Column
	private String pnamwe;
}

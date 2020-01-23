package com.capgemini.springcore.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
@Component
public class Pet {

	private String name;
	@Autowired
	//@Qualifier("Dog")
	private Animal animal;

	public Pet(String name, Animal animal) {
		this.name = name;
		this.animal = animal;
	}

	public Pet() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

}
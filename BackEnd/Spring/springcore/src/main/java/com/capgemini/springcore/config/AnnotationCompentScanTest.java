package com.capgemini.springcore.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.capgemini.springcore.beans.Animal;
import com.capgemini.springcore.beans.Pet;

public class AnnotationCompentScanTest {
	public static void main(String[] args) {
		ApplicationContext context=new AnnotationConfigApplicationContext(CompomentScanConfig.class);
		
		Animal animal=context.getBean(Animal.class);
		animal.makeSound();
		
		Pet pet=context.getBean(Pet.class);
		pet.getAnimal().makeSound();
		
	}
}
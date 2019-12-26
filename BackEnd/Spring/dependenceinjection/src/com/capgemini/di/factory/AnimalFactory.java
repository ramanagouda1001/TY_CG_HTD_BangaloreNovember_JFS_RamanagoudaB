package com.capgemini.di.factory;

import com.capgemini.di.dao.Animal;
import com.capgemini.di.dao.Dog;

public class AnimalFactory {
	private AnimalFactory() {
		// TODO Auto-generated constructor stub
	}
	public static Animal getAnimal()
	{
		return new Dog();
	}
}

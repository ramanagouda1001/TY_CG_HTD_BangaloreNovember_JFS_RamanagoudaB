package com.capgemini.springcore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.capgemini.springcore.beans.Animal;
import com.capgemini.springcore.beans.Author;
import com.capgemini.springcore.beans.Book;
import com.capgemini.springcore.beans.Hello;
import com.capgemini.springcore.beans.Pet;
import com.capgemini.springcore.config.BeansConfig;

public class AnnotationConfigApp {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(BeansConfig.class);
		Hello hello = context.getBean(Hello.class);
		System.out.println(hello.getMsg());
		System.out.println(hello.getCount());

		System.out.println("*************************************");
		Animal animal = context.getBean(Animal.class);
		animal.makeSound();
		System.out.println("*************************************");
		
		Hello hello1 = context.getBean(Hello.class);
		System.out.println(hello1.getMsg());
		System.out.println(hello1.getCount());
		
		System.out.println("****************************");
		System.out.println(hello==hello1);
		
		System.out.println("****************************");

		Pet pet=context.getBean(Pet.class);
		System.out.println(pet.getName());
		pet.getAnimal().makeSound();
		
		System.out.println("****************************");
		
		Author author=context.getBean(Author.class);
		//author.display();
		System.out.println("****************************");
		
		Book book=context.getBean(Book.class);
		System.out.println(book.getName());
		System.out.println(book.getAuthor().getName());
	}
}

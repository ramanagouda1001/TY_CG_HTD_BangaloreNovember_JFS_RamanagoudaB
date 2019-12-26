package com.capgemini.springcore.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

import com.capgemini.springcore.beans.Author;
import com.capgemini.springcore.beans.Book;
import com.capgemini.springcore.beans.Cat;
import com.capgemini.springcore.beans.Dog;
import com.capgemini.springcore.beans.Hello;
import com.capgemini.springcore.beans.Pet;

@Configuration
public class BeansConfig {
	@Bean("hello")
	@Scope("prototype")
	public Hello getHello() {
		Hello hello = new Hello();
		hello.setMsg("I love You");
		hello.setCount(3000);
		return hello;
	}

	@Bean(name="Dog")
	public Dog getDog() {
		return new Dog();
	}
	@Bean(name="Cat")
	@Primary
	public Cat getCat()
	{
		return new Cat();
	}

	@Bean("Pet")
	public Pet getPet() {
		Pet pet=new Pet();
		pet.setName("Tufy");
	//	pet.setAnimal(getDog());
		return pet;
	}
	@Bean("Author")
	public Author getAuthor()
	{
		Author a=new Author();
		a.setName("Author:-Rohan");
		return a;
	}
	@Bean("Book")
	public Book getBook()
	{
		Book b=new Book();
		b.setName("Book is:-I am Ironman");
		b.setAuthor(getAuthor());
		return b;
	}
}

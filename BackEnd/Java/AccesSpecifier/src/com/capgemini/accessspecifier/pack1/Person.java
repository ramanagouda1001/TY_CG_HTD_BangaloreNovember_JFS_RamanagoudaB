package com.capgemini.accessspecifier.pack1;
public class Person 
{
	public String name;
	public static int age=2;
	public Person(String name)
	{
		this.name=name;
		
	}
	public void display()
	{
		System.out.println("name is "+name);
	}
	public static void personDetails()
	{
		System.out.println("person age is "+age);
	}
}

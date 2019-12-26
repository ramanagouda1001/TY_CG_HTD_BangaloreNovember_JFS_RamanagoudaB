package com.capgemini.accessspecifier.pack1;
public class Student 
{
	protected String name;

	protected Student(String name)
	{
		this.name = name;
	}
	protected void studDetails()
	{
		System.out.println("the name in parent class"+name);
	}
	
}

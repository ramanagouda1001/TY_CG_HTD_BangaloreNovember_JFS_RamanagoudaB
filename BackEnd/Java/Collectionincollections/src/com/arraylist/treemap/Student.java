package com.arraylist.treemap;
public class Student 
{
	int age;
	String name;
	String Standared;
	public Student(int age, String name, String standared) {
		super();
		this.age = age;
		this.name = name;
		Standared = standared;
	}
	@Override
	public String toString() {
		return "Student [age=" + age + ", name=" + name + ", Standared=" + Standared + "]";
	}
	
}

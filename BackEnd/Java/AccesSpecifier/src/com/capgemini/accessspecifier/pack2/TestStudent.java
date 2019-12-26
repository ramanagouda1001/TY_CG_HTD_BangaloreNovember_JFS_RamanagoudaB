package com.capgemini.accessspecifier.pack2;

import com.capgemini.accessspecifier.pack1.Student;

public class TestStudent extends Student
{
	public TestStudent(String name)
	{
		super(name);
	}
	void studentDetails()
	{
		System.out.println("name  "+name);
	}
	public static void main(String[] args) 
	{
		TestStudent n=new TestStudent("rohan");
		n.studentDetails();
	}
}

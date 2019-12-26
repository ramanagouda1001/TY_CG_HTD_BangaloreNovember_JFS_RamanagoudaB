package com.capgemini.Treemap;

public class Student  implements Comparable<Student>
{
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + "]";
	}
	String name;
	int age;
	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	@Override
	public int compareTo(Student o) {
		// TODO Auto-generated method stub
		if(this.age>o.age)
			return 1;
		else if(this.age<o.age)
			return -1;
		else
			return 0;
	//	return this.name.compareTo(o.name);
	}
}

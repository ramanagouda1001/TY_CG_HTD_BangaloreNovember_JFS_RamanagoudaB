package com.capgemini.treeset;
public class Employee implements Comparable<Employee>{
	int age;
	String name;
	int salary;
	public Employee(int age, String name, int salary) {
		super();
		this.age = age;
		this.name = name;
		this.salary = salary;
	}
//	@Override
//	public int compareTo(Employee o) {
//		if(this.salary>o.salary) {
//			return 1;
//		}
//		else if(this.salary<o.salary) {
//			return -1;
//		} else {
//			return 0;
//		}
	//}
//	@Override
//	public int compareTo(Employee o) {
//		if(this.age>o.age) {
//			return 1;
//		}
//		else if(this.age<o.age) {
//			return -1;
//		} else {
//			return 0;
//		}
//} 
	@Override
	public int compareTo(Employee o) {
	return 0;
	}
	}

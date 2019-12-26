package com.capgemini.treeset;
import java.util.TreeSet;

public class TreeSet3 {
	public static void main(String[] args) {
		EmployeeName e1= new EmployeeName();
		EmployeeAge e2= new EmployeeAge();
		EmployeeSalary e3= new EmployeeSalary();
		TreeSet<Employee> t1= new TreeSet<Employee>(e1);
		t1.add(new Employee(22,"jon",30000));
		t1.add(new Employee(25,"dan",24000));     
		t1.add(new Employee(23,"tom",31000));
		
		for (Employee e4 : t1) {
			System.out.println("name is "+e4.name+" age is "+e4.age+" sal "+e4.salary);
		}
		
		
		
	}

}

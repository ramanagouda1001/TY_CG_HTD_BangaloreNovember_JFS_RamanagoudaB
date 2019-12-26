package com.capgemini.hashset;
import java.util.HashSet;

public class HashSet2 {
	public static void main(String[] args) {
		HashSet<Student> h1= new HashSet<Student>();
		h1.add(new Student("sam",22));
		h1.add(new Student("john",23));
		h1.add(new Student("tom",24));
		h1.add(new Student("sam",22));
		for (Student s1 : h1) {
			System.out.println(s1.name+" age is "+s1.age);
		}
	}

}

package com.capgemini.queue;
import java.util.PriorityQueue;

public class PriorityQueue2 {
	public static void main(String[] args) {
	   PriorityQueue<Student> s1= new PriorityQueue<Student>();
	   s1.add(new Student(22,"saif"));
	   s1.add(new Student(24,"kaif"));
	   s1.add(new Student(22,"saif"));
	  
	   for (Student p1 : s1) {
		   System.out.println(p1);
		
	}
	}

}

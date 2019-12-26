package com.arraylist.treemap;

import java.util.*;
import java.util.Map.Entry;

public class Treemap4 
{
	public static void main(String[] args) 
	{
		ArrayList<Student> s1=new ArrayList<Student>();
		s1.add(new Student(10,"rohan","1st"));
		s1.add(new Student(10,"pawan","1st"));
		//2nd 
		ArrayList<Student> s2=new ArrayList<Student>();
		s2.add(new Student(11,"Pawan","2st"));
		s2.add(new Student(11,"Rakesh","2st"));
		//3rd
		ArrayList<Student> s3=new ArrayList<Student>();
		s3.add(new Student(12,"Arun","3rd"));
		s3.add(new Student(12,"Vikas","3rd"));
		//treemap
		
		TreeMap<String,ArrayList<Student>> m=new TreeMap<String,ArrayList<Student>>();
		
		m.put("1st", s1);
		m.put("2st", s2);
		m.put("3st", s3);
		
		Set<Entry<String, ArrayList<Student>>> s=m.entrySet();
		for (Entry<String, ArrayList<Student>> e: s) {
			System.out.println(e.getKey());
			System.out.println(e.getValue());
			System.out.println("-------------------");
		}
		
	}
}

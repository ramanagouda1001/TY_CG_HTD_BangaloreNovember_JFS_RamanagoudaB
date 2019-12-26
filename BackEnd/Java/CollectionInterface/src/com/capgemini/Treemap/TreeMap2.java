package com.capgemini.Treemap;

import java.util.*;
import java.util.Map.Entry;

public class TreeMap2 
{
	public static void main(String[] args) 
	{
		SortinfAge o=new SortinfAge();
		TreeMap<Student,String> m=new TreeMap<Student,String>(o);
		Student s1=new Student("rohan",23);
		Student s2=new Student("rama",10);
		Student s3=new Student("ahit",19);
		m.put(s1, "1st standared");
		m.put(s2, "1st standared");	
		m.put(s3, "1st standared");
		Set<Entry<Student, String>> s=m.entrySet();
		for (Entry<Student, String> entry : s) {
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
		}
		
	}
}

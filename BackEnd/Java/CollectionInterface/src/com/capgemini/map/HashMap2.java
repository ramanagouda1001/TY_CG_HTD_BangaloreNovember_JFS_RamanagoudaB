package com.capgemini.map;

import java.util.*;
import java.util.Map.Entry;

public class HashMap2 
{
	public static void main(String[] args) 
	{
		HashMap<Integer,Student> h1=new HashMap<Integer,Student>();
		h1.put(1, new Student(22,"rohan"));
		h1.put(2, new Student(33,"rama"));
		h1.put(null,new Student(55,"ras"));
		
		Collection<Student> s=h1.values();
		for (Student s1 : s) {
			System.out.println(s1);
		}
		System.out.println(h1.get(1));
		System.out.println(h1.containsKey(2));
		System.out.println(h1.containsValue(new Student(22,"rohan")));
		
		System.out.println("size is "+h1.size());
		
		System.out.println("----------------");
		Set<Map.Entry<Integer,Student>> s1=h1.entrySet();
		
		for (Entry<Integer, Student> e : s1) {
			System.out.println(e.getKey());
			Student s2=e.getValue();
			System.out.println(s2.stuAge);
			System.out.println(s2.stuName);
			System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&");
		}
	}
}

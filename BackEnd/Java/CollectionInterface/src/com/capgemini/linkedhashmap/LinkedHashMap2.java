package com.capgemini.linkedhashmap;

import java.util.*;
import java.util.Map.Entry;

public class LinkedHashMap2
{
	public static void main(String[] args) 
	{
		LinkedHashMap<Integer,Employee> m=new LinkedHashMap<Integer,Employee>();
		m.put(2, new Employee(230000,"rohan"));
		m.put(1, new Employee(230000,"rama"));
		m.put(3, new Employee(230000,"ajay"));
		
		Set<Entry<Integer, Employee>> s=m.entrySet();
		for (Entry<Integer, Employee> entry : s) {
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
		}
		System.out.println(m.containsKey(2));
		System.out.println(m.containsValue(new Employee(230000,"rohan")));
	}
}

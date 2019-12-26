package com.capgemini.arraylist;

import java.util.*;

public class CollArrayList 
{
	public static void main(String[] args) 
	{
		ArrayList<String> l1=new ArrayList<String>();
		l1.add("rohan");
		l1.add("Rohit");
		l1.add("Pawan");
		l1.add("Pavan");
		l1.add("Shiva");
		l1.add("Dilipa");
		l1.add("Arun");
		ArrayList<String> l2=new ArrayList<String>();
		l2.add("Rama");
		l2.add("Arun");
		l2.add("Shri");
		l2.add("Akshay");
		l2.add("kumar");
		l2.add("praveen");

		System.out.println("Size of l1 is"+l1.size());
		System.out.println("Is arraylist l1 is empty="+l1.isEmpty());
		System.out.println("is arraylist l1 contain Pawan="+l1.contains("Pawan"));
		System.out.println(l1);
		l1.remove("rohan");
		System.out.println("list after removing rohan");
		System.out.println(l1);
		l1.addAll(l2);
		System.out.println("array list after adding l2 list");
		System.out.println(l1);
		l1.removeAll(l2);
		System.out.println("list after removing l2");
		System.out.println(l1);
		l1.containsAll(l2);		
		System.out.println(l1);
		l1.remove(0);
		System.out.println("after removing rohit");
		System.out.println(l1);
		System.out.println("Index of shiva is="+l1.indexOf("Shiva"));
		System.out.println(l1.subList(0, 3));
	}
}

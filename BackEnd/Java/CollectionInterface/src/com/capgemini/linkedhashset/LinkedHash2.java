package com.capgemini.linkedhashset;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class LinkedHash2 {
	public static void main(String[] args) {
		LinkedHashSet<Integer> l1= new LinkedHashSet<Integer>();
		l1.add(12);
		l1.add(23);
		l1.add(45);
		l1.add(65);
		l1.add(12);
		
		Iterator<Integer> itr= l1.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
		LinkedHashSet<String> l2= new LinkedHashSet<String>();
		l2.add("john");
		l2.add("watson");
		l2.add("sherlock");
		l2.add("watson");
		
		
		Iterator<String> itr1= l2.iterator();
		while(itr1.hasNext()) {
			System.out.println(itr1.next());
		}
	}
	}


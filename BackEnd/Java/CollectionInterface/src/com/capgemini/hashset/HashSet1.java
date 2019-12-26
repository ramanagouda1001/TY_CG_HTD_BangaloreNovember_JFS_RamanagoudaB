package com.capgemini.hashset;

import java.util.HashSet;

public class HashSet1 {
	public static void main(String[] args) {
		HashSet h1=new HashSet();
		h1.add(45);
		h1.add(2);
		h1.add(null);
		h1.add(4);
		h1.add(10);
		h1.add(45);
		System.out.println(h1);
		for (Object object : h1) {
			System.out.println(object);
		}
		HashSet<String> h2=new HashSet<String>();
		h2.add("john");
		h2.add("sam");
		h2.add(null);
		h2.add(null);
		h2.add("tom");
		h2.add("john");
		System.out.println(h2);
		for (String string : h2) {
			System.out.println(string);
			
		}
	}

}

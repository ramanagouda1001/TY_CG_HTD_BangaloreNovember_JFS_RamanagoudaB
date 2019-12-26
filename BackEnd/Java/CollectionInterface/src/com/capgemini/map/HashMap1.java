package com.capgemini.map;

import java.util.*;
import java.util.Map.Entry;

public class HashMap1 
{
	public static void main(String[] args) 
	{
		HashMap<Integer,String> l=new HashMap<Integer, String>();
		l.put(2,"suresh");
		l.put(1, "ramesh");
		l.put(4,"dinesh");
		l.put(3,"ganesh");		
		Set<Entry<Integer, String>> s=l.entrySet();
		
		for (Map.Entry<Integer, String> e : s) {
			System.out.println(e.getKey());
			System.out.println(e.getValue());
			System.out.println("---------------------------");
			
		}
	}
}

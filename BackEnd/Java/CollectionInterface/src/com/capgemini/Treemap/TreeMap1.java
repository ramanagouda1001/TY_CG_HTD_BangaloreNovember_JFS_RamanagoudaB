package com.capgemini.Treemap;

import java.util.*;
import java.util.Map.Entry;

public class TreeMap1 
{
	public static void main(String[] args) 
	{
		TreeMap<Integer,String> m=new TreeMap<Integer,String>();
		m.put(22,"anu");
		m.put(123,"rohan");
		m.put(2,"rohan");
		Set<Map.Entry<Integer, String>> s=m.entrySet();
		for (Entry<Integer, String> e : s) {
			System.out.println(e.getKey());
			System.out.println(e.getValue());
			System.out.println("-------------------------------------");
		}
	}
}

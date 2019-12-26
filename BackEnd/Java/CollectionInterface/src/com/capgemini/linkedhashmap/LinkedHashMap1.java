package com.capgemini.linkedhashmap;

import java.util.*;


public class LinkedHashMap1 
{
	public static void main(String[] args) 
	{
		LinkedHashMap<String,Integer> h=new LinkedHashMap<String,Integer>();
		h.put("Rajijinagar", 586103);
		h.put("BTM", 586165);
		h.put("BTR", 586158);
		h.put(null, null);
		h.put(null, 588158);
		Set<Map.Entry<String, Integer>> s=h.entrySet();
		for(Map.Entry<String,Integer> m:s)
		{
			System.out.println(m.getKey());
			System.out.println(m.getValue());
			System.out.println("----------------------");
		}
		System.out.println(h.containsKey("BTR"));
		System.out.println(h.containsValue(586103));
		h.remove("BTM");
		for(Map.Entry<String,Integer> m:s)
		{
			System.out.println(m.getKey());
			System.out.println(m.getValue());
			System.out.println("----------------------");
		}
	}

}

package com.capgemini.arraylist;

import java.util.*;

public class Arraylist 
{
	public static void main(String[] args) 
	{
		//arrayList is non-synchronized
		//dynamic in nature
		//duplication is allowed
		//it is index based and maintain the order of insertion
		//lot of shifting hence less efficiency
		ArrayList<Integer> a1=new ArrayList<Integer>();
		a1.add(1);
		a1.add(2);
		a1.add(99);
		a1.add(222);
		a1.add(100);
		a1.add(200);
		System.out.println("----------for each----");
		for(Integer i:a1)
		{
			System.out.println(i);
		}
		System.out.println("-------------itertator-----");
		Iterator<Integer> i=a1.iterator();
		while(i.hasNext())
		{
			System.out.println(i.next());
		}
		
		System.out.println("-----------------istIterator--------");
		ListIterator<Integer> it=a1.listIterator();
		while(it.hasNext())
		{
			System.out.println(it.next());
		}
		while(it.hasPrevious())
		{
			System.out.println(it.previous());
		}
	}
}

package com.capgemini.arraylist;
import java.util.*;
public class Coolection2 
{

	public static void main(String[] args)
	{
		ArrayList c=new ArrayList();
		c.add(12);
		c.get(1);
		c.add(22);
		c.add(32);
		c.add(42);
		Collection c1=new ArrayList();
		c1.add(12);
		c1.add(22);
		c1.add(320);
		c1.add(420);
		c1.add(23);
		System.out.println("The size of first collection="+c.size());
		System.out.println("the size of second collection="+c1.size());
		System.out.println(c.contains(12));
		c.addAll(c1);
		System.out.println("collection of c"+c);
		c.removeAll(c1);
		System.out.println("collection of c"+c);
		Object a[]=c.toArray();
//		for(int i=0;i<a.length-1;i++)
//		{
//			System.out.println(a[i]);
//		}
	}

}

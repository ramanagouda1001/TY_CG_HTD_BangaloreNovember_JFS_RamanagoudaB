package com.capgemini.arraylist;

import java.util.*;

public class Collection1 
{
	public static void main(String[] args) 
	{
		Collection c=new ArrayList();
		c.add(12);//adding elements
		System.out.println(c);
		c.remove(12);//removing
		System.out.println(c);
		System.out.println(c.isEmpty());//checking
		c.add(22);
		System.out.println(c.contains(22));//checking particular elements
		System.out.println(c.size());
		c.add("Hello");
		System.out.println(c);
	}
}

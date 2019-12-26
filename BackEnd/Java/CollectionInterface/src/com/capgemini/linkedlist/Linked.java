package com.capgemini.linkedlist;

import java.util.LinkedList;
import java.util.ListIterator;

public class Linked 
{
	public static void main(String[] args) 
	{
		LinkedList l=new LinkedList();
		l.add(2);
		l.add(3);
		l.add(22);
		l.add(36);
		l.add(2);
		l.add(null);
		ListIterator itr=l.listIterator();
		while(itr.hasNext())
		{
			System.out.println(itr.next());
		}
		l.remove(new Integer(36));
		System.out.println("----------------foreach-------------");
		for(Object i:l)
		{
			System.out.println(i);
		}

	}
}

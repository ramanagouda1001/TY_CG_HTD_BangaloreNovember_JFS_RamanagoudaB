package com.capgemini.vector;

import java.util.Vector;

public class VectorList 
{
	public static void main(String[] args) 
	{
		Vector l=new Vector();
		l.add(22);
		l.add(33);
		l.add(44);
		l.add(55);
		System.out.println(l.size());
		System.out.println(l);
		l.set(0,111);
		System.out.println(l);
		l.remove(new Integer(111));
		System.out.println(l);
	}
}

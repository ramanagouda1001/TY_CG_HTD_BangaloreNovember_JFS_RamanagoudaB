package com.capgemini.vector;

import java.util.Vector;

public class VectorListed 
{
	public static void main(String[] args) 
	{
		Vector v=new Vector();
		v.add(22);
		v.add(12);
		v.add(32);
		v.add(43);
		v.add(55);
		v.add(56);
		System.out.println(v.size());
		System.out.println(v.capacity());
		v.trimToSize();
		System.out.println(v.capacity());
		System.out.println(v);
		v.setSize(10);
		System.out.println(v);
		v.add(200);
		System.out.println(v);
		v.set(9,898);
		System.out.println(v);
	}
}

package com.capgemini.vector;

import java.util.Vector;

public class Vector3 
{
	public static void main(String[] args) 
	{
		Vector<Integer> v=new Vector<Integer>();
		v.addElement(22);
		v.addElement(12);
		v.addElement(12);
		v.addElement(12);
		System.out.println(v);
		v.remove(new Integer(12));
		System.out.println(v);
		 v.removeElementAt(0);
		 System.out.println(v);
		 System.out.println(v.size());
			System.out.println(v.capacity());

			
		 v.trimToSize();
		Object o[]=new Object[v.size()];
		v.copyInto(o);
		for(int i=0;i<o.length;i++)
		{			
			System.out.println(o[i]);
		}
		v.ensureCapacity(6);
		v.setSize(8);
		System.out.println(v.size());
		System.out.println(v.capacity());
		System.out.println(v);
	}
}

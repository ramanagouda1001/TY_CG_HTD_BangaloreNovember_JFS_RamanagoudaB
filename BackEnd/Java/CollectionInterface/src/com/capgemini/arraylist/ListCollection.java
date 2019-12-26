package com.capgemini.arraylist;

import java.util.*;

public class ListCollection 
{
		public static void main(String[] args) 
		{
			List l=new ArrayList();
			l.add(2);//passing index and element
			l.add(3);
			l.add(4);
			l.add(5);
			l.add(6);
			l.add(3);
			l.set(3, 89);
			System.out.println(l);
			System.out.println(l.size());
			//System.out.println(l.remove(0));//passing index
			//System.out.println(l.indexOf(3));//passing object and getting its index from first
			//System.out.println(l.lastIndexOf(3));//passing object and getting its index from last
			System.out.println(l.get(3));//passing index and getting object;
			System.out.println(l.subList(0, 6));
			System.out.println("----------------------------------------------");
			for(int i=0;i<l.size()-1;i++)
			{
				System.out.println(l.get(i));
			}
//			List l=new ArrayList();
//			l.add(2);
//			l.add(4);
//			l.add(3);
//			l.add(3);
//			int sum=0;
//			l.add(5);
//			l.add(6);
//			l.add(8);
//			l.add(9);
//			Collections.sort(l);
//			System.out.println(l);
//			for(int i=0;i<=l.size()-1;i++)
//			{
//				if(i+1==l.size())
//					break;
//				else
//				{
//					if(l.get(i)==l.get(i+1))
//					{
//						Integer m=(Integer) l.get(i+1);
//						m=(int)m;
//						l.set(i+1,m+1);
//						
//					}
//				}
//			}
//			for(int i=0;i<l.size();i++)
//			{
//				sum=sum+(int)l.get(i);
//			}
//			System.out.println(l);
//			System.out.println(sum);
//			System.out.println("------------------------------------8888888");
//			System.out.println(l.size());
//
		}
}

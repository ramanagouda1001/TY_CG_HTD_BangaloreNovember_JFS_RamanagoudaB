package com.capgemini.stack;

import java.util.Stack;

public class Stack1 
{
	public static void main(String[] args) 
	{
		Stack<Integer> s=new Stack<Integer>();
		s.add(23);
		s.add(36);
		s.push(222);
		s.add(23);
		s.add(36);
		s.push(222);
		System.out.println(s);
		s.pop();
		System.out.println(s);
		System.out.println(s.peek());
		System.out.println(s.search(36));
	}
}

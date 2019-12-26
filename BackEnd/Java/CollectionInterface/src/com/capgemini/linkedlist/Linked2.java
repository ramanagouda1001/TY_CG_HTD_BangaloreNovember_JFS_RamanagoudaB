package com.capgemini.linkedlist;

import java.util.LinkedList;

public class Linked2 
{
	public static void main(String[] args) 
	{
		LinkedList<Integer> l1=new LinkedList<Integer>();
		l1.add(2);
		l1.add(20);
		l1.add(20);
		l1.add(30);
		l1.add(40);
		l1.add(50);
		l1.add(20);
		l1.add(60);
		System.out.println(l1);
		l1.addFirst(10);
		l1.add(70);
		System.out.println(l1);
		System.out.println(l1.getFirst());
		System.out.println(l1.getLast());
		System.out.println(l1);
		l1.remove();
		System.out.println(l1);
		l1.removeLast();
		System.out.println(l1);
		l1.removeFirstOccurrence(20);
		System.out.println(l1);

		l1.removeLastOccurrence(20);
		System.out.println(l1);
		
		System.out.println("--------peek and peekfirst amd peek last-----------");
		System.out.println(l1.peekFirst());
		System.out.println(l1);
		System.out.println(l1.peekLast());
		System.out.println(l1);
		System.out.println(l1.peek());
		System.out.println(l1);
		

		System.out.println("--------pool and pollfirst amd poll last-----------");
		System.out.println(l1);
		System.out.println(l1.pollFirst());
		System.out.println(l1);
		System.out.println(l1.pollLast());
		System.out.println(l1);
		System.out.println(l1.poll());
		System.out.println(l1);


		System.out.println("--------offer and offerfirst amd offerlast-----------");
		System.out.println(l1);
		System.out.println(l1.offerFirst(333));
		System.out.println(l1);
		System.out.println(l1.offerLast(888));
		System.out.println(l1);
		System.out.println(l1.offer(101));
		System.out.println(l1);
		

		System.out.println("--------push and pop amd element-----------");
		l1.push(111);
		System.out.println(l1);
		System.out.println(l1.pop());
		System.out.println(l1);
		System.out.println(l1.element());
		System.out.println(l1);


	}
}

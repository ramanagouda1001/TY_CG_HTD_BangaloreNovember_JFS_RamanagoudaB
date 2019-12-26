package com.capgemini.queue;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.LinkedList;

public class ArrayDeque1 {
	public static void main(String[] args) {
		ArrayDeque<String> a1= new ArrayDeque<String>();
		a1.add("saif");
		a1.add("jon");
		a1.addFirst("john");
		a1.add("stark");
		
		Iterator<String> itr=a1.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		System.out.println("---linked list---");
		ArrayDeque<String> l1= new ArrayDeque<String>();
		l1.add("john");
		l1.add("sam");
		l1.add("watson");
		l1.add("sherlock");
		System.out.println(l1);
		System.out.println("add 1st and last---");
		l1.addFirst("saif");
		l1.addLast("kaif");
		System.out.println(l1);
		System.out.println("---get first &  last");
		System.out.println(l1.getFirst());
		System.out.println(l1.getLast());
		System.out.println("---remove,remove first and last");
		l1.remove();
		l1.removeFirst();
		l1.removeLast();
		System.out.println(l1);
	     l1.add("saif");
		System.out.println(l1);
		System.out.println("--remove 1st occ and last occ");
		l1.removeFirstOccurrence("saif");
		l1.removeLastOccurrence("saif");
		System.out.println(l1);
		
		System.out.println("---peek ,peek 1st and last----");
		System.out.println(l1);
		System.out.println(l1.peek());
		System.out.println(l1.peekFirst());
		System.out.println(l1.peekLast());

		System.out.println("----poll,poll first and poll last----");
		System.out.println(l1);
		System.out.println(l1.poll());
		System.out.println(l1.pollFirst());
		System.out.println(l1.pollLast());
		System.out.println("--offer ,offer 1st last");
		System.out.println(l1);
		l1.offer("ali");
		l1.offerLast("khan");
		l1.offerFirst("don");
		System.out.println(l1);
		
		
	}

}

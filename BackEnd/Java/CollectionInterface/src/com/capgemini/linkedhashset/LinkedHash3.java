package com.capgemini.linkedhashset;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class LinkedHash3 {
		public static void main(String[] args) {
			LinkedHashSet<Employee> h1=new LinkedHashSet<Employee>();
			h1.add(new Employee("john",22));
			h1.add(new Employee("sherlock",23));
			h1.add(new Employee("watson",24));
			h1.add(new Employee("john",22));
			Iterator<Employee> itr=h1.iterator();
			while(itr.hasNext()) {
				System.out.println(itr.next());
			}
		}

}

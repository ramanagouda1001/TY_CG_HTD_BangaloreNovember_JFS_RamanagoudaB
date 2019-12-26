package com.capgemini.treeset;
import java.util.Iterator;
import java.util.TreeSet;

public class TreeSet2 {
	public static void main(String[] args) {;
    TreeSet<Student> t1= new TreeSet<Student>();
    		t1.add(new Student(22,"john"));
    		t1.add(new Student(45,"sherlock"));
    		t1.add(new Student(23,"watson"));
    		t1.add(new Student(22,"john"));

    		Iterator<Student> itr=t1.iterator();
    		while(itr.hasNext()) {
    			System.out.println(itr.next());
    		}
//    		for (Student student : t1) {
//				System.out.println(student.age+student.name);
//			}
	}

}

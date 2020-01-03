package com.capgemini.jpawithhibernateapp;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.capgemini.onetoone.Employe_others;
import com.capgemini.onetoone.Employee_info;

public class TestOfOneToOne {
	public static void main(String[] args) {
		Employee_info obj=new Employee_info();
		obj.setName("hi");
		obj.setEmail("rohan@gmail.com");
		obj.setEmployee_id(1);
		obj.setPassword(123);
		Employe_others obj2=new Employe_others();
		obj2.setId(11);
		obj2.setAdhar_no(12345);
		obj2.setFather_name("helo");
		obj2.setEmployee(obj);
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("Test");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction transaction=entityManager.getTransaction();
		transaction.begin();
		//entityManager.persist(obj2);
//		Employee_info em=entityManager.find(Employee_info.class,1);
//		System.out.println(em.getOthers().getAdhar_no());
//		System.out.println(em.getOthers().getFather_name());
//		System.out.println("sucess");
	transaction.commit();
		}
}	

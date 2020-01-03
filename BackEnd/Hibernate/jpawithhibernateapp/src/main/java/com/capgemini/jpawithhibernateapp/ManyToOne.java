package com.capgemini.jpawithhibernateapp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.capgemini.onetoone.Employe_others;
import com.capgemini.onetoone.Employee_Exp;
import com.capgemini.onetoone.Employee_info;

public class ManyToOne {
	public static void main(String[] args) {
		Employee_info obj=new Employee_info();
		obj.setName("hi");
		obj.setEmail("rohan@gmail.com");
		obj.setEmployee_id(48);
		obj.setPassword(123);
		Employee_Exp obj2=new Employee_Exp();
		obj2.setCompany("Test");
		obj2.setExpId(200);
		obj2.setNoOfYear(3);
		obj2.setEmployee_info(obj);
		Employee_Exp obj3=new Employee_Exp();
		obj3.setCompany("Test");
		obj3.setExpId(30);
		obj3.setNoOfYear(3);
		obj3.setEmployee_info(obj);
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("Test");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction transaction=entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(obj2);
		entityManager.persist(obj3);
		System.out.println("sucess");
		transaction.commit();
		}
}

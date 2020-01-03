package com.capgemini.jpawithhibernateapp;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.capgemini.manytomany.TraninigInfo;
import com.capgemini.onetoone.Employee_info;

public class ManyToMany {
	public static void main(String[] args) {
		Employee_info obj=new Employee_info();
		obj.setEmployee_id(44);
		obj.setName("rohan");
		obj.setEmail("rohan@");
		obj.setPassword(1234);
		Employee_info obj1=new Employee_info();
		obj1.setEmployee_id(45);
		obj1.setName("rohan");
		obj1.setEmail("rohan@");
		obj1.setPassword(1234);
		List<Employee_info> list=new ArrayList<Employee_info>();
		TraninigInfo info=new TraninigInfo();
		info.setTid(100);
		info.setTname("dilipa");
		info.setEmp(list);
		EntityManager entityManager=null;
		EntityTransaction transaction=null;

		try {
			EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("Test");
			entityManager=entityManagerFactory.createEntityManager();
			transaction=entityManager.getTransaction();
			transaction.begin();
			entityManager.persist(info);
			System.out.println("Done");
			transaction.commit();
		}
		catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}

	}
}

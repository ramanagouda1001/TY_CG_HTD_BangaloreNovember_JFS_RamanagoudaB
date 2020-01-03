package com.rohan.confort;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.rohan.confory.dto.Hostel;

public class Insert {
	public static void main(String[] args) {
		Hostel h=new Hostel();
		h.setName("rohan");
		h.setRoomno(1);
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("Test");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction transaction=entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(h);
		System.out.println("saved");
		transaction.commit();
		entityManager.close();
		
	}
}

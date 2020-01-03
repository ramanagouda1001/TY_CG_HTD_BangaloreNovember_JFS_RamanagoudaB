package com.rohan.confort;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.rohan.confory.dto.Hostel;

public class Display {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("Test");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		Hostel h=entityManager.find(Hostel.class, 1);
		System.out.println(h.getRoomno());
		System.out.println(h.getName());
	}
}

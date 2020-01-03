package com.capgemini.jpawithhibernateapp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.capgemini.jpawithhibernateapp.dto.Movie;

public class GetRefernece {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Test");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Movie m = entityManager.getReference(Movie.class, 109);
		// Movie m=entityManager.find(Movie.class, 101);
		// System.out.println(m.getClass());

		// the difference is find method hit databases even if object is not used
		// getReference does not hit the databases if object is not used
		// find will get the actual address of obj
		// getReference get thre proxy address
		// System.out.println(m);
		// if obj is not found find will give nullpointerException
		// if obj is not found getReference will give EntitynotFound exception

	}
}

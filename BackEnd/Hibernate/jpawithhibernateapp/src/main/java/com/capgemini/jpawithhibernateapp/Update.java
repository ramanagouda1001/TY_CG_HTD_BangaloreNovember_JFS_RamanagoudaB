package com.capgemini.jpawithhibernateapp;

import javax.persistence.*;

import com.capgemini.jpawithhibernateapp.dto.Movie;

import antlr.debug.TraceAdapter;

public class Update {
	public static void main(String[] args) {
		Movie m;

		EntityManager entityManager = null;
		EntityTransaction transaction = null;
		try {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Test");
			entityManager = entityManagerFactory.createEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();
			m = entityManager.find(Movie.class, 102);
			m.setMname("Avenger Infinity war");
			System.out.println("record update");
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}
	}
}

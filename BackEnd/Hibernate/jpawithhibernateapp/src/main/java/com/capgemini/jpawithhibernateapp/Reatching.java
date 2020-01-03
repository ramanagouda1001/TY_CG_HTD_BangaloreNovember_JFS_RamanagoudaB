package com.capgemini.jpawithhibernateapp;

import javax.persistence.*;

import com.capgemini.jpawithhibernateapp.dto.Movie;

public class Reatching {

	public static void main(String[] args) {
		EntityManager entityManager = null;
		EntityTransaction transaction = null;
		try {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Test");
			entityManager = entityManagerFactory.createEntityManager();
			Movie m1 = entityManager.find(Movie.class, 101);
			System.out.println(entityManager.contains(m1));
			entityManager.detach(m1);
			System.out.println(entityManager.contains(m1));
			m1 = entityManager.merge(m1);
			m1.setMname("BAD BAD");
			System.out.println("upadted");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		entityManager.close();
	}
}

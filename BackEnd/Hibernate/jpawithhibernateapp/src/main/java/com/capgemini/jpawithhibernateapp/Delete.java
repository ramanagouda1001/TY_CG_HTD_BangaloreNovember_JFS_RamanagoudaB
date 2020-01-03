package com.capgemini.jpawithhibernateapp;

import javax.persistence.*;

import com.capgemini.jpawithhibernateapp.dto.Movie;

public class Delete {
	public static void main(String[] args) {
		EntityManager entityManager=null;
		EntityTransaction transaction=null;
		try {
			EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("Test");
			entityManager=entityManagerFactory.createEntityManager();
			transaction=entityManager.getTransaction();
			transaction.begin();
			Movie e=entityManager.find(Movie.class, 107);
			entityManager.remove(e);
			System.out.println("Deleted");
			transaction.commit();
		}
		catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}
	}
}

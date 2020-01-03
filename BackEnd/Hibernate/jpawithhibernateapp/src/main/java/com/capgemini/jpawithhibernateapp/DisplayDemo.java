package com.capgemini.jpawithhibernateapp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.capgemini.jpawithhibernateapp.dto.Movie;

public class DisplayDemo {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("Test");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		Movie m=entityManager.find(Movie.class,101);
		System.out.println("ID="+m.getMid());
		System.out.println("Movie="+m.getMname());
		System.out.println("Rating="+m.getRating());
		entityManager.close();
	}
}

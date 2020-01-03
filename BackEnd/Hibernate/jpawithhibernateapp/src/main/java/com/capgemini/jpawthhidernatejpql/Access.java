package com.capgemini.jpawthhidernatejpql;

import java.util.List;

import javax.persistence.*;

import com.capgemini.jpawithhibernateapp.dto.Movie;

public class Access {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("Test");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		//String jpql="from Movie";
		String jpql="select mname from Movie";
		Query query=entityManager.createQuery(jpql);
		List<String> list=query.getResultList();
		for (String string : list) {
			System.out.println(string);
		}
	}
}

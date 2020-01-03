package com.capgemini.jpawthhidernatejpql;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Update {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("Test");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction transaction =entityManager.getTransaction();
		transaction.begin();
		String jpql="update Movie set mname='abcd'";
		Query query=entityManager.createQuery(jpql);
		query.executeUpdate();
		transaction.commit();
		entityManager.close();
		System.out.println("updated");
		}
}

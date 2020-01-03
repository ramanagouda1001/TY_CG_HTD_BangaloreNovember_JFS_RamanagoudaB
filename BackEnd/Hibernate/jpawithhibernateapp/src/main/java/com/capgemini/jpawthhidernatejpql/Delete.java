package com.capgemini.jpawthhidernatejpql;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Delete {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory=null;
		EntityManager entityManager=null;
		EntityTransaction transaction=null;
		try {
			entityManagerFactory=Persistence.createEntityManagerFactory("Test");
			entityManager=entityManagerFactory.createEntityManager();
			transaction=entityManager.getTransaction();
			transaction.begin();
			String jpql="delete from Movie where mid=119";
			Query query=entityManager.createQuery(jpql);
			query.executeUpdate();
			System.out.println("deleted");
			transaction.commit();
			entityManager.close();
			
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}
}

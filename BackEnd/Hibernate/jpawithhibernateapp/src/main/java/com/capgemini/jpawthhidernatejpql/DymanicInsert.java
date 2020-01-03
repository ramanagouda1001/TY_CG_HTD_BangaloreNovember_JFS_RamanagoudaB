package com.capgemini.jpawthhidernatejpql;

import javax.persistence.*;

public class DymanicInsert {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Test");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		String jpql = "insert into Movie values(:id,:name,:rating)";
		Query query = entityManager.createNativeQuery(jpql);
		query.setParameter("id", 120);
		query.setParameter("name", "hi");
		query.setParameter("rating", "hi");
		int count = query.executeUpdate();
		System.out.println(count);
		transaction.commit();
	}
}

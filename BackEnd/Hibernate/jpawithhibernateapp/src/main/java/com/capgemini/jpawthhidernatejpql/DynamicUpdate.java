package com.capgemini.jpawthhidernatejpql;

import javax.persistence.EntityManagerFactory;
import javax.persistence.*;

public class DynamicUpdate {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("Test");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction transaction=entityManager.getTransaction();
		transaction.begin();
	//	String jpql="insert into Movie values(:id,:name,:rating)";
		String jpql="update Movie set mname=:name where mid=:id";
		Query query=entityManager.createQuery(jpql);
		query.setParameter("name","hi");
		query.setParameter("id", 109);
		
		int count=query.executeUpdate();
		if(count>0)
			System.out.println("got");
		transaction.commit();
	}
}

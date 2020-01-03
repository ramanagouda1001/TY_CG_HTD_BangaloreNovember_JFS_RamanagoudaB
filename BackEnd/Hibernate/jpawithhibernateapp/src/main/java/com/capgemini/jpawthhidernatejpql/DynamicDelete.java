package com.capgemini.jpawthhidernatejpql;

import javax.persistence.*;

public class DynamicDelete {
		public static void main(String[] args) {
			EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("Test");
			EntityManager entityManager=entityManagerFactory.createEntityManager();
			EntityTransaction transaction=entityManager.getTransaction();
			transaction.begin();
		//	String jpql="insert into Movie values(:id,:name,:rating)";
			String jpql="delete from Movie where mid=:id";
			Query query=entityManager.createQuery(jpql);
			query.setParameter("id", 109);
			
			int count=query.executeUpdate();
			if(count>0)
				System.out.println("got");
			transaction.commit();
		}
	}


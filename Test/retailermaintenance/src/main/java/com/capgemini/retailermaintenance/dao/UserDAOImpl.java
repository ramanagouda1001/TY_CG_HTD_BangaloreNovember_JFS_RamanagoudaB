package com.capgemini.retailermaintenance.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.capgemini.retailermaintenance.bean.UserInfo;
import com.capgemini.retailermaintenance.exception.RetailerMaintenanceException;

import antlr.debug.TraceAdapter;

@Repository
public class UserDAOImpl implements UserDAO{

	@PersistenceUnit
	EntityManagerFactory entityManagerFactory;
	
	@Override
	public boolean create(UserInfo bean) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		try {
			entityTransaction.begin();
			entityManager.persist(bean);
			entityTransaction.commit();
			return true;
		}catch(Exception e) {
			throw new RetailerMaintenanceException("Already Present");
		}
	}

	@Override
	public boolean authUser(String email, String password) {
		boolean status=false;
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		String jpql="from UserInfo where email=:email";
		TypedQuery<UserInfo> query=entityManager.createQuery(jpql,UserInfo.class);
		query.setParameter("email", email);
		try {
			UserInfo bean=query.getSingleResult();
			if(bean.getPassword().equals(password))
			{
				return status=true;
			}
			return status;
		}
		catch (Exception e) {
			throw new RetailerMaintenanceException("Not found");
		}
	}

	@Override
	public boolean updatepassword(String email, String password) {
		boolean status=false;
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		String jpql="from UserInfo where email=:email";
		TypedQuery<UserInfo> query=entityManager.createQuery(jpql,UserInfo.class);
		query.setParameter("email", email);
		try {
			UserInfo bean=query.getSingleResult();
			entityTransaction.begin();
			bean.setPassword(password);
			status=true;
			entityTransaction.commit();
			return status;
		}
		catch (Exception e) {
			throw new RetailerMaintenanceException("Not found");
		}
	}

}

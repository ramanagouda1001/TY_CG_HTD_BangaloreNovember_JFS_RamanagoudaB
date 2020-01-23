package com.capgemini.forestmanagementrest.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.capgemini.forestmanagementrest.bean.Account;
import com.capgemini.forestmanagementrest.exception.ForestManagementSystem;

@Repository
public class AdminDAOImpl implements AdminDAO {

	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;
	
	
	@Override
	public boolean getAdmin(Account admin) {
		EntityManager entiryManager = entityManagerFactory.createEntityManager();
		EntityTransaction  transaction = entiryManager.getTransaction();
		try {
			boolean status = false;
			transaction.begin();
			Account object = entiryManager.find(Account.class, admin.getUsername());
			if (object.getPassword().equals(admin.getPassword())) 
				{
					status = true;
				}
			return status;
		} catch (Exception e) {
			throw new ForestManagementSystem("Account is not Present");
		}

	}
	@Override
	public boolean addAccount(Account bean) {
		EntityManager entiryManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entiryManager.getTransaction();
		try {
			boolean status = false;
			transaction.begin();
			entiryManager.persist(bean);
			status = true;
			transaction.commit();
			return status;
		} catch (Exception e) {
			throw new ForestManagementSystem("ACCOUNT IS ALREADY PRESENT");
		}
	}
	
	@Override
	public boolean deleteAccount(Account bean) {
		EntityManager entiryManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entiryManager.getTransaction();
		try {
			boolean status = false;
			transaction.begin();
			Account object = entiryManager.find(Account.class, bean.getUsername());
			if (object.getPassword().equals(bean.getPassword())) {
				entiryManager.remove(object);
				status = true;
			}
			transaction.commit();
			return status;
		} catch (Exception e) {
			throw new ForestManagementSystem("YOUR ARE NOT ACCOUNT IS NOT PRESENT PLEASE CONTACT ADMIN");
		}
	}

	@Override
	public List<Account> listAccount() {
		EntityManager entiryManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entiryManager.getTransaction();
		try {
			transaction.begin();
			String jpql="from Account";
			Query query=entiryManager.createQuery(jpql);
			List<Account> list=query.getResultList();
			transaction.commit();
			return list;
		} catch (Exception e) {
		}
		return null;

	}
}

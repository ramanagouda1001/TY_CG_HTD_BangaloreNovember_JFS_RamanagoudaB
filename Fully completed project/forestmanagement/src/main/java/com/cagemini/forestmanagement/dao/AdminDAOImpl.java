package com.cagemini.forestmanagement.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.cagemini.forestmanagement.bean.Account;
import com.cagemini.forestmanagement.exception.ForestManagementSystem;

public class AdminDAOImpl implements AdminDAO {

	private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Forest_Test");
	private EntityManager entiryManager = null;
	private EntityTransaction transaction = null;

	@Override
	public boolean getAdmin(Account admin)  {
		entiryManager = entityManagerFactory.createEntityManager();
		transaction = entiryManager.getTransaction();
		try {
			boolean status = false;
			transaction.begin();
			Account object = entiryManager.find(Account.class, admin.getUsername());
			if (object.getPassword().equals(admin.getPassword())) {
				if(object.getRole().equals("admin"))
				status = true;
			}
			return status;
		} catch (Exception e) {
			throw new ForestManagementSystem("YOUR ARE NOT ADMIN");
		}
	}

	@Override
	public boolean addAccount(Account bean) {
		entiryManager = entityManagerFactory.createEntityManager();
		transaction = entiryManager.getTransaction();
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
	public boolean getAccount(String username, String password) {
		entiryManager = entityManagerFactory.createEntityManager();
		transaction = entiryManager.getTransaction();
		try {
			boolean status = false;
			transaction.begin();
			Account object = entiryManager.find(Account.class, username);
			if (object.getPassword().equals(password)) {
				if(object.getRole().equals("client"))
				{
					status = true;
				}
			}
			transaction.commit();
			return status;
		} catch (Exception e) {
			throw new ForestManagementSystem("YOUR ARE NOT ACCOUNT IS NOT PRESENT PLEASE CONTACT ADMIN");
		}

	}

	@Override
	public boolean deleteAccount(Account bean) {
		entiryManager = entityManagerFactory.createEntityManager();
		transaction = entiryManager.getTransaction();
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
		entiryManager = entityManagerFactory.createEntityManager();
		transaction = entiryManager.getTransaction();
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

	@Override
	public boolean updateAccount(String newPassword, String oldPassword) {
		entiryManager = entityManagerFactory.createEntityManager();
		transaction = entiryManager.getTransaction();
		try {
			boolean status=false;
			transaction.begin();
			String jpql="update Account set password=:newPassword where password=:oldPassword";
			Query query=entiryManager.createQuery(jpql);
			query.setParameter("newPassword", newPassword);
			query.setParameter("oldPassword", oldPassword);
			int count=query.executeUpdate();
			if(count>0)
				status=true;					
			transaction.commit();
			return status;
		}
		catch (Exception e) {
			throw new ForestManagementSystem("UNABLE TO UPDATE ");
		}
	}

	@Override
	public boolean getAccountSchedular(String username, String password) {
		entiryManager = entityManagerFactory.createEntityManager();
		transaction = entiryManager.getTransaction();
		try {
			boolean status = false;
			transaction.begin();
			Account object = entiryManager.find(Account.class, username);
			if (object.getPassword().equals(password)) {
				if(object.getRole().equals("Schedular"))
				{
					status = true;
				}
			}
			transaction.commit();
			return status;
		} catch (Exception e) {
			throw new ForestManagementSystem("YOUR ARE NOT ACCOUNT IS NOT PRESENT PLEASE CONTACT ADMIN");
		}
	}
}

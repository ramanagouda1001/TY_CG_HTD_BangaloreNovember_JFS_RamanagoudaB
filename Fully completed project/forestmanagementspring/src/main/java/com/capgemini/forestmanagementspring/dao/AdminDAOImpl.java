package com.capgemini.forestmanagementspring.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.capgemini.forestmanagementspring.bean.Account;
import com.capgemini.forestmanagementspring.exception.ForestManagementSystem;

@Repository
public class AdminDAOImpl implements AdminDAO {

	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;

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
			throw new ForestManagementSystem("Account Is Already Present");
		}
	}

	@Override
	public boolean deleteAccount(Account bean) {
		EntityManager entiryManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entiryManager.getTransaction();
		try {
			boolean status = false;
			transaction.begin();
			Account object = entiryManager.find(Account.class, bean.getEmail());
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
			String jpql = "from Account";
			Query query = entiryManager.createQuery(jpql);
			@SuppressWarnings("unchecked")
			List<Account> list = query.getResultList();
			transaction.commit();
			return list;
		} catch (Exception e) {
		}
		return null;

	}

	@Override
	public Account getAdmin(Account admin) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		try {
			transaction.begin();
			Account obj = entityManager.find(Account.class, admin.getEmail());
			transaction.commit();
			if (obj.getPassword().equals(admin.getPassword())) {
				return obj;
			} else {
				return null;
			}
		} catch (Exception e) {
			throw new ForestManagementSystem("Account is Not Found");
		}
	}

	@Override
	public boolean updateAccount(Account bean) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction transaction=entityManager.getTransaction();
		try {
			transaction.begin();
			Account obj=entityManager.find(Account.class, bean.getEmail());
			if(bean.getPassword()!=null) {
				obj.setPassword(bean.getPassword());
			}
			else
			{
				obj.setPassword(obj.getPassword());
			}
			if(bean.getRole()!=null) {
				obj.setRole(bean.getRole());
			}
			else {
				obj.setRole(obj.getRole());
			}
			transaction.commit();
			return true;
		}
		catch (Exception e) {
			throw new ForestManagementSystem("Account does Not Exist");
		}
	}
}

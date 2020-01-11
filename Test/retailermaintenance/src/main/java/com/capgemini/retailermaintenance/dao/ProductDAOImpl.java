package com.capgemini.retailermaintenance.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;

import org.springframework.stereotype.Repository;

import com.capgemini.retailermaintenance.bean.OrderInfo;
import com.capgemini.retailermaintenance.bean.ProductInfo;
import com.capgemini.retailermaintenance.exception.RetailerMaintenanceException;

@Repository
public class ProductDAOImpl  implements ProductDAO{

	@PersistenceUnit
	EntityManagerFactory entityManagerFactory;
	
	@Override
	public boolean add(ProductInfo bean) {
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
	public ProductInfo serach(int product_id) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		try {
			entityTransaction.begin();
			ProductInfo obj=entityManager.find(ProductInfo.class, product_id);
			entityTransaction.commit();
			return obj;
		}catch(Exception e) {
			throw new RetailerMaintenanceException("Not found");
		}
	}

	@Override
	public boolean addOrder(OrderInfo bean) {
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
}

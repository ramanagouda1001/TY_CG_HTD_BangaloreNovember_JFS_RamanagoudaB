package com.cagemini.forestmanagement.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.cagemini.forestmanagement.bean.Land;
import com.cagemini.forestmanagement.exception.ForestManagementSystem;

public class LandDAOImpl implements LandDAO {

	private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Forest_Test");
	private EntityManager entiryManager = null;
	private EntityTransaction transaction = null;
	@Override
	public boolean addLand(Land land) {
	
		entiryManager=entityManagerFactory.createEntityManager();
		transaction=entiryManager.getTransaction();
		try {
			boolean status=false;
			transaction.begin();
			entiryManager.persist(land);
			status=true;
			transaction.commit();
			return status;
		} catch (Exception e) {
			throw new ForestManagementSystem("LAND DETAILS ARE ALREADY PRESENT");
		}
	}

	@Override
	public boolean deleteLand(int landNumber) {
		entiryManager=entityManagerFactory.createEntityManager();
		transaction=entiryManager.getTransaction();
		try {
			boolean status=false;
			transaction.begin();
			Land land=entiryManager.find(Land.class, landNumber);
			entiryManager.remove(land);
			status=true;
			transaction.commit();
			return status;
		} catch (Exception e) {
			throw new ForestManagementSystem("LAND DETAILS ARE ALREADY DELETED OR NOT PRESENT");
		}

	}

	@Override
	public List<Land> displayLand() {
		entiryManager=entityManagerFactory.createEntityManager();
		transaction=entiryManager.getTransaction();
		try {
			transaction.begin();
			String jpql="from Land";
			Query query=entiryManager.createQuery(jpql);
			List<Land> list=query.getResultList();
			transaction.commit();
			if(list.isEmpty())
				return null;
			else
				return list;
		} catch (Exception e) {
			throw new ForestManagementSystem("EMPTY........");
		}
	}
}

package com.cagemini.forestmanagement.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.cagemini.forestmanagement.bean.Account;
import com.cagemini.forestmanagement.bean.Contract;
import com.cagemini.forestmanagement.exception.ForestManagementSystem;

public class ContractDAOImpl implements ContractDAO {

	private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Forest_Test");
	private EntityManager entiryManager = null;
	private EntityTransaction transaction = null;
	@Override
	public boolean addContract(Contract bean) {
		entiryManager = entityManagerFactory.createEntityManager();
		transaction = entiryManager.getTransaction();
		try {
			boolean status=false;
			transaction.begin();
			entiryManager.persist(bean);
			status=true;
			transaction.commit();
			return status;
		} catch (Exception e) {
			throw new ForestManagementSystem("ELEMENT IS ALREADY PRESENT");
		}
	}

	@Override
	public boolean deleteContact(int contract_no) {
		entiryManager = entityManagerFactory.createEntityManager();
		transaction = entiryManager.getTransaction();
		try {
			boolean status=false;
			transaction.begin();
			Contract contract=entiryManager.find(Contract.class, contract_no);
			entiryManager.remove(contract);
			status=true;
			transaction.commit();
			return status;
		} catch (Exception e) {
			throw new ForestManagementSystem("ELEMENT IS ALREADY DELETED");
		}
	}

	@Override
	public List<Contract> contractDetail() {
		entiryManager=entityManagerFactory.createEntityManager();
		transaction=entiryManager.getTransaction();
		try {
			transaction.begin();
			String jpql="from Contract";
			Query query=entiryManager.createQuery(jpql);
			List<Contract> list=query.getResultList();
			transaction.commit();
			return list;
		} catch (Exception e) {
			throw new ForestManagementSystem("EMPTY..................");
		}
	}

	@Override
	public Contract search(int contract_no) {
		entiryManager=entityManagerFactory.createEntityManager();
		transaction=entiryManager.getTransaction();
		try {
			transaction.begin();
			Contract contract=entiryManager.find(Contract.class,contract_no);
			transaction.commit();
			return contract;
		} catch (Exception e) {
			throw new ForestManagementSystem("Empty");
		}
	}

	@Override
	public List<Contract> serachProduct(String product_id) {
		entiryManager=entityManagerFactory.createEntityManager();
		transaction=entiryManager.getTransaction();
		try {
			transaction.begin();
			String jpql="from Contract where product_id=:product_id";
			Query query=entiryManager.createQuery(jpql);
			query.setParameter("product_id", product_id);
			List<Contract> list=query.getResultList();
			transaction.commit();
			return list;
		} catch (Exception e) {
			throw new ForestManagementSystem("EMPTY..................");
		}

	}
}

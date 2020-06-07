package com.cagemini.forestmanagement.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.cagemini.forestmanagement.bean.Account;
import com.cagemini.forestmanagement.bean.Product;
import com.cagemini.forestmanagement.exception.ForestManagementSystem;

public class ProductDAOImpl implements ProductDAO {

	private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Forest_Test");
	private EntityManager entiryManager = null;
	private EntityTransaction transaction = null;

	@Override
	public boolean getAuth(String username, String password) {
		entiryManager = entityManagerFactory.createEntityManager();
		transaction = entiryManager.getTransaction();
		try {
			boolean status = false;
			transaction.begin();
			Account object = entiryManager.find(Account.class, username);
			if (object.getPassword().equals(password)) {
				if (object.getRole().equals("product")) {
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
	public boolean addProduct(Product proObj) {
		entiryManager = entityManagerFactory.createEntityManager();
		transaction = entiryManager.getTransaction();
		try {
			boolean status = false;
			transaction.begin();
			entiryManager.persist(proObj);
			status = true;
			transaction.commit();
			return status;
		} catch (Exception e) {
			throw new ForestManagementSystem("PRODUCT DETAILS ARE ALREADY PRESENT");
		}
	}

	@Override
	public boolean deleteProduct(String product_id) {
		entiryManager = entityManagerFactory.createEntityManager();
		transaction = entiryManager.getTransaction();
		try {
			boolean status = false;
			transaction.begin();
			Product object=entiryManager.find(Product.class, product_id);
			if(object!=null)
			{
				entiryManager.remove(object);
				status = true;
			}
			transaction.commit();
			return status;
		} catch (Exception e) {
			throw new ForestManagementSystem("PRODUCT DETAILS ARE ALREADY DELETED");
		}
	}

	@Override
	public Product searchProduct(String product_id) {
		entiryManager = entityManagerFactory.createEntityManager();
		transaction = entiryManager.getTransaction();
		try {
			transaction.begin();
			Product object=entiryManager.find(Product.class, product_id);
			transaction.commit();
			return object;
		} catch (Exception e) {
			throw new ForestManagementSystem("PRODUCT DETAILS ARE NOT ALREADY PRESENT");
		}
	}

	@Override
	public List<Product> getAllProduct() {
		entiryManager=entityManagerFactory.createEntityManager();
		transaction=entiryManager.getTransaction();
		String jpql="from Product";
		Query query=entiryManager.createQuery(jpql);
		List<Product> list=query.getResultList();
		return list;
	}

	@Override
	public boolean modifyProductName(String product_id, String product_name) {
		entiryManager = entityManagerFactory.createEntityManager();
		transaction = entiryManager.getTransaction();
		try {
			boolean status=false;
			transaction.begin();
			Product object=entiryManager.find(Product.class, product_id);
			object.setProductName(product_name);
			status=true;
			transaction.commit();
			return status;
		} catch (Exception e) {
			throw new ForestManagementSystem("PRODUCT DETAILS ARE ALREADY UPDATED");
		}
	}

	@Override
	public boolean modifyProductDate(String product_id, String product_date) {
		entiryManager = entityManagerFactory.createEntityManager();
		transaction = entiryManager.getTransaction();
		try {
			boolean status=false;
			transaction.begin();
			Product object=entiryManager.find(Product.class, product_id);
			object.setProductDate(product_date);
			status=true;
			transaction.commit();
			return status;
		} catch (Exception e) {
			throw new ForestManagementSystem("PRODUCT DETAILS ARE ALREADY UPDATED");
		}

	}
}

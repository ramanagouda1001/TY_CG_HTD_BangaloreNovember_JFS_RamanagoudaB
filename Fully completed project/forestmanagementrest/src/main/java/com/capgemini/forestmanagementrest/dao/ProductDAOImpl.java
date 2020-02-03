package com.capgemini.forestmanagementrest.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.capgemini.forestmanagementrest.bean.Product;
import com.capgemini.forestmanagementrest.exception.ForestManagementSystem;

@Repository
public class ProductDAOImpl implements ProductDAO {

	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;

	@Override
	public boolean addProduct(Product proObj) {
		EntityManager entiryManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entiryManager.getTransaction();
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
		EntityManager entiryManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entiryManager.getTransaction();
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
		EntityManager entiryManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entiryManager.getTransaction();
		try {
			transaction.begin();
			Product object=entiryManager.find(Product.class, product_id);
			transaction.commit();
			return object;
		} catch (Exception e) {
			throw new ForestManagementSystem("PRODUCT DETAILS ARE ALREADY PRESENT");
		}
	}

	@Override
	public List<Product> getAllProduct() {
		EntityManager entiryManager=entityManagerFactory.createEntityManager();
		EntityTransaction transaction=entiryManager.getTransaction();
		String jpql="from Product";
		Query query=entiryManager.createQuery(jpql);
		List<Product> list=query.getResultList();
		return list;
	}

	@Override
	public boolean updateProduct(Product product) {
		EntityManager entiryManager=entityManagerFactory.createEntityManager();
		EntityTransaction transaction=entiryManager.getTransaction();
		try {
			transaction.begin();
			Product obj=entiryManager.find(Product.class, product.getProduct_id());
			if(product.getProduct_name()!=null)
			{
				obj.setProduct_name(product.getProduct_name());
			}
			else {
				obj.setProduct_name(obj.getProduct_name());
			}
			if(product.getProduct_date()!=null)
			{
				obj.setProduct_date(product.getProduct_date());
			}
			else {
				obj.setProduct_date(obj.getProduct_date());
			}
			if(product.getProduct_quality()!=0)
			{
				obj.setProduct_quality(product.getProduct_quality());
			}
			else {
				obj.setProduct_quality(obj.getProduct_quality());
			}
			transaction.commit();
			return true;
		} catch (Exception e) {
			throw new ForestManagementSystem("Cannot update");
		}
	}
}

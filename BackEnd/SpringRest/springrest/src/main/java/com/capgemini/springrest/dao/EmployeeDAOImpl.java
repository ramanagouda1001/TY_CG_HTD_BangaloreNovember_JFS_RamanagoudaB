package com.capgemini.springrest.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import com.capgemini.springrest.dto.EmployeeBean;
import com.capgemini.springrest.exception.EmployeeException;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	@PersistenceUnit
	private EntityManagerFactory factroy;

	@Override
	public EmployeeBean auth(String email, String password) {
		EntityManager manager = factroy.createEntityManager();
		String jpql = "from EmployeeBean where email=:email";
		TypedQuery<EmployeeBean> query = manager.createQuery(jpql, EmployeeBean.class);
		query.setParameter("email", email);
		// query.setParameter("password", password);
		try {
			EmployeeBean bean = query.getSingleResult();
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			if (encoder.matches(password, bean.getPassword())) {
				return bean;

			} else {
				throw new EmployeeException("password invalid");
			}
		} catch (Exception e) {
			throw new EmployeeException("Email Invalid");
		}
	}

	@Override
	public boolean register(EmployeeBean bean) {
		EntityManager entityManager = factroy.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		try {
			transaction.begin();
			entityManager.persist(bean);
			transaction.commit();
			return true;
		} catch (Exception e) {
			throw new EmployeeException("Email already exist");
		}

	}

	@Override
	public List<EmployeeBean> getAllEmployees(String key) {
		EntityManager manager = factroy.createEntityManager();
		String jpql = "from EmployeeBean where name=:name or email=:email";
		TypedQuery<EmployeeBean> query = manager.createQuery(jpql, EmployeeBean.class);
		query.setParameter("name", key);
		query.setParameter("email", key);
		return query.getResultList();
	}

	@Override
	public boolean changePassword(int id, String password) {
		EntityManager entityManager = factroy.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		String jpql = "update EmployeeBean set password=:password where id=:id";
		try {
			transaction.begin();
			Query query = entityManager.createQuery(jpql);
			query.setParameter("password", password);
			query.setParameter("id", id);
			int count = query.executeUpdate();
			transaction.commit();
			if (count > 0)
				return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	@Override
	public boolean deleteEmploye(int id) {
		EntityManager entityManager=factroy.createEntityManager();
		EntityTransaction transaction=entityManager.getTransaction();
		transaction.begin();
	
			EmployeeBean bean=entityManager.find(EmployeeBean.class, id);
			if(bean!=null)
			{
				entityManager.remove(bean);
				transaction.commit();
				return true;
			}
		throw new EmployeeException("not found"); 
	}

}